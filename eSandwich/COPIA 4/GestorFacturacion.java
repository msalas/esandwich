import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class GestorFacturacion {
	
	private GestorDisco gd;
	Connection con = null;
	
	public GestorFacturacion () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public Facturacion consultaFactura(int idFactura) throws errorSQL, errorConexionBD {
		
		
		Facturacion f = null;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			String consulta="SELECT from factura(id, id_pedido, fecha, importe) WHERE f.id=" + idFactura+ "'";
			ResultSet rs = stmt.executeQuery(consulta);
			if(rs.next()) id= rs.getInt(1); 
			rs.close();
			stmt.close();
			f = new Facturacion(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
			
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return f;
	}
	
	public void eliminaFactura(int idFactura) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Facturacion f=null;
		String pr;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			pr= "DELETE FROM factura WHERE f.id = '"+ idFactura+"'";
			
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	public void insertarFactura(int id, int idPedido, Date fecha, int importe) throws errorSQL, errorConexionBD {
		
		String p;
		PreparedStatement pstmt = null;
		
		int i = 0;
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		try {
			gd.begin();
			p=	"INSERT INTO factura (id, id_pedido, fecha, importe)" + "VALUES (?,?,?,?) RETURNING id" ;			
			pstmt = con.prepareStatement(p);
			pstmt.setInt(1,id);
			pstmt.setInt(2,idPedido);
			pstmt.setTimestamp(3,new java.sql.Timestamp ( fecha.getTime()));
			pstmt.setInt(4, importe);
			gd.commit();
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) i = rs.getInt(1);
			rs.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}

	}
	
	
	// FALTA LLISTAR PER DATES
	

	public void liberarRecursos(){
		
		gd.cerrarConexion();
		
	}
}
