import java.io.Serializable;

public class Producto implements Serializable {

	int idProducto;
	String descripcion;
	String descripcionAmpliada;
	int existencias;
	
	public Producto(int idProducto, String descripcion, String descripcionAmpliada, int existencias){
		super();
		this.idProducto=idProducto;
		this.descripcion=descripcion;
		this.descripcionAmpliada=descripcionAmpliada;
		this.existencias=existencias;
	}
	

	public Producto() {
		
	}


	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcionAmpliada() {
		return descripcionAmpliada;
	}
	
	public void setDescripcionAmpliada(String descripcionAmpliada) {
		this.descripcionAmpliada = descripcionAmpliada;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
		
}
