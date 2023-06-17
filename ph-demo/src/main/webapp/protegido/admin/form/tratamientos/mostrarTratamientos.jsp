<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Tratamientos</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <div class="row">
        <div class="table-responsive">
            <div class="col-md-6">
                <table id="tEstadoProyecto" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Descripción</th>
                            <th scope="col">Acción</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.listaDeTratamientos}" var="ep">
                        <tr>
                            <td>
                                <c:out value="${ep.descripcion}"></c:out>
                            </td>
                            <td>
                                <a href="EliminarTratamiento.do?idTratamiento=${ep.idTratamiento}" onclick="return confirmar()">Eliminar</a>
                                <a href="ModificarTratamiento.do?idTratamiento=${ep.idTratamiento}">Modificar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <a href="protegido/admin/form/tratamientos/insertarTratamientos.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>