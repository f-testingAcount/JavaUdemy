package dominio;

/**
 *
 * @author Fabricio
 */
public class Gerente extends Empleado {
    private String area; //area de desemplenio
    private String estudios;
    private String nombreAgencia;
    
    public Gerente(){}

    public Gerente(String area, String estudios, String nombreAgencia, String nombre, String apellido, int dni, int edad) {
        super(nombre, apellido, dni, edad);
        this.area = area;
        this.estudios = estudios;
        this.nombreAgencia = nombreAgencia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    @Override
    public String toString() {
        return "Gerente | Area: " + area + " | Estudios | " 
                + estudios + " | Nombre Agencia: " + nombreAgencia + super.toString() + " - ";
    }
    
}
