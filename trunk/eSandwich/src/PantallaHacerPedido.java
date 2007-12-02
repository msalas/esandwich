import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PantallaHacerPedido extends JDialog {

  private static final long      serialVersionUID   = 1L;

  private JPanel                 jContentPane       = null;
  private JPanel                 jPanel             = null;
  private JPanel                 jPanel1            = null;
  private JComboBox              jcbTipoSandwich    = null;
  private JLabel                 jLabel             = null;
  private JComboBox              jcbUnidades        = null;
  private JButton                jbtnAddUnidades    = null;
  private JPanel                 jPanel2            = null;
  private JPanel                 jPanel3            = null;
  private JPanel                 jPanel4            = null;
  private JComboBox              jcbBebidas         = null;
  private JLabel                 jLabel1            = null;
  private JComboBox              jcbUnidadesBebidas = null;
  private JButton                jbtnAddBebidas     = null;
  private JComboBox              jcbPostres         = null;
  private JLabel                 jLabel2            = null;
  private JComboBox              jcbUnidadesPostres = null;
  private JButton                jbtnAddPostres     = null;
  private JComboBox              jcbCafes           = null;
  private JLabel                 jLabel3            = null;
  private JComboBox              jcbUnidadesCafes   = null;
  private JButton                jbtnAddCafes       = null;
  private JPanel                 jPanel5            = null;
  private JPanel                 jPanel6            = null;
  private JScrollPane            jScrollPaneCompra  = null;
  private JTable                 jTableCompra       = null;
  private JButton                jButtonElimina     = null;
  private JTable                 jTableImport       = null;
  private JButton                jbtnFinalizaCompra = null;
  private JButton                jButtonSortir      = null;
  private JLabel                 lblCodUsuario      = null;

  AplicacionComprador            ac                 = null;
  ControladorPantallaHacerPedido cphp               = null;

  /**
   * This is the default constructor
   */
  public PantallaHacerPedido(AplicacionComprador ac) {
    super(ac, "Realizar Pedido", true);
    initialize();
    cphp = new ControladorPantallaHacerPedido(this);
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(568, 738);
    this.setContentPane(getJContentPane());
    this.setTitle("Hacer Pedido");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    jbtnFinalizaCompra.setActionCommand("compra");
    jbtnFinalizaCompra.addActionListener(cphp);
  }

  public void setDatos(String cod) {
    lblCodUsuario.setText(cod);

  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      jContentPane = new JPanel();
      jContentPane.setLayout(new BorderLayout());
      jContentPane.add(getJPanel(), BorderLayout.CENTER);
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
      lblCodUsuario = new JLabel();
      lblCodUsuario.setBounds(new Rectangle(3, 682, 102, 15));
      lblCodUsuario.setText("Cliente: CC00101");
      jPanel = new JPanel();
      jPanel.setLayout(null);
      jPanel.add(getJPanel1(), null);
      jPanel.add(getJPanel2(), null);
      jPanel.add(getJPanel3(), null);
      jPanel.add(getJPanel4(), null);
      jPanel.add(getJPanel5(), null);
      jPanel.add(getJPanel6(), null);
      jPanel.add(getJButtonElimina(), null);
      jPanel.add(getJButtonSortir(), null);
      jPanel.add(lblCodUsuario, null);
    }
    return jPanel;
  }

  /**
   * This method initializes jPanel1
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel1() {
    if (jPanel1 == null) {
      jLabel = new JLabel();
      jLabel.setBounds(new Rectangle(230, 24, 67, 25));
      jLabel.setText("Unidades:");
      jPanel1 = new JPanel();
      jPanel1.setLayout(null);
      jPanel1.setBounds(new Rectangle(15, 20, 509, 60));
      jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Sandwich",
          TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
          new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
      jPanel1.add(getJcbTipoSandwich(), null);
      jPanel1.add(jLabel, null);
      jPanel1.add(getJcbUnidades(), null);
      jPanel1.add(getJbtnAddUnidades(), null);
    }
    return jPanel1;
  }

  /**
   * This method initializes jComboBox
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbTipoSandwich() {
    if (jcbTipoSandwich == null) {
      String[] tipusSandwich = { "Pernil Dolç", "Salat", "Iberic", "Tonyina" };
      jcbTipoSandwich = new JComboBox(tipusSandwich);
      jcbTipoSandwich.setBounds(new Rectangle(11, 25, 206, 23));
    }
    return jcbTipoSandwich;
  }
  
  public void setJcbTipoSandwich( Vector v ){
    jcbTipoSandwich.setModel(new DefaultComboBoxModel(v));
  }

  /**
   * This method initializes jComboBox1
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbUnidades() {
    if (jcbUnidades == null) {
      String[] unitats = { "1", "2", "3" };
      jcbUnidades = new JComboBox(unitats);
      jcbUnidades.setBounds(new Rectangle(304, 23, 35, 26));
    }
    return jcbUnidades;
  }

  /**
   * This method initializes jButton
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbtnAddUnidades() {
    if (jbtnAddUnidades == null) {
      jbtnAddUnidades = new JButton();
      jbtnAddUnidades.setBounds(new Rectangle(400, 24, 83, 25));
      jbtnAddUnidades.setText("Añade");
    }
    return jbtnAddUnidades;
  }

  /**
   * This method initializes jPanel2
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel2() {
    if (jPanel2 == null) {
      jLabel1 = new JLabel();
      jLabel1.setBounds(new Rectangle(230, 24, 67, 25));
      jLabel1.setText("Unidades:");
      jPanel2 = new JPanel();
      jPanel2.setLayout(null);
      jPanel2.setBounds(new Rectangle(16, 89, 509, 56));
      jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Bebidas",
          TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
          new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
      jPanel2.add(getJcbBebidas(), null);
      jPanel2.add(jLabel1, null);
      jPanel2.add(getJcbUnidadesBebidas(), null);
      jPanel2.add(getJbtnAddBebidas(), null);
    }
    return jPanel2;
  }

  /**
   * This method initializes jPanel3
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel3() {
    if (jPanel3 == null) {
      jLabel2 = new JLabel();
      jLabel2.setBounds(new Rectangle(230, 24, 67, 25));
      jLabel2.setText("Unidades:");
      jPanel3 = new JPanel();
      jPanel3.setLayout(null);
      jPanel3.setBounds(new Rectangle(15, 159, 510, 56));
      jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Postres",
          TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
          new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
      jPanel3.add(getJcbPostres(), null);
      jPanel3.add(jLabel2, null);
      jPanel3.add(getJcbUnidadesPostres(), null);
      jPanel3.add(getJbtnAddPostres(), null);
    }
    return jPanel3;
  }

  /**
   * This method initializes jPanel4
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel4() {
    if (jPanel4 == null) {
      jLabel3 = new JLabel();
      jLabel3.setBounds(new Rectangle(230, 24, 67, 25));
      jLabel3.setText("Unidades:");
      jPanel4 = new JPanel();
      jPanel4.setLayout(null);
      jPanel4.setBounds(new Rectangle(15, 228, 510, 61));
      jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Cafés",
          TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
          new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
      jPanel4.add(getJcbCafes(), null);
      jPanel4.add(jLabel3, null);
      jPanel4.add(getJcbUnidadesCafes(), null);
      jPanel4.add(getJbtnAddCafes(), null);
    }
    return jPanel4;
  }

  /**
   * This method initializes jComboBox2
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbBebidas() {
    if (jcbBebidas == null) {
      String[] tipusBeguda = { "Coca-Cola Llauna 33cl", "7up ampolla 50cl",
          "Fanta Taronja llauna 33 cl", "Nestea llauna 33cl" };
      jcbBebidas = new JComboBox(tipusBeguda);
      jcbBebidas.setBounds(new Rectangle(11, 25, 206, 23));
    }
    return jcbBebidas;
  }
  
  public void setJcbBebida(Vector v){
    jcbBebidas.setModel(new DefaultComboBoxModel(v));
  }

  /**
   * This method initializes jComboBox3
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbUnidadesBebidas() {
    if (jcbUnidadesBebidas == null) {
      String[] unitats = { "1", "2", "3" };
      jcbUnidadesBebidas = new JComboBox(unitats);
      jcbUnidadesBebidas.setBounds(new Rectangle(304, 23, 35, 26));
    }
    return jcbUnidadesBebidas;
  }

  /**
   * This method initializes jButton1
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbtnAddBebidas() {
    if (jbtnAddBebidas == null) {
      jbtnAddBebidas = new JButton();
      jbtnAddBebidas.setBounds(new Rectangle(400, 24, 83, 25));
      jbtnAddBebidas.setText("Añade");
    }
    return jbtnAddBebidas;
  }

  /**
   * This method initializes jComboBox4
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbPostres() {
    if (jcbPostres == null) {
      String[] tipusPostres = { "Iogurt Natural", "Danao Vainilla",
          "Gelat Maduixa", "Tiramusú" };
      jcbPostres = new JComboBox(tipusPostres);
      jcbPostres.setBounds(new Rectangle(11, 25, 206, 23));
    }
    return jcbPostres;
  }

  /**
   * This method initializes jComboBox5
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbUnidadesPostres() {
    if (jcbUnidadesPostres == null) {
      String[] unitats = { "1", "2", "3" };
      jcbUnidadesPostres = new JComboBox(unitats);
      jcbUnidadesPostres.setBounds(new Rectangle(304, 23, 35, 26));
    }
    return jcbUnidadesPostres;
  }

  /**
   * This method initializes jButton2
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbtnAddPostres() {
    if (jbtnAddPostres == null) {
      jbtnAddPostres = new JButton();
      jbtnAddPostres.setBounds(new Rectangle(400, 24, 83, 25));
      jbtnAddPostres.setText("Añade");
    }
    return jbtnAddPostres;
  }

  /**
   * This method initializes jComboBox6
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbCafes() {
    if (jcbCafes == null) {
      String[] tipusCafes = { "Cafè sol", "Expresso", "Descafeinato",
          "Cafè amb llet" };
      jcbCafes = new JComboBox(tipusCafes);
      jcbCafes.setBounds(new Rectangle(11, 25, 206, 23));
    }
    return jcbCafes;
  }

  /**
   * This method initializes jComboBox7
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getJcbUnidadesCafes() {
    if (jcbUnidadesCafes == null) {
      String[] unitats = { "1", "2", "3" };
      jcbUnidadesCafes = new JComboBox(unitats);
      jcbUnidadesCafes.setBounds(new Rectangle(304, 23, 35, 26));
    }
    return jcbUnidadesCafes;
  }

  /**
   * This method initializes jButton3
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbtnAddCafes() {
    if (jbtnAddCafes == null) {
      jbtnAddCafes = new JButton();
      jbtnAddCafes.setBounds(new Rectangle(400, 24, 83, 25));
      jbtnAddCafes.setText("Añade");
    }
    return jbtnAddCafes;
  }

  /**
   * This method initializes jPanel5
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel5() {
    if (jPanel5 == null) {
      jPanel5 = new JPanel();
      jPanel5.setLayout(null);
      jPanel5.setBounds(new Rectangle(14, 301, 511, 224));
      jPanel5.setBorder(BorderFactory.createTitledBorder(null,
          "Compra Actual", TitledBorder.DEFAULT_JUSTIFICATION,
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12),
          new Color(51, 51, 51)));
      jPanel5.add(getJScrollPaneCompra(), null);
    }
    return jPanel5;
  }

  /**
   * This method initializes jPanel6
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJPanel6() {
    if (jPanel6 == null) {
      jPanel6 = new JPanel();
      jPanel6.setLayout(null);
      jPanel6.setBounds(new Rectangle(16, 571, 510, 60));
      jPanel6.setBorder(BorderFactory.createTitledBorder(null, "Importe",
          TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
          new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
      jPanel6.add(getJTableImport(), null);
      jPanel6.add(getJbtnFinalizaCompra(), null);
    }
    return jPanel6;
  }

  /**
   * This method initializes jScrollPaneCompra
   * 
   * @return javax.swing.JScrollPane
   */
  private JScrollPane getJScrollPaneCompra() {
    if (jScrollPaneCompra == null) {
      jScrollPaneCompra = new JScrollPane();
      jScrollPaneCompra.setBounds(new Rectangle(6, 19, 497, 200));
      jScrollPaneCompra.setViewportView(getJTableCompra());
    }
    return jScrollPaneCompra;
  }

  /**
   * This method initializes jTableCompra
   * 
   * @return javax.swing.JTable
   */
  private JTable getJTableCompra() {
    if (jTableCompra == null) {
      String[] columnNames = { "Productes", "Unitats", "Preu" };
      Object[][] data = { { "Sandwich pernil dolç", "2", "3.45 €" },
          { "Coca-Cola Light llauna 33cl", "1", "1.50 €" },
          { "yogurt danone Natural", "2", "1.75 €" },
          { "cafè amb llet", "1", "1.25 €" },
          { "sandwich iberic", "2", "12.60 €" },
          { "Danao 50ml plàtan", "1", "2.45 €" },
          { "Tallat Descafeïnat", "1", "0.80€" },
          { "sandwich especial", "1", "2.10 €" } };
      jTableCompra = new JTable(data, columnNames);
    }
    return jTableCompra;
  }

  public void setTablaCompra(TableModel tm) {
    getJTableCompra().setModel(tm);
  }

  /**
   * This method initializes jButtonElimina
   * 
   * @return javax.swing.JButton
   */
  private JButton getJButtonElimina() {
    if (jButtonElimina == null) {
      jButtonElimina = new JButton();
      jButtonElimina.setBounds(new Rectangle(368, 534, 156, 20));
      jButtonElimina.setText("Elimina Seleccionado");
    }
    return jButtonElimina;
  }

  /**
   * This method initializes jTableImport
   * 
   * @return javax.swing.JTable
   */
  private JTable getJTableImport() {
    if (jTableImport == null) {
      String[] columnNames = { "Subtotal", "IVA(%)", "Import Total" };
      Object[][] data = { { "Subtotal", "IVA(%)", "Import Total" },
          { "10.40 €", "1.66 €", "12.06 €" } };
      jTableImport = new JTable(data, columnNames);
      jTableImport.setBounds(new Rectangle(8, 18, 289, 35));
    }
    return jTableImport;
  }

  /**
   * This method initializes jButtonFinalitzaCompra
   * 
   * @return javax.swing.JButton
   */
  private JButton getJbtnFinalizaCompra() {
    if (jbtnFinalizaCompra == null) {
      jbtnFinalizaCompra = new JButton();
      jbtnFinalizaCompra.setBounds(new Rectangle(358, 15, 152, 31));
      jbtnFinalizaCompra.setText("Finaliza Compra");
    }
    return jbtnFinalizaCompra;
  }

  /**
   * This method initializes jButtonSortir
   * 
   * @return javax.swing.JButton
   */
  private JButton getJButtonSortir() {
    if (jButtonSortir == null) {
      jButtonSortir = new JButton();
      jButtonSortir.setBounds(new Rectangle(182, 645, 180, 30));
      jButtonSortir.setText("Cerrar");
    }
    return jButtonSortir;
  }

} // @jve:decl-index=0:visual-constraint="10,10"
