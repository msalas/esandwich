
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDialog;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaBuscarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabelNif = null;

	private JTextField jTextFieldNif = null;

	private JLabel jLabelNom = null;

	private JTextField jTextFieldNom = null;

	private JLabel jLabelCognoms = null;

	private JTextField jTextFieldCognoms = null;

	private JPanel jPanel = null;

	private JButton jButtonTrobar = null;

	private JLabel jLabelLlistatTrobat = null;

	private JButton jButtonSeleccionar = null;

	private JPanel jPanelBuscarDades = null;

	private JComboBox jComboBoxTipusUsuari = null;

	private JLabel jLabelTipusUsuari = null;

	private JButton jButtonCancellar = null;

	private JScrollPane jScrollPaneLlista = null;

	private JTable jTableLlista = null;

	private AplicacionEmpleado ae;
	private Vector vectorCombo = null;  //  @jve:decl-index=0:
	private Vector <Empleado> listaData = null;  //  @jve:decl-index=0:
	private ControladorPantallaBuscarEmpleado cpl = null;
	private int idSelecTabla = 0;
	private String PantallaDestino="";
	

	/**
	 * This is the default constructor
	 */
	public PantallaBuscarEmpleado(AplicacionEmpleado ae, String pantallaDestino) {
		super(ae,"Búsqueda Empleado",true);
		this.ae = ae;
		PantallaDestino = pantallaDestino;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(494, 384);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Búsqueda Empleado");
		// Para centrar pantalla
		this.setLocationRelativeTo(null);		
		cpl = new ControladorPantallaBuscarEmpleado(this,ae);
		jButtonTrobar.setActionCommand("BUS");
		jButtonSeleccionar.setActionCommand("SEL");
		jButtonTrobar.addActionListener(cpl);
		jButtonSeleccionar.addActionListener(cpl);
		cpl.iniCombo();
		jPanelBuscarDades.add(getJComboBoxTipusUsuari(), null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCognoms = new JLabel();
			jLabelCognoms.setText("Apellido:");
			jLabelCognoms.setLocation(new Point(150, 40));
			jLabelCognoms.setSize(new Dimension(57, 16));
			jLabelNom = new JLabel();
			jLabelNom.setText("Nombre:");
			jLabelNom.setLocation(new Point(10, 40));
			jLabelNom.setSize(new Dimension(59, 16));
			jLabelNif = new JLabel();
			jLabelNif.setText("NIF:");
			jLabelNif.setLocation(new Point(10, 10));
			jLabelNif.setSize(new Dimension(20, 16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJButtonSeleccionar(), null);
			jContentPane.add(getJButtonCancellar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldNif	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNif() {
		if (jTextFieldNif == null) {
			jTextFieldNif = new JTextField();
			jTextFieldNif.setSize(new Dimension(108, 18));
			jTextFieldNif.setLocation(new Point(37, 10));
		}
		return jTextFieldNif;
	}

	/**
	 * This method initializes jTextFieldNom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNom() {
		if (jTextFieldNom == null) {
			jTextFieldNom = new JTextField();
			jTextFieldNom.setSize(new Dimension(72, 18));
			jTextFieldNom.setLocation(new Point(70, 40));
		}
		return jTextFieldNom;
	}

	/**
	 * This method initializes jTextFieldCognoms	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCognoms() {
		if (jTextFieldCognoms == null) {
			jTextFieldCognoms = new JTextField();
			jTextFieldCognoms.setSize(new Dimension(190, 18));
			jTextFieldCognoms.setLocation(new Point(210, 40));
		}
		return jTextFieldCognoms;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelLlistatTrobat = new JLabel();
			jLabelLlistatTrobat.setBounds(new Rectangle(18, 125, 85, 16));
			jLabelLlistatTrobat.setText("Coincidencias:");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setLocation(new Point(20, 20));
			jPanel.setSize(new Dimension(445, 270));
			jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jPanel.add(jLabelLlistatTrobat, null);
			jPanel.add(getJPanelBuscarDades(), null);
			jPanel.add(getJScrollPaneLlista(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButtonTrobar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonTrobar() {
		if (jButtonTrobar == null) {
			jButtonTrobar = new JButton();
			jButtonTrobar.setText("Buscar");
			jButtonTrobar.setSize(new Dimension(93, 20));
			jButtonTrobar.setLocation(new Point(308, 69));
		}
		return jButtonTrobar;
	}

	/**
	 * This method initializes jButtonSeleccionar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSeleccionar() {
		if (jButtonSeleccionar == null) {
			jButtonSeleccionar = new JButton();
			jButtonSeleccionar.setText("Seleccionar");
			jButtonSeleccionar.setLocation(new Point(115, 304));
			jButtonSeleccionar.setSize(new Dimension(110, 28));
		}
		return jButtonSeleccionar;
	}

	/**
	 * This method initializes jPanelBuscarDades	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBuscarDades() {
		if (jPanelBuscarDades == null) {
			jLabelTipusUsuari = new JLabel();
			jLabelTipusUsuari.setBounds(new Rectangle(159, 10, 106, 16));
			jLabelTipusUsuari.setText("Tipo de Usuario:");
			jPanelBuscarDades = new JPanel();
			jPanelBuscarDades.setLayout(null);
			jPanelBuscarDades.setSize(new Dimension(414, 97));
			jPanelBuscarDades.setLocation(new Point(15, 15));
			jPanelBuscarDades.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			jPanelBuscarDades.add(jLabelNif, null);
			jPanelBuscarDades.add(getJTextFieldNif(), null);
			jPanelBuscarDades.add(getJTextFieldNom(), null);
			jPanelBuscarDades.add(jLabelNom, null);
			jPanelBuscarDades.add(getJButtonTrobar(), null);
			jPanelBuscarDades.add(getJTextFieldCognoms(), null);
			jPanelBuscarDades.add(jLabelCognoms, null);
			jPanelBuscarDades.add(jLabelTipusUsuari, null);
		}
		return jPanelBuscarDades;
	}

	/**
	 * This method initializes jComboBoxTipusUsuari	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxTipusUsuari() {
		if (jComboBoxTipusUsuari == null) {
			jComboBoxTipusUsuari = new JComboBox(vectorCombo);
			jComboBoxTipusUsuari.setLocation(new Point(263, 10));
			jComboBoxTipusUsuari.setSize(new Dimension(114, 18));
		}
		return jComboBoxTipusUsuari;
	}



	/**
	 * This method initializes jButtonCancellar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancellar() {
		if (jButtonCancellar == null) {
			jButtonCancellar = new JButton();
			jButtonCancellar.setText("Cancelar");
			jButtonCancellar.setSize(new Dimension(110, 28));
			jButtonCancellar.setLocation(new Point(260, 304));
			jButtonCancellar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancellar;
	}

	/**
	 * This method initializes jScrollPaneLlista	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLlista() {
		if (jScrollPaneLlista == null) {
			jScrollPaneLlista = new JScrollPane();
			jScrollPaneLlista.setBounds(new Rectangle(18, 147, 410, 104));
			jScrollPaneLlista.setViewportView(getJTableLlista());
		}
		return jScrollPaneLlista;
	}

	/**
	 * This method initializes jTableLlista	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableLlista() {
		Object[][] valores;
		String[] columnas = { "ID","NIF","Nombre","Apellido","Tipo Usuario" };
		
		if (jTableLlista == null) {
			jTableLlista = new JTable();
		}
		if (listaData != null) {
			valores = new Object[listaData.size()][5];
			for (int x=0;x<listaData.size();x++) {
				Empleado emp = (Empleado)listaData.elementAt(x);
				valores[x][0] = emp.getId();
				valores[x][1] = emp.getNif();
				valores[x][2] = emp.getNombre();
				valores[x][3] = emp.getApellido1();
				valores[x][4] = emp.getRol().getDescripcion();
			}		
		} else {
			valores = new Object[1][5];
			valores[0][0] = "";
			valores[0][1] = "";
			valores[0][2] = "";
			valores[0][3] = "";
			valores[0][4] = "";			
		}
		jTableLlista = new JTable(valores,columnas);		
		jTableLlista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableLlista.setEnabled(true);
		jTableLlista.setCellSelectionEnabled(false);
		jTableLlista.setColumnSelectionAllowed(false);
		jTableLlista.setRowSelectionAllowed(true);
		jTableLlista.setSelectionBackground(Color.cyan);
		jTableLlista.setSelectionForeground(Color.blue);
		jTableLlista.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				int fila = jTableLlista.rowAtPoint(e.getPoint());
				int columna = jTableLlista.columnAtPoint(e.getPoint());
				if ((fila > -1) && (columna > -1) && listaData != null) 
				{					
					setIdSelecTabla(Integer.parseInt(jTableLlista.getValueAt(fila, 0).toString()));
				}
					
			}
		});
		return jTableLlista;
	}

	public String getRolDesplegable() {
		return (String)jComboBoxTipusUsuari.getSelectedItem();
	}
	
	public Vector getVectorCombo() {
		return vectorCombo;
	}


	public void setVectorCombo(Vector vectorCombo) {
		this.vectorCombo = vectorCombo;
	}
	
	public void setListaData(Vector <Empleado> listaData) {
		this.listaData = listaData;
		jScrollPaneLlista.setViewportView(getJTableLlista());
	}

	

	public String getNifBusqueda() {
		return jTextFieldNif.getText();
	}
	
	public String getNombreBusqueda() {
		return jTextFieldNom.getText();
	}
	
	public String getApellidoBusqueda() {
		return jTextFieldCognoms.getText();
	}


	public int getIdSelecTabla() {
		return idSelecTabla;
	}

	public void setIdSelecTabla(int idSelecTabla) {
		this.idSelecTabla = idSelecTabla;
	}

	public String getPantallaDestino() {
		return PantallaDestino;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"
