import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServiciosAdAuxModelo extends ServiciosAccesoModelo {

	ServiciosRemotosAdminAux sraa;
	
	public ServiciosAdAuxModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		sraa = (ServiciosRemotosAdminAux)Naming.lookup("rmi://localhost:1099/ServiciosAdAux");
	}

	public ServiciosAdAuxModelo nuevoEmpleado(Empleado emp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		
		Empleado empAux = null;
		
		empAux = sraa.anadirEmpleado(emp);
		
		
		return this;
		
	}
	
	
}
