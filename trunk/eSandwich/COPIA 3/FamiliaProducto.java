import java.io.Serializable;

public class FamiliaProducto implements Serializable{

	int idFamilia;
	String descripcion;
	
	public FamiliaProducto(int idFamilia, String descripcion){
		this.idFamilia=idFamilia;
		this.descripcion=descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public long getIdFamilia() {
		return idFamilia;
	}
	
	public void setIdFamilia(int idFamilia) {
		this.idFamilia = idFamilia;
	}
		
}
