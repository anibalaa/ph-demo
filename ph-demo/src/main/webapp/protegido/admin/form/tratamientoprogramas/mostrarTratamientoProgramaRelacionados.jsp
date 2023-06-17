<%@ include file="/includes/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/ph3?useSSL=false" user="jelastic" password="temporal" />
<%-- <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://10.100.18.93:3306/ph3?useSSL=false" user="jelastic" password="temporal" /> --%>
<sql:query var="rsTratamiento" dataSource="${db}">
SELECT distinct
    idTratamiento
FROM
    ph3.Tratamiento;
</sql:query>
<c:forEach var="table" items="${rsTratamiento.rows}">
    <c:out value="${table.idTratamiento }" />
</c:forEach>
<c:out value="|" />
<sql:query var="rsPrograma" dataSource="${db}">
SELECT DISTINCT
    idPrograma
FROM
    TratamientoPrograma AS tp
WHERE
    tp.idTratamiento = ?;
<sql:param value="${idTratamiento}" />
</sql:query>
<c:forEach var="table" items="${rsPrograma.rows}">
    <c:out value="${table.idPrograma }" />
</c:forEach>
<c:out value="|" />
<sql:query var="rsProgramasPorTratamiento" dataSource="${db}">
SELECT DISTINCT
    idTratamiento
FROM
    Programa AS p,
    TratamientoPrograma AS tp
WHERE
    p.idPrograma = tp.idPrograma
        AND tp.idTratamiento = ?;
<sql:param value="${idTratamiento}" />
</sql:query>
<c:forEach var="table" items="${rsProgramasPorTratamiento.rows}">
    <c:out value="${table.idTratamiento }" />
</c:forEach>
<c:out value="|" />
<script type="text/javascript">
    function cambiar(s1, s2) {

        var contador = 0;
        <c:forEach items="${rsPrograma.rows}" var="table">
        contador++;
        </c:forEach>
        console.log("contador: " + contador);
        var x = 0; // los array en js tienen posicion 0 de inicio
        var arr = new Array(contador); // creamos un array con el número de filas de la tabla
        <c:forEach items="${rsPrograma.rows}" var="table">
        var str = ""; // almacenamos el único valor de cada fila en un string de modo "x|x" 
        str += "${table.idPrograma }";
        str += "|";
        str += "${table.idPrograma }";
        arr[x] = str; // almacenamos el string en cada posición del array
        x++; // sumar un valor para desplazar el array
        </c:forEach>
        var s1 = document.getElementById(s1);
        var s2 = document.getElementById(s2);
        console.log("s1.value: " + s1.value); // s1.value es el valor del select Tratamiento
        //         console.log(<c:out value="${table.idPrograma }"></c:out>); 
        if (s1.value == "${idTratamiento}") {
            $("#programa").empty(); // asegurarse de borrar todos los options del select Programa con JQuery
            for ( var option in arr) { // bucle del array de strings que creará los valores del select Programa dinámicamente
                var par = arr[option].split("|"); // llamamos par a un vector de 2 posiciones, 0 valor y 1 la parte visible del select 
                var newOption = document.createElement("option"); // creamos un option
                newOption.value = par[0]; // asignamos al option el valor de la tabla como valor
                newOption.innerHTML = par[1]; // asignamos al option el valor de la tabla como parte visible
                s2.options.add(newOption); // asignamos al select el option recien creado
            }
        }
    }

    function xmlhttpPost(strURL) {
        var xmlHttpReq = false;
        var self = this;
        // Mozilla/Safari
        if (window.XMLHttpRequest) {
            self.xmlHttpReq = new XMLHttpRequest();
        }
        // IE
        else if (window.ActiveXObject) {
            self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
        }
        self.xmlHttpReq.open('POST', strURL, true);
        self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        self.xmlHttpReq.onreadystatechange = function() {
            if (self.xmlHttpReq.readyState == 4 && self.xmlHttpReq.status == 200) {
                updatepage(self.xmlHttpReq.responseText);
            }
        }
        self.xmlHttpReq.send(getquerystring());
    }

    function getquerystring() {

        //  var word = document.getElementById("tratamiento").value;
        var word = $('#tratamiento').val();
        console.log("word: " + word);
        qstr = 'w=' + encodeURI(word); // NOTE: no '?' before querystring
        console.log("qstr: " + qstr);
        return qstr;
    }

    function updatepage(str) {
        document.getElementById("demo").innerHTML = str;
        $("#fase").empty(); // vaciamos el select de FASE en cada actualización 
        var newOption = document.createElement("option");
        newOption.value = str;
        newOption.innerHTML = str;
        document.ajax.fase.options.add(newOption);

    }
</script>
<body>
    <h1>Programas Relacionados Con Un Tratamiento</h1>
    <form action="void(0)" method="post" name="ajax" accept-charset="utf-8">
        <table>
            <tr>
                <th>idTratamiento</th>
                <th>idPrograma</th>
                <th>idFase</th>
                <th>idGrupo</th>
            </tr>
            <tr>
                <td>
                    <select name="tratamiento" id="tratamiento" onchange="cambiar(this.id,'programa'),xmlhttpPost('sql.jsp')">
                        <option value=""></option>
                        <c:forEach items="${sessionScope.listaDeTratamientos }" var="ep">
                            <c:catch var="catchtheException">
                                <option value="${ep.getIdTratamiento() }">${ep.getIdTratamiento() }</option>
                            </c:catch>
                            <c:if test="${catchtheException != null }">
                                <p>Excepcion: ${catchtheException }</p>
                            </c:if>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="programa" id="programa">
                        <option value=""></option>
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
    </form>
    <sql:query var="rsPrograma" dataSource="${db}">
    SELECT DISTINCT
        idPrograma
    FROM
        TratamientoPrograma AS tp
    WHERE
        tp.idTratamiento = <%="10"%>;
<%-- <sql:param value="${idTratamiento}" /> --%>
    </sql:query>
    <c:forEach var="table" items="${rsPrograma.rows}">
        <c:out value="${table.idPrograma }" />
    </c:forEach>
    <p id="demo"></p>
    <!--     <a href="protegido/admin/form/tratamientoprogramas/insertarTratamientoProgramas.jsp">Insertar</a> -->
    <%--     <%@ include file="/includes/pie.jsp"%> --%>
</body>
</html>