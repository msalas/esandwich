

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.KeyEvent;

public class PantallaAltaPromocion extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel jPanel = null;

	private JButton jButtonTrobar = null;

	private JPanel jPanelBuscarDades = null;

	private JButton jButtonCancellar = null;

	private JScrollPane jScrollPaneLlistat = null;

	private JTable jTableLlistat = null;

	private JLabel jLabelIdSandvitx = null;

	private JTextField jTextFieldIdSandvitx = null;

	private JLabel jLabelRegal = null;

	private JComboBox jComboBoxRegal = null;

	private JLabel jLabel2x1 = null;

	private JCheckBox jCheckBox2x1 = null;

	private JLabel jLabel = null;

	private JTextField jTextFieldDescompte = null;

	private JLabel jLabel1Percent = null;

	private JLabel jLabelMPunts = null;

	private JTextField jTextFieldMpunts = null;

	private JRadioButton jRadioButton = null;

	private JRadioButton jRadioButton1 = null;

	private JRadioButton jRadioButton2 = null;


	public PantallaAltaPromocion(AplicacionEmpleado ae) {
		// TODO Auto-generated constructor stub
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
		this.setTitle("Alta Promoció");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJButtonCancellar(), null);
			jContentPane.add(getJButtonTrobar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabelMPunts = new JLabel();
			jLabelMPunts.setText("Punts Mínims:");
			jLabelMPunts.setSize(new Dimension(84, 16));
			jLabelMPunts.setLocation(new Point(16, 199));
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setLocation(new Point(20, 20));
			jPanel.setSize(new Dimension(445, 278));
			jPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			jPanel.add(getJPanelBuscarDades(), null);
			jPanel.add(getJScrollPaneLlistat(), null);
			jPanel.add(jLabelIdSandvitx, null);
			jPanel.add(getJTextFieldIdSandvitx(), null);
			jPanel.add(jLabelMPunts, null);
			jPanel.add(getJTextFieldMpunts(), null);
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
			jButtonTrobar.setText("Promocionar");
			jButtonTrobar.setSize(new Dimension(115, 28));
			jButtonTrobar.setLocation(new Point(119, 310));
		}
		return jButtonTrobar;
	}

	/**
	 * This method initializes jPanelBuscarDades	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBuscarDades() {
		if (jPanelBuscarDades == null) {
			jLabel1Percent = new JLabel();
			jLabel1Percent.setText("%");
			jLabel1Percent.setSize(new Dimension(18, 16));
			jLabel1Percent.setLocation(new Point(160, 48));
			jLabel = new JLabel();
			jLabel.setText("Descompte:");
			jLabel.setSize(new Dimension(72, 16));
			jLabel.setLocation(new Point(39, 48));
			jLabel2x1 = new JLabel();
			jLabel2x1.setText("Sandvitx 2x1:");
			jLabel2x1.setLocation(new Point(39, 81));
			jLabel2x1.setSize(new Dimension(81, 16));
			jLabelRegal = new JLabel();
			jLabelRegal.setText("Regal:");
			jLabelRegal.setSize(new Dimension(39, 16));
			jLabelRegal.setLocation(new Point(39, 15));
			jLabelIdSandvitx = new JLabel();
			jLabelIdSandvitx.setText("Id Sandvitx:");
			jLabelIdSandvitx.setLocation(new Point(16, 169));
			jLabelIdSandvitx.setSize(new Dimension(66, 16));
			jPanelBuscarDades = new JPanel();
			jPanelBuscarDades.setLayout(null);
			jPanelBuscarDades.setSize(new Dimension(283, 117));
			jPanelBuscarDades.setLocation(new Point(153, 146));
			jPanelBuscarDades.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			jPanelBuscarDades.add(jLabelRegal, null);
			jPanelBuscarDades.add(getJComboBoxRegal(), null);
			jPanelBuscarDades.add(jLabel2x1, null);
			jPanelBuscarDades.add(getJCheckBox2x1(), null);
			jPanelBuscarDades.add(jLabel, null);
			jPanelBuscarDades.add(getJTextFieldDescompte(), null);
			jPanelBuscarDades.add(jLabel1Percent, null);
			jPanelBuscarDades.add(getJRadioButton(), null);
			jPanelBuscarDades.add(getJRadioButton1(), null);
			jPanelBuscarDades.add(getJRadioButton2(), null);
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
			jButtonCancellar.setLocation(new Point(251, 310));
		}
		return jButtonCancellar;
	}

	/**
	 * This method initializes jScrollPaneLlistat	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneLlistat() {
		if (jScrollPaneLlistat == null) {
			jScrollPaneLlistat = new JScrollPane();
			jScrollPaneLlistat.setBounds(new Rectangle(15, 21, 412, 111));
			jScrollPaneLlistat.setViewportView(getJTableLlistat());
		}
		return jScrollPaneLlistat;
	}

	/**
	 * This method initializes jTableLlistat	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableLlistat() {
		if (jTableLlistat == null) {
			String[] columna = {
				"IdSandvitx","Nom","Punts Mínims","Regal","Descompte","2x1"	
			};
			Object[][]dades = {
				{"01","Sandvitx de...","50","","10%",""},
				{"01","Sandvitx de...","100","","","V"},
				{"02","Sandvitx de...","","","",""},
				{"03","Sandvitx de...","50","","5%",""},
				{"04","Sandvitx de...","50","postre","",""},
			};
			jTableLlistat = new JTable(dades, columna);
		}
		return jTableLlistat;
	}

	/**
	 * This method initializes jTextFieldIdSandvitx	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldIdSandvitx() {
		if (jTextFieldIdSandvitx == null) {
			jTextFieldIdSandvitx = new JTextField();
			jTextFieldIdSandvitx.setSize(new Dimension(59, 18));
			jTextFieldIdSandvitx.setText("03");
			jTextFieldIdSandvitx.setLocation(new Point(88, 169));
		}
		return jTextFieldIdSandvitx;
	}

	/**
	 * This method initializes jComboBoxRegal	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxRegal() {
		if (jComboBoxRegal == null) {
			jComboBoxRegal = new JComboBox();
			jComboBoxRegal.setLocation(new Point(86, 15));
			jComboBoxRegal.setSize(new Dimension(193, 18));
		}
		return jComboBoxRegal;
	}

	/**
	 * This method initializes jCheckBox2x1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox2x1() {
		if (jCheckBox2x1 == null) {
			jCheckBox2x1 = new JCheckBox();
			jCheckBox2x1.setSize(new Dimension(21, 21));
			jCheckBox2x1.setLocation(new Point(124, 79));
		}
		return jCheckBox2x1;
	}

	/**
	 * This method initializes jTextFieldDescompte	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldDescompte() {
		if (jTextFieldDescompte == null) {
			jTextFieldDescompte = new JTextField();
			jTextFieldDescompte.setLocation(new Point(118, 48));
			jTextFieldDescompte.setText("15");
			jTextFieldDescompte.setSize(new Dimension(39, 18));
		}
		return jTextFieldDescompte;
	}

	/**
	 * This method initializes jTextFieldMpunts	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldMpunts() {
		if (jTextFieldMpunts == null) {
			jTextFieldMpunts = new JTextField();
			jTextFieldMpunts.setSize(new Dimension(36, 18));
			jTextFieldMpunts.setText("75");
			jTextFieldMpunts.setLocation(new Point(105, 199));
		}
		return jTextFieldMpunts;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new Rectangle(11, 13, 21, 21));
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setSize(new Dimension(21, 21));
			jRadioButton1.setMnemonic(KeyEvent.VK_UNDEFINED);
			jRadioButton1.setSelected(true);
			jRadioButton1.setLocation(new Point(11, 47));
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setSize(new Dimension(21, 21));
			jRadioButton2.setLocation(new Point(11, 79));
		}
		return jRadioButton2;
	}


}  //  @jve:decl-index=0:visual-constraint="10,10"
