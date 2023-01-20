package dominio;

/**
 *
 * @author Fabricio
 */
public class Vendedor extends Empleado {
    private String area; //vehiculos, repuestos, etc
    private String formacion; //capacitacion
    
    public Vendedor(){}

    public Vendedor(String nombre, String apellido, int dni, int edad, String area, String formacion) {
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
        return "Vendedor | Area: " + area + " | Formacion: " + formacion 
                + super.toString() + " - ";
    }
    
}
