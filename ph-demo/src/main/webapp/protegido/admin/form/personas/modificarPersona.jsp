<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsPersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript">
    // function setupChk(value) {
    //     JsPersonaBean.getActivo(value);
    //     console.log(value);
    //     }
    $(document).ready(function() {
        chkActivo();
    });
    function chkActivo() {
        console.log($('#chk-activo').val());
        $('#chk-activo').removeProp('checked');
        if ("${sessionScope.unaPersona.activo }" == 1) {
            $('#chk-activo').prop('checked', true);
            $('#chk-activo').val(1);
        } else if ("${sessionScope.unaPersona.activo }" == 0) {
            $('#chk-activo').prop('checked', false);
            $('#chk-activo').val(0);
        }
        console.log($('#chk-activo').val());
    }
    function chkValue() {
        // FUNCIONA EL CHECK DE ACTIVO COMO QUIERO :)
        if ($('#chk-activo').is(':checked')) {
            console.log("Entra por marcado");
            $('#chk-activo').checked = !$('#chk-activo').checked;
            $('#chk-activo').val(1);
            console.log($('#chk-activo').val());
        } else {
            console.log("Entra por NO marcado");
            $('#chk-activo').checked = !$('#chk-activo').checked;
            $('#chk-activo').val(0);
            console.log($('#chk-activo').val());
        }
    }
</script>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Modificar Persona</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SalvarPersona.do" accept-charset="ISO-8859-15">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="nombre">Nombre : </label>
                    <input type="text" name="nombre" value="${sessionScope.unaPersona.nombre }" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="apellido1">Apellido 1 : </label>
                    <input type="text" name="apellido1" value="${sessionScope.unaPersona.apellido1 }" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="apellido2">Apellido 2 : </label>
                    <input type="text" name="apellido2" value="${sessionScope.unaPersona.apellido2 }" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="activo">Activo : </label>
                    <%--                     <input type="text" value="${sessionScope.unaPersona.activo }" /> --%>
                    <input type="checkbox" name="activo" id="chk-activo" onchange="javascript:chkValue()" />
                    <br>
                </div>
                <input type="hidden" name="idPersona" value="${sessionScope.unaPersona.idPersona }" />
                <input type="submit" value="Guardar cambios" />
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>