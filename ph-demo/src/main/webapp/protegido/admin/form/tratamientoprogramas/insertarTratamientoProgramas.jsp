<%@ include file="/includes/include.jsp"%>
<body>
 <div class="container">
  <p class="text-center">
  <fieldset>
   <legend>Insertar TratamientoPrograma</legend>
   <form method="post" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/InsertarTratamientoPrograma.do" accept-charset="utf-8">
    <div class="form-group">
     <div class="col-sm-10 col-sm-offset-2">
      <input class="btn btn-primary" type="submit" value="Insertar TratamientoPrograma" />
     </div>
    </div>
   </form>
  </fieldset>
 </div>
 <%@ include file="/includes/pie.jsp"%>
</body>
</html>