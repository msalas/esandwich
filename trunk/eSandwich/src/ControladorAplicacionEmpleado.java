import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorAplicacionEmpleado implements ActionListener {

	AplicacionEmpleado ae = null;

	public ControladorAplicacionEmpleado(
			AplicacionEmpleado aplicacionEmpleado) {
		ae = aplicacionEmpleado;
	}


	public void actionPerformed(ActionEvent evt) {
	
		String action = evt.getActionCommand();
		
		if(action.equals("IS")){
		
			new PantallaLogin(ae).setVisible(true);
		

		}else if(action.equals("AR")){
		
			new PantallaAltaEmpleado(ae).setVisible(true);			
			
		}	
	}

}
