
import java.io.Serializable;
import java.util.Date;

public class TipoPromocion implements Serializable{
	private int id;
	private String descripcion = "";
	private Date fechaBaja = null;
	private static final long serialVersionUID = 1L;
	public TipoPromocion() {		
	}
	
	public TipoPromocion(int pId, String pDescripcion) {
		id = pId;
		descripcion = pDescripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString()
	{
		return (getId()+ " " +getDescripcion());
	}	
	
	
}
