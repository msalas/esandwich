
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ServidorModelo{
	
	private ServicioRemotoEjemplo sre;
	private ServicioRemotoComprador scomp;
	private ServicioRemotoCocina scoc;
	private ServicioRemotoAdminAux  sadaux;
	
	public ServidorModelo() throws errorConexionBD, RemoteException{

		sre = new ServicioEjemploImpl();
		scomp = new ServicioCompradorImpl();
		scoc = new ServicioCocinaImpl();
		sadaux = new ServicioAdminAuxImpl();
		
		 
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
