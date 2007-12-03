import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PantallaConsultaFamilia extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton jButton = null;

	private JTextField jTextField = null;

	private JTextField jTextField1 = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	/**
	 * This is the default constructor
	 */
	public PantallaConsultaFamilia() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(376, 216);
		this.setContentPane(getJContentPane());
		this.setTitle("Consulta Familia");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(30, 67, 132, 34));
			jLabel1.setText("Descripcion");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(30, 22, 134, 33));
			jLabel.setText("Id Familia");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
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
			jButton.setBounds(new Rectangle(132, 119, 112, 28));
			jButton.setText("Aceptar");
		}
		return jButton;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(185, 24, 158, 32));
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
			jTextField1.setBounds(new Rectangle(185, 71, 159, 33));
		}
		return jTextField1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
