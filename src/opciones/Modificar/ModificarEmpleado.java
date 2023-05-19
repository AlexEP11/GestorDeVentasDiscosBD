package opciones.Modificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarEmpleado extends JPanel implements MouseListener {
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

    // Componente N Puesto
    JLabel txtNPuesto = new JLabel("Nombre P.");
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


    public ModificarEmpleado() {
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
    buscar.setBounds(430,40,60,60);
    buscar.setCursor(new Cursor(12));
    buscar.addMouseListener(this);

    // Campo Id Puesto
    txtNPuesto.setBounds(20, 150, 120, 20);
    txtNPuesto.setFont(new Font("Roboto Black", Font.BOLD, 16));
    nPuesto.setBounds(130, 147, 270, 25);
    nPuesto.setForeground(Color.GRAY);
    nPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Nombre
    txtNombre.setBounds(20, 240, 120, 20);
    txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 16));
    nombre.setBounds(130, 237, 270, 25);
    nombre.setForeground(Color.GRAY);
    nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Apellido P.
    txtApellidoP.setBounds(20, 330, 120, 20);
    txtApellidoP.setFont(new Font("Roboto Black", Font.BOLD, 16));
    apellidoP.setBounds(130, 327, 270, 25);
    apellidoP.setForeground(Color.GRAY);
    apellidoP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Apellido M.
    txtApellidoM.setBounds(20, 420, 120, 20);
    txtApellidoM.setFont(new Font("Roboto Black", Font.BOLD, 16));
    apellidoM.setBounds(130, 417, 270, 25);
    apellidoM.setForeground(Color.GRAY);
    apellidoM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Tel. F.
    txtTelF.setBounds(520, 150, 120, 20);
    txtTelF.setFont(new Font("Roboto Black", Font.BOLD, 16));
    telF.setBounds(630, 147, 270, 25);
    telF.setForeground(Color.GRAY);
    telF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Tel. C.
    txtTelC.setBounds(520, 240, 120, 20);
    txtTelC.setFont(new Font("Roboto Black", Font.BOLD, 16));
    telC.setBounds(630, 237, 270, 25);
    telC.setForeground(Color.GRAY);
    telC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Turno
    txtTurno.setBounds(520, 330, 120, 20);
    txtTurno.setFont(new Font("Roboto Black", Font.BOLD, 16));
    turno.setBounds(630, 327, 270, 25);
    turno.setForeground(Color.GRAY);
    turno.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
    
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
    add(txtNPuesto);

    // Añadiendo el campo Tel. F.
    add(telF);
    add(txtTelF);

    // Añadiendo el campo Tel. C.
    add(telC);
    add(txtTelC);

    // Añadiendo el campo Turno
    add(turno);
    add(txtTurno);

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
            idEmpleado.setEditable(false);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                // Crear el objeto Statement
                statement = connection.createStatement();
                // Consulta para verificar los datos antes de eliminar
                String consultarVerificacion = "select Empleados.* from Empleados where idEmp = '"+ idEmpleado.getText()+"'";
                // Ejecutar la consulta de verificación 
                resultSet = statement.executeQuery(consultarVerificacion);

                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoIdEmp = resultSet.getString("idEmp");
                String datoNPuesto = resultSet.getString("NPuesto");
                String datoNombre = resultSet.getString("NOM");
                String datoAP = resultSet.getString("AP");
                String datoAM = resultSet.getString("AM");
                String datoTurno = resultSet.getString("Turno");
                String datoTelC = resultSet.getString("TelEC");
                String datoTelF = resultSet.getString("TelEF");
                // Asignar el dato al segundo TextField
                idEmpleado.setText(datoIdEmp);
                nPuesto.setText(datoNPuesto);
                nombre.setText(datoNombre);
                apellidoP.setText(datoAP);
                apellidoM.setText(datoAM);
                turno.setText(datoTurno);
                telC.setText(datoTelC);
                telF.setText(datoTelF);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                idEmpleado.setText("");
                JOptionPane.showMessageDialog(this, "No se encontró el dato asociado al ID", "ID NO ENCONTRADO",JOptionPane.ERROR_MESSAGE);
                idEmpleado.setEditable(true);
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
            idEmpleado.setEditable(true);
            try {
                // Establecer conexión con la base de datos
                 connection = DriverManager.getConnection(connectionBD);
    
                // Definir la consulta SQL con parámetros
                String modificarSQL = "update Empleados set  AP = ?, AM = ?, NOM = ?, NPuesto = ?, Turno = ?, TelEC = ?, TelEF = ? where idEmp = '"+ idEmpleado.getText()+"'";
    
                // Crear objeto PreparedStatement para enviar la consulta
                stmt = connection.prepareStatement(modificarSQL);
    
                // Establecer los valores de los parámetros
                stmt.setString(1, apellidoP.getText());
                stmt.setString(2, apellidoM.getText());
                stmt.setString(3, nombre.getText());
                stmt.setString(4, nPuesto.getText());
                stmt.setString(5, turno.getText());
                stmt.setString(6, telC.getText());
                stmt.setString(7, telF.getText());
                
    
                // Ejecutar la consulta y obtener el número de filas afectadas
                int filasAfectadas = stmt.executeUpdate();
    
                // Verificar si se actualizaron filas correctamente
                if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Los datos se actualizaron correctamente." , "CAMBIOS REALIZADOS",JOptionPane.INFORMATION_MESSAGE);
                } else {
                JOptionPane.showMessageDialog(this, "Los datos no se actualizaron" , "ERORR EN REALIZAR CAMBIOS",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Puesto no encontrado" , "ERORR EN REALIZAR CAMBIOS",JOptionPane.ERROR_MESSAGE);
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
            idEmpleado.setText("");
            apellidoP.setText("");
            apellidoM.setText("");
            nombre.setText("");
            nPuesto.setText("");
            turno.setText("");
            telC.setText("");
            telF.setText("");
        } else if (e.getSource() == cancelar){
            idEmpleado.setText("");
            apellidoP.setText("");
            apellidoM.setText("");
            nombre.setText("");
            nPuesto.setText("");
            turno.setText("");
            telC.setText("");
            telF.setText("");
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
