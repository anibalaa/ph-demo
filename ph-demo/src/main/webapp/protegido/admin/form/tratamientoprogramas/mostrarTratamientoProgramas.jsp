<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>TratamientoProgramas</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <div class="row">
        <div class="table-responsive">
            <div class="col-md-6">
                <table id="tEstadoProyecto" class="table table-striped">
                    <thead>
                        <tr>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.listaDeTratamientoProgramas}" var="ep">
                        <tr>
                            <td>
                                <a href="EliminarTratamientoPrograma.do?idTratamientoPrograma=${ep.idTratamientoPrograma}" onclick="return confirmar()">Eliminar</a>
                                <a href="ModificarTratamientoPrograma.do?idTratamientoPrograma=${ep.idTratamientoPrograma}">Modificar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <a href="protegido/admin/form/tratamientoprogramas/insertarTratamientoProgramas.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>