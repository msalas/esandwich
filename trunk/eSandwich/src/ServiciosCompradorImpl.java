import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ServiciosCompradorImpl extends UnicastRemoteObject implements
    ServiciosRemotosComprador {

  public ServiciosCompradorImpl() throws RemoteException {
    super();
  }

  public Usuario getUsuario(int id) throws errorConexionBD, errorSQL {
    GestorCliente gc = new GestorCliente();
    return gc.getCliente(id);
  }

  public void setUsuario(Usuario us) throws RemoteException, errorConexionBD,
      errorSQL {
    GestorCliente gc = new GestorCliente();
    gc.addCliente((Cliente) us);
  }

  public Vector<Producto> listaProductosPorFamilia(int familia)
      throws RemoteException, errorConexionBD, errorSQL {
    GestorProducto gp = new GestorProducto();
    Vector<Producto> v = gp.listaProductoPorFamilia(familia);
    return v;
  }

  public void addPedido(Pedido ped) throws RemoteException, errorConexionBD,
      errorSQL {
    GestorPedido gp = new GestorPedido();
    gp.addPedido(ped);
  }

  // public Vector getBebidas() throws RemoteException, errorConexionBD,
  // errorSQL {
  // // TODO Auto-generated method stub
  // return null;
  // }

  public void desactivarRecursos() {
    // TODO Auto-generated method stub

  }
}
