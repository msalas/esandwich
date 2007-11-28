import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServiciosEmpleadoModelo extends ServiciosAccesoModelo {

	ServiciosRemotosAdminAux src;
	
	public ServiciosEmpleadoModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		 src = (ServiciosRemotosAdminAux)Naming.lookup("rmi://localhost:1099/ServiciosEmpleado");
			
	}

}
