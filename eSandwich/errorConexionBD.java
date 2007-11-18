

public class errorConexionBD extends Exception {
	
	public errorConexionBD() {
		super("Problemas con la connexión a la BD");
	}
	
	public errorConexionBD(String pText) {
		super(pText);
	}
}