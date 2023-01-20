
package dominio;

/**
 *
 * @author Fabricio
 */
public class Marca {

    private String nombre;
    private String origen;
    private String logo;
    private int stock;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca(String nombre, String origen, String logo) {
        this.nombre = nombre;
        this.origen = origen;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }
    
    public void setOrigen(String origen){
        this.origen = origen;
    }
    
    public String getLogo(){
        return logo;
    }
    
    public void setLogo(String logo){
        this.logo = logo;
    }
    
    public int getStock(){
        return stock;
    }
    
    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca:");
        sb.append(" | Nombre: ").append(nombre);
        sb.append(" | Origen: ").append(origen);
        sb.append(" | Logo: ").append(logo);
        sb.append(" -");
        return sb.toString();
    }
    
}
