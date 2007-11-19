import java.io.Serializable;
import java.util.Date;


public class Sandwich extends Producto implements Serializable {
	
	private float precio;
	private TipoSandwich tipoSandwich;
	private IngredienteSandwich []ingredienteSandwich;
	private Date fechaBaja;
	
	
	
	public Sandwich() {
		super();
		
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public IngredienteSandwich[] getIngredienteSandwich() {
		return ingredienteSandwich;
	}
	public void setIngredienteSandwich(IngredienteSandwich[] ingredienteSandwich) {
		this.ingredienteSandwich = ingredienteSandwich;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public TipoSandwich getTipoSandwich() {
		return tipoSandwich;
	}
	public void setTipoSandwich(TipoSandwich tipoSandwich) {
		this.tipoSandwich = tipoSandwich;
	}
	
	
	

}
