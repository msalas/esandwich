
public class GestorUsuarioException extends errorSQL {
	private static final long serialVersionUID = 1L;	
	public GestorUsuarioException(String pText) {
		super(pText);
	}
	public GestorUsuarioException() {
		super("Contraseña incorrecta");
	}
	
	
}
