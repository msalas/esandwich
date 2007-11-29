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
	
	public void insertarFamiliaProducto(FamiliaProducto fp) throws errorSQL, errorConexionBD {
		
		PreparedStatement pstmt = null;
		
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			String s = "INSERT INTO familia (id, descripcion)"
				+ "VALUES (?,?)";	
						
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1,fp.getIdFamilia());
			pstmt.setString(2,fp.getDescripcion());
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
		
	public void eliminaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		FamiliaProducto f=null;
		String fp;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			fp= "DELETE FROM familia WHERE f.id = '"+ idFamilia+"'";
			
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
