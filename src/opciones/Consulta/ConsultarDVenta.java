package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class ConsultarDVenta extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botones[] = new JRadioButton[4];
    Color gris = new Color(237, 238, 239);
    //Tabla 
    JTable table;
    public ConsultarDVenta(){
        super();
        //Botones de radio y su configuracion
        botones[0] = new JRadioButton("IdVenta");
        botones[1] = new JRadioButton("IdDisco");
        botones[2] = new JRadioButton("Cantidad");
        botones[3] = new JRadioButton("Subtotal");
        opciones.setLayout(new GridLayout(4, 0, 0, 0));
        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("Buscar por " + botones[i].getText());
            botones[i].setBackground(Color.white);
            botones[i].setFont(new Font("Roboto Black", Font.BOLD, 18));
            grupo.add(botones[i]);
            opciones.add(botones[i]);
        }

        //Tabla
        
        table = new JTable(new MyTableModel());
        JScrollPane contenedorTabla = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Roboto Black", Font.PLAIN, 12));
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();
        renderizador.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, renderizador);
        contenedorTabla.setSize(550, 500);
        table.setBackground(gris);
        tabla.add(contenedorTabla);
        
        //Botones de limpiar y buscar
        limpiar.addActionListener(e->{
            actionPerformed(e);
        });
        buscar.addActionListener(e->{
            actionPerformed(e);
        });
    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"IdVenta","IdDisco","Cantidad", "Subtotal"};
        private Object[][] data = {{"V1","D1",2,200.0f},{"V1","D2",2,300.0f},{"V2","D3",3,400.0f},{"V2","D1",1,100f}};
    
        public int getColumnCount() {
            return columnNames.length;
        }
    
        public int getRowCount() {
            return data.length;
        }
    
        public String getColumnName(int col) {
            return columnNames[col];
        }
    
        public Object getValueAt(int row, int col) {
            return data[row][col];
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
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}
