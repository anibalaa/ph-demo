<%@ include file="/includes/include.jsp"%>
<body>
 <script>
		$(document).ready(function() {
			$('#tEstadoProyecto').DataTable();
		});
	</script>
 <p>
 <h1>Usuarios</h1>
 <!-- Estas dos capas para comprimir la tabla y que no ocupe todo el ancho de la pantalla -->
 <div class="row">
  <div class="table-responsive">
   <div class="col-md-6">
    <table id="tEstadoProyecto" class="table table-striped">
     <thead>
      <tr>
       <th>Descripción</th>
       <th>Acción</th>
      </tr>
     </thead>


     <c:forEach items="${requestScope.listaDeUsuarios}" var="ep">
      <tr>
       <td><c:out value="${ep.descripcion}"></c:out></td>
       <td><a href="EliminarUsuario.do?idUsuario=${ep.idUsuario}" onclick="return confirmar()">Eliminar</a> <a href="ModificarUsuario.do?idUsuario=${ep.idUsuario}">Modificar</a></td>
      </tr>
     </c:forEach>
    </table>
   </div>
  </div>
 </div>
 <a href="protegido/admin/form/usuarios/insertarUsuarios.jsp">Insertar</a>
 <%@ include file="/includes/pie.jsp"%>
</body>
</html>