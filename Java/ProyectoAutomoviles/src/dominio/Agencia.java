package dominio;

/**
 *
 * @author Fabricio
 */
public class Agencia {
    private String nombreAgencia;
    private String ciudad;
    private String marcaComercializada;
    
    public Agencia(){}

    public Agencia(String nombreAgencia, String ciudad, String marcaComercializada) {
        this.nombreAgencia = nombreAgencia;
        this.ciudad = ciudad;
        this.marcaComercializada = marcaComercializada;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMarcaComercializada() {
        return marcaComercializada;
    }

    public void setMarcaComercializada(String marcaComercializada) {
        this.marcaComercializada = marcaComercializada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Agencia");
        sb.append(" | Nombre: ").append(nombreAgencia);
        sb.append(" | Ciudad: ").append(ciudad);
        sb.append(" | Marca Comercializada: ").append(marcaComercializada);
        sb.append(" -");
        return sb.toString();
    }
    
}
