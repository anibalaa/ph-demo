<%@ include file="/includes/include.jsp"%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ph3?allowPublicKeyRetrieval=true&useSSL=false" user="jelastic" password="temporal" />
<%-- <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://10.100.18.93:3306/ph3?useSSL=false" user="jelastic" password="temporal" /> --%>
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
<sql:query var="rsTEST" dataSource="${db}">
select * FROM Persona WHERE Nombre = ?;
 <sql:param value="ramón" />
</sql:query>
<c:forEach var="table" items="${rsTEST.rows}">
    <c:out value="${table.Nombre }" />
</c:forEach>
<c:out value="|" />
<body>
    <h2>Estas en HQL TEST</h2>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>

