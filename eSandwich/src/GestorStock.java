import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
	
	
	
	
	
	
	
	
	
	
	
public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}
	
}
