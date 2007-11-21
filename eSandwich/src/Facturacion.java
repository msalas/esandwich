import java.io.Serializable;
import java.util.Date;

public class Facturacion implements Serializable {

	int unidades;
	int id;
	int idPedido;
	int idLinea;
	Date fecha;
	int importe;
	
	public Facturacion(int id, int idPedido, Date fecha, int importe){
		super();
		this.id=id;
		this.idPedido=idPedido;
		this.fecha=fecha;
		this.importe=importe;
	}
	
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
		
}
