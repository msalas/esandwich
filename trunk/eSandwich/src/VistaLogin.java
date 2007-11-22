import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class VistaLogin extends JFrame {

  private static final long serialVersionUID  = 1L;

  private JPanel            jContentPane      = null;
  private JPanel            jPanel            = null;
  private JLabel            jLabel            = null;
  private JLabel            jLabel1           = null;
  private JTextField        txtCClient        = null;
  private JTextField        txtPassword       = null;
  private JButton           btnLogin          = null;

  private String            codigo            = null;
  private String            clave             = null;

  private RMILoginInterface rmiLoginInterface = null;

  /**
   * This is the default constructor
   */
  public VistaLogin() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(300, 200);
    this.setContentPane(getJContentPane());
    this.setTitle("Login");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(new BorderLayout());
      jContentPane.add(getJPanel(), BorderLayout.CENTER);
    }
    return jContentPane;
  }

  /**
   * This method initializes jPanel
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel() {
    if (jPanel == null) {
      jLabel1 = new JLabel();
      jLabel1.setBounds(new Rectangle(18, 63, 72, 16));
      jLabel1.setText("Password:");
      jLabel = new JLabel();
      jLabel.setBounds(new Rectangle(19, 35, 67, 16));
      jLabel.setText("Codi Client:");
      jPanel = new JPanel();
      jPanel.setLayout(null);
      jPanel.add(jLabel, null);
      jPanel.add(jLabel1, null);
      jPanel.add(getTxtCClient(), null);
      jPanel.add(getTxtPassword(), null);
      jPanel.add(getBtnLogin(), null);
    }
    return jPanel;
  }

  /**
   * This method initializes txtCClient
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTxtCClient() {
    if (txtCClient == null) {
      txtCClient = new JTextField();
      txtCClient.setBounds(new Rectangle(104, 36, 122, 20));
    }
    return txtCClient;
  }

  /**
   * This method initializes txtPassword
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getTxtPassword() {
    if (txtPassword == null) {
      txtPassword = new JTextField();
      txtPassword.setBounds(new Rectangle(103, 62, 123, 20));
    }
    return txtPassword;
  }

  /**
   * This method initializes btnLogin
   * 
   * @return javax.swing.JButton
   */
  private JButton getBtnLogin() {
    if (btnLogin == null) {
      btnLogin = new JButton();
      btnLogin.setBounds(new Rectangle(103, 104, 113, 28));
      btnLogin.setText("Entrar");
      btnLogin.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("Login.actionPerformed()");
          doActionPerformed();
        }
      });
    }
    return btnLogin;
  }

  
  protected void doActionPerformed() {
    System.out.println("Login.doActionPerformed()");
    codigo = getTxtCClient().getText();
    clave = getTxtPassword().getText();

    // Cargamos y llamamos al método login
    doConexionRMI();
    
    // TODO: Iniciar Aplicación
    

  }

  private void doConexionRMI() {
    System.out.println("Login.doConexionRMI()");

    try {
      rmiLoginInterface = (RMILoginInterface) Naming
          .lookup("rmi://localhost:1099/RMILoginService");
      System.out.println("rmiLoginInterface obtenido");
      rmiLoginInterface.login(codigo, clave);
      
    } catch (MalformedURLException e) {
      System.err.println("Error en URL: " + e);
      // e.printStackTrace();
    } catch (RemoteException e) {
      System.err.println("Error remoto: \n\t" + e);
      // e.printStackTrace();
    } catch (NotBoundException e) {
      System.err.println("Servicio no encontrado: " + e);
      // e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    VistaLogin app = new VistaLogin();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);
  }

}
