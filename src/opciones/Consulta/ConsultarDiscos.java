package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.*;

public class ConsultarDiscos extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botoneso[] = new JRadioButton[8];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"IdDisco","Genero","Formato","Artista","NAlbum","DiaL","MesL","AñoL","Existencia","Costo"};
    //Tabla 
    JTable table;
    public ConsultarDiscos(){
        super();
        tablaN = "Discos";
        tabla.setBounds(25, 20, 910, 400);
        opciones.setBounds(40, 420, 500, 190);
        entrada.setBounds(620, 450, 250, 30);
        botones.setBounds(660, 510, 180, 60);
        //Botones de radio y su configuracion
        botoneso[0] = new JRadioButton("IdDisco");
        botoneso[0].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'D-0001'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'D-0001'";
            atri = "idDisco";
        });
        botoneso[1] = new JRadioButton("Genero");
        botoneso[1].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Rock'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Rock'";
            atri = "Genero";
        });
        botoneso[2] = new JRadioButton("Formato");
        botoneso[2].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'V'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'V'";
            atri = "Formato";
        });
        botoneso[3] = new JRadioButton("Artista");
        botoneso[3].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Rufus Du Sol'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Rufus Du Sol'";
            atri = "Artista";
        });
        botoneso[4] = new JRadioButton("NAlbum");
        botoneso[4].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Surrender'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Surrender'";
            atri = "NAlbum";
        });
        botoneso[5] = new JRadioButton("AñoL");
        botoneso[5].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'2023'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'2023'";
            atri = "AñoL";
        });
        botoneso[6] = new JRadioButton("Existencia");
        botoneso[6].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'22'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'22'";
            atri = "Exist";
        });
        botoneso[7] = new JRadioButton("Costo");
        botoneso[7].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'200'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'200'";
            atri = "Costo";
        });
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
            actualizarTabla(sql);
        });
        buscar.addActionListener(e->{
            actionPerformed(e);
            actualizarTabla(sql);
        });
    }

    public void actualizarTabla(String sql) {
        mtb.limpiarDatos();
        mtb.actualizarDatos(this.realizarConsulta(sql));
    }

    public ArrayList<Object[]> realizarConsulta(String sql) {
        ArrayList<Object[]> data = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
            +bdname+";user="+user+";password="+pass+";"+ "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
            connection = DriverManager.getConnection(connectionBD);
            // Crear el objeto Statement
            statement = connection.createStatement();
            // Ejecutar la consulta
            resultSet = statement.executeQuery(sql);
            // Procesar los resultados
            while (resultSet.next()) {
                // Obtener los valores de cada columna
                String idDisco = resultSet.getString("idDisco");
                String genero = resultSet.getString("Genero");
                String formato = resultSet.getString("Formato");
                String Artista = resultSet.getString("Artista");
                String NAlbum = resultSet.getString("NAlbum");
                int diaL = resultSet.getInt("DiaL");
                int mesL = resultSet.getInt("MesL");
                int anoL = resultSet.getInt("AñoL");
                int exist = resultSet.getInt("Exist");
                float costo = resultSet.getFloat("Costo");
                Object[] dato = {idDisco,genero,formato,Artista,NAlbum,diaL,mesL,anoL,exist,costo};
                data.add(dato);
            }
        } catch(ClassNotFoundException s) {
            System.out.println("Error: " + s.getMessage());
        }catch (SQLException e) {
            System.out.println("Error al consultar datos: " + e.getMessage());
        } finally {
            try {
                // Cerrar el ResultSet
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
            }

            try {
                // Cerrar el Statement
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement: " + e.getMessage());
            }

            try {
                // Cerrar la conexión
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return data;
    }
}
