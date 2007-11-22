import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorLogin implements RMILoginInterface {

  private GestorDisco gd;

  // public static final String tabla = "usuario";

  public GestorLogin() throws errorConexionBD {
    super();
    try {
      gd = new GestorDisco();
      gd.abrirConexion();

    } catch (errorConexionBD ecb) {
      System.err.println("Error conectando a la BDD.\n" + ecb);
    }
  }

  public void login(String login, String clave) throws RemoteException {
    System.out.println("GestorLogin.login()");

    ResultSet rs;
    String user = null;
    String pass = null;
    try {
      Statement stmt = gd.getConexion().createStatement();
      System.out.println("Statement creado");

      String sSQL = "SELECT * FROM usuario,persona "
          + " WHERE usuario.\"cod-usuario\"=persona.id AND nif='" + login + "'";
      System.out.println("Ejecutando: " + sSQL);
      rs = stmt.executeQuery(sSQL);

      if (!rs.next()) {
        String msg = "Login no encontrado";
        System.err.println(msg);
        throw new RemoteException(msg);
      } else {
        user = rs.getString("nombre");
        pass = rs.getString("password");
        System.out.println("Obtenidos login/pass");
      }

    } catch (SQLException e) {
      System.err.println("Error en GestorLogin.login(): " + e);
      // e.printStackTrace();
    }
    if (user.equals(login)) {
      if (pass.equals(clave)) {
        System.out.println("Clave correcta");
        return;
      } else {
        // TODO ponerlo en ventana gráfica
        throw new RemoteException("Clave incorrecta");
      }
    }

  }

}
