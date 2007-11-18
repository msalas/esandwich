
import java.io.Serializable;
import java.util.Date;

public class Promocion implements Serializable{
	private long id;
	private int idTipoPromocion;
	private int idSandwich;
	private String valor;
	private int puntosMinimos;
	private Producto producto;
	private Date fechaBaja = null;
	
	public Promocion (long pId, int pIdTipoPromocion, int pIdSandwich, String pValor,
			int pPuntosMinimos) {
		id = pId;
		idTipoPromocion = pIdTipoPromocion;
		idSandwich = pIdSandwich;
		valor = pValor;
		puntosMinimos = pPuntosMinimos;		
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIdSandwich() {
		return idSandwich;
	}

	public void setIdSandwich(int idSandwich) {
		this.idSandwich = idSandwich;
	}

	public int getIdTipoPromocion() {
		return idTipoPromocion;
	}

	public void setIdTipoPromocion(int idTipoPromocion) {
		this.idTipoPromocion = idTipoPromocion;
	}

	public int getPuntosMinimos() {
		return puntosMinimos;
	}

	public void setPuntosMinimos(int puntosMinimos) {
		this.puntosMinimos = puntosMinimos;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
