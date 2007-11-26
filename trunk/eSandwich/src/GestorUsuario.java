import java.sql.Connection;


public class GestorUsuario {

	GestorEmpleado gEmp;
	GestorCliente gCli;

	public GestorUsuario() throws errorConexionBD {
		super();
	
		// Si no usas el GestorDisco esto no hace falta 
		//	gd = new GestorDisco();
		//	gd.abrirConexion();
		
		// Pero hay que inicializar los gestores que usas aqui
		// Asi mantienes la conexion
		gEmp = new GestorEmpleado();
		gCli = new GestorCliente();
	}

	// Se tiene que cambiar, tiene que devolver el tipo de Usuario que ha accedido
	
	public Usuario login(String codUsuario, String password, boolean isCliente) throws errorConexionBD, errorSQL{
		Usuario rUsu = null;
					
		int pId =0;
		
		pId = Util.getNumDeCodigo(codUsuario);
		
		if (isCliente) rUsu = gCli.getCliente(pId);
		else rUsu = gEmp.consultaEmpleado(pId); 
			
			if (!rUsu.getPassword().equals(password)) {
				throw new GestorUsuarioException();
			}
			if (!rUsu.getPassword().equals(password)) {
				throw new GestorUsuarioException();
			}
			if (rUsu.getFechaBaja() != null) {
				throw new GestorUsuarioException("Usuario dado de baja");
			}
			if (rUsu.isDesactivado()) {
				throw new GestorUsuarioException("Usuario desactivado");
			}
		
		return rUsu;
	}
	
	
	public void liberarRecursos(){	
	
		// Liberar recursos de los gestores Cliente y Empleado
		
		gEmp.liberarRecursos();
		gCli.liberarRecursos();
	}

	public static void main (String[] args) {
		try {
			GestorUsuario gUsu = new GestorUsuario();
			try {
				gUsu.login("C0001", "prueba", false);				
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
			gUsu.liberarRecursos();
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
