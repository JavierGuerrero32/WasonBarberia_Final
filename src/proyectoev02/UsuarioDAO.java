package proyectoev02;

import modeloTablas.ConexionDB;
import modeloTablas.Cliente; // Asegúrate de que el nombre coincida: Cliente o Clientes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Capa de Acceso a Datos (DAO) para la gestión de usuarios.
 * Integra el paquete modeloTablas con la lógica de persistencia.
 */
public class UsuarioDAO {

    // Instancia de la conexión centralizada
    private ConexionDB mysql = new ConexionDB();
    private Connection con;

    /**
     * Registra un nuevo cliente en la base de datos software_barberia.
     * @param cliente Objeto con los datos capturados en la interfaz.
     * @return boolean true si el registro fue exitoso.
     */
    public boolean registrar(Cliente cliente) {
        // Sentencia SQL preparada para evitar inyecciones
        String sql = "INSERT INTO cliente (nombre, apellido, celular, correo, password) VALUES (?, ?, ?, ?, ?)";
        
        try {
            con = mysql.conectar(); // Obtiene la conexión activa
            PreparedStatement ps = con.prepareStatement(sql);
            
            // Mapeo de atributos desde el modelo
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getPassword());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            return false;
        } finally {
            // Cierre seguro de la conexión
            try {
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar conexión: " + ex.getMessage());
            }
        }
    }
}