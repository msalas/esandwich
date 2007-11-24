import java.io.Serializable;

public class Producto implements Serializable {

	int idProducto;
	String descripcion;
	String descripcionAmpliada;
	int existencias;
	int idFamilia;
	int precio;
	
	public Producto(int idProducto, String descripcion, String descripcionAmpliada, int existencias, int idFamilia, int precio){
		super();
		this.idProducto=idProducto;
		this.descripcion=descripcion;
		this.descripcionAmpliada=descripcionAmpliada;
		this.existencias=existencias;
		this.idFamilia=idFamilia;
		this.precio=precio;
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


	public int getIdFamilia() {
		return idFamilia;
	}


	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}
		
}
