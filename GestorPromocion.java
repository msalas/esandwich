import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



public class GestorPromocion {

	GestorDisco gd;
	Connection con = null;
	
	public GestorPromocion() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

	public void addPromocion(Promocion pPro) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";

		// Falta verificar campos: verifCampos(pRol);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO promocion (id-tipopromocion,id-sandwich,"
				+ "id-producto,valor,puntosminimos) "
				+ "VALUES (?,?,?,?,?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1, pPro.getIdTipoPromocion());
			pstmt.setInt(2, pPro.getIdSandwich());
			pstmt.setInt(3, pPro.getIdProducto());
			pstmt.setDouble(4, pPro.getValor());
			pstmt.setInt(5, pPro.getPuntosMinimos());
	
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL numero: " + e.getErrorCode());
		}
	}
	
	//Tanto para dar de baja como para modificar promocion
	public void setPromocion(Promocion pProm) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		
		// Falta verificar campos: verifCampos(pEmpleado);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "UPDATE promocion SET id-tipopromocion=?,id-sandwich=?,"
				+ "id-producto=?,valor=?,puntosminimos=?,fechabaja=? "
				+ "WHERE id = " + pProm.getId();			

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1, pProm.getIdTipoPromocion());
			pstmt.setInt(2, pProm.getIdSandwich());
			pstmt.setInt(3, pProm.getIdProducto());
			if (pProm.getFechaBaja() != null) {
				pstmt.setDate(10,(Date) pProm.getFechaBaja());
			}
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL numero: " + e.getErrorCode());
		}
	}

	public Vector lista(int pId, int pIdSandwich, int pPuntos) throws errorSQL, errorConexionBD {
		Vector v = new Vector();
		String strSQL = "";
		String strConsulta  = "";
		
		if (pIdSandwich > 0) {
			pPuntos = pPuntos + 1;
			strConsulta = " WHERE id-sandwich = " + pIdSandwich + " AND puntosminimos < " + pPuntos + " ";
		}

		if (pId > 0) {
			strConsulta = " WHERE id = " + pId + " ";
		}
		
		
		strSQL = "SELECT id,id-tipopromocion,id-sandwich,id-producto,valor,"
				+ "puntosminimos,fechabaja"
				+ "FROM promocion "
				+ strConsulta;
		
		Promocion pPro = null;
			
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(strSQL);
			
			while(rs.next()){
				pPro = montaPromocion(rs);
				v.add(pPro);
			}				
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	
	
	private Promocion montaPromocion(ResultSet rs) throws errorSQL {
		Promocion pPro = null;
		pPro = new Promocion();
		try {
			pPro.setIdTipoPromocion(rs.getInt("id-tipopromocion"));
			pPro.setIdSandwich(rs.getInt("id-sandwich"));
			pPro.setIdProducto(rs.getInt("id-producto"));
			pPro.setValor(rs.getDouble("valor"));
			pPro.setPuntosMinimos(rs.getInt("puntosminimos"));
			pPro.setFechaBaja(rs.getDate("fechabaja"));
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return pPro;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

}
