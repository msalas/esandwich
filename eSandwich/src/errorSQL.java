
public class errorSQL extends Exception {

	String msg="";
	
	public errorSQL(String mis){
		this.msg= mis;
	}
	
	public String getMessage(){
		return msg;
	}

}
