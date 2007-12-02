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

  
    
    if (action.equals("IS")) new PantallaLogin(ae).setVisible(true);
    else if (action.equals("AE")) new PantallaAltaEmpleado(ae).setVisible(true);
    else if (action.equals("ME")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("BE")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CE")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("BC")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CC")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CSAN")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("ASAN")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("MASAN")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("ATS")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("MTS")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("PF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("AP")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CP")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("BP")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("MP")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("AF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("MF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("BF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("ST")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("SF")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("FT")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("FS")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("APRO")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("BPRO")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CPRO")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("MPRO")) new PantallaXXX(ae).setVisible(true);
    else if (action.equals("CS")) {
    	ae.confirmacio("Estas seguro que quiere cerra la sesión?", "Cerrar Sesión");
    	// Falta hacer el logout
    }
    else;
    
  }

}
