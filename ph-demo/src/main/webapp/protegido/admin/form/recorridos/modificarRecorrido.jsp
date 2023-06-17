<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsGrupoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsMotivoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseGrupoBean.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        setupSelectTrat3();
        setupSelectProg3();
        setupSelectFase3();
        setupSelectGru3();
        setupSelectMot3();
        chkActivo();
    });
    function setupSelectTrat3() {
        $('#sel-trat option[value="${sessionScope.unRecorrido.tratamiento.idTratamiento}"]').prop('selected', 'selected').change();
    }
    function setupSelectProg3(value) {
        $('#sel-prog option[value="${sessionScope.unRecorrido.programa.idPrograma }"]').prop('selected', 'selected').change();
    }
    function setupSelectFase3(value) {
        $('#sel-fase option[value="${sessionScope.unRecorrido.fase.idFase }"]').prop('selected', 'selected').change();
    }
    function setupSelectGru3(value) {
        $('#sel-gru option[value="${sessionScope.unRecorrido.grupo.idGrupo }"]').prop('selected', 'selected').change();
    }
    function setupSelectMot3() {
        $('#sel-mot3 option[value="${sessionScope.unRecorrido.motivo.idMotivo }"]').prop('selected', 'selected').change();
    }
    function chkActivo() {
        console.log($('#chk-activo').val());
        $('#chk-activo').removeProp('checked');
        if ("${sessionScope.unRecorrido.activo }" == 1) {
            $('#chk-activo').prop('checked', true);
            $('#chk-activo').val(1);
        } else if ("${sessionScope.unRecorrido.activo }" == 0) {
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
            <legend>Modificar Recorrido</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SalvarRecorrido.do" accept-charset="utf-8">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="idRecorrido">idRecorrido : </label>
                    <input type="text" name="idRecorrido" value="${sessionScope.unRecorrido.idRecorrido }" readonly />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Nombre">Nombre : </label>
                    <input type="text" name="nombre" id="sel-nom" value="${sessionScope.unRecorrido.persona.nombre }" readonly />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Apellido1">Apellido 1 : </label>
                    <input type="text" name="apellido1" id="sel-ap1" value="${sessionScope.unRecorrido.persona.apellido1 }" readonly />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Apellido2">Apellido 2 : </label>
                    <input type="text" name="apellido2" id="sel-ap2" value="${sessionScope.unRecorrido.persona.apellido2 }" readonly />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Activo">Activo : </label>
                    <%--                     <input type="text" value="${sessionScope.unRecorrido.activo }" /> --%>
                    <input type="checkbox" name="activo" id="chk-activo" onchange="javascript:chkValue()" />
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Tratamiento">Tratamiento : </label>
                    <input type="text" id="sel-tra3" value="${sessionScope.unRecorrido.tratamiento.descripcion }" />
                    <select id="sel-trat" name="tratamiento">
                        <c:forEach items="${requestScope.listaDeTratamientos}" var="tp">
                            <option value="${tp.idTratamiento}">${tp.descripcion}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Programa">Programa : </label>
                    <input type="text" id="sel-prog3" value="${sessionScope.unRecorrido.programa.descripcion }" />
                    <select id="sel-prog" name="programa">
                        <c:forEach items="${requestScope.listaDeProgramas}" var="tp">
                            <option value="${tp.idPrograma}">${tp.descripcion}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Fase">Fase : </label>
                    <input type="text" id="sel-fase3" value="${sessionScope.unRecorrido.fase.descripcion }" />
                    <select id="sel-fase" name="fase">
                        <c:forEach items="${requestScope.listaDeFases}" var="tp">
                            <option value="${tp.idFase}">${tp.descripcion}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Grupo">Grupo : </label>
                    <input type="text" id="sel-gru3" value="${sessionScope.unRecorrido.grupo.descripcion }" />
                    <select id="sel-gru" name="grupo">
                        <c:forEach items="${requestScope.listaDeGrupos}" var="tp">
                            <option value="${tp.idGrupo}">${tp.descripcion}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="Motivo">Motivo : </label>
                    <input type="text" id="sel-mot3" value="${sessionScope.unRecorrido.motivo.descripcion }" />
                    <select id="sel-mot3" name="motivo">
                        <c:forEach items="${requestScope.listaDeMotivos}" var="tp">
                            <option value="${tp.idMotivo}">${tp.descripcion}</option>
                        </c:forEach>
                    </select>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="fechaDeInicio">Fecha de Inicio : </label>
                    <c:choose>
                        <c:when test="${sessionScope.unRecorrido.fechaInicio == null}">
                            <input type="date" name="fechaDeInicio" id="datepicker-1" value="" />
                        </c:when>
                        <c:otherwise>
                            <input type="date" name="fechaDeInicio" id="datepicker-1" value="${sessionScope.unRecorrido.fechaInicio}" />
                        </c:otherwise>
                    </c:choose>
                    <br>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="fechaDeFin">Fecha de Fin : </label>
                    <c:choose>
                        <c:when test="${sessionScope.unRecorrido.fechaFin == null}">
                            <input type="date" name="fechaDeFin" id="datepicker-2" value="" />
                        </c:when>
                        <c:otherwise>
                            <input type="date" name="fechaDeFin" id="datepicker-2" value="${sessionScope.unRecorrido.fechaFin }" />
                        </c:otherwise>
                    </c:choose>
                    <br>
                </div>
                <%--                 <input type="hidden" name="idRecorrido" value="${sessionScope.unRecorrido.idRecorrido }" /> --%>
                <!--                 <input type="hidden" name="activo" value="javascript:chkValue()" /> -->
                <input type="submit" value="Guardar cambios" class="btn btn-primary" />
                <a href="ModificarRecorrido.do?idRecorrido=${sessionScope.unRecorrido.idRecorrido }"> Resetear </a>
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>