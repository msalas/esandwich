import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;


public class ServiciosCocinaModelo extends ServiciosAccesoModelo {

	ServiciosRemotosCocina src;
	
	public ServiciosCocinaModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		src = (ServiciosRemotosCocina)Naming.lookup("rmi://localhost:1099/ServiciosCocina");
	}
	
	public boolean altaSandwich(Sandwich sandwich) throws errorConexionBD,RemoteException {
		return src.altaSandwich(sandwich);
	}

	public boolean altaTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD,RemoteException {
		return src.altaTipoSandwich(tipoSandwich);
	}

	public Sandwich consultaSandwich(int idSandwich) throws errorConexionBD,RemoteException {
	    return src.consultaSandwich(idSandwich);
	}

	public boolean eliminaSandwich(int idSandwich) throws errorConexionBD,RemoteException {
		return src.eliminaSandwich(idSandwich);
	}

	public Collection filtraTipoSandwich(String nombre) throws errorConexionBD,RemoteException {
		return src.filtraTipoSandwich(nombre);
	}

	public Collection listaCartaSandwich() throws errorConexionBD, RemoteException {
		return src.listaCartaSandwich();
	}

	public Collection listaPedidosPendientes() throws errorConexionBD,RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public Collection listaTipoSandwich() throws errorConexionBD,RemoteException {
		return src.listaTipoSandwich();
	}

	public boolean marcaPedidoFinalizado(int idPedido) throws errorConexionBD,RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modificacionSandwich(Sandwich sandwich) throws errorConexionBD,RemoteException {
		return src.modificacionSandwich(sandwich);
	}

	public boolean eliminaTipoSandwich(String nombreTipoSandwich) throws errorConexionBD,RemoteException {
		return src.eliminaTipoSandwich(nombreTipoSandwich);
	}
	
	public Collection listaIngredientesDisponibles() throws RemoteException, errorConexionBD{
		return src.listaIngredientesDisponibles();
	}
	
	public int devuelveIdTipoSandwich(String descripcion) throws RemoteException, errorConexionBD{
		return src.devuelveIdTipoSandwich(descripcion);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[]arg) throws MalformedURLException, RemoteException, NotBoundException, errorConexionBD{
		ServiciosCocinaModelo scm=new ServiciosCocinaModelo();
		TipoSandwich ts=new TipoSandwich();
		ts.setId(2001);
		ts.setDescripcion("tipo1");
		ts.setFechaBaja(new java.sql.Date(2007,11,11));
		scm.altaTipoSandwich(ts);
	}


}
