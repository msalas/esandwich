

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Point;

public class PantallaProductoExistente extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jartic = null;

	private JLabel jartic2 = null;

	private JButton jAcceptar = null;

	/**
	 * This is the default constructor
	 */
	public PantallaProductoExistente() {
		super();
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
		this.setTitle("Producto Existente");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jartic2 = new JLabel();
			jartic2.setBounds(new Rectangle(60, 73, 301, 16));
			jartic2.setText("Por favor, introduce un nuevo codigo de producto");
			jartic = new JLabel();
			jartic.setBounds(new Rectangle(61, 46, 136, 16));
			jartic.setText("Este producto ya existe");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jartic, null);
			jContentPane.add(jartic2, null);
			jContentPane.add(getJAcceptar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jAcceptar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAcceptar() {
		if (jAcceptar == null) {
			jAcceptar = new JButton();
			jAcceptar.setLocation(new Point(155, 119));
			jAcceptar.setText("Aceptar");
			jAcceptar.setSize(new Dimension(98, 27));
		}
		return jAcceptar;
	}

}
