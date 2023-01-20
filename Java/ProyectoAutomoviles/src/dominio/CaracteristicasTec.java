package dominio;

/**
 *
 * @author Fabricio
 */
public class CaracteristicasTec {
    private String modeloDenominacion;
    private String tipoMotor; //nafta, gasoil
    private String cilindros;
    private String cilindrada;
    private int HP;
    private String caja; //manual o automatica y cantidad de velocidades
    private String equipamiento; //base, full
    private String carroceria; //auto, camioneta, suv cantidad de puertas
    private int id; //codigo unico de identificacion
    
    public CaracteristicasTec(){}

    public CaracteristicasTec(int id) {
        this.id = id;
    }

    public CaracteristicasTec(String modeloDenominacion, String tipoMotor, String cilindros, String cilindrada, int HP, String caja, String equipamiento, 
            String carroceria, int id) {
        this.modeloDenominacion = modeloDenominacion;
        this.tipoMotor = tipoMotor;
        this.cilindros = cilindros;
        this.cilindrada = cilindrada;
        this.HP = HP;
        this.caja = caja;
        this.equipamiento = equipamiento;
        this.carroceria = carroceria;
        this.id = id;
       
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getCilindros() {
        return cilindros;
    }

    public void setCilindros(String cilindros) {
        this.cilindros = cilindros;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }
    
    public String getEquipamiento(){
        return equipamiento;
    }
    
    public void setEquipameiento(){
        this.equipamiento = equipamiento;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModeloDenominacion() {
        return modeloDenominacion;
    }

    public void setModeloDenominacion(String modeloDenominacion) {
        this.modeloDenominacion = modeloDenominacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modelo | ");
        sb.append("Denominacion: ").append(modeloDenominacion);
        sb.append(" | TipoMotor: ").append(tipoMotor);
        sb.append(" | Cilindros: ").append(cilindros);
        sb.append(" | Cilindrada: ").append(cilindrada);
        sb.append(" | HP: ").append(HP);
        sb.append(" | Caja: ").append(caja);
        sb.append(" | Equipamiento: ").append(equipamiento);
        sb.append(" | Carroceria: ").append(carroceria);
        sb.append(" | id: ").append(id);
        sb.append(" -");
        return sb.toString();
    }
    
    
}
