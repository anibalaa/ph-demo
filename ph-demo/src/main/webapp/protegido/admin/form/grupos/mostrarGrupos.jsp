<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Grupos</h1>
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
                    <c:forEach items="${requestScope.listaDeGrupos}" var="ep">
                        <tr>
                            <td>
                                <c:out value="${ep.descripcion}"></c:out>
                            </td>
                            <td>
                                <a href="EliminarGrupo.do?idGrupo=${ep.idGrupo}" onclick="return confirmar()">Eliminar</a>
                                <a href="ModificarGrupo.do?idGrupo=${ep.idGrupo}">Modificar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <a href="protegido/admin/form/grupos/insertarGrupos.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>