
public class GestorUsuarioException extends errorSQL {
	
	public GestorUsuarioException(String pText) {
		super(pText);
	}
	public GestorUsuarioException() {
		super("Contraseña incorrecta");
	}
	
	
}
