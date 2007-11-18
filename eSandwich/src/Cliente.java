package src;
import Usuario;

import java.io.Serializable;


public class Cliente extends Usuario implements Serializable  {
	private String tarjetaCredito;

	public Cliente(long pId,int pDni, String pNombre, String pApellido1, String pApellido2,
			String pDireccion, String pPoblacion, String pTelefono, String pMovil,
			String pEmail, String pCodUsuario, String pPassword,
			boolean pDesactivado, String pTarjetaCredito) {
		super(pId, pDni, pNombre, pApellido1, pApellido2, pDireccion, pPoblacion,				
			pTelefono, pMovil, pEmail, pCodUsuario, pPassword, pDesactivado);	
		tarjetaCredito = pTarjetaCredito;		
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

}