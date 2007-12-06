import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorPantallaListarStock implements ActionListener{

	private ServiciosAdAuxModelo sm = null;
	private PantallaListadosStock pls = null;
	private AplicacionEmpleado ae = null;
	private PantallaListados pl = null;
	private Vector<String> vStock = new Vector<String>();
	
	public ControladorPantallaListarStock(
			PantallaListadosStock pantallaListadosStock,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pls = pantallaListadosStock;	
			
			vStock.add("Id");
			vStock.add("Descripcion");
			vStock.add("Existencias");
					
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		

		
		try {
		
		
			sm = (ServiciosAdAuxModelo) ae.getSm();
		
		
			if (action.equals("acceptar")) {
				
				pl = new PantallaListados(ae);
				Vector<Vector> vv = null;
				if(ae.getComanda().equalsIgnoreCase("A")){
				//Total
					vv= sm.listaStock();
					
				}else if(ae.getComanda().equalsIgnoreCase("B")){
				//Por producto	
					int id = new Integer(pls.getJComboBox().getSelectedIndex());
					vv = sm.listaStockPorFamilia(id);
					
				}else if(ae.getComanda().equalsIgnoreCase("C")){
				//Por familia
					int id = new Integer(pls.getJComboBox1().getSelectedIndex());

				}
				
				(pl.getJTable()).setModel(new DefaultTableModel(vv,vStock));			
				pls.setVisible(false);
				pl.setVisible(true);
			
			
			

	    }else if (action.equals("cancelar")) {
	    	
	    }else  	ae.setComanda(action);
	    
 
 
		
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
			
		} catch (Exception e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
		}

	}
	
	
	
}
