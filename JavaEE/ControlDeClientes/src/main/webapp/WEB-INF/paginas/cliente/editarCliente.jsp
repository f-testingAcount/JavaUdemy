<%-- 
    Document   : editarCliente
    Created on : 19 ene. 2023, 19:22:18
    Author     : user
--%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/WEB-INF/paginas/comunes/plantillaBootstrapHead.jsp"/>
    </head>
    <body>
        <%-- Cabecero utlilizando bootstrap --%>
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" 
              method="POST" class="was-validated">

            <%-- Editar clientes Botones de Navegacion--%>
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">email</label>
                                        <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>
                                        <input type="number" class="form-control" name="saldo" required step="any" value="${cliente.saldo}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
        <%-- Pie de Pagina --%>
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <%-- Links Bootstrap --%>
        <jsp:include page="/WEB-INF/paginas/comunes/plantillaBootstrapBody.jsp"/>
    </body>
</html>
