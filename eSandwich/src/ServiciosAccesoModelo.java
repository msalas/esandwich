import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServiciosAccesoModelo extends ServiciosModelo {

  ServiciosRemotosAcceso sra;

  public ServiciosAccesoModelo() throws MalformedURLException,
      RemoteException, NotBoundException {

    sra = (ServiciosRemotosAcceso) Naming
        .lookup("rmi://localhost:1099/ServiciosAcceso");

  }

  public ServiciosModelo login(String usuario, String password,
      boolean isCliente) throws errorConexionBD, errorSQL,
      MalformedURLException, RemoteException, NotBoundException {
    System.out.println("ServiciosAccesoModelo.login()");
    Usuario u;
    ServiciosModelo s = null;

    System.out.println("Ejecutando ServiciosRemotosAcceso.login()");
    u = sra.login(usuario, password, isCliente);

    if (u instanceof Empleado) {
      System.out.println("Usuario es empleado");
      Empleado e = (Empleado) u;
      if (e.getRol().equals("Cocina")) {
        System.out.println("Rol: Cocina");
        s = new ServiciosCocinaModelo();
      } else if (e.getRol().equals("AdAux")) {
        System.out.println("Rol: AdAux");
        s = new ServiciosAdAuxModelo();
      } else
        ;

    } else { // es cliente (registrado)
      s = new ServiciosCompradorRegistradoModelo();
    }

    return s;

  }

}
