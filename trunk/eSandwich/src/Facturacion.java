import java.io.Serializable;

public class Facturacion implements Serializable {

	int unidades;
	int idLinea;
	int importe;
	
	public int getIdLinea() {
		return idLinea;
	}
	
	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}
	
	public int getImporte() {
		return importe;
	}
	
	public void setImporte(int importe) {
		this.importe = importe;
	}
	
	public int getUnidades() {
		return unidades;
	}
	
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
		
}
