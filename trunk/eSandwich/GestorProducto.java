import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class GestorProducto {
	
	private GestorDisco gd;
	Connection con = null;
	
	public GestorProducto () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from producto");
			while(rs.next()){
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				v.add(p);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public Vector<Producto> listaProductoPorFamilia(long idFamilia) throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String s = "SELECT p.id, p.descripcion,p.descripcionampliada, p.existencias from producto p, familia f where p.id=f.id and f.id='"+idFamilia+"'";
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				v.add(p);
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}
	
	public void insertarProducto(long idProducto, String descripcion, String descripcionAmpliada, int existencias) throws errorSQL, errorConexionBD {
	
		String p;
		PreparedStatement pstmt = null;
		
		int id = 0;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			p=	"INSERT INTO producto (id, descripcion, descripcionampliada, existencias)" + "VALUES (?,?,?,?) RETURNING id" ;			
			pstmt = con.prepareStatement(p);
			pstmt.setLong(1,id);
			pstmt.setString(2,descripcion);
			pstmt.setString(3,descripcionAmpliada);
			pstmt.setInt(4, existencias);
			gd.commit();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) id = rs.getInt(1);
			rs.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public void eliminaProducto(long idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Producto p=null;
		String pr;
		PreparedStatement pstmt = null;
		Statement stmt = null;		
		try {
			gd.begin();
			
			pr= "DELETE FROM producto(id, descripcion, descripcionampliada, existencias) WHERE p.id = '"+ idProducto+"'";
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public Producto consultaProducto(long idProducto) throws errorSQL, errorConexionBD {
		
		
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String consulta="SELECT from producto(id, descripcion, descripcionampliada, existencias) WHERE p.id=" + idProducto+ "'";
			ResultSet rs = stmt.executeQuery(consulta);
			if(rs.next()) id= rs.getInt(1); 
			rs.close();
			stmt.close();
			p = new Producto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return p;
	}
	

	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}

	
	
}
