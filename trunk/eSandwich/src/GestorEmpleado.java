
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

	public int addEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		int id = 0;
		
		
		verifCampos(pEmpleado);
				
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
						
			
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			gd.commit();
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (empleado) numero: " + e.getErrorCode());
		}
		return id;
	}
	
	//Tanto para dar de baja como para modificar usuario
	public void setEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";

		verifCampos(pEmpleado);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
							
		try {			
			gd.begin();
			strSQL = "UPDATE persona SET nif=?,nombre=?,apellido1=?,"
				+ "apellido2=?,direccion=?,poblacion=?,telefono=?," 
				+ "movil=?,email=?,fecha_baja=? "
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
				pstmt.setDate(10,new java.sql.Date(pEmpleado.getFechaBaja().getTime()));
			} else {
				pstmt.setDate(10,null);
			}
			
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (persona) numero: " + e.getErrorCode());
		}
		
		try {
			strSQL = "UPDATE usuario SET pasword=?,desactivado=? "
				+ "WHERE cod_usuario = " + pEmpleado.getId();

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pEmpleado.getPassword());
			if (pEmpleado.getFechaBaja() != null) {
				pstmt.setBoolean(2, true);
			}
			else {
				pstmt.setBoolean(2, false);
			}						
			
			pstmt.execute();
			pstmt.close();
			pstmt = null;
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL (usuario) numero: " + e.getErrorCode());
		}
		
		try {
			strSQL = "UPDATE empleado SET id_rol=? "
				+ "WHERE cod_empleado = " + pEmpleado.getId();

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1,pEmpleado.getRol().getId());
						
			
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			gd.commit();
			
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
			
			strSQL = "SELECT cod_empleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,cod_Usuario,pasword,"
				+ "desactivado,id_rol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.cod_empleado = usuario.cod_usuario AND "
				+ "empleado.cod_empleado = persona.id "
				+ "AND cod_empleado = " + pId;
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
			gd.commit();
			return Emp;
		} 
		catch (SQLException e) {
			throw new GestorEmpleadoException("Error SQL numero: " + e.getErrorCode());			
		}
	}
	
	public boolean existeNif(String pNif) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		boolean existeAux;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT nif "
				+ "FROM persona "
				+ "WHERE nif ='" + pNif + "' ";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				existeAux = true;
			}
			else {
				existeAux = false;
			}
			rs.close();
			stmt.close();
			gd.commit();
			return existeAux;
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
			strConsulta = "AND id_rol = " + pIdRol + " ";
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

		strSQL = "SELECT cod_empleado,nif,nombre,apellido1,apellido2,"
				+ "direccion,poblacion,telefono,movil,email,cod_Usuario,pasword,"
				+ "desactivado,id_rol "
				+ "FROM persona,usuario,empleado "
				+ "WHERE empleado.cod_empleado = usuario.cod_usuario AND "
				+ "empleado.cod_empleado = persona.id AND "
				+ "desactivado = false "
				+ strConsulta
				+ "ORDER BY nif";
		
		Empleado emplAux = null;
			
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			gd.begin();
			stmt = con.createStatement();
			rs = stmt.executeQuery(strSQL);
			
			while(rs.next()){
				emplAux = montaEmpleado(rs);
				v.add(emplAux);
			}				
			rs.close();
			stmt.close();
			gd.commit();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	private void verifCampos(Empleado pEmpl) throws GestorEmpleadoException {
		if (!Util.compruebaCampoNif(pEmpl.getNif().toCharArray())) 
			throw new GestorEmpleadoException("Error en NIF");

		if (!Util.compruebaCampoTamano(pEmpl.getNombre().toCharArray(), 50)) 
			throw new GestorEmpleadoException("Error tamaño campo nombre");

		if (!Util.compruebaCampoTamano(pEmpl.getApellido1().toCharArray(), 100)) 
			throw new GestorEmpleadoException("Error tamaño campo primer apellido");
			
		if (!Util.compruebaCampoTamano(pEmpl.getApellido2().toCharArray(), 100)) 
			throw new GestorEmpleadoException("Error tamaño campo segundo apellido");

		if (!Util.compruebaCampoTamano(pEmpl.getDireccion().toCharArray(), 100)) 
			throw new GestorEmpleadoException("Error tamaño campo dirección");
			
		if (!Util.compruebaCampoTamano(pEmpl.getPoblacion().toCharArray(), 100)) 
			throw new GestorEmpleadoException("Error tamaño campo población");

		if (!Util.compruebaCampoTamano(pEmpl.getTelefono().toCharArray(), 16)) 
			throw new GestorEmpleadoException("Error tamaño campo teléfono");
			
		if (!Util.compruebaCampoTamano(pEmpl.getMovil().toCharArray(), 16)) 
			throw new GestorEmpleadoException("Error tamaño campo móvil");

		if (!Util.compruebaCampoTamano(pEmpl.getEmail().toCharArray(), 100)) 
			throw new GestorEmpleadoException("Error tamaño campo e-mail");
			
			
		if (!Util.compruebaCampo(pEmpl.getPassword().toCharArray())) 
			throw new GestorEmpleadoException("Error en password");
		if (!Util.compruebaCampoTamano(pEmpl.getPassword().toCharArray(), 10)) 
			throw new GestorEmpleadoException("Error tamaño campo password");

	}

	
	private Empleado montaEmpleado(ResultSet rs) throws errorSQL, errorConexionBD {
		Empleado Emp = new Empleado();
		GestorRol gRol = null;
		Rol pRol = null; 
		String codAuxEmpleado = "";
		try {
			gRol = new GestorRol();
			try {
				Emp.setId(rs.getInt("cod_empleado"));
				Emp.setNif(rs.getString("nif"));
				Emp.setNombre(rs.getString("nombre"));
				Emp.setApellido1(rs.getString("apellido1"));
				Emp.setApellido2(rs.getString("apellido2"));
				Emp.setDireccion(rs.getString("direccion"));
				Emp.setPoblacion(rs.getString("poblacion"));
				Emp.setTelefono(rs.getString("telefono"));
				Emp.setMovil(rs.getString("movil"));
				Emp.setEmail(rs.getString("email"));		
				Emp.setPassword(rs.getString("pasword"));
				Emp.setDesactivado(rs.getBoolean("desactivado"));
				pRol = gRol.consultaRol(rs.getInt("id_rol"));
				Emp.setRol(pRol);
				codAuxEmpleado = Util.generarCodigo(Emp.getId(), pRol.getLetraRol());
				Emp.setCodUsuario(codAuxEmpleado);
				gRol.liberarRecursos();
			}
			catch (SQLException e) {
				throw new errorSQL(e.toString());
			}
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}

		return Emp;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

/*	public static void main (String[] args) {
		Empleado pEmpleado = new Empleado();		
		Rol pRol = new Rol();
		GestorEmpleado gEmpl = null;
		int idAux = 0;
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
		pEmpleado.setNif("0000086N");
		pEmpleado.setNombre("Eruka");
		pEmpleado.setApellido1("Java");
		pEmpleado.setApellido2("Dificil");
		pEmpleado.setDireccion("direccion 2");
		pEmpleado.setPoblacion("poblacion 2");
		pEmpleado.setTelefono("telefono 2");
		pEmpleado.setMovil("movil 2");
		pEmpleado.setEmail("email 2");
		pEmpleado.setPassword("123410");
		pEmpleado.setDesactivado(false);
		pEmpleado.setRol(pRol);
		
		try {
			gEmpl = new GestorEmpleado();
			try {
				if (!gEmpl.existeNif(pEmpleado.getNif())) {
					idAux = gEmpl.addEmpleado(pEmpleado);
				}
				else {
					System.out.println("ERROR: Nif existente en empleados");
				}
				pEmpleado.setId(2);
				pEmpleado = gEmpl.consultaEmpleado(pEmpleado.getId());
				System.out.println(pEmpleado.getCodUsuario());
				
				pEmpleado.setFechaBaja(new java.util.Date());
				gEmpl.setEmpleado(pEmpleado);
				
				

				Vector v = gEmpl.lista(1, null, null, null);
				int x;
				for (x=0;x<v.size();x++)
					System.out.println((v.elementAt(x)).toString());
				
				gEmpl.liberarRecursos();
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		
	} */  

}
