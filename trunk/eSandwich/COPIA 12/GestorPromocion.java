import java.sql.Connection;
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

	public int addPromocion(Promocion pPro) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		int id = 0;

		verifCampos(pPro);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "INSERT INTO promocion (id_tipo_promocion,id_sandwich,"
				+ "id_producto,valor,puntos_minimos) "
				+ "VALUES (?,?,?,?,?)";
					
			pstmt = con.prepareStatement(strSQL);
			
			
			pstmt.setInt(1, pPro.getIdTipoPromocion());
			pstmt.setInt(2, pPro.getIdSandwich());
			pstmt.setInt(3, pPro.getIdProducto());
			pstmt.setDouble(4, pPro.getValor());
			pstmt.setInt(5, pPro.getPuntosMinimos());
	
			pstmt.execute();
			pstmt.close();

			strSQL = "select currval('promocion_id_seq')";

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
	
	//Tanto para dar de baja como para modificar promocion
	public void setPromocion(Promocion pProm) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		
		verifCampos(pProm);
				
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");
		
		
		PreparedStatement pstmt = null;
					
		try {
			gd.begin();
			
			strSQL = "UPDATE promocion SET id_tipo_promocion=?,id_sandwich=?,"
				+ "id_producto=?,valor=?,puntos_minimos=?,fecha_baja=? "
				+ "WHERE id = " + pProm.getId();			

			pstmt = con.prepareStatement(strSQL);
			
			pstmt.setInt(1, pProm.getIdTipoPromocion());
			pstmt.setInt(2, pProm.getIdSandwich());
			pstmt.setInt(3, pProm.getIdProducto());
			pstmt.setDouble(4, pProm.getValor());
			pstmt.setInt(5, pProm.getPuntosMinimos());
			if (pProm.getFechaBaja() != null) {
				pstmt.setDate(6,new java.sql.Date(pProm.getFechaBaja().getTime()));
			} else {
				pstmt.setDate(6,null);
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

	public Promocion consultaPromocion(int pId) throws errorSQL, 
	errorConexionBD{
		String strSQL = "";
		Promocion pProm = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexión!");

		Statement stmt = null;
					
		try {
			gd.begin();
			
			strSQL = "SELECT id,id_tipo_promocion,id_sandwich,"
				+ "id_producto,valor,puntos_minimos,fecha_baja "
				+ "FROM promocion "
				+ "WHERE id = " + pId;			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(strSQL);			
			if (rs.next()){				
				pProm = montaPromocion(rs);				
			}
			else {
				throw new GestorPromocionException("No existe promoción");
			}
			rs.close();
			stmt.close();
			gd.commit();			
		} 
		catch (SQLException e) {
			throw new GestorPromocionException("Error SQL numero: " + e.getErrorCode());			
		}
		return pProm;
	}
	
	
	//Excluimos a los que estan dados de baja
	public Vector lista(int pId, int pIdSandwich, int pPuntos) throws errorSQL, errorConexionBD {
		Vector v = new Vector();
		String strSQL = "";
		String strConsulta  = "";
		
		if (pIdSandwich > 0) {
			pPuntos = pPuntos + 1;
			strConsulta = " AND id_sandwich = " + pIdSandwich
			+ " AND puntos_minimos < " + pPuntos ;
		}

		if (pId > 0) {
			strConsulta = " AND id = " + pId + " ";
		}
		
		
		strSQL = "SELECT id,id_tipo_promocion,id_sandwich,id_producto,valor,"
				+ "puntos_minimos,fecha_baja "
				+ "FROM promocion "
				+ "WHERE fecha_baja IS NULL"
				+ strConsulta;
		
		Promocion pPro = null;
			
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");
		Statement stmt = null;
		ResultSet rs = null;
			
		try {
			gd.begin();
			stmt = con.createStatement();
			rs = stmt.executeQuery(strSQL);
			
			while(rs.next()){
				pPro = montaPromocion(rs);
				v.add(pPro);
			}				
			rs.close();
			stmt.close();
			gd.commit();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
		return v;
	}
	
	private void verifCampos(Promocion Pro) throws GestorPromocionException {
		String str = Double.toString(Pro.getValor());
		if (!Util.IsNumeric(str)) 
			throw new GestorPromocionException("Valor a de ser un dato numérico");
		str = Integer.toString(Pro.getPuntosMinimos());
		if (!Util.IsNumeric(str))
			throw new GestorPromocionException("Puntos mínimos a de ser un dato numérico");
	}
	
	
	private Promocion montaPromocion(ResultSet rs) throws errorSQL {
		Promocion pPro = null;
		pPro = new Promocion();
		try {
			pPro.setId(rs.getInt("id"));
			pPro.setIdTipoPromocion(rs.getInt("id_tipo_promocion"));
			pPro.setIdSandwich(rs.getInt("id_sandwich"));
			pPro.setIdProducto(rs.getInt("id_producto"));
			pPro.setValor(rs.getDouble("valor"));
			pPro.setPuntosMinimos(rs.getInt("puntos_minimos"));
			pPro.setFechaBaja(rs.getDate("fecha_baja"));
		}
		catch (SQLException e) {
			throw new errorSQL(e.toString());
		}		
		return pPro;		
	}
	
	public void liberarRecursos(){	
		gd.cerrarConexion();	
	}

	/*public static void main (String[] args) {
		Promocion Prom = new Promocion();
		GestorPromocion gProm = null;
		Vector v;
		int x;
		int idAux = 0;

		try {
			gProm = new GestorPromocion();
			try {
				Prom.setIdTipoPromocion(1);
				Prom.setIdSandwich(1);
				Prom.setIdProducto(1);
				Prom.setValor(100);
				Prom.setPuntosMinimos(40);
				idAux = gProm.addPromocion(Prom);
				Prom.setId(idAux);				
				Prom = gProm.consultaPromocion(Prom.getId());				
				//System.out.println(Prom.toString());
				
				Prom.setValor(150);
				gProm.setPromocion(Prom);
				Prom = gProm.consultaPromocion(Prom.getId());
				//System.out.println(Prom.toString());
				
				
				Prom.setPuntosMinimos(35);
				gProm.setPromocion(Prom);
				v = gProm.lista(0,1,35);				
				for (x=0;x<v.size();x++)
					System.out.println((v.elementAt(x)).toString());

				Prom.setFechaBaja(new java.util.Date());				
				gProm.setPromocion(Prom);
				v = gProm.lista(0,0,0);
				for (x=0;x<v.size();x++)
					System.out.println((v.elementAt(x)).toString()); 
				
				
				gProm.liberarRecursos();
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
