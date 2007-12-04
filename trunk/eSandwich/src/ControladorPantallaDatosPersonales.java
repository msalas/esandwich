import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JComboBox;

public class ControladorPantallaDatosPersonales implements ActionListener {

  ServiciosCompradorModelo scrm = null;
  AplicacionComprador      ac   = null;
  PantallaDatosPersonales  pdp  = null;
  Cliente                  cli  = null;

  public ControladorPantallaDatosPersonales(
      PantallaDatosPersonales pantallaDatosPersonales, AplicacionComprador ac) {

    this.ac = ac;
    this.pdp = pantallaDatosPersonales;

    scrm = ac.getSm();
    // Quin servei estem?
    if (scrm instanceof ServiciosCompradorRegistradoModelo) {
      // Mas de lo mismo, mostrem segons si estem modificant o consultant dades
      if (pdp.isModificar())
        pdp.setModificar();
      else
        pdp.setConsultar();
      // Forcem la nostra instancia a ser de comprador registrat
      scrm = (ServiciosCompradorRegistradoModelo) ac.getSm();
      System.out.println("MODIF O CONS");
      this.llenarDatos();

    } else {
      // Vol dir que no esta registrat, per tant fem Alta Registro
      // Aixo ho deixa editable per posar les dades
      pdp.setCrear();
      System.out.println("CREAR");

    }
  }

  private void llenarDatos() {
    // Tant si es modificar com consultar omplim les dades del cliente

    cli = (Cliente) scrm.getU();
    pdp.getJTextFieldNom().setText(cli.getNombre());
    pdp.getJTextFieldNumTargCredit().setText(cli.getTarjetaCredito());
    (pdp.getJTextFieldCodiUsuari()).setText(cli.getCodUsuario());
    pdp.getJTextFieldCognoms().setText(cli.getApellido1());
    pdp.getJTextFieldAdreça().setText(cli.getDireccion());
    pdp.getJTextFieldEMail().setText(cli.getEmail());
    pdp.getJTextFieldTelefon().setText(cli.getTelefono());
    pdp.getJTextFieldMobil().setText(cli.getMovil());
    pdp.getJTextFieldPoblacio().setText(cli.getPoblacion());
    pdp.getJPasswordFieldCContrasenya().setText(cli.getPassword());
    pdp.getJPasswordFieldNContrasenya().setText(cli.getPassword());

  }

  public void actionPerformed(ActionEvent arg0) {
    System.out.println("ControladorPantallaDatosPersonales.actionPerformed");

    String cmd = arg0.getActionCommand();
    System.out.println("ActionCommand: " + cmd);

    if (cmd.equals("crear")) {
      System.out.println("Alta Registro");

      // Hem de pillar les dades de la pantalla via get's
      // I enviar-ho al model
      Cliente cli = new Cliente();
      cli.setNombre(pdp.getJTextFieldNom().getText());
      cli.setApellido1(pdp.getJTextFieldCognoms().getText());
      cli.setDireccion(pdp.getJTextFieldAdreça().getText());
      cli.setEmail(pdp.getJTextFieldEMail().getText());
      cli.setMovil(pdp.getJTextFieldMobil().getText());
      cli.setTelefono(pdp.getJTextFieldTelefon().getText());
//      cli.set
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
      
      // I el model ens torna el codi usuari, que l'hem de mostrar per pantalla
      // Per exemple fent mostrarInformacion passantli el codi usuari
      ac.mostrarInformacion("", "");

    } else if (cmd.equals("modificar")) {
      System.out.println("modificar");

      // Si apreten modificar hem de posar les dades al model

    } else if (cmd.equals("cancelar")) {
      System.out.println("Cancelar");

    }

  }

}
