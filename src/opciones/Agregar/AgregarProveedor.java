package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AgregarProveedor extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Disco
    JLabel txtIdProveedor = new JLabel("Id Proveedor");
    JTextField idProveedor = new JTextField();

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

    public AgregarProveedor() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Proveedor
        txtIdProveedor.setBounds(230, 60, 120, 20);
        txtIdProveedor.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idProveedor.setBounds(350, 57, 270, 25);
        idProveedor.setForeground(Color.GRAY);
        idProveedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        idProveedor.setEditable(false);

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

        // Añadiendo el campo id Proveedor
        add(idProveedor);
        add(txtIdProveedor);

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
        Connection connection = null; //se almacena la conexion
        String bdname = "GestorVentasDiscos";//nombre  de la base de datos
        String user = "admin";//usuario de la base de datos
        String pass = "123456";//contraseña de usuario

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
            +bdname+";user="+user+";password="+pass+";"+ "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
            String AgregarQuery = "INSERT INTO Proveedores (IdProv, NomP, Calle, NExterior, TelPC, TelPF) VALUES (?, ?, ?, ?, ?, ?)";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
            // Establecer los valores de los parámetros en la sentencia de inserción
            //preparedStatement.setString(1, idProveedor.getText()); Aqui ira la id del proveedor
            preparedStatement.setString(2, idProveedor.getText());
            preparedStatement.setString(3, nomProv.getText());
            preparedStatement.setString(4, calle.getText());
            preparedStatement.setInt(5, Integer.parseInt(numExt.getText()));
            preparedStatement.setString(7, telC.getText());
            preparedStatement.setString(8, telF.getText());
            // Ejecutar la sentencia de inserción
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
            // Se cierra la conexion en teoria xd
            connection.close();
        } catch(ClassNotFoundException s) {
            System.out.println("Error: " + s.getMessage());
        }catch(SQLException s) {
            System.out.println("Error: " + s.getMessage());
        }catch(Exception s) {
            System.out.println("Error: " + s.getMessage());
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
