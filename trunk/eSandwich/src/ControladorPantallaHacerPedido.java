import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Vector;

public class ControladorPantallaHacerPedido implements ActionListener {
  // ServiciosCompradorRegistradoModelo scrm = null;
  public static final int   FAMILIA_BEBIDA   = 0;
  public static final int   FAMILIA_SANDWICH = 1;
  public static final int   FAMILIA_POSTRE   = 2;
  public static final int   FAMILIA_CAFE     = 3;

  PantallaHacerPedido       php              = null;
  ServiciosRemotosComprador src              = null;

  public ControladorPantallaHacerPedido(PantallaHacerPedido p) {
    super();
    try {
      src = (ServiciosRemotosComprador) Naming
          .lookup("rmi://localhost:1099/ServiciosComprador");

      php = p;
      try {
        Vector<Producto> v = src.listaProductosPorFamilia(FAMILIA_SANDWICH);
        php.setJcbTipoSandwich(toComboModel(v));

        v = src.listaProductosPorFamilia(FAMILIA_BEBIDA);
        php.setJcbBebida(toComboModel(v));

      } catch (errorConexionBD e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (errorSQL e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      // scrm = new ServiciosCompradorRegistradoModelo();

    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private Vector<String> toComboModel(Vector<Producto> v) {

    Vector<String> vAux = new Vector<String>();

    for (int i = 0; i < v.size(); i++) {
      vAux.add(v.get(i).descripcion);
    }
    return vAux;

  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("ControladorPantallaHacerPedido.actionPerformed");
    String cmd = e.getActionCommand();
    System.out.println("Actioncommand: " + cmd);

    if (cmd.equals("compra")) {
      System.out.println("Realizando compra");

    } else {

    }

  }

}
