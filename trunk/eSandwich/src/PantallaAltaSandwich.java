import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;

public class PantallaAltaSandwich extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jTituloLabel = null;

	private JLabel jIdLabel = null;

	private JLabel jNombreLabel = null;

	private JLabel jDescripcionLabel = null;

	private JLabel jTipoSandwichLabel = null;

	private JLabel jPrecioLabel = null;

	private JLabel jIngredientesLabel = null;

	private JButton jAceptarButton = null;

	private JButton jCancelarButton = null;

	private JTextField jIdSandwichText = null;

	private JTextField jNombreText = null;

	private JTextField jPrecioText = null;

	private JComboBox jTipoComboBox = null;

	private JComboBox jIngredientesComboBox = null;

	private JTextArea jDescripcionTextArea = null;

	private JButton jSuprimirButton = null;
	
	private AplicacionEmpleado aplicacionEmpleado=null;
    private ControladorPantallaAltaSandwich cPantallaAltaSandwich=null;

	private JList jIngredientesList = null;

	private JButton jAñadirIngredienteButton = null;
	
	Vector <String> v=new Vector<String>();
	Vector <String> ingredientesSelec=new Vector<String>();

	/**
	 * @param owner
	 */
	public PantallaAltaSandwich(AplicacionEmpleado aplicacionEmpleado) {
		super(aplicacionEmpleado,"Alta  de sandwich",true);
		this.aplicacionEmpleado=aplicacionEmpleado;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(788, 464);
		
		cPantallaAltaSandwich=new ControladorPantallaAltaSandwich(this,aplicacionEmpleado);
		this.setContentPane(getJContentPane());
		
		jAceptarButton.setActionCommand("aceptar");
	    jAceptarButton.addActionListener(cPantallaAltaSandwich);
	    
	    jCancelarButton.setActionCommand("cancelar");
		jCancelarButton.addActionListener(cPantallaAltaSandwich);

		jSuprimirButton.setActionCommand("suprimir");
		jCancelarButton.addActionListener(cPantallaAltaSandwich);
		
		jAñadirIngredienteButton.setActionCommand("añadir");
        jAñadirIngredienteButton.addActionListener(cPantallaAltaSandwich);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jIngredientesLabel = new JLabel();
			jIngredientesLabel.setBounds(new Rectangle(104, 208, 138, 16));
			jIngredientesLabel.setText("Ingredientes");
			jPrecioLabel = new JLabel();
			jPrecioLabel.setBounds(new Rectangle(104, 150, 138, 16));
			jPrecioLabel.setText("Precio");
			jTipoSandwichLabel = new JLabel();
			jTipoSandwichLabel.setBounds(new Rectangle(104, 178, 138, 16));
			jTipoSandwichLabel.setText("Tipo de Sandwich");
			jDescripcionLabel = new JLabel();
			jDescripcionLabel.setBounds(new Rectangle(105, 240, 138, 16));
			jDescripcionLabel.setText("Descripción");
			jNombreLabel = new JLabel();
			jNombreLabel.setBounds(new Rectangle(104, 120, 136, 16));
			jNombreLabel.setText("Nombre");
			jIdLabel = new JLabel();
			jIdLabel.setBounds(new Rectangle(104, 91, 139, 16));
			jIdLabel.setText("Identificación");
			jTituloLabel = new JLabel();
			jTituloLabel.setBounds(new Rectangle(205, 28, 191, 16));
			jTituloLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jTituloLabel.setText("Alta de Sandwich");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jTituloLabel, null);
			jContentPane.add(jIdLabel, null);
			jContentPane.add(jNombreLabel, null);
			jContentPane.add(jDescripcionLabel, null);
			jContentPane.add(jTipoSandwichLabel, null);
			jContentPane.add(jPrecioLabel, null);
			jContentPane.add(jIngredientesLabel, null);
			jContentPane.add(getJAceptarButton(), null);
			jContentPane.add(getJCancelarButton(), null);
			jContentPane.add(getJIdSandwichText(), null);
			jContentPane.add(getJNombreText(), null);
			jContentPane.add(getJPrecioText(), null);
			jContentPane.add(getJTipoComboBox(), null);
			jContentPane.add(getJIngredientesComboBox(), null);
			jContentPane.add(getJDescripcionTextArea(), null);
			jContentPane.add(getJSuprimirButton(), null);
			jContentPane.add(getJIngredientesList(v), null);
			jContentPane.add(getJAñadirIngredienteButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jAceptarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	JButton getJAceptarButton() {
		if (jAceptarButton == null) {
			jAceptarButton = new JButton();
			jAceptarButton.setBounds(new Rectangle(194, 337, 106, 21));
			jAceptarButton.setText("Aceptar");
		}
		return jAceptarButton;
	}

	/**
	 * This method initializes jCancelarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	 JButton getJCancelarButton() {
		if (jCancelarButton == null) {
			jCancelarButton = new JButton();
			jCancelarButton.setBounds(new Rectangle(388, 337, 105, 22));
			jCancelarButton.setText("Cancelar");
		}
		return jCancelarButton;
	}

	/**
	 * This method initializes jIdSandwichText	
	 * 
	 * 	
	 * @return javax.swing.JTextField
	 */
	  JTextField getJIdSandwichText() {
		if (jIdSandwichText == null) {
			jIdSandwichText = new JTextField();
			jIdSandwichText.setBounds(new Rectangle(284, 91, 56, 20));
			jIdSandwichText.setEditable(false);
		}
		return jIdSandwichText;
	}

	/**
	 * This method initializes jNombreText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	JTextField getJNombreText() {
		if (jNombreText == null) {
			jNombreText = new JTextField();
			jNombreText.setBounds(new Rectangle(285, 116, 139, 20));
		}
		return jNombreText;
	}

	/**
	 * This method initializes jPrecioText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	JTextField getJPrecioText() {
		if (jPrecioText == null) {
			jPrecioText = new JTextField();
			jPrecioText.setBounds(new Rectangle(284, 147, 64, 20));
		}
		return jPrecioText;
	}

	/**
	 * This method initializes jTipoComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	
      JComboBox getJTipoComboBox() {
		if (jTipoComboBox == null) {
			Vector <String> tipos=new Vector <String>();
			tipos=(Vector<String>) cPantallaAltaSandwich.getTiposSandwich();
			jTipoComboBox = new JComboBox(tipos);
			jTipoComboBox.setBounds(new Rectangle(284, 175, 142, 17));
		}
		return jTipoComboBox;
	}

	/**
	 * This method initializes jIngredientesComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	 JComboBox getJIngredientesComboBox() {
		if (jIngredientesComboBox == null) {
			Vector <String> ingredientes=new Vector <String>();
			ingredientes=(Vector<String>) cPantallaAltaSandwich.getIngredientes();
			jIngredientesComboBox = new JComboBox(ingredientes);
			
			
			
			
			jIngredientesComboBox.setBounds(new Rectangle(285, 208, 141, 17));
		}
		return jIngredientesComboBox;
	}
	 
	/*public void  jIngredientesComboBoxActionPerformed(ActionEvent evt){
		ingredientesSelec.addElement((String) jIngredientesComboBox.getSelectedItem());
		jIngredientesList.setListData(ingredientesSelec);
		
	}*/

	/**
	 * This method initializes jDescripcionTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
     JTextArea getJDescripcionTextArea() {
		if (jDescripcionTextArea == null) {
			jDescripcionTextArea = new JTextArea();
			jDescripcionTextArea.setBounds(new Rectangle(284, 241, 143, 54));
		}
		return jDescripcionTextArea;
	}

	/**
	 * This method initializes jSuprimirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	 JButton getJSuprimirButton() {
		if (jSuprimirButton == null) {
			jSuprimirButton = new JButton();
			jSuprimirButton.setBounds(new Rectangle(623, 273, 86, 21));
			jSuprimirButton.setText("Suprimir");
		}
		return jSuprimirButton;
	}

	/**
	 * This method initializes jIngredientesList	
	 * 	
	 * @return javax.swing.JList	
	 */
	JList getJIngredientesList(Vector v) {
		if (jIngredientesList == null) {
			
			jIngredientesList = new JList(v);
			jIngredientesList.setBounds(new Rectangle(600, 120, 132, 135));
		}
		return jIngredientesList;
	}

	/**
	 * This method initializes jAñadirIngredienteButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	JButton getJAñadirIngredienteButton() {
		if (jAñadirIngredienteButton == null) {
			jAñadirIngredienteButton = new JButton();
			jAñadirIngredienteButton.setBounds(new Rectangle(466, 198, 103, 26));
			jAñadirIngredienteButton.setText("Añade >>");
		}
		return jAñadirIngredienteButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
