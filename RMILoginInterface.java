import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMILoginInterface extends Remote {

  public void login(String nombre, String clave) throws RemoteException;

}
