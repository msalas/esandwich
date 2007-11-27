
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class ServiciosEjemploModelo{

ServiciosRemotosEjemplo sre;
	
	public ServiciosEjemploModelo() throws MalformedURLException, RemoteException, NotBoundException{
	     
		   // System.setSecurityManager(new RMISecurityManager());
		   // Es busca el servei ServicioX -- forward
		   // Localitzem i instanciem objecte de la classe remota RemoteImpl
		   // I obtenim el RemoteImplStub   
		   sre = (ServiciosRemotosEjemplo)Naming.lookup("rmi://localhost:1099/ServiciosEjemplo");
		 
		
	}
	

	public Vector<Ejemplo> listaEjemplos() throws errorSQL, errorConexionBD, RemoteException{
		
		// Si aqui hay que tratar alguna cosa se trata, excepciones etc
		
		return sre.listaEjemplos();
	}
	
	public String insertarEjemplo(Ejemplo ej) throws errorSQL, errorConexionBD, RemoteException {
	
		// Si aqui hay que tratar alguna cosa se trata, excepciones etc
		
		return sre.insertarEjemplo(ej);
	}
	
	

}


