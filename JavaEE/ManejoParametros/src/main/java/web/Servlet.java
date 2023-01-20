package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Procesamos los valores o parametros que nos esta enviando el formulario y regresamos una respuesta hacia el navegador
        //Primero leemos los parametros del formulario html
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //Imprimimos estas variables en la consola de glasfish (ya no en la consola standar como veniamos haciendo.
        //Esta info es solo a titulo informativo y va a estar del lado del servidor
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        //Ahora respondemos al cliente que hizo la llamada
        PrintWriter out = response.getWriter();
        //A continuacion podriamos escribir la respuesta o agregar codigo html. En este caso vamos a escribir codigo html lo cual 
        //no es lo mas conveniente pero lo hacemos a titulo de ejemplo. En la practica vamos a utilizar jsp
        
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es: " + usuario);
        out.print("<br>");
        out.print("El parametro password es: " + password);
        out.print("</body>");
        out.print("</html>");
        out.close();
        
        
        
    }
}
