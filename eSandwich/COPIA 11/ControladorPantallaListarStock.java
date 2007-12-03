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
	private Vector<String> v = new Vector<String>();
	
	public ControladorPantallaListarStock(
			PantallaListadosStock pantallaListadosStock,
			AplicacionEmpleado ae) {
			this.ae = ae;
			this.pls = pantallaListadosStock;	
			v.add("Id");
			v.add("Descripcion");
			v.add("Descripcion Ampliada");
			v.add("Existencias");
			v.add("Id Familia");
			v.add("Precio");
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String action = arg0.getActionCommand();
		sm = (ServiciosAdAuxModelo) ae.getSm();
	
		try {
		if (action.equals("A")) {
			pl = new PantallaListados();
			JTable t = pl.getJTable();
			t.setModel(new DefaultTableModel(sm.listaProductos(),v));
			pl.setJTable(t);
			pl.setVisible(true);

		} else if (action.equals("B")) {
			int id = new Integer(pls.getJComboBox().getSelectedIndex());
			pl = new PantallaListados();
			JTable t = pl.getJTable();
			t.setModel(new DefaultTableModel(sm.listaProductos(id),v));
			pl.setJTable(t);
			pl.setVisible(true);

		}  else if (action.equals("C")) {
			int id = new Integer(pls.getJComboBox1().getSelectedIndex());
			pl = new PantallaListados();
			JTable t = pl.getJTable();
			t.setModel(new DefaultTableModel(sm.listaProductos(id),v));
			pl.setJTable(t);
			pl.setVisible(true);

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
