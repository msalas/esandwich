import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiciosAccesoImpl extends UnicastRemoteObject implements
    ServiciosRemotosAcceso {

  GestorUsuario gu;

  protected ServiciosAccesoImpl() throws RemoteException, errorConexionBD {
    super();
    gu = new GestorUsuario();

  }

  public Usuario login(String usuario, String password, boolean esCliente)
      throws errorConexionBD, errorSQL, RemoteException {

    return gu.login(usuario, password, esCliente);
  }

  public void logout() throws RemoteException {

  }

  public void desactivarRecursos() {

    gu.liberarRecursos();

  }

}
