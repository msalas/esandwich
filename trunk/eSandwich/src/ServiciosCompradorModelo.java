import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServiciosCompradorModelo extends ServiciosAccesoModelo {

  ServiciosRemotosComprador src;

  public ServiciosCompradorModelo() throws MalformedURLException,
      RemoteException, NotBoundException {
    super();
    src = (ServiciosRemotosComprador) Naming
        .lookup("rmi://localhost:1099/ServiciosComprador");

  }
  
  public void editaUsuario(Usuario usu) throws errorConexionBD, errorSQL {
    GestorCliente gcli = new GestorCliente();
    gcli.editaCliente((Cliente)usu);
  }

}
