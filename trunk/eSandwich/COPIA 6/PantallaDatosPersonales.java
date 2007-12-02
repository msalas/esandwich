import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDialog;

public class PantallaDatosPersonales extends JDialog {

  private static final long              serialVersionUID           = 1L;
  private JPanel                         jContentPane               = null;
  private JLabel                         jLabelNif                  = null;
  private JLabel                         jLabelNom                  = null;
  private JLabel                         jLabelCognoms              = null;
  private JLabel                         jLabelAdreça               = null;
  private JLabel                         jLabelPoblació             = null;
  private JLabel                         jLabelTelefon              = null;
  private JLabel                         jLabelMobil                = null;
  private JLabel                         jLabelEMail                = null;
  private JPanel                         jPanelDadesPersonals       = null;
  private JTextField                     jTextFieldNif              = null;
  private JTextField                     jTextFieldNom              = null;
  private JTextField                     jTextFieldCognoms          = null;
  private JTextField                     jTextFieldAdreça           = null;
  private JLabel                         jLabelContrasenya          = null;
  private JLabel                         jLabelConfContrasenya      = null;
  private JPanel                         jPanelDadesAcces           = null;
  private JPanel                         jPanelContrasenya          = null;
  private JPasswordField                 jPasswordFieldNContrasenya = null;
  private JPasswordField                 jPasswordFieldCContrasenya = null;
  private JTextField                     jTextFieldPoblacio         = null;
  private JTextField                     jTextFieldTelefon          = null;
  private JTextField                     jTextFieldMobil            = null;
  private JTextField                     jTextFieldEMail            = null;
  private JButton                        jButtonCrear               = null;
  private JCheckBox                      jCheckBoxDeshabilitar      = null;
  private JLabel                         jLabelDeshabilitar         = null;
  private JButton                        jButtonCancellar           = null;
  private JComboBox                      jComboBox                  = null;
  private JLabel                         jLabel1                    = null;
  private JLabel                         jLabel2                    = null;
  private JLabel                         jLabel3                    = null;

  private AplicacionComprador            ac                         = null;
  private ControladorPantallaDatosPersonales cpdp = null;
private boolean modificar = false;
  /**
   * This is the default constructor
   */
  public PantallaDatosPersonales(AplicacionComprador ac, boolean modif) {
    super(ac, "Alta empleado", true);
    this.ac = ac;
    this.modificar = modif;
    initialize();
    
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(494, 384);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setContentPane(getJContentPane());
    cpdp = new ControladorPantallaDatosPersonales(this,ac);
    jButtonCrear.setActionCommand("crear");
    jButtonCrear.addActionListener(cpdp);
    
    //Faltara un jButtonModificar
    //jButtonCrear.setActionCommand("crear");
    //jButtonCrear.addActionListener(cpdp);
    
    // jButtonCancellar.setActionCommand("cancelar");
    // jButtonCancellar.addActionListener(cpl);
  
  
    if(modificar){ // S'han de posar les dades de l'usuari
    	
    	//ho poses a els atributs de pantalla que vulguis, per exemple: jNombre.setText(cpdp.getNombre());
      jTextFieldNom.setText(cpdp.getNombre());
//      jTextFieldCognoms.setText(cpdp.);
    	
    	
    } // Sino ja esta be, no cal fer res
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jLabel3 = new JLabel();
      jLabel3.setBounds(new Rectangle(399, 3, 64, 16));
      jLabel3.setFont(new Font("Dialog", Font.PLAIN, 12));
      jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
//      if (usuario != null) {
//        jLabel3.setText(usuario.getCodUsuario());
//      }
      jLabel2 = new JLabel();
      jLabel2.setText("Usuario:");
      jLabel2.setLocation(new Point(336, 3));
      jLabel2.setSize(new Dimension(64, 16));
      jLabelDeshabilitar = new JLabel();
      jLabelDeshabilitar.setBounds(new Rectangle(52, 306, 70, 17));
      jLabelDeshabilitar.setText("deshabilitar");
      jLabelConfContrasenya = new JLabel();
      jLabelConfContrasenya.setText("Confirmar Contrasenya:");
      jLabelConfContrasenya.setBounds(new Rectangle(10, 35, 139, 16));
      jLabelContrasenya = new JLabel();
      jLabelContrasenya.setText("Nova Contrasenya:");
      jLabelContrasenya.setBounds(new Rectangle(10, 10, 106, 16));
      jLabelEMail = new JLabel();
      jLabelEMail.setText("E-Mail:");
      jLabelEMail.setBounds(new Rectangle(200, 90, 39, 16));
      jLabelMobil = new JLabel();
      jLabelMobil.setText("Mòbil:");
      jLabelMobil.setBounds(new Rectangle(15, 90, 36, 16));
      jLabelTelefon = new JLabel();
      jLabelTelefon.setText("Telèfon:");
      jLabelTelefon.setBounds(new Rectangle(15, 65, 48, 16));
      jLabelPoblació = new JLabel();
      jLabelPoblació.setText("Població:");
      jLabelPoblació.setBounds(new Rectangle(240, 40, 55, 16));
      jLabelAdreça = new JLabel();
      jLabelAdreça.setText("Adreça:");
      jLabelAdreça.setBounds(new Rectangle(15, 40, 47, 16));
      jLabelCognoms = new JLabel();
      jLabelCognoms.setText("Cognoms:");
      jLabelCognoms.setBounds(new Rectangle(165, 15, 60, 16));
      jLabelNom = new JLabel();
      jLabelNom.setText("Nom:");
      jLabelNom.setBounds(new Rectangle(15, 15, 32, 16));
      jLabelNif = new JLabel();
      jLabelNif.setText("NIF:");
      jLabelNif.setBounds(new Rectangle(15, 15, 20, 16));
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
      jContentPane.add(getJPanelDadesPersonals(), null);
      jContentPane.add(getJPanelDadesAcces(), null);
      jContentPane.add(getJButtonCrear(), null);
      jContentPane.add(getJCheckBoxDeshabilitar(), null);
      jContentPane.add(jLabelDeshabilitar, null);
      jContentPane.add(getJButtonCancellar(), null);
      jContentPane.add(jLabel2, null);
      jContentPane.add(jLabel3, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes jPanelDadesPersonals
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanelDadesPersonals() {
    if (jPanelDadesPersonals == null) {
      jPanelDadesPersonals = new JPanel();
      jPanelDadesPersonals.setLayout(null);
      jPanelDadesPersonals.setBounds(new Rectangle(20, 170, 445, 122));
      jPanelDadesPersonals.setBorder(BorderFactory
          .createBevelBorder(BevelBorder.RAISED));
      jPanelDadesPersonals.add(jLabelNom, null);
      jPanelDadesPersonals.add(jLabelCognoms, null);
      jPanelDadesPersonals.add(jLabelPoblació, null);
      jPanelDadesPersonals.add(jLabelAdreça, null);
      jPanelDadesPersonals.add(jLabelTelefon, null);
      jPanelDadesPersonals.add(jLabelMobil, null);
      jPanelDadesPersonals.add(jLabelEMail, null);
      jPanelDadesPersonals.add(getJTextFieldNom(), null);
      jPanelDadesPersonals.add(getJTextFieldCognoms(), null);
      jPanelDadesPersonals.add(getJTextFieldAdreça(), null);
      jPanelDadesPersonals.add(getJTextFieldPoblacio(), null);
      jPanelDadesPersonals.add(getJTextFieldTelefon(), null);
      jPanelDadesPersonals.add(getJTextFieldMobil(), null);
      jPanelDadesPersonals.add(getJTextFieldEMail(), null);
    }
    return jPanelDadesPersonals;
  }

  /**
   * This method initializes jTextFieldNif
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldNif() {
    if (jTextFieldNif == null) {
      jTextFieldNif = new JTextField();
      jTextFieldNif.setBounds(new Rectangle(40, 15, 120, 18));
      jTextFieldNif.setEditable(true);
      jTextFieldNif.setEnabled(true);
//      if (usuario != null) {
//        jTextFieldNif.setText(usuario.getNif());
//      }
    }
    return jTextFieldNif;
  }

  /**
   * This method initializes jTextFieldNom
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldNom() {
    if (jTextFieldNom == null) {
      jTextFieldNom = new JTextField();
      jTextFieldNom.setBounds(new Rectangle(49, 15, 100, 18));
      jTextFieldNom.setEditable(true);
//      if (usuario != null) {
//        jTextFieldNom.setText(usuario.getNombre());
//      }
    }
    return jTextFieldNom;
  }

  /**
   * This method initializes jTextFieldCognoms
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldCognoms() {
    if (jTextFieldCognoms == null) {
      jTextFieldCognoms = new JTextField();
      jTextFieldCognoms.setBounds(new Rectangle(229, 15, 200, 18));
      jTextFieldCognoms.setEditable(true);
//      if (usuario != null) {
//        if (usuario.getApellido1() != null) {
//          jTextFieldCognoms.setText(usuario.getApellido1() + " "
//              + usuario.getApellido2());
//        }
//      }
    }
    return jTextFieldCognoms;
  }

  /**
   * This method initializes jTextFieldAdreça
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldAdreça() {
    if (jTextFieldAdreça == null) {
      jTextFieldAdreça = new JTextField();
      jTextFieldAdreça.setBounds(new Rectangle(60, 40, 170, 18));
      jTextFieldAdreça.setEditable(true);
//      if (usuario != null) {
//        jTextFieldAdreça.setText(usuario.getDireccion());
//      }
    }
    return jTextFieldAdreça;
  }

  /**
   * This method initializes jPanelDadesAcces
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanelDadesAcces() {
    if (jPanelDadesAcces == null) {
      jLabel1 = new JLabel();
      jLabel1.setBounds(new Rectangle(286, 50, 38, 16));
      jLabel1.setText("Rol");
      jPanelDadesAcces = new JPanel();
      jPanelDadesAcces.setLayout(null);
      jPanelDadesAcces.setBounds(new Rectangle(20, 20, 445, 130));
      jPanelDadesAcces.setBorder(BorderFactory
          .createBevelBorder(BevelBorder.RAISED));
      jPanelDadesAcces.add(jLabelNif, null);
      jPanelDadesAcces.add(getJTextFieldNif(), null);
      jPanelDadesAcces.add(getJPanelContrasenya(), null);
      jPanelDadesAcces.add(getJComboBox(), null);
      jPanelDadesAcces.add(jLabel1, null);
    }
    return jPanelDadesAcces;
  }

  /**
   * This method initializes jPanelContrasenya
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanelContrasenya() {
    if (jPanelContrasenya == null) {
      jPanelContrasenya = new JPanel();
      jPanelContrasenya.setLayout(null);
      jPanelContrasenya.setBounds(new Rectangle(15, 45, 263, 62));
      jPanelContrasenya.setBorder(BorderFactory
          .createBevelBorder(BevelBorder.LOWERED));
      jPanelContrasenya.add(jLabelContrasenya, null);
      jPanelContrasenya.add(jLabelConfContrasenya, null);
      jPanelContrasenya.add(getJPasswordFieldNContrasenya(), null);
      jPanelContrasenya.add(getJPasswordFieldCContrasenya(), null);
    }
    return jPanelContrasenya;
  }

  /**
   * This method initializes jPasswordFieldNContrasenya
   * 
   * @return javax.swing.JPasswordField
   */
  private JPasswordField getJPasswordFieldNContrasenya() {
    if (jPasswordFieldNContrasenya == null) {
      jPasswordFieldNContrasenya = new JPasswordField();
      jPasswordFieldNContrasenya.setBounds(new Rectangle(152, 10, 100, 18));
      jPasswordFieldNContrasenya.setEditable(true);
//      if (usuario != null) {
//        jPasswordFieldNContrasenya.setText(usuario.getPassword());
//      }
    }
    return jPasswordFieldNContrasenya;
  }

  /**
   * This method initializes jPasswordFieldCContrasenya
   * 
   * @return javax.swing.JPasswordField
   */
  private JPasswordField getJPasswordFieldCContrasenya() {
    if (jPasswordFieldCContrasenya == null) {
      jPasswordFieldCContrasenya = new JPasswordField();
      jPasswordFieldCContrasenya.setBounds(new Rectangle(152, 35, 100, 18));
      jPasswordFieldCContrasenya.setEditable(true);
//      if (usuario != null) {
//        jPasswordFieldCContrasenya.setText(usuario.getPassword());
//      }
    }
    return jPasswordFieldCContrasenya;
  }

  /**
   * This method initializes jTextFieldPoblacio
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldPoblacio() {
    if (jTextFieldPoblacio == null) {
      jTextFieldPoblacio = new JTextField();
      jTextFieldPoblacio.setBounds(new Rectangle(300, 40, 129, 18));
      jTextFieldPoblacio.setEditable(true);
//      if (usuario != null) {
//        jTextFieldPoblacio.setText(usuario.getPoblacion());
//      }
    }
    return jTextFieldPoblacio;
  }

  /**
   * This method initializes jTextFieldTelefon
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldTelefon() {
    if (jTextFieldTelefon == null) {
      jTextFieldTelefon = new JTextField();
      jTextFieldTelefon.setBounds(new Rectangle(65, 65, 120, 18));
      jTextFieldTelefon.setEditable(true);
//      if (usuario != null) {
//        jTextFieldTelefon.setText(usuario.getTelefono());
//      }
    }
    return jTextFieldTelefon;
  }

  /**
   * This method initializes jTextFieldMobil
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldMobil() {
    if (jTextFieldMobil == null) {
      jTextFieldMobil = new JTextField();
      jTextFieldMobil.setBounds(new Rectangle(65, 90, 120, 18));
      jTextFieldMobil.setEditable(true);
//      if (usuario != null) {
//        jTextFieldMobil.setText(usuario.getMovil());
//      }
    }
    return jTextFieldMobil;
  }

  /**
   * This method initializes jTextFieldEMail
   * 
   * @return javax.swing.JTextField
   */
  private JTextField getJTextFieldEMail() {
    if (jTextFieldEMail == null) {
      jTextFieldEMail = new JTextField();
      jTextFieldEMail.setBounds(new Rectangle(245, 90, 183, 18));
      jTextFieldEMail.setEditable(true);
//      if (usuario != null) {
//        jTextFieldEMail.setText(usuario.getEmail());
//      }
    }
    return jTextFieldEMail;
  }

  /**
   * This method initializes jButtonCrear
   * 
   * @return javax.swing.JButton
   */
  private JButton getJButtonCrear() {
    if (jButtonCrear == null) {
      jButtonCrear = new JButton();
      jButtonCrear.setText("Crear");
      jButtonCrear.setSize(new Dimension(95, 28));
      jButtonCrear.setLocation(new Point(181, 307));
      jButtonCrear.setVisible(true);
      // El listener es el controlador cpl
      jButtonCrear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("PantallaDatosPersonales.actionPerformed()");

        }
      });
    }
    return jButtonCrear;
  }

  /**
   * This method initializes jCheckBoxDeshabilitar
   * 
   * @return javax.swing.JCheckBox
   */
  private JCheckBox getJCheckBoxDeshabilitar() {
    if (jCheckBoxDeshabilitar == null) {
      jCheckBoxDeshabilitar = new JCheckBox();
      jCheckBoxDeshabilitar.setBounds(new Rectangle(28, 305, 21, 21));
      jCheckBoxDeshabilitar.setEnabled(true);
    }
    return jCheckBoxDeshabilitar;
  }

  /**
   * This method initializes jButtonCancellar
   * 
   * @return javax.swing.JButton
   */
  private JButton getJButtonCancellar() {
    if (jButtonCancellar == null) {
      jButtonCancellar = new JButton();
      jButtonCancellar.setLocation(new Point(299, 307));
      jButtonCancellar.setText("Cancel·lar");
      jButtonCancellar.setSize(new Dimension(95, 28));
      jButtonCancellar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          System.out.println("actionPerformed()");
          doClose();
        }
      });
    }
    return jButtonCancellar;
  }

  /**
   * This method initializes jComboBox
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJComboBox() {
    Object data[] = { "Administrativo", "Auxiliar", "Cocinero" };
    if (jComboBox == null) {
      jComboBox = new JComboBox(data);
      jComboBox.setBounds(new Rectangle(285, 69, 150, 25));
    }
    return jComboBox;
  }

  private void doClose() {
    this.setVisible(false);
    try {
      this.finalize();

    } catch (Throwable e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Usuario usu = new Cliente();
    usu.setId(0);
    usu.setNif("73385595R");
    usu.setNombre("Antonio");
    usu.setApellido1("Antúnez");
    usu.setApellido2("García");
    usu.setDireccion("C/Saboya nº3");
    usu.setPoblacion("Viladecaballs");
    usu.setEmail("algo@correo.no.es");
    usu.setDesactivado(false);
    usu.setTelefono("92 111 222");
    usu.setMovil("666 111 222");
    // PantallaModifCliente app = new PantallaDatosPersonales (null, usu);
    // app.setVisible(true);
  }

} // @jve:decl-index=0:visual-constraint="10,10"
