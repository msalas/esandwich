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

public class PantallaInsertarFamilia extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JTextField jTextField = null;

	private JTextField jTextField1 = null;

	private JButton jButton = null;

	private JButton jButton1 = null;

	private ControladorPantallaInsertarFamilia cpif = null;
	
	private AplicacionEmpleado ae = null;
	
	/**
	 * This is the default constructor
	 */
	public PantallaInsertarFamilia(AplicacionEmpleado ae) {
		super(ae, "Insertar Familia", true);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(392, 225);
		this.setContentPane(getJContentPane());
		this.setTitle("Insertar Familia");
		cpif = new ControladorPantallaInsertarFamilia(this,ae);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(43, 83, 118, 28));
			jLabel1.setText("Descripción");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(44, 37, 115, 29));
			jLabel.setText("Id familia");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(195, 38, 163, 29));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(195, 83, 164, 27));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(63, 132, 114, 33));
			jButton.setText("Aceptar");
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(208, 132, 120, 33));
			jButton1.setText("Cancelar");
		}
		return jButton1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
