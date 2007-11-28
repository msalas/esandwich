import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServiciosAdminAuxImpl extends UnicastRemoteObject 
implements ServiciosRemotosAdminAux {
	private static final long serialVersionUID = 1L;

	GestorEmpleado ge;
	
	public ServiciosAdminAuxImpl() throws errorConexionBD,
	RemoteException {
		try {
			ge = new GestorEmpleado();
		}
		catch (errorConexionBD e) {
			throw new errorConexionBD(e.getMessage());
		}
		
	}
	
	public int anadirEmpleado (Empleado e) throws errorSQL, errorConexionBD,
	RemoteException {
		int idAux = 0;
		try {
			if (!ge.existeNif(e.getNif())) {
				idAux = ge.addEmpleado(e);
			}
			else {
				throw new errorSQL("ERROR: Nif existente en empleados");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idAux;
	}
	
	public void desactivarRecursos() {
		ge.liberarRecursos();
	}
	
}
