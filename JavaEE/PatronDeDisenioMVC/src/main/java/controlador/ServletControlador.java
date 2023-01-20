package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        
        //2. Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        //3. Agregamos el JavaBeans a algun alcance
        request.setAttribute("mensaje", "Saludos desde el Servlet");  //La variable es mensaje y el valor es el saludo. La variable la vamos a 
                                                                      //requerir desde el JSP para mostrar la info al cliente. El servlet no se 
                                                                      //encarga de responder directamente al cliente por lo cual no vamos a utilizar
                                                                      //aqui response, setContentType pq todo esto se hace desde el jsp
        
        //4. Ahora compartimos el JavaBean de rectangulo pero no en el alcance de request sino en el alcanse de session. 
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //5. Redireccionamos a la vista seleccionada
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
    }
}
