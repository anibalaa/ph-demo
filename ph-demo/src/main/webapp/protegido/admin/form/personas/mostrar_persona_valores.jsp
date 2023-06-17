<%@ include file="/includes/include.jsp"%>
<body>
    <script type="text/javascript">
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Persona / Recorridos</h1>
    <br />
    <br />
    <table>
        <thead>
            <tr>
                <th colspan="4">Persona</th>
            </tr>
            <tr>
                <th>NOMBRE</th>
                <th>APELLIDO1</th>
                <th>APELLIDO2</th>
                <th>ACTIVO</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${sessionScope.persona.nombre }" />
                </td>
                <td>
                    <c:out value="${sessionScope.persona.apellido1}" />
                </td>
                <td>
                    <c:out value="${sessionScope.persona.apellido2}" />
                </td>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.persona.activo == 1}">Si</c:when>
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
                <th colspan="8">Recorridos</th>
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
            <c:forEach items="${sessionScope.listaDeRecorridos}" var="ep">
                <tr>
                    <td>
                        <c:out value="${ep.fechaInicio }" />
                    </td>
                    <td>
                        <c:out value="${ep.fechaFin }" />
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
                        <a href="ModificarRecorrido.do?idRecorrido=${ep.idRecorrido}">Modificar</a>
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
