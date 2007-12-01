import java.rmi.RemoteException;
import java.util.Date;
import java.util.Vector;

public interface ServiciosRemotosAdminAux extends ServiciosRemotos {

  public int anadirEmpleado(Empleado e) throws errorSQL, errorConexionBD,
      RemoteException;

  public Vector listaDescripcionesRol() throws errorSQL, errorConexionBD,
	RemoteException;
  
  public int añadirProducto(Producto p) throws errorSQL, errorConexionBD,
      RemoteException;

  public int eliminaProducto(int idProducto) throws errorSQL, errorConexionBD,
      RemoteException;

  public int consultaProducto(int idProducto) throws errorSQL,
      errorConexionBD, RemoteException;

  public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD,
      RemoteException;

  public Vector<Producto> listaProductoPorFamilia(int idFamilia)
      throws errorSQL, errorConexionBD, RemoteException;

  public int añadirFamilia(FamiliaProducto fp) throws errorSQL,
      errorConexionBD, RemoteException;

  public int eliminaFamiliaProducto(int idFamilia) throws errorSQL,
      errorConexionBD, RemoteException;

  public int consultaFamiliaProducto(int idFamilia) throws errorSQL,
      errorConexionBD, RemoteException;

  public Vector<FamiliaProducto> listaProductoPorFamilia() throws errorSQL,
      errorConexionBD, RemoteException;

  public int eliminaStock(int idProducto) throws errorSQL, errorConexionBD,
      RemoteException;

  public int consultaStock(int idProducto) throws errorSQL, errorConexionBD,
      RemoteException;

  public int insertarStock(int idProducto, int unidades) throws errorSQL,
      errorConexionBD, RemoteException;

  public Vector<Producto> listaStock() throws errorSQL, errorConexionBD,
      RemoteException;

  public Vector<Producto> listaStockPorFamilia(int idFamilia) throws errorSQL,
      errorConexionBD, RemoteException;

  public int insertarFactura(Facturacion f) throws errorSQL, errorConexionBD,
      RemoteException;

  public Vector<Facturacion> listaFacturas() throws errorSQL, errorConexionBD,
      RemoteException;

  public int eliminaFactura(int idFactura) throws errorSQL, errorConexionBD,
      RemoteException;

  public int consultaFactura(int idFactura) throws errorSQL, errorConexionBD,
      RemoteException;

  public Vector<Facturacion> listaFacturasSandwich(int id, Date fechaDesde,
      Date fechaHasta) throws errorSQL, errorConexionBD, RemoteException;

  public int consultaFacturacionSandwich(int idProducto) throws errorSQL,
      errorConexionBD, RemoteException;

  public int eliminaFacturacionSandwich(int idProducto) throws errorSQL,
      errorConexionBD, RemoteException;

  public int insertarFacturacionSandwich(int idProducto) throws errorSQL,
      errorConexionBD, RemoteException;

}
