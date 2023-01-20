<%-- 
    Document   : index
    Created on : 29 dic. 2022, 16:23:51
    Author     : user
--%>

<%--  
    JSTL (JAVA SERVER PAGES STANDARD TAG LIBRARY)
    
    JSTL extiende los tags de los JSPs, agregando principalmente las siguientes librerias:
    
    core: Permite leer y manipular datos, asi como iterar, agregar condiciones y otras funciones basicas.
    
    xml: Tambien tiene esta libreria que permite la mamipulacion y transformacion de documentos xml en jsps

    sql: Permite ejecutar consultas a una Base de Datos, asi como crear conexiones a las mismas.

    fmt: Permite dar formato a las cadenas, apoyado de conceptos como Internacionalizacion(Locale)

    CONFGURACION DE JSTL
    Se deben agregar las siguientes librerias al Classpath (no es necesario si el servidor web como Glassfish ya cuenta con ellas):
    standard.jar, jstl.jar
    
    Configuracion de la directiva JSP:
    JSP clasico:
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    Documento JSP (jspx) 
    <html
        xmlns:c = "http://java.sun.com/jsp/jstl/core"
        xmlns:jsp = "http://java.sun.com/JSP/Page" >

    LIBRERIA CORE DE JSTL
    Tags de despliegue de info
    <c:out value="${persona.nombre}">
    
    Tags de creacion y manipulacion de variables:
    <c:set var="nombre" value="Carlos" scope="page" />

    Tags de elementos condicionales: con esto evitamos el uso de scriplets
    <c:if test="${i > 0} />   y    <c:choose> <c.when test="a">

    Tags de iteracion de elementos:
    <c:forEach var="persona" items="${personas}">

    Tags de importacion de recursos web:
    <c:import url = "recursosInternoExterno">

    Tags de redireccionamiento:
    <c:redirect url="${nuevaUrl} />

    Tags de manejo de parametros:
    <c:import url="c-impor-param.jsp">
        <c:param name = "nombre" value = "${param.select}" />
    </c:import>
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <h1>JSTL (Jsp Standard Tag Library)</h1>
        <br/>
        <br/>
        <a  href="jstlCore.jsp?opcion=1">Ir al JSP de JSTL Core</a>
        
    </body>
</html>
