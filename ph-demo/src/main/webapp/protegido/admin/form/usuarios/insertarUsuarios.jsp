<%@ include file="/includes/include.jsp"%>
<body>
    <div class="container">
        <p class="text-center">
        <fieldset>
            <legend>Insertar Usuario</legend>
            <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/InsertarUsuario.do" accept-charset="utf-8">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="descripcion">Descripción :</label>
                    <input type="text" name="descripcion" />
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <input class="btn btn-primary" type="submit" value="Insertar Usuario" />
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>