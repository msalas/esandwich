import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMILoginImpl extends UnicastRemoteObject implements
    RMILoginInterface, Serializable {

  /** Version serializable */
  private static final long serialVersionUID = 1L;

  private GestorLogin       gestorLogin      = null;

  public RMILoginImpl() throws RemoteException {
    super();
    System.out.println("RMILoginImpl()");
    try {
      gestorLogin = new GestorLogin();
      // Ya lo hace el gestorlogin en el constructor
      // gestorLogin.abrirConexion();

    } catch (errorConexionBD e) {
      System.err.println("Error abriendo la conexion: " + e);
      // e.printStackTrace();
    }
  }

  public void login(String nombre, String clave) throws RemoteException {
    gestorLogin.login(nombre, clave);
  }

}
