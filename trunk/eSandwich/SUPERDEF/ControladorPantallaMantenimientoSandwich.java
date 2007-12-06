import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;


public class ControladorPantallaMantenimientoSandwich implements ActionListener {
    
	
	private ServiciosAdAuxModelo serviciosAdAuxModelo = null;
	private PantallaMantenimientoSandwich pantallaMantenimientoSandwich = null;
	private AplicacionEmpleado aplicacionEmpleado = null;
	
	
	public ControladorPantallaMantenimientoSandwich
	  (PantallaMantenimientoSandwich pantallaMantenimientoSandwich,
			  AplicacionEmpleado aplicacionEmpleado){
		this.pantallaMantenimientoSandwich=pantallaMantenimientoSandwich;
		this.aplicacionEmpleado=aplicacionEmpleado;
		}
	
	
	public Object[][] listaSandwich(){
		
		serviciosAdAuxModelo=(ServiciosAdAuxModelo) aplicacionEmpleado.getSm();
		Vector cartaSandwich=null;
		Object [][] tablaSandwich=new Object[10][2];
		try {
			cartaSandwich = (Vector)serviciosAdAuxModelo.listaCartaSandwich();
			
			for (int i=0;i<cartaSandwich.size();i++){
				tablaSandwich[i][0]=((Sandwich)cartaSandwich.get(i)).getIdProducto();
				System.out.println(tablaSandwich[i][0]);
				tablaSandwich[i][1]=((Sandwich)cartaSandwich.get(i)).getDescripcion();
				System.out.println(tablaSandwich[i][1]);
			}
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (errorConexionBD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tablaSandwich;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
