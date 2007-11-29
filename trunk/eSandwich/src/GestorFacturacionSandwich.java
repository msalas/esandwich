import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.Date;

public class GestorFacturacionSandwich {

	private GestorDisco gd;
	Connection con = null;
	
	public GestorFacturacionSandwich () throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	//AQUESTA NO TINC MOLT CLAR COM FUNCIONA
	
	public void insertarFacturacionSandwich (int idProducto) throws errorSQL, errorConexionBD{
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		
		
	}
	
	public void eliminaFacturacionSandwich(int idProducto) throws errorSQL, errorConexionBD {

		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
	
		String pr;
		PreparedStatement pstmt = null;
		
		try {
			gd.begin();
			
			pr= "DELETE FROM factura WHERE producto.id=factura.id and producto.id = '"+ idProducto+"'";
			pstmt = con.prepareStatement(pr);
			gd.commit();
			pstmt.execute();
			pstmt.close();
		
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL(e.toString());
		}
	}
	
	//No tinc gaire clar que sigui això el que ha de fer el metode
	
	public Producto consultaFacturacionSandwich(int idProducto) throws errorSQL, errorConexionBD {
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement st = null;
		ResultSet rs=null;
		String consulta="SELECT from producto(precio) WHERE producto.id=" + idProducto+ "'";
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
				p.setPrecio(rs.getInt("precio"));
			}
			rs.close();
			st.close();
			return p;
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	}
	
	// FALTA LLISTAR PER DATES; no se com es fa
	
	public Vector<Facturacion> listaFacturasSandwich(int id, Date fechaDesde, Date fechaHasta) throws errorSQL, errorConexionBD{
		
		Vector<Facturacion> v = new Vector<Facturacion>();
		return v;
	
	}
	
	public void liberarRecursos(){
		gd.cerrarConexion();	
	}
	
}
