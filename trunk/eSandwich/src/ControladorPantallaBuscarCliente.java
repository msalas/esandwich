import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;



public class ControladorPantallaBuscarCliente implements ActionListener {
	private static final long serialVersionUID = 1L;
	PantallaBuscarCliente Pe;
	AplicacionEmpleado ae = null;
	ServiciosAdAuxModelo scrm = null; 
	
	public ControladorPantallaBuscarCliente(PantallaBuscarCliente pBusCli, AplicacionEmpleado ae) {
		Pe = pBusCli;	
		this.ae = ae;
	}
	

	public void actionPerformed(ActionEvent evt)  {
		
		String action = evt.getActionCommand();
		int idSelec = 0;
		int numCod = 0;		
		try {
			numCod = Util.getNumDeCodigo(Pe.getCodClienteBusqueda());
			if (action.equals("BUS")) {
				scrm = (ServiciosAdAuxModelo) ae.getSm();				
				Pe.setListaData(scrm.listClientes(numCod, 
						Pe.getNombreBusqueda(), Pe.getApellidoBusqueda()));
				ae.setSm(scrm);
			}
			if (action.equals("SEL")) {
				scrm = (ServiciosAdAuxModelo) ae.getSm();
				idSelec = Pe.getIdSelecTabla();
				ae.setSm(scrm);
				if (idSelec > 0) {
					if (Pe.getPantallaDestino().equals("BC")) {
						new PantallaBajaCliente(ae,idSelec).setVisible(true);
					}
					if (Pe.getPantallaDestino().equals("CC")) {
						new PantallaConsultaCliente(ae,idSelec).setVisible(true);
					}
					Pe.setListaData(scrm.listClientes(numCod, 
							Pe.getNombreBusqueda(), Pe.getApellidoBusqueda()));
				}
				Pe.setIdSelecTabla(0);
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
