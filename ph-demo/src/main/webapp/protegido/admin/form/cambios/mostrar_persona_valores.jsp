<%@ include file="/includes/include.jsp"%>
<body>
    <script type="text/javascript">
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Persona / Recorridos activos</h1>
    <br />
    <br />
    <table>
        <thead>
            <tr>
                <th>Persona</th>
            </tr>
            <tr>
                <th>Nombre</th>
                <th>Apellido 1</th>
                <th>Apellido 2</th>
                <th>Activo</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${requestScope.persona.nombre }" />
                </td>
                <td>
                    <c:out value="${requestScope.persona.apellido1}" />
                </td>
                <td>
                    <c:out value="${requestScope.persona.apellido2}" />
                </td>
                <td>
                    <c:choose>
                        <c:when test="${requestScope.persona.activo == 1}">Si</c:when>
                        <c:otherwise>
                      No
                    </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </tbody>
    </table>
    <br />
    <table>
        <thead>
            <tr>
                <th>Recorridos</th>
            </tr>
            <tr>
                <th>Fecha Inicio</th>
                <th>Fecha Fin</th>
                <th>Tratamiento</th>
                <th>Programa</th>
                <th>Fase</th>
                <th>Grupo</th>
                <th>Activo</th>
                <th>ACCION</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.listaDeRecorridos}" var="ep">
                <tr>
                    <td>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${ep.fechaInicio }" />
                    </td>
                    <td>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${ep.fechaFin }" />
                    </td>
                    <td>
                        <c:out value="${ep.tratamiento.descripcion }" />
                    </td>
                    <td>
                        <c:out value="${ep.programa.descripcion }" />
                    </td>
                    <td>
                        <c:out value="${ep.fase.descripcion }" />
                    </td>
                    <td>
                        <c:out value="${ep.grupo.descripcion }" />
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
                        <a href="EliminarRecorrido.do?idRecorrido=${ep.idRecorrido}" onclick="return confirmar()">Eliminar</a>
                        <a href="CambiarRecorrido.do?idRecorrido=${ep.idRecorrido}">Cambiar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <br>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>
