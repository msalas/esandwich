
public class errorConexionBD extends Exception {

String msg="";
	
	public errorConexionBD(String mis){
		this.msg= mis;
	}
	
	public String getMessage(){
		return msg;
	}
	
}
