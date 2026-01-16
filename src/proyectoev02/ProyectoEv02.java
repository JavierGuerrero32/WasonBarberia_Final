/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoev02;

/**
 *
 * @author USUARIO
 */import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProyectoEv02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombre = "root";
        String contraseña = "";
        String url = "jdbc:mysql://localhost:3306/software_barberia";
        Connection conexion;
        Statement statement;
        ResultSet rs;
       
    
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoEv02.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error: Driver JDBC de MySQL no encontrado. Asegúrate de haber añadido la librería (.jar).");            e.printStackTrace();
            return; // Termina si el driver no carga
            
            
        }
        try {
            conexion = DriverManager.getConnection(url,nombre,contraseña);
            statement = conexion.createStatement();
            rs = statement.executeQuery ("SELECT * FROM barbero");
            rs.next();
            do {
               
                System.out.println(rs.getInt("idBarbero")+"  :  "+ rs.getString("nombre"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoEv02.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        }
        
            
        }
        
    }
    
}
