package principal;

import java.sql.*;

public class SQLDatabaseConnection {
   public static Connection connection = null; //se almacena la conexion para poderla retornar
   
    public static Connection getConnection(){
        String bdname = "GestorVentasDiscos";//nombre  de la base de datos
        String user = "usersql";//usuario de la base de datos
        String pass = "root2";//contraseña de usuario

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Se conecta al driver
            String connectionBD = "jdbc:sqlserver://localhost;databaseName="
            +bdname+";user="+user+";password="+pass+";"+ "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";//Parametros de la conexion a bd
            connection = DriverManager.getConnection(connectionBD);
        } catch(ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if(SQLDatabaseConnection.getConnection() != null){
            System.out.println("CONEXION EXITOSA");
        } else {
            System.out.println("CONEXION FALLIDA");
        }

        return connection;
    }
}