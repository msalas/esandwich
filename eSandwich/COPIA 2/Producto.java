
public class Producto {

	long idProducto;
	String descripcion;
	String descripcionAmpliada;
	int existencias;
	
	public Producto(long idProducto, String descripcion, String descripcionAmpliada, int existencias){
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
	
	public long getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public int getExistencias() {
		return existencias;
	}

	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}
		
}
