import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiciosCompradorImpl extends UnicastRemoteObject implements
    ServiciosRemotosComprador {

  public ServiciosCompradorImpl() throws RemoteException {
    super();
  }

  public Usuario getUsuario(int id) throws errorConexionBD, errorSQL{
    GestorCliente gc = new GestorCliente();
    return gc.getCliente(id);
  }
  
  public void setUsuario(Usuario us)throws RemoteException, errorConexionBD, errorSQL{
    GestorCliente gc = new GestorCliente();
    gc.addCliente((Cliente)us);
  }
  
  public void desactivarRecursos() {
    // TODO Auto-generated method stub

  }

}
