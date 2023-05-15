package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class ConsultarEmpleados extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botoneso[] = new JRadioButton[8];
    Color gris = new Color(237, 238, 239);
    //Tabla 
    JTable table;
    public ConsultarEmpleados(){
        super();
        tabla.setBounds(25, 20, 910, 400);
        opciones.setBounds(40, 420, 500, 190);
        entrada.setBounds(620, 450, 250, 30);
        botones.setBounds(660, 510, 180, 60);
        //Botones de radio y su configuracion
        botoneso[0] = new JRadioButton("IdEmpl");
        botoneso[1] = new JRadioButton("Ap.Paterno");
        botoneso[2] = new JRadioButton("Ap.Materno");
        botoneso[3] = new JRadioButton("Nombre");
        botoneso[4] = new JRadioButton("Puesto");
        botoneso[5] = new JRadioButton("Turno");
        botoneso[6] = new JRadioButton("Tel. Cel");
        botoneso[7] = new JRadioButton("Tel. Fijo");
        opciones.setLayout(new GridLayout(0, 3, 0, 0));
        for (int i = 0; i < botoneso.length; i++) {
            botoneso[i].setText("Buscar por " + botoneso[i].getText());
            botoneso[i].setBackground(Color.white);
            botoneso[i].setFont(new Font("Roboto Black", Font.BOLD, 14));
            grupo.add(botoneso[i]);
            opciones.add(botoneso[i]);
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
        contenedorTabla.setSize(910, 400);
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
        private String[] columnNames = {"IdEmp","Ap.Paterno","Ap.Materno","Nombre","Puesto","Turno","Tel. Cel","Tel. Fijo"};
        private Object[][] data = {
            {"E1","Ponce","Estrada","Alejandro","Cajero","M","3411700344",""},
            {"E1","Ponce","Estrada","Alejandro","Cajero","M","3411700344",""},
            {"E1","Ponce","Estrada","Alejandro","Cajero","M","3411700344",""},
            {"E1","Ponce","Estrada","Alejandro","Cajero","M","3411700344",""}
            
        };
    
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
