import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaAltaEmpleado implements ActionListener {
	PantallaAltaEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null;  //  @jve:decl-index=0:

	public ControladorPantallaAltaEmpleado(PantallaAltaEmpleado pAltEmp, AplicacionEmpleado ae) {
		Pe = pAltEmp;	
		this.ae = ae;			
	}

	public void actionPerformed(ActionEvent evt)  {
		
		Empleado emp = null;
		String action = evt.getActionCommand();
		
		
		if(action.equals("ARX")){		
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			Pe.montaEmpleado();
			emp = Pe.getEmp();
			try {
				scrm =  (ServiciosAdAuxModelo) scrm.nuevoEmpleado(emp);
				ae.setSm(scrm);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (errorConexionBD e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (errorSQL e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Pe.getJButtonCancellar(); 
		}
	
	}

}
