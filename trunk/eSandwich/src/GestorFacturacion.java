import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.Vector;
import java.util.Vector;


public class GestorFacturacion {
	
	private GestorDisco gd;
	Connection con = null;
	
	public GestorFacturacion () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Facturacion consultaFactura(int idFactura) throws errorSQL, errorConexionBD {
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement st = null;
		ResultSet rs=null;
		String consulta="SELECT id, id_pedido, fecha, importe FROM factura WHERE factura.id=" + idFactura;
		Facturacion f = new Facturacion();
		try {
			st=con.createStatement();
			rs=st.executeQuery(consulta);
			
			while (rs.next()){
				f.setId(rs.getInt("id"));
				f.setIdPedido(rs.getInt("id_pedido"));
				f.setFecha(rs.getDate("fecha"));
				f.setImporte(rs.getInt("importe"));
			}
			rs.close();
			st.close();
			return f;
		} 
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
	}
	
	public void eliminaFactura(int idFactura) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		String pr;
		PreparedStatement pstmt;
		
		try {
			gd.begin();
			pr= "DELETE FROM factura WHERE factura.id = '"+ idFactura+"'";
			pstmt = con.prepareStatement(pr);
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
	}
	
	public int insertarFactura(Facturacion f) throws errorSQL, errorConexionBD {
		
		int id=0;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			String p=	"INSERT INTO factura (id, id_pedido, fecha, importe)" + "VALUES (?,?,?,?)" ;			
			pstmt = con.prepareStatement(p);
			pstmt.setInt(1,f.getId());
			pstmt.setInt(2,f.getIdPedido());
			pstmt.setTimestamp(3,new java.sql.Timestamp (f.getFecha().getTime()));
			pstmt.setInt(4, f.getImporte());
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
	
	
	// FALTA LLISTAR PER DATES; no se com es fa
	
	public Vector<Facturacion> listaFacturas() throws errorSQL, errorConexionBD{
		
		Vector<Facturacion> v = new Vector<Facturacion>();
		return v;
	
	}
	
	public boolean existeFactura(int id) throws errorSQL, errorConexionBD{
		String strSQL = "";
		boolean existeFactura;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT id "
				+ "FROM factura "
				+ "WHERE id ='" + id + "' ";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				existeFactura = true;
			}
			else {
				existeFactura = false;
			}
			rs.close();
			stmt.close();
			gd.commit();
			return existeFactura;
		} 
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	}	
	
	public void liberarRecursos(){
		
		gd.cerrarConexion();	
	}
	
	public static void main(String[] arg) throws errorSQL,errorConexionBD{
		
		//no se com entrar les dates, quin format tenen
		//Facturacion f = new Facturacion(0, 0,date(Gener,01,2008), 15);
		
		GestorFacturacion gf= new GestorFacturacion();
		//gf.insertarFactura(f);
		System.out.println(gf.consultaFactura(0));
	}
	
}
