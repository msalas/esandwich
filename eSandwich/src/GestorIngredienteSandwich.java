import java.sql.Connection;
import java.util.Collection;


public class GestorIngredienteSandwich {
	
	GestorDisco gd;
	Connection con = null;
	
	public GestorIngredienteSandwich() throws errorConexionBD {
		super();
		gd = new GestorDisco();
		gd.abrirConexion();
	}
	
	public IngredienteSandwich lee(int idSandwich, int idIngrediente){
		return null;
		
	}
	public void guarda(IngredienteSandwich ingredienteSandwich){
		
	}
	public void elimina (IngredienteSandwich ingredienteSandwich){
		
	}
	public Collection listaPorSandwich(){
		return null;
		
	}

}
