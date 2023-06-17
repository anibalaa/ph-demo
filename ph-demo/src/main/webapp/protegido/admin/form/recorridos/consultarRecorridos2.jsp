<%@ include file="/includes/include.jsp"%>
<script>
    $(document).ready(function() {
        $('#tEstadoProyecto').DataTable();
    });
</script>
<body>
    <p>
    <h1>Consultar Recorridos Por Motivo</h1>
    <form method="post" role="form" action="${pageContext.request.contextPath}/MostrarRecorridoPorFiltro2.do" accept-charset="utf-8">
        <table id="tablaConsulta" class="table table-responsive table-bordered">
            <thead>
                <tr>
                    <th scope="col">Fecha de Inicio</th>
                    <th scope="col">Fecha de Fin</th>
                    <th scope="col">Motivo</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <input type="date" name="fechaDeInicio" required>
                    </td>
                    <td>
                        <input type="date" name="fechaDeFin" required>
                    </td>
                    <td>
                        <select id="sel-mot" name="motivo" required>
                            <option value="" selected></option>
                            <c:forEach items="${requestScope.listaDeMotivos}" var="ep">
                                <option value="${ep.idMotivo}">${ep.descripcion}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Buscar" />
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>