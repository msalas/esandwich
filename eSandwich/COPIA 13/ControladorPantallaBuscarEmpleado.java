import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ControladorPantallaBuscarEmpleado implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaBuscarEmpleado Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null; 
	
	public ControladorPantallaBuscarEmpleado(PantallaBuscarEmpleado pBusEmp, AplicacionEmpleado ae) {
		Pe = pBusEmp;	
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
		
		String action = evt.getActionCommand();
		Rol pRol = null;
		String selecRol;
		int idRol = 0;
		int idSelec = 0;
		
		selecRol = Pe.getRolDesplegable();
		try {
			if (action.equals("BUS")) {
				scrm = (ServiciosAdAuxModelo) ae.getSm();
				if (!selecRol.isEmpty()) {
					pRol = scrm.RolDesc(selecRol);
					idRol = pRol.getId();
				}				
				Pe.setListaData(scrm.listEmpleados(idRol, Pe.getNifBusqueda(), 
						Pe.getNombreBusqueda(), Pe.getApellidoBusqueda()));
				ae.setSm(scrm);
			}
			if (action.equals("SEL")) {
				scrm = (ServiciosAdAuxModelo) ae.getSm();
				idSelec = Pe.getIdSelecTabla();
				ae.setSm(scrm);
				if (idSelec > 0) {
					if (Pe.getPantallaDestino().equals("ME")) {
						new PantallaModificacionEmpleado(ae,idSelec).setVisible(true);
					}
					if (Pe.getPantallaDestino().equals("BE")) {
						new PantallaBajaEmpleado(ae,idSelec).setVisible(true);
					}
					if (Pe.getPantallaDestino().equals("CE")) {
						new PantallaConsultaEmpleado(ae,idSelec).setVisible(true);
					}
					Pe.dispose();
				}
			}
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
