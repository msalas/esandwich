import java.rmi.RemoteException;
import java.util.Vector;


public interface ServiciosRemotosAdminAux extends ServiciosRemotos {
	
	public int anadirEmpleado (Empleado e) throws errorSQL, 
	errorConexionBD,RemoteException;

	public int añadirProducto (Producto p) throws errorSQL, errorConexionBD,
	RemoteException;
	
	public int eliminarProducto (int idProducto) throws errorSQL, errorConexionBD,
	RemoteException;

	public int consultaProducto (int idProducto) throws errorSQL, errorConexionBD,
	RemoteException;
	
	public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD;
	
	public Vector<Producto> listaProductoPorFamilia(int idFamilia) throws errorSQL, errorConexionBD;
	
	
}
