<%@ include file="/includes/include.jsp"%>
<body>
    <h1>Elija una Agrupación</h1>
    <form method="post" action="MostrarMenu2Agrupacion.do" accept-charset="utf-8">
        <table class="table table-responsive table-bordered">
            <tbody>
                <tr>
                    <th>Listado de agrupaciones:</th>
                    <td>
                        <select name="agrupacion">
                            <option value=""></option>
                            <c:forTokens items="tratamiento - programa,programa - fase,fase - grupo" delims="," var="opcion">
                                <option value="${opcion }">${opcion }</option>
                            </c:forTokens>
                        </select>
                    </td>
                    <td>
                        <input type="submit" value="Seleccionar Agrupación" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>
