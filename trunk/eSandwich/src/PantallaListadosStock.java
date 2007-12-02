

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Point;

public class PantallaListadosStock extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jstock = null;

	private JLabel jfinsa = null;

	private JTextField jfinsa1 = null;

	private JLabel jLlistat = null;

	private JRadioButton jTotalstock = null;

	private JLabel jTotalStock1 = null;

	private JRadioButton jStockmp = null;

	private JLabel jStockmp1 = null;

	private JComboBox jComboBox = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	private JTextField jfinsa11 = null;

	private JLabel jfinsa2 = null;

	private JLabel jStockmp11 = null;

	private JRadioButton jStockmp2 = null;

	private JComboBox jComboBox1 = null;

	/**
	 * This is the default constructor
	 */
	public PantallaListadosStock() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(457, 325);
		this.setContentPane(getJContentPane());
		this.setTitle("Listar Stocks");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jStockmp11 = new JLabel();
			jStockmp11.setBounds(new Rectangle(88, 211, 113, 16));
			jStockmp11.setText("Stock por Familia:");
			jfinsa2 = new JLabel();
			jfinsa2.setBounds(new Rectangle(111, 59, 48, 16));
			jfinsa2.setText("Desde");
			jStockmp1 = new JLabel();
			jStockmp1.setBounds(new Rectangle(88, 180, 156, 16));
			jStockmp1.setText("Stock por Producto:");
			jTotalStock1 = new JLabel();
			jTotalStock1.setText("Stock Total");
			jTotalStock1.setLocation(new Point(88, 149));
			jTotalStock1.setSize(new Dimension(77, 16));
			jLlistat = new JLabel();
			jLlistat.setBounds(new Rectangle(29, 117, 61, 16));
			jLlistat.setText("Listar:");
			jfinsa = new JLabel();
			jfinsa.setBounds(new Rectangle(114, 89, 38, 16));
			jfinsa.setText("Hasta");
			jstock = new JLabel();
			jstock.setBounds(new Rectangle(29, 25, 257, 16));
			jstock.setText("Selecciona el periodo a consultar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jstock, null);
			jContentPane.add(jfinsa, null);
			jContentPane.add(getJfinsa1(), null);
			jContentPane.add(jLlistat, null);
			jContentPane.add(getJTotalstock(), null);
			jContentPane.add(jTotalStock1, null);
			jContentPane.add(getJStockmp(), null);
			jContentPane.add(jStockmp1, null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
			jContentPane.add(getJfinsa11(), null);
			jContentPane.add(jfinsa2, null);
			jContentPane.add(jStockmp11, null);
			jContentPane.add(getJStockmp2(), null);
			jContentPane.add(getJComboBox1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jfinsa1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJfinsa1() {
		if (jfinsa1 == null) {
			jfinsa1 = new JTextField();
			jfinsa1.setText("dd/mm/aa");
			jfinsa1.setLocation(new Point(179, 87));
			jfinsa1.setSize(new Dimension(114, 20));
		}
		return jfinsa1;
	}

	/**
	 * This method initializes jTotalstock	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJTotalstock() {
		if (jTotalstock == null) {
			jTotalstock = new JRadioButton();
			jTotalstock.setSize(new Dimension(21, 21));
			jTotalstock.setLocation(new Point(60, 147));
		}
		return jTotalstock;
	}

	/**
	 * This method initializes jStockmp	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJStockmp() {
		if (jStockmp == null) {
			jStockmp = new JRadioButton();
			jStockmp.setBounds(new Rectangle(60, 176, 21, 21));
		}
		return jStockmp;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(252, 176, 115, 21));
		}
		return jComboBox;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setBounds(new Rectangle(116, 244, 86, 26));
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
			jCancelar.setBounds(new Rectangle(241, 244, 91, 26));
			jCancelar.setText("Cancelar");
		}
		return jCancelar;
	}

	/**
	 * This method initializes jfinsa11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJfinsa11() {
		if (jfinsa11 == null) {
			jfinsa11 = new JTextField();
			jfinsa11.setBounds(new Rectangle(180, 57, 112, 20));
			jfinsa11.setText("dd/mm/aa");
		}
		return jfinsa11;
	}

	/**
	 * This method initializes jStockmp2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJStockmp2() {
		if (jStockmp2 == null) {
			jStockmp2 = new JRadioButton();
			jStockmp2.setBounds(new Rectangle(60, 208, 21, 21));
		}
		return jStockmp2;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setBounds(new Rectangle(252, 207, 115, 23));
		}
		return jComboBox1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
