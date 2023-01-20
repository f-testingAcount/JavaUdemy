<%-- 
    Document   : index
    Created on : 22 dic. 2022, 23:25:05
    Author     : user
--%>



<%-- Agregamos una declaracion de JSP --%>
<%-- Podemos declarar un atributo o un metodo que va a formar parte de la clase del Servlet que se va a asociar a este JSP una vez compilado --%>

<%!
    //Declaramos una variable con su metodo get
    private String usuario = "Pedro";

    public String getUsuario() {
        return this.usuario;
    }

    //Declaramos un contador de visitas
    private int contadorVisitas = 1;


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones JSP</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSP</h1>
        Valor usuario por medio del atributo: <%= this.usuario %>
        <br>
        Volor usuario por medio del metodo: <%= this.getUsuario() %>
        <br>
        Contador de visitas: <%= this.contadorVisitas++ %>

    </body>
</html>
