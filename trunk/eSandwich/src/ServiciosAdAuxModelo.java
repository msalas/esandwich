import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;


public class ServiciosAdAuxModelo extends ServiciosAccesoModelo {

	ServiciosRemotosAdminAux sraa;
	
	public ServiciosAdAuxModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		sraa = (ServiciosRemotosAdminAux)Naming.lookup("rmi://localhost:1099/ServiciosAdAux");
	}

	public void nuevoEmpleado(Empleado emp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		
		
		sraa.anadirEmpleado(emp);
		
		
	}
	
	public void nuevoProducto(Producto p) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.añadirProducto(p);
	}
	
	public void eliminarProducto(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaProducto(id);
	}
	
	public void consultaProducto(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.consultaProducto(id);
	}

	public Vector<Vector> listaProductos() throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Producto> p = (sraa.listaProductos()).elements() ; p.hasMoreElements() ;) {
					Producto pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getIdProducto());
					v.add(pr.getDescripcion());
					v.add(pr.getDescripcionAmpliada());
					v.add(pr.getIdFamilia());
					v.add(pr.getExistencias());
					v.add(pr.getPrecio());
					vv.add(v);
		}
		
		return vv;
	}

}
