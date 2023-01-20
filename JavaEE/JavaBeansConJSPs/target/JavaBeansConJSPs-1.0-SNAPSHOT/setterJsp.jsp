<%-- 
    Document   : setterJsp
    Created on : 27 dic. 2022, 15:54:45
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica a un Java Beans</title>
    </head>
    <body>
        <h1>JSP que modifica a un Java Beans</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />  <!-- scope (alcance) tenemos varios alcances request (el mas
                                                                                                   basico), session y application. El alcance de request 
                                                                                                   la info del java beans solo perdura durante la peticion
                                                                                                   del cliente servidor, al concluir la peticion desaparece
                                                                                                   la info. El alcance de session perdura durante la session
                                                                                                   y solo va a desaparecer luego de 30 minutos de inactivi
                                                                                                   dad o cuando bajemos la app al detenerse el servidor. El
                                                                                                   alcance de application va a perdurar mientras la app este
                                                                                                   arriba y solo se destruye cuando se cierra la app.-->
        Modificamos los atributos:
        <br/>
        <br/>
        <!-- Abrimos un scriptlet y definimos dos variables para modificar los valores de base y altura -->
        <% 
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>" />
        
        Nuevo valor base: <%=baseValor%>
        <br/>
        Nuevo valor altura: <%=alturaValor%>
        <br/>
        <br/>
        <a href="index.jsp">Volver al inicio</a>
    </body>
</html>
