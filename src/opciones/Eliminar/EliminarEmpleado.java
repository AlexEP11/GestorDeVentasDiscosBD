package opciones.Eliminar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EliminarEmpleado extends JPanel implements MouseListener {
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Empleado
    JLabel txtIdEmpleado = new JLabel("Id Empleado");
    JTextField idEmpleado = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Nombre
    JLabel txtNombre = new JLabel("Nombre");
    JTextField nombre = new JTextField();

    // Componente Apellido P.
    JLabel txtApellidoP = new JLabel("Apellido P.");
    JTextField apellidoP = new JTextField();

    // Componente Apellido M.
    JLabel txtApellidoM = new JLabel("Apellido M.");
    JTextField apellidoM = new JTextField();

    // Componente id Puesto
    JLabel txtNPuesto = new JLabel("Id Puesto");
    JTextField nPuesto = new JTextField();

    // Componente Tel. F.
    JLabel txtTelF = new JLabel("Tel. F.");
    JTextField telF = new JTextField();

    // Componente Tel. C.
    JLabel txtTelC = new JLabel("Tel. C.");
    JTextField telC = new JTextField();

    // Componente Turno
    JLabel txtTurno = new JLabel("Turno");
    JTextField turno = new JTextField();

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

    public EliminarEmpleado() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Empleado
        txtIdEmpleado.setBounds(20, 60, 120, 20);
        txtIdEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idEmpleado.setBounds(130, 57, 270, 25);
        idEmpleado.setForeground(Color.GRAY);
        idEmpleado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(430, 40, 60, 60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Id Puesto
        txtNPuesto.setBounds(20, 150, 120, 20);
        txtNPuesto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nPuesto.setBounds(130, 147, 270, 25);
        nPuesto.setForeground(Color.GRAY);
        nPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        nPuesto.setEditable(false);

        // Campo Nombre
        txtNombre.setBounds(20, 240, 120, 20);
        txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nombre.setBounds(130, 237, 270, 25);
        nombre.setForeground(Color.GRAY);
        nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        nombre.setEditable(false);

        // Campo Apellido P.
        txtApellidoP.setBounds(20, 330, 120, 20);
        txtApellidoP.setFont(new Font("Roboto Black", Font.BOLD, 16));
        apellidoP.setBounds(130, 327, 270, 25);
        apellidoP.setForeground(Color.GRAY);
        apellidoP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        apellidoP.setEditable(false);

        // Campo Apellido M.
        txtApellidoM.setBounds(20, 420, 120, 20);
        txtApellidoM.setFont(new Font("Roboto Black", Font.BOLD, 16));
        apellidoM.setBounds(130, 417, 270, 25);
        apellidoM.setForeground(Color.GRAY);
        apellidoM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        apellidoM.setEditable(false);

        // Campo Tel. F.
        txtTelF.setBounds(520, 150, 120, 20);
        txtTelF.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telF.setBounds(630, 147, 270, 25);
        telF.setForeground(Color.GRAY);
        telF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        telF.setEditable(false);

        // Campo Tel. C.
        txtTelC.setBounds(520, 240, 120, 20);
        txtTelC.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telC.setBounds(630, 237, 270, 25);
        telC.setForeground(Color.GRAY);
        telC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        telC.setEditable(false);

        // Campo Turno
        txtTurno.setBounds(520, 330, 120, 20);
        txtTurno.setFont(new Font("Roboto Black", Font.BOLD, 16));
        turno.setBounds(630, 327, 270, 25);
        turno.setForeground(Color.GRAY);
        turno.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        turno.setEditable(false);

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

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL //////////////////////////////////// 

        // Añadiendo el campo id Disco
        add(idEmpleado);
        add(txtIdEmpleado);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Nombre
        add(nombre);
        add(txtNombre);

        // Añadiendo el campo Apellido P.
        add(apellidoP);
        add(txtApellidoP);

        // Añadiendo el campo Apellido M.
        add(apellidoM);
        add(txtApellidoM);

        // Añadiendo el campo id Puesto
        add(nPuesto);
        add(nPuesto);

        // Añadiendo el campo Tel. F.
        add(telF);
        add(txtTelF);

        // Añadiendo el campo Tel. C.
        add(telC);
        add(txtTelC);

        // Añadiendo el campo Turno
        add(turno);
        add(txtTurno);

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
                String consultaVerificacion = "select Empleados.* from Empleados where idEmp = '"+idEmpleado.getText()+"'";
                // Ejecutar la consulta de verificación
                resultSet = statement.executeQuery(consultaVerificacion);
                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoAP = resultSet.getString("AP");
                String datoAM = resultSet.getString("AM");
                String datoNom = resultSet.getString("NOM");
                String datoNPuesto = resultSet.getString("NPuesto");
                String datoTurno = resultSet.getString("Turno");
                String datoTelC = resultSet.getString("TelEC");
                String datoTelF = resultSet.getString("TelEF");
                // Asignar el dato al segundo TextField
                apellidoM.setText(datoAP);
                apellidoP.setText(datoAM);
                nombre.setText(datoNom);
                nPuesto.setText(datoNPuesto);
                turno.setText(datoTurno);
                telC.setText(datoTelC);
                telF.setText(datoTelF);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                apellidoM.setText("");
                apellidoP.setText("");
                nombre.setText("");
                nPuesto.setText("");
                turno.setText("}");
                telC.setText("");
                telF.setText("");
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
                String EliminarQuery = "DELETE FROM Empleados WHERE idEmp = '"+idEmpleado.getText()+"'";
                //Ejecutar la sentencia
                int rowsAffected = statement.executeUpdate(EliminarQuery);
                //Verificar si se eliminaron registros
                if (rowsAffected > 0) {
                    System.out.println("Se eliminaron " + rowsAffected + " registros.");
                    JOptionPane.showMessageDialog(this, "Se ha eliminado con exito el empleado","Eliminacion exitosa",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron registros para eliminar","Informacion no encontrada",JOptionPane.INFORMATION_MESSAGE);
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
            idEmpleado.setText("");
            apellidoM.setText("");
            apellidoP.setText("");
            nombre.setText("");
            nPuesto.setText("");
            turno.setText("}");
            telC.setText("");
            telF.setText("");
        }
        if (e.getSource()==cancelar) {
            idEmpleado.setText("");
            apellidoM.setText("");
            apellidoP.setText("");
            nombre.setText("");
            nPuesto.setText("");
            turno.setText("}");
            telC.setText("");
            telF.setText("");
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
