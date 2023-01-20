package dominio;

/**
 *
 * @author Fabricio
 */
public class Recepcionista extends Empleado {
    private String formacion; //Estudios, capacitacion
    
    public Recepcionista(){}

    public Recepcionista(String formacion, String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
        this.formacion = formacion;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    @Override
    public String toString() {
        return "Recepcionista | Formacion: " + formacion + super.toString() + (" -");
    }
    
}
