package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesHttpServlet")
public class SesionesServlet extends HttpServlet{
    
    
        //SESION HTTP
        //El api de los Servlet administra las sesiones de los clientes a traves de la clase HttpSesion que se ejecuta de manera automatica
        //Cada peticion de un cliente hacia nuestro recurso web genera automaticamente una nueva sesion.
        //Si tenemos dos navegadores en la misma pc se consideran clientes distintos y cada una genera su propia nueva sesion en el servidor web.
        //Si en el mismo navegador abrimos una nueva ventana no se considera un nuevo cliente por lo que no va a crear una nueva sesion del lado del servidor.
        //Una sesion nos permite administrar las sesiones que realiza un usuario. El protocolo http no tiene estado por lo que no va a recordar la info que
        //el usuario haya enviado previamente. El objeto HttpSesion se obtiene a traves del objeto HttpServletRequest. 
        //Una sesion tiene un periodo de vida mas largo que una peticion o lo que es lo mismo el objeto request.
        //Una sesion se destruye una vez transcurrido el tiempo que le hemos asignado al periodo de inactividad o tambien se puede hacer que expire
        //de manera no automatica ejecutando el metodo invalidate().
        
        //MANEJO DE SESIONES CON SERVLETS
        //request.getSession(); : Se utiliza para obtener la sesion que se creo a partir de la peticion del cliente
        //La sesion creada se asocia con el cliente que realizo la peticion
        //sesion.getAttribute(); : Permite obtener  un atributo previamente agregado a la sesion del cliente.
        //sesion.setAttribute(); : Permite agregar un atributo a la sesion actual del cliente.
        //sesion.removeAttribute(); : Permite eliminar atributos de la sesion
        //sesion.invalidate(); : Invalida la sesion actual del cliente.
        //sesion.isNew(); : Permite saber si la sesion ha sido recien creada
        //sesion.getCreationTime(); : Permite conocer la fecha y hora de cuando se creo la sesion
        //sesion.getLastAccesedTime(); : Permite saber la ultmia vez que la sesion fue accesada por el cliente.
        //sesion.setMaxInactiveInterval(); : Permite modificar el valor mencionado en la funcion anterior. Este valor tambien se puede modificar en el archivo web.xml
        
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        
        //Solicitamos el objeto Session
        HttpSession sesion = request.getSession(); //Esto nos regresa la sesion actual asociada con esta peticion.
                                                   //Si la peticion no tiene asociada una sesion entonces crea un nuevo objeto.
                                                   //Automaticamente nos regresa el objeto sesion y si fuera la primera vez genera automaticamente el objeto
                                                   //Si el objeto ya existe debido a peticiones anteriores nos regresa el objeto existente.
        String titulo = null;
        
        //Solicitamos el atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        //Si el contador de visitas es nulo implica que es la primera vez que accedemos a la aplicacion
            if (contadorVisitas == null) {
                contadorVisitas = 1;
                titulo = "Bienvenido por pirmera vez a nuestro sitio!";
            } else {
                contadorVisitas++;
                titulo = "Bienvenido nuevamente!";
            }
            
            //Agregamos el nuevo valor a la sesion:
            sesion.setAttribute("contadorVisitas", contadorVisitas);
            
            //A continuacion enviamos la respuesta al cliente
            PrintWriter out = response.getWriter();
            out.print(titulo);
            out.print("<br>");
            out.println("Veces que se accedio al recurso: " + contadorVisitas);
            out.println("<br>");
            out.println("ID de la sesion: " + sesion.getId());
            out.close();
    } 
}
