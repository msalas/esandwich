import java.rmi.RemoteException;


public interface ServiciosRemotosAdminAux extends ServiciosRemotos {

	public int anadirEmpleado (Empleado e) throws errorSQL, 
	errorConexionBD,RemoteException;

	
	
	
}
