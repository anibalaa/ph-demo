<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsNombrePersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido1PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido2PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsGrupoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        window.onload = function() {
            $("#chk-nom,#chk-ap1,#chk-ap2").prop('checked', false);
            $("#sel-nom,#sel-ap1,#sel-ap2,#sp0").hide();
            setupSelect();
            setupSelectTrat();
            setupSelectProg();
            setupSelectFase();
            setupSelectGru();

        };

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

    });
</script>
<script type="text/javascript">
    function setupSelect() {
        JsNombrePersonaBean.getPersonaInfo(populate);
    }

    function populate(list) {
        dwr.util.removeAllOptions("sel-nom");
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
        var c = $("#sel-nom option").length;
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
</script>
<script>
    $(function() {
        $("#datepicker-1").datepicker();
        $("#datepicker-2").datepicker();
    });
</script>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Insertar Recorrido</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/InsertarRecorrido.do" accept-charset="utf-8">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="fechaDeInicio">Fecha de Inicio :</label>
                    <input type="text" name="fechaDeInicio" id="datepicker-1" value="01-12-2001" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="fechaDeFin">Fecha de Fin :</label>
                    <input type="text" name="fechaDeFin" id="datepicker-2" value="03-12-2001" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="activo">activo :</label>
                    <input type="text" name="activo" value="1" />
                    <br>
                </div>
                <input type="hidden" name="idPersona" value="1" />
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <input class="btn btn-primary" type="submit" value="Insertar Recorrido" />
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>