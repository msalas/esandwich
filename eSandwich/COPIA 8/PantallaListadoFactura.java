import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaListadoFactura extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLlistat = null;

	private JRadioButton jTotalstock = null;

	private JRadioButton jTotalstock1 = null;

	private JLabel jTotalStock1 = null;

	private JLabel jStockmp1 = null;

	private JTextField jTextField = null;

	private JRadioButton jTotalstock11 = null;

	private JLabel jStockmp11 = null;

	private JLabel jfinsa2 = null;

	private JLabel jfinsa = null;

	private JTextField jfinsa11 = null;

	private JTextField jfinsa111 = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	private JTextField jTextField1 = null;

	/**
	 * This is the default constructor
	 */
	public PantallaListadoFactura() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(562, 335);
		this.setContentPane(getJContentPane());
		this.setTitle("Listado Factura");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jfinsa = new JLabel();
			jfinsa.setBounds(new Rectangle(380, 193, 33, 16));
			jfinsa.setText("Hasta");
			jfinsa2 = new JLabel();
			jfinsa2.setBounds(new Rectangle(380, 165, 36, 16));
			jfinsa2.setText("Desde");
			jStockmp11 = new JLabel();
			jStockmp11.setBounds(new Rectangle(175, 118, 217, 24));
			jStockmp11.setText("Factura por Producto entre periodo:");
			jStockmp1 = new JLabel();
			jStockmp1.setBounds(new Rectangle(175, 70, 146, 25));
			jStockmp1.setText("Factura por Producto:");
			jTotalStock1 = new JLabel();
			jTotalStock1.setBounds(new Rectangle(173, 27, 116, 24));
			jTotalStock1.setText("Facturacion Total");
			jLlistat = new JLabel();
			jLlistat.setBounds(new Rectangle(48, 30, 36, 16));
			jLlistat.setText("Listar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLlistat, null);
			jContentPane.add(getJTotalstock(), null);
			jContentPane.add(getJTotalstock1(), null);
			jContentPane.add(jTotalStock1, null);
			jContentPane.add(jStockmp1, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTotalstock11(), null);
			jContentPane.add(jStockmp11, null);
			jContentPane.add(jfinsa2, null);
			jContentPane.add(jfinsa, null);
			jContentPane.add(getJfinsa11(), null);
			jContentPane.add(getJfinsa111(), null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
			jContentPane.add(getJTextField1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTotalstock	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJTotalstock() {
		if (jTotalstock == null) {
			jTotalstock = new JRadioButton();
			jTotalstock.setBounds(new Rectangle(134, 29, 21, 21));
		}
		return jTotalstock;
	}

	/**
	 * This method initializes jTotalstock1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJTotalstock1() {
		if (jTotalstock1 == null) {
			jTotalstock1 = new JRadioButton();
			jTotalstock1.setBounds(new Rectangle(134, 74, 21, 21));
		}
		return jTotalstock1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(354, 70, 153, 19));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTotalstock11	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJTotalstock11() {
		if (jTotalstock11 == null) {
			jTotalstock11 = new JRadioButton();
			jTotalstock11.setBounds(new Rectangle(136, 120, 21, 21));
		}
		return jTotalstock11;
	}

	/**
	 * This method initializes jfinsa11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJfinsa11() {
		if (jfinsa11 == null) {
			jfinsa11 = new JTextField();
			jfinsa11.setBounds(new Rectangle(445, 161, 60, 20));
			jfinsa11.setText("dd/mm/aa");
		}
		return jfinsa11;
	}

	/**
	 * This method initializes jfinsa111	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJfinsa111() {
		if (jfinsa111 == null) {
			jfinsa111 = new JTextField();
			jfinsa111.setBounds(new Rectangle(444, 191, 60, 20));
			jfinsa111.setText("dd/mm/aa");
		}
		return jfinsa111;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setBounds(new Rectangle(129, 240, 79, 26));
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
			jCancelar.setBounds(new Rectangle(306, 240, 85, 26));
			jCancelar.setText("Cancelar");
		}
		return jCancelar;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(415, 120, 93, 21));
		}
		return jTextField1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
