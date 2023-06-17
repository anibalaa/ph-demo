<%@ include file="/includes/include.jsp"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsTratamientoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsProgramaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsFaseBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsGrupoBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        window.onload = function() {
            setupSelectTrat();
            setupSelectProg();
            setupSelectFase();
            setupSelectGru();
        };
    });
    function setupSelectTrat() {
        JsTratamientoBean.getTratamientoInfo(popul_trat);
    }
    function popul_trat(list) {
        dwr.util.removeAllOptions("sel-trat");
        dwr.util.addOptions("sel-trat", [ "" ]);
        dwr.util.addOptions("sel-trat", list);
        $('#sel-trat option[value="Recurso para menores y jovenes RECIELLA"]').prop('selected', 'selected').change();

    }
    function setupSelectProg() {
        JsProgramaBean.getProgramaInfo(popul_prog);
    }
    function popul_prog(list) {
        dwr.util.removeAllOptions("sel-prog");
        dwr.util.addOptions("sel-prog", [ "" ]);
        dwr.util.addOptions("sel-prog", list);
        $('#sel-prog option[value="PG. acogida Gijon"]').prop('selected', 'selected').change();

    }
    function setupSelectFase() {
        JsFaseBean.getFaseInfo(popul_fase);
    }
    function popul_fase(list) {
        dwr.util.removeAllOptions("sel-fase");
        dwr.util.addOptions("sel-fase", [ "" ]);
        dwr.util.addOptions("sel-fase", list);
        $('#sel-fase option[value="FASE 3"]').prop('selected', 'selected').change();

    }
    function setupSelectGru() {
        JsGrupoBean.getGrupoInfo(popul_gru);
    }
    function popul_gru(list) {
        dwr.util.removeAllOptions("sel-gru");
        dwr.util.addOptions("sel-gru", [ "" ]);
        dwr.util.addOptions("sel-gru", list);
        $('#sel-gru option[value="GRUPO D"]').prop('selected', 'selected').change();

    }
</script>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Insertar Recorrido</legend>
            <form method="post" role="form" action="${pageContext.request.contextPath}/InsertarRecorrido.do" accept-charset="utf-8">
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Nombre">Nombre : </label>
                    <input type="text" name="nombre" value="anibal" />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Apellido1">Apellido 1 : </label>
                    <input type="text" name="apellido1" value="alvarez" />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Apellido2">Apellido 2 : </label>
                    <input type="text" name="apellido2" value="alvarez" />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Tratamiento">Tratamiento : </label>
                    <select id="sel-trat"  name="descripcion">
                    </select>
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Programa">Programa : </label>
                    <select id="sel-prog"  name="descripcion">
                    </select>
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Fase">Fase : </label>
                    <select id="sel-fase" name="descripcion">
                    </select>
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Grupo">Grupo : </label>
                    <select id="sel-gru"  name="descripcion">
                    </select>
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="fechaDeInicio">Fecha de Inicio : </label>
                    <input type="text" name="fechaDeInicio" id="datepicker-1" value="01-01-2001" />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="fechaDeFin">Fecha de Fin : </label>
                    <input type="text" name="fechaDeFin" id="datepicker-2" value="31-12-2016" />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Activo">Activo : </label>
                    <input type="checkbox"  name="activo" value="1" checked />
                    <br>
                </div>
                <div class="form-control-sm">
                    <label class="col-sm-2 col-form-label" for="Motivo">Motivo : </label>
                    <input type="text"  name="descripcion" value="motiv1" />
                    <br>
                </div>
                <div class="form-control-sm">
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

<script type="text/javascript">
    $(function() {
        $("#datepicker-1").datepicker();
        $("#datepicker-2").datepicker();
    });
</script>