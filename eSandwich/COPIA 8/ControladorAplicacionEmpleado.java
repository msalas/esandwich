import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAplicacionEmpleado implements ActionListener {

  AplicacionEmpleado ae = null;

  public ControladorAplicacionEmpleado(AplicacionEmpleado aplicacionEmpleado) {
    ae = aplicacionEmpleado;
  }

  public void actionPerformed(ActionEvent evt) {
    System.out.println("ControladorAplicacionEmpleado.actionPerformed()");
    String action = evt.getActionCommand();

    System.out.println("Action = " + action);

    if (action.equals("IS")) {
      System.out.println("login");
      new PantallaLogin(ae).setVisible(true);

    } else if (action.equals("AR")) {
      System.out.println("PantallaAltaEmpleado()");
      new PantallaAltaEmpleado(ae).setVisible(true);

    } else if (action.equals("crear")) {
      System.out.println("Crear");
      
    } 
//    else if (action.equals("cancelar")) {
//      System.out.println("Cancelar");
//      
//      
//    }
  }

}
