package opciones.Consulta;
import java.util.*;
import javax.swing.table.AbstractTableModel;
public class MyTableModel extends AbstractTableModel {
    private ArrayList<Object[]> data; // Lista de datos para las filas
    private String[] columnNames; // Nombres de las columnas

    public MyTableModel(String[] columnNames) {
        this.columnNames = columnNames;
        data = new ArrayList<>();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public void limpiarDatos() {
        data.clear();
        fireTableDataChanged(); // Notificar a la tabla que se han limpiado los datos
    }
    
    public void actualizarDatos(ArrayList<Object[]> newData) {
        data = newData;
        fireTableDataChanged(); // Notificar a la tabla que se han actualizado los datos
    }

    public void setData(ArrayList<Object[]> data){
        this.data = data;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data.get(row)[col] = value;
        fireTableCellUpdated(row, col);
    }
}
