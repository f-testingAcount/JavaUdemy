package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        //Creamos o recuperamos el objeto HttpSession
        HttpSession sesion = request.getSession();
        //Recuperamos la lista de articulos previos si existe
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        //Verificamos la existencia de la lista
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");
        //Revisamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) { //El metodo trim() quita espacios en blanco a la derecha y a la izquierda
            articulos.add(articuloNuevo);
        }

        try ( //Imprimimos la lista de articulos:
            PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de Articulos</h1>");
            out.print("<br>");
            //Iteramos todos los articulos de la lista
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            //Agregamos un link para regresar al inicio:
            out.print("<br>");
            out.print("<a href='/CarritoCompras'>Volver al inicio</a>");
        }
    }
}
