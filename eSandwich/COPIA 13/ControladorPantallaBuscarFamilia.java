import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaBuscarFamilia implements ActionListener{
	private ServiciosAdAuxModelo sm = null;
	private PantallaBuscarFamilia pbf = null;
	private PantallaConsultaFamilia pcf = null;
	private AplicacionEmpleado ae = null;
	private int id;

	public ControladorPantallaBuscarFamilia(
			PantallaBuscarFamilia pantallaBuscarFamilia,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pbf = pantallaBuscarFamilia;
			
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		id = new Integer(pbf.getJTextField().getText());
		

		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			
			sm.consultaFamilia(id);
					
			
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
