
package negocios;

import dominio.Marca;
import dominio.Modelo;

/**
 *
 * @author Fabricio
 * @param <T>
 */
public interface IAccionesComerciales<T> {
    
    void iniciar();
    
    void agregar(String nombreArchivo, T object);
    
    void listarArchivo(String nombreArchivo, T object);
    
    void enviarRecibirPedidoDeFabricante(String nombreArchivo, Modelo modelo, String denominacionModelo, int unidades);
    
    void venderVehiculo(String nombreArchivo, String denominacionModelo);
    
    void ingresarAlService(String ID);
    
    void enviarUnidadesAAgencia(Marca marca, Modelo modelo);
    
    void borrarArchivo(String nombreArchivo);
}
