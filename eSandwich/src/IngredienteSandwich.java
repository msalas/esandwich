import java.io.Serializable;


public class IngredienteSandwich implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idSandwich;
	private int idIngrediente;
	private String nombreIngrediente;
	
	
	
	
	
	public String getNombreIngrediente() {
		return nombreIngrediente;
	}
	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}
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
