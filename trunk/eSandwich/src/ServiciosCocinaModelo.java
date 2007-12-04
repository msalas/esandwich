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
	
	

	public Collection listaPedidosPendientes() throws errorConexionBD,RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean marcaPedidoFinalizado(int idPedido) throws errorConexionBD,RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	
	@SuppressWarnings("deprecation")
	public static void main(String[]arg) throws MalformedURLException, RemoteException, NotBoundException, errorConexionBD{
		ServiciosCocinaModelo scm=new ServiciosCocinaModelo();
		TipoSandwich ts=new TipoSandwich();
		ts.setId(2001);
		ts.setDescripcion("tipo1");
		ts.setFechaBaja(new java.sql.Date(2007,11,11));
	//	scm.altaTipoSandwich(ts);
	}


}
