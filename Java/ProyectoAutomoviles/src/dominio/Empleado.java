package dominio;

/**
 *
 * @author Fabricio
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private int dni;
    private int edad;
    
    public Empleado(){}

    public Empleado(String nombre, String apellido, int dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return " | Nombre: " + nombre + " | Apellido: " + apellido 
                + " | DNI: " + dni + " | Edad: " + edad;
    }
    
}
