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
		
		
		
		try {
			System.out.println(id);
			
			sm = (ServiciosAdAuxModelo) ae.getSm();
			
			System.out.println("AFTER SM");
			
			
			if(sm.existeProducto(id)){	
				System.out.println("IN EXISTE");
				
				Producto p = sm.consultaProducto(id);
			}else ae.mostrarInformacion("El producto no existe", "Buscar producto");
				
			
		if(ae.getComanda().equalsIgnoreCase("CP")){
			// 	Creamos una pantalla para mostrar los datos
		
			new PantallaConsultaProducto(this);
			
		}else if(ae.getComanda().equalsIgnoreCase("BP")){
			
						
		}else if(ae.getComanda().equalsIgnoreCase("MP")){
			
			// Creamos una pantalla para mostrar los datos editables
		
		}
			
		
		

		
			
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
			
		}
		
	}
		
}
