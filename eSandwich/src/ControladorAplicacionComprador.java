import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorAplicacionComprador implements ActionListener {

	AplicacionComprador ac = null;
	
	public ControladorAplicacionComprador(
			AplicacionComprador aplicacionComprador) {
		
		ac = aplicacionComprador;
	}


	public void actionPerformed(ActionEvent evt) {
	
		String action = evt.getActionCommand();
		
	if(action.equals("IS")){
		
		new PantallaLogin(ac);
		
	}else if(action.equals("CS")){
	
	}else if(action.equals("AR")){

	}else if(action.equals("CDP")){
		
	}else if(action.equals("MDP")){

	}else if(action.equals("PPa")){
		
	}else if(action.equals("PPu")){
		
	}else if(action.equals("PS")){
	
	}else if(action.equals("RP")){
			
	}
	
	}

}
