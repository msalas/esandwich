import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAplicacionComprador implements ActionListener {

  AplicacionComprador ac = null;

  // AplicacionEmpleado ae = null;

  public ControladorAplicacionComprador(AplicacionComprador aplicacionComprador) {

    ac = aplicacionComprador;
  }

  public void actionPerformed(ActionEvent evt) {

    String action = evt.getActionCommand();

    if (action.equals("IS")) {// Inicial sesion

      PantallaLogin login = new PantallaLogin(ac);
      login.setVisible(true);

    } else if (action.equals("CS")) {// Cerrar sesion
      ac.setMenuNoRegistrado();

    } else if (action.equals("AR")) {// Alta registro
      Usuario u = new Cliente();
      PantallaUsuarisWindow puw = new PantallaUsuarisWindow(ac, u);
      puw.setVisible(true);

    } else if (action.equals("CDP")) {// Consultar Datos Promociones

    } else if (action.equals("MDP")) {// Modificar Promociones

    } else if (action.equals("PPa")) {// Panel de promociones

    } else if (action.equals("PPu")) { // Promociones puntos

    } else if (action.equals("PS")) {// Promociones seleccion

    } else if (action.equals("RP")) {// Realizar Pedido

    }

  }

}
