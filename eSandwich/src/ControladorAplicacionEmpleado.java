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
		
		new PantallaLogin(ae);
		
	}else if(action.equals("CS")){
	
	}else if(action.equals("AR")){
		
		new PantallaUsuarisWindow(ae);
		
	}else if(action.equals("CDP")){
		
	}else if(action.equals("MDP")){

	}else if(action.equals("PPa")){
		
	}else if(action.equals("PPu")){
		
	}else if(action.equals("PS")){
	
	}else if(action.equals("RP")){
			
	}
	
	}

}
