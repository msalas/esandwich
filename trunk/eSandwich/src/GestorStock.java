import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.lang.Integer;

public class GestorStock {
	private GestorDisco gd;
	Connection con = null;
	
	public GestorStock () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Vector<Stock> listaStock() throws errorSQL, errorConexionBD{
		
		Vector<Stock> v = new Vector<Stock>();
		Producto p = null;
		Stock s=null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT p.existencias from producto");
			while(rs.next()){
			s= new Stock(rs.getInt(1));
				v.add(s);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public Vector<Stock> listaStockPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		
		Vector<Stock> v = new Vector<Stock>();
		Producto p = null;
		Stock st = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String s = "SELECT p.existencias from producto p, familia f where p.id=f.id and f.id='"+idFamilia+"'";
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				st = new Stock(rs.getInt(1));
				v.add(st);
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}
	
	public void insertarStock(int unidades) throws errorSQL, errorConexionBD {
		
		String p;
		PreparedStatement pstmt = null;
		
		int id = 0;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			p=	"INSERT INTO producto (existencias)" + "VALUES (?) RETURNING id" ;			
			pstmt = con.prepareStatement(p);
			pstmt.setInt(1,unidades);
			gd.commit();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) id = rs.getInt(1);
			rs.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public void eliminaStock(int idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Producto p;
		String pr;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			pr= "DELETE FROM producto (existencias) WHERE p.id = '"+ idProducto+"'";
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public Stock consultaStock(int idProducto) throws errorSQL, errorConexionBD {
		
		
		Producto p = null;
		Stock s= null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String consulta="SELECT from producto(existencias) WHERE p.id=" + idProducto+ "'";
			ResultSet rs = stmt.executeQuery(consulta);
			if(rs.next()) id= rs.getInt(1); 
			rs.close();
			stmt.close();
			s = new Stock(rs.getInt(1));
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return s;
	}
	
	
	//si les necessitem les dessarrollem, però no els hi veig gaire sentit
	
	public void restaStock(int idp, int uni)throws errorSQL, errorConexionBD{	
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		Producto p = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String st = "UPDATE producto SET id = "+idp+" WHERE producto(existencias) = p.existencias - " + uni; 
			stmt.executeUpdate(st);
			stmt.close();
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());}
	}
	
	public void sumaStock(int idp, int uni)throws errorSQL, errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		Producto p = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String st = "UPDATE producto SET id = "+idp+" WHERE producto(existencias) = p.existencias + " + uni; 
			stmt.executeUpdate(st);
			stmt.close();
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
			}
	}

	
	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}
	
}
