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

  Vector<Producto>          vSandwiches      = null;
  Vector<Producto>          vBebidas         = null;
  Vector<Producto>          vPostres         = null;
  Vector<Producto>          vCafes           = null;

  public ControladorPantallaHacerPedido(PantallaHacerPedido p) {
    super();
    try {
      src = (ServiciosRemotosComprador) Naming
          .lookup("rmi://localhost:1099/ServiciosComprador");

      php = p;
      try {
        vSandwiches = src.listaProductosPorFamilia(FAMILIA_SANDWICH);
        php.setJcbTipoSandwich(toComboModel(vSandwiches));

        vBebidas = src.listaProductosPorFamilia(FAMILIA_BEBIDA);
        php.setJcbBebida(toComboModel(vBebidas));

        vPostres = src.listaProductosPorFamilia(FAMILIA_POSTRE);
        php.setJcbPostres(toComboModel(vPostres));

        vCafes = src.listaProductosPorFamilia(FAMILIA_CAFE);
        php.setJcbCafes(toComboModel(vCafes));

        php.getJTableCompra().setModel(new TMCompras(new Vector()));

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
      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      float cuanto = 0;
      for (int i = 0; i < tm.getNumFilas(); i++) {
        float f = ((Float) tm.getValueAt(i, 2)).floatValue();
        cuanto += f;
      }
      System.out.println("Valor total: " + cuanto);
      
    } else if (cmd.equals("addSandwich")) {
      System.out.println("add Sandwich");
      int i = php.getJcbTipoSandwich().getSelectedIndex();
      Producto p = vSandwiches.get(i);

      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      Vector v = new Vector();
      int cuantos = php.getJcbUnidades().getSelectedIndex();
      v.add(new Integer(++cuantos));
      v.add(p.getDescripcion());
      v.add(p.getPrecio());

      tm.addFila(v);
      tm.fireTableDataChanged();

    } else if (cmd.equals("addBebida")) {
      System.out.println("add Bebida");
      int i = php.getJcbBebidas().getSelectedIndex();
      Producto p = vBebidas.get(i);

      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      Vector v = new Vector();
      int cuantos = php.getJcbUnidadesBebidas().getSelectedIndex();
      v.add(new Integer(++cuantos));
      v.add(p.getDescripcion());
      v.add(p.getPrecio());

      tm.addFila(v);
      tm.fireTableDataChanged();

    } else if (cmd.equals("addPostre")) {
      System.out.println("add Postre");
      int i = php.getJcbPostres().getSelectedIndex();
      Producto p = vPostres.get(i);

      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      Vector v = new Vector();
      int cuantos = php.getJcbUnidadesPostres().getSelectedIndex();
      v.add(new Integer(++cuantos));
      v.add(p.getDescripcion());
      v.add(p.getPrecio());

      tm.addFila(v);
      tm.fireTableDataChanged();

    } else if (cmd.equals("addCafe")) {
      System.out.println("add Café");
      int i = php.getJcbCafes().getSelectedIndex();
      Producto p = vCafes.get(i);

      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      Vector v = new Vector();
      int cuantos = php.getJcbUnidadesCafes().getSelectedIndex();
      v.add(new Integer(++cuantos));
      v.add(p.getDescripcion());
      v.add(p.getPrecio());

      tm.addFila(v);
      tm.fireTableDataChanged();

    } else if (cmd.equals("borra")) {
      int fila = php.getJTableCompra().getSelectedRow();
      TMCompras tm = (TMCompras) (php.getJTableCompra().getModel());
      tm.borraFila(fila);
      tm.fireTableDataChanged();
    }

  }

}
