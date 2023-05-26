package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;

public class AgregarVenta extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);
    Color gris = new Color(237, 238, 239);
    // Componentes id Empleado
    JLabel txtIdEmpleado = new JLabel("Id Empleado");
    JTextField idEmpleado = new JTextField();
    // Variables necesarias
    private String[] columnNames = { "IdDisco", "Cantidad", "Subtotal" };
    // Componente Fecha
    JLabel txtFecha = new JLabel("Fecha");
    String fechaA = "";

    // Componente IdVenta
    JLabel txtIdVenta = new JLabel("IdVenta: ");
    String idActual = "";

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Cantidad
    JLabel txtCantidad = new JLabel("Cantidad");
    JTextField cantidad = new JTextField();

    // Componente Tabla
    JTable table;
    TablaEspecialMod mtb;

    // Boton Agregar
    JPanel agregar = new JPanel(null);
    JLabel txtAgregar = new JLabel("Agregar");
    JLabel imgAgregar = new JLabel();
    ImageIcon discoAgregar = new ImageIcon("./src/imagenes/discoAgregar.png");

    // Boton Finaliar
    JPanel finalizar = new JPanel(null);
    JLabel txtFinalizar = new JLabel("Finalizar");
    JLabel imgFinalizar = new JLabel();
    ImageIcon carroFinalizar = new ImageIcon("./src/imagenes/finalizar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");
    LocalDate fechaActual = LocalDate.now();

    public AgregarVenta() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Empleado
        txtIdEmpleado.setBounds(25, 60, 120, 20);
        txtIdEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idEmpleado.setBounds(135, 57, 270, 25);
        idEmpleado.setForeground(Color.GRAY);
        idEmpleado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Fecha
        txtFecha.setBounds(750, 52, 200, 20);
        txtFecha.setFont(new Font("Roboto Black", Font.BOLD, 18));
        fechaA = String.format("%02d", fechaActual.getDayOfMonth()) + "/"
                + String.format("%02d", fechaActual.getMonthValue()) + "/" + fechaActual.getYear();
        txtFecha.setText("Fecha: " + fechaA);

        // Campo IdVenta
        txtIdVenta.setBounds(500, 52, 200, 20);
        txtIdVenta.setFont(new Font("Roboto Black", Font.BOLD, 18));
        formatoId();
        txtIdVenta.setText("IdVenta: " + idActual);
        add(txtIdVenta);

        // Campo Id Disco
        txtIdDisco.setBounds(40, 200, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(135, 197, 270, 25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        idDisco.setEditable(false);

        // Campo Cantidad
        txtCantidad.setBounds(40, 340, 120, 20);
        txtCantidad.setFont(new Font("Roboto Black", Font.BOLD, 16));
        cantidad.setBounds(135, 337, 270, 25);
        cantidad.setForeground(Color.GRAY);
        cantidad.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        cantidad.setEditable(false);

        // Campo Tabla
        mtb = new TablaEspecialMod(columnNames);
        table = new JTable(mtb);
        JScrollPane contenedorTabla = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Roboto Black", Font.PLAIN, 12));
        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer();
        renderizador.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, renderizador);
        contenedorTabla.setBounds(450, 100, 500, 400);
        table.setBackground(gris);
        add(contenedorTabla);

        // Campo boton Agregar
        agregar.setBackground(cremaHov);
        agregar.setBounds(30, 420, 160, 60);
        agregar.addMouseListener(this);
        agregar.setCursor(new Cursor(12));
        imgAgregar.setBounds(10, 5, 50, 50);
        imgAgregar.setIcon(discoAgregar);
        txtAgregar.setForeground(Color.BLACK);
        txtAgregar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtAgregar.setBounds(70, 5, 120, 50);

        // Campo boton Finalizar
        finalizar.setBackground(cremaHov);
        finalizar.setBounds(245, 420, 160, 60);
        finalizar.addMouseListener(this);
        finalizar.setCursor(new Cursor(12));
        imgFinalizar.setBounds(10, 5, 50, 50);
        imgFinalizar.setIcon(carroFinalizar);
        txtFinalizar.setForeground(Color.BLACK);
        txtFinalizar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtFinalizar.setBounds(70, 5, 120, 50);

        // Campo boton Cancelar
        cancelar.setBackground(cremaHov);
        cancelar.setBounds(140, 510, 160, 60);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(12));
        imgCancelar.setBounds(10, 5, 50, 50);
        imgCancelar.setIcon(equisCancelar);
        txtCancelar.setForeground(Color.BLACK);
        txtCancelar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtCancelar.setBounds(70, 5, 120, 50);

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL
        //////////////////////////////////// //////////////////////////////////////////////

        // Añadiendo el campo id Empleado
        add(idEmpleado);
        add(txtIdEmpleado);

        // Añadiendo el campo Fecha
        add(txtFecha);

        // Añadiendo el campo id Disco
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo cantidad
        add(cantidad);
        add(txtCantidad);

        // Añadiendo la tabla

        // Añadiendo el boton Agregar (disquito)
        agregar.add(imgAgregar);
        agregar.add(txtAgregar);
        add(agregar);

        // Añadiendo el boton Finalizar
        finalizar.add(imgFinalizar);
        finalizar.add(txtFinalizar);
        add(finalizar);

        // Añadiendo el boton Cancelar
        cancelar.add(imgCancelar);
        cancelar.add(txtCancelar);
        add(cancelar);

        setBounds(0, 0, 960, 600);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == finalizar) {
            Connection connection = null; // se almacena la conexion
            String bdname = "GestorVentasDiscos";// nombre de la base de datos
            String user = "admin";// usuario de la base de datos
            String pass = "123456";// contraseña de usuario

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
                String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                        + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                        + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
                String AgregarQuery = "INSERT INTO Compras (idVenta, idEmp, FechaV, Total) VALUES (?, ?, ?, ?)";
                connection = DriverManager.getConnection(connectionBD);
                PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
                // Establecer los valores de los parámetros en la sentencia de inserción
                // preparedStatement.setString(1, .getText()); aqui va el id de la venta
                // preparedStatement.setString(2, idEmpleado.getText()); aqui ira el id del
                // empleado
                preparedStatement.setString(3, fechaA);
                // preparedStatement.setFloat(2, Total.getText()); aqui ira el campo que calcula
                // el total
                // Ejecutar la sentencia de inserción
                int rowsAffected = preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Se agregó el registro de la venta correctamente",
                        "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
            } catch (ClassNotFoundException s) {
                System.out.println("Error: " + s.getMessage());
            } catch (SQLException s) {
                System.out.println("Error: " + s.getMessage());
            } catch (Exception s) {
                System.out.println("Error: " + s.getMessage());
            } finally {
                try {
                    // Cerrar la conexión
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException s) {
                    System.out.println("Error al cerrar la conexión: " + s.getMessage());
                }
            }
        }else if(e.getSource() == agregar){
            if(idEmpleado.isEditable()){
                if(checarEmpleado()){
                    idEmpleado.setEditable(false);
                    idDisco.setEditable(true);
                    cantidad.setEditable(true);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void formatoId(){
        int id = idAutomaticas();
        idActual = String.format("V-%04d",id);
    }

    public int idAutomaticas() {
        Connection connection = null; // se almacena la conexion
        String bdname = "GestorVentasDiscos";// nombre de la base de datos
        String user = "admin";// usuario de la base de datos
        String pass = "123456";// contraseña de usuario
        int ans = -1;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                    + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                    + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
            Statement statement = null;
            ResultSet resultSet = null;
            connection = DriverManager.getConnection(connectionBD);
            // Crear el objeto Statement
            statement = connection.createStatement();
            // Ejecutar la consulta
            resultSet = statement.executeQuery("select count(*) as res from Ventas");
            resultSet.next();
            ans = resultSet.getInt(1) + 1;

        } catch (ClassNotFoundException s) {
            System.out.println("Error: " + s.getMessage());
        } catch (SQLException s) {
            System.out.println("Error: " + s.getMessage());
        } catch (Exception s) {
            System.out.println("Error: " + s.getMessage());
        } finally {
            try {
                // Cerrar la conexión
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException s) {
                System.out.println("Error al cerrar la conexión: " + s.getMessage());
            }
        }
        return ans;
    }

    public boolean checarEmpleado(){
        Connection connection = null; // se almacena la conexion
        String bdname = "GestorVentasDiscos";// nombre de la base de datos
        String user = "admin";// usuario de la base de datos
        String pass = "123456";// contraseña de usuario
        boolean ans = false;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                    + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                    + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
            Statement statement = null;
            ResultSet resultSet = null;
            connection = DriverManager.getConnection(connectionBD);
            // Crear el objeto Statement
            statement = connection.createStatement();
            // Ejecutar la consulta
            resultSet = statement.executeQuery("select * from Empleados where idEmp = '" + idEmpleado.getText() +"'");
            if(resultSet.next()){
                ans = true;
            }else{
                JOptionPane.showMessageDialog(this, "El idEmpleado no existe en la base de datos, verifique los datos","IdEmp no encontrado",JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException s) {
            System.out.println("Error: " + s.getMessage());
        } catch (SQLException s) {
            System.out.println("Error: " + s.getMessage());
        } catch (Exception s) {
            System.out.println("Error: " + s.getMessage());
        } finally {
            try {
                // Cerrar la conexión
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException s) {
                System.out.println("Error al cerrar la conexión: " + s.getMessage());
            }
        }
        return ans;
    }
}

