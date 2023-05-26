package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.*;
import java.time.LocalDate;

public class AgregarCompra extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);
    Color gris = new Color(237, 238, 239);
    // Componentes id Proveedor
    JLabel txtIdProveedor = new JLabel("Id Proveedor");
    JTextField idProveedor = new JTextField();

    // Componente Fecha
    JLabel txtFechaC = new JLabel("Fecha: ");
    String fechaA = "";
    LocalDate fechaActual = LocalDate.now();

    // Componente IdCompra
    JLabel txtIdCompra = new JLabel("IdCompra: ");
    String idCompraActual = "D--001";
    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco: ");
    JTextField idDisco = new JTextField();
    // Componente id Disco
    JLabel txtCosto = new JLabel("Costo: ");
    JTextField costo = new JTextField();

    // Componente Cantidad
    JLabel txtCantidad = new JLabel("Cantidad");
    JTextField cantidad = new JTextField();

    // Componente Tabla
    JTable table;
    TablaEspecialMod mtb;
    String[] columnNames = { "IdDisco", "Cantidad", "Subtotal" };

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

    // ArrayList
    ArrayList<Object[]> compras = new ArrayList<>();

    public AgregarCompra() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Empleado
        txtIdProveedor.setBounds(25, 60, 120, 20);
        txtIdProveedor.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idProveedor.setBounds(135, 57, 270, 25);
        idProveedor.setForeground(Color.GRAY);
        idProveedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Fecha
        txtFechaC.setBounds(750, 52, 200, 20);
        txtFechaC.setFont(new Font("Roboto Black", Font.BOLD, 18));
        actualizarFecha();

        // Campo IdCompra
        txtIdCompra.setBounds(500, 52, 200, 20);
        txtIdCompra.setFont(new Font("Roboto Black", Font.BOLD, 18));
        formatoId();
        add(txtIdCompra);
        // Campo Id Disco
        txtIdDisco.setBounds(40, 200, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(135, 197, 270, 25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        idDisco.setEditable(false);
        // Campo Costo
        txtCosto.setBounds(40, 270, 120, 20);
        txtCosto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        costo.setBounds(135, 270, 270, 25);
        costo.setForeground(Color.GRAY);
        costo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        costo.setEditable(false);
        add(txtCosto);
        add(costo);
        
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
        add(idProveedor);
        add(txtIdProveedor);

        // Añadiendo el campo Fecha
        add(txtFechaC);

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
        if (e.getSource() == agregar) {
            if (idProveedor.isEditable()) {
                if (checarId("IdProv", "Proveedores")) {
                    idProveedor.setEditable(false);
                    idDisco.setEditable(true);
                    cantidad.setEditable(true);
                    costo.setEditable(true);
                }
            } else {
                if (checarId("idDisco", "Discos")) {
                    Object[] x = new Object[3];
                    int cant = -1;
                    float costo = -1;
                    try {
                        x[0] = idDisco.getText();
                        cant = Integer.parseInt(cantidad.getText());
                        costo = Float.parseFloat(this.costo.getText());
                        x[1] = cant;
                        x[2] = cant * costo;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,
                                "Ingrese un numero entero en cantidad/costo o verifique los valores ingresados en el disco",
                                "Cantidad invalida", JOptionPane.ERROR_MESSAGE);
                    }
                    if (cant > 0 && costo > 0) {
                        boolean ban = true;
                        for (int i = 0; i < compras.size(); i++) {
                            if ((x[0]).equals(compras.get(i)[0])) {
                                compras.get(i)[1] = (((int) compras.get(i)[1]) + (int) (x[1]));
                                compras.get(i)[2] = (((float) compras.get(i)[2]) + (float) (x[2]));
                                ban = false;
                                JOptionPane.showMessageDialog(this,
                                        "La cantidad y el subtotal se agregaron al registro con la idProporcionada",
                                        "IdDisco Repetida", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }
                        if (ban) {
                            compras.add(x);
                        } 
                        mtb.actualizarDatos(compras);
                        idDisco.setText("");
                        cantidad.setText("");
                        this.costo.setText("");
                    }else {
                        JOptionPane.showMessageDialog(this,
                                "Cantidad/Costo invalida, verifique que haya ingresado un numero mayor a 0 y que se tenga mas existencia que la cantidad a vender del disco",
                                "Cantidad/Costo invalida", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else if (e.getSource() == finalizar) {
            if (idProveedor.isEditable()) {

            } else {
                if (compras.size() != 0) {
                    float total = 0;
                    if(agregarCompra()){
                        for (int i = 0; i < compras.size(); i++) {
                            String idDisco = (String) compras.get(i)[0];
                            int cant = (int) compras.get(i)[1];
                            float subtotal = (float) compras.get(i)[2];
                            total += subtotal;
                            agregarDetallesCompra(idDisco, cant, subtotal);
                            modificarDiscos(cant, idDisco);
                        }
                        modificarCompra(total);
                        formatoId();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(this,
                            "Error desconocido, falla fatal, cancele ",
                            "Falla fatidica", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se ha agregado nada, si esa era tu intencion da click en cancelar",
                            "No se ha agregado nada", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if(e.getSource() == cancelar){
            limpiar();
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

    public void actualizarFecha() {
        fechaActual = LocalDate.now();
        int dia = fechaActual.getDayOfMonth();
        int mes = fechaActual.getMonthValue();
        int anio = fechaActual.getYear();
        fechaA = String.format("%02d/%02d/%04d", dia, mes, anio);
        txtFechaC.setText("Fecha: " + fechaA);
    }

    public void formatoId() {
        int id = idAutomaticas();
        idCompraActual = String.format("C-%04d", id);
        txtIdCompra.setText("IdCompra: " + idCompraActual);
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
            resultSet = statement.executeQuery("select count(*) as res from Compras");
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

    public boolean checarId(String id, String tabla) {
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
            if (tabla.equals("Proveedores")) {
                resultSet = statement
                        .executeQuery("select * from " + tabla + " where " + id + " = '" + idProveedor.getText() + "'");
            } else {
                resultSet = statement
                        .executeQuery("select * from " + tabla + " where " + id + " = '" + idDisco.getText() + "'");
            }

            if (resultSet.next()) {
                ans = true;
                if (tabla.equals("Discos")) {
                    // costo = resultSet.getFloat("Costo");
                    // exist = resultSet.getInt("Exist");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El " + id + " no existe en la base de datos, verifique los datos",
                        "IdEmp no encontrado", JOptionPane.ERROR_MESSAGE);
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

    public boolean agregarCompra() {
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
            String AgregarQuery = "INSERT INTO Compras (idCompras, idProv, FechaC, Total) VALUES (?, ?, ?, ?)";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
            // Establecer los valores de los parámetros en la sentencia de inserción
            preparedStatement.setString(1, idCompraActual);
            preparedStatement.setString(2, idProveedor.getText());
            preparedStatement.setString(3, fechaA);
            preparedStatement.setFloat(4, 0);
            // Ejecutar la sentencia de inserción
            int rowsAffected = preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Se agregó el registro de la venta correctamente",
                    "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
            ans = true;
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

    public boolean agregarDetallesCompra(String idDisco,int cant, float subtotal) {
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
            String AgregarQuery = "INSERT INTO DetallesCompras (idCompra, idDisco, Cant, SubTotal) VALUES (?, ?, ?, ?)";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
            // Establecer los valores de los parámetros en la sentencia de inserción
            preparedStatement.setString(1, idCompraActual);
            preparedStatement.setString(2, idDisco);
            preparedStatement.setInt(3, cant);
            preparedStatement.setFloat(4, subtotal);
            // Ejecutar la sentencia de inserción
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
            ans = true;
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

    public void modificarCompra(float total){
        Connection connection = null; // se almacena la conexion
        String bdname = "GestorVentasDiscos";// nombre de la base de datos
        String user = "admin";// usuario de la base de datos
        String pass = "123456";// contraseña de usuario

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                    + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                    + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
            String modificar = "update Compras set Total = ? where idCompras =  '" + idCompraActual + "'";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(modificar);
            preparedStatement.setFloat(1, total);
            int rowsAffected = preparedStatement.executeUpdate();
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
    }

    public void limpiar(){
        idProveedor.setEditable(true);
        idDisco.setEditable(false);
        cantidad.setEditable(false);
        idProveedor.setText("");
        costo.setEditable(false);
        idDisco.setText("");
        cantidad.setText("");
        compras.clear();
        mtb.actualizarDatos(compras);
        txtIdCompra.setText("IdCompra: "+idCompraActual);
        actualizarFecha();
    }

    public void modificarDiscos(int cant, String idDisco){
        Connection connection = null; // se almacena la conexion
        String bdname = "GestorVentasDiscos";// nombre de la base de datos
        String user = "admin";// usuario de la base de datos
        String pass = "123456";// contraseña de usuario
        int total = 0;
        String connectionBD;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
            connectionBD = "jdbc:sqlserver://localhost;databaseName="
                    + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                    + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
            Statement statement = null;
            ResultSet resultSet = null;
            connection = DriverManager.getConnection(connectionBD);
            // Crear el objeto Statement
            statement = connection.createStatement();
            // Ejecutar la consulta
            resultSet = statement.executeQuery("select Exist from  Discos where idDisco = '" + idDisco + "'");
            resultSet.next();
            total = resultSet.getInt(1);
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
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
            connectionBD = "jdbc:sqlserver://localhost;databaseName="
                    + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                    + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
            String modificar = "update Discos set Exist = ? where idDisco =  '" + idDisco + "'";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(modificar);
            preparedStatement.setFloat(1, total + cant);
            int rowsAffected = preparedStatement.executeUpdate();
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
    }
}
