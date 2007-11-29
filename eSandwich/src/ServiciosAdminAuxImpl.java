import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Vector;


public class ServiciosAdminAuxImpl extends UnicastRemoteObject 
implements ServiciosRemotosAdminAux {
	private static final long serialVersionUID = 1L;

	GestorEmpleado ge;
	GestorProducto gp;
	GestorFamiliaProd gfp;
	GestorStock gs;
	GestorFacturacion gf;
	GestorFacturacionSandwich gfs;
	
	public ServiciosAdminAuxImpl() throws errorConexionBD,
	RemoteException {
		try {
			ge = new GestorEmpleado();
			gp = new GestorProducto();
			gfp = new GestorFamiliaProd();
			gs = new GestorStock();
			gf = new GestorFacturacion();
			gfs = new GestorFacturacionSandwich();
		}
		catch (errorConexionBD e) {
			throw new errorConexionBD(e.getMessage());
		}
		
	}
	
	public int anadirEmpleado (Empleado e) throws errorSQL, errorConexionBD,
	RemoteException {
		int idAux = 0;
		try {
			if (!ge.existeNif(e.getNif())) {
				idAux = ge.addEmpleado(e);
			}
			else {
				throw new errorSQL("ERROR: Nif existente en empleados");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idAux;
	}
	
	public int añadirProducto (Producto p) throws errorSQL, errorConexionBD,
	RemoteException {
		int idP = 0;
		try {
			if (!gp.existeProducto(p.getIdProducto())) {
				idP = gp.insertarProducto(p);
			}
			else {
				throw new errorSQL("ERROR: Producto existente");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int eliminarProducto (int idProducto) throws errorSQL, errorConexionBD,
	RemoteException {
		int idP = idProducto;
		try {
			gp.eliminaProducto(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int consultaProducto (int idProducto) throws errorSQL, errorConexionBD,
	RemoteException {
		int idP = idProducto;
		try {
			gp.consultaProducto(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD{
		return gp.listaProductos();	
	}
	
	public Vector<Producto> listaProductoPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		return gp.listaProductoPorFamilia(idFamilia);
	}
	
	
	
	public void desactivarRecursos() {
		ge.liberarRecursos();
	}
	
}
