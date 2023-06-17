<%@ include file="/includes/include.jsp"%>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Modificar Tratamiento</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/SalvarTratamiento.do" accept-charset="utf-8">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="descripcion">Descripción : </label>
                    <input type="text" name="descripcion" value="${sessionScope.unTratamiento.descripcion }" />
                    <br/>
                </div>
                <input type="hidden" name="idTratamiento" value="${sessionScope.unTratamiento.idTratamiento }" />
                <input type="submit" value="Guardar cambios" />
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>