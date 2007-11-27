
public class Util {

	private final static String letraCliente = "C";
	
	public static String generarCodigo(int id, String letraRol){
		
		String res = new Integer(id).toString();
		int n = res.length();
		if(n==3)res = letraRol+"0"+res;
		else if(n==2)res = letraRol+"00"+res;
		else if(n==1)res = letraRol+"000"+res;
		else res = letraRol+res;
		
		return res;
		
	}

	public static String generarCodigo(int id){
		
		
		String res = new Integer(id).toString();
		int n = res.length();
		if(n==3)res = letraCliente+"0"+res;
		else if(n==2)res = letraCliente+"00"+res;
		else if(n==1)res = letraCliente+"000"+res;
		else res = letraCliente+res;
		
		return res;
		
	}
	
	public static int getNumDeCodigo(String codUsuario) {
		int n = 0;
		n = Integer.parseInt(codUsuario.substring(1));		
		return n;
	}
	
	public static boolean compruebaCampo(char[] pCamp) {
		int x;
		boolean correcto = true;
		for (x=0;x<pCamp.length;x++) {
			// Si tiene numeros o letras es correcto
			if (Character.isDigit(pCamp[x]) || !Character.isLetter(pCamp[x])) {
				correcto = true;
			}
			else {
				correcto = false;
				break;
			}				
		}
		return correcto;
	}
	
	
}
