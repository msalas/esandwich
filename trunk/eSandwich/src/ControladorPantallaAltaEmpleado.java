import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class ControladorPantallaAltaEmpleado extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaAltaEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null;  //  @jve:decl-index=0:
	private JOptionPane jOptionPane = null;  //  @jve:decl-index=0:visual-constraint="88,77"
	public ControladorPantallaAltaEmpleado(PantallaAltaEmpleado pAltEmp, AplicacionEmpleado ae) {
		Pe = pAltEmp;	
		this.ae = ae;
	}
	
	public void iniCombo() {
		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			Pe.setVectorCombo(scrm.listaDescRol());
			ae.setSm(scrm);
		}
		catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR URL",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR remote",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (errorConexionBD e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR conexión BD",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (errorSQL e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR SQL",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR BOUND",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR GENERAL",JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent evt)  {
		
		
		Empleado emp = null;
		
		
		Pe.montaEmpleado();
		emp = Pe.getEmp();
		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			scrm.nuevoEmpleado(emp);
			ae.setSm(scrm);
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR URL",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR remote",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (errorConexionBD e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR conexión BD",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (errorSQL e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR SQL",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR BOUND",JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.toString(),"ERROR GENERAL",JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(this,"Alta realizada","Alta empleados",JOptionPane.INFORMATION_MESSAGE);
		Pe.getJButtonCancellar(); 
	}

	

}
