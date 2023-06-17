<%@ include file="/includes/include.jsp"%>
<body>
    <h1>Elija una Persona</h1>
    <form method="get" action="MostrarUnaPersona2.do" accept-charset="utf-8">
        Listado de Personas:
        <select name="idPersona">
            <option value=""></option>
            <c:forEach items="${sessionScope.listaDePersonas}" var="unaPersona">
                <option value="${unaPersona.idPersona}">${unaPersona.nombre}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Seleccionar Persona" />
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>
