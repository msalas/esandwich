import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServiciosCocinaModelo extends ServiciosAccesoModelo {

	ServiciosRemotosCocina src;
	
	public ServiciosCocinaModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		src = (ServiciosRemotosCocina)Naming.lookup("rmi://localhost:1099/ServiciosCocina");
	}

}
