package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HolaMundo") //Indicamos la ruta
public class HolaMundo extends HttpServlet {
    
    //Indicamos el tipo de peticion doGet si la hacemos desde el navegador 
    //o doPost si la hacemos desde un formulario
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hola Mundo desde Servlets!");
        //Ejecutamos Clean an build previa verificacion de que el servidor de aplicaciones de GlasFish este detenido y con esto generamos el archivo .war que es
        //donde se empaquetan los proyectos web. WAR significa Web Archive File
        //Tambien se ha creado un archivo index.html y dentro de la carpeta WEB-INF se agregaron algunos archivos de configuracion de los cuales uno de
        //los mas importantes es el archivo de web.xml donde se indica la version que estamos utilizando del api de los servlets
        
    }
}
