import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;


public class ServiciosAdminAuxImpl extends UnicastRemoteObject 
implements ServiciosRemotosAdminAux {
	private static final long serialVersionUID = 1L;

	GestorEmpleado ge;
	GestorRol gr;
	
	public ServiciosAdminAuxImpl() throws errorConexionBD,
	RemoteException {
		try {
			ge = new GestorEmpleado();
			gr = new GestorRol();
		}
		catch (errorConexionBD e) {
			throw new errorConexionBD(e.getMessage());
		}
		
	}
	
	public Empleado anadirEmpleado (Empleado emp) throws errorSQL, errorConexionBD,
	RemoteException {
		Empleado auxEmp = null;
		try {
			if (!ge.existeNif(emp.getNif())) {
				auxEmp = ge.addEmpleado(emp);
			}
			else {
				throw new errorSQL("ERROR: Nif existente en empleados");
			}
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		return auxEmp;
	}
	
	public void desactivarRecursos() {
		ge.liberarRecursos();
	}
	
	public Vector listaDescripcionesRol() throws errorSQL, errorConexionBD,
	RemoteException {
		Vector v = new Vector();
		Vector vRet = new Vector();
		try {
			v = gr.lista();
		}
		catch (errorSQL err) {
			throw new errorSQL(err.getMessage());
		}
		for (int i=0;i<v.size();i++){
			Rol rolT=(Rol)vRet.get(i);
			String desc = rolT.getDescripcion();
			vRet.add(desc);			
		}
		return vRet;
	}
	
}
