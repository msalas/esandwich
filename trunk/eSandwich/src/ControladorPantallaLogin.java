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
        System.out.println("***\nObteniendo serviciosAccesoModelo");
      
        sm = (ServiciosAccesoModelo) ae.getSm();
        System.out.println("Realizando login");
        sm = (ServiciosAccesoModelo) sm.login((pl.getTxtCUsuario()).getText(),
            (pl.getTxtPassword()).getText(), false);
        
        if (sm instanceof ServiciosAdAuxModelo) {
					ae.setMenuAdAux();
		}else if(sm instanceof ServiciosCocinaModelo) {
			ae.setMenuCocina();	
		}else{
			System.out.println("Que servicios tenemos?");
		}
        
        ae.setSm(sm);
      }

      // Actualizamos los servicios de la aplicacion a cliente registrado
      pl.setVisible(false);

    } catch (MalformedURLException e) {
    	ae.mostrarError(e.getMessage(), "URL incorrecta");
    } catch (RemoteException e) {
    	ae.mostrarError(e.getMessage(), "Excepcion remota");
    } catch (errorConexionBD e) {
    	ae.mostrarError(e.getMessage(), "Error BD");
    } catch (errorSQL e) {
    	ae.mostrarError(e.getMessage(), "Error SQL");
    } catch (NotBoundException e) {
    	ae.mostrarError(e.getMessage(), "Error de servicios");
    }catch (Exception e) {
    	ae.mostrarError(e.getMessage(), "Error aplicacion");
	}

  }

}

