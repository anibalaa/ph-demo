<%@ include file="/includes/include.jsp"%>
<body>
    <script>
                    $(document).ready(function() {
                        $('#tEstadoProyecto').DataTable();
                    });
                </script>
    <p>
    <h1>Recorrido</h1>
    <table class="table table-responsive table-bordered">
        <thead>
            <tr>
                <th scope="col">idRecorrido</th>
                <th scope="col">idPersona</th>
                <th scope="col">idTratamiento</th>
                <th scope="col">idPrograma</th>
                <th scope="col">idFase</th>
                <th scope="col">idGrupo</th>
                <th scope="col">Fecha Inicio</th>
                <th scope="col">Fecha Fin</th>
                <th scope="col">Activo</th>
                <th scope="col">idMotivo</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${sessionScope.recorrido.idRecorrido }" />
                </td>
                <td>
                    <c:catch var="catchtheException">
                        <c:out value="${sessionScope.recorrido.persona.getIdPersona() }" />
                    </c:catch>
                    <c:if test="${catchtheException != null }">
                        <p>
                            The type of exception is: ${catchtheException }
                            <br />
                            There is an exception: ${catchtheException.message }
                        </p>
                    </c:if>
                </td>
                <td>
                    <c:catch var="catchtheException">
                        <c:out value="${sessionScope.recorrido.tratamiento.getIdTratamiento() }" />
                    </c:catch>
                    <c:if test="${catchtheException != null }">
                        <p>
                            The type of exception is: ${catchtheException }
                            <br />
                            There is an exception: ${catchtheException.message }
                        </p>
                    </c:if>
                </td>
                <td>
                    <c:out value="${sessionScope.recorrido.programa.getIdPrograma() }" />
                </td>
                <td>
                    <c:out value="${sessionScope.recorrido.fase.getIdFase() }" />
                </td>
                <td>
                    <c:out value="${sessionScope.recorrido.grupo.getIdGrupo() }" />
                </td>
                <td>
                    <fmt:formatDate pattern="dd-MM-yyyy" value="${sessionScope.recorrido.fechaInicio }" />
                    <%--                 <fmt:formatDate pattern="yyyy-MM-dd"  value--%>
                    <%--                 <c:out value="${sessionScope.recorrido.fechaInicio }" /> --%>
                </td>
                <td>
                    <fmt:formatDate pattern="dd-MM-yyyy" value="${sessionScope.recorrido.fechaFin }" />
                    <%--                 <fmt:formatDate pattern="yyyy-MM-dd"  value--%>
                    <%--                 <c:out value="${sessionScope.recorrido.fechaFin }" /> --%>
                </td>
                <td>
                    <c:out value="${sessionScope.recorrido.activo }" />
                </td>
                <td>
                    <c:out value="${sessionScope.recorrido.motivo.getIdMotivo() }" />
                </td>
            </tr>
        </tbody>
    </table>
    <br />
    <br />
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>