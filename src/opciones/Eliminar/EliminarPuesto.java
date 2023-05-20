package opciones.Eliminar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EliminarPuesto extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Nombre P.
    JLabel txtNPuesto = new JLabel("Nombre P.");
    JTextField nPuesto = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Salario
    JLabel txtSalario = new JLabel("Salario");
    JTextField salario = new JTextField();

    // Boton Eliminar
    JPanel eliminar = new JPanel(null);
    JLabel txtEliminar = new JLabel("Eliminar");
    JLabel imgEliminar = new JLabel();
    ImageIcon iconoEliminar = new ImageIcon("./src/imagenes/borrar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");

    public EliminarPuesto() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Nombre P.
        txtNPuesto.setBounds(20, 60, 120, 20);
        txtNPuesto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nPuesto.setBounds(130, 57, 270, 25);
        nPuesto.setForeground(Color.GRAY);
        nPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

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
        salario.setEditable(false);


        // Campo boton Eliminar
        eliminar.setBackground(cremaHov);
        eliminar.setBounds(780, 510, 160, 60);
        eliminar.addMouseListener(this);
        eliminar.setCursor(new Cursor(12));
        imgEliminar.setBounds(10, 5, 50, 50);
        imgEliminar.setIcon(iconoEliminar);
        txtEliminar.setForeground(Color.BLACK);
        txtEliminar.setFont(new Font("Roboto Black", Font.BOLD, 18));
        txtEliminar.setBounds(70, 5, 120, 50);

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
        add(nPuesto);
        add(txtNPuesto);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Salario
        add(salario);
        add(txtSalario);

        // Añadiendo el boton Eliminar
        eliminar.add(imgEliminar);
        eliminar.add(txtEliminar);
        add(eliminar);

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
        String bdname = "GestorVentasDiscos";// Nombre de la base de datos
        String user = "admin";// Usuario de la base de datos
        String pass = "123456";// Contraseña de usuario
        
        if (e.getSource()==buscar) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                        + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                        + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                // Crear el objeto Statement
                statement = connection.createStatement();
                // Consulta para verificar los datos antes de eliminar
                String consultaVerificacion = "select Puestos.* from Puestos where NPuesto = '"+nPuesto.getText()+"'";
                // Ejecutar la consulta de verificación
                resultSet = statement.executeQuery(consultaVerificacion);

                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String dato = resultSet.getString("Salario");
                // Asignar el dato al segundo TextField
                salario.setText(dato);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                salario.setText("");
                JOptionPane.showMessageDialog(this,"Error no se encontro el dato asociado a la id");
            }

            } catch(ClassNotFoundException s) {
                System.out.println("Error: " + s.getMessage());        
            } catch (SQLException s) {
                JOptionPane.showMessageDialog(this,"Error al buscar registros");
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
        if (e.getSource() == eliminar) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                        + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                        + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                //Crear el objeto Statement
                statement = connection.createStatement();
                //Sentencia SQL para eliminar un registro
                String EliminarQuery = "DELETE FROM Puestos WHERE NPuesto = '"+nPuesto.getText()+"'";
                //Ejecutar la sentencia
                int rowsAffected = statement.executeUpdate(EliminarQuery);
                //Verificar si se eliminaron registros
                if (rowsAffected > 0) {
                    System.out.println("Se eliminaron " + rowsAffected + " registros.");
                    JOptionPane.showMessageDialog(this, "Se ha eliminado con exito el puesto","Eliminacion exitosa",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron registros para eliminar", "Eliminacion cancelada",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch(ClassNotFoundException s) {
                System.out.println("Error: " + s.getMessage());        
            } catch (SQLException s) {
                System.out.println("Error al eliminar registros: " + s.getMessage());
            } finally {
                try {
                    // Cerrar el Statement
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException s) {
                    System.out.println("Error al cerrar el Statement: " + s.getMessage());
                }
                try {
                    // Cerrar la conexión
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException s) {
                    System.out.println("Error al cerrar la conexión: " + s.getMessage());
                }
            }
            nPuesto.setText("");
            salario.setText("");
        }
        if (e.getSource()==cancelar) {
            nPuesto.setText("");
            salario.setText("");
            JOptionPane.showMessageDialog(this,"Se ha cancelado la eliminación","Eliminacion cancelada",JOptionPane.INFORMATION_MESSAGE);
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
