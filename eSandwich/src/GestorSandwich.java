import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;




/**
 * 
 */

/**
 * @author C010059
 *
 */
public class GestorSandwich {
	
	GestorDisco gd;
	Connection con = null;
	
	public GestorSandwich() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Sandwich lee(int idSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");

		Statement stmt = null;
		ResultSet rs = null;
		String sql="select * from sandwich where id="+idSandwich+";";
		Sandwich sandwich=null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				 sandwich= new Sandwich();
				 sandwich.setIdProducto(rs.getInt(1));
				 sandwich.setDescripcion(rs.getString(2));
				 sandwich.setPrecio(rs.getFloat(3));
				 sandwich.setTipoSandwich(new GestorTipoSandwich().leePorId(rs.getInt(4)));
				 
			}
				
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		
		
		
		
		
		
		return sandwich;
		
	}
	
	public void guarda(Sandwich sandwich) throws errorConexionBD{
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		PreparedStatement ps=null;
		String sql="";
		
		
		
		
		sql="INSERT INTO sandwich VALUES (?,?,?,?,?);";
		
		
		
		
	}
	
	public void elimina(Sandwich sandwich){
		
	}
		
	
	public Collection lista(){
		return null;
		
		}
	public Collection listaPorTipo(TipoSandwich tipoSandwich){
		return null;
		
	}
	

}
