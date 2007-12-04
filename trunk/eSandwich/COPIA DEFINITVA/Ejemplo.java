import java.io.Serializable;


public class Ejemplo implements Serializable{

	String ejemplo;
	int numero;
	public Ejemplo(String ejemplo, int numero) {
		super();
		this.ejemplo = ejemplo;
		this.numero = numero;
	}
	public Ejemplo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ejemplo(String string) {
		// TODO Auto-generated constructor stub
	}
	public String getEjemplo() {
		return ejemplo;
	}
	public void setEjemplo(String ejemplo) {
		this.ejemplo = ejemplo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
