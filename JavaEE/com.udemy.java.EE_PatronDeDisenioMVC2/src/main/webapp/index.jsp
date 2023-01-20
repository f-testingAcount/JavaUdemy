<%-- 
    Document   : index
    Created on : 30 dic. 2022, 15:52:06
    Author     : user
--%>

<!DOCTYPE html>

<!-- PATRON DE DISEÑO MVC (MODELO VISTA CONTROLADOR) MODEL VIEW CONTROLLER
    Un patron de diseño nos facilita el diseño de aplicaciones web en este caso el MVC
    Algo que es importante es separar la vista de los datos y unirlos por un componente que hace las veces de controlador y los datos hacen las
    veces del modelo.
    Los Servlets estan enfocados en controlar el flujo de la app web procesando las peticiones http y utilizan los java beans para almacenar la info
    y finalmente redireccionar al jsp respectivo. 
    Los jsp estan enfocados en desplegar la info de la app web. La info la proveen los servlets. La info que se comparte entre estos componentes
    (servlets y jsps) suele manejarce con javabeans.
    El patron de disño MVC nos permite integrar a los jsps (vista), a los sevlets(Controlador) y a los javabeans (modelo)
    FRAMEWORKS QUE UTILIZAN EL PATRON MVC
    JSP/SERVLETS: Se implementa manualmente con la ayuda del objeto RequestDispatcher para controlar el flujo de la aplicacion.
    STRUTS: Es un framework de Apache el cual utiliza jsps(vista) con tags de Struts, ActionForm (modelo), Action (Controlador), entre otros componentes.
    JAVASERVER FACES (JSF): Es una tecnologia que utiliza conceptos como jsps (vista) con tags de JSF, ManagedBeans (Controlador) y JavaBeans (Modelo)
    SPRINGMVC: Es una extension del framework de Spring, qe utiliza jsps (vista) con tags de Spring, Clases Java (Controladores) y JavaBeans (Modelo)
    EXISTEN VARIOS FRAMEWORKS MAS.

    ARQUITECTURA MVC CON JSPs Y SERVLETS
    En principio, el flujo comienza del lado del cliente con un formulario html y se envia la peticion post o get al servidor luego, el Servlet 
    controlador procesa los parametros del formulario html si es que aplica y luego el flujo continua hacia un javaBeans que almacena o procesa la
    info de logica de negocio o logica de presentacion de la app web. Ya creada y almacenada la info en el javaBeans se regresa el control al servlet
    el cual puede colocar al javaBeans en algun alcance para compartir la info hacia un jsp. El alacance puede ser request, session o application. El
    alcance de page no aplica en los servlets, solo en los jsps. Una vez que el servlet controlador ha colocado los javaBeans en algun alcance produce
    un redireccionamiento mediante el objeto request dispatcher. En este punto el servlet controlador decide cual jsp (vista) va a utilizar, esto depende 
    del flujo de la app web. El jsp seleccionado va a jugar el rol de la vista, lo cual implica que unicamente va a recuperar la info que le ha compartido 
    el servlet. Los jsps en teoria no deberian crear nuevos objetos java, para ello toda la info que va a utilizar el jsp ya debio haber sido procesada
    por el servlet controlador. Una vez que el jsp genera el html con la info del javaBeans que el servlet controlador le proporciono lo que hace es
    mostrale el contenido al cliente generado por un render segun el contentType que se haya utilizado; puede ser html, excel, pdf, video, audio, etc.
    En definitiva el jsp va a desplegar la info que recibio del servlet contolador para mostrarsela al cliente. Con esto concluye el flujo y si se 
    ejecuta otra peticion se repite el proceso descripto.
    Este diagrama se enuentra en la clase 238 de udemy/universidadJava.

    PASOS GENERALES DE UN SERVLET CONTROLADOR:
    a) Procesamos y validamos los parametros (si aplica): request.getParameter("nombreParametro");
    b) Realizamos la logica de presentacion almacenando el resultado en objetos javaBeans:    Rectangulo rec = new Rectangulo();
    c) Compartimos el objeto beans a utilizar en algun alcance (scope)
       request.seAttribute("rectanguloBean", rec); Se utiliza el mapa llave, valor (key, value)
    d) Redireccionamos al jsp seleccionado
       RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
       Luego por medio del objeto dispatcher ejecutamos un forward, es decir que , enviamos la info al jsp seleccionado por lo cual enviamos los objetos
       request y response a este jsp y asi la info que compartimos en cualquiera de los alcances le va a llegar directamente al jsp llamado resultado.jsp
       dispatcher.forward(request, response);
    
-->
<html>
    <head>
        <title>Patron de Diseño MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Patron de Diseño MVC 2 (Model View Controler)</h1>
        <br/>
        <div style="color: red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet Controlador SIN parametros
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Link al Servlet Controlador para agregar las variables.
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al Servlet Controlador para listar las variables.
        </a>
    </body>
</html>
