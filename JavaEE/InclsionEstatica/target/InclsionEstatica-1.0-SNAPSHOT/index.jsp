<%-- 
    Document   : index
    Created on : 26 dic. 2022, 20:03:12
    Author     : user
--%>


<%-- INCLUSION DE ARCHIVOS UTILIZANDO JSPs
     Esto implica incluir un jsp dentro de otro. Basicamente existen dos formas:
     1- INCLUSION ESTATICA (translation time) inclusion en tiempo de traduccion.
        La directiva a utilizar es: <%@ include file="paginaRelativa.jsp" %>
     
2- INCLUSION DINAMICA (request time) inclusion en tiempo de ejecucion
        La accion a utilizar es (en este caso se utiliza una accion en lugar de una directiva): <jsp:include page="paginaRelativa.jsp" />

        INCLUSION ESTATICA: 
        El objetivo es reutilizar codigo en texto plano que generalmente proviene de html o jsp.
        En este caso el jsp que se incluye puede afectar o compartir info con el jsp incluyente.
        En este caso no se delega el control al jsp incluido, sin que se incluye el archivo jsp, generando un unico jsp resultante de los jsps componentes
        El jsp se compila en un servlet dado que es necesario la clase java para poder ejecutar el jsp asociado.
        Por lo anterior, se pueden tener variables o metodos que se complarten entre los diferentes jsps que estemos utilizando.
        Con la inclusion estatica para obtener la verision mas reciente del jsp que estamos incluyendo se recomienda complilar y reconstruir 
        nuevamente el proyecto. La inclusion estatica no garantiza que tengamos la ultima version del jsp incluido, esto se debe a que el contenido
        del jsp incluido se va a vaciar en el jsp principal.  
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusion Estatica</title>
    </head>
    <body>
        <h1>Inclusion Estatica</h1>
        <br/>
        <!-- Incluimos dos elementos del tipo html. Puede ser otro tipo de archivo. En este caso incluimos un elemento del tipo html y otro del tipo jsp 
             utilizando la inclusion estatica -->
        <ul>
            <li> <%@include file="paginas/noticias1.html" %> </li>
            <li> <%@include file="paginas/noticias2.jsp" %> </li>
        </ul>
    </body>
</html>
