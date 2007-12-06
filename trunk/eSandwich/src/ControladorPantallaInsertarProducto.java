import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class ControladorPantallaInsertarProducto implements ActionListener {

	private ServiciosAdAuxModelo sm = null;
	private PantallaInsertarProducto pip = null;
	private AplicacionEmpleado ae = null;

	public ControladorPantallaInsertarProducto(
			PantallaInsertarProducto pantallaInsertarProducto,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pip = pantallaInsertarProducto;
	}

	public void actionPerformed(ActionEvent arg0) {
	
		//Executem aquest codi si ens han apretat el boto d'acceptar
		
		// Ara hem d'insertar el producte que ens han entrat a la pantalla
		// Per tant hem de cridar a serviciosAdaux.insertarProducto.. 
		// On tenim els serveis? L'aplicacio té els serveis actuals
		Producto p = new Producto();
		
		
		//p.setIdProducto(new Integer(pip.getJcodiarticle().getText()));
		
		p.setDescripcion((pip.getJquantitat()).getText());
		p.setDescripcionAmpliada((pip.getJarticle()).getText());
		p.setExistencias(new Integer(pip.getJarticle1().getText()));
		p.setIdFamilia(new Integer(pip.getJTextField().getText()));
		p.setPrecio(new Float(pip.getJTextField1().getText()));
		
		
		sm = (ServiciosAdAuxModelo) ae.getSm();
		try {
			int i = sm.nuevoProducto(p);
		
			ae.mostrarInformacion("Producto con id: "+i, "Producto insertado");
			
		} catch (MalformedURLException e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		} catch (RemoteException e) {
ae.mostrarError(e.getMessage(), "Posar titol");
		} catch (errorConexionBD e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		} catch (errorSQL e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		} catch (NotBoundException e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		}catch (Exception e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		}
		
		
		

	}

}
