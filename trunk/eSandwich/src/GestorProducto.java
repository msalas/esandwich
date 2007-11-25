import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
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
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getInt(6));
				v.add(p);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public Vector<Producto> listaProductoPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String s = "SELECT p.id, p.descripcion,p.descripcion_ampliada, p.existencias, p.id_familia, p.precio from producto p, familia f where p.id=f.id and f.id='"+idFamilia+"'";
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getInt(6));
				v.add(p);
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}
	
	public void insertarProducto(Producto p) throws  errorSQL, errorConexionBD {
	
		
		PreparedStatement pstmt = null;
		
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			String s = "INSERT INTO producto (id, descripcion, descripcion_ampliada, existencias, id_familia, precio )"
				+ "VALUES (?,?,?,?,?,?)";	
			
			
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1,p.getIdProducto());
			pstmt.setString(2,p.getDescripcion());
			pstmt.setString(3,p.getDescripcionAmpliada());
			pstmt.setInt(4, p.getExistencias());
			pstmt.setInt(5,p.getIdFamilia());
			pstmt.setInt(6,p.getPrecio());
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public void eliminaProducto(int idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		String pr;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			pr= "DELETE FROM producto WHERE p.id = '"+ idProducto+"'";
			pstmt.execute(pr);
			gd.commit();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public Producto consultaProducto(int idProducto) throws errorSQL, errorConexionBD {
		
		
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String consulta="SELECT from producto(id, descripcion, descripcion_ampliada, existencias, id_familia, precio ) WHERE p.id=" + idProducto+ "'";
			ResultSet rs = stmt.executeQuery(consulta);
			if(rs.next()) id= rs.getInt(1); 
			rs.close();
			stmt.close();
			p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return p;
	}
	

	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}

	public static void main(String[] arg) throws errorSQL,errorConexionBD{
		
		FamiliaProducto fp = new FamiliaProducto(0, "embutido");
		
		GestorFamiliaProd gpf= new GestorFamiliaProd();
		gpf.insertarFamiliaProducto(fp);
		
		Producto p=new Producto(0,"bocata", "de chorizo", 5, 0, 4);
		
		GestorProducto gp=new GestorProducto();
		gp.insertarProducto(p);
		
		Vector v=gp.listaProductos();
		Iterator it=v.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
	}
}
