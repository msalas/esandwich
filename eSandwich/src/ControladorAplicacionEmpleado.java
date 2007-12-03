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

  
    
    if (action.equals("IS")) new PantallaLogin(ae).setVisible(true);
    else if (action.equals("AE")) new PantallaAltaEmpleado(ae).setVisible(true);
    else if (action.equals("ME")) new PantallaModificacionEmpleado(ae).setVisible(true);
    else if (action.equals("BE")) new PantallaBajaEmpleado(ae).setVisible(true);
    else if (action.equals("CE")) new PantallaConsultaEmpleado(ae).setVisible(true);
    else if (action.equals("BC")) new PantallaBajaCliente(ae).setVisible(true);
    else if (action.equals("CC")) new PantallaConsultaCliente(ae).setVisible(true);
    else if (action.equals("CSAN")) new PantallaCartaSandwich(ae).setVisible(true);
    else if (action.equals("ASAN")) new PantallaAltaSandwich(ae).setVisible(true);
    else if (action.equals("MASAN")) new PantallaMantenimientoSandwich(ae).setVisible(true);
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
    	ae.confirmacio("Estas seguro que quiere cerrar la sesión?", "Cerrar Sesión");
    	// Falta hacer el logout
    }
    else;
    
  }

}
