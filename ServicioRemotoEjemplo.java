import java.rmi.RemoteException;
import java.util.Vector;


public interface ServicioRemotoEjemplo extends ServicioRemoto{

	public Vector<Ejemplo> listaEjemplos() throws errorSQL, errorConexionBD, RemoteException;
	public String insertarEjemplo(Ejemplo ej) throws errorSQL, errorConexionBD, RemoteException;
	
}
