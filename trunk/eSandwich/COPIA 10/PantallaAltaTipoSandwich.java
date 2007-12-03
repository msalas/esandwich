import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;

public class PantallaAltaTipoSandwich extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jTitulo = null;

	private JLabel jIdTipoSandwich = null;

	private JTextField jIdentificadorTextField = null;

	private JLabel jNombreLabel = null;

	private JTextField jNombreTextField = null;

	private JButton jAceptarButton = null;

	private JButton jCancelarButton = null;
	
	private AplicacionEmpleado aplicacionEmpleado=null;
    private ControladorPantallaAltaTipoSandwich cPantallaAltaTipoSandwich=null;
	/**
	 * @param owner
	 */
	public PantallaAltaTipoSandwich(AplicacionEmpleado aplicacionEmpleado) {
		super(aplicacionEmpleado,"Alta de tipo de sandwich",true);
		this.aplicacionEmpleado=aplicacionEmpleado;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(551, 269);
		this.setSize(new Dimension(768, 509));
		this.setContentPane(getJContentPane());
		
		cPantallaAltaTipoSandwich=new ControladorPantallaAltaTipoSandwich(this,aplicacionEmpleado);
	    jAceptarButton.addActionListener(cPantallaAltaTipoSandwich);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jNombreLabel = new JLabel();
			jNombreLabel.setBounds(new Rectangle(86, 90, 110, 16));
			jNombreLabel.setBounds(new Rectangle(90, 209, 110, 16));
			jNombreLabel.setText("Nombre");
			jIdTipoSandwich = new JLabel();
			jIdTipoSandwich.setBounds(new Rectangle(86, 60, 114, 16));
			jIdTipoSandwich.setBounds(new Rectangle(91, 164, 114, 16));
			jIdTipoSandwich.setText("Identificador");
			jTitulo = new JLabel();
			jTitulo.setBounds(new Rectangle(185, 16, 134, 16));
			jTitulo.setBounds(new Rectangle(288, 17, 134, 16));
			jTitulo.setFont(new Font("Dialog", Font.BOLD, 14));
			jTitulo.setText("Alta Tipo Sandwich");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jTitulo, null);
			jContentPane.add(jIdTipoSandwich, null);
			jContentPane.add(getJIdentificadorTextField(), null);
			jContentPane.add(jNombreLabel, null);
			jContentPane.add(getJNombreTextField(), null);
			jContentPane.add(getJAceptarButton(), null);
			jContentPane.add(getJCancelarButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jIdentificadorTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	JTextField getJIdentificadorTextField() {
		if (jIdentificadorTextField == null) {
			jIdentificadorTextField = new JTextField();
			jIdentificadorTextField.setBounds(new Rectangle(276, 60, 61, 20));
			jIdentificadorTextField.setBounds(new Rectangle(256, 164, 61, 20));
		}
		return jIdentificadorTextField;
	}

	/**
	 * This method initializes jNombreTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	JTextField getJNombreTextField() {
		if (jNombreTextField == null) {
			jNombreTextField = new JTextField();
			jNombreTextField.setBounds(new Rectangle(276, 89, 112, 20));
			jNombreTextField.setBounds(new Rectangle(256, 209, 224, 20));
		}
		return jNombreTextField;
	}

	/**
	 * This method initializes jAceptarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAceptarButton() {
		if (jAceptarButton == null) {
			jAceptarButton = new JButton();
			jAceptarButton.setBounds(new Rectangle(125, 175, 107, 28));
			jAceptarButton.setBounds(new Rectangle(203, 375, 107, 28));
			jAceptarButton.setText("Aceptar");
		}
		return jAceptarButton;
	}

	/**
	 * This method initializes jCancelarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJCancelarButton() {
		if (jCancelarButton == null) {
			jCancelarButton = new JButton();
			jCancelarButton.setBounds(new Rectangle(340, 175, 113, 31));
			jCancelarButton.setBounds(new Rectangle(375, 375, 113, 31));
			jCancelarButton.setText("Cancelar");
		}
		return jCancelarButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
