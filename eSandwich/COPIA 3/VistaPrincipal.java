import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame {

  private static final long serialVersionUID             = 1L;

  private JPanel            jContentPane                 = null;
  private JMenuBar          jbarramenu                   = null;
  private JMenu             jlogin                       = null;
  private JMenu             jRegistre                    = null;
  private JMenu             jDadesPersonals              = null;
  private JMenu             jPromocions                  = null;
  private JMenu             jStock                       = null;
  private JMenu             jFacturacio                  = null;
  private JMenu             jComandes                    = null;
  private JMenuItem         jRealitcomandes              = null;
  private JMenuItem         jaltaarticle                 = null;
  private JMenuItem         jfactutotal                  = null;
  private JMenuItem         jFacturaciosand              = null;
  private JMenu             jMenuComanda                 = null;
  private JMenuItem         jMenuItemIniciSesion         = null;
  private JMenuItem         jMenuItemAlta                = null;
  private JMenuItem         jMenuItemConsulta            = null;
  private JMenuItem         jMenuItemPromocionsPanell    = null;
  private JMenuItem         jMenuItemePunts              = null;
  private JMenuItem         jMenuItemPromocionsTemporada = null;
  private JMenuItem         jMenuItemOfertesSandwichs    = null;
  private JMenu             jMenuComanda1                = null;
  private JMenuItem         jMenuItemCrearComanda        = null;

  private RMILoginInterface rmiLoginInterface            = null;

  /**
   * This is the default constructor
   */
  public VistaPrincipal() {
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
    
    doConexionRMI();
  }

  private void doConexionRMI() {
    System.out.println("Principal.doConexionRMI()");

    try {
      rmiLoginInterface = (RMILoginInterface) Naming
          .lookup("rmi://localhost:1099/RMILoginService");
      System.out.println("rmiLoginInterface obtenido");
      // rmiLoginInterface.login(codigo, clave);

    } catch (MalformedURLException e) {
      System.err.println("Error en URL: \n\t" + e);
    } catch (RemoteException e) {
      System.err.println("Error remoto: \n\t" + e);
    } catch (NotBoundException e) {
      System.err.println("Servicio no encontrado: \n\t" + e);
    }
  }

  private void doLogin() {
    VistaLogin jfl = new VistaLogin();
    // jfl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfl.setVisible(true);
  }

  // ****************************************
  // Getters i setters de la clase
  // ****************************************

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
      jbarramenu.add(getJlogin());
      jbarramenu.add(getJRegistre());
      jbarramenu.add(getJDadesPersonals());
      jbarramenu.add(getJPromocions());
      jbarramenu.add(getJMenuComanda1());
    }
    return jbarramenu;
  }

  /**
   * This method initializes jlogin
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJlogin() {
    if (jlogin == null) {
      jlogin = new JMenu();
      jlogin.setText("Login");
      jlogin.add(getJMenuItemIniciSesion());
    }
    return jlogin;
  }

  /**
   * This method initializes jRegistre
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJRegistre() {
    if (jRegistre == null) {
      jRegistre = new JMenu();
      jRegistre.setText("Registre");
      jRegistre.add(getJMenuItemAlta());
    }
    return jRegistre;
  }

  /**
   * This method initializes jDadesPersonals
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJDadesPersonals() {
    if (jDadesPersonals == null) {
      jDadesPersonals = new JMenu();
      jDadesPersonals.setText("Dades Personals");
      jDadesPersonals.add(getJMenuItemConsulta());
    }
    return jDadesPersonals;
  }

  /**
   * This method initializes jPromocions
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJPromocions() {
    if (jPromocions == null) {
      jPromocions = new JMenu();
      jPromocions.setText("Promocions");
      // jPromocions.add(getJStock());
      jPromocions.add(getJMenuItemPromocionsPanell());
      // jPromocions.add(getJFacturacio());
      jPromocions.add(getJMenuItemePunts());
      // jPromocions.add(getJComandes());
      jPromocions.add(getJMenuItemPromocionsTemporada());
      jPromocions.add(getJMenuItemOfertesSandwichs());
    }
    return jPromocions;
  }

  /**
   * This method initializes jStock
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJStock() {
    if (jStock == null) {
      jStock = new JMenu();
      jStock.setText("");
      jStock.add(getJaltaarticle());
    }
    return jStock;
  }

  /**
   * This method initializes jFacturacio
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJFacturacio() {
    if (jFacturacio == null) {
      jFacturacio = new JMenu();
      jFacturacio.setText("Facturació");
      jFacturacio.add(getJfactutotal());
      jFacturacio.add(getJFacturaciosand());
    }
    return jFacturacio;
  }

  /**
   * This method initializes jComandes
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJComandes() {
    if (jComandes == null) {
      jComandes = new JMenu();
      jComandes.setText("Comandes");
      jComandes.add(getJRealitcomandes());
    }
    return jComandes;
  }

  /**
   * This method initializes jRealitcomandes
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJRealitcomandes() {
    if (jRealitcomandes == null) {
      jRealitcomandes = new JMenuItem();
      jRealitcomandes.setText("Realitzar comandes");
    }
    return jRealitcomandes;
  }

  /**
   * This method initializes jaltaarticle
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJaltaarticle() {
    if (jaltaarticle == null) {
      jaltaarticle = new JMenuItem();
      jaltaarticle.setText("Alta Article");
    }
    return jaltaarticle;
  }

  /**
   * This method initializes jfactutotal
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJfactutotal() {
    if (jfactutotal == null) {
      jfactutotal = new JMenuItem();
      jfactutotal.setText("Facturació total");
    }
    return jfactutotal;
  }

  /**
   * This method initializes jFacturaciosand
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJFacturaciosand() {
    if (jFacturaciosand == null) {
      jFacturaciosand = new JMenuItem();
      jFacturaciosand.setText("Facturació per Sandvitx");
    }
    return jFacturaciosand;
  }

  /**
   * This method initializes jMenuItemIniciSesion
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemIniciSesion() {
    if (jMenuItemIniciSesion == null) {
      jMenuItemIniciSesion = new JMenuItem();
      jMenuItemIniciSesion.setText("Inici Sessió");
      jMenuItemIniciSesion
          .addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
              System.out.println("Principal.actionPerformed()");
              doLogin();
            }
          });
    }
    return jMenuItemIniciSesion;
  }

  /**
   * This method initializes jMenuItemAlta
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemAlta() {
    if (jMenuItemAlta == null) {
      jMenuItemAlta = new JMenuItem();
      jMenuItemAlta.setText("Alta");
    }
    return jMenuItemAlta;
  }

  /**
   * This method initializes jMenuItemConsulta
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemConsulta() {
    if (jMenuItemConsulta == null) {
      jMenuItemConsulta = new JMenuItem();
      jMenuItemConsulta.setText("Consulta");
    }
    return jMenuItemConsulta;
  }

  /**
   * This method initializes jMenuItemPromocionsPanell
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemPromocionsPanell() {
    if (jMenuItemPromocionsPanell == null) {
      jMenuItemPromocionsPanell = new JMenuItem();
      jMenuItemPromocionsPanell.setText("Panell Promocions");
    }
    return jMenuItemPromocionsPanell;
  }

  /**
   * This method initializes jMenuItemePunts
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemePunts() {
    if (jMenuItemePunts == null) {
      jMenuItemePunts = new JMenuItem();
      jMenuItemePunts.setText("Consulta ePunts");
    }
    return jMenuItemePunts;
  }

  /**
   * This method initializes jMenuItemPromocionsTemporada
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemPromocionsTemporada() {
    if (jMenuItemPromocionsTemporada == null) {
      jMenuItemPromocionsTemporada = new JMenuItem();
      jMenuItemPromocionsTemporada.setText("Promocions Temporada");
    }
    return jMenuItemPromocionsTemporada;
  }

  /**
   * This method initializes jMenuItemOfertesSandwichs
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemOfertesSandwichs() {
    if (jMenuItemOfertesSandwichs == null) {
      jMenuItemOfertesSandwichs = new JMenuItem();
      jMenuItemOfertesSandwichs.setText("Ofertes Sandwichs");
    }
    return jMenuItemOfertesSandwichs;
  }

  /**
   * This method initializes jMenuComanda1
   * 
   * @return javax.swing.JMenu
   */
  private JMenu getJMenuComanda1() {
    if (jMenuComanda1 == null) {
      jMenuComanda1 = new JMenu();
      jMenuComanda1.setText("Comanda");
      jMenuComanda1.add(getJMenuItemCrearComanda());
    }
    return jMenuComanda1;
  }

  /**
   * This method initializes jMenuItemCrearComanda
   * 
   * @return javax.swing.JMenuItem
   */
  private JMenuItem getJMenuItemCrearComanda() {
    if (jMenuItemCrearComanda == null) {
      jMenuItemCrearComanda = new JMenuItem();
      jMenuItemCrearComanda.setText("Iniciar Comanda");
    }
    return jMenuItemCrearComanda;
  }

  public static void main(String[] args) {
    VistaPrincipal app = new VistaPrincipal();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }

} // @jve:decl-index=0:visual-constraint="24,-126"
