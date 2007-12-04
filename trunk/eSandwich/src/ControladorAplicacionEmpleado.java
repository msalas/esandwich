import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAplicacionEmpleado implements ActionListener {

  AplicacionEmpleado ae = null;

  public ControladorAplicacionEmpleado(AplicacionEmpleado aplicacionEmpleado) {
    ae = aplicacionEmpleado;
  }

  public void actionPerformed(ActionEvent evt) {
    System.out.println("ControladorAplicacionEmpleado.actionPerformed()");
    String action = evt.getActionCommand();

    System.out.println("Action = " + action);

    ae.setComanda(action);
    
    if (action.equals("IS")) new PantallaLogin(ae).setVisible(true);
    else if (action.equals("AE")) new PantallaAltaEmpleado(ae).setVisible(true);
    else if (action.equals("ME")) new PantallaBuscarEmpleado(ae, "ME").setVisible(true);
    else if (action.equals("BE")) new PantallaBuscarEmpleado(ae, "BE").setVisible(true);
    else if (action.equals("CE")) new PantallaBuscarEmpleado(ae, "CE").setVisible(true);
    else if (action.equals("BC")) new PantallaBuscarCliente(ae, "BC").setVisible(true);
    else if (action.equals("CC")) new PantallaBuscarCliente(ae, "CC").setVisible(true);
    else if (action.equals("CSAN")) new PantallaCartaSandwich(ae).setVisible(true);
    else if (action.equals("ASAN")) new PantallaAltaSandwich(ae).setVisible(true);
    else if (action.equals("MSAN")) new PantallaMantenimientoSandwich(ae).setVisible(true);
    else if (action.equals("ATS")) new PantallaAltaTipoSandwich(ae).setVisible(true);
    else if (action.equals("MTS")) new PantallaMantenimientoTipoSandwich(ae).setVisible(true);
    else if (action.equals("PF")) new PantallaFinalizarPedidos(ae).setVisible(true);
    else if (action.equals("AP")) new PantallaInsertarProducto(ae).setVisible(true);
    else if (action.equals("CP")) new PantallaBuscarProducto(ae).setVisible(true);
    else if (action.equals("BP")) new PantallaBuscarProducto(ae).setVisible(true);
    else if (action.equals("MP")) new PantallaBuscarProducto(ae).setVisible(true);
    else if (action.equals("AF")) new PantallaInsertarFamilia(ae).setVisible(true);
    else if (action.equals("MF")) new PantallaBuscarFamilia(ae).setVisible(true);
    else if (action.equals("BF")) new PantallaBuscarFamilia(ae).setVisible(true);
    else if (action.equals("CF")) new PantallaBuscarFamilia(ae).setVisible(true);
    else if (action.equals("ST")) new PantallaListadosStock(ae).setVisible(true);
    else if (action.equals("SF")) new PantallaListadosStock(ae).setVisible(true);
    else if (action.equals("FT")) new PantallaListadoFactura(ae).setVisible(true);
    else if (action.equals("FS")) new PantallaListadoFactura(ae).setVisible(true);
    else if (action.equals("APRO")) new PantallaAltaPromocion(ae).setVisible(true);
    else if (action.equals("BPRO")) new PantallaBajaPromocion(ae).setVisible(true);
    else if (action.equals("CS")) {
    	int a = ae.confirmacio("Estas seguro que quiere cerrar la sesión?", "Cerrar Sesión");
    	// Falta hacer el logout
    	if (a==0)ae.setMenuBasico();
    }
    else;
    
  }

}
