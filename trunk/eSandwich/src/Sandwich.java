import java.io.Serializable;
import java.util.Date;


public class Sandwich extends Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TipoSandwich tipoSandwich;
	private String []ingredienteSandwich;
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
	public String[] getIngredienteSandwich() {
		return ingredienteSandwich;
	}
	public void setIngredienteSandwich(String[] ingredienteSandwich) {
		this.ingredienteSandwich = ingredienteSandwich;
	}
	public TipoSandwich getTipoSandwich() {
		return tipoSandwich;
	}
	public void setTipoSandwich(TipoSandwich tipoSandwich) {
		this.tipoSandwich = tipoSandwich;
	}
	
	public String toString(){
		String cadena="";
		cadena="Identificador:"+this.getIdProducto()+" Nombre:"+this.getDescripcion()+" TipoSandwich:"+this.getTipoSandwich().getDescripcion();
		return cadena;
	}
	
	
	

}
