<%@ include file="/includes/include.jsp"%>
<jsp:useBean id="programa" class="com.ph3.vo.Programa"></jsp:useBean>
<script type="text/javascript">
    function ingresar(s1,s2) {
        var s1 = document.getElementById(s1);
        var s2 = document.getElementById(s2);
        s2.innerHTML = "";
        if (s1.value == "23") {
            var optionArray = ["|","7|7","8|8","9|9"];
        }
        for ( var option in optionArray) {
            var par = optionArray[option].split("|");
            var newOption = document.createElement("option");
            newOption.value = par[0];
            newOption.innerHTML = par[1];
            s2.options.add(newOption);
        }
    }
</script>
<body>
    <h1>Fases Relacionadas Con Un Programa</h1>
    <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
    <table>
        <tr>
            <th>idPrograma</th>
            <th>idFase</th>
            <th>idGrupo</th>
        </tr>
        <tr>
            <td>
                <select name="programa" id="programa" onchange="ingresar(this.id,'fase')">
                    <option value=""></option>
                    <option value="${requestScope.idPrograma }">${requestScope.idPrograma }</option>
                </select>
            </td>
            <td>
                <select name="fase" id="fase">
                </select>
            </td>
            <td>
                <select name="grupo" id="grupo">
                </select>
            </td>
        </tr>
    </table>
    <a href="protegido/admin/form/programafases/insertarProgramaFases.jsp">Insertar</a>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>