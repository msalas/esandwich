import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;


// Falta cambiar los comentarios 
public class AplicacionEmpleado extends JFrame implements Aplicacion {

	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private JMenuBar jJMenuBar = null;
	private JMenuBar jbarramenu = null;

	private JMenu jMenuSesion = null;
	private JMenu jarxiu = null;
	
	private JMenuItem jMenuItemLogin = null;

	private JMenuItem jMenuItemLogout = null;

	
	private JMenu jMenuEmpleados = null;
	private JMenu jmanteniment = null;
	
	private JMenuItem jMenuItemAltaEmpleado = null;

	private JMenu jCuina = null;
	private JMenuItem jItemSandw = null;
	private JMenuItem jItemTipoSandw = null;

	private JMenu jStock_Estadisitiques = null;

	private JMenu jStock = null;
	private JMenuItem jaltaarticle = null;

	private JMenu jFacturacio = null;
	private JMenuItem jfactutotal = null;
	private JMenuItem jFacturaciosand = null;

	private JMenu jComandes = null;

	private JMenuItem jRealitcomandes = null;




	
	private JMenuItem jItemPedidoFin = null;

	private JMenu jMenuUsuari = null;

	private JMenu jMenuClient = null;

	private JMenu jMenuPromocio = null;

	private JMenuItem jMenuItemCrear = null;

	private JMenuItem jMenuItemEsborrar = null;

	private JMenuItem jMenuItemModificar = null;

	private JMenuItem jMenuItemConsultar = null;

	private ServiciosModelo sm = null;  

	private ControladorAplicacionEmpleado cae = null;

	private JOptionPane jOptionPane = null;  //  @jve:decl-index=0:visual-constraint="161,283"


	/**
	 * This is the default constructor
	 */
	
	public AplicacionEmpleado() {
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
		this.setResizable(false);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("eSandvitx");
		// Para centrar pantalla
		this.setLocationRelativeTo(null);
		// Inicializamos modelo
		
		try {
			sm = new ServiciosAdAuxModelo();
			//sm = new ServiciosAccesoModelo();

		} catch (MalformedURLException e) {
			mostrarError(e.getMessage(), "");
			//e.printStackTrace();
		} catch (RemoteException e) {
			mostrarError(e.getMessage(), "");
			//e.printStackTrace();
		} catch (NotBoundException e) {
			mostrarError(e.getMessage(), "");
			//e.printStackTrace();
		} 
		
		// Inicializamos controlador para acciones del menu
		
		cae = new ControladorAplicacionEmpleado(this);
		
		jMenuItemLogin.setActionCommand("IS");
		jMenuItemLogin.addActionListener(cae);

		jMenuItemLogout.setActionCommand("CS");
		jMenuItemLogout.addActionListener(cae);

		jMenuItemAltaEmpleado.setActionCommand("AR");
		jMenuItemAltaEmpleado.addActionListener(cae);
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
			jContentPane.setPreferredSize(new Dimension(1, 1));
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.setPreferredSize(new Dimension(418, 23));
			jJMenuBar.add(getJMenuSesion());
			jJMenuBar.add(getJMenuEmpleados());
		}
		return jJMenuBar;
	}


	/**
	 * This method initializes jMenuSesion	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuSesion() {
		if (jMenuSesion == null) {
			jMenuSesion = new JMenu();
			jMenuSesion.setPreferredSize(new Dimension(60, 5));
			jMenuSesion.setRolloverEnabled(false);
			jMenuSesion.setHorizontalAlignment(SwingConstants.LEADING);
			jMenuSesion.setHorizontalTextPosition(SwingConstants.TRAILING);
			jMenuSesion.setSize(new Dimension(50, 21));
			jMenuSesion.setText("Sesión");
			jMenuSesion.add(getJMenuItemLogin());
			jMenuSesion.add(getJMenuItemLogout());
		}
		return jMenuSesion;
	}

	/**
	 * This method initializes jMenuItemLogin	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemLogin() {
		if (jMenuItemLogin == null) {
			jMenuItemLogin = new JMenuItem();
			jMenuItemLogin.setPreferredSize(new Dimension(63, 21));
			jMenuItemLogin.setText("Login");
		}
		return jMenuItemLogin;
	}

	/**
	 * This method initializes jMenuItemLogout	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemLogout() {
		if (jMenuItemLogout == null) {
			jMenuItemLogout = new JMenuItem();
			jMenuItemLogout.setText("Logout");
		}
		return jMenuItemLogout;
	}

	/**
	 * This method initializes jMenuEmpleados	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuEmpleados() {
		if (jMenuEmpleados == null) {
			jMenuEmpleados = new JMenu();
			jMenuEmpleados.setPreferredSize(new Dimension(75, 5));
			jMenuEmpleados.setText("Empleados");
			jMenuEmpleados.add(getJMenuItemAltaEmpleado());
		}
		return jMenuEmpleados;
	}

	/**
	 * This method initializes jMenuItemAltaEmpleado	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemAltaEmpleado() {
		if (jMenuItemAltaEmpleado == null) {
			jMenuItemAltaEmpleado = new JMenuItem();
			jMenuItemAltaEmpleado.setText("Alta");
			jMenuItemAltaEmpleado.setPreferredSize(new Dimension(63, 21));
		}
		return jMenuItemAltaEmpleado;
	}
	
	/**
	 * This method initializes jOptionPane	
	 * 	
	 * @return javax.swing.JOptionPane	
	 */
	private JOptionPane getJOptionPane() {
		if (jOptionPane == null) {
			jOptionPane = new JOptionPane();
		}
		return jOptionPane;
	}

	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	AplicacionEmpleado app = new AplicacionEmpleado();
                app.setVisible(true);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

	public ServiciosModelo getSm() {
		return sm;
	}

	public void setSm(ServiciosModelo sm) {
		this.sm = sm;
	}

	public int confirmacio(String mensaje, String titulo) {
		return JOptionPane.showConfirmDialog(null,mensaje,titulo, JOptionPane.YES_NO_OPTION);
		
	}


	public void mostrarError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
		
	}


	public void mostrarInformacion(String mensaje, String titulo) {
		 JOptionPane.showInternalMessageDialog(null, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
		
	}

}  //  @jve:decl-index=0:visual-constraint="24,-126"

