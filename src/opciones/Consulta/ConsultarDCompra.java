package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.*;

public class ConsultarDCompra extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botones[] = new JRadioButton[4];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"IdCompra","IdDisco","Cantidad", "Subtotal"};
    //Tabla 
    JTable table;
    public ConsultarDCompra(){
        super();
        tablaN = "DetallesCompras";
        //Botones de radio y su configuracion
        botones[0] = new JRadioButton("IdCompra");
        botones[0].addActionListener(e->{
            if(!(entrada.getText().equals(hover))){
                entrada.setText("'C-0001'");
            }
            hover = "'C-0001'";
            atri = "idCompra";
        });
        botones[1] = new JRadioButton("IdDisco");
        botones[1].addActionListener(e->{
            if(!(entrada.getText().equals(hover))){
                entrada.setText("'D-0001'");
            }
            hover = "'D-0001'";
            atri = "idDisco";
        });
        botones[2] = new JRadioButton("Cantidad");
        botones[2].addActionListener(e->{
            if(!(entrada.getText().equals(hover))){
                entrada.setText("'12'");
            }
            hover = "'12'";
            atri = "Cant";
        });
        botones[3] = new JRadioButton("Subtotal");
        botones[3].addActionListener(e->{
            if(!(entrada.getText().equals(hover))){
                entrada.setText("'1223'");
            }
            hover = "'1223'";
            atri = "SubTotal";
        });
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
        contenedorTabla.setSize(550, 500);
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
                String idCompra = resultSet.getString("idCompra");
                String idDisco = resultSet.getString("idDisco");
                int cant = resultSet.getInt("Cant");
                float Total = resultSet.getFloat("Subtotal");
                Object[] dato = {idCompra,idDisco,cant,Total};
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
