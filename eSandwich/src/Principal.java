

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import javax.swing.JMenu;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar jbarramenu = null;

	private JMenu jarxiu = null;

	private JMenu jmanteniment = null;

	private JMenu jCuina = null;

	private JMenu jStock_Estadisitiques = null;

	private JMenu jStock = null;

	private JMenu jFacturacio = null;

	private JMenu jComandes = null;

	private JMenuItem jRealitcomandes = null;

	private JMenuItem jaltaarticle = null;

	private JMenuItem jfactutotal = null;

	private JMenuItem jFacturaciosand = null;

	/**
	 * This is the default constructor
	 */
	public Principal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(536, 362);
		this.setJMenuBar(getJbarramenu());
		this.setContentPane(getJContentPane());
		this.setTitle("eSandvitx");
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
		}
		return jContentPane;
	}

	/**
	 * This method initializes jbarramenu	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJbarramenu() {
		if (jbarramenu == null) {
			jbarramenu = new JMenuBar();
			jbarramenu.add(getJarxiu());
			jbarramenu.add(getJmanteniment());
			jbarramenu.add(getJCuina());
			jbarramenu.add(getJStock_Estadisitiques());
		}
		return jbarramenu;
	}

	/**
	 * This method initializes jarxiu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJarxiu() {
		if (jarxiu == null) {
			jarxiu = new JMenu();
			jarxiu.setText("Archivo");
		}
		return jarxiu;
	}

	/**
	 * This method initializes jmanteniment	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJmanteniment() {
		if (jmanteniment == null) {
			jmanteniment = new JMenu();
			jmanteniment.setText("Mantenimiento");
		}
		return jmanteniment;
	}

	/**
	 * This method initializes jCuina	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJCuina() {
		if (jCuina == null) {
			jCuina = new JMenu();
			jCuina.setText("Cocina");
		}
		return jCuina;
	}

	/**
	 * This method initializes jStock_Estadisitiques	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJStock_Estadisitiques() {
		if (jStock_Estadisitiques == null) {
			jStock_Estadisitiques = new JMenu();
			jStock_Estadisitiques.setText("Stock-Estadisticas");
			jStock_Estadisitiques.add(getJStock());
			jStock_Estadisitiques.add(getJFacturacio());
			jStock_Estadisitiques.add(getJComandes());
		}
		return jStock_Estadisitiques;
	}

	/**
	 * This method initializes jStock	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJStock() {
		if (jStock == null) {
			jStock = new JMenu();
			jStock.setText("Stock de mat�ries primeres");
			jStock.add(getJaltaarticle());
		}
		return jStock;
	}

	/**
	 * This method initializes jFacturacio	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJFacturacio() {
		if (jFacturacio == null) {
			jFacturacio = new JMenu();
			jFacturacio.setText("Facturaci�");
			jFacturacio.add(getJfactutotal());
			jFacturacio.add(getJFacturaciosand());
		}
		return jFacturacio;
	}

	/**
	 * This method initializes jComandes	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJComandes() {
		if (jComandes == null) {
			jComandes = new JMenu();
			jComandes.setText("Comandes");
			jComandes.add(getJRealitcomandes());
		}
		return jComandes;
	}

	/**
	 * This method initializes jRealitcomandes	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJRealitcomandes() {
		if (jRealitcomandes == null) {
			jRealitcomandes = new JMenuItem();
			jRealitcomandes.setText("Realitzar comandes");
		}
		return jRealitcomandes;
	}

	/**
	 * This method initializes jaltaarticle	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJaltaarticle() {
		if (jaltaarticle == null) {
			jaltaarticle = new JMenuItem();
			jaltaarticle.setText("Alta Article");
		}
		return jaltaarticle;
	}

	/**
	 * This method initializes jfactutotal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJfactutotal() {
		if (jfactutotal == null) {
			jfactutotal = new JMenuItem();
			jfactutotal.setText("Facturaci� total");
		}
		return jfactutotal;
	}

	/**
	 * This method initializes jFacturaciosand	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJFacturaciosand() {
		if (jFacturaciosand == null) {
			jFacturaciosand = new JMenuItem();
			jFacturaciosand.setText("Facturaci� per Sandvitx");
		}
		return jFacturaciosand;
	}

}  //  @jve:decl-index=0:visual-constraint="24,-126"
