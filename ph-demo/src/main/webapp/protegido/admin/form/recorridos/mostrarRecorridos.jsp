<%@ include file="/includes/include.jsp"%>
<script>
    $(document).ready(function() {
        $('#tEstadoProyecto').DataTable();
    });
</script>
<body>
    <p>
    <h1>Recorridos</h1>
    <table id="tEstadoProyecto" class="table table-responsive table-bordered">
        <thead>
            <tr>
                <th scope="col">Recorrido</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido 1</th>
                <th scope="col">Apellido 2</th>
                <th scope="col">Activo</th>
                <th scope="col">Tratamiento</th>
                <th scope="col">Programa</th>
                <th scope="col">Fase</th>
                <th scope="col">Grupo</th>
                <th scope="col">Motivo</th>
                <th scope="col">Fecha de Inicio</th>
                <th scope="col">Fecha de Fin</th>
                <th scope="col">Accion</th>
            </tr>
        </thead>
        <tbody>
            <c:catch var="catchtheException">
                <c:forEach items="${requestScope.listaDeRecorridos}" var="ep">
                    <tr>
                        <td>
                            <c:out value="${ep.idRecorrido}" />
                        </td>
                        <td>
                            <c:out value="${ep.persona.nombre}" />
                        </td>
                        <td>
                            <c:out value="${ep.persona.apellido1}" />
                        </td>
                        <td>
                            <c:out value="${ep.persona.apellido2}" />
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
                            <c:out value="${ep.tratamiento.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${ep.programa.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${ep.fase.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${ep.grupo.descripcion}" />
                        </td>
                        <td>
                            <c:out value="${ep.motivo.descripcion}" />
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${ep.fechaInicio == ''}">""</c:when>
                                <c:otherwise>
                                    <fmt:formatDate pattern="dd-MM-yyyy" value="${ep.fechaInicio}" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${ep.fechaFin == ''}">""</c:when>
                                <c:otherwise>
                                    <fmt:formatDate pattern="dd-MM-yyyy" value="${ep.fechaFin}" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="EliminarRecorrido.do?idRecorrido=${ep.idRecorrido}" onclick="return confirmar();">Eliminar</a>
                            <a href="ModificarRecorrido.do?idRecorrido=${ep.idRecorrido}">Modificar</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:catch>
        </tbody>
    </table>
    <!--     <a href="protegido/admin/form/recorridos/insertarRecorridos.jsp">Insertar</a> -->
    <%@ include file="/includes/pie.jsp"%>
    <c:if test="${catchtheException != null }">
        <p>
            The type of exception is: ${catchtheException }
            <br />
            There is an exception: ${catchtheException.message }
        </p>
    </c:if>
</body>
</html>