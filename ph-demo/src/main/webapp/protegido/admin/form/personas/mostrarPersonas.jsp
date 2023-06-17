<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Personas</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <div class="row">
        <div class="table-responsive">
            <div class="col-md-8">
                <table id="tEstadoProyecto" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido 1</th>
                            <th scope="col">Apellido 2</th>
                            <th scope="col">Activo</th>
                            <th scope="col">Acción</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.listaDePersonas}" var="ep">
                        <tr>
                            <td>
                                <c:out value="${ep.nombre}"></c:out>
                            </td>
                            <td>
                                <c:out value="${ep.apellido1}"></c:out>
                            </td>
                            <td>
                                <c:out value="${ep.apellido2}"></c:out>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${ep.activo == 1}">Si</c:when>
                                    <c:otherwise>
                      No
                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a href="EliminarPersona.do?idPersona=${ep.idPersona}" onclick="return confirmar()">Eliminar</a>
                                <a href="ModificarPersona.do?idPersona=${ep.idPersona}">Modificar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <a href="protegido/admin/form/personas/insertarPersonas.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>