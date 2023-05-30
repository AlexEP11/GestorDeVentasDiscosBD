package opciones.Modificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarPuesto extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Nombre P.
    JLabel txtNombreP = new JLabel("Nombre P.");
    JTextField nombreP = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Salario
    JLabel txtSalario = new JLabel("Salario");
    JTextField salario = new JTextField();

    // Boton Guardar
    JPanel guardar = new JPanel(null);
    JLabel txtGuardar = new JLabel("Guardar");
    JLabel imgGuardar = new JLabel();
    ImageIcon discoGuardar = new ImageIcon("./src/imagenes/discoAgregar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");

    public ModificarPuesto() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Nombre P.
        txtNombreP.setBounds(20, 60, 120, 20);
        txtNombreP.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nombreP.setBounds(130, 57, 270, 25);
        nombreP.setForeground(Color.GRAY);
        nombreP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(440,40,60,60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Salario
        txtSalario.setBounds(30, 150, 120, 20);
        txtSalario.setFont(new Font("Roboto Black", Font.BOLD, 16));
        salario.setBounds(130, 147, 270, 25);
        salario.setForeground(Color.GRAY);
        salario.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));


        // Campo boton Guardar
        guardar.setBackground(cremaHov);
        guardar.setBounds(780, 510, 160, 60);
        guardar.addMouseListener(this);
        guardar.setCursor(new Cursor(12));
        imgGuardar.setBounds(10, 5, 50, 50);
        imgGuardar.setIcon(discoGuardar);
        txtGuardar.setForeground(Color.BLACK);
        txtGuardar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtGuardar.setBounds(70, 5, 120, 50);

        // Campo boton Cancelar
        cancelar.setBackground(cremaHov);
        cancelar.setBounds(600, 510, 160, 60);
        cancelar.addMouseListener(this);
        cancelar.setCursor(new Cursor(12));
        imgCancelar.setBounds(10, 5, 50, 50);
        imgCancelar.setIcon(equisCancelar);
        txtCancelar.setForeground(Color.BLACK);
        txtCancelar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtCancelar.setBounds(70, 5, 120, 50);

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL ///////////////////////////////////////////////////////////////////

        // Añadiendo el campo Nombre P.
        add(nombreP);
        add(txtNombreP);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Salario
        add(salario);
        add(txtSalario);

        // Añadiendo el boton Guardar (disquito)
        guardar.add(imgGuardar);
        guardar.add(txtGuardar);
        add(guardar);

        // Añadiendo el boton Cancelar
        cancelar.add(imgCancelar);
        cancelar.add(txtCancelar);
        add(cancelar);

        setBounds(0, 0, 960, 600);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Connection connection = null; // Se almacena la conexion
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        String bdname = "GestorVentasDiscos";// Nombre de la base de datos
        String user = "admin";// Usuario de la base de datos
        String pass = "123456";// Contraseña de usuario
        String connectionBD = "jdbc:sqlserver://localhost;databaseName="
        + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
        + "trustServerCertificate=true;" + "loginTimeout=30;";

        if (e.getSource() == buscar) {
            nombreP.setEditable(false);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                // Crear el objeto Statement
                statement = connection.createStatement();
                // Consulta para verificar los datos antes de eliminar
                String consultarVerificacion = "select Puestos.* from Puestos where NPuesto = '"+ nombreP.getText()+"'";
                // Ejecutar la consulta de verificación 
                resultSet = statement.executeQuery(consultarVerificacion);

                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoNPuesto = resultSet.getString("NPuesto");
                String datoSalario = resultSet.getString("Salario");
                // Asignar el dato al segundo TextField
                nombreP.setText(datoNPuesto);
                salario.setText(datoSalario);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                nombreP.setText("");
                JOptionPane.showMessageDialog(this, "No se encontró el dato asociado al ID", "ID NO ENCONTRADO",JOptionPane.ERROR_MESSAGE);
                nombreP.setEditable(true);
            }

            } catch(ClassNotFoundException s) {
                System.out.println("Error: " + s.getMessage());        
            } catch (SQLException s) {
                System.out.println("Error al buscar registros: " + s.getMessage());
            } finally {
                // Cerrar los recursos (ResultSet, Statement y conexión) en el bloque finally
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar el ResultSet: " + s.getMessage());
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar el Statement: " + s.getMessage());
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar la conexión: " + s.getMessage());
                    }
                }
            }
        }
        if (e.getSource() == guardar) {
            nombreP.setEditable(true);
            try {
                // Establecer conexión con la base de datos
                 connection = DriverManager.getConnection(connectionBD);
    
                // Definir la consulta SQL con parámetros
                String modificarSQL = "update Puestos set  Salario = ? where NPuesto = '"+ nombreP.getText()+"'";
    
                // Crear objeto PreparedStatement para enviar la consulta
                stmt = connection.prepareStatement(modificarSQL);
    
                // Establecer los valores de los parámetros
                stmt.setFloat(1, Float.parseFloat(salario.getText()));
                
                // Ejecutar la consulta y obtener el número de filas afectadas
                int filasAfectadas = stmt.executeUpdate();
    
                // Verificar si se actualizaron filas correctamente
                if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Los datos se actualizaron correctamente." , "CAMBIOS REALIZADOS",JOptionPane.INFORMATION_MESSAGE);
                } else {
                JOptionPane.showMessageDialog(this, "Los datos no se actualizaron" , "ERORR EN REALIZAR CAMBIOS",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Error: " + ex.getMessage(),"Modificacion cancelada",JOptionPane.ERROR_MESSAGE);
            } finally {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar el ResultSet: " + s.getMessage());
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar el Statement: " + s.getMessage());
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException s) {
                        System.out.println("Error al cerrar la conexión: " + s.getMessage());
                    }
                }
            }
            nombreP.setText("");
            salario.setText("");
        } else if (e.getSource() == cancelar){
            nombreP.setText("");
            salario.setText("");
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

}
