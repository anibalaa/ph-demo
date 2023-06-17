<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Motivos</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <div class="row">
        <div class="table-responsive">
            <div class="col-md-6">
                <table id="tEstadoProyecto" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Descripci�n</th>
                            <th scope="col">Acci�n</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.listaDeMotivos}" var="ep">
                        <tr>
                            <td>
                                <c:out value="${ep.descripcion}"></c:out>
                            </td>
                            <td>
                                <a href="EliminarMotivo.do?idMotivo=${ep.idMotivo}" onclick="return confirmar()">Eliminar</a>
                                <a href="ModificarMotivo.do?idMotivo=${ep.idMotivo}">Modificar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <a href="protegido/admin/form/motivos/insertarMotivos.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>