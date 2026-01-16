package proyectoev02;
import java.sql.*;

public class ConexionDB {
    public static Connection getConnection() throws SQLException {
        // Verifica que estos datos coincidan con tu MySQL Workbench
        String url = "jdbc:mysql://localhost:3306/software_barberia";
        String user = "root";
        String password = "tu_password_aqui"; // Pon aquí tu clave real
        
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw e;
        }
    }
}