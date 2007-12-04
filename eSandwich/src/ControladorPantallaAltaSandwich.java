import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.print.attribute.standard.Severity;


public class ControladorPantallaAltaSandwich implements ActionListener {

	private ServiciosCocinaModelo serviciosCocinaModelo = null;
	private PantallaAltaSandwich pantallaAltaSandwich = null;
	private AplicacionEmpleado aplicacionEmpleado = null;
	
	Vector <String> v=new Vector <String>();
	
	public ControladorPantallaAltaSandwich
	  (PantallaAltaSandwich pantallaAltaSandwich,
			  AplicacionEmpleado aplicacionEmpleado){
		this.pantallaAltaSandwich=pantallaAltaSandwich;
		this.aplicacionEmpleado=aplicacionEmpleado;
	}
	
	
	public Collection <String> getIngredientes(){
		Collection <String> cl=new Vector<String>();
		serviciosCocinaModelo=(ServiciosCocinaModelo) aplicacionEmpleado.getSm();
		Iterator<String> it;
		try {
			Collection <String> csan = serviciosCocinaModelo.listaIngredientesDisponibles();
			it = csan.iterator();
			while (it.hasNext()){
				cl.add(it.next());
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
	
	public Collection <String> getTiposSandwich(){
		Collection <String> cl=new Vector<String>();
		serviciosCocinaModelo=(ServiciosCocinaModelo) aplicacionEmpleado.getSm();
		Iterator<TipoSandwich> it;
		try {
			Collection<TipoSandwich> ctipo = serviciosCocinaModelo.listaTipoSandwich();
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
		
		String cmd = e.getActionCommand();
		
		
		if (cmd.equals("añadir")){
			String ingrediente=(String) pantallaAltaSandwich.getJIngredientesComboBox().getSelectedItem();
			System.out.println(ingrediente);
			v.add(ingrediente);
			//pantallaAltaSandwich.getJIngredientesList(v);
		}
		
		if (cmd.equals("aceptar")){
			Sandwich sandwich=new Sandwich();
			sandwich.setDescripcion((pantallaAltaSandwich.getJNombreText()).getText());
			sandwich.setDescripcionAmpliada(pantallaAltaSandwich.getJDescripcionTextArea().getText());
			sandwich.setPrecio(new Float(pantallaAltaSandwich.getJPrecioText().getText()));
			Object [] ingredientesObject= v.toArray();
			String [] ingredientesArray=new String[10];
			for(int i=0;i<ingredientesObject.length;i++){
				ingredientesArray[i]=(String) ingredientesObject[i]; 
			}
			sandwich.setIngredienteSandwich(ingredientesArray);
			String nombreTipoSandwich=(String) pantallaAltaSandwich.getJTipoComboBox().getSelectedItem();
			
			
			
			
			serviciosCocinaModelo=(ServiciosCocinaModelo) aplicacionEmpleado.getSm();
			
			try {
				TipoSandwich ts=new TipoSandwich();
				String descripcion=(String)pantallaAltaSandwich.getJTipoComboBox().getSelectedItem();
				int id=serviciosCocinaModelo.devuelveIdTipoSandwich(descripcion);
				ts.setId(id);
				ts.setDescripcion(descripcion);
				sandwich.setTipoSandwich(ts);
				serviciosCocinaModelo.altaSandwich(sandwich);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (errorConexionBD e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


}
