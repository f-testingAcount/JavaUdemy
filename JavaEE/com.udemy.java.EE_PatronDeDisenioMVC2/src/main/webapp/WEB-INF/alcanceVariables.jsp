<%-- 
    Document   : alcanceVariables
    Created on : 30 dic. 2022, 17:07:46
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/>
        Variable en alcance request:
        <br/>
        Base: ${rectanguloRequest.base}
        <br/>
        Altura: ${rectanguloRequest.altura}
        <br/>
        Area: ${rectanguloRequest.area}
        <br/>
        <br/>
        
        Variable en alcance session:
        <br/>
        Base: ${rectanguloSesion.base}
        <br/>
        Altura: ${rectanguloSesion.altura}
        <br/>
        Area: ${rectanguloSesion.area}
        <br/>
        <br/>
        
        Variable en alcance application:
        <br/>
        Base: ${rectanguloAplicacion.base}
        <br/>
        Altura: ${rectanguloAplicacion.altura}
        <br/>
        Area: ${rectanguloAplicacion.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
    </body>
</html>
