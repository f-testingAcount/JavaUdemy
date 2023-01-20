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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //El ServletControlador va a recuperar el listado de clientes y 
        //compartir esta info hacia otro jsp que se va a llamar clientes.jsp
        //El metodo doGet va recuperar el listado de clientes (los objetos de tipo Cliente, lo va a compartir en alguno de los alcances que esten
        //disponibles (en este caso vamos a utilizar request) y luego hacemos un Redirect hacia la pagina clinetes.jsp.
        //Ahora este codigo lo pasamos a el metodo accionDefault para poder llamarlo desde aqui y desde el doPost
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar": {
                    try {
                        this.editarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                case "delete": {
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
        List<Cliente> clientes;
        try {
            clientes = new ClienteDaoJdbc().listar();
            System.out.println("Clientes: " + clientes);

//            request.setAttribute("clientes", clientes); //Compartimos en el alcance request
//            request.setAttribute("totalClientes", clientes.size());
//            request.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
            //Cambiamos el alcance de request cuando utilizamos sendRedirect en lugar del forward por un alcance mayor como session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("clientes", clientes);
            sesion.setAttribute("totalClientes", clientes.size());
            sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
            //request.getRequestDispatcher("clientes.jsp").forward(request, response);
            //El forward hace que el url no cambie y en consecuencia se dupica el ultimo registro cargado.
            //Para resolver esto utilizamos sendRedirect
            response.sendRedirect("clientes.jsp");
            //El sendRedirect si notifica al navegador
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

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos el idCliente
        //HttpSession sesion = request.getSession();
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDaoJdbc().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        //response.sendRedirect("clientes.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar": {
                    try {
                        this.insertarCliente(request, response);
                        break;
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace(System.out);
                    }
                }
                case "modificar": {
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

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario agrgarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }
        //Creamos el objeto de cliente (modelo). La clase Cliente es la que representa al modelos en el patron modelo, vista, controlador
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        //Insertamos el objeto en la base de datos
        int registrosModificados = new ClienteDaoJdbc().insertar(cliente);
        System.out.println("RegistrosModificados: " + registrosModificados);
        this.accionDefault(request, response);
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario agrgarCliente
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
        //Creamos el objeto de cliente (modelo). La clase Cliente es la que representa al modelos en el patron modelo, vista, controlador
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //Modificamos el objeto en la base de datos
        int registrosModificados = new ClienteDaoJdbc().actualizar(cliente);
        System.out.println("RegistrosModificados: " + registrosModificados);
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        //Recuperamos los valores del formulario agrgarCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Creamos el objeto de cliente (modelo). La clase Cliente es la que representa al modelos en el patron modelo, vista, controlador
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el objeto en la base de datos
        int registrosModificados = new ClienteDaoJdbc().delete(cliente);
        System.out.println("RegistrosModificados: " + registrosModificados);
        this.accionDefault(request, response);
    }
}
