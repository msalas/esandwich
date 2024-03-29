import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JComboBox;

public class ControladorPantallaDatosPersonales implements ActionListener {

  ServiciosCompradorModelo scrm          = null;
  AplicacionComprador                ac          = null;
  PantallaDatosPersonales            pdp         = null;
  Cliente                            cli = null;

  public ControladorPantallaDatosPersonales(
      PantallaDatosPersonales pantallaDatosPersonales, AplicacionComprador ac) {

    this.ac = ac;
    this.pdp = pantallaDatosPersonales;
  
    scrm = ac.getSm();
//    Quin servei estem?
    if (scrm instanceof ServiciosCompradorRegistradoModelo) {
    	// Mas de lo mismo, mostrem segons si estem modificant o consultant dades
    	if(pdp.isModificar())pdp.setModificar();
    	else pdp.setConsultar();
		// Forcem la nostra instancia a ser de comprador registrat
    	scrm = (ServiciosCompradorRegistradoModelo) ac.getSm();
    	System.out.println("MODIF O CONS");
    	this.llenarDatos();
	
    }else 
	{
    	//Vol dir que no esta registrat, per tant fem Alta Registro
    	// Aixo ho deixa editable per posar les dades
    	pdp.setCrear();
    System.out.println("CREAR");	
    
    }
  }



  private void llenarDatos() {
	  // Tant si es modificar com consultar omplim les dades del cliente

      cli = (Cliente) scrm.getU();
         System.out.println(cli.getNombre());  
	(pdp.getJTextFieldCodiUsuari()).setText(cli.getCodUsuario());
	
}



public void actionPerformed(ActionEvent arg0) {
    System.out.println("ControladorPantallaDatosPersonales.actionPerformed");

    String cmd = arg0.getActionCommand();
    System.out.println("ActionCommand: " + cmd);

    if (cmd.equals("crear")) {
      System.out.println("Alta Registro");

      //Hem de pillar les dades de la pantalla via get's
      // I enviar-ho al model
      
      // I el model ens torna el codi usuari, que l'hem de mostrar per pantalla
     // Per exemple fent mostrarInformacion passantli el codi usuari
      ac.mostrarInformacion("","");
      
    } else if (cmd.equals("modificar")) {
      System.out.println("modificar");
     
// Si apreten modificar hem de posar les dades al model
           
      
      
    } else if (cmd.equals("cancelar")) {
      System.out.println("Cancelar");
    
    }

  }

}
