<%-- 
    Document   : desplegarVariables
    Created on : 30 dic. 2022, 13:33:14
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en alcance de request: ${mensaje}
        <br/>
        <br/>
        Variable en alcance de session: 
        <br/>
        Rectangulo:
        <br/>
        Base: ${rectangulo.base}
        <br/>
        Altura: ${rectangulo.altura}
        <br/>
        Area: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
    </body>
</html>
