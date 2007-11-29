import java.rmi.RemoteException;


public interface ServiciosRemotosAdminAux extends ServiciosRemotos {
	public Empleado anadirEmpleado (Empleado e) throws errorSQL, 
	errorConexionBD,RemoteException;
}
