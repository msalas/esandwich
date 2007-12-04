import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;



public class GestorIngredienteSandwich {
	
	GestorDisco gd;
	Connection con = null;
	
	public GestorIngredienteSandwich() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public IngredienteSandwich lee(int idSandwich, int idIngrediente){
		return null;
		
	}
	public void guarda(IngredienteSandwich ingredienteSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		PreparedStatement ps=null;
		String sql="";
		
		
		
		
		sql="INSERT INTO ingrediente VALUES (?,?,?);";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, ingredienteSandwich.getIdSandwich());
			ps.setInt(2, ingredienteSandwich.getIdIngrediente());
			ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	}
	public void elimina (IngredienteSandwich ingredienteSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		String sql="";
		
		
		
		
		sql="DELETE FROM ingrediente WHERE id_producto="+ingredienteSandwich.getIdSandwich()
		                +" AND id_ingrediente="+ingredienteSandwich.getIdIngrediente()+";";
		
		try {
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public Collection listaIngredientePorSandwich(int idSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		Collection<IngredienteSandwich> cl=new Vector<IngredienteSandwich>();
		sql="SELECT * FROM ingrediente WHERE id_producto="+idSandwich+";";
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				IngredienteSandwich is=new IngredienteSandwich();
				is.setIdSandwich(rs.getInt(1));
				is.setIdIngrediente(rs.getInt(2));
				is.setNombreIngrediente(rs.getString(3));
				cl.add(is);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
		
	}
	
	public Collection listaIngredientes() throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
	    ResultSet rs=null;
		String sql="";
	
		
		
		Collection<String> cl=new Vector<String>();
		sql="select p.descripcion from producto p,ingrediente i where p.id=i.id_ingrediente;"; ;
		
		
		try {
			st=con.createStatement();
		    rs=st.executeQuery(sql);
		
			
			while (rs.next()){
		          cl.add(rs.getString(1));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cl;
		
	}

}
