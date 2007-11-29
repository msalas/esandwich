import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ControladorPantallaLogin implements ActionListener {

	PantallaLogin pl = null;
	AplicacionComprador ac = null;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm1 = null;  //  @jve:decl-index=0:
	ServiciosCompradorModelo scrm2 = null;  //  @jve:decl-index=0:
	
	public ControladorPantallaLogin(PantallaLogin pantallaLogin, AplicacionComprador ac, AplicacionEmpleado ae) {
		if (ae == null) {
			pl = pantallaLogin;	
			this.ac = ac;
		}
		else {
			pl = pantallaLogin;	
			this.ae = ae;			
		}
			
	}

	public void actionPerformed(ActionEvent arg0) {
	
		// Se ha pulsado boton para hacer login
		
		 try {
			 if (ae == null) {
				 scrm2 = (ServiciosCompradorModelo) ac.getSm();
				 scrm2 =  (ServiciosCompradorModelo) scrm2.login((pl.getTxtCUsuario()).getText(),(pl.getTxtPassword()).getText(),true);
				 ac.setSm(scrm2);
				 ac.setMenuRegistrado();
				 
			 } else {
				 scrm1 = (ServiciosAdAuxModelo) ac.getSm();
				 scrm1 =  (ServiciosAdAuxModelo) scrm1.login((pl.getTxtCUsuario()).getText(),(pl.getTxtPassword()).getText(),false);
				 ae.setSm(scrm1);
			 }
			
			// Actualizamos los servicios de la aplicacion a cliente registrado
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
