import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

public class PantallaConsultaFactura extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jContentPane1 = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JLabel jLabel3 = null;

	private JTextField jfinsa11 = null;

	private JTextField jTextField = null;

	private JTextField jTextField1 = null;

	private JTextField jTextField2 = null;

	private JButton jAcceptar = null;

	/**
	 * This is the default constructor
	 */
	public PantallaConsultaFactura() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(534, 325);
		this.setContentPane(getJContentPane());
		this.setTitle("Consultar Factura");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJContentPane1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jContentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	public JPanel getJContentPane1() {
		if (jContentPane1 == null) {
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
			jContentPane1 = new JPanel();
			jContentPane1.setLayout(null);
			jContentPane1.setBounds(new Rectangle(-2, 0, 532, 297));
			jContentPane1.add(jLabel, null);
			jContentPane1.add(jLabel1, null);
			jContentPane1.add(jLabel2, null);
			jContentPane1.add(jLabel3, null);
			jContentPane1.add(getJfinsa11(), null);
			jContentPane1.add(getJTextField(), null);
			jContentPane1.add(getJTextField1(), null);
			jContentPane1.add(getJTextField2(), null);
			jContentPane1.add(getJAcceptar(), null);
		}
		return jContentPane1;
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
			jAcceptar.setBounds(new Rectangle(221, 235, 79, 26));
			jAcceptar.setText("Aceptar");
		}
		return jAcceptar;
	}

}  //  @jve:decl-index=0:visual-constraint="13,8"
