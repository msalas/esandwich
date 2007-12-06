import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
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
		ResultSet rs=null;
		String sql="";
		int id=0;
		GestorTipoSandwich gts=new GestorTipoSandwich();
		
		
		//MODIFICADO
		sql="INSERT INTO producto(descripcion,descripcion_ampliada,existencias, id_familia" +
				",precio)  VALUES (?,?,?,?,?) RETURNING id; ";
		
		try {
			ps=con.prepareStatement(sql);
			
			//ps.setInt(1, sandwich.getIdProducto());
			ps.setString(1, sandwich.getDescripcion());
			ps.setString(2, sandwich.getDescripcionAmpliada());
			ps.setInt(3, 1);
			ps.setInt(4,1);
			ps.setFloat(5, sandwich.getPrecio());
			//ps.setDate(4, new java.sql.Date((sandwich.getFechaBaja()).getTime()));
			
			rs=ps.executeQuery();
			
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		sql="INSERT INTO sandwich(id, nombre, id_tipo_sandwich, fecha_baja) VALUES (?, ?, ?, ?);";
		Date dt=sandwich.getFechaBaja();
		try {
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setString(2, sandwich.getDescripcion());
			ps.setInt(3, (gts.devuelveId(sandwich.getTipoSandwich().getDescripcion())));
			if (dt!=null){
				ps.setDate(4, new java.sql.Date((sandwich.getFechaBaja()).getTime()));
			}else{
				ps.setDate(4,null);
			}
			
			
			
			ps.executeUpdate();
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				Date dt=sa.getFechaBaja();
				sa.setIdProducto(rs.getInt(1));
				sa.setDescripcion(rs.getString(2));
				sa.setTipoSandwich(gts.leePorId(rs.getInt(3)));
				if (dt!=null){
				sa.setFechaBaja(rs.getDate(4));
				}else{
					sa.setFechaBaja(null);
				}
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
		sql="SELECT * FROM tipo_sandwich WHERE descripcion='"+tipoSandwich+"';";
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
    	//sa.setIdProducto(20);
    	sa.setDescripcion("superbigmac8");
    	sa.setDescripcionAmpliada("Un gran sandwich, pero no tanto como los de mi abuela");
    	
    	sa.setPrecio(20.50f);
    	sa.setTipoSandwich(gts.leePorId(2));
    	sa.setFechaBaja(new java.sql.Date(2007,11,23));
    	//gs.guarda(sa);
    	
    	
    	//Collection cn=gs.lista();
		//Iterator it=cn.iterator();
		//while (it.hasNext()){
		//	System.out.println(it.next());
		//}
    	
    	gs.guarda(sa);
    	
    }

}
