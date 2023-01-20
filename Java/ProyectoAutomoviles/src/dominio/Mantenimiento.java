package dominio;

/**
 *
 * @author Fabricio
 */
public class Mantenimiento extends Empleado {
    private String area; //salon ventas, taller
    private String formacion; //capacitacion
    
    public Mantenimiento() {}

    public Mantenimiento(String nombre, String apellido, int dni, int edad, String area, String formacion) {
        super(nombre, apellido, dni, edad);
        this.area = area;
        this.formacion = formacion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    @Override
    public String toString() {
        return "Mantenimiento | Area: " + area + " | Formacion: " + formacion + super.toString() + (" -");
    }
}
