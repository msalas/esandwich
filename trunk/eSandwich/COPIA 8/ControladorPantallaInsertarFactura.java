import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class ControladorPantallaInsertarFactura implements ActionListener{

	private ServiciosAdAuxModelo sm = null;
	private PantallaInsertarFactura pif = null;
	private AplicacionEmpleado ae = null;
	
	public ControladorPantallaInsertarFactura(
			PantallaInsertarFactura pantallaInsertarFactura,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pif = pantallaInsertarFactura;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		Facturacion f = new Facturacion();
		
		f.setId(new Integer(pif.getJTextField().getText()));
		f.setIdPedido(new Integer(pif.getJTextField1().getText()));
		f.setFecha(new Date(pif.getJfinsa11().getText()));
		f.setImporte(new Integer(pif.getJTextField2().getText()));
		
		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			sm.insertarFactura(f);
			
			
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
