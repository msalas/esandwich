
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

			strSQL = "select currval('persona_id_seq')";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (persona) numero: " + e.getErrorCode());
		}
		try {
			strSQL = "INSERT INTO usuario (cod_usuario,pasword,desactivado) "
				+ "VALUES (?,?,?)";

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,pEmpleado.getPassword());
			pstmt.setBoolean(3, false);
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (usuario) numero: " + e.getErrorCode());
		}
		try {
			strSQL = "INSERT INTO empleado (cod_empleado,id_rol) "
				+ "VALUES (?,?)";

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,id);
			pstmt.setInt(2,pEmpleado.getRol().getId());
						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (empleado) numero: " + e.getErrorCode());
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

			strSQL = "UPDATE persona SET fechabaja=? WHERE id = " + pEmpleado.getId();
			
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
				pstmt.setDate(10,new java.sql.Date(pEmpleado.getFechaBaja().getTime()));
			} 		
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;

		} catch (SQLException e) {
			switch (e.getErrorCode()){
			case 0: 
				throw new GestorEmpleadoException("Este usuario ya existe");
			default: 
				{
					gd.rollback();
					throw new errorSQL("Error SQL (persona) numero: " + e.getErrorCode());
				}
			}
		}
		
		try {
			
			strSQL = "UPDATE usuario SET password=?,desactivado=? "
				+ "WHERE codusuario = " + pEmpleado.getId();

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
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (usuario) numero: " + e.getErrorCode());
		}
		
		try {
			strSQL = "UPDATE empleado SET idrol=? "
				+ "WHERE codempleado = " + pEmpleado.getId();

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,pEmpleado.getRol().getId());
						
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (empleado) numero: " + e.getErrorCode());
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
			
			strSQL = "SELECT codempleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,codUsuario,password,"
				+ "desactivado,idrol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.codempleado = usuario.codusuario AND "
				+ "empleado.codempleado = persona.id "
				+ "AND codempleado = " + pId;
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
			strConsulta = "AND idrol = " + pIdRol + " ";
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

		strSQL = "SELECT codempleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,codUsuario,password,"
				+ "desactivado,idrol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.codempleado = usuario.codusuario AND "
				+ "empleado.codempleado = persona.id AND "
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
	

	
	private Empleado montaEmpleado(ResultSet rs) throws errorSQL, errorConexionBD {
		Empleado Emp = null;
		GestorRol gRol = null;
		Emp = new Empleado();
		gRol = new GestorRol();
		try {
			Emp.setId(rs.getInt("codempleado"));
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
			Emp.setRol(gRol.consultaRol(rs.getInt("idrol")));
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return Emp;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

	public static void main (String[] args) {
		Empleado pEmpleado = new Empleado();		
		Rol pRol = new Rol();
		
		try {
			GestorRol gRol = new GestorRol();
			try {
				pRol = gRol.consultaRol(1);
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		//pEmpleado.setId(32);
		pEmpleado.setNif("0000081N");
		pEmpleado.setNombre("Diego");
		pEmpleado.setApellido1("Java");
		pEmpleado.setApellido2("Dificil");
		pEmpleado.setDireccion("direccion 2");
		pEmpleado.setPoblacion("poblacion 2");
		pEmpleado.setTelefono("telefono 2");
		pEmpleado.setMovil("movil 2");
		pEmpleado.setEmail("email 2");
		pEmpleado.setCodUsuario("codUsuario32");
		pEmpleado.setPassword("123410");
		pEmpleado.setDesactivado(false);
		pEmpleado.setRol(pRol);

		try {
			GestorEmpleado gEmpl = new GestorEmpleado();
			try {
				gEmpl.addEmpleado(pEmpleado);
				//pEmpleado = gEmpl.consultaEmpleado(pEmpleado.getId());
				//gEmpl.setEmpleado(pEmpleado);
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
			gEmpl.liberarRecursos();
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		
	} 

}
