import java.io.Serializable;

public class FacturacionSandwich implements Serializable {

	int idSandwich;
	
	public FacturacionSandwich(int idSandwich){
		super();
		this.idSandwich=idSandwich;
	}

	public int getIdSandwich() {
		return idSandwich;
	}

	public void setIdSandwich(int idSandwich) {
		this.idSandwich = idSandwich;
	}
	
}
