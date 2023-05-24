package opciones.Agregar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AgregarDisco extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Nom. Album
    JLabel txtNomAlbum = new JLabel("Nom. Album");
    JTextField nomAlbum = new JTextField();

    // Componente numExt
    JLabel txtnumExt = new JLabel("Num. Exist");
    JTextField numExt = new JTextField();

    // Componente Genero
    JLabel txtGenero = new JLabel("Genero");
    JTextField genero = new JTextField();

    // Componente Artista
    JLabel txtArtista = new JLabel("Artista");
    JTextField artista = new JTextField();

    // Componente Costo
    JLabel txtCosto = new JLabel("Costo");
    JTextField costo = new JTextField();

    // Componente Formato
    JLabel txtFormato = new JLabel("Formato");
    JTextField formato = new JTextField();

    // Componente Fecha L.
    JLabel txtFechaL = new JLabel("Fecha L.");
    JTextField fechaL = new JTextField();

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

    public AgregarDisco() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Disco
        txtIdDisco.setBounds(270, 60, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(350, 57, 270, 25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        idDisco.setEditable(false);

        // Campo Nom. Album
        txtNomAlbum.setBounds(20, 150, 120, 20);
        txtNomAlbum.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nomAlbum.setBounds(130, 147, 270, 25);
        nomAlbum.setForeground(Color.GRAY);
        nomAlbum.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo numExt
        txtnumExt.setBounds(20, 240, 120, 20);
        txtnumExt.setFont(new Font("Roboto Black", Font.BOLD, 16));
        numExt.setBounds(130, 237, 270, 25);
        numExt.setForeground(Color.GRAY);
        numExt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Genero
        txtGenero.setBounds(20, 330, 120, 20);
        txtGenero.setFont(new Font("Roboto Black", Font.BOLD, 16));
        genero.setBounds(130, 327, 270, 25);
        genero.setForeground(Color.GRAY);
        genero.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Fecha L
        txtFechaL.setBounds(20, 420, 120, 20);
        txtFechaL.setFont(new Font("Roboto Black", Font.BOLD, 16));
        fechaL.setForeground(Color.GRAY);
        fechaL.setBounds(130, 417, 270, 25);
        fechaL.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Artista
        txtArtista.setBounds(520, 150, 120, 20);
        txtArtista.setFont(new Font("Roboto Black", Font.BOLD, 16));
        artista.setBounds(600, 147, 270, 25);
        artista.setForeground(Color.GRAY);
        artista.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Costo
        txtCosto.setBounds(520, 240, 120, 20);
        txtCosto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        costo.setBounds(600, 237, 270, 25);
        costo.setForeground(Color.GRAY);
        costo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Formato
        txtFormato.setBounds(520, 330, 120, 20);
        txtFormato.setFont(new Font("Roboto Black", Font.BOLD, 16));
        formato.setBounds(600, 327, 270, 25);
        formato.setForeground(Color.GRAY);
        formato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

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
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo Nom. Album
        add(nomAlbum);
        add(txtNomAlbum);

        // Añadiendo el campo Existenncia
        add(numExt);
        add(txtnumExt);

        // Añadiendo el campo Genero
        add(genero);
        add(txtGenero);

        // Añadiendo el campo Fecha L
        add(fechaL);
        add(txtFechaL);

        // Añadiendo el campo Artista
        add(artista);
        add(txtArtista);

        // Añadiendo el campo Costo
        add(costo);
        add(txtCosto);

        // Añadiendo el campo Formato
        add(formato);
        add(txtFormato);

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
                String AgregarQuery = "INSERT INTO Discos (idDisco, Genero, Formato, Artista, NAlbum, DiaL, MesL, AñoL, Exist, Cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                connection = DriverManager.getConnection(connectionBD);
                PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
                // Establecer los valores de los parámetros en la sentencia de inserción
                // preparedStatement.setString(1, idDisco.getText()); Aqui ira el id del disco
                preparedStatement.setString(2, genero.getText());
                preparedStatement.setString(3, formato.getText());
                preparedStatement.setString(4, artista.getText());
                preparedStatement.setString(5, nomAlbum.getText());
                // La fecha sera automatica
                preparedStatement.setInt(9, Integer.parseInt(numExt.getText()));
                preparedStatement.setFloat(10, Float.parseFloat(costo.getText()));
                // Ejecutar la sentencia de inserción
                int rowsAffected = preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(this,"Se agregó el registro del disco correctamente", "Registro exitoso",JOptionPane.INFORMATION_MESSAGE);
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
