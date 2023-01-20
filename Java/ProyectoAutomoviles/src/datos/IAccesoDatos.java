package datos;

import excepciones.AccesoDatosEx;
import java.util.List;

/**
 *
 * @author Fabricio
 * @param <T>
 */
public interface IAccesoDatos <T> {
    
    void crear(String nombreArchivo) throws AccesoDatosEx;
    
    boolean existe(String nombreArchivo) throws AccesoDatosEx;
    
    void escribir(T object, String nombreArchivo) throws AccesoDatosEx;
    
    void modificarDatoEnArchivo(String nombreArchivo, List<T> object) throws AccesoDatosEx;
    
    List<T> listar(T object, String nombreArchivo) throws AccesoDatosEx;
    
    T buscar(String nombreArchivo, Object object) throws AccesoDatosEx;
    
    int buscarIndice(String nombreArchivo, Object object, String modeloDenominacion) throws AccesoDatosEx;
    
    Integer stockModelo(String nombreArchivo, String denominacionModelo) throws AccesoDatosEx;
    
    void borrar(String nombreArchivo) throws AccesoDatosEx;
    
}
