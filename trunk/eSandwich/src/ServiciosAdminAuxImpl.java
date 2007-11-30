import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServiciosAdminAuxImpl extends UnicastRemoteObject 
implements ServiciosRemotosAdminAux {
	private static final long serialVersionUID = 1L;

	GestorEmpleado ge;
	
	public ServiciosAdminAuxImpl() throws errorConexionBD,
	RemoteException {
		try {
			ge = new GestorEmpleado();
		}
		catch (errorConexionBD e) {
			throw new errorConexionBD(e.getMessage());
		}
		
	}
	
	public Empleado anadirEmpleado (Empleado emp) throws errorSQL, errorConexionBD,
	RemoteException {
		Empleado auxEmp = null;
		try {
			auxEmp = ge.addEmpleado(emp);
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
	
}
