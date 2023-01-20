<%-- 
    Document   : procesaFormulario
    Created on : 22 dic. 2022, 16:45:57
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de Procesar el Formulario</h1>
        Usuario: <%= request.getParameter("usuario") %>
        <br>
        Password: <%= request.getParameter("password") %>
        <br>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
