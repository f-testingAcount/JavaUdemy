package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    //CODIGOS DE ESTADO
    //API DE SERVLETS AL UTILIZAR CODIGOS DE ESTADO:
    //Los siguientes metodos nos permiten indicar el codigo de respuesta del servidor web al cliente (navegador web):

    //response.setStatus(int codigo)    Se utilian normalmente constantes tales como SC_OK, SC_NOT_FOUND, etc.
    //response.sendError(int codigo, String mensaje)     Se utiliza para mostrar el error en un docmento HTML, normalmente los navegadores.
    //response.sendredirect(String url)    Se utiliza para indicar un redireccionamiento a otra pagina. El codigo de estado es el 302.
    
    //CODIGOS DE ESTADO MAS COMUNES:
    //200 (Ok): La respuesta fue correcta, es el codio de estado por defautl.
    //204 (Sin contenido): El navegador continua desplegando el documento previo.
    //301 (Movido permanentemente): El documento solicitado ha cambiando de ubicacion, y posiblemente, se indica la nueva ruta, en el caso del navegador se mueve al nuevo url de manera automatica
    //302 (Encontrado): El documento se ha movido temporalmente, y el navegador se mueve al nuevo url de manera automatica.
    //401 (Sin autorizacion): No se tiene permiso para visualizar el contenido solicitado, debido a que se trato de acceder a un recurso protegido con contraseña sin la autorizacion respetiva
    //404 (No encontrado): El recurso solicitado no se encuentra alojado en el servidor web.
    //500 (Error Interno del Servidor Web): El servidor web lanzo una excepcion irrecuperable por lo tanto no se puede continuar procesando la peticion.
   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Simulando los valores correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";
    
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter out = response .getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br>Usuario: " + usuario);
            out.print("<br>Password: " + password);
            out.print("</h1>");
        } else {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
        out.close();
    }
}
