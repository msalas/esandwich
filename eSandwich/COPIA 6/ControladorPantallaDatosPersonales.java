import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPantallaDatosPersonales implements ActionListener {

  ServiciosCompradorRegistradoModelo sc          = null;
  AplicacionComprador                ac          = null;
  PantallaDatosPersonales            pdp         = null;
  Usuario                            userSession = null;

  public ControladorPantallaDatosPersonales(
      PantallaDatosPersonales pantallaDatosPersonales, AplicacionComprador ac) {

    this.ac = ac;
    this.pdp = pantallaDatosPersonales;
    sc = (ServiciosCompradorRegistradoModelo) ac.getSm();
    userSession = sc.getU();
  }

  // Exemple, fer el mateix amb totes les dades que necessitis

  public String getNombre() {
    return userSession.getNombre();
  }

  public void actionPerformed(ActionEvent arg0) {

    String cmd = arg0.getActionCommand();
    System.out.println("ActionCommand: " + cmd);

    if(cmd.equals("crear")){
      
    }else if(cmd.equals("modificar")){
      
    }

  }

}
