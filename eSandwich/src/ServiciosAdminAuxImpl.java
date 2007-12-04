import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;


public class ServiciosAdminAuxImpl extends UnicastRemoteObject 
implements ServiciosRemotosAdminAux {
	private static final long serialVersionUID = 1L;

	GestorEmpleado ge;
	GestorCliente gc;
	GestorProducto gp;
	GestorFamiliaProd gfp;
	GestorStock gs;
	GestorFacturacion gf;
	GestorFacturacionSandwich gfs;
	GestorRol gr;
	
	public ServiciosAdminAuxImpl() throws errorConexionBD,
	RemoteException {
		try {
			ge = new GestorEmpleado();
			gc = new GestorCliente();
			gp = new GestorProducto();
			gfp = new GestorFamiliaProd();
			gs = new GestorStock();
			gf = new GestorFacturacion();
			gfs = new GestorFacturacionSandwich();
			gr = new GestorRol();
		}
		catch (errorConexionBD e) {
			throw new errorConexionBD(e.getMessage());
		}
		
	}
	
	public void borraEmpleado(Empleado pEmpleado) throws errorSQL, 
	errorConexionBD, RemoteException {
		ge.eliminaEmpleado(pEmpleado);
	}
	
	
	public Empleado anadirEmpleado (Empleado e) throws errorSQL, errorConexionBD,
	RemoteException {
		Empleado emp = null;
		try {

			if (!ge.existeNif(e.getNif(),e.getId())) {
				emp = ge.addEmpleado(e);
			} else {
				throw new errorSQL("ERROR: Nif existente en empleados");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return emp;
	}
	
	public void modEmpleado (Empleado e) throws errorSQL, errorConexionBD,
	RemoteException {
		try {
			if (!ge.existeNif(e.getNif(),e.getId())) {
				ge.setEmpleado(e);
			} else {
				throw new errorSQL("ERROR: Nif existente en empleados");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
	}

	
	public Vector  <String>  listaDescripcionesRol() throws errorSQL, errorConexionBD,
	RemoteException {
		Vector v = new Vector();
		Vector  <String> vRet = new Vector <String> ();
		try {
			v = gr.lista();
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		vRet.add(""); // Se añade blanco para poder hacer búsquedas sin tener en cuenta ROL
		for (int i=0;i<v.size();i++){
			Rol rolT=(Rol)v.get(i);
			String desc = rolT.getDescripcion();
			vRet.add(desc);			
		}
		return vRet;
	}

	public Vector <Cliente> listaClientes(int id, String pNombre, String pApellido1) throws 
	errorSQL, errorConexionBD,RemoteException {
		Vector<Cliente> v;
		try {
			
			v = gc.lista(id, pNombre, pApellido1);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		
		return v;		
	}

	public Cliente consultarCliente(int id) throws errorSQL, errorConexionBD,RemoteException {
		Cliente pCli;
		try {
			pCli= gc.getCliente(id);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return pCli;	
		
	}
	
	public Vector <Empleado> listaEmpleados(int pIdRol, String pNif, String pNombre, String pApellido1) throws errorSQL, errorConexionBD,	
	RemoteException {
		Vector<Empleado> v;

		try {
			v = ge.lista(pIdRol, pNif, pNombre, pApellido1);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		
		return v;
	}

	public Rol consultaRol_por_Desc(String pDescripcion) throws errorSQL, errorConexionBD,
	RemoteException {
		Rol pRol;
		try {
			pRol = gr.consultaRolDescripcion(pDescripcion);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return pRol;
		
	}
	
	public Empleado consultarEmpleado(int pId) throws errorSQL, errorConexionBD,
	RemoteException {
		Empleado pEmp;
		try {
			pEmp= ge.consultaEmpleado(pId);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return pEmp;		
	}

	public void borraCliente(Cliente pCliente) throws errorSQL, 
	errorConexionBD, RemoteException {
		gc.elimina(pCliente);
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
	
	public int eliminaProducto (int idProducto) throws errorSQL, errorConexionBD,
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
	
	public Producto consultaProducto (int idProducto) throws errorSQL, errorConexionBD,
	RemoteException {
		
		return gp.consultaProducto(idProducto);
	}
	
	public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD{
		return gp.listaProductos();	
	}
	
	public Vector<Producto> listaProductoPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		return gp.listaProductoPorFamilia(idFamilia);
	}
	
//	public boolean existeProducto(int id) throws errorSQL, errorConexionBD, RemoteException{
//		return gp.existeProducto(id);
//	}
	
//	public boolean existeFactura(int id) throws errorSQL, errorConexionBD, RemoteException{
//		return gf.existeFactura(id);
//	}
	
	public boolean existeProducto(int id) throws errorSQL, errorConexionBD, RemoteException{
		return gp.existeProducto(id);
	}
	
	public boolean existeFactura(int id) throws errorSQL, errorConexionBD, RemoteException{
		return gf.existeFactura(id);
	}
	

	public int añadirFamilia(FamiliaProducto fp) throws errorSQL, errorConexionBD,
	RemoteException {
		int idP = 0;
		try {
			if (!gfp.existeFamilia(fp.getIdFamilia())) {
				idP = gfp.insertarFamiliaProducto(fp);
			}
			else {
				throw new errorSQL("ERROR: Familia existente");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int eliminaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {
		int idP = idFamilia;
		try {
			gfp.eliminaFamiliaProducto(idFamilia);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int consultaFamiliaProducto(int idFamilia) throws errorSQL, errorConexionBD {
		int idP = idFamilia;
		try {
			gfp.consultaFamiliaProducto(idFamilia);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public Vector<FamiliaProducto> listaProductoPorFamilia() throws errorSQL, errorConexionBD{
		return gfp.listaProductoPorFamilia();
	}
	
	public int eliminaStock(int idProducto) throws errorSQL, errorConexionBD {
		int idP = idProducto;
		try {
			gs.eliminaStock(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int consultaStock(int idProducto) throws errorSQL, errorConexionBD {
		int idP = idProducto;
		try {
			gs.consultaStock(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int insertarStock(int idProducto, int unidades) throws errorSQL, errorConexionBD {
		int idP = idProducto;
		try {
			gs.insertarStock(idProducto, unidades);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public Vector<Producto> listaStock() throws errorSQL, errorConexionBD{
		return gs.listaStock();
	}
	
	public Vector<Producto> listaStockPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		return gs.listaStockPorFamilia(idFamilia);
	}
	
	public int insertarFactura(Facturacion f) throws errorSQL, errorConexionBD {
		int idAux=0;
		try {
				idAux = gf.insertarFactura(f);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idAux;
	}
	
	public Vector<Facturacion> listaFacturas() throws errorSQL, errorConexionBD{
		return gf.listaFacturas();
	}
	
	public int eliminaFactura(int idFactura) throws errorSQL, errorConexionBD {
		int idP = idFactura;
		try {
			gf.eliminaFactura(idFactura);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int consultaFactura(int idFactura) throws errorSQL, errorConexionBD {
		int idP = idFactura;
		try {
			gf.consultaFactura(idFactura);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public Vector<Facturacion> listaFacturasSandwich(int id, Date fechaDesde, Date fechaHasta) throws errorSQL, errorConexionBD{
		return gfs.listaFacturasSandwich(id, fechaDesde, fechaHasta);
	}
	
	public int consultaFacturacionSandwich(int idProducto) throws errorSQL, errorConexionBD {
		int idP = idProducto;
		try {
			gfs.consultaFacturacionSandwich(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int eliminaFacturacionSandwich(int idProducto) throws errorSQL, errorConexionBD {
		int idP = idProducto;
		try {
			gfs.eliminaFacturacionSandwich(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public int insertarFacturacionSandwich (int idProducto) throws errorSQL, errorConexionBD{
		int idP = idProducto;
		try {
			gfs.insertarFacturacionSandwich(idProducto);
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return idP;
	}
	
	public void desactivarRecursos() {
		ge.liberarRecursos();
		gc.liberarRecursos();
		gp.liberarRecursos();
		gfp.liberarRecursos();
		gs.liberarRecursos();
		gfs.liberarRecursos();
		gf.liberarRecursos();
		gr.liberarRecursos();
	}
	
}
