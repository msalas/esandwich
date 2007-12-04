
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
import javax.swing.*;
import java.awt.Point;

public class PantallaListadosStock extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLlistat = null;

	private JRadioButton jTotalstock = null;

	private JLabel jTotalStock1 = null;

	private JRadioButton jStockmp = null;

	private JLabel jStockmp1 = null;

	private JComboBox jComboBox = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	private JLabel jStockmp11 = null;

	private JRadioButton jStockmp2 = null;

	private JComboBox jComboBox1 = null;

	private ControladorPantallaListarStock cpls = null;
	
	private AplicacionEmpleado ae = null;
	
	/**
	 * This is the default constructor
	 */
	public PantallaListadosStock(AplicacionEmpleado ae) {
		super(ae, "Listar Stock", true);
		this.ae=ae;
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
	
		cpls = new ControladorPantallaListarStock(this,ae);
		
		jAcceptar.setActionCommand("acceptar");
		jAcceptar.addActionListener(cpls);
		
		jCancelar.setActionCommand("cancelar");
		jCancelar.addActionListener(cpls);
		
		jTotalstock.setActionCommand("A");
		jTotalstock.addActionListener(cpls);
		
		jStockmp.setActionCommand("B");
		jStockmp.addActionListener(cpls);
		
		jStockmp2.setActionCommand("C");
		jStockmp2.addActionListener(cpls);
				
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jStockmp11 = new JLabel();
			jStockmp11.setBounds(new Rectangle(149, 132, 113, 16));
			jStockmp11.setText("Stock por Familia:");
			jStockmp1 = new JLabel();
			jStockmp1.setBounds(new Rectangle(149, 94, 156, 16));
			jStockmp1.setText("Stock por Producto:");
			jTotalStock1 = new JLabel();
			jTotalStock1.setText("Stock Total");
			jTotalStock1.setLocation(new Point(150, 58));
			jTotalStock1.setLocation(new Point(149, 60));
			jTotalStock1.setSize(new Dimension(77, 16));
			jLlistat = new JLabel();
			jLlistat.setBounds(new Rectangle(43, 30, 61, 16));
			jLlistat.setText("Listar:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLlistat, null);
			jContentPane.add(getJTotalstock(), null);
			jContentPane.add(jTotalStock1, null);
			jContentPane.add(getJStockmp(), null);
			jContentPane.add(jStockmp1, null);
			jContentPane.add(getJComboBox(), null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
			jContentPane.add(jStockmp11, null);
			jContentPane.add(getJStockmp2(), null);
			jContentPane.add(getJComboBox1(), null);
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
			jTotalstock.setSize(new Dimension(21, 21));
			jTotalstock.setLocation(new Point(110, 54));
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
			jStockmp.setBounds(new Rectangle(111, 92, 21, 21));
		}
		return jStockmp;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(311, 91, 115, 21));
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
	 * This method initializes jStockmp2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJStockmp2() {
		if (jStockmp2 == null) {
			jStockmp2 = new JRadioButton();
			jStockmp2.setBounds(new Rectangle(112, 128, 21, 21));
		}
		return jStockmp2;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	public JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setBounds(new Rectangle(312, 126, 115, 23));
		}
		return jComboBox1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
