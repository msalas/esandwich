
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class GestorEmpleado {

	GestorDisco gd;
	Connection con = null;
	
	public GestorEmpleado() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

	public void addEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		String codEmpleado = "";
		int id = 0;
		
		// Primero se ha de consultar para ver si existe.
		
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		// Para montar código de usuario...
		codEmpleado = pEmpleado.getRol().getLetraRol();
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
					
		try {
			gd.begin();
			
			// Pendiante de Marc
			strSQL = "SELECT nextval ('persona_id_seq')";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();
			
			if (id < 10) {
				codEmpleado = codEmpleado + "000" + id;	
			}
			if (id > 9 && id < 100) {
				codEmpleado = codEmpleado + "00" + id;	
			}
			if (id > 99 && id < 1000) {
				codEmpleado = codEmpleado + "0" + id;	
			}
			if (id > 999) {
				codEmpleado = codEmpleado  + id;	
			}
					
			
			// Pendiante de Marc
			strSQL = "INSERT INTO empleados ()";			
			pstmt = con.prepareStatement(strSQL);
			
			//Las pstmt.setString (por ejemplo) pendiente de Marc
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL (e.toString());
		}
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

}
