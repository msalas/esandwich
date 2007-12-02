import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServiciosCompradorRegistradoModelo extends
    ServiciosCompradorModelo {

  public ServiciosCompradorRegistradoModelo() throws MalformedURLException,
      RemoteException, NotBoundException {
    super();

  }

  // Ejemplo
  public String aaa() {
    // Se puede usar src porque lo heredamos, asi que
    // no hace falta crear otra conexion
    // src.loquesea();
    return null;
  }

  public Usuario getUsuario(int id) {
    Usuario u = null;
    try {
      u = src.getUsuario(id);

    } catch (errorConexionBD e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (errorSQL e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return u;
  }
}
