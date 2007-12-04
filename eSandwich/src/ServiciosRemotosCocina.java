import java.rmi.RemoteException;
import java.util.Collection;


public interface ServiciosRemotosCocina extends ServiciosRemotos {
	
	public Collection listaPedidosPendientes()throws errorConexionBD,RemoteException;
	public boolean marcaPedidoFinalizado(int idPedido)throws errorConexionBD,RemoteException;
	

}
