import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TMCompras extends AbstractTableModel implements TableModel {

  public static String[] nombres = { "Producto", "unidades", "Precio" };

  private Vector         vCompras;

  public TMCompras(Vector lista) {
    vCompras = lista;
  }

  public String geColumnName(int col) {
    if (col <= nombres.length) {
      return nombres[col].toString();

    } else {
      return null;

    }
  }

  public int getRowCount() {
    return vCompras.size();
  }

  public int getColumnCount() {
    return nombres.length;
  }

  public Object getValueAt(int arg0, int arg1) {
    Vector vFila ;
    if (vCompras!=null && arg0 <= vCompras.size()) {
      vFila = (Vector) vCompras.get(arg0);
    } else {
      return null;
    }

    if (vFila != null && arg1 <= vFila.size()) {
      return vFila.get(arg1);

    } else {
      return null;

    }
  }

}
