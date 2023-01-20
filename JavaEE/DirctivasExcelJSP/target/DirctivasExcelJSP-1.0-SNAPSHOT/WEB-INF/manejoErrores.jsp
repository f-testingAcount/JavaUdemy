<%-- 
    Document   : manejoErrores
    Created on : 23 dic. 2022, 21:04:52
    Author     : user
--%>

<%@page isErrorPage="true" %> <%-- Con esta directiva en true indicamos que esa va a ser la pagina que va a menejar errores y vamos a tener acceso directo
al objetro implicito llamado Exception que es el que contiene la excepcion que se ha generado en el otro JSP --%>
<%@page import="java.io.*" %> <%-- Importamos la clase java.io a fin de poder utilizar la clase PrintWriter para imprimir la excepcion que se lanzo --%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Manejo Errores</title>
    </head>
    <body>
        <h1>JSP Manejo Errores</h1>
        <br/>
        Ocurrio una excepcion: <%= exception.getMessage() %>  <%-- Por medio de una expresion accedemos al mensaje que se ha lanzado a traves de el objeto exception --%>
        <br/>
        <textarea cols="30" rows="5">
            <% exception.printStackTrace(new PrintWriter(out)); %>  <%-- Por medio de este Scriptlet imprimimos el detalle de la excepcion --%>
        </textarea>
    </body>
</html>
