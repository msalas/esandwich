import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.ParseException;
//import java.util.Collection;
import java.util.Enumeration;
//import java.util.Iterator;
import java.util.Vector;


public class GestorProducto {
	
	private GestorDisco gd;
	Connection con = null;
	
	public GestorProducto () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Vector<Producto> listaProductos() throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from producto");
			while(rs.next()){
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getFloat(6));
				v.add(p);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public Vector<Producto> listaProductoPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String s = "SELECT * FROM producto WHERE producto.id_familia="+idFamilia;
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getFloat(6));
				v.add(p);
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}
	
	public int insertarProducto(Producto p) throws  errorSQL, errorConexionBD {
	
		int id=0;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			String s = "INSERT INTO producto (id, descripcion, descripcion_ampliada, existencias, id_familia, precio )"
				+ "VALUES (?,?,?,?,?,?)";	
			
			
			pstmt = con.prepareStatement(s);
			pstmt.setInt(1,p.getIdProducto());
			pstmt.setString(2,p.getDescripcion());
			pstmt.setString(3,p.getDescripcionAmpliada());
			pstmt.setInt(4, p.getExistencias());
			pstmt.setInt(5,p.getIdFamilia());
			pstmt.setFloat(6,p.getPrecio());
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
			String str = "select currval('id')";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();
					
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
		return id;
	}
	
	public int eliminaProducto(int idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		int id=idProducto;
		String pr;
		PreparedStatement pstmt;
		
		try {
			gd.begin();
			pr= "DELETE FROM producto WHERE producto.id = '"+ idProducto+"'";
			pstmt = con.prepareStatement(pr);
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
		return id;
	}
	
	public Producto consultaProducto(int idProducto) throws errorSQL, errorConexionBD {
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement st = null;
		ResultSet rs=null;
		String consulta="SELECT id, descripcion, descripcion_ampliada, existencias, id_familia, precio FROM producto WHERE producto.id=" + idProducto;
		Producto p = new Producto();
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while (rs.next()){
				p.setIdProducto(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				p.setDescripcionAmpliada(rs.getString("descripcion_ampliada"));
				p.setExistencias(rs.getInt("existencias"));
				p.setIdFamilia(rs.getInt("id_familia"));
				p.setPrecio(rs.getFloat("precio"));
			}
			rs.close();
			st.close();
			return p;
		} 
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
	}
	
	public boolean existeProducto(int id) throws errorSQL, errorConexionBD{
		String strSQL = "";
		boolean existeProducto;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT id "
				+ "FROM producto "
				+ "WHERE id ='" + id + "' ";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				existeProducto = true;
			}
			else {
				existeProducto = false;
			}
			rs.close();
			stmt.close();
			gd.commit();
			return existeProducto;
		} 
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	}
  
  
	
	
	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}

	public static void main(String[] arg) throws errorSQL,errorConexionBD{
		
		GestorProducto gp=new GestorProducto();
		FamiliaProducto fp1 = new FamiliaProducto(0, "embutidos");
		FamiliaProducto fp2 = new FamiliaProducto(1, "pan");
		
		GestorFamiliaProd gpf= new GestorFamiliaProd();
		gpf.insertarFamiliaProducto(fp1);
		gpf.insertarFamiliaProducto(fp2);
		
		Producto pr1=new Producto(0,"longaniza", "extra", 100, 0, 15);
		Producto pr2=new Producto(1,"panecillo", "blanco", 10, 1, 8);
		Producto pr3=new Producto(2,"jamon", "curado del pais", 1000, 0, 10);
		Producto pr4=new Producto(3,"coca", "de cereales", 1, 1, 23);
		Producto pr5=new Producto(4,"queso", "cabra", 15, 0, 17);
			
		gp.insertarProducto(pr1);
		gp.insertarProducto(pr2);
		gp.insertarProducto(pr3);
		gp.insertarProducto(pr4);
		gp.insertarProducto(pr5);
		
		
		for (Enumeration<Producto> p = (gp.listaProductos()).elements() ; p.hasMoreElements() ;) {
			Producto pd = p.nextElement();
			System.out.println(pd.toString());
		}
		
		
		Producto p=gp.consultaProducto(0);
		System.out.println(p.toString());
			
		gp.eliminaProducto(0);
		
		
		for (Enumeration<Producto> p1 = (gp.listaProductoPorFamilia(0)).elements() ; p1.hasMoreElements() ;) {
		Producto pd = p1.nextElement();
		System.out.println(pd.toString());
		}
		
	}
}
