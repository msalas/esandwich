
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

public class PantallaBuscarFamilia extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;
	
	private ControladorPantallaBuscarFamilia cpbf = null;
	
	private AplicacionEmpleado ae = null;
	

	/**
	 * This is the default constructor
	 */
	public PantallaBuscarFamilia(AplicacionEmpleado ae) {
		super(ae, "Buscar Familia", true);
		this.ae = ae;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(412, 213);
		this.setContentPane(getJContentPane());
		this.setTitle("Buscar Familia");
		cpbf = new ControladorPantallaBuscarFamilia(this,ae);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(31, 46, 91, 29));
			jLabel.setText("Id Familia");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTextField(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(148, 119, 100, 35));
			jButton.setText("Aceptar");
		}
		return jButton;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(163, 45, 184, 35));
		}
		return jTextField;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
