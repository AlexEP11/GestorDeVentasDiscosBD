package opciones.Consulta;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;


public class ConsultarPuestos extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botones[] = new JRadioButton[2];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"NPuesto","Salario"};
    
    //Tabla 
    JTable table;
    public ConsultarPuestos(){
        super();
        tabla.setBounds(420, 50, 500, 500);
        opciones.setBounds(80, 50, 280, 250);
        //Botones de radio y su configuracion
        botones[0] = new JRadioButton("Nombre Puesto");
        botones[1] = new JRadioButton("Salario");
        opciones.setLayout(new GridLayout(4, 0, 0, 0));
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
        contenedorTabla.setSize(500, 500);
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
