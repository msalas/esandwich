import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ControladorPantallaBajaCliente implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaBajaCliente Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null;
	private int idAux = 0;
	
	public ControladorPantallaBajaCliente(PantallaBajaCliente pModEmp, AplicacionEmpleado ae) {
		Pe = pModEmp;	
		this.ae = ae;
	}

	public void consulta(int idReg) {
		Cliente cliP;
		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			cliP = scrm.consultarCliente(idReg);
			idAux = cliP.getId();
			Pe.entraCampos(cliP);
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
		
		
		Cliente cli = null;
			
		Pe.montaCliente();		
		cli = Pe.getCli();
		
		cli.setId(idAux);

		try {
			scrm = (ServiciosAdAuxModelo) ae.getSm();
			scrm.borraCliente(cli);
			ae.setSm(scrm);
			//ae.mostrarInformacion("Baja realizada", "Clientes");
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
