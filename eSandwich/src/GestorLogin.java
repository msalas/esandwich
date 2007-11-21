import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorLogin extends GestorDisco {

  public static final String tabla = "usuario";

  public GestorLogin() throws errorConexionBD {
    super();
    try {
      abrirConexion();

    } catch (errorConexionBD ecb) {
      System.err.println("Error conectando a la BDD.\n" + ecb);
    }
  }

  public void login(String login, String clave) {
    System.out.println("GestorLogin.login()");

    ResultSet rs;
    try {
      Statement stmt = getConexion().createStatement();
      System.out.println("Statement creado");

      String sSQL = "SELECT * FROM " + tabla + " WHERE nombre='" + login + "'";
      System.out.println("Ejecutando: " + sSQL);
      rs = stmt.executeQuery(sSQL);

      if (!rs.next()) {
        throw new SQLException("Login no encontrado");
      } else {
        String l = rs.getString("nombre");
        String c = rs.getString("clave");

        if (l.equals(login)) {
          if (c.equals(clave)) {
            System.out.println("Clave correcta");
            return;
          } else {
            // TODO ponerlo en ventana gráfica
            throw new SQLException("Clave incorrecat");
          }
        }
      }

    } catch (SQLException e) {
      System.err.println("Error en GestorLogin.login(): " + e);
      // e.printStackTrace();
    }

  }

}
