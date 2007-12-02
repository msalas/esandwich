import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaListarFacturas implements ActionListener{

	private ServiciosAdAuxModelo sm = null;
	private PantallaListadoFactura plf = null;
	private AplicacionEmpleado ae = null;
	
	public ControladorPantallaListarFacturas(
			PantallaListadoFactura pantallaListadoFactura,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.plf = pantallaListadoFactura;	
	}
	
	public ControladorPantallaListarFacturas(){
		super();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		sm = (ServiciosAdAuxModelo) ae.getSm();
		if (action.equals("A")) {
			try {
				sm.listaFacturas();				
				} catch (MalformedURLException e) {
					ae.mostrarError(e.getMessage(), "Posar titol");
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (errorConexionBD e) {
					e.printStackTrace();
				} catch (errorSQL e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				}			
		    } else if (action.equals("B")) {
		     

		    } else if (action.equals("C")) {
		     
		      
		    } 

		
		
	}
}
