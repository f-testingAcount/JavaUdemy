<%-- 
    Document   : scriplets
    Created on : 22 dic. 2022, 17:32:14
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <%-- Utilizar el codigo condicionado no es buena practica pero se puede hacer desde un JSP. Hay mejores practicas como el patron de diseño MVC --%>
        <br>
        <br>
        <%-- Scriptlets paa enviar informacion al navegador --%>
        <% 
            out.print("Saludos desde un Scriptlet");
        %>
        <br>
        <br>
        <%-- Scriptlet para manipular los objetos implicitos --%>
        <% 
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicacion: " + nombreAplicacion);
        %>
        <br>
        <br>
        <%-- Scriptlet con codigo condionado --%>
        <% 
            if (session != null && session.isNew()) {
        %>
        La sesion es nueva!
        <% 
            } else if (session != null) { 
        %>
        La sesion no es nueva!
        <% 
            }
        %>
        <br>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
