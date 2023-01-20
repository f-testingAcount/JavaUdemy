package dominio;

/**
 *
 * @author Fabricio
 */
public class Distribuidor {
    
    private String nombreDistribuidor;
    private String pais;
    private String marcaDistribuida;

    public Distribuidor() {}

    public Distribuidor(String nombreDistribuidor, String pais, String marcaDistribuida) {
        this.nombreDistribuidor = nombreDistribuidor;
        this.pais = pais;
        this.marcaDistribuida = marcaDistribuida;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMarcaDistribuida() {
        return marcaDistribuida;
    }

    public void setMarcaDistribuida(String marcaDistribuida) {
        this.marcaDistribuida = marcaDistribuida;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distribuidor | ");
        sb.append("Nombre: ").append(nombreDistribuidor);
        sb.append(" | Pais: ").append(pais);
        sb.append(" | Marca Distribuida: ").append(marcaDistribuida);
        sb.append(" -");
        return sb.toString();
    }
    
}
