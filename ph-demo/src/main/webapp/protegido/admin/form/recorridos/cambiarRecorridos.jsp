<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsNombrePersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido1PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido2PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsGrupoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseGrupoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsMotivoBean.js"></script>
<script type="text/javascript">
    function setupSelectTrat3() {
        JsTratamientoProgramaBean.getTratamientoInfo3(popul_trat3);
    }
    function popul_trat3(list3) {
        dwr.util.removeAllOptions("sel-trat3");
        dwr.util.addOptions("sel-trat3", [ "" ]);
        dwr.util.addOptions("sel-trat3", list3);
    }
    function setupSelectProg3(value) {
        dwr.util.removeAllOptions("sel-prog3");
        dwr.util.removeAllOptions("sel-fase3");
        dwr.util.removeAllOptions("sel-gru3");
        JsTratamientoProgramaBean.getProgramasRelacionadosConUnTratamiento(value, popul_prog3);
    }
    function popul_prog3(list3) {
        dwr.util.removeAllOptions("sel-prog3");
        dwr.util.addOptions("sel-prog3", [ "" ]);
        dwr.util.addOptions("sel-prog3", list3, "idPrograma", "descripcion");
    }
    function setupSelectFase3(value) {
        dwr.util.removeAllOptions("sel-fase3");
        dwr.util.removeAllOptions("sel-gru3");
        JsProgramaFaseBean.getFasesRelacionadasConPrograma(value, popul_fase3);
    }
    function popul_fase3(list3) {
        dwr.util.removeAllOptions("sel-fase3");
        dwr.util.addOptions("sel-fase3", [ "" ]);
        dwr.util.addOptions("sel-fase3", list3, "idFase", "descripcion");
    }
    function setupSelectGru3(value) {
        dwr.util.removeAllOptions("sel-gru3");
        JsFaseGrupoBean.getGruposRelacionadosConFase(value, popul_gru3);
    }
    function popul_gru3(list3) {
        dwr.util.removeAllOptions("sel-gru3");
        dwr.util.addOptions("sel-gru3", [ "" ]);
        dwr.util.addOptions("sel-gru3", list3, "idGrupo", "descripcion");
    }
    function setupSelectMot3() {
        dwr.util.removeAllOptions("sel-mot3");
        JsMotivoBean.getMotivos(popul_mot3);
    }
    function popul_mot3(list3) {
        dwr.util.removeAllOptions("sel-mot3");
        dwr.util.addOptions("sel-mot3", [ "" ]);
        dwr.util.addOptions("sel-mot3", list3, "idMotivo", "descripcion");
    }

    $(document).ready(function() {
    });
</script>
<body>
    <h3>Especifique nuevo recorrido</h3>
    <form action="${pageContext.request.contextPath}/ProcesarCambioDePersonaRecorrido.do" method="post" accept-charset="utf-8">
        <div class="container">
            <table id="tabla3" class="table table-responsive table-bordered">
                <tr>
                    <th>
                        <label>Tratamiento</label>
                    </th>
                    <td>
                        <c:catch var="catchtheException">
                            <select id="sel-trat3" name="tratamiento" onchange="javascript:setupSelectProg3(this.value)">
                                <option value="" selected></option>
                                <c:forEach items="${requestScope.listaDeTratamientos}" var="tp">
                                    <option value="${tp.idTratamiento}">${tp.descripcion}</option>
                                </c:forEach>
                            </select>
                        </c:catch>
                        <c:if test="${catchtheException != null }">
                            <p>
                                The type of exception is: ${catchtheException }
                                <br />
                                There is an exception: ${catchtheException.message }
                            </p>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label>Programa</label>
                    </th>
                    <td>
                        <select id="sel-prog3" name="programa" onchange="javascript:setupSelectFase3(this.value)"></select>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label>Fase</label>
                    </th>
                    <td>
                        <select id="sel-fase3" name="fase" onchange="javascript:setupSelectGru3(this.value)"></select>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label>Grupo</label>
                    </th>
                    <td>
                        <select id="sel-gru3" name="grupo"></select>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label>Motivo</label>
                    </th>
                    <td>
                        <select id="sel-mot3" name="motivo">
                            <option value="" />
                            <c:forEach items="${requestScope.listaDeMotivos}" var="tm">
                                <option value="${tm.idMotivo}">${tm.descripcion}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        <label>Fecha de Inicio</label>
                    </th>
                    <td>
                        <input type="date" name="fechaDeInicio" value="" />
                        *
                        <br />
                        <span>*(La fecha elegida coincidirá con la fecha final en el antiguo recorrido)</span>
                    </td>
                </tr>
            </table>
        </div>
        <input type="hidden" name="idPersona" value="${requestScope.idPersona}">
        <input type="hidden" name="idRecorrido" value="${requestScope.idRecorrido}">
        <input type="submit" value="Insertar" />
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>
