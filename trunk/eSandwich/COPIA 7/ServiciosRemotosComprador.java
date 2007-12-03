import java.rmi.RemoteException;

public interface ServiciosRemotosComprador extends ServiciosRemotos {

  public Usuario getUsuario(int id) throws errorConexionBD, errorSQL,
      RemoteException;

  public void setUsuario(Usuario u) throws RemoteException, errorConexionBD,
      errorSQL;

}
