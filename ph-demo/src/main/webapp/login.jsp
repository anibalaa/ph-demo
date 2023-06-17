<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" class="com.ph3.vo.Usuario" scope="request" />
<jsp:setProperty property="*" name="Usuario" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
    <c:if test="${ not empty usuario.getUsuarioNombre() }">
        <jsp:forward page="Controlador"></jsp:forward>
    </c:if>
    <h1>Iniciar sesión</h1>
    <form action="login.jsp" method="post" accept-charset="utf-8">
        <fieldset id="form">
            <legend>Login</legend>
            <ul>
                <li>
                    <label>Usuario: </label>
                    <input type="text" name="usuarioNombre">
                </li>
                <li>
                    <label>Contraseña: </label>
                    <input type="password" name="usuarioClave">
                </li>
            </ul>
            <input type="hidden" name="opcion" value="0" />
            <p>
                <input type="submit" value="login">
            </p>
        </fieldset>
    </form>
</body>
</html>
