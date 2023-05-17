package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;" + "database=GestorVentasDiscos;" +
                "user=sa;" + "password=1234;" + "encrypt=true; " + "trustServerCertificate=true;" + "loginTimeout=30;";

        try {
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
