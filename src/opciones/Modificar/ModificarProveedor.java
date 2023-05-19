package opciones.Modificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarProveedor extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Disco
    JLabel txtIdProveedor = new JLabel("Id Proveedor");
    JTextField idProveedor = new JTextField();

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente Nom. Prov.
    JLabel txtNomProv = new JLabel("Nom. Prov.");
    JTextField nomProv = new JTextField();

    // Componente Calle
    JLabel txtCalle = new JLabel("Calle");
    JTextField calle = new JTextField();

    // Componente Num. Ext.
    JLabel txtNumExt = new JLabel("Num. Ext.");
    JTextField numExt = new JTextField();

    // Componente Tel. F.
    JLabel txtTelF = new JLabel("Tel. F.");
    JTextField telF = new JTextField();

    // Componente Tel. C.
    JLabel txtTelC = new JLabel("Tel. C.");
    JTextField telC = new JTextField();

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

    public ModificarProveedor() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Proveedor
        txtIdProveedor.setBounds(230, 60, 120, 20);
        txtIdProveedor.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idProveedor.setBounds(350, 57, 270, 25);
        idProveedor.setForeground(Color.GRAY);
        idProveedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(650,40,60,60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Nom. Prov.
        txtNomProv.setBounds(20, 150, 120, 20);
        txtNomProv.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nomProv.setBounds(130, 147, 270, 25);
        nomProv.setForeground(Color.GRAY);
        nomProv.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Calle
        txtCalle.setBounds(40, 240, 120, 20);
        txtCalle.setFont(new Font("Roboto Black", Font.BOLD, 16));
        calle.setBounds(130, 237, 270, 25);
        calle.setForeground(Color.GRAY);
        calle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo NumExt
        txtNumExt.setBounds(30, 330, 120, 20);
        txtNumExt.setFont(new Font("Roboto Black", Font.BOLD, 16));
        numExt.setBounds(130, 327, 270, 25);
        numExt.setForeground(Color.GRAY);
        numExt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo TelF
        txtTelF.setBounds(520, 150, 120, 20);
        txtTelF.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telF.setBounds(600, 147, 270, 25);
        telF.setForeground(Color.GRAY);
        telF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo TelC
        txtTelC.setBounds(520, 240, 120, 20);
        txtTelC.setFont(new Font("Roboto Black", Font.BOLD, 16));
        telC.setBounds(600, 237, 270, 25);
        telC.setForeground(Color.GRAY);
        telC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));


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

        // Añadiendo el campo id Proveedor
        add(idProveedor);
        add(txtIdProveedor);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Nom. Prov.
        add(nomProv);
        add(txtNomProv);

        // Añadiendo el campo Calle
        add(calle);
        add(txtCalle);

        // Añadiendo el campo NumExt
        add(numExt);
        add(txtNumExt);

        // Añadiendo el campo TelF
        add(telF);
        add(txtTelF);

        // Añadiendo el campo TelC
        add(telC);
        add(txtTelC);


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
            idProveedor.setEditable(false);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                // Crear el objeto Statement
                statement = connection.createStatement();
                // Consulta para verificar los datos antes de eliminar
                String consultarVerificacion = "select Proveedores.* from Proveedores where idProv = '"+ idProveedor.getText()+"'";
                // Ejecutar la consulta de verificación 
                resultSet = statement.executeQuery(consultarVerificacion);

                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoIdProv = resultSet.getString("IdProv");
                String datoNomP = resultSet.getString("NomP");
                String datoCalle = resultSet.getString("Calle");
                String datoNExterior = resultSet.getString("NExterior");
                String datoTelPC = resultSet.getString("TelPC");
                String datoTelPF = resultSet.getString("TelPF");
                // Asignar el dato al segundo TextField
                idProveedor.setText(datoIdProv);
                nomProv.setText(datoNomP);
                calle.setText(datoCalle);
                numExt.setText(datoNExterior);
                telC.setText(datoTelPC);
                telF.setText(datoTelPF);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                idProveedor.setText("");
                JOptionPane.showMessageDialog(this, "No se encontró el dato asociado al ID", "ID NO ENCONTRADO",JOptionPane.ERROR_MESSAGE);
                idProveedor.setEditable(true);
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
            idProveedor.setEditable(true);
            try {
                // Establecer conexión con la base de datos
                 connection = DriverManager.getConnection(connectionBD);
    
                // Definir la consulta SQL con parámetros
                String modificarSQL = "update Proveedores set  NomP = ?, Calle = ?, NExterior = ?, TelPC = ?, TelPF = ? where idProv = '"+ idProveedor.getText()+"'";
    
                // Crear objeto PreparedStatement para enviar la consulta
                stmt = connection.prepareStatement(modificarSQL);
    
                // Establecer los valores de los parámetros
                stmt.setString(1, nomProv.getText());
                stmt.setString(2, calle.getText());
                stmt.setString(3, numExt.getText());
                stmt.setString(4, telC.getText());
                stmt.setString(5, telF.getText());
                
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
            idProveedor.setText("");
            nomProv.setText("");
            calle.setText("");
            numExt.setText("");
            telC.setText("");
            telF.setText("");
        } else if (e.getSource() == cancelar){
            idProveedor.setText("");
            nomProv.setText("");
            calle.setText("");
            numExt.setText("");
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
