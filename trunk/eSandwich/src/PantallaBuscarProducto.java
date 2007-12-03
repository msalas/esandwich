

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

public class PantallaBuscarProducto extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jCodibaixa = null;

	private JTextField jcodiArticle = null;

	private JButton jAcceptar = null;

	private JButton jCancelar = null;

	private AplicacionEmpleado ae = null;
	
	private ControladorPantallaBuscarProducto cpbp = null;
	
	/**
	 * This is the default constructor
	 */
	public PantallaBuscarProducto(AplicacionEmpleado ae) {
		super(ae, "Buscar Producto", true);
		this.ae = ae;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(409, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Buscar Producto");
		

		cpbp = new ControladorPantallaBuscarProducto(this,ae);
		
		jAcceptar.addActionListener(cpbp);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jCodibaixa = new JLabel();
			jCodibaixa.setBounds(new Rectangle(59, 60, 108, 16));
			jCodibaixa.setText("Codigo Producto");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jCodibaixa, null);
			jContentPane.add(getJcodiArticle(), null);
			jContentPane.add(getJAcceptar(), null);
			jContentPane.add(getJCancelar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jcodiArticle	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJcodiArticle() {
		if (jcodiArticle == null) {
			jcodiArticle = new JTextField();
			jcodiArticle.setBounds(new Rectangle(189, 59, 170, 20));
		}
		return jcodiArticle;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setText("Aceptar");
			jAcceptar.setBounds(new Rectangle(104, 114, 91, 26));
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
			jCancelar.setBounds(new Rectangle(223, 113, 91, 26));
			jCancelar.setText("Cancelar");
		}
		return jCancelar;
	}

}
