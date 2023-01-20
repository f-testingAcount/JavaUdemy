
package dominio;

/**
 *
 * @author Fabricio
 */
public class Mecanico extends Empleado {
    private String especialidad; //Autos, camiones, motos
    private String formacion; //Estudios, capacitacion
    
    public Mecanico(){}

    public Mecanico(String nombre, String apellido, int dni, int edad, String especialidad, String formacion) {
        super(nombre, apellido, dni, edad);
        this.especialidad = especialidad;
        this.formacion = formacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    @Override
    public String toString() {
        return "Mecanico | Especialidad: " + especialidad + " | Formacion: " + formacion 
                + super.toString() + " - ";
    }
    
}
