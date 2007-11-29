import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;


public class ServicioCocinaImpl extends UnicastRemoteObject implements ServicioRemotoCocina {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServicioCocinaImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void desactivarRecursos() {
		// TODO Auto-generated method stub

	}

	public boolean altaSandwich(Sandwich sandwich) throws errorConexionBD {
		GestorSandwich gs=new GestorSandwich();
		gs.guarda(sandwich);
		return true;
	}

	public boolean altaTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD {
		GestorTipoSandwich gts=new GestorTipoSandwich();
		gts.guarda(tipoSandwich);
		return true;
	}

	public Sandwich consultaSandwich(int idSandwich) throws errorConexionBD {
		GestorSandwich gs=new GestorSandwich();
		return gs.lee(idSandwich);
	}

	public boolean eliminaSandwich(int idSandwich) throws errorConexionBD {
		GestorSandwich gs=new GestorSandwich();
		gs.elimina(gs.lee(idSandwich));
		return true;
	}

	public Collection filtraTipoSandwich(String nombre) throws errorConexionBD {
		GestorTipoSandwich gts=new GestorTipoSandwich();
		return gts.listaPorNombre(nombre);
	}

	public Collection listaCartaSandwich() throws errorConexionBD {
		GestorSandwich gs=new GestorSandwich();
		return gs.lista();
	}

	public Collection listaPedidosPendientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection listaTipoSandwich() throws errorConexionBD {
		GestorTipoSandwich gts=new GestorTipoSandwich();
		return gts.lista();
	}

	public boolean marcaPedidoFinalizado(int idPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modificacionSandwich(Sandwich sandwich) throws errorConexionBD {
		GestorSandwich gs=new GestorSandwich();
		gs.guarda(sandwich);
		return true;
	}

	public boolean modificacionTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD {
		GestorTipoSandwich gts=new GestorTipoSandwich();
		gts.guarda(tipoSandwich);
		return true;
	}

}
