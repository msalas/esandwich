import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ControladorPantallaModificacionEmpleado implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaModificacionEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null;
	private int idAux = 0;
	private Rol rolAux = null;
	
	public ControladorPantallaModificacionEmpleado(PantallaModificacionEmpleado pModEmp, AplicacionEmpleado ae) {
		Pe = pModEmp;	
		this.ae = ae;
	}

	public void consulta(int idReg) {
		Empleado empP;
		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			empP = scrm.consulEmpleado(idReg);
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
		
		
		Empleado emp = null;
			
		Pe.montaEmpleado();		
		emp = Pe.getEmp();
		
		emp.setId(idAux);
		emp.setRol(rolAux);

		if (Pe.isIgualesPasswords() == false) {
			ae.mostrarError("Las contraseñas no coinciden","Error Contraseñas");
		} else {
			try {
				scrm = (ServiciosAdAuxModelo) ae.getSm();
				scrm.modificaEmpleado(emp);
				ae.setSm(scrm);
				//ae.mostrarInformacion("Modificacion realizada", "Empleados");
				Pe.dispose();
			}catch (MalformedURLException e) {
				ae.mostrarError(e.getMessage(),"Error Url");
			} catch (RemoteException e) {
				ae.mostrarError(e.getMessage(),"Error remoto");
			} catch (errorConexionBD e) {
				ae.mostrarError(e.getMessage(), "Error de conexion con la Base de Datos");
			} catch (errorSQL e) {
				ae.mostrarError(e.getMessage(),"Error de sql");
			} catch (NotBoundException e) {
				ae.mostrarError(e.getMessage(),"Error de servicios");
			} catch (Exception e) {
				ae.mostrarError(e.getMessage(),"Error general");
			}				 
		}
		
	}

	

}
