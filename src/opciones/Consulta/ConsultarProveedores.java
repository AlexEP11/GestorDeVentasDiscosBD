package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class ConsultarProveedores extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botones[] = new JRadioButton[6];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"IdProv","Nombre","Calle", "NExterior","Tel. Cel","Tel. Fijo"};
    //Tabla 
    JTable table;
    public ConsultarProveedores(){
        super();
        //Botones de radio y su configuracion
        botones[0] = new JRadioButton("IdProv");
        botones[1] = new JRadioButton("Nombre");
        botones[2] = new JRadioButton("Calle");
        botones[3] = new JRadioButton("NExterior");
        botones[4] = new JRadioButton("Tel. Cel");
        botones[5] = new JRadioButton("Tel. Fijo");
        opciones.setLayout(new GridLayout(6, 0, 0, 0));
        for (int i = 0; i < botones.length; i++) {
            botones[i].setText("Buscar por " + botones[i].getText());
            botones[i].setBackground(Color.white);
            botones[i].setFont(new Font("Roboto Black", Font.BOLD, 18));
            grupo.add(botones[i]);
            opciones.add(botones[i]);
        }

        //Tabla
        mtb = new MyTableModel(columnNames);
        table = new JTable(mtb);
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
}
