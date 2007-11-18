
public class itemNoEncontrado extends Exception {

	String msg="";
	
	public itemNoEncontrado(String mis){
		this.msg= mis;
	}
	
	public itemNoEncontrado() {

	}

	public String getMessage(){
		return msg;
	}
}
