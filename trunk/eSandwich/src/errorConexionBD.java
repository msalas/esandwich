
public class errorConexionBD extends Exception {
	private static final long serialVersionUID = 1L;	
	
	public errorConexionBD() {
		super("Problemas con la connexión a la BD");
	}
	
	public errorConexionBD(String pText) {
		super(pText);
	}
}