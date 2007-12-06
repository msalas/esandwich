import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorModelo {

  
  private ServiciosRemotosComprador scomp;
  private ServiciosRemotosCocina scoc;
  private ServiciosRemotosAdminAux  sadaux;
  private ServiciosRemotosAcceso    sra;

  public ServidorModelo() throws errorConexionBD, RemoteException {
    createRegistry(1099);
    // 1099 puerto utilizado por defecto por rmiregistry

  }

  public void encenderServidor() throws RemoteException, MalformedURLException, errorConexionBD {
	  iniciarServicios();
    // Publicamos todos los servicios en el servicio de nombres
    Naming.rebind("rmi://localhost/ServiciosComprador", scomp);
    Naming.rebind("rmi://localhost/ServiciosCocina", scoc);
    Naming.rebind("rmi://localhost/ServiciosAdAux", sadaux);
    Naming.rebind("rmi://localhost/ServiciosAcceso", sra);

  }

  public void apagarServidor() throws RemoteException, MalformedURLException,
      NotBoundException {

    // Quitamos todos los servicios disponibles del servicio de nombres
   
    Naming.unbind("rmi://localhost/ServiciosComprador");
    Naming.unbind("rmi://localhost/ServiciosCocina");
    Naming.unbind("rmi://localhost/ServiciosAdAux");
    Naming.unbind("rmi://localhost/ServiciosAcceso");

    // Desactivamos los recursos que ha adquirido objeto remoto
    
    scomp.desactivarRecursos();
    scoc.desactivarRecursos();
    sadaux.desactivarRecursos();
    sra.desactivarRecursos();

  }

  /* M�todo utilizado para iniciar el registro RMI */

  private static void createRegistry(int hostport) {
    try {
      LocateRegistry.createRegistry(hostport);
      LocateRegistry.getRegistry(hostport);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    try {
      System.out.println("Activating Java RmiRegistry.......");
      java.lang.Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println("InterruptedException: " + e);
      // e.printStackTrace();
    }
  }

  private void iniciarServicios() throws RemoteException, errorConexionBD{
	  scomp = new ServiciosCompradorImpl();
	    scoc = new ServiciosCocinaImpl();
	    sadaux = new ServiciosAdminAuxImpl();
	    sra = new ServiciosAccesoImpl();
  }
}
