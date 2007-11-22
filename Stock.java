import java.io.Serializable;

public class Stock implements Serializable {

	int unidades;

	public Stock (int unidades){
		super();
		this.unidades=unidades;
	}
	
	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
}
