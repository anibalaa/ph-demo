<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript">
    function marcartodos() {
        $(":checkbox").prop('checked', true);
    }
    function borrartodos() {
        $(":checkbox").prop('checked', false);
    }
    function getProgramasRelacionadosConTratamiento(value) {
        console.log("idTratamiento: " + value);
        JsTratamientoBean.getProgramasRelacionadosConTratamiento(value, populate);
    }
    function populate(list) {
    	var marcados = [];
        $(":checkbox").prop('checked', false);
        list.forEach(function(element) {
            console.log("idPrograma: " + element.idPrograma);
            $('input[type=checkbox]').each(function() {
                if (this.value == element.idPrograma) {
                    $(this).prop('checked', true);
                    marcados.push(this.value);
                }
            });
        });
        console.log(marcados);
        // pasamos desde javaScript a Java mediante el input hidden
        $("#listaDeProgramasEnBD").val(marcados);
        console.log($("#listaDeProgramasEnBD").val());
    }
</script>
<body>
    <h1>Tratamiento - Programa</h1>
    <h4>Seleccione los Programas a asignar a un Tratamiento</h4>
    <br>
    <form method="post" action="ProcesarTratamientoPrograma.do" accept-charset="utf-8">
        <table>
            <thead>
                <tr>
                    <th>Listado de Tratamientos:</th>
                    <th>
                        <select name="idTratamiento" onchange="javascript:getProgramasRelacionadosConTratamiento(this.value)">
                            <option value="" selected></option>
                            <c:forEach items="${requestScope.listaDeTratamientos }" var="ep1">
                                <option value="${ep1.getIdTratamiento() }">${ep1.getDescripcion() }</option>
                            </c:forEach>
                        </select>
                    </th>
                    <th>
                        <input type="submit" value="Establecer asociación" />
                    </th>
                    <th>
                        <input type="button" value="marcar todos" onclick="javascript:marcartodos()" />
                    </th>
                    <th>
                        <input type="button" value="borrar todos" onclick="javascript:borrartodos()" />
                    </th>
                </tr>
            </thead>
        </table>
        <p />
        <table>
            <thead>
                <tr>
                    <th>Listado de Programas</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listaDeProgramas }" var="ep2">
                    <!--                 cada 8 tds, se se podría saltar de columna para aprobechar la pantalla -->
                    <tr>
                        <td>
                            <input type="checkbox" name="programa" value="${ep2.getIdPrograma() }" />
                            <c:out value="${ep2.getDescripcion() }" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="hidden" name="listaDeProgramasEnBD" id="listaDeProgramasEnBD">
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>
