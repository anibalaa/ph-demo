<%@ include file="/includes/include.jsp"%>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Modificar Programa</legend>
            <form method="post" class="form-horizontal" role="form" action=${pageContext.request.contextPath}/SalvarPrograma.do>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="descripcion">Descripción : </label>
                    <input type="text" name="descripcion" value="${sessionScope.unPrograma.descripcion }" />
                    <br>
                </div>
                <input type="hidden" name="idPrograma" value="${sessionScope.unPrograma.idPrograma }" />
                <input type="submit" value="Guardar cambios" />
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>