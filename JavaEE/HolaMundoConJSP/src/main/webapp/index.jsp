<%-- 
    Document   : index
    Created on : 21 dic. 2022, 21:10:56
    Author     : user
--%>



<%-- Los JSPs son componentes del lado del servidor web especializados en manejar codigo html e incrustar codigo java por medio de etiquetas (tags) 
     Los JSPs son utilizados como componentes de PRESENTACION que nos muestran la info procesada por otros componentes como pueden ser los Servlets
     Un JSP cuando se compila crea indirectamente un Servlet asociado a este JSP. Este Servlet se genera de manera automatica y su formato es
     un archivo .class. En definitiva un JSP es un Servlet del lado del servidor web cuyo ciclo de vida es similar al de un Servlet.
     BENEFICIOS DE LOS JSPs:
     Los JSPs nos facilitan escribir codigo HTML haciendo mas facil el mantenimiento de la capa de presentacion.
     Se pueden utilizar herramientas de diseño para crear visualmente las paginas HTML e incrustar las etiquetas dinamicas de los JSPs.
     Nos posibilita separar el codigo de presentacion del codigo de java.
     La separacion de responsabilidades nos permite que cada integrante del equipo de desarrollo se pueda enfocar en tareas especificas.
     La lenguaje de JSP es similar al HTML en cuanto a la sintaxis de etiquetas.
     Los JSPs pueden incluir codigo java pero no es lo recomendable debido a que dificultaria el mantenimiento en funcion de que el aumento de 
     complejidad requeriria de desarrolladores mas especializados.
     CICLO DE VIDA DE UN JSP:
     1. Se traduce el JSP a un Servlet
     2. Se compila y se carga la clase del Servlet
     3. Se crea un subproceso del Servlet
     4. Se ejecuta el metodo init()
     5. Se ejecuta el metodo service()
     6. Se ejecuta el metodo destroy()
--%>

<%-- En JSPs ademas de los tags incorporamos el concepto de directivas 
     e inversamente a lo que ocurre en un Servlet podemos escribir directamente codigo HTML e incrustar codigo java
     (En un Servlet escribimos codigo java e incrustamos lenguaje HTML)
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%-- La linea de codigo meta que dejamos comentada a continuacion la eliminamos del codigo HTML dado que la misma sentencia ya la 
        tipeamos con la directiva <%@page ..... %> lineas arriba y seria redundante escribir lo mismo en distintos lenguajes por lo cual, en 
        funcion de que se genero automaticamente, la eliminamos. --%>
        
        <%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        
        <%--
            DESCRIPCION DE LAS DIRECTIVAS:
            <% %>         Scriplet dentro del cual podemos agrgar codigo java. El codigo java se inserta en el metodo service() del Servlet generado
            <%!           Declaraciones: codigo java. Se utiliza para declarar variables o metodos que pertenezcan a la clase del Servlet generado. 
                          A difencia del Srcriplet que esta dentro del metodo service() en el caso de las declaraciones como puede ser una variable se vuelve una
                          variable de instancia dado que pertenece a la clase del Servlet generado y no unicamente como una variable local a cierto metodo.
                          Los metodos que agregemos tambien son parte del Servlet generado. 
            <%--          Comentario (Se cierra de la misma manera en que se abre)
            <&= &>        Expresion. La expresion se evalua y se inserta en la salida del servlet. Es equivalente a un out.println(expresion). 
                          Invariablemente devuelve algo por lo tanto no puede ser del tipo void
            Sintaxis XML: Cada elemento JSP tiene su equivalente en sintaxis XML.
                          Esta sintaxis se utiliza para tener una mayor compatibilidad, por ejemplo, con herramientas visuales.
            
            VARIABLE IMPLICITAS EN LOS JSPs.
            request
            response
            out
            session
            application
            
        --%>
        
        <title>Sriptlets JSPs</title>
    </head>
    <body>
        <h1>Sriptlets JSPs</h1>
        <ul>
            <li> <% out.print("Hola mundo con Scriplets"); %> </li> 
                <%-- En jsps el out.print es el equivalente al PrintWriter en Servlets 
                Un jsp no es un simple archivo html, es un componente del lado del servidor que puede hacer llamadas directamente a una base de datos --%>
            <li>${"Hola mundo con expresion language, donde utilizamos el signo $ y las {}"}</li>
            <li> <%= "Hola mundo con expresiones" %> </li>
            <li> <c:out value="Hola Mundo con JSTL" /> </li>  <%-- JSTL JavaServer Pages Standard Tag Library --%>
        </ul>
    </body>
</html>
