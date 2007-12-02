import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;




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
		
	
		return sandwich ;
		
	}
	
	
	public void guarda(Sandwich sandwich) throws errorConexionBD{
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		PreparedStatement ps=null;
		String sql="";
		
		
		
		
		sql="INSERT INTO sandwich VALUES (?,?,?,?,?);";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, sandwich.getIdProducto());
			ps.setString(2, sandwich.getDescripcion());
			ps.setFloat(3,sandwich.getPrecio());
			ps.setInt(4, (sandwich.getTipoSandwich()).getId());
			ps.setDate(5, new java.sql.Date((sandwich.getFechaBaja()).getTime()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void elimina(Sandwich sandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		String sql="";
		
		
		
		
		sql="DELETE FROM sandwich WHERE id="+sandwich.getIdProducto()+";";
		
		try {
			st=con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
		
	
	public Collection lista() throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		Collection<Sandwich> cl=new Vector<Sandwich>();
		sql="SELECT * FROM sandwich";
		GestorTipoSandwich gts=new GestorTipoSandwich();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				Sandwich sa=new Sandwich();
				sa.setIdProducto(rs.getInt(1));
				sa.setDescripcion(rs.getString(2));
				sa.setPrecio(rs.getFloat(3));
				sa.setTipoSandwich(gts.leePorId(rs.getInt(4)));
				sa.setFechaBaja(rs.getDate(5));
				cl.add(sa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cl;
	
		
		}
	public Collection listaPorTipo(TipoSandwich tipoSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		Collection<Sandwich> cl=new Vector<Sandwich>();
		sql="SELECT * FROM tiposandwich WHERE descripcion='"+tipoSandwich+"';";
		GestorTipoSandwich gts=new GestorTipoSandwich();
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				Sandwich sa=new Sandwich();
				sa.setIdProducto(rs.getInt(1));
				sa.setDescripcion(rs.getString(2));
				sa.setPrecio(rs.getFloat(3));
				sa.setTipoSandwich(gts.leePorId(rs.getInt(4)));
				sa.setFechaBaja(rs.getDate(5));
				cl.add(sa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cl;
	}	

    @SuppressWarnings("deprecation")
	public static void main(String[] arg) throws errorConexionBD{
    	
    	GestorSandwich gs=new GestorSandwich();
    	GestorTipoSandwich gts=new GestorTipoSandwich();
    	Sandwich sa=new Sandwich();
    	sa.setIdProducto(1001);
    	sa.setDescripcion("bigmac");
    	sa.setPrecio(20.50f);
    	sa.setTipoSandwich(gts.leePorId(30));
    	sa.setFechaBaja(new java.sql.Date(2007,11,23));
    	//gs.guarda(sa);
    	
    	
    	Collection cn=gs.lista();
		Iterator it=cn.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
    	
    }

}
