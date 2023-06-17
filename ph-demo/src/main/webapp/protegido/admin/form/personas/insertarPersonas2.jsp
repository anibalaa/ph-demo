<%@ include file="/includes/include.jsp"%>
<script type="text/javascript">
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
            <legend>Insertar Persona</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/InsertarPersona.do" accept-charset="utf-8">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="nombre">Nombre : </label>
                    <input type="text" name="nombre" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="apellido1">Apellido 1 : </label>
                    <input type="text" name="apellido1" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="apellido2">Apellido 2 : </label>
                    <input type="text" name="apellido2" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="activo">Activo : </label>
                    <input type="checkbox" name="activo" id="chk-activo" onchange="javascript:chkValue()" />
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <input class="btn btn-primary" type="submit" value="Insertar Persona" />
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>