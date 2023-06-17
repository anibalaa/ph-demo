<%@ include file="/includes/include.jsp"%>
<body>
 <div class="container">
  <p class="text-center">
  <fieldset>
   <legend>Insertar FaseGrupo</legend>
   <form method="post" class="form-horizontal" role="form" action=${pageContext.request.contextPath}/InsertarFaseGrupo.do accept-charset="utf-8">
    <div class="form-group">
     <div class="col-sm-10 col-sm-offset-2">
      <input class="btn btn-primary" type="submit" value="Insertar FaseGrupo" />
     </div>
    </div>
   </form>
  </fieldset>
 </div>
 <%@ include file="/includes/pie.jsp"%>
</body>
</html>