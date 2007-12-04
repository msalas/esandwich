import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControladorServidor implements ActionListener {

	private ServidorModelo sm = null;
	private Servidor s = null;

	public ControladorServidor(Servidor servidor) {

		s = servidor;
		try {
			sm = new ServidorModelo();
		} catch (RemoteException re) {
			s.mostrarError("Error: Se ha producido una excepción remota: \n" + re,
					"Error connexión");
		} catch (errorConexionBD e) {
			s.mostrarError(e.getMessage(), "Error Base de Datos");
		} catch (Exception e) {
			s.mostrarError("Error: Se ha producido una excepción general", "Error");
		}

	}


	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand().equalsIgnoreCase("ISERV")) {

			try {
				sm.encenderServidor();
				(s.getJLabel1()).setText("Servidor Encendido!");
				(s.getJLabel1()).setForeground(Color.BLUE);
				(s.getJButton1()).setEnabled(false);
				(s.getJButton2()).setEnabled(true);

			} catch (MalformedURLException murle) {
				s.mostrarError("Error: URL del servidor incorrecta",
						"Error connexión");
			} catch (RemoteException re) {
				s.mostrarError("Error: Se ha producido una excepción remota: \n" + re,
						"Error connexión");
			} catch (Exception e) {
				s.mostrarError("Error: Se ha producido una excepción general", "Error");
			}

		} else if (arg0.getActionCommand().equalsIgnoreCase("ASERV")) {

			try {
				sm.apagarServidor();
				(s.getJLabel1()).setText("Servidor apagado!");
				(s.getJLabel1()).setForeground(Color.RED);
				(s.getJButton1()).setEnabled(true);
				(s.getJButton2()).setEnabled(false);
			} catch (MalformedURLException murle) {
				s.mostrarError("Error: URL del servidor incorrecta",
						"Error connexión");
			} catch (NotBoundException nbe) {
				s.mostrarError("Error: Falta de referencia del objeto en el registro",
								"Error connexión");
			} catch (RemoteException re) {
				s.mostrarError("Error: Se ha producido una excepción remota: \n" + re,
						"Error connexión");
			} catch (Exception e) {
				s.mostrarError("Error: Se ha producido una excepción general", "Error");
			}

		}
	}
}
