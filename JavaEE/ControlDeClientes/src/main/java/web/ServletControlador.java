package web;

import datos.ClienteDaoJdbc;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                {
                    try {
                        this.editarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                case "eliminar":
                {
                    try {
                        this.eliminarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Cliente> clientes = new ClienteDaoJdbc().listar();
            System.out.println("clientes = " + clientes);
//            request.setAttribute("clientes", clientes);
//            request.setAttribute("totalClientes", clientes.size());
//            request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
//            request.getRequestDispatcher("clientes.jsp").forward(request, response);
//            Al utilizar un dispatcher cuando ejecutamos un refresh nos pregunta si queremos volver a enviar el formulario el cual contiene la 
//            la ultima info que cargamos la cual va a aprecer duplicada en la pagina a la que enviamos la info. El metodo forward genera un cambio de
//            manera interna por lo que el navegador no recibe la info de que se selecciono otro jsp para mostrar. Todo se hace del lado del servidor por
//            lo cual la ultima accion sigue fijada en la url y seguimos utilizando el servlet controlador. Para solucionar esto en lugar de forward se
//            utiliza sendRedirect con el objeto response que si notifica al navegador, vuelve a hacer una llamada y no utiliza los datos obtenidos 
//            con el objeto request.
            HttpSession sesion = request.getSession();
            sesion.setAttribute("clientes", clientes);
            sesion.setAttribute("totalClientes", clientes.size());
            sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
            response.sendRedirect("clientes.jsp");
            //El metodo sendRedirect genera una nueva llamada get hacia el servidor para notificar un cambio de jsp que supera el alcance de request el cual 
            //pierde la info del listado de clientes
            //es por esto que cambiamos el alcance a session para que se sostenga el listado ante una nueva peticion.
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
        //Recuperamos el idCiente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJdbc().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos el parametro de accion
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                {
                    try {
                        this.insertarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                case "modificar":
                {
                    try {
                        this.modificarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario agregar cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto de cliente (modelo) del patron de diseño modelo vista controlador
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        //Insertamos este objeto cliente en la base de datos.
        int registrosModificados = new ClienteDaoJdbc().insertar(cliente);
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos a la accion por default.
        this.accionDefault(request, response);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario editar cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto de cliente (modelo) del patron de diseño modelo vista controlador
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        //Modificamos este objeto cliente en la base de datos.
        int registrosModificados = new ClienteDaoJdbc().actualizar(cliente);
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos a la accion por default.
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario editar cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //Creamos el objeto de cliente (modelo) del patron de diseño modelo vista controlador
        Cliente cliente = new Cliente(idCliente);
        //Modificamos este objeto cliente en la base de datos.
        int registrosModificados = new ClienteDaoJdbc().delete(cliente);
        System.out.println("Registros Modificados = " + registrosModificados);
        //redirigimos a la accion por default.
        this.accionDefault(request, response);
    }
}
