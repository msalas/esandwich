import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
  private int    id;
  private int    idCliente;
  private int    idPromocion;
  private int    idProducto;
  private float  importe;
  private int    unidades;
  private Date   fecha;
  private String estado;

  public Pedido(int pId, int pIdCliente, int pIdPromocion, int pIdProducto,
      float pImporte, int pUnidades, Date pFecha, String pEstado) {

    id = pId;
    idCliente = pIdCliente;
    idPromocion = pIdPromocion;
    idProducto = pIdProducto;
    importe = pImporte;
    unidades = pUnidades;
    fecha = pFecha;
    estado = pEstado;
  }

  // ************************************
  // Getters y Setters de la clase
  // ************************************
  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public int getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
  }

  public int getIdPromocion() {
    return idPromocion;
  }

  public void setIdPromocion(int idPromocion) {
    this.idPromocion = idPromocion;
  }

  public float getImporte() {
    return importe;
  }

  public void setImporte(float importe) {
    this.importe = importe;
  }

  public int getUnidades() {
    return unidades;
  }

  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

}
