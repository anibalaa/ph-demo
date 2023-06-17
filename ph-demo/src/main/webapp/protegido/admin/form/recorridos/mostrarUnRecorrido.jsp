<%@ include file="/includes/include.jsp"%>
<body>
    <h1>Escoja un Recorrido</h1>
    <form method="post" action="MostrarUnRecorrido2.do" accept-charset=utf-8>
        <table class="table table-responsive table-bordered">
            <tbody>
                <tr>
                    <th>
                        <label>Recorrido:</label>
                    </th>
                    <td>
                        <select name="idRecorrido">
                            <option value=""></option>
                            <c:forEach items="${sessionScope.listaDeRecorridos}" var="unRecorrido">
                                <option value="${unRecorrido.idRecorrido}">${unRecorrido.idRecorrido}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <input type="submit" value="Seleccionar Recorrido" />
                    </td>
                <tr>
            </tbody>
        </table>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>