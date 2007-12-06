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

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelCodiUsuari = null;
	private JLabel jLabelNom = null;
	private JLabel jLabelCognoms = null;
	private JLabel jLabelAdreça = null;
	private JLabel jLabelPoblació = null;
	private JLabel jLabelTelefon = null;
	private JLabel jLabelMobil = null;
	private JLabel jLabelEMail = null;
	private JPanel jPanelDadesPersonals = null;
	private JTextField jTextFieldCodiUsuari = null;
	private JTextField jTextFieldNom = null;
	private JTextField jTextFieldCognoms = null;
	private JTextField jTextFieldAdreça = null;
	private JLabel jLabelContrasenya = null;
	private JLabel jLabelConfContrasenya = null;
	private JPanel jPanelDadesAcces = null;
	private JPanel jPanelContrasenya = null;
	private JPasswordField jPasswordFieldNContrasenya = null;
	private JPasswordField jPasswordFieldCContrasenya = null;
	private JTextField jTextFieldPoblacio = null;
	private JTextField jTextFieldTelefon = null;
	private JTextField jTextFieldMobil = null;
	private JTextField jTextFieldEMail = null;
	private JButton jButtonCrear = null;
	private JButton jButtonModificar = null;
	private JButton jButtonCancellar = null;
	private JLabel jLabelNumTargCredit = null;
	private JTextField jTextFieldNumTargCredit = null;
	/**
	 * This is the default constructor
	 */
	private AplicacionComprador ac = null;
	private ControladorPantallaDatosPersonales cpdp = null;
	private boolean modificar = false;

	/**
	 * This is the default constructor
	 */
	public PantallaDatosPersonales(AplicacionComprador ac, boolean modif) {
		super(ac, "Datos personales", true);
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
		this.setContentPane(getJContentPane());
		cpdp = new ControladorPantallaDatosPersonales(this, ac);
		jButtonCrear.setActionCommand("crear");
		jButtonCrear.addActionListener(cpdp);

		jButtonModificar.setActionCommand("modificar");
		jButtonModificar.addActionListener(cpdp);
			
		jButtonCancellar.setActionCommand("cancelar");
		jButtonCancellar.addActionListener(cpdp);

		//if(modificar) setModificar();
		//else setConsultar();
	}

	public void setModificar(){
		jTextFieldCodiUsuari.setEditable(false);
		jTextFieldNom.setEditable(true);
		jTextFieldCognoms.setEditable(true);
		jTextFieldAdreça.setEditable(true);
		jPasswordFieldNContrasenya.setEditable(true);
		jPasswordFieldCContrasenya.setEditable(true);
		jTextFieldPoblacio.setEditable(true);
		jTextFieldTelefon.setEditable(true);
		jTextFieldMobil.setEditable(true);
		jTextFieldEMail.setEditable(true);
		jTextFieldNumTargCredit.setEditable(true);
	
		jButtonModificar.setVisible(true);
		jButtonCrear.setVisible(false);
	}
	
	public void setCrear(){
		
		jLabelCodiUsuari.setVisible(false);
		
		jTextFieldCodiUsuari.setVisible(false);
		jTextFieldNom.setEditable(true);
		jTextFieldCognoms.setEditable(true);
		jTextFieldAdreça.setEditable(true);
		jPasswordFieldNContrasenya.setEditable(true);
		jPasswordFieldCContrasenya.setEditable(true);
		jTextFieldPoblacio.setEditable(true);
		jTextFieldTelefon.setEditable(true);
		jTextFieldMobil.setEditable(true);
		jTextFieldEMail.setEditable(true);
		jTextFieldNumTargCredit.setEditable(true);
		
		jButtonModificar.setVisible(false);
		jButtonCrear.setVisible(true);
	}
	
	public void setConsultar(){
		jTextFieldCodiUsuari.setEditable(false);
		jTextFieldNom.setEditable(false);
		jTextFieldCognoms.setEditable(false);
		jTextFieldAdreça.setEditable(false);
		jPasswordFieldNContrasenya.setEditable(false);
		jPasswordFieldCContrasenya.setEditable(false);
		jTextFieldPoblacio.setEditable(false);
		jTextFieldTelefon.setEditable(false);
		jTextFieldMobil.setEditable(false);
		jTextFieldEMail.setEditable(false);
		jTextFieldNumTargCredit.setEditable(false);
		
		jButtonModificar.setVisible(false);
		jButtonCrear.setVisible(false);
	}
	
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
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
			jLabelCodiUsuari = new JLabel();
			jLabelCodiUsuari.setText("Codi Usuari:");
			jLabelCodiUsuari.setLocation(new Point(15, 15));
			jLabelCodiUsuari.setSize(new Dimension(73, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jContentPane.add(getJPanelDadesPersonals(), null);
			jContentPane.add(getJPanelDadesAcces(), null);
			jContentPane.add(getJButtonCrear(), null);
			jContentPane.add(getJButtonModificar(), null);
			jContentPane.add(getJButtonCancellar(), null);
		}
		return jContentPane;
	}

	private JButton getJButtonCrear() {
		if (jButtonCrear == null) {
			jButtonCrear = new JButton();
			jButtonCrear.setText("Registrarse");
			jButtonCrear.setSize(new Dimension(95, 28));
			jButtonCrear.setLocation(new Point(181, 307));
			jButtonCrear.setVisible(true);
		}
		return jButtonCrear;
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
	 * This method initializes jTextFieldCodiUsuari
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldCodiUsuari() {
		if (jTextFieldCodiUsuari == null) {
			jTextFieldCodiUsuari = new JTextField();
			jTextFieldCodiUsuari.setEditable(false);
			jTextFieldCodiUsuari.setEnabled(true);
			jTextFieldCodiUsuari.setSize(new Dimension(58, 18));
			jTextFieldCodiUsuari.setLocation(new Point(90, 15));
		
		}
		return jTextFieldCodiUsuari;
	}

	/**
	 * This method initializes jTextFieldNom
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldNom() {
		if (jTextFieldNom == null) {
			jTextFieldNom = new JTextField();
			jTextFieldNom.setBounds(new Rectangle(49, 15, 100, 18));
		
		}
		return jTextFieldNom;
	}

	/**
	 * This method initializes jTextFieldCognoms
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldCognoms() {
		if (jTextFieldCognoms == null) {
			jTextFieldCognoms = new JTextField();
			jTextFieldCognoms.setBounds(new Rectangle(229, 15, 200, 18));
		
		
		}
		return jTextFieldCognoms;
	}

	/**
	 * This method initializes jTextFieldAdreça
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldAdreça() {
		if (jTextFieldAdreça == null) {
			jTextFieldAdreça = new JTextField();
			jTextFieldAdreça.setBounds(new Rectangle(60, 40, 170, 18));
		
		
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
			jLabelNumTargCredit = new JLabel();
			jLabelNumTargCredit.setText("Núm. targeta crèdit:");
			jLabelNumTargCredit.setLocation(new Point(15, 97));
			jLabelNumTargCredit.setSize(new Dimension(120, 16));
			jPanelDadesAcces = new JPanel();
			jPanelDadesAcces.setLayout(null);
			jPanelDadesAcces.setBounds(new Rectangle(20, 20, 445, 130));
			jPanelDadesAcces.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.RAISED));
			jPanelDadesAcces.add(jLabelCodiUsuari, null);
			jPanelDadesAcces.add(getJTextFieldCodiUsuari(), null);
			jPanelDadesAcces.add(getJPanelContrasenya(), null);
			jPanelDadesAcces.add(jLabelNumTargCredit, null);
			jPanelDadesAcces.add(getJTextFieldNumTargCredit(), null);
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
			jPanelContrasenya.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
			jPanelContrasenya.setSize(new Dimension(263, 62));
			jPanelContrasenya.setLocation(new Point(168, 15));
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
	public JPasswordField getJPasswordFieldNContrasenya() {
		if (jPasswordFieldNContrasenya == null) {
			jPasswordFieldNContrasenya = new JPasswordField();
			jPasswordFieldNContrasenya
					.setBounds(new Rectangle(152, 10, 100, 18));
		}
		return jPasswordFieldNContrasenya;
	}

	/**
	 * This method initializes jPasswordFieldCContrasenya
	 * 
	 * @return javax.swing.JPasswordField
	 */
	public JPasswordField getJPasswordFieldCContrasenya() {
		if (jPasswordFieldCContrasenya == null) {
			jPasswordFieldCContrasenya = new JPasswordField();
			jPasswordFieldCContrasenya
					.setBounds(new Rectangle(152, 35, 100, 18));

		}
		return jPasswordFieldCContrasenya;
	}

	/**
	 * This method initializes jTextFieldPoblacio
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldPoblacio() {
		if (jTextFieldPoblacio == null) {
			jTextFieldPoblacio = new JTextField();
			jTextFieldPoblacio.setBounds(new Rectangle(300, 40, 129, 18));

		}
		return jTextFieldPoblacio;
	}

	/**
	 * This method initializes jTextFieldTelefon
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldTelefon() {
		if (jTextFieldTelefon == null) {
			jTextFieldTelefon = new JTextField();
			jTextFieldTelefon.setBounds(new Rectangle(65, 65, 120, 18));

		}
		return jTextFieldTelefon;
	}

	/**
	 * This method initializes jTextFieldMobil
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldMobil() {
		if (jTextFieldMobil == null) {
			jTextFieldMobil = new JTextField();
			jTextFieldMobil.setBounds(new Rectangle(65, 90, 120, 18));

		}
		return jTextFieldMobil;
	}

	/**
	 * This method initializes jTextFieldEMail
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldEMail() {
		if (jTextFieldEMail == null) {
			jTextFieldEMail = new JTextField();
			jTextFieldEMail.setBounds(new Rectangle(245, 90, 183, 18));

		}
		return jTextFieldEMail;
	}

	/**
	 * This method initializes jButtonCrear
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonModificar() {
		if (jButtonModificar == null) {
			jButtonModificar = new JButton();
			jButtonModificar.setText("Modificar");
			jButtonModificar.setSize(new Dimension(95, 28));
			jButtonModificar.setLocation(new Point(181, 307));
			jButtonModificar.setVisible(true);
		}
		return jButtonModificar;
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
			jButtonCancellar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							System.out.println("actionPerformed()");
							doClose();
						}
					});
		}
		return jButtonCancellar;
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

	/**
	 * This method initializes jTextFieldNumTargCredit
	 * 
	 * @return javax.swing.JTextField
	 */
	public JTextField getJTextFieldNumTargCredit() {
		if (jTextFieldNumTargCredit == null) {
			jTextFieldNumTargCredit = new JTextField();
			jTextFieldNumTargCredit.setBounds(new Rectangle(133, 97, 141, 18));
			jTextFieldNumTargCredit.setEnabled(true);

		}
		return jTextFieldNumTargCredit;
	}

	public boolean isModificar() {
		return modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}

}

//
// public static void main(String[] args) {
// Usuario usu = new Cliente();
// usu.setId(0);
// usu.setNif("73385595R");
// usu.setNombre("Antonio");
// usu.setApellido1("Antúnez");
// usu.setApellido2("García");
// usu.setDireccion("C/Saboya nº3");
// usu.setPoblacion("Viladecaballs");
//    usu.setEmail("algo@correo.no.es");
//    usu.setDesactivado(false);
//    usu.setTelefono("92 111 222");
//    usu.setMovil("666 111 222");
//    // PantallaModifCliente app = new PantallaDatosPersonales (null, usu);
//    // app.setVisible(true);
//  }
//
//} // @jve:decl-index=0:visual-constraint="10,10"
