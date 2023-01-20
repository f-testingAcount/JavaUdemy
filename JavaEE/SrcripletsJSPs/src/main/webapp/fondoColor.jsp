<%-- 
    Document   : fondoColor
    Created on : 22 dic. 2022, 17:31:39
    Author     : user
--%>

<!DOCTYPE html>

<% 
    String fondo = request.getParameter("colorFondo");
    if (fondo == null || fondo.trim().equals("")) {
            fondo = "white";
        }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cambio de Color</title>
    </head>
    <body bgcolor="<%=fondo%>">
        <h1>JSP Cambio de Color</h1>
        <br>
        Color de fondo aplicado: <%=fondo%>
        <br>
        <a href="index.html">Volver al inicio</a>
    </body>
</html>
