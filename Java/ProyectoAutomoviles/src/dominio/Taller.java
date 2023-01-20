package dominio;

/**
 *
 * @author Fabricio
 */
public class Taller {
    private String especialidad; //autos, camiones, motos
    private String ciudad;
    
    public Taller(){}

    public Taller(String especialidad, String ciudad) {
        this.especialidad = especialidad;
        this.ciudad = ciudad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Taller | Especialidad: " + especialidad + " | Ciudad: " + ciudad + (" -");
    }
}
