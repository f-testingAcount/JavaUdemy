<%-- 
    Document   : reporteExcel
    Created on : 23 dic. 2022, 17:35:07
    Author     : user
--%>

<%-- %@page contentType="text/html" pageEncoding="UTF-8"%> QUITAMOS ESTA DIRECTIVA Y LA LINEA DE CODIGO META DADO QUE NO VAMOS A RESPONDER CON TEXTO HTML --%>

<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%@page errorPage="WEB-INF/manejoErrores.jsp" %>

<%-- El JSP del manejo de errores es recomendable que sea privado o sea que no sea accesible desde el navegador directamente entonces lo recomendable es 
que este dentro de la carpeta WEB-INF ya que todos los jsps y recursos que esten dentro de esta carpeta no van a ser accesibles directamente desde el 
navegador. Solamente los componentes de la aplicacion como en este caso los jsps u otro Servlet puede acceder a info dentro la carpeta WEB-INF --%>

<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<%-- Con este Scriptlet indicamos el tipo de contenido que vamos a responder desde este JSP. Agrgamos el cabecero de Content-Disposition 
indicando que vamos a descargar un archivo (attachment) de excel y pasamos el nombre del archivo.--%>

<!DOCTYPE html>
<html>
    <head>
        <%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de java</td>
                <td>Aprendemos la sintaxis basica de java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2. Programacion con java</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
