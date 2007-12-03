

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Point;

public class PantallaConsultaProducto extends JFrame {

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

	private JTextField jTextField = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JTextField jTextField1 = null;

	private JTextField jTextField2 = null;

	/**
	 * This is the default constructor
	 */
	public PantallaConsultaProducto() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(457, 343);
		this.setContentPane(getJContentPane());
		this.setTitle("ConsultaProducto");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(40, 215, 47, 18));
			jLabel1.setText("Precio");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(37, 172, 80, 18));
			jLabel.setText("Id Familia");
			jDescrip = new JLabel();
			jDescrip.setBounds(new Rectangle(34, 135, 78, 16));
			jDescrip.setText("Existencias");
			jartic = new JLabel();
			jartic.setBounds(new Rectangle(35, 96, 130, 16));
			jartic.setText("Descripcion Ampliada");
			jquant = new JLabel();
			jquant.setBounds(new Rectangle(35, 63, 79, 16));
			jquant.setText("Descripcion");
			jCodi = new JLabel();
			jCodi.setBounds(new Rectangle(37, 25, 98, 16));
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
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
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
			jcodiarticle.setBounds(new Rectangle(148, 23, 271, 24));
		}
		return jcodiarticle;
	}

	/**
	 * This method initializes jquantitat	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJquantitat() {
		if (jquantitat == null) {
			jquantitat = new JTextField();
			jquantitat.setBounds(new Rectangle(134, 57, 287, 23));
		}
		return jquantitat;
	}

	/**
	 * This method initializes jarticle	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJarticle() {
		if (jarticle == null) {
			jarticle = new JTextField();
			jarticle.setBounds(new Rectangle(175, 90, 246, 25));
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
			jAcceptar.setText("Aceptar");
			jAcceptar.setSize(new Dimension(98, 27));
			jAcceptar.setLocation(new Point(185, 262));
		}
		return jAcceptar;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(128, 130, 292, 24));
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
			jTextField1.setBounds(new Rectangle(148, 169, 269, 23));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(104, 210, 313, 24));
		}
		return jTextField2;
	}

}
