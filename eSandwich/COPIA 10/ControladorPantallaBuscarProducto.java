import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaBuscarProducto implements ActionListener{
	
	private ServiciosAdAuxModelo sm = null;
	private PantallaBuscarProducto pbp = null;
	private AplicacionEmpleado ae = null;
	
	public ControladorPantallaBuscarProducto(
			PantallaBuscarProducto pantallaBuscarProducto,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pbp = pantallaBuscarProducto;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		int id = new Integer(pbp.getJcodiArticle().getText());
		

		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			sm.existeProducto(id);
			
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
