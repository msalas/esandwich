import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GestorRol {

	GestorDisco gd;
	Connection con = null;
	
	public GestorRol() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

	public void addRol(Rol pRol) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";

		// Falta verificar campos: verifCampos(pRol);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO rol (descripcion,letrarol) "
				+ "VALUES (?,?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pRol.getDescripcion());
			pstmt.setString(2, pRol.getLetraRol());
	
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			switch (e.getErrorCode()){
			case 0:
				throw new GestorRolException("Este rol ya existe");
			default: 
				{
					gd.rollback();
					throw new errorSQL("Error SQL numero: " + e.getErrorCode());
				}
			}
		}
	}
	
	public Rol consultaRol(int pId) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		Rol pRol = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT id, descripcion, letraRol "
				+ "FROM rol "
				+ "WHERE id = " + pId;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				pRol = montaRol(rs);
			}
			else {
				throw new GestorRolException("No existe rol");
			}
			rs.close();
			stmt.close();
			
			return pRol;
		} 
		catch (SQLException e) {
			throw new GestorRolException("Error SQL numero: " + e.getErrorCode());			
		}
	}
	
	private Rol montaRol(ResultSet rs) throws errorSQL {
		Rol pRol = null;
		pRol = new Rol();
		try {
			pRol.setId(rs.getInt("id"));
			pRol.setDescripcion(rs.getString("descripcion"));
			pRol.setLetraRol(rs.getString("letraRol"));
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return pRol;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}
/*	public static void main (String[] args) {
		Rol pRol = new Rol();
		
		pRol.setDescripcion("Admin");
		pRol.setLetraRol("A");
		
		try {
			GestorRol gRol = new GestorRol();
			try {
				//gRol.addRol(pRol);
				pRol = gRol.consultaRol(1);
				System.out.println(pRol.getId());
				System.out.println(pRol.getDescripcion());
				System.out.println(pRol.getLetraRol());
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
			gRol.liberarRecursos();
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		
	}
*/
}
