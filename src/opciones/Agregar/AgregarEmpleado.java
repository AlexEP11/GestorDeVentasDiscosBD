package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AgregarEmpleado extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Empleado
    JLabel txtIdEmpleado = new JLabel("Id Empleado");
    JTextField idEmpleado = new JTextField();

    // Componente Nombre
    JLabel txtNombre = new JLabel("Nombre");
    JTextField nombre = new JTextField();

    // Componente Apellido P.
    JLabel txtApellidoP = new JLabel("Apellido P.");
    JTextField apellidoP = new JTextField();

    // Componente Apellido M.
    JLabel txtApellidoM = new JLabel("Apellido M.");
    JTextField apellidoM = new JTextField();

    // Componente nombre Puesto
    JLabel txtNPuesto = new JLabel("Id Puesto");
    JTextField NPuesto = new JTextField();

    // Componente Tel. F.
    JLabel txtTelF = new JLabel("Tel. F.");
    JTextField telF = new JTextField();

    // Componente Tel. C.
    JLabel txtTelC = new JLabel("Tel. C.");
    JTextField telC = new JTextField();

    // Componente Turno
    JLabel txtTurno = new JLabel("Turno");
    JTextField turno = new JTextField();

    // Boton Agregar
    JPanel agregar = new JPanel(null);
    JLabel txtAgregar = new JLabel("Agregar");
    JLabel imgAgregar = new JLabel();
    ImageIcon discoAgregar = new ImageIcon("./src/imagenes/discoAgregar.png");

    // Boton Cancelar
    JPanel cancelar = new JPanel(null);
    JLabel txtCancelar = new JLabel("Cancelar");
    JLabel imgCancelar = new JLabel();
    ImageIcon equisCancelar = new ImageIcon("./src/imagenes/cancelar.png");


    public AgregarEmpleado() {
    setLayout(null);
    setBackground(Color.WHITE);
    
    // Campo Id Empleado
    txtIdEmpleado.setBounds(20, 60, 120, 20);
    txtIdEmpleado.setFont(new Font("Roboto Black", Font.BOLD, 16));
    idEmpleado.setBounds(130, 57, 270, 25);
    idEmpleado.setForeground(Color.GRAY);
    idEmpleado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Nombre
    txtNombre.setBounds(20, 150, 120, 20);
    txtNombre.setFont(new Font("Roboto Black", Font.BOLD, 16));
    nombre.setBounds(130, 147, 270, 25);
    nombre.setForeground(Color.GRAY);
    nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Apellido P.
    txtApellidoP.setBounds(20, 240, 120, 20);
    txtApellidoP.setFont(new Font("Roboto Black", Font.BOLD, 16));
    apellidoP.setBounds(130, 237, 270, 25);
    apellidoP.setForeground(Color.GRAY);
    apellidoP.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Apellido M.
    txtApellidoM.setBounds(20, 330, 120, 20);
    txtApellidoM.setFont(new Font("Roboto Black", Font.BOLD, 16));
    apellidoM.setBounds(130, 327, 270, 25);
    apellidoM.setForeground(Color.GRAY);
    apellidoM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

    // Campo Id Puesto
    txtNPuesto.setBounds(520, 60, 120, 20);
    txtNPuesto.setFont(new Font("Roboto Black", Font.BOLD, 16));
    NPuesto.setBounds(630, 57, 270, 25);
    NPuesto.setForeground(Color.GRAY);
    NPuesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

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
    
    // Campo boton Agregar
    agregar.setBackground(cremaHov);
    agregar.setBounds(780, 510, 160, 60);
    agregar.addMouseListener(this);
    agregar.setCursor(new Cursor(12));
    imgAgregar.setBounds(10, 5, 50, 50);
    imgAgregar.setIcon(discoAgregar);
    txtAgregar.setForeground(Color.BLACK);
    txtAgregar.setFont(new Font("Roboto Black", Font.BOLD, 18));
    txtAgregar.setBounds(70, 5, 120, 50);

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
    add(NPuesto);
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

    // Añadiendo el boton Agregar (disquito)
    agregar.add(imgAgregar);
    agregar.add(txtAgregar);
    add(agregar);

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
            Connection connection = null; // se almacena la conexion
            String bdname = "GestorVentasDiscos";// nombre de la base de datos
            String user = "admin";// usuario de la base de datos
            String pass = "123456";// contraseña de usuario

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// Se conecta al driver
                String connectionBD = "jdbc:sqlserver://localhost;databaseName="
                        + bdname + ";user=" + user + ";password=" + pass + ";" + "encrypt=true; "
                        + "trustServerCertificate=true;" + "loginTimeout=30;";// Parametros de la conexion a bd
                String AgregarQuery = "INSERT INTO Empleados (idEmp, AP, AM, NOM, NPuesto, Turno, TelEC, TelEF) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                connection = DriverManager.getConnection(connectionBD);
                PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
                // Establecer los valores de los parámetros en la sentencia de inserción
                preparedStatement.setString(1, idEmpleado.getText());
                preparedStatement.setString(2, apellidoP.getText());
                preparedStatement.setString(3, apellidoM.getText());
                preparedStatement.setString(4, nombre.getText());
                preparedStatement.setString(5, NPuesto.getText());
                preparedStatement.setString(6, turno.getText());
                preparedStatement.setString(7, telC.getText());
                preparedStatement.setString(8, telF.getText());
                // Ejecutar la sentencia de inserción
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
                // Se cierra la conexion en teoria xd
                connection.close();
            } catch (ClassNotFoundException s) {
                System.out.println("Error: " + s.getMessage());
            } catch (SQLException s) {
                System.out.println("Error: " + s.getMessage());
            } catch (Exception s) {
                System.out.println("Error: " + s.getMessage());
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
    

    
}
