import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GestorTipoPromocion {

	GestorDisco gd;
	Connection con = null;
	
	public GestorTipoPromocion() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

	public void addTipoPromocion(TipoPromocion pTipProm) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";

		// Falta verificar campos: verifCampos(pRol);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO tipopromocion (descripcion) "
				+ "VALUES (?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pTipProm.getDescripcion());
	
			gd.commit();
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			
		} catch (SQLException e) {
				gd.rollback();
				throw new errorSQL("Error SQL numero: " + e.getErrorCode());
		}
	}
	
	public TipoPromocion consultaTipoPromocion(int pId) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		TipoPromocion pTipProm = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT descripcion "
				+ "FROM tipopromocion "
				+ "WHERE id = " + pId;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()){
				pTipProm = montaTipoPromocion(rs);
			}
			else {
				throw new GestorTipoPromocionException("No existe tipo promoción");
			}
			rs.close();
			stmt.close();
			
			return pTipProm;
		} 
		catch (SQLException e) {
			throw new GestorTipoPromocionException("Error SQL numero: " + e.getErrorCode());			
		}
	}
	
	private TipoPromocion montaTipoPromocion(ResultSet rs) throws errorSQL {
		TipoPromocion pTipProm = null;
		pTipProm = new TipoPromocion();
		try {
			pTipProm.setDescripcion(rs.getString("descripcion"));
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return pTipProm;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

}
