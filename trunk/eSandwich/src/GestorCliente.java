import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class GestorCliente {
  GestorDisco gd;

  public GestorCliente() throws errorConexionBD {
    gd = new GestorDisco();
    gd.abrirConexion();
  }

  public void elimina(Cliente cli) throws errorSQL, errorConexionBD {
    System.out.println("GestorCliente.elimina()");
    int id = cli.getId();
    String sql;
    Statement stmt = null;

    try {
      gd.begin();

      sql = "DELETE FROM cliente WHERE cod_cliente =" + id;
      System.out.println("Ejecutando: " + sql);
      stmt = gd.getConexion().createStatement();
      stmt.executeUpdate(sql);

      System.out.println("executeUpdate");

      sql = "DELETE FROM persona WHERE id =" + id;
      System.out.println("Ejecutando: " + sql);
      stmt.executeUpdate(sql);

      gd.commit();
      System.out.println("commit");
      stmt.close();

    } catch (SQLException e) {
      gd.rollback();
      throw new errorSQL(e.toString());

    } catch (errorConexionBD e) {
      System.err.println("Error en GestorCliente.elimina(): " + e);

    } catch (errorSQL e) {
      System.err.println("Error en GestorCliente.elimina(): " + e);
    }

  }

  public Cliente getCliente(int id) throws errorSQL, errorConexionBD {
    System.out.println("GestorCliente.getCliente()");
    Cliente cli = new Cliente();
    cli.setId(id);
    String sql;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      sql = "SELECT id, nif, nombre, apellido1, apellido2, "
          + "direccion, poblacion, telefono, movil, email, fecha_baja, "
          + "pasword, desactivado, cod_cliente, tarjeta_credito, puntos "
          + "FROM persona, usuario, cliente "
          + "WHERE id=cod_cliente AND cod_usuario=id AND id=" + id;
      System.out.println("Ejecutando: " + sql);
      stmt = gd.getConexion().createStatement();

      rs = stmt.executeQuery(sql);
      System.out.println("executeQuery");

      if (rs.next()) {
        cli.setId(id);
        cli.setNif(rs.getString("nif"));
        cli.setNombre(rs.getString("nombre"));
        cli.setApellido1(rs.getString("apellido1"));
        cli.setApellido2(rs.getString("apellido2"));
        cli.setDireccion(rs.getString("direccion"));
        cli.setPoblacion(rs.getString("poblacion"));
        cli.setTelefono(rs.getString("telefono"));
        cli.setMovil(rs.getString("movil"));
        cli.setEmail(rs.getString("email"));
        cli.setFechaBaja(rs.getDate("fecha_baja"));
        cli.setPassword(rs.getString("pasword"));
        cli.setCodUsuario(rs.getString("cod_cliente"));
        cli.setTarjetaCredito(rs.getString("tarjeta_credito"));
        cli.setPuntos(rs.getInt("puntos"));
        System.out.println("Cargados datos de persona y cliente");
      } else {
        System.out.println("cliente " + id + " no encontrado.");
      }

      stmt.close();
      rs.close();

    } catch (SQLException e) {
      throw new errorSQL(e.toString());

    }
    return cli;
  }

  public int addCliente(Cliente cli) throws errorConexionBD, errorSQL {
    System.out.println("GestorCliente.addCliente()");
    String sql;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int nuevoId = 0;

    try {
      // Precondición el NIF no existe en BDD
      sql = "SELECT nif FROM persona WHERE nif='" + cli.getNif() + "'";
      System.out.println("Ejecuando: " + sql);
      stmt = gd.getConexion().createStatement();

      rs = stmt.executeQuery(sql);

      if (rs.next()) {
        throw new errorSQL("NIF duplicado en INSERT");
      }

      // Primero insertamos en persona -------------------------------
      gd.begin();
      sql = "INSERT INTO persona(nif, nombre, apellido1, apellido2, "
          + "direccion, poblacion,telefono, movil, email, fecha_baja)"
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
      System.out.println("Ejecuando: " + sql);
      pstmt = gd.getConexion().prepareStatement(sql);
      // pstmt.setInt(1, 0); // id serial NOT NULL,
      pstmt.setString(1, cli.getNif());// nif character varying(9),
      pstmt.setString(2, cli.getNombre());// nombre character varying(50),
      pstmt.setString(3, cli.getApellido1());// apellido1 character
      pstmt.setString(4, cli.getApellido2());// apellido2 character
      pstmt.setString(5, cli.getDireccion());// direccion character
      pstmt.setString(6, cli.getPoblacion());// poblacion character
      pstmt.setString(7, cli.getTelefono());// telefono character varying(16),
      pstmt.setString(8, cli.getMovil());// movil character varying(16),
      pstmt.setString(9, cli.getEmail());// email character varying(100),
      pstmt.setDate(10, (java.sql.Date) cli.getFechaBaja());// fecha_baja date,
      rs = pstmt.executeQuery();
      System.out.println("Devolviendo el nuevo ID");
      if (rs.next()) {
        nuevoId = rs.getInt(1);
        System.out.println("Nuevo id: " + nuevoId);
      }
      // Libramos recursos de BDD
      pstmt.close();
      rs.close();

      // 2º Insertamos en cliente con el nuevo ID de persona -------------
      sql = "INSERT INTO cliente (cod_cliente, tarjeta_credito, puntos)"
          + "VALUES (?,?,?) RETURNING cod_cliente";
      System.out.println("Ejecuando: " + sql);
      pstmt = gd.getConexion().prepareStatement(sql);
      pstmt.setInt(1, nuevoId);
      pstmt.setString(2, cli.getTarjetaCredito());
      pstmt.setInt(3, 0);// 0 puntos inicialmente

      gd.commit();
      System.out.println("commit");
      rs = pstmt.executeQuery();
      rs.close();
      pstmt.close();

      return nuevoId;

    } catch (SQLException e) {
      System.err.println("Error en GestorCliente.addCliente()");
      gd.rollback();
      throw new errorSQL(e.toString());
    }

  }

  public void editaCliente(Cliente cli) throws errorSQL, errorConexionBD {
    System.out.println("GestorCliente.editaCliente()");
    String sql;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    int nuevoId = 0;

    try {
      // Precondición el ID existe en BDD
      sql = "SELECT id FROM persona WHERE id=" + cli.getId();
      System.out.println("Ejecuando: " + sql);
      stmt = gd.getConexion().createStatement();

      rs = stmt.executeQuery(sql);

      if (!rs.next()) {
        throw new errorSQL("Usuario inexistente en BDD");
      }

      // Primero insertamos en persona -------------------------------
      gd.begin();
      sql = "UPDATE persona "
          + "SET nif=?, nombre=?, apellido1=?, apellido2=?, direccion=?, "
          + "poblacion=?, telefono=?, movil=?, email=?, fecha_baja=? "
          + "WHERE id=" + cli.getId();
      System.out.println("Ejecuando: " + sql);
      pstmt = gd.getConexion().prepareStatement(sql);
      // pstmt.setInt(1, 0); // id serial NOT NULL,
      pstmt.setString(1, cli.getNif());// nif character varying(9),
      pstmt.setString(2, cli.getNombre());// nombre character varying(50),
      pstmt.setString(3, cli.getApellido1());// apellido1 character
      pstmt.setString(4, cli.getApellido2());// apellido2 character
      pstmt.setString(5, cli.getDireccion());// direccion character
      pstmt.setString(6, cli.getPoblacion());// poblacion character
      pstmt.setString(7, cli.getTelefono());// telefono character varying(16),
      pstmt.setString(8, cli.getMovil());// movil character varying(16),
      pstmt.setString(9, cli.getEmail());// email character varying(100),

      if (cli.getFechaBaja() != null) {
        pstmt.setDate(10, (java.sql.Date) cli.getFechaBaja());// fecha_baja
        // date,
      } else {
        pstmt.setNull(10, Types.DATE);
      }
      rs = pstmt.executeQuery();
      // Libramos recursos de BDD
      pstmt.close();
      rs.close();

      // 2º Insertamos en cliente con el nuevo ID de persona -------------
      sql = "UPDATE cliente " + "SET tarjeta_credito=?, puntos=? "
          + "WHERE cod_cliente=" + cli.getCodUsuario();
      System.out.println("Ejecuando: " + sql);
      pstmt = gd.getConexion().prepareStatement(sql);
      pstmt.setString(1, cli.getTarjetaCredito());
      pstmt.setInt(2, cli.getPuntos());

      pstmt.executeUpdate();
      System.out.println("commit");
      gd.commit();
      rs.close();
      pstmt.close();

    } catch (SQLException e) {
      System.err.println("Error en GestorCliente.editaCliente()");
      gd.rollback();
      throw new errorSQL(e.toString());
    }
  } /*
     * public Vector<Cliente> lista() throws errorSQL { Vector<Cliente> v =
     * new Vector<Cliente>(); Cliente cli = null; Statement stmt = null;
     * ResultSet rs = null;
     * 
     * try { stmt = gd.getConexion().createStatement(); String sql = "SELECT id,
     * nif, nombre, apellido1, apellido2," + " direccion, poblacion, telefono,
     * movil, email, fecha_baja, " + "cod_cliente, tarjeta_credito, puntos " +
     * "FROM cliente,persona " + "WHERE id = cod_cliente";
     * System.out.println("Ejecutando: \n" + sql); rs = stmt.executeQuery(sql);
     * while (rs.next()) { cli = new Cliente(); cli.setNif(rs.getString("nif"));
     * cli.setNombre(rs.getString("nombre"));
     * cli.setApellido1(rs.getString("apellido1"));
     * cli.setApellido2(rs.getString("apellido2"));
     * cli.setDireccion(rs.getString("direccion"));
     * cli.setPoblacion(rs.getString("poblacion"));
     * cli.setTelefono(rs.getString("telefono"));
     * cli.setMovil(rs.getString("movil")); cli.setEmail(rs.getString("email"));
     * cli.setFechaBaja(rs.getDate("fecha_baja")); //
     * cli.setCodUsuario(rs.getInt("cod_cliente"));
     * cli.setTarjetaCredito(rs.getString("tarjeta_credito"));
     * cli.setPuntos(rs.getInt("puntos"));
     * 
     * v.add(cli); } rs.close(); stmt.close(); } catch (SQLException e) { throw
     * new errorSQL(e.toString()); } return v; }
     */

  // Operación getUsuario es la misma
  // public Vector<Cliente> listaPorUsuario(String idUsuario) throws errorSQL {
  // Vector<Cliente> v = new Vector<Cliente>();
  // Cliente cli = null;
  // Statement stmt = null;
  // ResultSet rs = null;
  //    
  // try {
  // stmt = gd.getConexion().createStatement();
  // String sql = "SELECT id, nif, nombre, apellido1, apellido2,"
  // + " direccion, poblacion, telefono, movil, email, fecha_baja, "
  // + "cod_cliente, tarjeta_credito, puntos " + "FROM cliente,persona "
  // + "WHERE id = cod_cliente";
  // System.out.println("Ejecutando: \n" + sql);
  // rs = stmt.executeQuery(sql);
  // while (rs.next()) {
  // cli = new Cliente();
  // cli.setNif(rs.getString("nif"));
  // cli.setNombre(rs.getString("nombre"));
  // cli.setApellido1(rs.getString("apellido1"));
  // cli.setApellido2(rs.getString("apellido2"));
  // cli.setDireccion(rs.getString("direccion"));
  // cli.setPoblacion(rs.getString("poblacion"));
  // cli.setTelefono(rs.getString("telefono"));
  // cli.setMovil(rs.getString("movil"));
  // cli.setEmail(rs.getString("email"));
  // cli.setFechaBaja(rs.getDate("fecha_baja"));
  // // cli.setCodUsuario(rs.getInt("cod_cliente"));
  // cli.setTarjetaCredito(rs.getString("tarjeta_credito"));
  // cli.setPuntos(rs.getInt("puntos"));
  //
  // v.add(cli);
  // }
  // ResultSet rs = stmt.executeQuery(sql);
  // // while (rs.next()) {
  // // cli = new Cliente(rs.getInt(1));
  // // v.add(cli);
  // // }
  //
  // rs.close();
  // stmt.close();
  //
  // } catch (SQLException e) {
  // throw new errorSQL(e.toString());
  // }
  //
  // return v;
  // }
  /*
   * public Collection<Cliente> listaPorApellidos(String apellido1, String
   * apellido2) throws errorSQL { Vector<Cliente> v = new Vector<Cliente>();
   * Cliente cli = null; Statement stmt = null; ResultSet rs = null;
   * 
   * try { stmt = gd.getConexion().createStatement(); String sql = "SELECT id,
   * nif, nombre, apellido1, apellido2," + " direccion, poblacion, telefono,
   * movil, email, fecha_baja, " + "cod_cliente, tarjeta_credito, puntos " +
   * "FROM cliente,persona " + "WHERE id = cod_cliente AND apellido1 = '" +
   * apellido1 + "' AND apellido2='" + apellido2 + "'";
   * System.out.println("Ejecutando: \n" + sql); rs = stmt.executeQuery(sql);
   * while (rs.next()) { cli = new Cliente(); cli.setNif(rs.getString("nif"));
   * cli.setNombre(rs.getString("nombre"));
   * cli.setApellido1(rs.getString("apellido1"));
   * cli.setApellido2(rs.getString("apellido2"));
   * cli.setDireccion(rs.getString("direccion"));
   * cli.setPoblacion(rs.getString("poblacion"));
   * cli.setTelefono(rs.getString("telefono"));
   * cli.setMovil(rs.getString("movil")); cli.setEmail(rs.getString("email"));
   * cli.setFechaBaja(rs.getDate("fecha_baja")); //
   * cli.setCodUsuario(rs.getInt("cod_cliente"));
   * cli.setTarjetaCredito(rs.getString("tarjeta_credito"));
   * cli.setPuntos(rs.getInt("puntos"));
   * 
   * v.add(cli); } rs.close(); stmt.close(); } catch (SQLException e) { throw
   * new errorSQL(e.toString()); } return v; }
   */
  /*
   * public Collection<Cliente> listaPorNomre(String nombre) throws errorSQL {
   * Vector<Cliente> v = new Vector<Cliente>(); Cliente cli = null; Statement
   * stmt = null; ResultSet rs = null;
   * 
   * try { stmt = gd.getConexion().createStatement(); String sql = "SELECT id,
   * nif, nombre, apellido1, apellido2," + " direccion, poblacion, telefono,
   * movil, email, fecha_baja, " + "cod_cliente, tarjeta_credito, puntos " +
   * "FROM cliente,persona " + "WHERE id = cod_cliente AND nombre = '" + nombre +
   * "'"; System.out.println("Ejecutando: \n" + sql); rs =
   * stmt.executeQuery(sql); while (rs.next()) { cli = new Cliente();
   * cli.setNif(rs.getString("nif")); cli.setNombre(rs.getString("nombre"));
   * cli.setApellido1(rs.getString("apellido1"));
   * cli.setApellido2(rs.getString("apellido2"));
   * cli.setDireccion(rs.getString("direccion"));
   * cli.setPoblacion(rs.getString("poblacion"));
   * cli.setTelefono(rs.getString("telefono"));
   * cli.setMovil(rs.getString("movil")); cli.setEmail(rs.getString("email"));
   * cli.setFechaBaja(rs.getDate("fecha_baja")); //
   * cli.setCodUsuario(rs.getInt("cod_cliente"));
   * cli.setTarjetaCredito(rs.getString("tarjeta_credito"));
   * cli.setPuntos(rs.getInt("puntos"));
   * 
   * v.add(cli); } rs.close(); stmt.close(); } catch (SQLException e) { throw
   * new errorSQL(e.toString()); } return v; }
   */
  public void liberarRecursos() {
    gd.cerrarConexion();
  }

  public static void main(String[] args) {
    Cliente c = new Cliente();
    try {
      GestorCliente gCli = new GestorCliente();
      try {
        c.setId(0);
        c.setNif("12345679");
        c.setNombre("Pepito");
        c.setApellido1("Alto");
        c.setApellido2("Gómez");
        c.setDireccion("C/Industris 12-3");
        c.setPoblacion("Barcelona");
        c.setTelefono("93666545");
        c.setMovil("664 001122");
        c.setEmail("un.correo@no.es");
        c.setCodUsuario("0");
        c.setTarjetaCredito("122446489");

        // gCli.elimina(c);
        // gCli.addCliente(c);
        // gCli.getCliente(0);
        gCli.editaCliente(c);
        // System.out.println(gCli.lista());
        // System.out.println(gCli.listaPorApellidos("Pérez", "Gómez"));
        // System.out.println(gCli.listaPorNomre("Pepe"));
        // Vector<Cliente> v = gCli.lista();
        // for (int i = 0; i < v.size(); i++) {
        // System.out.println("Elemento " + i + ": " + v.get(i).getId() + "-"
        // + v.get(i).getCodUsuario());
        // }

      } catch (errorSQL e) {
        System.out.println(e.getMessage());
      }
      // gCli.liberarRecursos();
    } catch (errorConexionBD e) {
      System.out.println(e.getMessage());
    }

  }
}
