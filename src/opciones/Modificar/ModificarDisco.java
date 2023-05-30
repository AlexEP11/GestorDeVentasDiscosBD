package opciones.Modificar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarDisco extends JPanel implements MouseListener {
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
    // JLabel txtFormato = new JLabel("Formato");
    // JTextField formato = new JTextField();

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

    public ModificarDisco() {
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
        buscar.setBounds(650, 40, 60, 60);
        buscar.setCursor(new Cursor(12));
        buscar.addMouseListener(this);

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
        // txtFormato.setBounds(520, 330, 120, 20);
        // txtFormato.setFont(new Font("Roboto Black", Font.BOLD, 16));
        // formato.setBounds(600, 327, 270, 25);
        // formato.setForeground(Color.GRAY);
        // formato.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));

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

        //////////////////////////////////// AÑADIENDO AL PANEL PRINCIPAL
        //////////////////////////////////// ////////////////////////////////////////////////////////////////////

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
            idDisco.setEditable(false);
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
                //Establecer la conexión
                connection = DriverManager.getConnection(connectionBD);
                // Crear el objeto Statement
                statement = connection.createStatement();
                // Consulta para verificar los datos antes de eliminar
                String consultarVerificacion = "select Discos.* from Discos where idDisco = '"+ idDisco.getText()+"'";
                // Ejecutar la consulta de verificación 
                resultSet = statement.executeQuery(consultarVerificacion);

                // Verificar si se encontró el dato
            if (resultSet.next()) {
                // Obtener el dato del resultado de la consulta
                String datoIdDisco = resultSet.getString("idDisco");
                String datoNomAlbum = resultSet.getString("NAlbum");
                String datoGenero = resultSet.getString("Genero");
                String datoArtista = resultSet.getString("Artista");
                String datoExist = resultSet.getString("Exist");
                String datoCosto = resultSet.getString("Costo");
                // Asignar el dato al segundo TextField
                idDisco.setText(datoIdDisco);
                nomAlbum.setText(datoNomAlbum);
                genero.setText(datoGenero);
                artista.setText(datoArtista);
                numExt.setText(datoExist);
                costo.setText(datoCosto);
            } else {
                // No se encontró el dato, puedes mostrar un mensaje de error o limpiar el segundo TextField
                idDisco.setText("");
                JOptionPane.showMessageDialog(this, "No se encontró el dato asociado al ID", "ID NO ENCONTRADO",JOptionPane.ERROR_MESSAGE);
                idDisco.setEditable(true);
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
            idDisco.setEditable(true);
            try {
                // Establecer conexión con la base de datos
                 connection = DriverManager.getConnection(connectionBD);
    
                // Definir la consulta SQL con parámetros
                String modificarSQL = "update Discos set Genero = ?, Artista = ?, NAlbum = ?, Exist = ?, Costo = ? where idDisco = '"+ idDisco.getText()+"'";
    
                // Crear objeto PreparedStatement para enviar la consulta
                stmt = connection.prepareStatement(modificarSQL);
    
                // Establecer los valores de los parámetros
                stmt.setString(1, genero.getText());
                stmt.setString(2, artista.getText());
                stmt.setString(3, nomAlbum.getText());
                stmt.setInt(4, Integer.parseInt(numExt.getText()));
                stmt.setFloat(5, Float.parseFloat(costo.getText()));
    
                // Ejecutar la consulta y obtener el número de filas afectadas
                
                if(Integer.parseInt(numExt.getText()) >= 0 && Float.parseFloat(costo.getText()) >=0){
                    int filasAfectadas = stmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Se agregó el registro del disco correctamente", "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Se agregó el registro correctamente. Filas afectadas: " + filasAfectadas);
                }else{
                    JOptionPane.showMessageDialog(this,"Error: verifique que el costo y numero de existencia sean positivos" ,"Agregacion cancelada",JOptionPane.ERROR_MESSAGE);
                }
                // Verificar si se actualizaron filas correctamente
                // if (filasAfectadas > 0) {
                // JOptionPane.showMessageDialog(this, "Los datos se actualizaron correctamente." , "CAMBIOS REALIZADOS",JOptionPane.INFORMATION_MESSAGE);
                // } else {
                // JOptionPane.showMessageDialog(this, "Los datos no se actualizaron" , "ERROR EN REALIZAR CAMBIOS",JOptionPane.ERROR_MESSAGE);
                // }
            } catch (SQLException ex) {
                System.out.println("Error al buscar registros: " + ex.getMessage());
                JOptionPane.showMessageDialog(this,"Error: " + ex.getMessage(),"Modificacion cancelada",JOptionPane.ERROR_MESSAGE);
            } catch (Exception s) {
                JOptionPane.showMessageDialog(this,"Error: ingrese numeros tanto en la fecha, como en el costo y la existencia","Agregacion cancelada",JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: " + s.getMessage());
            }finally {
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
            idDisco.setText("");
            nomAlbum.setText("");
            genero.setText("");
            // formato.setText("");
            artista.setText("");
            numExt.setText("");
            costo.setText("");
        } else if (e.getSource() == cancelar){
            idDisco.setEditable(true);
            idDisco.setText("");
            nomAlbum.setText("");
            genero.setText("");
            // formato.setText("");
            artista.setText("");
            numExt.setText("");
            costo.setText("");
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
