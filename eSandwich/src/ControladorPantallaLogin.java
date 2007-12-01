import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorPantallaLogin implements ActionListener {

  PantallaLogin         pl = null;
  AplicacionComprador   ac = null;
  AplicacionEmpleado    ae = null;
  ServiciosAccesoModelo sm = null;

  // ServiciosCompradorModelo scrm2 = null;

  public ControladorPantallaLogin(PantallaLogin pantallaLogin, Aplicacion ap) {

    if (ap instanceof AplicacionComprador) {
      System.out.println("Llamada desde aplicacionComprador");
      ac = (AplicacionComprador) ap;

    } else if (ap instanceof AplicacionEmpleado) {
      System.out.println("Llamada desde AplicacionEmpleado");
      ae = (AplicacionEmpleado) ap;
    }

    pl = pantallaLogin;

  }

  public void actionPerformed(ActionEvent arg0) {

    // Se ha pulsado boton para hacer login

    try {
      // Aplicacion Comprador
      if (ac != null) {
        System.out.println("Obteniendo ServiciosCompradorModelo");
        sm = (ServiciosCompradorModelo) ac.getSm();
        System.out.println("Realizando login");
        sm = (ServiciosCompradorModelo) sm.login((pl.getTxtCUsuario())
            .getText(), (pl.getTxtPassword()).getText(), true);
        
        ac.setSm((ServiciosCompradorRegistradoModelo)sm);
        System.out.println("Mostrando menu de usuario registrado");
        ac.setMenuRegistrado();

      } else {
        System.out.println("***\nObteniendo serviciosAdAuxModelo");
//        sm = (ServiciosAdAuxModelo) ac.getSm();
//        System.out.println("Realizando login");
//        sm = (ServiciosAdAuxModelo) sm.login((pl.getTxtCUsuario()).getText(),
//            (pl.getTxtPassword()).getText(), false);
//        ae.setSm(sm);
      }

      // Actualizamos los servicios de la aplicacion a cliente registrado
      pl.setVisible(false);

    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (errorConexionBD e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (errorSQL e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}

