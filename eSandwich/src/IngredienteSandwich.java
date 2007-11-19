import java.io.Serializable;


public class IngredienteSandwich implements Serializable {
	
	private int idSandwich;
	private int idIngrediente;
	
	
	public int getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public int getIdSandwich() {
		return idSandwich;
	}
	public void setIdSandwich(int idSandwich) {
		this.idSandwich = idSandwich;
	}
	
	

}
