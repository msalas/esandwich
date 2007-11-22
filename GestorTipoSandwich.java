import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;





public class GestorTipoSandwich {
	
	GestorDisco gd;
	Connection con = null;
	
	public GestorTipoSandwich() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public TipoSandwich lee(int id,String nombre){
	    TipoSandwich tp=new TipoSandwich();
	    tp.setId(id);
	    tp.setDescripcion(nombre);
	    
		return tp;
		
	}

	public TipoSandwich leePorId(int id) throws errorConexionBD{
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		
		sql="SELECT * FROM tiposandwich WHERE id="+id+";";
		TipoSandwich ts=new TipoSandwich();
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				
				ts.setId(rs.getInt(1));
				ts.setDescripcion(rs.getString(2));
				ts.setFechaBaja(rs.getDate(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ts;
		
		
	}
	
	/* Se corresponde con Alta de nuevo Tipo de Sandwich del documento de diseño*/ 
	
	public void guarda(TipoSandwich tipoSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		PreparedStatement ps=null;
		String sql="";
		
		
		
		Date dt=tipoSandwich.getFechaBaja();
		sql="INSERT INTO tiposandwich VALUES (?,?,?);";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, tipoSandwich.getId());
			ps.setString(2, tipoSandwich.getDescripcion());
			ps.setDate(3,new java.sql.Date(dt.getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
	}
	
	public void elimina(TipoSandwich tipoSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		String sql="";
		
		
		
		
		sql="DELETE FROM tiposandwich WHERE id="+tipoSandwich.getId()+";";
		
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
		
		
		
		Collection<TipoSandwich> cl=new Vector<TipoSandwich>();
		sql="SELECT * FROM tiposandwich";
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				TipoSandwich ts=new TipoSandwich();
				ts.setId(rs.getInt(1));
				ts.setDescripcion(rs.getString(2));
				ts.setFechaBaja(rs.getDate(3));
				cl.add(ts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cl;
		
	}
	
	public Collection listaPorNombre(String nombre) throws errorConexionBD{
		
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		Collection<TipoSandwich> cl=new Vector<TipoSandwich>();
		sql="SELECT * FROM tiposandwich WHERE descripcion='"+nombre+"';";
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				TipoSandwich ts=new TipoSandwich();
				ts.setId(rs.getInt(1));
				ts.setDescripcion(rs.getString(2));
				ts.setFechaBaja(rs.getDate(3));
				cl.add(ts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cl;
		
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] arg) throws errorConexionBD, ParseException{
		
		GestorTipoSandwich gts=new GestorTipoSandwich();
		TipoSandwich ts=new TipoSandwich();
		ts.setId(70);
		ts.setDescripcion("prueba1");
		ts.setFechaBaja(new java.sql.Date(2007,11,21));
		
		Collection cn=gts.lista();
		Iterator it=cn.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		
		
		
		
		
		
		
	}
	
	
	

}
