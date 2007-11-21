
import java.io.Serializable;
import java.util.Date;

public class Rol implements Serializable{
	private int id;
	private String descripcion = "";
	private String letraRol = "";
	
	public Rol(int pId, String pDescripcion,String pLetraRol) {
		id = pId;
		descripcion = pDescripcion;
		letraRol = pLetraRol; 
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLetraRol() {
		return letraRol;
	}

	public void setLetraRol(String letraRol) {
		this.letraRol = letraRol;
	}
}
