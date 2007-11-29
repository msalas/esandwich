import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;
//import java.lang.Integer;

public class GestorStock {
	private GestorDisco gd;
	Connection con = null;
	
	public GestorStock () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Vector<Producto> listaStock() throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT producto.existencias from producto");
			while(rs.next()){
				p= new Producto(rs.getInt(1));
				v.add(p);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	public Vector<Producto> listaStockPorFamilia(int idFamilia) throws errorSQL, errorConexionBD{
		
		Vector<Producto> v = new Vector<Producto>();
		Producto p = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String s = "SELECT producto.existencias FROM producto WHERE producto.id_familia="+idFamilia;
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				p = new Producto(rs.getInt(1));
				v.add(p);
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}
	
	// aquesta no acaba de funcionar, s'ha de revisar
	
	public void insertarStock(int idProducto, int unidades) throws errorSQL, errorConexionBD {
		
		
		PreparedStatement pstmt = null;

		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			String p="UPDATE producto(existencias)  WHERE producto.id="+idProducto + "VALUES (?)";			
			pstmt = con.prepareStatement(p);
			pstmt.setInt(1, unidades);
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;	
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public void eliminaStock(int idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		String pr;
		PreparedStatement pstmt;
		
		try {
			gd.begin();
			pr= "DELETE FROM producto WHERE producto.id = "+ idProducto;
			pstmt = con.prepareStatement(pr);
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public Producto consultaStock(int idProducto) throws errorSQL, errorConexionBD {
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement st = null;
		ResultSet rs=null;
		String consulta="SELECT existencias FROM producto WHERE producto.id=" + idProducto;
		Producto p = new Producto();
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			while (rs.next()){
			p.setExistencias(rs.getInt("existencias"));}
			rs.close();
			st.close();
			return p;
			}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	}
	
	// Si son necesarias, ya las desarrollaremos
	
	public void restaStock(int idp, int uni)throws errorSQL, errorConexionBD{	}
	
	public void sumaStock(int idp, int uni)throws errorSQL, errorConexionBD{   }
	
	public void liberarRecursos(){
		gd.cerrarConexion();
	}
	
	public static void main(String[] arg) throws errorSQL,errorConexionBD{
		GestorStock gs=new GestorStock();
		
		Producto p1=gs.consultaStock(2);
		System.out.println(p1.toString2());
		
		gs.eliminaStock(2);
		
		for (Enumeration<Producto> p = (gs.listaStock()).elements() ; p.hasMoreElements() ;) {
			Producto pd = p.nextElement();
			System.out.println(pd.toString2());
		}
		
		for (Enumeration<Producto> p = (gs.listaStockPorFamilia(1)).elements() ; p.hasMoreElements() ;) {
			Producto pd = p.nextElement();
			System.out.println(pd.toString2());
		}
		
		Producto p2=gs.consultaStock(2);
		System.out.println(p2.toString2());
		
		//no acaba de funcionar, s'ha de revisar
		//gs.insertarStock(2, 100);
		
		Producto p=gs.consultaStock(2);
		System.out.println(p.toString2());
		
	}
	
}
	

