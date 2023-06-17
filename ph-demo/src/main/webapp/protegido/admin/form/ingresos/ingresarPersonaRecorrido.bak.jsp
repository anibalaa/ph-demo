<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsNombrePersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido1PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido2PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsGrupoBean.js"></script>
<script type="text/javascript">
    function setupSelect() {
        JsNombrePersonaBean.getPersonaInfo(populate);
    }

    function populate(list) {

        dwr.util.removeAllOptions("sel-nom");
        dwr.util.addOptions("sel-nom", [ "" ]);
        dwr.util.addOptions("sel-nom", list);
    }

    function setupSelect1(value) {
        console.log("value: " + value);
        JsApellido1PersonaBean.getPersonaInfo(value, populate1);
    }
    function populate1(list) {
        console.log("list: " + list);
        dwr.util.removeAllOptions("sel-ap1");
        dwr.util.addOptions("sel-ap1", list);
    }
    function setupSelect2(value) {
        console.log("value: " + value);
        JsApellido2PersonaBean.getPersonaInfo(value, populate2);
    }
    function populate2(list) {
        console.log("list: " + list);
        dwr.util.removeAllOptions("sel-ap2");
        dwr.util.addOptions("sel-ap2", list);
    }

    function cont() {
        var c = $("#sel-nom option").length - 1; // quitamos 1 del 1º option en blanco
        return c;
    }
    function cont1() {
        var c = $("#sel-ap1 option").length;
        return c;
    }
    function cont2() {
        var c = $("#sel-ap2 option").length;
        return c;
    }

    function setupSelectTrat() {
        JsTratamientoBean.getTratamientoInfo(popul_trat);
    }
    function popul_trat(list) {
        dwr.util.removeAllOptions("sel-trat");
        dwr.util.addOptions("sel-trat", list);
    }
    function setupSelectProg() {
        JsProgramaBean.getProgramaInfo(popul_prog);
    }
    function popul_prog(list) {
        dwr.util.removeAllOptions("sel-prog");
        dwr.util.addOptions("sel-prog", list);
    }
    function setupSelectFase() {
        JsFaseBean.getFaseInfo(popul_fase);
    }
    function popul_fase(list) {
        dwr.util.removeAllOptions("sel-fase");
        dwr.util.addOptions("sel-fase", list);
    }
    function setupSelectGru() {
        JsGrupoBean.getGrupoInfo(popul_gru);
    }
    function popul_gru(list) {
        dwr.util.removeAllOptions("sel-gru");
        dwr.util.addOptions("sel-gru", list);
    }
    $(document).ready(function() {
        $("#chk-nom,#chk-ap1,#chk-ap2").prop('checked', false);
        $("#sel-nom,#sel-ap1,#sel-ap2,#sp0").hide();

        $("#b_toggle").click(function() {
            $("#tabla2").toggle();
        });

        $("#chk-nom").change(function() {
            if ($(this).is(":checked")) {
                $("#sel-nom").show();
                $("#chk-nom,#chk-ap1,#chk-ap2").hide();
            }
        });

        $("#chk-ap1").change(function() {
            if ($(this).is(":checked")) {
                $("#sel-ap1").show();
                $("#chk-nom,#chk-ap1,#chk-ap2").hide();
            }
        });

        $("#chk-ap2").change(function() {
            if ($(this).is(":checked")) {
                $("#sel-ap2").show();
                $("#chk-nom,#chk-ap1,#chk-ap2").hide();
            }
        });

        $("#sel-nom").change(function() {

            $("#sel-ap1,#sel-ap2").show();
            $("#sp0").text(cont() + " opcion(es)");
            $("#sp0").fadeIn(2000);
            $("#sp0").fadeOut(2000);
            // MEJORAR CODIGO
            $("#sp1").text(cont1() + " opcion(es)");
            $("#sp1").fadeIn(2000);
            $("#sp1").fadeOut(2000);
            $("#sp2").text(cont2() + " opcion(es)");
            $("#sp2").fadeIn(2000);
            $("#sp2").fadeOut(2000);

        });

        $("#sel-ap1").change(function() {
            $("#sel-nom,#sel-ap2").show();
            $("#sp1").text(cont1() + " opcion(es)");
            $("#sp1").fadeIn(2000);
            $("#sp1").fadeOut(2000);

        });

        $("#sel-ap2").change(function() {
            $("#sel-nom,#sel-ap1").show();
            $("#sp2").text(cont2() + " opcion(es)");
            $("#sp2").fadeIn(2000);
            $("#sp2").fadeOut(2000);
        });
        setupSelect();
        setupSelectTrat();
        setupSelectProg();
        setupSelectFase();
        setupSelectGru();
    });
</script>
<body>
    <span class="d-inline-block">INGRESO PERSONA RECORRIDO</span>
    <form action="void(0)" method="post" accept-charset="utf-8">
        <table id="tabla1" class="table table-responsive table-bordered">
            <thead>
                <tr>
                    <th scope="col">
                        <label>Nombre</label>
                    </th>
                    <th scope="col">
                        <label>Apellido 1</label>
                    </th>
                    <th scope="col">
                        <label>Apellido 2</label>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <input type="checkbox" id="chk-nom" value="v0">
                        <select id="sel-nom" onchange="javascript:setupSelect1(this.value),setupSelect2(this.value)"></select>
                    </td>
                    <td>
                        <input type="checkbox" id="chk-ap1" value="v1">
                        <select id="sel-ap1"></select>
                    </td>
                    <td>
                        <input type="checkbox" id="chk-ap2" value="v2">
                        <select id="sel-ap2"></select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span id="sp0"></span>
                    </td>
                    <td>
                        <span id="sp1"></span>
                    </td>
                    <td>
                        <span id="sp2"></span>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="button" value="toggle()" id="b_toggle" class="btn btn-info" />
        <table id="tabla2" class="table table-responsive table-bordered">
            <tr>
                <td>
                    <select id="sel-trat"></select>
                </td>
                <th>
                    <label>Tratamiento</label>
                </th>
                <td>
                    <%--                     <input type="text" value="${Date() }" /> --%>
                    <fmt:formatDate pattern="dd-MM-yyyy" value="${Date() }" />
                </td>
                <th>
                    <label>Fecha de Inicio</label>
                </th>
            <tr>
            <tr>
                <td>
                    <select id="sel-prog"></select>
                </td>
                <th>
                    <label>Programa</label>
                </th>
                <td>
                    <c:out value="31-12-2017"></c:out>
                </td>
                <th>
                    <label>Fecha de Fin</label>
                </th>
            <tr>
            <tr>
                <td>
                    <select id="sel-fase"></select>
                </td>
                <th>
                    <label>Fase</label>
                </th>
            <tr>
            <tr>
                <td>
                    <select id="sel-gru"></select>
                </td>
                <th>
                    <label>Grupo</label>
                </th>
            <tr>
            <tr>
                <td>
                    <select id="sel-plan"></select>
                </td>
                <th>
                    <label>Plantilla</label>
                </th>
            <tr>
            <tr>
                <td>
                    <div class="form-group">
                        <label for="exampleInputFile" class="sr-only">Infome</label>
                        <input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">
                        <small id="fileHelp" class="form-text text-muted">Pulse el botón para abrir el diálogo de selección de archivos.</small>
                    </div>
                </td>
                <th>Infome</th>
            <tr>
        </table>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>