import java.io.Serializable;

public class Producto implements Serializable {

	int idProducto;
	String descripcion;
	String descripcionAmpliada;
	int existencias;
	int idFamilia;
	float precio;
	
	public Producto(int idProducto, String descripcion, String descripcionAmpliada, int existencias, int idFamilia, float precio){
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

	public Producto(int existencias) {
		this.existencias=existencias;
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


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String toString(){
		return "id: " + idProducto + "\ndescripcion: "+descripcion + "\ndescripcion ampliada: "+ descripcionAmpliada + "\nexistencias: "+ existencias+ "\nid familia: "+ idFamilia + "\nprecio: "+precio; 
	}
	
	public String toString2(){
		return "existencias: "+ existencias; 
	}
	
}
