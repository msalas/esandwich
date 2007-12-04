import java.rmi.RemoteException;


public abstract class ServiciosModelo {

	 Usuario u;
	 
	 public Usuario getU() {
		    return u;
	 }

	 public void setU(Usuario u) throws RemoteException, errorConexionBD,
		      errorSQL {
		    System.out.println("ServiciosAccesoModelo.setU()");
		   // sra.setUsuario(u);
		     this.u = u;

	  }

}
