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
	
	public void actionPerformed(ActionEvent arg0) {
		
		

		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			sm.listaFacturas();
					
			
		} catch (MalformedURLException e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
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
