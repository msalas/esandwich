import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class ControladorPantallaInsertarFamilia implements ActionListener{


	private ServiciosAdAuxModelo sm = null;
	private PantallaInsertarFamilia pif = null;
	private AplicacionEmpleado ae = null;
	
	public ControladorPantallaInsertarFamilia(
			PantallaInsertarFamilia pantallaInsertarFamilia,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pif = pantallaInsertarFamilia;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		FamiliaProducto f = new FamiliaProducto();
		
		f.setIdFamilia(new Integer(pif.getJTextField().getText()));
		f.setDescripcion(pif.getJTextField1().getText());
		
		
		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			sm.nuevaFamilia(f);
			
			
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
