import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;


public class ServiciosCocinaImpl extends UnicastRemoteObject implements ServiciosRemotosCocina {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ServiciosCocinaImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void desactivarRecursos() {
		// TODO Auto-generated method stub

	}

	public Collection listaPedidosPendientes() throws errorConexionBD {
		GestorIngredienteSandwich gis=new GestorIngredienteSandwich();
		return gis.listaIngredientes();
	}

	
	public boolean marcaPedidoFinalizado(int idPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
