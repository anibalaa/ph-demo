<%@ include file="/includes/include.jsp"%>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Insertar Programa</legend>
            <form
                method="post"
                class="form-horizontal"
                role="form"
                action=${pageContext.request.contextPath}/InsertarPrograma.do>
                <div class="form-group">
                    <label
                        class="col-sm-2 control-label"
                        for="descripcion">Descripci�n :</label>
                    <input
                        type="text"
                        name="descripcion" />
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <input
                            class="btn btn-primary"
                            type="submit"
                            value="Insertar Programa" />
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>