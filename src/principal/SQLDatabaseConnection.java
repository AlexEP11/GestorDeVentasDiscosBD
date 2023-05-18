package principal;
import java.sql.*;

public class SQLDatabaseConnection {
    public static Connection getConnection(){
        Connection connection = null; //se almacena la conexion para poderla retornar
        String bdname = "GestorVentasDiscos";//nombre  de la base de datos
        String user = "admin";//usuario de la base de datos
        String pass = "123456";//contraseña de usuario

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
            +bdname+";user="+user+";password="+pass+";"+ "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
            String AgregarQuery = "INSERT INTO Productos (idprod, nombre, precio, existencia) VALUES (?, ?, ?, ?)";
            connection = DriverManager.getConnection(connectionBD);
            PreparedStatement preparedStatement = connection.prepareStatement(AgregarQuery);
            // Establecer los valores de los parámetros en la sentencia de inserción
            preparedStatement.setString(1, "P-10");
            preparedStatement.setString(2, "PruebaConexion");
            preparedStatement.setInt(3, 123);
            preparedStatement.setInt(4, 123);
            // Ejecutar la sentencia de inserción
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Se agregó el registro correctamente. Filas afectadas: " + rowsAffected);
            connection.close();
        } catch(ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }
}