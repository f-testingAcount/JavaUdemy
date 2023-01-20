package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //Indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //Para un uso mas profesional de excel se debe utilizar la libreria de apache poi (poi.apache.org)
        
        //Indicamos a continuacion al navegador que no guarde informacion previa para que cada vez que clikemos el link siempre sea info nueva y q no guarde cache el navegador)
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);  //El valor de -1 es para que expire de manera inmediata
        //Desplegamos la info al cliente
        PrintWriter out = response.getWriter();
        
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(b2:b3)");
    }
}
