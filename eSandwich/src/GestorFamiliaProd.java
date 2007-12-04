import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Iterator;
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
			rs = stmt.executeQuery("SELECT * from familia");
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
	
	public int insertarFamiliaProducto(FamiliaProducto fp) throws errorSQL, errorConexionBD {
		
		int id=0;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
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
			
			String str = "select currval('id')";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();
		} 
		catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
		return id;
	}
		
	public void eliminaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		String fp;
		PreparedStatement pstmt;
		
		try {
			gd.begin();
			
			fp= "DELETE FROM familia WHERE familia.id = '"+ idFamilia+"'";
			pstmt = con.prepareStatement(fp);
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public FamiliaProducto consultaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {		
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		FamiliaProducto fp = new FamiliaProducto();
		Statement st = null;
		ResultSet rs=null;
		String consulta="SELECT id, descripcion FROM familia WHERE familia.id=" + idFamilia;
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while (rs.next()){
				fp.setIdFamilia(rs.getInt("id"));
				fp.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			return fp;
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}	
	}
	
	public boolean existeFamilia(int id) throws errorSQL, errorConexionBD{
		String strSQL = "";
		boolean existeFamilia;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT id "
				+ "FROM familia "
				+ "WHERE id ='" + id + "' ";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				existeFamilia = true;
			}
			else {
				existeFamilia = false;
			}
			rs.close();
			stmt.close();
			gd.commit();
			return existeFamilia;
		} 
		catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
	}
	

	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}

	public static void main(String[] arg) throws errorSQL,errorConexionBD{
		
		FamiliaProducto fp1 = new FamiliaProducto(2, "bebidas");
		FamiliaProducto fp2 = new FamiliaProducto(3, "postres");
		FamiliaProducto fp3 = new FamiliaProducto(4, "bolleria");
		
		GestorFamiliaProd gpf= new GestorFamiliaProd();
		
		gpf.insertarFamiliaProducto(fp1);
		gpf.insertarFamiliaProducto(fp2);
		gpf.insertarFamiliaProducto(fp3);
		
		for (Enumeration<FamiliaProducto> fp = (gpf.listaProductoPorFamilia()).elements() ; fp.hasMoreElements() ;) {
			FamiliaProducto pd = fp.nextElement();
			System.out.println(pd.toString());
			}

		FamiliaProducto fp=gpf.consultaFamiliaProducto(0);
		System.out.println(fp.toString());
			
		gpf.eliminaFamiliaProducto(4);
				
		}
	
}
