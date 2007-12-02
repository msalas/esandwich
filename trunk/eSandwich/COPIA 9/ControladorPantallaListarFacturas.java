import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorPantallaListarFacturas implements ActionListener{

	private ServiciosAdAuxModelo sm = null;
	private PantallaListadoFactura plf = null;
	private AplicacionEmpleado ae = null;
	private PantallaListados pl = null;
	private Vector<String> v = new Vector<String>();
	
	public ControladorPantallaListarFacturas(
			PantallaListadoFactura pantallaListadoFactura,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.plf = pantallaListadoFactura;	
			v.add("Id");
			v.add("Id pedido");
			v.add("Fecha");
			v.add("Importe");
	}
	

	
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		sm = (ServiciosAdAuxModelo) ae.getSm();
	
		try {
		if (action.equals("A")) {
	
				
				pl = new PantallaListados();
				JTable t = pl.getJTable();
				t.setModel(new DefaultTableModel(sm.listaFacturas(),v));
				pl.setJTable(t);
				pl.setVisible(true);

		} else if (action.equals("B")) {
		     

		    } else if (action.equals("C")) {
		     
		      
		    } 

		} catch (MalformedURLException e) {
			ae.mostrarError(e.getMessage(), "Posar titol");
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (errorConexionBD e) {
			e.printStackTrace();
		} catch (errorSQL e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
	}
}
