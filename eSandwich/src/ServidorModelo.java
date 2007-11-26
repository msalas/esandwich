
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServidorModelo{
	
	private ServiciosRemotosEjemplo sre;
	private ServiciosRemotosComprador scomp;
	private ServiciosRemotosCocina scoc;
	private ServiciosRemotosAdminAux  sadaux;
	
	public ServidorModelo() throws errorConexionBD, RemoteException{

		sre = new ServiciosEjemploImpl();
		scomp = new ServiciosCompradorImpl();
		scoc = new ServiciosCocinaImpl();
		sadaux = new ServiciosAdminAuxImpl();
		
		 
	}
	
	public void encenderServidor() throws RemoteException, MalformedURLException{

	
			// Publicamos todos los servicios en el servicio de nombres
		    Naming.rebind("rmi://localhost/ServiciosEjemplo", sre);
			Naming.rebind("rmi://localhost/ServiciosComprador", scomp);
		    Naming.rebind("rmi://localhost/ServiciosCocina", scoc);
		    Naming.rebind("rmi://localhost/ServiciosAdAux", sadaux);
			
	    
	}

	public void apagarServidor() throws RemoteException, MalformedURLException, NotBoundException{

		// Quitamos todos los servicios disponibles del servicio de nombres
		Naming.unbind("rmi://localhost/ServiciosEjemplo");
		Naming.unbind("rmi://localhost/ServiciosComprador");
		Naming.unbind("rmi://localhost/ServiciosCocina");
		Naming.unbind("rmi://localhost/ServiciosAdAux");
		
		// Desactivamos los recursos que ha adquirido objeto remoto
		sre.desactivarRecursos();
		scomp.desactivarRecursos();
		scoc.desactivarRecursos();
		sadaux.desactivarRecursos();
		
		
	}

}
