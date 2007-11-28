import java.rmi.RemoteException;

public interface ServiciosRemotosAcceso extends ServiciosRemotos {

  public Usuario login(String usuario, String password, boolean esCliente)
      throws errorConexionBD, errorSQL, RemoteException;

  public void logout() throws RemoteException;

}
