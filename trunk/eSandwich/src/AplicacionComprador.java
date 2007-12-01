import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JMenu;

// Falta cambiar los comentarios 
public class AplicacionComprador extends JFrame implements Aplicacion{

  private static final long              serialVersionUID      = 1L;

  private JPanel                         jContentPane          = null;
  private JMenuBar                       jbarramenu            = null;
  private JMenu                          jLogin                = null;
  private JMenuItem                      jIniciarSesion        = null;
  private JMenu                          jLogout               = null;
  private JMenuItem                      jCerrarSesion         = null;
  private JMenu                          jRegistro             = null;
  private JMenuItem                      jAltaRegistro         = null;
  private JMenu                          jDatosPersonales      = null;
  private JMenuItem                      jConsultarDP          = null;
  private JMenuItem                      jModificarDP          = null;
  private JMenu                          jPromociones          = null;
  private JMenuItem                      jPromocionesPanel     = null;
  private JMenuItem                      jPromocionesPuntos    = null;
  private JMenuItem                      jPromocionesSeleccion = null;
  private JMenu                          jPedido               = null;
  private JMenuItem                      jRealizarPedido       = null;

  private ServiciosModelo                sm                    = null;
  private ControladorAplicacionComprador cac                   = null;

  /**
   * This is the default constructor
   */

  public AplicacionComprador() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(536, 362);
    this.setJMenuBar(getJbarramenu());
    this.setContentPane(getJContentPane());
    this.setTitle("eSandvitx");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    // Inicializamos modelo

    try {
      sm = new ServiciosCompradorModelo();

    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (RemoteException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Inicializamos controlador para acciones del menu

    cac = new ControladorAplicacionComprador(this);

    jIniciarSesion.setActionCommand("IS");
    jIniciarSesion.addActionListener(cac);

    jCerrarSesion.setActionCommand("CS");
    jCerrarSesion.addActionListener(cac);

    jAltaRegistro.setActionCommand("AR");
    jAltaRegistro.addActionListener(cac);

    jConsultarDP.setActionCommand("CDP");
    jConsultarDP.addActionListener(cac);

    jModificarDP.setActionCommand("MDP");
    jModificarDP.addActionListener(cac);

    jPromocionesPanel.setActionCommand("PPa");
    jPromocionesPanel.addActionListener(cac);

    jPromocionesPuntos.setActionCommand("PPu");
    jPromocionesPuntos.addActionListener(cac);

    jPromocionesSeleccion.setActionCommand("PS");
    jPromocionesSeleccion.addActionListener(cac);

    jRealizarPedido.setActionCommand("RP");
    jRealizarPedido.addActionListener(cac);

    // Desactivamos menus para cliente no registrado

    this.setMenuNoRegistrado();

  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
    }
    return jContentPane;
  }

  /**
   * This method initializes jbarramenu
   * 
   * @return javax.swing.JMenuBar
   */
  private JMenuBar getJbarramenu() {
    if (jbarramenu == null) {
      jbarramenu = new JMenuBar();
      jbarramenu.add(getJLogin());
      jbarramenu.add(getJLogout());
      jbarramenu.add(getJRegistro());
      jbarramenu.add(getJDatosPersonales());
      jbarramenu.add(getJPromociones());
      jbarramenu.add(getJPedido());
    }
    return jbarramenu;
  }

  /**
   * This method initializes jlogin
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJLogin() {
    if (jLogin == null) {
      jLogin = new JMenu();
      jLogin.setText("Login");
      jLogin.add(getJIniciarSesion());
    }
    return jLogin;
  }

  /**
   * This method initializes jMenuItemIniciSesion
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJIniciarSesion() {
    if (jIniciarSesion == null) {
      jIniciarSesion = new JMenuItem();
      jIniciarSesion.setText("Iniciar Sesión");
    }
    return jIniciarSesion;
  }

  /**
   * This method initializes jLogout
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJLogout() {
    if (jLogout == null) {
      jLogout = new JMenu();
      jLogout.setText("Logout");
      jLogout.add(getJCerrarSesion());
    }
    return jLogout;
  }

  /**
   * This method initializes jCerrarSesion
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJCerrarSesion() {
    if (jCerrarSesion == null) {
      jCerrarSesion = new JMenuItem();
      jCerrarSesion.setText("Cerrar Sesión");
    }
    return jCerrarSesion;
  }

  /**
   * This method initializes jRegistre
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJRegistro() {
    if (jRegistro == null) {
      jRegistro = new JMenu();
      jRegistro.setText("Registro");
      jRegistro.add(getJAltaRegistro());
    }
    return jRegistro;
  }

  /**
   * This method initializes jMenuItemAlta
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJAltaRegistro() {
    if (jAltaRegistro == null) {
      jAltaRegistro = new JMenuItem();
      jAltaRegistro.setText("Alta");
    }
    return jAltaRegistro;
  }

  /**
   * This method initializes jDadesPersonals
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJDatosPersonales() {
    if (jDatosPersonales == null) {
      jDatosPersonales = new JMenu();
      jDatosPersonales.setText("Dades Personals");
      jDatosPersonales.add(getJConsultarDP());
      jDatosPersonales.add(getJModificarDP());
    }
    return jDatosPersonales;
  }

  /**
   * This method initializes jMenuItemConsulta
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJConsultarDP() {
    if (jConsultarDP == null) {
      jConsultarDP = new JMenuItem();
      jConsultarDP.setText("Consulta");
    }
    return jConsultarDP;
  }

  /**
   * This method initializes jMenuItemModificar
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJModificarDP() {
    if (jModificarDP == null) {
      jModificarDP = new JMenuItem();
      jModificarDP.setText("Modificar");
    }
    return jModificarDP;
  }

  /**
   * This method initializes jPromocions
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJPromociones() {
    if (jPromociones == null) {
      jPromociones = new JMenu();
      jPromociones.setText("Promocions");
      jPromociones.add(getJPromocionesPanel());
      jPromociones.add(getJPromocionesPuntos());
      jPromociones.add(getJPromocionesSeleccion());
    }
    return jPromociones;
  }

  /**
   * This method initializes jMenuItemPromocionsPanell
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJPromocionesPanel() {
    if (jPromocionesPanel == null) {
      jPromocionesPanel = new JMenuItem();
      jPromocionesPanel.setText("Panel Promociones");
    }
    return jPromocionesPanel;
  }

  /**
   * This method initializes jMenuItemePunts
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJPromocionesPuntos() {
    if (jPromocionesPuntos == null) {
      jPromocionesPuntos = new JMenuItem();
      jPromocionesPuntos.setText("Consulta ePunts");
    }
    return jPromocionesPuntos;
  }

  /**
   * This method initializes jMenuItemPromocions
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJPromocionesSeleccion() {
    if (jPromocionesSeleccion == null) {
      jPromocionesSeleccion = new JMenuItem();
      jPromocionesSeleccion.setText("Promocions");
    }
    return jPromocionesSeleccion;
  }

  /**
   * This method initializes jComandes
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJPedido() {
    if (jPedido == null) {
      jPedido = new JMenu();
      jPedido.setText("Comandes");
      jPedido.add(getJRealizarPedido());
    }
    return jPedido;
  }

  /**
   * This method initializes jRealitcomandes
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJRealizarPedido() {
    if (jRealizarPedido == null) {
      jRealizarPedido = new JMenuItem();
      jRealizarPedido.setText("Realizar pedido");
    }
    return jRealizarPedido;
  }

  public ServiciosModelo getSm() {
    return sm;
  }

  public void setSm(ServiciosModelo sm) {
    this.sm = sm;
  }

  public void setMenuRegistrado() {
    // Mostramos ...
    jLogout.setVisible(true);
    jDatosPersonales.setVisible(true);
    jPromociones.setVisible(true);
    jPedido.setVisible(true);

    // No mostramos
    jLogin.setVisible(false);
    jRegistro.setVisible(false);

  }

  public void setMenuNoRegistrado() {

    // Mostramos ...
    jLogin.setVisible(true);
    jRegistro.setVisible(true);
    jPedido.setVisible(true);

    // No mostramos
    jLogout.setVisible(false);
    jDatosPersonales.setVisible(false);
    jPromociones.setVisible(false);

  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        AplicacionComprador app = new AplicacionComprador();
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    });
  }


public int confirmacio(String mensaje, String titulo) {
	return JOptionPane.showConfirmDialog(null,mensaje,titulo, JOptionPane.YES_NO_OPTION);
	
}


public void mostrarError(String mensaje, String titulo) {
	JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	
}


public void mostrarInformacion(String mensaje, String titulo) {
	 JOptionPane.showInternalMessageDialog(null, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
	
}
} 
