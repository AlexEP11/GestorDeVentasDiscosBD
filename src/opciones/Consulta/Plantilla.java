package opciones.Consulta;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.util.*;
public class Plantilla extends JPanel implements ActionListener {
    //Variables de la conexion
    Connection connection = null; //se almacena la conexion
    Statement statement = null;
    ResultSet resultSet = null;
    String bdname = "GestorVentasDiscos";//nombre  de la base de datos
    String user = "admin";//usuario de la base de datos
    String pass = "123456";//contraseña de usuario
    //Colores
    public Color cremaP = new Color(251, 205, 131);

    //Espacio de la tabla
    public JPanel tabla = new JPanel(null);
    
    //Imagenes
    ImageIcon buscarImg = new ImageIcon("./src/imagenes/consultar.png");
    ImageIcon limpiarImg = new ImageIcon("./src/imagenes/limpiar.png");

    //Espacio de los radioButtons
    public JPanel opciones = new JPanel();
    public ButtonGroup grupo = new ButtonGroup();
    public MyTableModel mtb;

    //Entrada
    public JTextField entrada = new JTextField("Buscar",20);

    //Botones
    public JPanel botones = new JPanel();
    public JButton limpiar = new JButton();
    public JButton buscar = new JButton(); 

    public Plantilla(){
        setBackground(Color.white);
        //Area de la tabla
        setLayout(null);
        tabla.setBounds(390, 50, 550, 500);
        tabla.setLayout(null);
        add(tabla);

        //Area de las opciones
        opciones.setBounds(80, 50, 260, 250);
        add(opciones);
        entrada.setBounds(65, 350, 250, 30);
        entrada.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        entrada.setHorizontalAlignment(SwingConstants.CENTER);
        opciones.setBackground(Color.white);
        add(entrada);

        //Area de los botones
        botones.setLayout(new GridLayout(1, 2, 50, 0));
        botones.setBounds(100, 420, 180, 60);
        botones.setBackground(Color.white);
        limpiar.setIcon(limpiarImg);
        buscar.setIcon(buscarImg);
        botones.add(limpiar);
        botones.add(buscar);
        add(botones);
        limpiar.setBackground(cremaP);
        buscar.setBackground(cremaP);
        
        //Configuraciones por defecto
        setBounds(0,0,960, 600);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == limpiar){
            grupo.clearSelection();
            entrada.setText("Buscar");
        }
    }
    public void actualizarTabla(String sql) {
        mtb.limpiarDatos();
        mtb.actualizarDatos(this.realizarConsulta(sql));
    }
    public ArrayList<Object[]> realizarConsulta(String sql) {
        ArrayList<Object[]> data = new ArrayList<>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
            +bdname+";user="+user+";password="+pass+";"+ "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
            connection = DriverManager.getConnection(connectionBD);
            // Crear el objeto Statement
            statement = connection.createStatement();
            // Ejecutar la consulta
            resultSet = statement.executeQuery(sql);
            // Procesar los resultados
            while (resultSet.next()) {
                // Obtener los valores de cada columna
                String nPuesto = resultSet.getString("NPuesto");
                float Salario = resultSet.getFloat("Salario");
                Object[] dato = {nPuesto,Salario};
                data.add(dato);
            }
        } catch(ClassNotFoundException s) {
            System.out.println("Error: " + s.getMessage());
        }catch (SQLException e) {
            System.out.println("Error al consultar datos: " + e.getMessage());
        } finally {
            try {
                // Cerrar el ResultSet
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
            }

            try {
                // Cerrar el Statement
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement: " + e.getMessage());
            }

            try {
                // Cerrar la conexión
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return data;
    }
}
