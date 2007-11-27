import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ControladorPantallaLogin implements ActionListener {

	PantallaLogin pl = null;
	AplicacionComprador ac = null;
	ServiciosCompradorRegistradoModelo scrm = null;
	
	public ControladorPantallaLogin(PantallaLogin pantallaLogin, AplicacionComprador ac) {
		pl = pantallaLogin;	
		this.ac = ac;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		// Se ha pulsado boton para hacer login
		
		 scrm = (ServiciosCompradorRegistradoModelo) ac.getSm();
		
		 try {
			scrm =  (ServiciosCompradorRegistradoModelo) scrm.login((pl.getTxtCUsuario()).getText(),(pl.getTxtPassword()).getText(),true);
			
			// Actualizamos los servicios de la aplicacion a cliente registrado
			ac.setSm(scrm);
			ac.setMenuRegistrado();
			pl.setVisible(false);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (errorConexionBD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (errorSQL e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
