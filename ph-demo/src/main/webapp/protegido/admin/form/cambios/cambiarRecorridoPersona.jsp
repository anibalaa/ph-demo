<%@ include file="/includes/include.jsp"%>
<body>
<h1>Cambiar Recorrido / Persona</h1>
<h4>Elija una Persona</h4>
    <form method="post" action="MostrarUnaPersona3.do" accept-charset="utf-8">
        Listado de Personas:
        <select name="idPersona">
            <option value=""></option>
            <c:forEach items="${requestScope.listaDePersonas}" var="unaPersona">
                <option value="${unaPersona.idPersona}">${unaPersona.nombre}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Seleccionar Persona" />
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>