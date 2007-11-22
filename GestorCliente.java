import java.util.Collection;

public class GestorCliente {
  GestorDisco gd;

  public GestorCliente() throws errorConexionBD {
    gd = new GestorDisco();
  }

  public void elimina(Cliente cli) {

  }

  public void getCliente(long id) {

  }

  public void addCliente(Cliente cli) {

  }

  public Collection<Cliente> lista() {
    return null;
  }

  public Cliente listaPorUsuario(String idUsuario) {
    return null;
  }

  public Collection<Cliente> listaPorApellidos(String apellidos) {
    return null;
  }

  public Collection<Cliente> listaPorNomre(String nombre) {
    return null;
  }
}
