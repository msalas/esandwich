

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.util.Vector;

public class PantallaAltaEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelNif = null;
	private JLabel jLabelNom = null;
	private JLabel jLabelCognoms = null;
	private JLabel jLabelAdreça = null;
	private JLabel jLabelPoblació = null;
	private JLabel jLabelTelefon = null;
	private JLabel jLabelMobil = null;
	private JLabel jLabelEMail = null;
	private JPanel jPanelDadesPersonals = null;
	private JTextField jTextFieldNif = null;
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
	private JButton jButtonCancellar = null;
	private JComboBox jComboBox = null;
	private JLabel jLabel1 = null;
	private JLabel jLabelCognoms2 = null;
	private JTextField jTextFieldCognoms2 = null;
	
	private Empleado emp = null; 	
	private Vector vectorCombo = null;
	private AplicacionEmpleado ae;
	private ControladorPantallaAltaEmpleado cpl = null; 

	/**
	 * This is the default constructor
	 */

	public PantallaAltaEmpleado(AplicacionEmpleado ae){
		super(ae,"Alta empleado",true);
		this.ae = ae;
		initialize();
	}
	
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(494, 384);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		// Para centrar pantalla
		this.setLocationRelativeTo(null);		
		cpl = new ControladorPantallaAltaEmpleado(this,ae);
		jButtonCrear.addActionListener(cpl);
		cpl.iniCombo();
		jPanelDadesAcces.add(getJComboBox(), null);
	}
	

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelConfContrasenya = new JLabel();
			jLabelConfContrasenya.setText("Confirmar Contraseña:");
			jLabelConfContrasenya.setBounds(new Rectangle(10, 35, 139, 16));
			jLabelContrasenya = new JLabel();
			jLabelContrasenya.setText("Nueva Contraseña:");
			jLabelContrasenya.setBounds(new Rectangle(10, 10, 133, 16));
			jLabelEMail = new JLabel();
			jLabelEMail.setText("E-Mail:");
			jLabelEMail.setBounds(new Rectangle(200, 90, 39, 16));
			jLabelMobil = new JLabel();
			jLabelMobil.setText("Móbil:");
			jLabelMobil.setBounds(new Rectangle(15, 90, 36, 16));
			jLabelTelefon = new JLabel();
			jLabelTelefon.setText("Teléfono:");
			jLabelTelefon.setBounds(new Rectangle(233, 65, 72, 16));
			jLabelPoblació = new JLabel();
			jLabelPoblació.setText("Población:");
			jLabelPoblació.setBounds(new Rectangle(17, 65, 66, 16));
			jLabelAdreça = new JLabel();
			jLabelAdreça.setText("Dirección:");
			jLabelAdreça.setBounds(new Rectangle(221, 41, 67, 16));
			jLabelCognoms = new JLabel();
			jLabelCognoms.setText("Primer apellido:");
			jLabelCognoms.setBounds(new Rectangle(193, 15, 95, 16));
			jLabelNom = new JLabel();
			jLabelNom.setText("Nombre:");
			jLabelNom.setBounds(new Rectangle(15, 15, 52, 16));
			jLabelNif = new JLabel();
			jLabelNif.setText("NIF:");
			jLabelNif.setBounds(new Rectangle(15, 15, 20, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jContentPane.add(getJPanelDadesPersonals(), null);
			jContentPane.add(getJPanelDadesAcces(), null);
			jContentPane.add(getJButtonCrear(), null);
			jContentPane.add(getJButtonCancellar(), null);
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
			jLabelCognoms2 = new JLabel();
			jLabelCognoms2.setBounds(new Rectangle(13, 40, 104, 16));
			jLabelCognoms2.setText("Segundo apellido:");
			jPanelDadesPersonals = new JPanel();
			jPanelDadesPersonals.setLayout(null);
			jPanelDadesPersonals.setBounds(new Rectangle(20, 170, 445, 122));
			jPanelDadesPersonals.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
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
			jPanelDadesPersonals.add(jLabelCognoms2, null);
			jPanelDadesPersonals.add(getJTextFieldCognoms2(), null);
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
			jTextFieldNom.setBounds(new Rectangle(63, 15, 127, 18));
			jTextFieldNom.setEditable(true);
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
			jTextFieldCognoms.setBounds(new Rectangle(291, 15, 138, 18));
			jTextFieldCognoms.setEditable(true);
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
			jTextFieldAdreça.setBounds(new Rectangle(288, 40, 139, 18));
			jTextFieldAdreça.setEditable(true);
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
			jPanelDadesAcces.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jPanelDadesAcces.add(jLabelNif, null);
			jPanelDadesAcces.add(getJTextFieldNif(), null);
			jPanelDadesAcces.add(getJPanelContrasenya(), null);
			//jPanelDadesAcces.add(getJComboBox(), null);
			jPanelDadesAcces.add(jLabel1, null);
		}
		return jPanelDadesAcces;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {		
		if (jComboBox == null) {
			jComboBox = new JComboBox(vectorCombo);
			jComboBox.setBounds(new Rectangle(285, 69, 150, 25));
		}
		return jComboBox;
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
			jPanelContrasenya.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
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
			jTextFieldPoblacio.setBounds(new Rectangle(88, 65, 138, 18));
			jTextFieldPoblacio.setEditable(true);
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
			jTextFieldTelefon.setBounds(new Rectangle(307, 65, 120, 18));
			jTextFieldTelefon.setEditable(true);
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
			jButtonCrear.setLocation(new Point(129, 307));
			jButtonCrear.setVisible(true);
		}
		return jButtonCrear;
	}

	/**
	 * This method initializes jButtonCancellar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonCancellar() {
		if (jButtonCancellar == null) {
			jButtonCancellar = new JButton();
			jButtonCancellar.setLocation(new Point(247, 307));
			jButtonCancellar.setText("Cancelar");
			jButtonCancellar.setSize(new Dimension(95, 28));
			jButtonCancellar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancellar;
	}



	public Empleado montaEmpleado() {
		Empleado auxEmp = new Empleado();
		auxEmp.setNif(jTextFieldNif.getText());
		auxEmp.setNombre(jTextFieldNom.getText());
		auxEmp.setApellido1(jTextFieldCognoms.getText());
		auxEmp.setApellido2(jTextFieldCognoms2.getText());
		auxEmp.setDireccion(jTextFieldAdreça.getText());
		auxEmp.setPoblacion(jTextFieldPoblacio.getText());
		auxEmp.setTelefono(jTextFieldTelefon.getText());
		auxEmp.setMovil(jTextFieldMobil.getText());
		auxEmp.setEmail(jTextFieldEMail.getText());
		auxEmp.setPassword(jPasswordFieldNContrasenya.getText());
		auxEmp.setDesactivado(false);
		return auxEmp;
	}

	public void iniCampos() {
		jTextFieldNif.setText("");
		jTextFieldNom.setText("");
		jTextFieldCognoms.setText("");
		jTextFieldCognoms2.setText("");
		jTextFieldAdreça.setText("");
		jTextFieldPoblacio.setText("");
		jTextFieldTelefon.setText("");
		jTextFieldMobil.setText("");
		jTextFieldEMail.setText("");
		jPasswordFieldNContrasenya.setText("");
		jPasswordFieldCContrasenya.setText("");
	}
	
	public boolean isIgualesPasswords() {
		boolean auxConf = false;
		if (jPasswordFieldNContrasenya.getText().equals(jPasswordFieldCContrasenya.getText())) {
			auxConf = true;
		}
		return auxConf;
	}


	public Empleado getEmp() {
		setEmp(montaEmpleado());
		return emp;
	}


	public void setEmp(Empleado emp) {
		this.emp = emp;
	}


	/**
	 * This method initializes jTextFieldCognoms2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCognoms2() {
		if (jTextFieldCognoms2 == null) {
			jTextFieldCognoms2 = new JTextField();
			jTextFieldCognoms2.setBounds(new Rectangle(119, 40, 101, 20));
			jTextFieldCognoms2.setEditable(true);
		}
		return jTextFieldCognoms2;
	}


	public Vector getVectorCombo() {
		return vectorCombo;
	}


	public void setVectorCombo(Vector vectorCombo) {
		this.vectorCombo = vectorCombo;
	}
	
	public String getRolDesplegable() {
		return (String)jComboBox.getSelectedItem();

	}
}
