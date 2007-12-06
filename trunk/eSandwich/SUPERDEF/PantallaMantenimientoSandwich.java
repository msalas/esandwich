import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JButton;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class PantallaMantenimientoSandwich extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jTituloLabel = null;

	private JTable jSandwichTable = null;

	private JButton jAceptarButton = null;

	private JButton jModificarButton = null;

	private JButton jConsultarButton = null;

	private JButton jSuprimirButton = null;

	/**
	 * @param owner
	 */
	
	private AplicacionEmpleado aplicacionEmpleado=null;
    private ControladorPantallaMantenimientoSandwich cPantallaMantenimientoSandwich=null;
    
    
	public PantallaMantenimientoSandwich(AplicacionEmpleado aplicacionEmpleado){
		
		super(aplicacionEmpleado,"Mantenimiento de sandwich",true);
		System.out.println("Entro en pantalla");
		this.aplicacionEmpleado=aplicacionEmpleado;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws errorConexionBD 
	 * @throws RemoteException 
	 */
	private void initialize() {
		this.setSize(667, 496);
		
		cPantallaMantenimientoSandwich=new ControladorPantallaMantenimientoSandwich(this,aplicacionEmpleado);
		this.setContentPane(getJContentPane());
		
		//jAceptarButton.setActionCommand("aceptar");
	    //jAceptarButton.addActionListener(cPantallaAltaSandwich);
	    
	    //jCancelarButton.setActionCommand("cancelar");
		//jCancelarButton.addActionListener(cPantallaAltaSandwich);

		//jSuprimirButton.setActionCommand("suprimir");
		//jCancelarButton.addActionListener(cPantallaAltaSandwich);
		
		//jAñadirIngredienteButton.setActionCommand("añadir");
        //jAñadirIngredienteButton.addActionListener(cPantallaAltaSandwich);
		//this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws errorConexionBD 
	 * @throws RemoteException 
	 */
	private JPanel getJContentPane(){
		if (jContentPane == null) {
			jTituloLabel = new JLabel();
			jTituloLabel.setBounds(new Rectangle(221, 36, 214, 16));
			jTituloLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jTituloLabel.setText("Mantenimiento de Sandwich");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jTituloLabel, null);
			jContentPane.add(getJSandwichTable(), null);
			jContentPane.add(getJAceptarButton(), null);
			jContentPane.add(getJModificarButton(), null);
			jContentPane.add(getJConsultarButton(), null);
			jContentPane.add(getJSuprimirButton(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jSandwichTable	
	 * 	
	 * @return javax.swing.JTable	
	 * @throws errorConexionBD 
	 * @throws RemoteException 
	 */
	private JTable getJSandwichTable() {
		if (jSandwichTable == null) {
			Object [][] listaSandwich=cPantallaMantenimientoSandwich.listaSandwich();
			Object [] names=new String[2];
			names[0]="Código";
			names[1]="Nombre";
			
			jSandwichTable = new JTable(listaSandwich,names);
			jSandwichTable.setBounds(new Rectangle(142, 93, 375, 176));
			jSandwichTable.setVisible(true);
			
			
		}
		return jSandwichTable;
	}

	/**
	 * This method initializes jAceptarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJAceptarButton() {
		if (jAceptarButton == null) {
			jAceptarButton = new JButton();
			jAceptarButton.setBounds(new Rectangle(111, 339, 84, 25));
			jAceptarButton.setText("Aceptar");
		}
		return jAceptarButton;
	}

	/**
	 * This method initializes jModificarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJModificarButton() {
		if (jModificarButton == null) {
			jModificarButton = new JButton();
			jModificarButton.setBounds(new Rectangle(225, 337, 87, 27));
			jModificarButton.setText("Modificar");
		}
		return jModificarButton;
	}

	/**
	 * This method initializes jConsultarButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJConsultarButton() {
		if (jConsultarButton == null) {
			jConsultarButton = new JButton();
			jConsultarButton.setBounds(new Rectangle(342, 338, 94, 26));
			jConsultarButton.setText("Consultar");
		}
		return jConsultarButton;
	}

	/**
	 * This method initializes jSuprimirButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJSuprimirButton() {
		if (jSuprimirButton == null) {
			jSuprimirButton = new JButton();
			jSuprimirButton.setBounds(new Rectangle(464, 337, 93, 27));
			jSuprimirButton.setText("Suprimir");
		}
		return jSuprimirButton;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
