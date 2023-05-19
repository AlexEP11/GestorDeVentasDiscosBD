package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class ConsultarDiscos extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botoneso[] = new JRadioButton[8];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"IdDisco","Genero","Formato","Artista","NAlbum","DiaL","MesL","AñoL","Existencia","Costo"};
    //Tabla 
    JTable table;
    public ConsultarDiscos(){
        super();
        tabla.setBounds(25, 20, 910, 400);
        opciones.setBounds(40, 420, 500, 190);
        entrada.setBounds(620, 450, 250, 30);
        botones.setBounds(660, 510, 180, 60);
        //Botones de radio y su configuracion
        botoneso[0] = new JRadioButton("IdDisco");
        botoneso[1] = new JRadioButton("Genero");
        botoneso[2] = new JRadioButton("Formato");
        botoneso[3] = new JRadioButton("Artista");
        botoneso[4] = new JRadioButton("NAlbum");
        botoneso[5] = new JRadioButton("AñoL");
        botoneso[6] = new JRadioButton("Existencia");
        botoneso[7] = new JRadioButton("Costo");
        opciones.setLayout(new GridLayout(0, 3, 0, 0));
        for (int i = 0; i < botoneso.length; i++) {
            botoneso[i].setText("Buscar por " + botoneso[i].getText());
            botoneso[i].setBackground(Color.white);
            botoneso[i].setFont(new Font("Roboto Black", Font.BOLD, 14));
            grupo.add(botoneso[i]);
            opciones.add(botoneso[i]);
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
}
