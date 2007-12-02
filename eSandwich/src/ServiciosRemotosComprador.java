import java.rmi.RemoteException;

public interface ServiciosRemotosComprador extends ServiciosRemotos {

  public Usuario getUsuario(int id) throws errorConexionBD, errorSQL,
      RemoteException;

}
