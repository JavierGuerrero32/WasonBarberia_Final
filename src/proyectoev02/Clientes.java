package modeloTablas;

/**
 * Clase que representa la entidad Cliente en la base de datos software_barberia.
 * Esta clase debe coincidir con las columnas de tu tabla 'cliente'.
 */
public class Clientes {

    // Variables basadas en las columnas de tu tabla 'cliente'
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String celular;
    private String correo;
    private String password;

    // Constructor vacío (necesario para muchos frameworks y DAO)
    public Clientes() {
    }

    // Constructor con parámetros
    public Clientes(int id_cliente, String nombre, String apellido, String celular, String correo, String password) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.password = password;
    }

    // Métodos Getters y Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}