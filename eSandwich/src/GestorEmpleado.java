
import java.sql.Connection;
import java.sql.Date;
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
		int id = 0;
		
		
		// Falta verificar campos: verifCampos(pEmpleado);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO persona (nif,nombre,apellido1,"
				+ "apellido2,direccion,poblacion,telefono," 
				+ "movil,email) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pEmpleado.getNif());
			pstmt.setString(2,pEmpleado.getNombre());
			pstmt.setString(3,pEmpleado.getApellido1());
			pstmt.setString(4,pEmpleado.getApellido2());
			pstmt.setString(5,pEmpleado.getDireccion());
			pstmt.setString(6,pEmpleado.getPoblacion());
			pstmt.setString(7,pEmpleado.getTelefono());
			pstmt.setString(8,pEmpleado.getMovil());
			pstmt.setString(9,pEmpleado.getEmail());			
	
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			strSQL = "select currval('persona_id_seq')";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();
			
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
			case -268: //Tengo que validar este código (este es de INFORMIX)
				throw new GestorEmpleadoException("Este usuario ya existe");
			default: 
				{
					gd.rollback();
					throw new errorSQL("Error SQL numero: " + e.getErrorCode());
				}
			}
		}
	}
	
	//Tanto para dar de baja como para modificar usuario
	public void setEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		
		// Falta verificar campos: verifCampos(pEmpleado);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "UPDATE persona SET nif=?,nombre=?,apellido1=?,"
				+ "apellido2=?,direccion=?,poblacion=?,telefono=?," 
				+ "movil=?,email=?,fechabaja=? "
				+ "WHERE id = " + pEmpleado.getId();			

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pEmpleado.getNif());
			pstmt.setString(2,pEmpleado.getNombre());
			pstmt.setString(3,pEmpleado.getApellido1());
			pstmt.setString(4,pEmpleado.getApellido2());
			pstmt.setString(5,pEmpleado.getDireccion());
			pstmt.setString(6,pEmpleado.getPoblacion());
			pstmt.setString(7,pEmpleado.getTelefono());
			pstmt.setString(8,pEmpleado.getMovil());
			pstmt.setString(9,pEmpleado.getEmail());
			if (pEmpleado.getFechaBaja() != null) {
				pstmt.setDate(10,(Date) pEmpleado.getFechaBaja());
			}
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			strSQL = "UPDATE usuario SET password=?,desactivado=? "
				+ "WHERE cod-usuario = " + pEmpleado.getId();

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pEmpleado.getPassword());
			if (pEmpleado.getFechaBaja() != null) {
				pstmt.setBoolean(2, true);
			}
			else {
				pstmt.setBoolean(2, false);
			}						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			strSQL = "UPDATE empleado SET id-rol=? "
				+ "WHERE cod-empleado = " + pEmpleado.getId();

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,pEmpleado.getRol().getId());
						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			switch (e.getErrorCode()){
			case -268: //Tengo que validar este código (este es de INFORMIX)
				throw new GestorEmpleadoException("Este usuario ya existe");
			default: 
				{
					gd.rollback();
					throw new errorSQL("Error SQL numero: " + e.getErrorCode());
				}
			}
		}
	}

	public Empleado consultaEmpleado(int pId) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		Empleado Emp = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT cod-empleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,codUsuario,password,"
				+ "desactivado,id-rol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.cod-empleado = usuario.cod-usuario AND "
				+ "empleado.cod-empleado = persona.id "
				+ "WHERE cod-empleado=" + pId;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				Emp = montaEmpleado(rs);
			}
			else {
				throw new GestorEmpleadoException("No existe empleado");
			}
			rs.close();
			stmt.close();
			
			return Emp;
		} 
		catch (SQLException e) {
			throw new GestorEmpleadoException("Error SQL numero: " + e.getErrorCode());			
		}
	}
	
	
	
	//Excluimos a los que estan dados de baja
	public Vector lista(int pIdRol, String pNif, String pNombre, String pApellido1) throws errorSQL, errorConexionBD {
		Vector v = new Vector();
		String strSQL = "";
		String strConsulta  = "";
		if (pIdRol > 0) {
			strConsulta = "AND id-rol = " + pIdRol + " ";
		}
		if (pNif != null) {
			strConsulta = "AND nif like '" + pNif + "' ";
		}
		if (pNombre != null) {
			strConsulta = "AND nombre like '" + pNombre + "' ";
		}
		if (pApellido1 != null) {
			strConsulta = "AND apellido1 like '" + pApellido1 + "' ";
		}

		strSQL = "SELECT cod-empleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,codUsuario,password,"
				+ "desactivado,id-rol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.cod-empleado = usuario.cod-usuario AND "
				+ "empleado.cod-empleado = persona.id AND "
				+ "desactivado = 0 "
				+ strConsulta
				+ "ORDER BY nif";
		
		Empleado emplAux = null;
			
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(strSQL);
			
			while(rs.next()){
				emplAux = montaEmpleado(rs);
				v.add(emplAux);
			}				
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	

	
	private Empleado montaEmpleado(ResultSet rs) throws errorSQL {
		Empleado Emp = null;
		Emp = new Empleado();
		try {
			Emp.setId(rs.getInt("cod-empleado"));
			Emp.setNif(rs.getString("nif"));
			Emp.setNombre(rs.getString("nombre"));
			Emp.setApellido1(rs.getString("apellido1"));
			Emp.setApellido2(rs.getString("apellido2"));
			Emp.setDireccion(rs.getString("direccion"));
			Emp.setPoblacion(rs.getString("poblacion"));
			Emp.setTelefono(rs.getString("telefono"));
			Emp.setMovil(rs.getString("movil"));
			Emp.setEmail(rs.getString("email"));
			Emp.setCodUsuario(rs.getString("codUsuario"));
			Emp.setPassword(rs.getString("password"));
			Emp.setDesactivado(rs.getBoolean("desactivado"));
			// Falta GestorRol consulta de rol por id (id-rol) y que nos de objeto Rol
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return Emp;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

}
