package modeloTablas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase centralizada para la conexión a la base de datos software_barberia.
 */
public class ConexionDB {
    
    // Configuración de parámetros de conexión
    private final String URL = "jdbc:mysql://localhost:3306/software_barberia";
    private final String USER = "root";
    private final String PASSWORD = ""; 

    public Connection conectar() {
        Connection con = null;
        try {
            // Cargar el Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentar establecer la conexión
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            // Manejo específico si falta la librería JAR
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "Driver no encontrado", ex);
        } catch (SQLException ex) {
            // Manejo de errores de credenciales o servidor
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, "Error de SQL al conectar", ex);
        }
        return con;
    }
}