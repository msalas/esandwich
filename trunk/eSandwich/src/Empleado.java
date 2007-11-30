
import java.io.Serializable;

public class Empleado extends Usuario implements Serializable  {
	private static final long serialVersionUID = 1L;	
	private Rol rol = null;

	public Empleado() {
		super();
	}
	
	public Empleado(int pId,String pNif, String pNombre, String pApellido1, String pApellido2,
			String pDireccion, String pPoblacion, String pTelefono, String pMovil,
			String pEmail, String pCodUsuario, String pPassword,
			boolean pDesactivado, Rol pRol) {
		super(pId, pNif, pNombre, pApellido1, pApellido2, pDireccion, pPoblacion,				
			pTelefono, pMovil, pEmail, pCodUsuario, pPassword, pDesactivado);	
		rol = pRol;		
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}