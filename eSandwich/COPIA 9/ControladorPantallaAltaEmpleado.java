import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class ControladorPantallaAltaEmpleado implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaAltaEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null; 
	
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
			ae.mostrarError(e.getMessage(),"Error Url");
			//e.printStackTrace();
		} catch (RemoteException e) {
			ae.mostrarError(e.getMessage(),"Error remoto");
			//e.printStackTrace();
		} catch (errorConexionBD e) {
			ae.mostrarError(e.getMessage(), "Error de conexion con la Base de Datos");
			//e.printStackTrace();
		} catch (errorSQL e) {
			ae.mostrarError(e.getMessage(),"Error de sql");
			//e.printStackTrace();
		} catch (NotBoundException e) {
			ae.mostrarError(e.getMessage(),"Error de servicios");
			//e.printStackTrace();
		} catch (Exception e) {
			ae.mostrarError(e.getMessage(),"Error general");
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
		}catch (MalformedURLException e) {
				ae.mostrarError(e.getMessage(),"Error Url");
				//e.printStackTrace();
			} catch (RemoteException e) {
				ae.mostrarError(e.getMessage(),"Error remoto");
				//e.printStackTrace();
			} catch (errorConexionBD e) {
				ae.mostrarError(e.getMessage(), "Error de conexion con la Base de Datos");
				//e.printStackTrace();
			} catch (errorSQL e) {
				ae.mostrarError(e.getMessage(),"Error de sql");
				//e.printStackTrace();
			} catch (NotBoundException e) {
				ae.mostrarError(e.getMessage(),"Error de servicios");
				//e.printStackTrace();
			} catch (Exception e) {
				ae.mostrarError(e.getMessage(),"Error general");
			}
		//ae.mostrarInformacion("Alta realizada","Alta empleados");
		Pe.getJButtonCancellar(); 
	}

	

}
