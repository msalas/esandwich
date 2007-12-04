import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ControladorPantallaMantenimientoTipoSandwich implements
		ActionListener {
	
	private ServiciosAdAuxModelo serviciosAdAuxModelo = null;
	private PantallaMantenimientoTipoSandwich pantallaMantenimientoTipoSandwich = null;
	private AplicacionEmpleado aplicacionEmpleado = null;
	
	public ControladorPantallaMantenimientoTipoSandwich
	  (PantallaMantenimientoTipoSandwich pantallaMantenimientoTipoSandwich,
			  AplicacionEmpleado aplicacionEmpleado){
		this.pantallaMantenimientoTipoSandwich=pantallaMantenimientoTipoSandwich;
		this.aplicacionEmpleado=aplicacionEmpleado;
		System.out.println("constructor ControladorP...");
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection <String> getTipoSandwich(){
		Collection <String> cl=new Vector<String>();
		serviciosAdAuxModelo=(ServiciosAdAuxModelo) aplicacionEmpleado.getSm();
		Iterator<TipoSandwich> it;
		try {
			Collection<TipoSandwich> ctipo = serviciosAdAuxModelo.listaTipoSandwich();
			it = ctipo.iterator();
			while (it.hasNext()){
				cl.add(it.next().getDescripcion());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (errorConexionBD e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cl;
	}

	public void actionPerformed(ActionEvent e) {
		String s=(String)pantallaMantenimientoTipoSandwich.getJIngredientesList().getSelectedValue();
		//System.out.println(s);
		serviciosAdAuxModelo=(ServiciosAdAuxModelo) aplicacionEmpleado.getSm();
		try {
			serviciosAdAuxModelo.eliminaTipoSandwich(s);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (errorConexionBD e1) {
			
			e1.printStackTrace();
		}

	}
	

}
