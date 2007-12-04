import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


public class ControladorPantallaAltaTipoSandwich implements ActionListener {
	
	private ServiciosCocinaModelo serviciosCocinaModelo = null;
	private PantallaAltaTipoSandwich pantallaAltaTipoSandwich = null;
	private AplicacionEmpleado aplicacionEmpleado = null;
	
	public ControladorPantallaAltaTipoSandwich
	  (PantallaAltaTipoSandwich pantallaAltaTipoSandwich,
			  AplicacionEmpleado aplicacionEmpleado){
		this.pantallaAltaTipoSandwich=pantallaAltaTipoSandwich;
		this.aplicacionEmpleado=aplicacionEmpleado;
	}
	
	
			            


	public void actionPerformed(ActionEvent e) {
		TipoSandwich tipoSandwich=new TipoSandwich();
		//tipoSandwich.setId(new Integer((pantallaAltaTipoSandwich.getJIdentificadorTextField()).getText()));
		tipoSandwich.setDescripcion((pantallaAltaTipoSandwich.getJNombreTextField()).getText());
		
		serviciosCocinaModelo=(ServiciosCocinaModelo) aplicacionEmpleado.getSm();
		try {
			serviciosCocinaModelo.altaTipoSandwich(tipoSandwich);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (errorConexionBD e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
