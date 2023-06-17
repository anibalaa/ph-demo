<%@ include file="/includes/include.jsp"%>
<body>
 <script>
					$(document).ready(function() {
						$('#tEstadoProyecto').DataTable();
					});
				</script>
 <p>
 <h1>FaseGrupos</h1>
 <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
 <div class="row">
  <div class="table-responsive">
   <div class="col-md-6">
    <table id="tEstadoProyecto" class="table table-striped">
     <thead>
      <tr>
       <th>Id</th>
       <th>Acción</th>
      </tr>
     </thead>

     <c:forEach items="${requestScope.listaDeFaseGrupos}" var="ep">
      <tr>
       <td><c:out value="${ep.idFaseGrupo}"></c:out></td>

       <td><a href="EliminarFaseGrupo.do?idFaseGrupo=${ep.idFaseGrupo}" onclick="return confirmar()">Eliminar</a> <a href="ModificarFaseGrupo.do?idFaseGrupo=${ep.idFaseGrupo}">Modificar</a></td>
      </tr>
     </c:forEach>
    </table>
   </div>
  </div>
 </div>
 <a href="protegido/admin/form/fasegrupos/insertarFaseGrupos.jsp">Insertar</a>
 <%@ include file="/includes/pie.jsp"%>
</body>
</html>