import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GestorFamiliaProd {

	private GestorDisco gd;
	Connection con = null;
	
	public GestorFamiliaProd () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Vector<FamiliaProducto> listaProductoPorFamilia() throws errorSQL, errorConexionBD{

		Vector<FamiliaProducto> v = new Vector<FamiliaProducto>();
		FamiliaProducto fp = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from FamiliaProductos");
			while(rs.next()){
				fp = new FamiliaProducto(rs.getInt(1), rs.getString(2));
				v.add(fp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public void insertarFamiliaProducto(int idFamilia, String descripcion) throws errorSQL, errorConexionBD {
		
		String fp;
		PreparedStatement pstmt = null;
		
		int id = 0;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			fp=	"INSERT INTO familia (id, descripcion)" + "VALUES (?,?) RETURNING id" ;			
			pstmt = con.prepareStatement(fp);
			pstmt.setInt(1,id);
			pstmt.setString(2,descripcion);
			gd.commit();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) id = rs.getInt(1);
			rs.close();
		} 
		catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
		
	public void eliminaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		String fp;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			fp= "DELETE FROM familia WHERE fp.id = '"+ idFamilia+"'";
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public FamiliaProducto consultaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {
				
		FamiliaProducto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String consulta="SELECT from producto(id, descripcion) WHERE p.id=" + idFamilia+ "'";
			ResultSet rs = stmt.executeQuery(consulta);
			if(rs.next()) id= rs.getInt(1); 
			rs.close();
			stmt.close();
			p = new FamiliaProducto(rs.getInt(1), rs.getString(2));
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return p;
	}
	

	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}

	
	
}
