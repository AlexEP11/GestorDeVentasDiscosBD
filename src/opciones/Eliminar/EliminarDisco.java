package opciones.Eliminar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EliminarDisco extends JPanel implements MouseListener {
    // Colores
    Color cremaHov = new Color(242, 190, 107);

    // Componente Buscar
    ImageIcon iconBuscar = new ImageIcon("./src/imagenes/consultar.png");
    JLabel imgBuscar = new JLabel();
    JPanel buscar = new JPanel(null);

    // Componente id Disco
    JLabel txtIdDisco = new JLabel("Id Disco");
    JTextField idDisco = new JTextField();

    // Componente Nom. Album
    JLabel txtNomAlbum = new JLabel("Nom. Album");
    JTextField nomAlbum = new JTextField();

    // Componente numExt
    JLabel txtnumExt = new JLabel("numExt");
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

    public EliminarDisco() {
        setLayout(null);
        setBackground(Color.WHITE);

        // Campo Id Disco
        txtIdDisco.setBounds(270, 60, 120, 20);
        txtIdDisco.setFont(new Font("Roboto Black", Font.BOLD, 16));
        idDisco.setBounds(350, 57, 270, 25);
        idDisco.setForeground(Color.GRAY);
        idDisco.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

        // Campo Buscar
        imgBuscar.setIcon(iconBuscar);
        imgBuscar.setBounds(8, 7, 45, 45);
        buscar.setBackground(cremaHov);
        buscar.setBounds(650,40,60,60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

        // Campo Nom. Album
        txtNomAlbum.setBounds(20, 150, 120, 20);
        txtNomAlbum.setFont(new Font("Roboto Black", Font.BOLD, 16));
        nomAlbum.setBounds(130, 147, 270, 25);
        nomAlbum.setForeground(Color.GRAY);
        nomAlbum.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        nomAlbum.setEditable(false);
    

        // Campo numExt
        txtnumExt.setBounds(20, 240, 120, 20);
        txtnumExt.setFont(new Font("Roboto Black", Font.BOLD, 16));
        numExt.setBounds(130, 237, 270, 25);
        numExt.setForeground(Color.GRAY);
        numExt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        numExt.setEditable(false);

        // Campo Genero
        txtGenero.setBounds(20, 330, 120, 20);
        txtGenero.setFont(new Font("Roboto Black", Font.BOLD, 16));
        genero.setBounds(130, 327, 270, 25);
        genero.setForeground(Color.GRAY);
        genero.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        genero.setEditable(false);

        // Campo Artista
        txtArtista.setBounds(520, 150, 120, 20);
        txtArtista.setFont(new Font("Roboto Black", Font.BOLD, 16));
        artista.setBounds(600, 147, 270, 25);
        artista.setForeground(Color.GRAY);
        artista.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        artista.setEditable(false);

        // Campo Costo
        txtCosto.setBounds(520, 240, 120, 20);
        txtCosto.setFont(new Font("Roboto Black", Font.BOLD, 16));
        costo.setBounds(600, 237, 270, 25);
        costo.setForeground(Color.GRAY);
        costo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        costo.setEditable(false);

        // Campo Formato
        txtFormato.setBounds(520, 330, 120, 20);
        txtFormato.setFont(new Font("Roboto Black", Font.BOLD, 16));
        formato.setBounds(600, 327, 270, 25);
        formato.setForeground(Color.GRAY);
        formato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
        formato.setEditable(false);

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

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL ////////////////////////////////////////////////////////////////////

        // Añadiendo el campo id Disco
        add(idDisco);
        add(txtIdDisco);

        // Añadiendo el campo Buscar
        buscar.add(imgBuscar);
        add(buscar);

        // Añadiendo el campo Nom. Album
        add(nomAlbum);
        add(txtNomAlbum);

        // Añadiendo el campo Existenncia
        add(numExt);
        add(txtnumExt);

        // Añadiendo el campo Genero
        add(genero);
        add(txtGenero);

        // Añadiendo el campo Artista
        add(artista);
        add(txtArtista);

        // Añadiendo el campo Costo
        add(costo);
        add(txtCosto);

        // Añadiendo el campo Formato
        add(formato);
        add(txtFormato);

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
                String consultaVerificacion = "select Discos.* from Discos where idDisco = '"+idDisco.getText()+"'";
                // Ejecutar la consulta de verificación
                resultSet = statement.executeQuery(consultaVerificacion);
                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoGenero = resultSet.getString("Genero");
                String datoFormato = resultSet.getString("Formato");
                String datoArtista = resultSet.getString("Artista");
                String datoNAlbum = resultSet.getString("NAlbum");
                String datoExist = resultSet.getString("Exist");
                String datoCosto = resultSet.getString("Costo");
                // Asignar el dato al segundo TextField
                genero.setText(datoGenero);
                formato.setText(datoFormato);
                artista.setText(datoArtista);
                nomAlbum.setText(datoNAlbum);
                numExt.setText(datoExist);
                costo.setText(datoCosto);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                genero.setText("");
                formato.setText("");
                artista.setText("");
                nomAlbum.setText("");
                numExt.setText("");
                costo.setText("");
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
                String EliminarQuery = "DELETE FROM Discos WHERE idDisco = '"+idDisco.getText()+"'";
                //Ejecutar la sentencia
                int rowsAffected = statement.executeUpdate(EliminarQuery);
                //Verificar si se eliminaron registros
                if (rowsAffected > 0) {
                    System.out.println("Se eliminaron " + rowsAffected + " registros.");
                    JOptionPane.showMessageDialog(this, "Se ha eliminado con exito el disco","Eliminacion exitosa",JOptionPane.INFORMATION_MESSAGE);
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
            idDisco.setText("");
            genero.setText("");
            formato.setText("");
            artista.setText("");
            nomAlbum.setText("");
            numExt.setText("");
            costo.setText("");
        }
        if (e.getSource()==cancelar) {
            idDisco.setText("");
            genero.setText("");
            formato.setText("");
            artista.setText("");
            nomAlbum.setText("");
            numExt.setText("");
            costo.setText("");
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
