import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;


public class ServiciosCocinaModelo extends ServiciosAccesoModelo {

	ServicioRemotoCocina src;
	
	public ServiciosCocinaModelo() throws MalformedURLException,
			RemoteException, NotBoundException {
		super();
		src = (ServicioRemotoCocina)Naming.lookup("rmi://localhost:1099/ServiciosCocina");
	}
	
	public boolean altaSandwich(Sandwich sandwich) throws errorConexionBD {
		return src.altaSandwich(sandwich);
	}

	public boolean altaTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD {
		return src.altaTipoSandwich(tipoSandwich);
	}

	public Sandwich consultaSandwich(int idSandwich) throws errorConexionBD {
	    return src.consultaSandwich(idSandwich);
	}

	public boolean eliminaSandwich(int idSandwich) throws errorConexionBD {
		return src.eliminaSandwich(idSandwich);
	}

	public Collection filtraTipoSandwich(String nombre) throws errorConexionBD {
		return src.filtraTipoSandwich(nombre);
	}

	public Collection listaCartaSandwich() throws errorConexionBD {
		return src.listaCartaSandwich();
	}

	public Collection listaPedidosPendientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection listaTipoSandwich() throws errorConexionBD {
		return src.listaTipoSandwich();
	}

	public boolean marcaPedidoFinalizado(int idPedido) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modificacionSandwich(Sandwich sandwich) throws errorConexionBD {
		return src.modificacionSandwich(sandwich);
	}

	public boolean modificacionTipoSandwich(TipoSandwich tipoSandwich) throws errorConexionBD {
		return src.modificacionTipoSandwich(tipoSandwich);
	}


}
