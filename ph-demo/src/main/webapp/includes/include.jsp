<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://www.directwebremoting.org/dwr/" prefix="dwr"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<title>-_-ph-demo-_-</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/normalize.css" />
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-1.12.4.min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/includes/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/bootstrap-3.3.7-dist/css/bootstrap.min.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/includes/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/jquery-ui-1.12.1/jquery-ui.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/bootstrap-4.0.0-beta.2-dist/js/popper.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/bootstrap-4.0.0-beta.2-dist/js/tooltip.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/bootstrap-4.0.0-beta.2-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/bootstrap-4.0.0-beta.2-dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/DataTables-1.10.16/datatables.min.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/DataTables-1.10.16/datatables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#tEstadoProyecto').DataTable({
            "language" : {
                "url" : "${pageContext.request.contextPath}/includes/datatables.spanish.lang.json"
            }
        });
    });
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/includes/funciones.js"></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script>
<!-- saco el código CSS a un archivo -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/base.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/includes/wait.css" />
</head>
