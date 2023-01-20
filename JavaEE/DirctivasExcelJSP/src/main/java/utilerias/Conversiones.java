package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversiones {

    private static final String FORMATO_FECHA = "dd-MM";

    //DIRECTIVAS:
    //Las directivas nos permiten controlar el comportamiento de un JSP por ejemplo las clases que vamos a utilizar dentro de un JSP y hacer 
    //el import de clases java, especificar el tipo mime con el que vamos a responder a nuestro cliente entre otro tipo de directivas que sirven para 
    //controlar el comportamiento del jsp.
    //Con el uso de directivas podemos  especificar: 
    //Las clases java que queremos importar en un JSP
    //El tipo MIME utilizado
    //Indicar se el JSP puede acceder a la sesion HTTP
    //El tamaño del buffer de salida.
    //Indicar la pagina JSP de error en algun caso de excepcion
    //El manejo de multihilos, entro otra caracteristicas que podemos especificar con el uso de directivas
    //ATRIBUTOS EN LAS DIRECTIVAS DE UN JSP
    //Atributo import: Dentro de la directiva page no permite especificar cuales son las clases que vamos a importar dentro de nuestro JSP e
    //indirectamente a nuestro Servlet generado a partir de la solicitud a nuestro JSP. El import se puede declarar en cualquier parte del JSP
    //pero lo recomendable es declararlo al principio. La sintaxis es la siguiente:
    // <%@ page import="paquete.Clase1, paquete.ClaseN" %>
    //Atributo contentType: Explicita el tipo de respuesta que le vamos en enviar a nuestro cliente.
    // <%@ page contentType="MIME-Type" %>
    //Atributo session: Con la directiva page podemos determinar si el JSP va a poder acceder al objeto session que se haya creado anteriormente desde
    //un JSP o desde otro Servlet. Por defult el JSP esta configurado para que podamos acceder al objeto session y si no queremos acceder por default
    //hay que colocar en false esta directiva. En este caso en las clase implicitas de un JSP no vamos a poder acceder a la variable del tipo Session.
    // <%@ page session="true" %>
    //Atributo isELIgnored: Si que queremos desabilitar el manejo de EL (Expression Language) en el JSP el atributo debe estar en true. 
    //por defecto el valor esta en false lo cual habilita EL en forma automatica
    // <%@ page isELIgnored="false" %>
    //Atributo buffer: Con esta directiva podemos especificar el tamaño en kb que puede contener el buffer del JSP. Si llegamos al tamaño que 
    //especificamos se hace un flush o vaciado automatico de todo el fuljo que hayamo agregado al objeto PrintWriter o al ouput Servlet dependiendo del caso
    //<%@ page buffer="tamañoEnKb" %>
    //Atributo errorPage: Con este atributo vamos a especificar cual va a ser el JSP que va a manejar la excepcion en caso de que el JSP arroje un error
    //<%@ page errorPage="url relativo al JSP de error" %>
    //Atributo isErrorPage: Esta directiva se va a agregar al JSP que va a manejar los errores. Por default esta directiva esta en false debido a que los
    //JSPs no van a manejar las excepciones de manera automatica si no hay que configurarlos para que puedan acceder a la pila de errores. Con esta directiva
    //en true este JSP va a poder manejar la excepciones que puedan probocarse en otro JSP.
    // <% page isErrorPage="true" %>
    //Atributo isThreadSafe: Con esta directiva en true especificamos que un JSP se considera seguro para ser accedido por multiples hilos. Por default
    //el contenedor de Servlets considera a un JSP seguro para ser accedido por multiples hilos. Para que el contenido no sea accedido por multiples hilos 
    //esta directiva se debe colocar en false. 
    // <%@ page isThreadSafe="true" %>
    //Atributo extends: Con esta directiva podemos heredar de otra clase.
    
    
    public static String format(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
        //Esto nos devuelve el String asociado a la fecha que hemos porporcionado.

        //Definimos esta clase para utilizarla directamente desde el JSP para poner en practica el concepto de directiva y esto nos va a devolver
        //una fecha pero en texto.
    }

    public static String format(String fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
}
