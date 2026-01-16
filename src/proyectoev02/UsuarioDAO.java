/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoev02;

/**
 *
 * @author USUARIO
 */
import modeloTablas.Cliente; // Importamos tu clase Cliente
import java.sql.*;

public class UsuarioDAO {
    // Método para registrar los datos que vienen de tu diseño de Figma
    public boolean registrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, celular, correo, password) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionDB.getConnection(); // Usando tu clase de conexión
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Aquí usamos los Getters que eliminan las advertencias amarillas
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getPassword());

            int filas = ps.executeUpdate();
            return filas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
