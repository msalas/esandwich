

public class errorConexionBD extends Exception {
	
	public errorConexionBD() {
		super("Problemas con la connexi�n a la BD");
	}
	
	public errorConexionBD(String pText) {
		super(pText);
	}
}