package src;

public class errorSQL extends Exception {
	
	public errorSQL() {
		super("Problemas SQL");
	}
	
	public errorSQL(String pText) {
		super(pText);
	}
}