<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript">
    function marcartodos() {
        $(":checkbox").prop('checked', true);
    }
    function borrartodos() {
        $(":checkbox").prop('checked', false);
    }
    function getFasesRelacionadasConPrograma(value) {
        console.log(value);
        JsProgramaBean.getFasesRelacionadasConPrograma(value, populate);
    }
    function populate(list) {
        var marcados = [];
        $(":checkbox").prop('checked', false);
        list.forEach(function(element) {
            console.log(element.idFase);
            $('input[type=checkbox]').each(function() {
                if (this.value == element.idFase) {
                    $(this).prop('checked', true);
                    marcados.push(this.value);
                }
            });
        });
        console.log(marcados);
        // pasamos desde javaScript a Java mediante el input hidden
        $("#listaDeFasesEnBD").val(marcados);
        console.log($("#listaDeFasesEnBD").val());
    }
</script>
<body>
    <h1>Programa - Fase</h1>
    <h4>Seleccione las Fases a asignar a un Programa</h4>
    <br>
    <form method="post" action="ProcesarProgramaFase.do" accept-charset="utf-8">
        <table>
            <thead>
                <tr>
                    <th>Listado de Programas:</th>
                    <th>
                        <select name="idPrograma" onchange="javascript:getFasesRelacionadasConPrograma(this.value)">
                            <option value="" selected></option>
                            <c:forEach items="${requestScope.listaDeProgramas }" var="ep1">
                                <option value="${ep1.getIdPrograma() }">${ep1.getDescripcion() }</option>
                            </c:forEach>
                        </select>
                    </th>
                    <th>
                        <input type="submit" value="Establecer asociacion" />
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
                    <th>Listado de Fases</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listaDeFases }" var="ep2">
                    <tr>
                        <td>
                            <input type="checkbox" name="fase" value="${ep2.getIdFase() }" />
                            <c:out value="${ep2.getDescripcion() }" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="hidden" name="listaDeFasesEnBD" id="listaDeFasesEnBD">
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>