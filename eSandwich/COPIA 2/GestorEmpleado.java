
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

	// Hay que devolver un String (el codigo creado)
	
	public void addEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		String codEmpleado = "";
		int id = 0;
		
		
		// Falta verificar campos: verifCampos(pEmpleado);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexi�n!");
		
		// Para montar c�digo de usuario...
		// MARC: Aun no lo necesitas
		codEmpleado = pEmpleado.getRol().getLetraRol();
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
					
		try {
			gd.begin();
	//MARC: Este codigo no hace falta, ya que el insert crea el id automaticamente
/*			
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
			}*/

			// Anyadir a la sentencia RETURNING id
			strSQL = "INSERT INTO persona (nif,nombre,apellido1,"
				+ "apellido2,direccion,poblacion,telefono," 
				+ "movil,email) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";			
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pEmpleado.getNif().toString());
			pstmt.setString(2,pEmpleado.getNombre());
			pstmt.setString(3,pEmpleado.getApellido1());
			pstmt.setString(4,pEmpleado.getApellido2());
			pstmt.setString(5,pEmpleado.getDireccion());
			pstmt.setString(6,pEmpleado.getPoblacion());
			pstmt.setString(7,pEmpleado.getTelefono());
			pstmt.setString(8,pEmpleado.getMovil());
			pstmt.setString(9,pEmpleado.getEmail());
			
			gd.commit();
	
			// MARC: 
//			pstmt.execute();
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) id = rs.getInt(1);
			rs.close();			
			
			// FI MODIFICACIO MARC
			
			pstmt.close();
			pstmt = null;
			
			strSQL = "INSERT INTO usuario (cod-usuario,password,desactivado) "
				+ "VALUES (?,?,?)";

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,pEmpleado.getPassword());
			pstmt.setBoolean(3, false);
						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			strSQL = "INSERT INTO empleado (cod-empleado,id-rol) "
				+ "VALUES (?,?)";

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,id);
			pstmt.setInt(2,pEmpleado.getRol().getId());
						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;

			
		} catch (SQLException e) {
			switch (e.getErrorCode()){
			case -268: //Tengo que validar este c�digo (este es de INFORMIX)
				throw new GestorEmpleadoException("Este usuario ya existe");
			default: 
				{
					gd.rollback();
					throw new errorSQL("Error SQL numero: " + e.getErrorCode());
				}
			}
		}
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

}
