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
	
	private JMenu jMenuSesion = null;
	private JMenuItem jMenuItemLogin = null;
	private JMenuItem jMenuItemLogout = null;

	private JMenu jMenuUsuarios = null;
	private JMenu jMenuEmpleados = null;
	private JMenuItem jMenuItemAltaEmpleado = null;
	private JMenuItem jMenuItemModifEmpleado = null;
	private JMenuItem jMenuItemBajaEmpleado = null;
	private JMenuItem jMenuItemConEmpleado = null;
	
	private JMenu jMenuClientes = null;
	private JMenuItem jMenuItemBajaCliente = null;
	private JMenuItem jMenuItemConCliente = null;
	
	private JMenu jMenuSandwich = null;
	private JMenu jMenuGestionSand = null;
	private JMenu jMenuGestionTipoSand = null;
	
	private JMenuItem jMenuItemCartaSand = null;
	private JMenuItem jMenuItemAltaSand = null;
	private JMenuItem jMenuItemMantSand = null;
	private JMenuItem jMenuItemAltaTipoSand = null;
	private JMenuItem jMenuItemMantTipoSand = null;
	
	private JMenu jMenuCocina = null;
	private JMenuItem jItemPedidoFin = null;
	
	private JMenu jMenuProducto = null;
	private JMenu jMenuGestionProd = null;
	private JMenuItem jAltaProd = null;
	private JMenuItem jConProd= null;
	private JMenuItem jBajaProd= null;
	private JMenuItem jModProd= null;

	private JMenu jMenuGestionFam = null;
	private JMenuItem jAltaFam= null;
	private JMenuItem jModFam= null;
	private JMenuItem jBajaFam= null;
	private JMenuItem jConFam= null;


	private JMenu jStock_Estadisitiques = null;
	private JMenu jStock = null;
	private JMenuItem jStockTotal = null;
	private JMenuItem jStockFam = null;
	private JMenu jFacturacio = null;
	private JMenuItem jfactutotal = null;
	private JMenuItem jFacturaciosand = null;

	private JMenu jMenuPromocio = null;
	private JMenuItem jMenuItemCrearPromo = null;
	private JMenuItem jMenuItemBorrarPromo = null;
	private JMenuItem jMenuItemModificarPromo = null;
	private JMenuItem jMenuItemConsultarPromo = null;

	private ServiciosModelo sm = null;  

	private ControladorAplicacionEmpleado cae = null;


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
		this.setSize(800, 600);
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
		jMenuItemLogout.setActionCommand("CS");
		jMenuItemAltaEmpleado.setActionCommand("AE");
		jMenuItemModifEmpleado.setActionCommand("ME");
		jMenuItemBajaEmpleado.setActionCommand("BE");
		jMenuItemConEmpleado.setActionCommand("CE");
		jMenuItemBajaCliente.setActionCommand("BC");
		jMenuItemConCliente.setActionCommand("CC");
		jMenuItemCartaSand.setActionCommand("CSAN");
		jMenuItemAltaSand.setActionCommand("ASAN");
		jMenuItemMantSand.setActionCommand("MSAN");
		jMenuItemAltaTipoSand.setActionCommand("ATS");
		jMenuItemMantTipoSand.setActionCommand("MTS");
		jItemPedidoFin.setActionCommand("PF");
		jAltaProd.setActionCommand("AP");
		jConProd.setActionCommand("CP");
		jBajaProd.setActionCommand("BP");
		jModProd.setActionCommand("MP");
		jAltaFam.setActionCommand("AF");
		jModFam.setActionCommand("MF");
		jBajaFam.setActionCommand("BF");
		jConFam.setActionCommand("CF");
		jStockTotal.setActionCommand("ST");
		jStockFam.setActionCommand("SF");
		jfactutotal.setActionCommand("FT");
		jFacturaciosand.setActionCommand("FS");
		jMenuItemCrearPromo.setActionCommand("APRO");
		jMenuItemBorrarPromo.setActionCommand("BPRO");
		//jMenuItemModificarPromo.setActionCommand("MPRO");
		//jMenuItemConsultarPromo.setActionCommand("CPRO");

		jMenuItemLogin.addActionListener(cae);
		jMenuItemLogout.addActionListener(cae);
		jMenuItemAltaEmpleado.addActionListener(cae);
		jMenuItemModifEmpleado.addActionListener(cae);
		jMenuItemBajaEmpleado.addActionListener(cae);
		jMenuItemConEmpleado.addActionListener(cae);
		jMenuItemBajaCliente.addActionListener(cae);
		jMenuItemConCliente.addActionListener(cae);
		jMenuItemCartaSand.addActionListener(cae);
		jMenuItemAltaSand.addActionListener(cae);
		jMenuItemMantSand.addActionListener(cae);
		jMenuItemAltaTipoSand.addActionListener(cae);
		jMenuItemMantTipoSand.addActionListener(cae);
		jItemPedidoFin.addActionListener(cae);
		jAltaProd.addActionListener(cae);
		jConProd.addActionListener(cae);
		jBajaProd.addActionListener(cae);
		jModProd.addActionListener(cae);
		jAltaFam.addActionListener(cae);
		jModFam.addActionListener(cae);
		jBajaFam.addActionListener(cae);
		jConFam.addActionListener(cae);
		jStockTotal.addActionListener(cae);
		jStockFam.addActionListener(cae);
		jfactutotal.addActionListener(cae);
		jFacturaciosand.addActionListener(cae);
		jMenuItemCrearPromo.addActionListener(cae);
		jMenuItemBorrarPromo.addActionListener(cae);
	//	jMenuItemModificarPromo.addActionListener(cae);
		//jMenuItemConsultarPromo.addActionListener(cae);

	
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
			jJMenuBar.add(getJMenuSesion());
			jJMenuBar.add(getJMenuUsuarios());
			jJMenuBar.add(getJMenuPromocio());
			jJMenuBar.add(getJMenuSandwich());
			jJMenuBar.add(getJMenuCocina());
			jJMenuBar.add(getJMenuProductos());
			jJMenuBar.add(getJStock_Estadisitiques());
				
		}
		return jJMenuBar;
	}

	
	private JMenu getJMenuProductos() {
		if (jMenuProducto == null) {
			jMenuProducto = new JMenu();
			jMenuProducto.setText("Productos");
			jMenuProducto.add(getMenuGestionProd());
			jMenuProducto.add(getMenuGestionFam());
			
		}
		return jMenuProducto;
	}
	
	private JMenu getMenuGestionProd(){
		if (jMenuGestionProd == null) {
			jMenuGestionProd = new JMenu();
			jMenuGestionProd.setText("Gestión Productos");
			jMenuGestionProd.add(getAltaProducto());
			jMenuGestionProd.add(getModificarProducto());
			jMenuGestionProd.add(getBajaProducto());
			jMenuGestionProd.add(getConsultaProducto());
			
		}
		return jMenuGestionProd;
	}
	
	private JMenu getMenuGestionFam(){
		if (jMenuGestionFam == null) {
			jMenuGestionFam = new JMenu();
			jMenuGestionFam.setText("Gestión Familias de Productos");
			jMenuGestionFam.add(getAltaFam());
			jMenuGestionFam.add(getModificarFam());
			jMenuGestionFam.add(getBajaFam());
			jMenuGestionFam.add(getConsultaFam());
			
		}
		return jMenuGestionFam;
	}
	private JMenuItem getConsultaProducto() {
		if (jConProd == null) {
			jConProd = new JMenuItem();
			jConProd.setText("Consultar Producto");
		}
		return jConProd;
	}

	private JMenuItem getBajaProducto() {
		if (jBajaProd == null) {
			jBajaProd = new JMenuItem();
			jBajaProd.setText("Dar de baja Producto");
		}
		return jBajaProd;
	}

	private JMenuItem getModificarProducto() {
		if (jModProd == null) {
			jModProd = new JMenuItem();
			jModProd.setText("Modificar Producto");
		}
		return jModProd;
	}

	/**
	 * This method initializes jaltaarticle	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAltaProducto() {
		if (jAltaProd == null) {
			jAltaProd = new JMenuItem();
			jAltaProd.setText("Alta Producto");
		}
		return jAltaProd;
	}

	
	private JMenuItem getConsultaFam() {
		if (jConFam == null) {
			jConFam = new JMenuItem();
			jConFam.setText("Consultar Familia");
		}
		return jConFam;
	}

	private JMenuItem getBajaFam() {
		if (jBajaFam == null) {
			jBajaFam = new JMenuItem();
			jBajaFam.setText("Dar de baja Familia");
		}
		return jBajaFam;
	}

	private JMenuItem getModificarFam() {
		if (jModFam == null) {
			jModFam = new JMenuItem();
			jModFam.setText("Modificar Familia");
		}
		return jModFam;
	}

	/**
	 * This method initializes jaltaarticle	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAltaFam() {
		if (jAltaFam == null) {
			jAltaFam = new JMenuItem();
			jAltaFam.setText("Alta Familia");
		}
		return jAltaFam;
	}
	private JMenu getJMenuCocina() {
	
		if (jMenuCocina == null) {
			jMenuCocina = new JMenu();
			jMenuCocina.setText("Gestión Pedidos");
			jMenuCocina.add(getJItemPedidoFin());
		}
		return jMenuCocina;
		


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
			jMenuItemLogin.setText("Iniciar Sesión");
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
			jMenuItemLogout.setText("Cerrar Sessión");
		}
		return jMenuItemLogout;
	}

	

	private JMenu getJMenuUsuarios() {
		
		if (jMenuUsuarios == null) {
			jMenuUsuarios = new JMenu();
			jMenuUsuarios.setText("Mantenimiento usuarios");
			jMenuUsuarios.add(getJMenuEmpleados());
			jMenuUsuarios.add(getJMenuClientes());
		}
		return jMenuUsuarios;
	}

	/**
	 * This method initializes jMenuEmpleados	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuEmpleados() {
		if (jMenuEmpleados == null) {
			jMenuEmpleados = new JMenu();
			jMenuEmpleados.setText("Empleados");
			jMenuEmpleados.add(getJMenuItemAltaEmpleado());
			jMenuEmpleados.add(getJMenuItemModifEmpleado());
			jMenuEmpleados.add(getJMenuItemBajaEmpleado());
			jMenuEmpleados.add(getJMenuItemConEmpleado());
			
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
			jMenuItemAltaEmpleado.setText("Alta Empleado");
		}
		return jMenuItemAltaEmpleado;
	}

	/**
	 * This method initializes jMenuItemModifEmpleado	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemModifEmpleado() {
		if (jMenuItemModifEmpleado == null) {
			jMenuItemModifEmpleado = new JMenuItem();
			jMenuItemModifEmpleado.setText("Modificar Empleado");
		
		}
		return jMenuItemModifEmpleado;
	}

	private JMenuItem getJMenuItemConEmpleado() {
		if (jMenuItemConEmpleado == null) {
			jMenuItemConEmpleado = new JMenuItem();
			jMenuItemConEmpleado.setText("Consultar Empleado");
		
		}
		return jMenuItemConEmpleado;
	}

	private JMenuItem getJMenuItemBajaEmpleado() {
		if (jMenuItemBajaEmpleado == null) {
			jMenuItemBajaEmpleado = new JMenuItem();
			jMenuItemBajaEmpleado.setText("Dar de baja Empleado");
		
		}
		return jMenuItemBajaEmpleado;
	}
	
	private JMenuItem getJMenuClientes() {
		
		if (jMenuClientes == null) {
			jMenuClientes = new JMenu();
			jMenuClientes.setText("Clientes");
			jMenuClientes.add(getJMenuItemConCliente());
			jMenuClientes.add(getJMenuItemBajaCliente());
		}
		return jMenuClientes;
	}

	
	private JMenuItem getJMenuItemConCliente() {
		if (jMenuItemConCliente == null) {
			jMenuItemConCliente = new JMenuItem();
			jMenuItemConCliente.setText("Consultar Cliente");
		
		}
		return jMenuItemConCliente;
	}

	private JMenuItem getJMenuItemBajaCliente() {
		if (jMenuItemBajaCliente == null) {
			jMenuItemBajaCliente = new JMenuItem();
			jMenuItemBajaCliente.setText("Dar de baja Cliente");
		
		}
		return jMenuItemBajaCliente;
	}
	
	
	/**
	 * This method initializes jMenuPromocio	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuPromocio() {
		if (jMenuPromocio == null) {
			jMenuPromocio = new JMenu();
			jMenuPromocio.setText("Promociones");
			jMenuPromocio.add(getJMenuItemCrearPromo());
		//	jMenuPromocio.add(getJMenuItemModificarPromo());
			jMenuPromocio.add(getJMenuItemBorrarPromo());
			//jMenuPromocio.add(getJMenuItemConsultarPromo());
			
		}
		return jMenuPromocio;
	}

	/**
	 * This method initializes jMenuItemCrear	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemCrearPromo() {
		if (jMenuItemCrearPromo == null) {
			jMenuItemCrearPromo = new JMenuItem();
			jMenuItemCrearPromo.setText("Crear Promoción");
		}
		return jMenuItemCrearPromo;
	}

	/**
	 * This method initializes jMenuItemEsborrar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemBorrarPromo() {
		if (jMenuItemBorrarPromo == null) {
			jMenuItemBorrarPromo = new JMenuItem();
			jMenuItemBorrarPromo.setText("Borrar Promoción");
		}
		return jMenuItemBorrarPromo;
	}

	/**
	 * This method initializes jMenuItemModificar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemModificarPromo() {
		if (jMenuItemModificarPromo == null) {
			jMenuItemModificarPromo = new JMenuItem();
			jMenuItemModificarPromo.setText("Modificar Promoción");
		}
		return jMenuItemModificarPromo;
	}

	/**
	 * This method initializes jMenuItemConsultar	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItemConsultarPromo() {
		if (jMenuItemConsultarPromo == null) {
			jMenuItemConsultarPromo = new JMenuItem();
			jMenuItemConsultarPromo.setText("Consultar Promoción");
		}
		return jMenuItemConsultarPromo;
	}


	

	/**
	 * This method initializes jCuina	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenuSandwich() {
		if (jMenuSandwich == null) {
			jMenuSandwich = new JMenu();
			jMenuSandwich.setText("Sandwichs");
			jMenuSandwich.add(getJMenuGestionSand());
			jMenuSandwich.add(getJMenuGestionTipoSand());
			jMenuSandwich.add(getJMenuItemCartaSand());
			
		}
		return jMenuSandwich;
	}

	private JMenuItem getJMenuItemCartaSand() {
		if (jMenuItemCartaSand == null) {
			jMenuItemCartaSand = new JMenuItem();
			jMenuItemCartaSand.setText("Carta de Sandwiches");
		}
		return jMenuItemCartaSand;
	}

	private JMenu getJMenuGestionTipoSand() {
		if(jMenuGestionTipoSand == null) {
			jMenuGestionTipoSand = new JMenu();
			jMenuGestionTipoSand.setText("Gestión Tipo de Sandwiches");
			jMenuGestionTipoSand.add(getAltaTipoSand());
			jMenuGestionTipoSand.add(getMantTipoSand());
		}
		return jMenuGestionTipoSand;
	}

	private JMenuItem getMantSand() {
		if (jMenuItemMantSand == null) {
			jMenuItemMantSand = new JMenuItem();
			jMenuItemMantSand.setText("Mantenimiento Sandwiches");
		}
		return jMenuItemMantSand;
	}

	private JMenuItem getAltaSand() {
		if (jMenuItemAltaSand == null) {
			jMenuItemAltaSand = new JMenuItem();
			jMenuItemAltaSand.setText("Alta Sandwich");
		}
		return jMenuItemAltaSand;
	}

	private JMenu getJMenuGestionSand() {
		if(jMenuGestionSand == null) {
			jMenuGestionSand = new JMenu();
			jMenuGestionSand.setText("Gestión Sandwiches");
			jMenuGestionSand.add(getAltaSand());
			jMenuGestionSand.add(getMantSand());
		}
		return jMenuGestionSand;
		
	}

	private JMenuItem getMantTipoSand() {
		if (jMenuItemMantTipoSand == null) {
			jMenuItemMantTipoSand = new JMenuItem();
			jMenuItemMantTipoSand.setText("Mantenimiento Tipos de Sandwiches");
		}
		return jMenuItemMantTipoSand;
	}

	private JMenuItem getAltaTipoSand() {
		if (jMenuItemAltaTipoSand == null) {
			jMenuItemAltaTipoSand = new JMenuItem();
			jMenuItemAltaTipoSand.setText("Alta Tipo de Sandwich");
		}
		return jMenuItemAltaTipoSand;
	}

	/**
	 * This method initializes jStock_Estadisitiques	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJStock_Estadisitiques() {
		if (jStock_Estadisitiques == null) {
			jStock_Estadisitiques = new JMenu();
			jStock_Estadisitiques.setText("Estadisticas");
			jStock_Estadisitiques.add(getJStock());
			jStock_Estadisitiques.add(getJFacturacio());
			
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
			jStock.setText("Stock de Productos");
			jStock.add(getStockTotal());
			jStock.add(getStockFam());
		}
		return jStock;
	}

	private JMenuItem getStockFam() {
		if (jStockFam == null) {
			jStockFam = new JMenuItem();
			jStockFam.setText("Stock por Familia");
		}
		return jStockFam;
	}

	private JMenuItem getStockTotal() {
		if (jStockTotal == null) {
			jStockTotal = new JMenuItem();
			jStockTotal.setText("Stock total");
		}
		return jStockTotal;
	}

	/**
	 * This method initializes jFacturacio	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJFacturacio() {
		if (jFacturacio == null) {
			jFacturacio = new JMenu();
			jFacturacio.setText("Facturacion");
			jFacturacio.add(getJfactutotal());
			jFacturacio.add(getJFacturaciosand());
		}
		return jFacturacio;
	}

	
	

	/**
	 * This method initializes jfactutotal	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJfactutotal() {
		if (jfactutotal == null) {
			jfactutotal = new JMenuItem();
			jfactutotal.setText("Facturación total");
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
			jFacturaciosand.setText("Facturación por Sandwitch");
		}
		return jFacturaciosand;
	}
	

	/**
	 * This method initializes jItemPedidoFin	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJItemPedidoFin() {
		if (jItemPedidoFin == null) {
			jItemPedidoFin = new JMenuItem();
			jItemPedidoFin .setText("Finalización de Pedidos");			
		}
		return jItemPedidoFin;
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
		 JOptionPane.showInternalMessageDialog(this, mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
		
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

}

