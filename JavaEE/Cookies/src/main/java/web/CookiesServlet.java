package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    
    
        //Una sesion en una aplicacion web permite administrar varias peticiones de un mismo usuario. Esto se debe a que el protocolo Http no guarda
        //informacion. Es un protocolo sin estado (stateless). Entre distintas peticiones de un mismo usuario no almacena informacion del mismo.
        
        //MECANISMOS PARA MANEJAR LAS SESIONES EN LOS SERVLETS:
        //1. Cookies
        //2. URL Rewritting
        //El API de los Servlets abstrae estos conceptos en una clase llamado HttpSession.
        
        //COOKIES:
        //Las cookies las utilizamos para almacenar informacion del usuario ya que el protocolo http no lo hace.
        //Una cookie es un archivo que contiene informacion en forma de NOMBRE Y VALOR, el cual se almacena en el navegador Web.
        //El objetivo de una cookie es almacenar informacion del usuario cada vez que accede a un mismo sitio, como puede ser el lenguaje preferido, 
        //colores preferidos y en general GUARDA LAS PREFERENCIAS DEL USUARIO.
        //La info que guardan las cookies es texto plano no encriptado por lo que se debe evitar almacenar informacion sensible como passwords, 
        //tarjetas de credito, etc.
        
        //Los Servlets crean objetos cookies y enviar info al navegador web y, a su ves odemos leer las cookies que el navegador envie a nuestro 
        //servidor web por medio del api de los Servlets utilizando el objeto cookie que se encuentra en el paquete javax.servlet.http. Con el objeto
        //cookie podemos almacenar info del usuario ya sea para leer nueva info que este llegando o para enviar info al navegador web. Cada cookie se 4
        //asocia con una direccion ip o con el dominio del sitio web desde el cual proviene la peticion http. Las cookies almacenan las preferencias del4
        //usuario.
        
        //API DE LAS COOKIES EN LS SERVLETS
        //Una cookie se puede leer en una peticion http (se itera el arreglo de cookies) y se puede escribir en una respuesta http.
        //Para crear un objeto cookie se utiliza la siguiente sintaxis: Cookie c = new Cookie("usuario", "Juan");   donde usuario es el nombre de la cookie y Juan es el valor
        //c.getName(); y c.getValue(); recuperan estos datos.
        
        //Para leer todas las cookies en peticion http se ejecuta la siguiente linea de codigo:   Cookie[] cookies = request.getCookies(); 
        //Totos los valores que se almacenan en una cookie son del tipo String.
        
        //Para agregar una Cookie en la respuesta se utiliza el siguiente metodo:  response.addCookie(c);
        
        //API DEL OBJETO COOKIE
        //Los metodos mas comunes que se utilizan en un objeto Cookie son:
        //getDomain | setDomain:  Se utiliza para especificar el dominio de donde proviene o se va a almacenar la Cookie.
        //getMaxAge | setMaxAge:  Especifica el tiempo a expirar(segundos)
        //getName: Obtiene el nombre de la cookie, para colocar el nombre se debe utilizar el constructor de la clase
        //getValue | setValue: Especifica el valor asociado con el nombre de la cookie.
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            //Creamos una variable suponiendo un usuario que visita por primera vez nuestro sitio.
            boolean nuevoUsuario = true;
            
            //Obtenemos el arreglo de cookies.
            Cookie[] cookies = request.getCookies();
            
            //Buscamos  si ya existe una cookie creada con anterioridad llamada visitanteRecurrente
            if(cookies != null){
                for (Cookie c: cookies) {
                    if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {
                        //Si ya existe la cookie es un usuario recurrente
                        nuevoUsuario = false;
                        break;
                    }
                }
            }
            String mensaje = null;
            if (nuevoUsuario) {
                Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
                response.addCookie(visitanteCookie);
                mensaje = "Gracias por visitar nuestro sitio por primera vez!";
            } else {
                mensaje = "Gracias por visitar nuevamente  nuestro sitio!";
            }
            //A continuacion enviamos la respuesta
            response.setContentType("text/html;charse=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("Mensaje: " + mensaje);
            out.close();
        }
    }

