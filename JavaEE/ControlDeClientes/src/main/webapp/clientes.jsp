<%-- 
    Document   : clientes
    Created on : 18 ene. 2023, 22:56:11
    Author     : user
--%>



<!DOCTYPE html>
<html>
    <head>
        <%-- Plantilla Bootstrap --%>
        <!-- Required meta tags -->
        <jsp:include page="/WEB-INF/paginas/comunes/plantillaBootstrapHead.jsp"/>
        <title>Control de Clientes</title>
    </head>
    <body>
        <%-- Cabecero utlilizando bootstrap --%>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <%-- Botones de Navegacion --%>
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <%-- Listado de Clientes --%>
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        
        <%-- Pie de Pagina --%>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        
        <%-- Links Bootstrap --%>
        <jsp:include page="/WEB-INF/paginas/comunes/plantillaBootstrapBody.jsp"/>
    </body>
</html>
