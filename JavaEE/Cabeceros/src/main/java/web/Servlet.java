
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {
    
    //REQUEST HEADER (CABECEROS DE PETICION) Sirven para obtener metadatos de la peticion HTTP como ser:
    
    //El metodo HTTP utilizado en la peticion(Get, Post, etc)
    //La IP del equipo que realizo la peticion (192.168.1.1)
    //El dominio del equipo que realizo la peticion (www.midominio.com)
    //El recurso solicitado(http://midominio.com/recurso)
    //El navegador que se utilizo en la peticion(Mozilla, explorer, Chrome, etc.)
    //Hay varios cabeceros mas
    
    
    //Definimos el metodo que va a procesar esta peticion:
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Agregamos el tipo de repuesta
        response.setContentType("text/html, charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metodoHttp = request.getMethod();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Header HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("Metodo Http: " + metodoHttp);
        
        String uri = request.getRequestURI();
        out.print("<br>");
        out.print("Uri solicitada: " + uri);
        
        out.print("<br>");
        out.print("<br>");
        //Imprimimos todos los cabeceros disponibles.
        Enumeration cabeceros = request.getHeaderNames();
        while(cabeceros.hasMoreElements()){
            String nombreCabecero = (String) cabeceros.nextElement();
            out.print("<b>" + nombreCabecero + "</b>");
            out.print(request.getHeader(nombreCabecero));
            out.print("<br>");
        }
        
        String id = request.getLocalName();
        out.print("<br>");
        out.print("Local name: " + id);
        
        String direccionLocal = request.getLocalAddr();
        out.print("<br>");
        out.print("Local address: " + direccionLocal);
        
        String idSesion = request.getRequestedSessionId();
        out.print("<br>");
        out.print("Sesion id: " + idSesion);
        
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
    
    
    
}
