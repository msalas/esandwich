

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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JDialog;


public class PantallaConsultaEmpleado extends JDialog {

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
	private JCheckBox jCheckBoxDeshabilitar = null;
	private JLabel jLabelDeshabilitar = null;
	private JButton jButtonCancellar = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabelCognoms1 = null;
	private JTextField jTextFieldCognoms2 = null;
	private JTextField jTextRol = null; 
	
	private Empleado emp = null; 	
	private AplicacionEmpleado ae;
	private ControladorPantallaConsultaEmpleado cpl = null;
	private int idRegAux;
	
	public PantallaConsultaEmpleado(AplicacionEmpleado ae,int idRegistro) {
		super(ae,"Consulta Empleado",true);
		this.ae = ae;
		idRegAux = idRegistro;
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
		this.setTitle("Consulta Empleado");
		// Para centrar pantalla
		this.setLocationRelativeTo(null);
		cpl = new ControladorPantallaConsultaEmpleado(this,ae);
		cpl.consulta(idRegAux);		
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
			jLabel2 = new JLabel();
			jLabel2.setText("Usuario:");
			jLabel2.setLocation(new Point(336, 3));
			jLabel2.setSize(new Dimension(64, 16));
			jLabelDeshabilitar = new JLabel();
			jLabelDeshabilitar.setBounds(new Rectangle(52, 306, 70, 17));
			jLabelDeshabilitar.setText("deshabilitar");
			jLabelConfContrasenya = new JLabel();
			jLabelConfContrasenya.setText("Confirmar Contraseña");
			jLabelConfContrasenya.setBounds(new Rectangle(10, 35, 139, 16));
			jLabelContrasenya = new JLabel();
			jLabelContrasenya.setText("Nueva contraseña");
			jLabelContrasenya.setBounds(new Rectangle(10, 10, 106, 16));
			jLabelEMail = new JLabel();
			jLabelEMail.setText("E-Mail:");
			jLabelEMail.setBounds(new Rectangle(200, 90, 39, 16));
			jLabelMobil = new JLabel();
			jLabelMobil.setText("Móbil:");
			jLabelMobil.setBounds(new Rectangle(15, 90, 36, 16));
			jLabelTelefon = new JLabel();
			jLabelTelefon.setText("Teléfono:");
			jLabelTelefon.setBounds(new Rectangle(250, 64, 55, 16));
			jLabelPoblació = new JLabel();
			jLabelPoblació.setText("Población:");
			jLabelPoblació.setBounds(new Rectangle(14, 64, 72, 16));
			jLabelAdreça = new JLabel();
			jLabelAdreça.setText("Dirección:");
			jLabelAdreça.setBounds(new Rectangle(233, 40, 58, 16));
			jLabelCognoms = new JLabel();
			jLabelCognoms.setText("Primer apellido:");
			jLabelCognoms.setBounds(new Rectangle(165, 15, 95, 16));
			jLabelNom = new JLabel();
			jLabelNom.setText("Nombre:");
			jLabelNom.setBounds(new Rectangle(15, 15, 49, 16));
			jLabelNif = new JLabel();
			jLabelNif.setText("NIF:");
			jLabelNif.setBounds(new Rectangle(15, 15, 20, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jContentPane.add(getJPanelDadesPersonals(), null);
			jContentPane.add(getJPanelDadesAcces(), null);
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
			jLabelCognoms1 = new JLabel();
			jLabelCognoms1.setBounds(new Rectangle(12, 41, 110, 16));
			jLabelCognoms1.setText("Segundo apellido:");
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
			jPanelDadesPersonals.add(jLabelCognoms1, null);
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
			jTextFieldNif.setEditable(false);
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
			jTextFieldNom.setBounds(new Rectangle(67, 15, 90, 18));
			jTextFieldNom.setEnabled(true);
			jTextFieldNom.setEditable(false);
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
			jTextFieldCognoms.setBounds(new Rectangle(263, 15, 166, 18));
			jTextFieldCognoms.setEnabled(true);
			jTextFieldCognoms.setEditable(false);
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
			jTextFieldAdreça.setBounds(new Rectangle(294, 40, 132, 18));
			jTextFieldAdreça.setEnabled(true);
			jTextFieldAdreça.setEditable(false);
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
			jPanelDadesAcces.add(jLabel1, null);
			jPanelDadesAcces.add(getJTextRol(), null);
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
			jPasswordFieldNContrasenya.setEditable(false);
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
			jPasswordFieldCContrasenya.setEditable(false);
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
			jTextFieldPoblacio.setBounds(new Rectangle(90, 64, 113, 18));
			jTextFieldPoblacio.setEditable(false);
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
			jTextFieldTelefon.setBounds(new Rectangle(307, 64, 120, 18));
			jTextFieldTelefon.setEditable(false);
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
			jTextFieldMobil.setEditable(false);
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
			jTextFieldEMail.setEditable(false);
		}
		return jTextFieldEMail;
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
			jCheckBoxDeshabilitar.setEnabled(false);
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
			jButtonCancellar.setLocation(new Point(187, 307));
			jButtonCancellar.setText("Salir");
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
		auxEmp.setDesactivado(jCheckBoxDeshabilitar.isSelected());
		return auxEmp;
	}

	public void iniCampos() {
		jLabel3.setText(""); // Codigo Empleado
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
		jTextRol.setText("");
		jCheckBoxDeshabilitar.setSelected(false);
	}

	public void entraCampos(Empleado emp) {
		jLabel3.setText(emp.getCodUsuario()); // Codigo Empleado
		jTextFieldNif.setText(emp.getNif());
		jTextFieldNom.setText(emp.getNombre());
		jTextFieldCognoms.setText(emp.getApellido1());
		jTextFieldCognoms2.setText(emp.getApellido2());
		jTextFieldAdreça.setText(emp.getDireccion());
		jTextFieldPoblacio.setText(emp.getPoblacion());
		jTextFieldTelefon.setText(emp.getTelefono());
		jTextFieldMobil.setText(emp.getMovil());
		jTextFieldEMail.setText(emp.getEmail());
		jPasswordFieldNContrasenya.setText(emp.getPassword());
		jPasswordFieldCContrasenya.setText(emp.getPassword());
		jTextRol.setText(emp.getRol().getDescripcion());
		jCheckBoxDeshabilitar.setSelected(emp.isDesactivado());
		setEmp(emp);
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
			jTextFieldCognoms2.setBounds(new Rectangle(119, 39, 108, 20));
			jTextFieldCognoms2.setEnabled(true);
			jTextFieldCognoms2.setEditable(false);
		}
		return jTextFieldCognoms2;
	}

	/**
	 * This method initializes jTextRol	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextRol() {
		if (jTextRol == null) {
			jTextRol = new JTextField();
			jTextRol.setBounds(new Rectangle(325, 48, 110, 20));
			jTextRol.setEditable(false);
			jTextRol.setEnabled(true);
		}
		return jTextRol;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
