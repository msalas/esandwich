
import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable {
	private long id;
	private NIF nif;	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String poblacion;
	private String telefono;
	private String movil;
	private String email;
	private Date fechaBaja;
	
	public Persona(long pId,int pDni, String pNombre, String pApellido1, String pApellido2,
			String pDireccion, String pPoblacion, String pTelefono, String pMovil,
			String pEmail)
	{
		id = pId;
		nif = new NIF(pDni);
		nombre = pNombre;
		apellido1 = pApellido1;
		apellido2 = pApellido2;
		direccion = pDireccion;
		poblacion = pPoblacion;
		telefono = pTelefono;
		movil = pMovil;
		email = pEmail;
		fechaBaja = null;
	}


	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public NIF getNif() {
		return nif;
	}

	public void setNif(NIF nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean equals(Object obj)
	{
		Persona auxPersona;
        NIF auxNif;
        auxPersona = (Persona) obj;
        auxNif = auxPersona.getNif();
        return (auxNif.equals(getNif()));
	}	
}
