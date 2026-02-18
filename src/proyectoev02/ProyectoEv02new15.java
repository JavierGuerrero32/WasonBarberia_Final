package proyectoev02;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoEv02new15 {

    public static void main(String[] args) {

        // Configuración de la conexión
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/software_barberia";

        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            // 1. Cargar el Driver y conectar
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion exitosa.\n");

            // --- BLOQUE DE INSERCIÓN DE DATOS (COMENTADO) ---
            /*
            String sqlInsert = "INSERT INTO barbero (nombre, apellido, telefono, cargo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conexion.prepareStatement(sqlInsert)) {
                pst.setString(1, "Diosnaldo");
                pst.setString(2, "pedrozo");
                pst.setString(3, "3164397612");
                pst.setString(4, "Barbero junior");
                
                int filas = pst.executeUpdate();
                System.out.println("¡Filas insertadas: " + filas + "!"); 
            } 
            */

            // --- BLOQUE DE MODIFICACION DE DATOS (COMENTADO) ---
            /*
            statement = conexion.createStatement(); 
            String sqlModificar = "UPDATE barbero SET nombre = 'Alexander' WHERE idBarbero = 14";
            statement.executeUpdate(sqlModificar);
            System.out.println("Registro actualizado.\n");
            */

            // --- ELIMINAR DATOS DE BASE DE DATOS ---
            String sqlEliminar = "DELETE FROM barbero WHERE idBarbero = ?";

            try (PreparedStatement pst = conexion.prepareStatement(sqlEliminar)) {
                pst.setInt(1, 9);
                int filasAfectadas = pst.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("¡Registro eliminado con éxito!");
                } else {
                    System.out.println("No se encontró ningún registro con ese ID.");
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar datos: " + e.getMessage());
            }

            // --- CONSULTA PARA MOSTRAR LOS DATOS ACTUALIZADOS ---
            // 1. Preparamos una nueva consulta para ver los cambios
            String queryActualizada = "SELECT idBarbero, nombre FROM barbero";
            statement = conexion.createStatement();

            // 2. Llenamos nuestro ResultSet con los datos frescos
            rs = statement.executeQuery(queryActualizada);

            System.out.println("\n--- Lista de Barberos Actualizada ---");

            // 3. El bucle: SIN punto y coma al final del while para que imprima
            while (rs.next()) {
                // Extraemos los datos de la fila actual
                int id = rs.getInt("idBarbero");
                String nombre = rs.getString("nombre");

                // Los mostramos en pantalla
                System.out.println(id + " - " + nombre);
            }

            System.out.println("\nCONSTRUCCION EXITOSA");

        } catch (ClassNotFoundException e) {
            Logger.getLogger(ProyectoEv02new15.class.getName()).log(Level.SEVERE, "Driver no encontrado", e);
        } catch (SQLException e) {
            Logger.getLogger(ProyectoEv02new15.class.getName()).log(Level.SEVERE, "Error de SQL", e);
        } finally {
            // Cierre seguro de recursos
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProyectoEv02new15.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}