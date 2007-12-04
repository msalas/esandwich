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

import javax.swing.JFrame;
import javax.swing.JOptionPane;





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
		
		
		
		
		sql="SELECT * FROM tipo_sandwich WHERE id="+id+";";
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
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		int id=0;
		
		
		Date dt=tipoSandwich.getFechaBaja();
		sql="INSERT INTO tipo_sandwich (descripcion,fecha_baja) VALUES (?,?) RETURNING id;";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, tipoSandwich.getDescripcion());
			if (dt!=null){
				ps.setDate(2,new java.sql.Date(dt.getTime()));
			}else{
				ps.setDate(2,null);
			}
			
			rs=ps.executeQuery();
			
			
		
			
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			
		
			
			
				
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
	}
	
	public void elimina(String nombreTipoSandwich) throws errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql1="";
		String sql2="";
		String sql3="";
		
		int id=0;
		
		
		
		
		sql1="SELECT id FROM tipo_sandwich WHERE descripcion='"+nombreTipoSandwich+"';";
		sql2="DELETE FROM sandwich WHERE id_tipo_sandwich="+id+";";
		sql3="DELETE FROM tipo_sandwich WHERE descripcion='"+nombreTipoSandwich+"';";
		
		try {
			st=con.createStatement();
			//rs=st.executeQuery(sql1);
			//while (rs.next()){
			//	id=rs.getInt(1);
			//}
			
			//System.out.println("id:"+id);
			//st=con.createStatement();
			//st.execute(sql2);
			//rs.close();
			//st.close();
			
			//st=con.createStatement();
			st.executeUpdate(sql3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public Collection lista() throws errorConexionBD{
		System.out.println("GestorTipoSandwich");
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		
		Collection<TipoSandwich> cl=new Vector<TipoSandwich>();
		sql="SELECT * FROM tipo_sandwich";
		
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
		sql="SELECT * FROM tipo_sandwich WHERE descripcion='"+nombre+"';";
		
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
	
	public int devuelveId(String descripcion) throws errorConexionBD{
		int id=0;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		Statement st=null;
		ResultSet rs=null;
		String sql="";
		
		
		sql="SELECT id FROM tipo_sandwich WHERE descripcion='"+descripcion+"';";
		
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			while (rs.next()){
				
				id=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return id;
		
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] arg) throws errorConexionBD, ParseException{
		
		GestorTipoSandwich gts=new GestorTipoSandwich();
		//TipoSandwich ts=new TipoSandwich();
		
		//ts.setDescripcion("vamos a ver ahora");
		//ts.setFechaBaja(new java.sql.Date(2007,11,10));
		
		//Collection cn=gts.lista();
		//Iterator it=cn.iterator();
		//while (it.hasNext()){
		//	System.out.println(it.next());
		//}
		
		gts.elimina("hola");
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
