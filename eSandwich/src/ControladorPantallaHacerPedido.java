import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaHacerPedido implements ActionListener {
  ServiciosCompradorRegistradoModelo scrm = null;
  PantallaHacerPedido                php  = null;

  public ControladorPantallaHacerPedido(PantallaHacerPedido p) {
    try {
      php = p;
      scrm = new ServiciosCompradorRegistradoModelo();

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
