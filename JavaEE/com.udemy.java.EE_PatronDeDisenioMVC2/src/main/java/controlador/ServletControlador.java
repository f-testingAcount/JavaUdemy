package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos los parametros si es que existen
        String accion = request.getParameter("accion");
        
        //2. Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSession = new Rectangulo(3,4);
        Rectangulo recApplication = new Rectangulo(5,6);
        
        //3. Agregamos el JavaBeans a algun alcance
        
        //Revisamos la accion proporcionada
        if ("agregaVariables".equals(accion)) {
            //Alcance request
            request.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSession);
            
            //Alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recApplication);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas!");
            
            //Redireccionamos al jsp de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if ("listarVariables".equals(accion)) {
            
            //4. Redireccionamos al jsp que despliega las variables.
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        } else {
            
            //5. Redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
