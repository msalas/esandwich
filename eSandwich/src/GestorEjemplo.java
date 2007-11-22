
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


public class GestorEjemplo {

	GestorDisco gd;
	Connection con = null;
	
public GestorEjemplo() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}

public Vector<Ejemplo> listaEjemplos() throws errorSQL, errorConexionBD{

	Vector<Ejemplo> v = new Vector<Ejemplo>();
		
		Ejemplo ej = null;
		
		if(gd.isConectado()) con = gd.getConexion();
		else throw new errorConexionBD("No hay conexion!");

		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from ejemplo");
			
			while(rs.next()){
				ej = new Ejemplo(rs.getString(1));
				v.add(ej);
			}
				
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new errorSQL(e.toString());
		}
	
		return v;
	}


// Suponer que en la BD tenemos una tabla ejemplo(id, nombre, numero)
// Suponer que tambien hay una tabla sequencia ejemplo_seq(id)
public String insertarEjemplo(Ejemplo ej) throws errorSQL, errorConexionBD {

	String res;
	
	if(gd.isConectado()) con = gd.getConexion();
	else throw new errorConexionBD("No hay conexion!");

	Statement stmt = null;
	ResultSet rs = null;
	int id = 0;
	
	try {
		
		gd.begin();
		
		// Insercion, modificacion o borrado
		stmt = con.createStatement();
		rs = stmt.executeQuery("insert into ejemplo values("+ej.getEjemplo()+","+ej.getNumero()+") returning id;");
		if (rs.next()) id = rs.getInt(1);
		rs.close();
		stmt.close();
		
		gd.commit();
		
		res = Util.generarCodigo(id);
		
	} catch (SQLException e) {
		gd.rollback();
		throw new errorSQL(e.toString());
	}

	return res; 
}

public void liberarRecursos(){
	
	gd.cerrarConexion();
	
}

}
