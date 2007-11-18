
/**
 * Aquesta �s la classe que interacciona amb la BD.
 *  @Author TDP
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class GestorDisco
{
  /**atribut que indica si s'ha establert o no la connexi� amb la BD*/
  boolean conectado;
  /**atribut que indica si hi ha una transacci� en execusi�*/
  boolean enTransaccion;
  /**atribut que cont� l'objecte connexi� amb la BD*/
  Connection conexion;
 
  String url;
  String schema;
  String user;
  String pass;
  String driver;

  /**
   * Constructor de la classe gestorVotacio. Inicialitza els atributs.
 * @throws errorConexionBD 
   */
  public GestorDisco() throws errorConexionBD 
  {
	  Properties prop = null;
		try
		{ 
		  prop = new Properties();
		  FileInputStream fis = new FileInputStream("configuration.properties");
		  prop.load(fis);

		  this.url = prop.getProperty("url");
		  this.schema = prop.getProperty("schema");
		  this.user = prop.getProperty("username");
		  this.pass = prop.getProperty("password");
		  this.driver = prop.getProperty("driver");
		
		  //Carrega el driver del postgre
		   Class.forName(driver); 
		}
		catch (FileNotFoundException fnfe) 
		{
			throw new errorConexionBD("Error: No s'ha trobat el fitxer configuration.properties");
		}
		catch (IOException ioe) 
		{
			throw new errorConexionBD("Error: Problema amb el fitxer configuration.properties");
		}catch (ClassNotFoundException cnfe){
			throw new errorConexionBD("Error: No s'ha pogut carregar el driver");
		}catch (Exception e){
			throw new errorConexionBD("Error: No s'ha pogut establir la configuraci� de la Base de Dades");
		}
		
    conectado = false;
    enTransaccion = false;
  }
  
  
	
  /**
   * Procediment que tanca la connexi� amb la BD.
   * {Pre: Existeix una connexi� amb la BD}.
   * {Post: S'ha tancat la connexi�}.
   */
  public void cerrarConexion()
  {
    if ( ! conectado )
      return;

    if ( enTransaccion )
    {
	  enTransaccion = false;	  	
	  try {
        conexion.rollback();
	  } catch (Exception e) {}
    }

    try {
     
      conexion.close();
    } catch (Exception e) {}

    conectado = false;
  }

  /**
   * Procediment que estableix una connexi� amb la BD.
   * {Pre: existeix el nom ODBC per a la connexi� a la BD}.
   * {Post: S'ha establert la connexi� amb la BD}.
   * @param nomBD String que cont� el nom ODBC
   * @throws errorConexionBD si no s'ha pogut establir la connexi� amb la BD 
   */
  public void abrirConexion() throws errorConexionBD
  {
    
    try {
      conexion = DriverManager.getConnection(url,user,pass);
     // sentencia = conexion.createStatement();
    } catch (Exception e) {
      throw new errorConexionBD("Error en getConnection: " + e.toString());
    };

    conectado = true;
  }

  /**
   * Procediment que inicia una transacci�.
   * {Pre: hi ha una connexi� a la BD oberta}.
   * {Post: S'ha iniciat una transacci�}.
   * @throws errorConexionBD si no hi ha una connexi� amb la BD.
   * @throws errorSQL si hi ha un error en iniciar la transacci�.
   */
  public void begin()
	throws errorConexionBD, errorSQL
  {
    if ( ! conectado )
      throw new errorConexionBD("conexion no establerta.");

    try {
      conexion.setAutoCommit(false);
      conexion.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
    } catch (Exception e) {
      throw new errorSQL (e.toString());
    }

    enTransaccion = true;
    return;
  }

  /**
   * Procediment que finalitza una transacci� acceptant les actualitzacions.
   * {Pre: hi ha una connexi� a la BD oberta}.
   * {Post: S'ha tancat la transacci�}.
   * @throws errorConexionBD si no hi ha una connexi� amb la BD.
   * @throws errorSQL si hi ha un error en tancar la transacci�.
   */
  public void commit()
	throws errorConexionBD, errorSQL
  {
    if ( ! conectado )
      throw new errorConexionBD("conexion no establerta.");

    if ( ! enTransaccion )
      return;

    enTransaccion = false;
    try {
      conexion.commit();
      conexion.setAutoCommit(true);
    } catch (Exception e) {
      throw new errorSQL (e.toString());
    }
    return;
  }

  /**
   * Procediment que finalitza una transacci� desfent les actualitzacions.
   * {Pre: hi ha una connexi� a la BD oberta}.
   * {Post: S'ha tancat la transacci�}.
   * @throws errorConexionBD si no hi ha una connexi� amb la BD.
   * @throws errorSQL si hi ha un error en tancar la transacci�.
   */
  public void rollback()
	throws errorConexionBD, errorSQL
  {
    if ( ! conectado )
      throw new errorConexionBD("conexion no establerta.");

    if ( ! enTransaccion )
      return;

    enTransaccion = false;
    try {
      conexion.rollback();
      conexion.setAutoCommit(true);
    } catch (Exception e) {
      throw new errorSQL (e.toString());
    }
    return;
  }

  /**
   * Funci� que tanca la connexi� amb la BD. La crida el garbage collector quan es 
   * detruiex l'objecte.
   * {Pre: No hi ha m�s refer�ncies a l'objecte en mem�ria}.
   * {Post: S'ha tancat la connexi� amb la BD}. 
   */
  protected void finalize()
  {
    cerrarConexion();
    return;
  }


public boolean isConectado() {
	return conectado;
}


public void setConectado(boolean conectado) {
	this.conectado = conectado;
}


public boolean isEnTransaccion() {
	return enTransaccion;
}


public void setEnTransaccion(boolean enTransaccion) {
	this.enTransaccion = enTransaccion;
}


public Connection getConexion() {
	return conexion;
}


public void setConexion(Connection conexion) {
	this.conexion = conexion;
}

 /* Procediment per fer les proves unit�ries de la classe
  public static void main (String[] args) {
  GestorDisco gd = new GestorDisco();
  try {
    gd.abrirConexion();
	System.out.println(gd.insertar("votacioCircums", "(3, 3)"));
	gd.begin();
	System.out.println(gd.insertar("votacioCircums", "(1, 1)"));
	System.out.println(gd.insertar("votacioCircums", "(2, 2)"));
	gd.commit();
    gd.cerrarConexion();
	//System.out.println(gd.insertar("votacioCircums", "(4, 4)"));
  } catch (Exception e) {
    System.out.println (e.toString());
  }
  }*/
}
