<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript">
    function marcartodos() {
        $(":checkbox").prop('checked', true);
    }
    function borrartodos() {
        $(":checkbox").prop('checked', false);
    }
    function getGruposRelacionadosConFase(value) {
        console.log(value);
        JsFaseBean.getGruposRelacionadosConFase(value, populate);
    }
    function populate(list) {
        var marcados = [];
        $(":checkbox").prop('checked', false);
        list.forEach(function(element) {
            console.log(element.idGrupo);
            $('input[type=checkbox]').each(function() {
                if (this.value == element.idGrupo) {
                    $(this).prop('checked', true);
                    marcados.push(this.value);
                }
            });
        });
        console.log(marcados);
        // pasamos desde javaScript a Java mediante el input hidden
        $("#listaDeGruposEnBD").val(marcados);
        console.log($("#listaDeGruposEnBD").val());
    }
</script>
<body>
    <h1>Fase - Grupo</h1>
    <h4>Seleccione los Grupos a asignar a una Fase</h4>
    <br>
    <form method="post" action="ProcesarFaseGrupo.do" accept-charset="utf-8">
        <table>
            <thead>
                <tr>
                    <th>Listado de Fases:</th>
                    <th>
                        <select name="idFase" onchange="javascript:getGruposRelacionadosConFase(this.value)">
                            <option value="" selected></option>
                            <c:forEach items="${requestScope.listaDeFases }" var="ep1">
                                <option value="${ep1.getIdFase() }">${ep1.getDescripcion() }</option>
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
                <tr>
            </thead>
        </table>
        <p />
        <table>
            <thead>
                <tr>
                    <th>Listado de Grupos</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.listaDeGrupos }" var="ep2">
                    <!--                 cada 8 tds, se se podría saltar de columna para aprobechar la pantalla -->
                    <tr>
                        <td>
                            <input type="checkbox" name="grupo" value="${ep2.getIdGrupo() }" />
                            <c:out value="${ep2.getDescripcion() }" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="hidden" name="listaDeGruposEnBD" id="listaDeGruposEnBD">
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>