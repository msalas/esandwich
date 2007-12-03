import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class PantallaConsultaSandwich extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private AplicacionEmpleado aplicacionEmpleado=null;
    private ControladorPantallaConsultaSandwich cPantallaConsultaSandwich=null;

	private JLabel jTituloLabel = null;

	private JLabel jIdLabel = null;

	private JLabel jNombreLabel = null;

	private JLabel jPrecioLabel = null;

	private JLabel jIngredientesLabel = null;

	private JButton jAceptarButton = null;

	private JTextField jIdentificadorText = null;

	private JTextField jNombreText = null;

	private JTextField jPrecioText = null;

	private JTable jIngredientesTable = null;

	private JLabel jDescripcionLabel = null;

	private JTextArea jDescripcionTextArea = null;

	private JButton jModificarButton = null;

	private JButton jCancelarButton = null;

	private JButton jCancelarVerdaderoButton = null;

	private JLabel jTipoSandwichLabel = null;

	private JComboBox jTipoSandwichComboBox = null;

	/**
	 * @param owner
	 */
	public PantallaConsultaSandwich(AplicacionEmpleado aplicacionEmpleado) {
		super(aplicacionEmpleado,"Consulta de sandwich",true);
		this.aplicacionEmpleado=aplicacionEmpleado;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(697, 498);
		this.setSize(new Dimension(768, 509));
		this.setContentPane(getJContentPane());
		
		cPantallaConsultaSandwich=new ControladorPantallaConsultaSandwich(this,aplicacionEmpleado);
	    //jAceptarButton.addActionListener(cPantallaConsultaSandwich);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jTipoSandwichLabel = new JLabel();
			jTipoSandwichLabel.setBounds(new Rectangle(103, 196, 127, 16));
			jTipoSandwichLabel.setText("Tipo de Sandwich");
			jDescripcionLabel = new JLabel();
			jDescripcionLabel.setBounds(new Rectangle(102, 234, 129, 16));
			jDescripcionLabel.setEnabled(true);
			jDescripcionLabel.setText("Descripción");
			jIngredientesLabel = new JLabel();
			jIngredientesLabel.setBounds(new Rectangle(103, 286, 123, 16));
			jIngredientesLabel.setText("Ingredientes");
			jPrecioLabel = new JLabel();
			jPrecioLabel.setBounds(new Rectangle(102, 165, 117, 16));
			jPrecioLabel.setText("Precio");
			jNombreLabel = new JLabel();
			jNombreLabel.setBounds(new Rectangle(103, 136, 125, 16));
			jNombreLabel.setText("Nombre");
			jIdLabel = new JLabel();
			jIdLabel.setBounds(new Rectangle(104, 105, 127, 16));
			jIdLabel.setText("Identificador");
			jTituloLabel = new JLabel();
			jTituloLabel.setBounds(new Rectangle(165, 44, 396, 16));
			jTituloLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jTituloLabel.setText("Consulta/Modificación/Eliminación de Sandwich");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jTituloLabel, null);
			jContentPane.add(jIdLabel, null);
			jContentPane.add(jNombreLabel, null);
			jContentPane.add(jPrecioLabel, null);
			jContentPane.add(jIngredientesLabel, null);
			jContentPane.add(getJAceptarButton(), null);
			jContentPane.add(getJIdentificadorText(), null);
			jContentPane.add(getJNombreText(), null);
			jContentPane.add(getJPrecioText(), null);
			jContentPane.add(getJIngredientesTable(), null);
			jContentPane.add(jDescripcionLabel, null);
			jContentPane.add(getJDescripcionTextArea(), null);
			jContentPane.add(getJModificarButton(), null);
			jContentPane.add(getJCancelarButton(), null);
			jContentPane.add(getJCancelarVerdaderoButton(), null);
			jContentPane.add(jTipoSandwichLabel, null);
			jContentPane.add(getJTipoSandwichComboBox(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jAceptarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAceptarButton() {
		if (jAceptarButton == null) {
			jAceptarButton = new JButton();
			jAceptarButton.setBounds(new Rectangle(76, 385, 93, 25));
			jAceptarButton.setText("Aceptar");
		}
		return jAceptarButton;
	}

	/**
	 * This method initializes jIdentificadorText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJIdentificadorText() {
		if (jIdentificadorText == null) {
			jIdentificadorText = new JTextField();
			jIdentificadorText.setBounds(new Rectangle(271, 102, 86, 20));
			jIdentificadorText.setEditable(false);
		}
		return jIdentificadorText;
	}

	/**
	 * This method initializes jNombreText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJNombreText() {
		if (jNombreText == null) {
			jNombreText = new JTextField();
			jNombreText.setBounds(new Rectangle(270, 134, 170, 20));
			jNombreText.setEditable(false);
		}
		return jNombreText;
	}

	/**
	 * This method initializes jPrecioText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJPrecioText() {
		if (jPrecioText == null) {
			jPrecioText = new JTextField();
			jPrecioText.setBounds(new Rectangle(270, 159, 71, 20));
			jPrecioText.setEditable(false);
		}
		return jPrecioText;
	}

	/**
	 * This method initializes jIngredientesTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJIngredientesTable() {
		if (jIngredientesTable == null) {
			jIngredientesTable = new JTable();
			jIngredientesTable.setBounds(new Rectangle(285, 285, 236, 80));
		}
		return jIngredientesTable;
	}

	/**
	 * This method initializes jDescripcionTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJDescripcionTextArea() {
		if (jDescripcionTextArea == null) {
			jDescripcionTextArea = new JTextArea();
			jDescripcionTextArea.setBounds(new Rectangle(271, 235, 233, 38));
			jDescripcionTextArea.setEditable(false);
		}
		return jDescripcionTextArea;
	}

	/**
	 * This method initializes jModificarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJModificarButton() {
		if (jModificarButton == null) {
			jModificarButton = new JButton();
			jModificarButton.setBounds(new Rectangle(196, 384, 98, 25));
			jModificarButton.setText("Modificar");
		}
		return jModificarButton;
	}

	/**
	 * This method initializes jCancelarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJCancelarButton() {
		if (jCancelarButton == null) {
			jCancelarButton = new JButton();
			jCancelarButton.setBounds(new Rectangle(321, 385, 100, 25));
			jCancelarButton.setText("Eliminar");
		}
		return jCancelarButton;
	}

	/**
	 * This method initializes jCancelarVerdaderoButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJCancelarVerdaderoButton() {
		if (jCancelarVerdaderoButton == null) {
			jCancelarVerdaderoButton = new JButton();
			jCancelarVerdaderoButton.setBounds(new Rectangle(461, 384, 89, 27));
			jCancelarVerdaderoButton.setText("Cancelar");
		}
		return jCancelarVerdaderoButton;
	}

	/**
	 * This method initializes jTipoSandwichComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJTipoSandwichComboBox() {
		if (jTipoSandwichComboBox == null) {
			jTipoSandwichComboBox = new JComboBox();
			jTipoSandwichComboBox.setBounds(new Rectangle(270, 194, 197, 18));
		}
		return jTipoSandwichComboBox;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
