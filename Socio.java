import java.io.Serializable;

public class Socio implements Serializable {
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String categoria;
    private boolean estaAlDia;

    public Socio(String nombre, String dni, String telefono, String email, String categoria) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
        this.estaAlDia = false; 
    }

    // Agregamos todos los Getters para que Java no proteste
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public String getCategoria() { return categoria; }
    public boolean isEstaAlDia() { return estaAlDia; }

    // Método para que el administrador pueda cambiar el estado de deuda
    public void setEstaAlDia(boolean estado) {
        this.estaAlDia = estado;
    }
}