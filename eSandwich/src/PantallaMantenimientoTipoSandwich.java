import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;

public class PantallaMantenimientoTipoSandwich extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jTituloLabel = null;

	

	private JButton jAceptarButton = null;

	private JButton jSuprimirButton = null;
	
	private AplicacionEmpleado aplicacionEmpleado=null;
    private ControladorPantallaMantenimientoTipoSandwich cPantallaMantenimientoTipoSandwich=null;

	private JList jIngredientesList = null;

	/**
	 * @param owner
	 */
	public PantallaMantenimientoTipoSandwich(AplicacionEmpleado aplicacionEmpleado) {
		
		super(aplicacionEmpleado,"Mantenimiento de Tipo de Sandwich",true);
		System.out.println("constructor pantalla...");
		this.aplicacionEmpleado=aplicacionEmpleado;
		
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(658, 451);
		
		
		cPantallaMantenimientoTipoSandwich=new ControladorPantallaMantenimientoTipoSandwich(this,aplicacionEmpleado);
		
		this.setContentPane(getJContentPane());
		
		jSuprimirButton.addActionListener(cPantallaMantenimientoTipoSandwich);
		
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jTituloLabel = new JLabel();
			jTituloLabel.setBounds(new Rectangle(181, 31, 245, 16));
			jTituloLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jTituloLabel.setText("Mantenimiento Tipo Sandwich");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jTituloLabel, null);
			
			jContentPane.add(getJAceptarButton(), null);
			jContentPane.add(getJSuprimirButton(), null);
			jContentPane.add(getJIngredientesList(), null);
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
			jAceptarButton.setBounds(new Rectangle(166, 300, 95, 28));
			jAceptarButton.setText("Aceptar");
		}
		return jAceptarButton;
	}

	/**
	 * This method initializes jSuprimirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJSuprimirButton() {
		if (jSuprimirButton == null) {
			jSuprimirButton = new JButton();
			jSuprimirButton.setBounds(new Rectangle(340, 299, 108, 28));
			jSuprimirButton.setText("Suprimir");
		}
		return jSuprimirButton;
	}

	/**
	 * This method initializes jIngredientesList	
	 * 	
	 * @return javax.swing.JList	
	 */
	JList getJIngredientesList() {
		if (jIngredientesList == null) {
			Vector <String> ingredientes=new Vector <String>();
			ingredientes=(Vector<String>) cPantallaMantenimientoTipoSandwich.getTipoSandwich();
			jIngredientesList = new JList(ingredientes);
			jIngredientesList.setBounds(new Rectangle(220, 87, 179, 180));
		}
		return jIngredientesList;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
