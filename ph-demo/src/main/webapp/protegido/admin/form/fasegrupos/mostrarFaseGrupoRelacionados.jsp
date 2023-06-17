<%@ include file="/includes/include.jsp"%>
<script type="text/javascript">
    $(document).ready(function() {
        $("select.grupo").hide();
        $("select.fase").change(function() {
            var selectedFase = $(".fase option:selected").val();
            if (selectedFase != " ") {
                //                alert("Has selecionado la fase nº - " + selectedFase);
                $("select.grupo").show();
            } else {
                //                alert("No hay fase seleccionada");
            }
        });

    });
</script>
<body>
    <h1>Grupos Relacionados Con Una Fase</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <table>
        <tr>
            <th>idGrupo</th>
            <th>Acción</th>
        </tr>
        <c:forEach items="${requestScope.listaDeFaseGrupos}" var="ep">
            <tr>
                <td>${ep.getGrupo().getIdGrupo() }</td>
                <td>
                    <a href="EliminarFaseGrupo.do?idFaseGrupo=${ep.idFaseGrupo}" onclick="return confirmar()">Eliminar</a>
                    <a href="ModificarFaseGrupo.do?idFaseGrupo=${ep.idFaseGrupo}">Modificar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <th>idFase</th>
            <th>idGrupo</th>
        </tr>
        <tr>
            <td>
                <select name="fase" class="fase">
                    <c:forTokens items=" ,${requestScope.idFase }" delims="," var="opcion1">
                        <option value="${opcion1 }">${opcion1 }</option>
                    </c:forTokens>
                </select>
            </td>
            <td>
                <select name="grupo" class="grupo">
                    <option value=""></option>
                    <c:forEach items="${requestScope.listaDeFaseGrupos }" var="ep2">
                        <option value="${ep2.getGrupo().getIdGrupo() }">${ep2.getGrupo().getIdGrupo() }</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <a href="protegido/admin/form/fasegrupos/insertarFaseGrupos.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>