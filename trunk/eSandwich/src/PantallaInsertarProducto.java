

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;

public class PantallaInsertarProducto extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jCodi = null;

	private JTextField jcodiarticle = null;

	private JLabel jquant = null;

	private JTextField jquantitat = null;

	private JLabel jartic = null;

	private JTextField jarticle = null;

	private JLabel jDescrip = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	private JLabel jartic1 = null;

	private JTextField jarticle1 = null;

	private JTextField jTextField = null;

	private JLabel jLabel = null;

	private JTextField jTextField1 = null;

	private ControladorPantallaInsertarProducto cpip = null;
	
	private AplicacionEmpleado ae = null;
	
	/**
	 * This is the default constructor
	 */
	public PantallaInsertarProducto(AplicacionEmpleado ae) {
		super(ae, "Insertar Producto", true);
		this.ae = ae;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 324);
		this.setContentPane(getJContentPane());
	
		// Li passem la pantalla i l'aplicacio
		cpip = new ControladorPantallaInsertarProducto(this,ae);
		
//Al boto Acceptar li diem que si és apretat que vagi a buscar que ha de fer al ActionPerformed del Controlador		
		jAcceptar.addActionListener(cpip);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(44, 194, 51, 19));
			jLabel.setText("Precio");
			jartic1 = new JLabel();
			jartic1.setBounds(new Rectangle(46, 126, 72, 16));
			jartic1.setText("Existencias");
			jDescrip = new JLabel();
			jDescrip.setBounds(new Rectangle(46, 163, 55, 16));
			jDescrip.setText("Familia");
			jartic = new JLabel();
			jartic.setBounds(new Rectangle(46, 95, 130, 16));
			jartic.setText("Descripcion Ampliada");
			jquant = new JLabel();
			jquant.setBounds(new Rectangle(45, 63, 79, 16));
			jquant.setText("Descripcion");
			jCodi = new JLabel();
			jCodi.setBounds(new Rectangle(45, 32, 112, 16));
			jCodi.setText("Codigo Producto");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jCodi, null);
			jContentPane.add(getJcodiarticle(), null);
			jContentPane.add(jquant, null);
			jContentPane.add(getJquantitat(), null);
			jContentPane.add(jartic, null);
			jContentPane.add(getJarticle(), null);
			jContentPane.add(jDescrip, null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
			jContentPane.add(jartic1, null);
			jContentPane.add(getJarticle1(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jcodiarticle	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJcodiarticle() {
		if (jcodiarticle == null) {
			jcodiarticle = new JTextField();
			jcodiarticle.setBounds(new Rectangle(173, 29, 234, 20));
		}
		return jcodiarticle;
	}

	/**
	 * This method initializes jquantitat	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJquantitat() {
		if (jquantitat == null) {
			jquantitat = new JTextField();
			jquantitat.setBounds(new Rectangle(128, 61, 280, 20));
		}
		return jquantitat;
	}

	/**
	 * This method initializes jarticle	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJarticle() {
		if (jarticle == null) {
			jarticle = new JTextField();
			jarticle.setBounds(new Rectangle(190, 93, 219, 20));
		}
		return jarticle;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setBounds(new Rectangle(118, 238, 86, 26));
			jAcceptar.setText("Aceptar");
		}
		return jAcceptar;
	}

	/**
	 * This method initializes jCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJCancelar() {
		if (jCancelar == null) {
			jCancelar = new JButton();
			jCancelar.setBounds(new Rectangle(238, 238, 91, 26));
			jCancelar.setText("Cancelar");
		}
		return jCancelar;
	}

	/**
	 * This method initializes jarticle1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJarticle1() {
		if (jarticle1 == null) {
			jarticle1 = new JTextField();
			jarticle1.setBounds(new Rectangle(129, 124, 278, 20));
		}
		return jarticle1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(124, 160, 284, 20));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(125, 194, 281, 24));
		}
		return jTextField1;
	}

}  
