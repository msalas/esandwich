
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PantallaTrobarClientWindow extends JFrame {

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

	private JButton jButtonCancellar = null;

	private JScrollPane jScrollPaneLlista = null;

	private JTable jTableLlista = null;

	/**
	 * This is the default constructor
	 */
	public PantallaTrobarClientWindow() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(494, 384);
		this.setContentPane(getJContentPane());
		this.setTitle("Cercar Client");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelCognoms = new JLabel();
			jLabelCognoms.setText("Cognoms:");
			jLabelCognoms.setLocation(new Point(150, 40));
			jLabelCognoms.setSize(new Dimension(57, 16));
			jLabelNom = new JLabel();
			jLabelNom.setText("Nom:");
			jLabelNom.setLocation(new Point(10, 40));
			jLabelNom.setSize(new Dimension(29, 16));
			jLabelNif = new JLabel();
			jLabelNif.setText("Codi Client:");
			jLabelNif.setLocation(new Point(10, 10));
			jLabelNif.setSize(new Dimension(71, 16));
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
			jTextFieldNif.setSize(new Dimension(103, 18));
			jTextFieldNif.setLocation(new Point(82, 10));
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
			jTextFieldNom.setSize(new Dimension(100, 18));
			jTextFieldNom.setText("Juan José");
			jTextFieldNom.setLocation(new Point(42, 40));
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
			jLabelLlistatTrobat.setText("Llistat Trobat:");
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
			jButtonTrobar.setText("Cercar");
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
		}
		return jPanelBuscarDades;
	}

	/**
	 * This method initializes jButtonCancellar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancellar() {
		if (jButtonCancellar == null) {
			jButtonCancellar = new JButton();
			jButtonCancellar.setText("Cancel·lar");
			jButtonCancellar.setSize(new Dimension(110, 28));
			jButtonCancellar.setLocation(new Point(260, 304));
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
			jScrollPaneLlista.setBounds(new Rectangle(14, 146, 416, 109));
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
		if (jTableLlista == null) {
			String[] columnNames = {
                    "Codi de Client",
                    "Nom",
                    "Cognoms"
			};
			Object[][] data = {
					{"C00002","Juan José","García Escabia"},
					{"C00010","Juan José","Roldán García"}	
			};
			jTableLlista = new JTable(data, columnNames);	
		
		}
		return jTableLlista;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"
