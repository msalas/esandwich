import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAplicacionComprador implements ActionListener {

  AplicacionComprador ac = null;

  public ControladorAplicacionComprador(AplicacionComprador aplicacionComprador) {

    ac = aplicacionComprador;
  }

  public void actionPerformed(ActionEvent evt) {
    System.out.println("ControladorAplicacionComprador.actionPerformed()");
    String action = evt.getActionCommand();

    if (action.equals("IS")) {// Inicial sesion
      System.out.println("Iniciar Sesión");
      PantallaLogin login = new PantallaLogin(ac);
      login.setVisible(true);

    } else if (action.equals("CS")) {// Cerrar sesion
      System.out.println("Cerrar sesión");
      ac.setMenuNoRegistrado();

    } else if (action.equals("AR")) {// Alta registro
      System.out.println("Alta registro");

      // PantallaAltaRegistro pap = new PantallaAltaRegistro(ac);
      PantallaDatosPersonales pdp = new PantallaDatosPersonales(ac, false);
      pdp.setVisible(true);

    } else if (action.equals("CDP")) {// Consultar Datos Personales

      PantallaDatosPersonales pdp = new PantallaDatosPersonales(ac, false);
      pdp.setVisible(true);

    } else if (action.equals("MDP")) {// Modificar Datos Personales

      PantallaDatosPersonales pdp = new PantallaDatosPersonales(ac, true);
      pdp.setVisible(true);

    } else if (action.equals("PPa")) {// Panel de promociones

    } else if (action.equals("PPu")) { // Promociones puntos

    } else if (action.equals("PS")) {// Promociones seleccion

    } else if (action.equals("RP")) {// Realizar Pedido
      PantallaHacerPedido php = new PantallaHacerPedido(ac);
      php.setVisible(true);
    }

  }

}
