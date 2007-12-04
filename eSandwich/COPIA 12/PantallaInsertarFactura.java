import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaInsertarFactura extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	private JTextField jfinsa11 = null;

	private JTextField jTextField = null;

	private JTextField jTextField1 = null;

	private JTextField jTextField2 = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	/**
	 * This is the default constructor
	 */
	public PantallaInsertarFactura() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(529, 347);
		this.setContentPane(getJContentPane());
		this.setTitle("Insertar Facturacion");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(44, 181, 76, 23));
			jLabel3.setText("Importe:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(46, 134, 75, 24));
			jLabel2.setText("Fecha:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(47, 91, 74, 22));
			jLabel1.setText("Id pedido:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(47, 45, 74, 25));
			jLabel.setText("Id Factura:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJfinsa11(), null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jfinsa11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJfinsa11() {
		if (jfinsa11 == null) {
			jfinsa11 = new JTextField();
			jfinsa11.setBounds(new Rectangle(166, 133, 300, 28));
			jfinsa11.setText("dd/mm/aa");
		}
		return jfinsa11;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(165, 43, 301, 27));
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
			jTextField1.setBounds(new Rectangle(165, 89, 300, 27));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(165, 178, 300, 26));
		}
		return jTextField2;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setBounds(new Rectangle(131, 240, 79, 26));
			jAcceptar.setText("Aceptar");
		}
		return jAcceptar;
	}

	/**
	 * This method initializes jCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJCancelar() {
		if (jCancelar == null) {
			jCancelar = new JButton();
			jCancelar.setBounds(new Rectangle(316, 240, 85, 26));
			jCancelar.setText("Cancelar");
		}
		return jCancelar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
