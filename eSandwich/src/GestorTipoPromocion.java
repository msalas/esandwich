import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



public class GestorTipoPromocion {

	GestorDisco gd;
	Connection con = null;
	
	public GestorTipoPromocion() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

	public int addTipoPromocion(TipoPromocion pTipProm) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		int id = 0;

		verifCampos(pTipProm);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO tipo_promocion (descripcion) "
				+ "VALUES (?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1,pTipProm.getDescripcion());
	
			pstmt.execute();
			pstmt.close();
						
			strSQL = "select currval('tipo_promocion_id_seq')";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);
			if (rs.next()) id = rs.getInt(1);
			rs.close();
			stmt.close();
			gd.commit();
			
		} catch (SQLException e) {
				gd.rollback();
				throw new errorSQL("Error SQL numero: " + e.getErrorCode());
		}
		return id;
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
			
			strSQL = "SELECT id,descripcion "
				+ "FROM tipo_promocion "
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
			gd.commit();			
		} 
		catch (SQLException e) {
			throw new GestorTipoPromocionException("Error SQL numero: " + e.getErrorCode());			
		}
		return pTipProm;
	}

	//Tanto para dar de baja como para modificar tipo de promocion
	public void setTipoPromocion(TipoPromocion pTipoProm) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		
		verifCampos(pTipoProm);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "UPDATE tipo_promocion SET descripcion=?,fecha_baja=? "
				+ "WHERE id = " + pTipoProm.getId();			

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setString(1, pTipoProm.getDescripcion());
			if (pTipoProm.getFechaBaja() != null) {
				pstmt.setDate(2,new java.sql.Date(pTipoProm.getFechaBaja().getTime()));
			} else {
				pstmt.setDate(2,null);
			}
			
			pstmt.execute();
			pstmt.close();
			pstmt = null;
			gd.commit();
		} catch (SQLException e) {
			gd.rollback();
			throw new errorSQL("Error SQL numero: " + e.getErrorCode());
		}
	}
	
	//Excluimos a los que estan dados de baja
	public Vector lista() throws errorSQL, errorConexionBD {
		Vector v = new Vector();
		String strSQL = "";
		
		strSQL = "SELECT id,descripcion,fecha_baja "
				+ "FROM tipo_promocion "
				+ "WHERE fecha_baja IS NULL";
		
		TipoPromocion pTipoPro = null;
			
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			gd.begin();
			stmt = con.createStatement();
			rs = stmt.executeQuery(strSQL);
			
			while(rs.next()){
				pTipoPro = montaTipoPromocion(rs);
				v.add(pTipoPro);
			}				
			rs.close();
			stmt.close();
			gd.commit();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}

	private void verifCampos(TipoPromocion tPro) throws GestorTipoPromocionException {
		if (!Util.compruebaCampoTamano(tPro.getDescripcion().toCharArray(), 100)) 
			throw new GestorTipoPromocionException("Error tamaño campo descripción");
	}
	
	
	private TipoPromocion montaTipoPromocion(ResultSet rs) throws errorSQL {
		TipoPromocion pTipProm = new TipoPromocion();
		try {
			pTipProm.setId(rs.getInt("id"));			
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

/*	public static void main (String[] args) {
		TipoPromocion tProm = new TipoPromocion();
		GestorTipoPromocion gTipProm = null;
		int idAux = 0;

		try {
			gTipProm = new GestorTipoPromocion();
			try {
				tProm.setDescripcion("Promoción Disney");
				idAux = gTipProm.addTipoPromocion(tProm);
				tProm.setId(idAux);				
				tProm = gTipProm.consultaTipoPromocion(tProm.getId());				
				System.out.println(tProm.toString());
				
				tProm.setDescripcion("Promoción Disney 2");
				idAux = gTipProm.addTipoPromocion(tProm);
				tProm.setId(idAux);				
				tProm = gTipProm.consultaTipoPromocion(tProm.getId());
				System.out.println(tProm.toString());
				
				tProm.setDescripcion("Promoción Disney dos");
				gTipProm.setTipoPromocion(tProm);
				tProm = gTipProm.consultaTipoPromocion(tProm.getId());
				System.out.println(tProm.toString());

				Vector v = gTipProm.lista();
				int x;
				for (x=0;x<v.size();x++)
					System.out.println((v.elementAt(x)).toString());
				
				
				tProm.setFechaBaja(new java.util.Date());				
				gTipProm.setTipoPromocion(tProm);
				v = gTipProm.lista();
				for (x=0;x<v.size();x++)
					System.out.println((v.elementAt(x)).toString());

				
				gTipProm.liberarRecursos();
			}
			catch (errorSQL e) {
				System.out.println(e.getMessage());
			}
		}
		catch (errorConexionBD e) {
			System.out.println(e.getMessage());
		}
		
	} */  
	
	
}
