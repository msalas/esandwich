import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ControladorPantallaConsultaEmpleado implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaConsultaEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null;
	private int idAux = 0;
	private Rol rolAux = null;
	
	public ControladorPantallaConsultaEmpleado(PantallaConsultaEmpleado pModEmp, AplicacionEmpleado ae) {
		Pe = pModEmp;	
		this.ae = ae;
	}

	public void consulta() {
		Empleado empP;
		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			empP = scrm.consulEmpleado(1);
			idAux = empP.getId();
			rolAux = empP.getRol();
			Pe.entraCampos(empP);
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
		
		
	}

	

}
