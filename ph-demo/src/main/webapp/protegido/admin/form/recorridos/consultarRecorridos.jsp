<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido1PersonaBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsApellido2PersonaBean.js"></script>
<script>
    $(document).ready(function() {
        $('#tEstadoProyecto').DataTable();
    });
</script>
<script type="text/javascript">
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
</script>
<body>
    <p>
    <h1>Consultar Recorridos Por Persona</h1>
    <form method="post" role="form" action="${pageContext.request.contextPath}/MostrarRecorridoPorFiltro.do" accept-charset="utf-8">
        <table id="tablaConsulta" class="table table-responsive table-bordered">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido 1</th>
                    <th scope="col">Apellido 2</th>
                    <th scope="col">Fecha de Inicio</th>
                    <th scope="col">Fecha de Fin</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <select id="sel-nom" name="nombre" onchange="javascript:setupSelect1(this.value),setupSelect2(this.value)" required>
                            <option value="" selected></option>
                            <c:forEach items="${requestScope.listaDePersonas}" var="tp">
                                <option value="${tp.nombre}">${tp.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <select id="sel-ap1" name="apellido1"></select>
                    </td>
                    <td>
                        <select id="sel-ap2" name="apellido2"></select>
                    </td>
                    <td>
                        <input type="date" name="fechaDeInicio" required>
                    </td>
                    <td>
                        <input type="date" name="fechaDeFin" required>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Buscar" />
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>