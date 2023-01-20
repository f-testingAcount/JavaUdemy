<%-- 
    Document   : index
    Created on : 26 dic. 2022, 23:19:18
    Author     : user
--%>

<%--
    INCLUSION DINAMICA
    Sintaxis: <jsp:include page="paginaRelativa.jsp" />  En este caso utilizamos una accion
    El objetivo de la inclusion dinamica es reutilizar codigo en texto plano, html o jsps tambien permite actualizar el contenido sin alterar
    al jsp que incluye el contenido a reutilizar a diferencia de la inclusion estatica donde se mezclan los contenidos de los jsps y se puede alterar 
    al jsp principal debido a la inclusion de otro jsp en este caso (inclusion dinamica) no se mezclan los contenidos.
    El jsp prinicipal delega el control al jsp incluido y la salida del jsp se agrega al jsp principal. La ejecucion no se mezcla solo se integra la salida
    resultante.
    A diferencia de la inclusion estatica no se comparten variables o metodos entre los jsps pero se garantiza tener siempre la version mas reciente de los
    jsps ya que no se genera un solo servlet sin uno por cada jsp.
    la pagina debe ser la relativa a la aplicacion web (uso de /)
    Se pueden incluir archivos privados (desde la carpeta WEB-INF)

--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusion Dinamica</title>
    </head>
    <body>
        <h1>Inclusion Dinamica</h1>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp" />
        <jsp:include page="WEB-INF/recursoPrivado.jsp" >
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
