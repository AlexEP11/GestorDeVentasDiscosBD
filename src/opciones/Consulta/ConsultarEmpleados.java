package opciones.Consulta;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.*;

public class ConsultarEmpleados extends Plantilla {
    //Configuraciones de la tabla
    JRadioButton botoneso[] = new JRadioButton[8];
    Color gris = new Color(237, 238, 239);
    String[] columnNames = {"IdEmp","Ap.Paterno","Ap.Materno","Nombre","Puesto","Turno","Tel. Cel","Tel. Fijo"};
    //Tabla 
    JTable table;
    public ConsultarEmpleados(){
        super();
        tabla.setBounds(25, 20, 910, 400);
        opciones.setBounds(40, 420, 500, 190);
        entrada.setBounds(620, 450, 250, 30);
        botones.setBounds(660, 510, 180, 60);
        tablaN = "Empleados";
        //Botones de radio y su configuracion
        botoneso[0] = new JRadioButton("IdEmpl");
        botoneso[0].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'E-0001'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'E-0001'";
            atri = "idEmp";
        });
        botoneso[1] = new JRadioButton("Ap.Paterno");
        botoneso[1].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Ponce'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Ponce'";
            atri = "AP";
        });
        botoneso[2] = new JRadioButton("Ap.Materno");
        botoneso[2].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Villa'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Villa'";
            atri = "AM";
        });
        botoneso[3] = new JRadioButton("Nombre");
        botoneso[3].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Carlos'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Carlos'";
            atri = "NOM";
        });
        botoneso[4] = new JRadioButton("Puesto");
        botoneso[4].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'Supervisor'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'Supervisor'";
            atri = "NPuesto";
        });
        botoneso[5] = new JRadioButton("Turno");
        botoneso[5].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'M'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'M'";
            atri = "Turno";
        });
        botoneso[6] = new JRadioButton("Tel. Cel");
        botoneso[6].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'3411800344'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'3411800344'";
            atri = "TelEC";
        });
        botoneso[7] = new JRadioButton("Tel. Fijo");
        botoneso[7].addActionListener(e->{
            if((entrada.getText().equals(hover))){
                entrada.setText("'3411800349'");
                entrada.setForeground(Color.lightGray);
            }
            hover = "'3411800349'";
            atri = "TelEF";
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
                String idEmp = resultSet.getString("idEmp");
                String AP = resultSet.getString("AP");
                String AM = resultSet.getString("AM");
                String nom = resultSet.getString("NOM");
                String npuesto = resultSet.getString("NPuesto");
                String turno = resultSet.getString("Turno");
                String telEC = resultSet.getString("telEC");
                String telEF = resultSet.getString("telEF");
                Object[] dato = {idEmp,AP,AM,nom,npuesto,turno,telEC,telEF};
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
