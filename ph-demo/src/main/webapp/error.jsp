<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 Ha ocurrido un error en la aplicacion :
 <c:out value="${sessionScope.error}"/>
 <a href="login.jsp">Login</a>
</body>
</html>