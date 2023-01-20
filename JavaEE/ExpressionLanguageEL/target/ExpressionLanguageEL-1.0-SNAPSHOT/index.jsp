<%-- 
    Document   : index
    Created on : 29 dic. 2022, 12:38:32
    Author     : user
--%>

<!--  
    EXPRESSION LANGUAGE
    EL nos permite simplificar el despliegue de informacion en un JSP utilizndo Java Beans.
    
    Sintaxis con ACCIONES jsp:
    jsp:useBean id="nombreBean" class="ClaseBean"  (no abrimos y cerramos la accion pq aun adentro el comentario la toma como valida < />
    jsp:getProperty name="nombreBean" propiedad="nombrePropiedad" 
    
    SINTAXIS CON EXPRESSION LANGUAGE:
    <%-- ${nombreBean.nombrePropiedad} 
         ${nombreBean["nombrePropiedad"]} Cualquiera de las dos sintaxis funciona (la segunda es del estilo arreglos)
    --%>
    CARACTERISTICAS DE EL
    Los objetos JavaBean a utilizar se deben agregar previamente en algun alcance (scope) por medio del metodo setAttribute() en un Servlet
    page, request, session, application.
    
    La notacion es muy simplificada, pero solo permite la lectura de informaicn (getters). No existe notacion para la modificacion de los atributos
    en un JavaBeans (setters). EL se concentra en leer la info y mostrarla en el jsp. 
    EL permite acceder a propiedades de un JavaBean de manera anidada, por ejemplo:
    <%-- ${alumno.direccion.calle} --%>

    EL nos permite acceder a propiedades de un objeto del tipo Collection o Arreglos
    <%-- ${listaPersonas[indice/llave]} --%>
    Con EL no es posible iterar los elementos, para ello debemos usar JSTL que tiene funciones iterativas

    EL genera conversiones automaticas de tipos de datos al desplegar la info.
    Manejo automatico de valores null o vacios, convirtiendolos en cadenas vacias para evitar excepciones del tipo null pointer exception.

    Se pueden utilizar operadores <%-- ${ 3 + 2 / 2} tambien se puede usar >= > y < --%>

    ACCESO A VARIABLES IMPLICITAS CON EL
    Objeto pageContext <%-- ${pageContext.session.id} --%>
    Valores de parametros con param y paramValues
    Valores de cabeceros con header y headerValues <%-- ${header["user-Agent"]} --%>
    Valores con el objeto cookie <%-- ${cookie.nombreCookie.value} --%>
    Tambien podemos acceder a los valores de atributos agregados en algun alcance con pageScope, requestScope, sessionScope, applicationScope
    Ej: <%-- ${sessionScope.rectangulo.area} o ${rectangulo.area} --%>
-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression Language EL</title>
    </head>
    <body>
        <h1>Expression Language EL</h1>
        <br/>
        <a href="variablesImplicitas.jsp?usuario=juan">Objetos implicitos con EL</a>
    </body>
</html>
