package web;

import datos.ClienteDaoJdbc;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJdbc().listar();
        System.out.println("clientes: " + clientes);
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }
}
