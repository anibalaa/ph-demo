<%@ include file="/includes/include.jsp"%>
<body>
    <p>
    <h1>TratamientoProgramas2</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <table id="tEstadoProyecto" class="table table-striped">
        <thead>
            <tr>
                <th>idTratamientoPrograma</th>
                <th>idTratamiento</th>
                <th>idPrograma</th>
                <th>Acción</th>
            </tr>
        </thead>
        <tbody>
<%--             <c:forEach items="${requestScope.listaDeTratamientoProgramas}" var="ep"> --%>
            <c:forEach items="${requestScope.listaDeTratamientoProgramas}" var="ep">
                <tr>
                    <td>
                        <c:out value="${ep.idTratamientoPrograma }">${ep.idTratamientoPrograma }</c:out>
                    </td>
                    <td>
                        <c:out value="${ep.tratamiento.idTratamiento }">${ep.tratamiento.idTratamiento }</c:out>
                    </td>
                    <td>
                        <c:out value="${ep.programa.idPrograma }">${ep.programa.idPrograma }</c:out>
                    </td>
                    <td>
                        <a href="EliminarTratamientoPrograma.do?idTratamientoPrograma=${ep.idTratamientoPrograma}" onclick="return confirmar()">Eliminar</a>
                        <a href="ModificarTratamientoPrograma.do?idTratamientoPrograma=${ep.idTratamientoPrograma}">Modificar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <select name="prueba">
            <c:forEach items="${requestScope.listaDeTratamientoProgramas}" var="tp">
                <option value="${tp.idTratamientoPrograma}">${tp.idTratamientoPrograma}</option>
            </c:forEach>
        </select>
    <a href="protegido/admin/form/tratamientoprogramas/insertarTratamientoProgramas.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>