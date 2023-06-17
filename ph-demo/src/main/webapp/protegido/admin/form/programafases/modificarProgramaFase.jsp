<%@ include file="/includes/include.jsp"%>
<body>
 <script>
					$(document).ready(function() {
						$('#tEstadoProyecto').DataTable();
					});
				</script>
 <p>
 <h1>ProgramaFases</h1>
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

     <c:forEach items="${requestScope.listaDeProgramaFases}" var="ep">
      <tr>
       <td><c:out value="${ep.idProgramaFase}"></c:out></td>

       <td><a href="EliminarProgramaFase.do?idProgramaFase=${ep.idProgramaFase}" onclick="return confirmar()">Eliminar</a> <a href="ModificarProgramaFase.do?idProgramaFase=${ep.idProgramaFase}">Modificar</a></td>
      </tr>
     </c:forEach>
    </table>
   </div>
  </div>
 </div>
 <a href="protegido/admin/form/programafases/insertarProgramaFases.jsp">Insertar</a>
 <%@ include file="/includes/pie.jsp"%>
</body>
</html>