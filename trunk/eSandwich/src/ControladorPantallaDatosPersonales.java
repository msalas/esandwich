import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class ControladorPantallaDatosPersonales implements ActionListener {

  ServiciosCompradorRegistradoModelo scrm          = null;
  AplicacionComprador                ac          = null;
  PantallaDatosPersonales            pdp         = null;
  Usuario                            userSession = null;

  public ControladorPantallaDatosPersonales(
      PantallaDatosPersonales pantallaDatosPersonales, AplicacionComprador ac) {

    this.ac = ac;
    this.pdp = pantallaDatosPersonales;
    scrm = (ServiciosCompradorRegistradoModelo) ac.getSm();
    userSession = scrm.getU();
  }

  // Exemple, fer el mateix amb totes les dades que necessitis
  public String getNombre() {
    return userSession.getNombre();
  }

  public Usuario getUsuario() {
    return userSession;
  }

  public void actionPerformed(ActionEvent arg0) {
    System.out.println("ControladorPantallaDatosPersonales.actionPerformed");

    String cmd = arg0.getActionCommand();
    System.out.println("ActionCommand: " + cmd);

    if (cmd.equals("crear")) {
      System.out.println("crear");
//      System.out.println("pdp.setUsuario(userSession)");
      // TODO cargar el usuario
      // sc.getUsuario(id);
      Cliente cli = pdp.getCliente();
      try {
        scrm.setU(cli);
        
      } catch (RemoteException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (errorConexionBD e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (errorSQL e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
//      pdp.setUsuario(userSession);

    } else if (cmd.equals("modificar")) {
      System.out.println("modificar");

    } else if (cmd.equals("cancelar")) {
      System.out.println("Cancelar");
    }

  }

}
