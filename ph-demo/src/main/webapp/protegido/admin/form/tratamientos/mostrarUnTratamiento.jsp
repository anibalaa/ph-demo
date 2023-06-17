<%@ include file="/includes/include.jsp"%>
<body>
    <h1>Tratamiento</h1>
    <table>
        <thead>
            <tr>
                <th>
                    <label for="tratamiento">Descripción</label>
                </th>
            </tr>
        </thead>
        <tr>
            <td>
                <c:out value="${unTratamiento }" />
            </td>
        </tr>
    </table>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>