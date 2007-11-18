
import java.io.Serializable;

public class Empleado extends Usuario implements Serializable  {
	private Rol rol;

	public Empleado(long pId,int pDni, String pNombre, String pApellido1, String pApellido2,
			String pDireccion, String pPoblacion, String pTelefono, String pMovil,
			String pEmail, String pCodUsuario, String pPassword,
			boolean pDesactivado, Rol pRol) {
		super(pId, pDni, pNombre, pApellido1, pApellido2, pDireccion, pPoblacion,				
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