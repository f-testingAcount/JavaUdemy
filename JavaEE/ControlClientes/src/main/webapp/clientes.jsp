<%-- 
    Document   : clientes
    Created on : 31 dic. 2022, 17:57:49
    Author     : user
--%>



<%-- El prefijo c refiere a la libreria de core que vamos a utilizar y la uri es el de la libreria de jstl de core --%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <%--
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e4eb3fadfc.js" crossorigin="anonymous"></script>
        --%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/e4eb3fadfc.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        <%-- Cabecero --%>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <%-- Botones de navegacion --%>
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

        <%-- Listado Clientes --%>
        <jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>

        <%-- Pie de pagina --%>
        <jsp:include page="/WEB-INF/paginas/comunes/piepagina.jsp"/>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>    
    </body>
</html>
