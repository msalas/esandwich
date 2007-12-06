import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Date;


public class ServiciosAdAuxModelo extends ServiciosAccesoModelo {

	ServiciosRemotosAdminAux sraa;
	
	public ServiciosAdAuxModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		sraa = (ServiciosRemotosAdminAux)Naming.lookup("rmi://localhost:1099/ServiciosAdAux");
	}

	public Empleado nuevoEmpleado(Empleado emp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Empleado pEmp = null;
		pEmp = sraa.anadirEmpleado(emp);
		return pEmp;
	}
	
	public Vector <String> listaDescRol() throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector <String> vRet = new Vector<String>();
		vRet = sraa.listaDescripcionesRol();
		return vRet;
	}
	
	public Rol RolDesc(String queRolDes) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.consultaRol_por_Desc (queRolDes);
	}
	
	public Empleado consulEmpleado(int idEmp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.consultarEmpleado(idEmp);
	}

	public void modificaEmpleado (Empleado Emp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.modEmpleado(Emp);
	}
	
	public void borrarEmpleado (Empleado Emp) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.borraEmpleado(Emp);
	}
	
	public void borraCliente(Cliente pCliente)  throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.borraCliente(pCliente);
	}
	
	public Vector <Empleado> listEmpleados(int pIdRol, String pNif, String pNombre, String pApellido1) throws errorConexionBD, errorSQL, 
	MalformedURLException, RemoteException, NotBoundException {
		return sraa.listaEmpleados(pIdRol, pNif, pNombre, pApellido1);
	}
	
	public Vector <Cliente> listClientes(int id, String pNombre, String pApellido1) throws errorConexionBD, errorSQL, 
	MalformedURLException, RemoteException, NotBoundException {
		return sraa.listaClientes(id, pNombre, pApellido1);
	}

	public Cliente consultarCliente(int id) throws errorConexionBD, errorSQL, 
	MalformedURLException, RemoteException, NotBoundException {
		return sraa.consultarCliente(id);
	}
	
	public int nuevoProducto(Producto p) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.añadirProducto(p);
	}
	
	public void eliminarProducto(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaProducto(id);
	}
	
	public Producto consultaProducto(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.consultaProducto(id);
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

	public Vector<Vector> listaProductos(int idFamilia) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Producto> p = (sraa.listaProductoPorFamilia(idFamilia)).elements() ; p.hasMoreElements() ;) {
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
	
	public boolean existeProducto(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.existeProducto(id);
	}
	
	public boolean existeFactura(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		return sraa.existeFactura(id);
	}
	
	public void nuevaFamilia(FamiliaProducto f) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.añadirFamilia(f);
	}
	
	public void eliminarFamilia(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaFamiliaProducto(id);
	}
	
	public void consultaFamilia(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.consultaFamiliaProducto(id);
	}

	public Vector<Vector> listaFamilia() throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<FamiliaProducto> p = (sraa.listaProductoPorFamilia()).elements() ; p.hasMoreElements() ;) {
					FamiliaProducto pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getIdFamilia());
					v.add(pr.getDescripcion());
					vv.add(v);
		}
	return vv;
	}
	
	public void insertarStock(int id, int unidades) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.insertarStock(id, unidades);
	}
	
	public void eliminarStock(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaStock(id);
	}
	
	public void consultaStock(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.consultaStock(id);
	}
	
	public Vector<Vector> listaStock() throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Producto> p = (sraa.listaStock()).elements() ; p.hasMoreElements() ;) {
					Producto pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getIdProducto());
					v.add(pr.getDescripcion());
					v.add(pr.getExistencias());
					vv.add(v);
		}
	return vv;
	}
	
	public Vector<Vector> listaStockPorFamilia(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Producto> p = (sraa.listaStockPorFamilia(id)).elements() ; p.hasMoreElements() ;) {
					Producto pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getIdProducto());
					v.add(pr.getDescripcion());
					v.add(pr.getExistencias());
					
					vv.add(v);
		}
	return vv;
	}
	
	public void insertarFactura(Facturacion f) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.insertarFactura(f);
	}
	
	public void eliminarFactura(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaFactura(id);
	}
	
	public void consultaFactura(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.consultaFactura(id);
	}
	
	public Vector<Vector> listaFacturas() throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Facturacion> p = (sraa.listaFacturas()).elements() ; p.hasMoreElements() ;) {
					Facturacion pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getId());
					v.add(pr.getIdPedido());
					v.add(pr.getFecha());
					v.add(pr.getImporte());
					vv.add(v);
		}
	return vv;
	}
	
	public void insertarFacturaSandwich(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.insertarFacturacionSandwich(id);
	}
	
	public void eliminarFacturaSandwich(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.eliminaFacturacionSandwich(id);
	}
	
	public void consultaFacturaSandwich(int id) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		sraa.consultaFacturacionSandwich(id);
	}
	
	
	//Suposo que NO ha d'anar així, però el metode del gestor tampoc ser com va
	public Vector<Vector> listaFacturasSandwich(int id, Date fechaDesde, Date fechaHasta) throws errorConexionBD, errorSQL, MalformedURLException, RemoteException, NotBoundException{
		Vector<Object> v;
		Vector<Vector> vv = new Vector<Vector>();
		
		for (Enumeration<Facturacion> p = (sraa.listaFacturasSandwich(id, fechaDesde, fechaHasta)).elements() ; p.hasMoreElements() ;) {
					Facturacion pr = p.nextElement();

					v = new Vector<Object>();
					v.add(pr.getId());
					v.add(pr.getIdPedido());
					v.add(pr.getFecha());
					v.add(pr.getImporte());
					vv.add(v);
		}
	return vv;
	}
	
	public boolean altaSandwich(Sandwich sandwich) throws errorConexionBD,RemoteException {
		return sraa.altaSandwich(sandwich);
	}

	public boolean altaTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD,RemoteException {
		return sraa.altaTipoSandwich(tipoSandwich);
	}

	public Sandwich consultaSandwich(int idSandwich) throws errorConexionBD,RemoteException {
	    return sraa.consultaSandwich(idSandwich);
	}

	public boolean eliminaSandwich(int idSandwich) throws errorConexionBD,RemoteException {
		return sraa.eliminaSandwich(idSandwich);
	}

	public Collection filtraTipoSandwich(String nombre) throws errorConexionBD,RemoteException {
		return sraa.filtraTipoSandwich(nombre);
	}

	public Collection listaCartaSandwich() throws errorConexionBD, RemoteException {
		return sraa.listaCartaSandwich();
	}
	
	public Collection listaTipoSandwich() throws errorConexionBD,RemoteException {
		return sraa.listaTipoSandwich();
	}

	public boolean modificacionSandwich(Sandwich sandwich) throws errorConexionBD,RemoteException {
		return sraa.modificacionSandwich(sandwich);
	}

	public boolean eliminaTipoSandwich(String nombreTipoSandwich) throws errorConexionBD,RemoteException {
		return sraa.eliminaTipoSandwich(nombreTipoSandwich);
	}
	
	public Collection listaIngredientesDisponibles() throws RemoteException, errorConexionBD{
		return sraa.listaIngredientesDisponibles();
	}
	
	public int devuelveIdTipoSandwich(String descripcion) throws RemoteException, errorConexionBD{
		return sraa.devuelveIdTipoSandwich(descripcion);
	}
	
	
	
	
	
}
