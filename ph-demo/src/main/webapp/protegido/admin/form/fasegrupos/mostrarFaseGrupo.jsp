<%@ include file="/includes/include.jsp"%>
<body>
    <h1>Fase - Grupo</h1>
    <h4>Verifique la selección antes de ser grabada</h4>
    <br>
    <form method="post" action="InsertarFaseGrupo2.do" accept-charset="utf-8">
        <table>
            <thead>
                <tr>
                    <th>Fase</th>
                </tr>
            </thead>
            <tbody>
                <c:catch var="catchtheException1">
                    <tr>
                        <td>
                            <c:out value="${requestScope.idFase }" />
                            <input type="hidden" name="idFase" value="${requestScope.idFase }">
                        </td>
                    </tr>
                </c:catch>
                <c:if test="${catchtheException1 != null }">
                    <p>
                        The type of exception is: ${catchtheException1 }
                        <br />
                        There is an exception: ${catchtheException1.message }
                    </p>
                </c:if>
            </tbody>
        </table>
        <input type="submit" value="Grabar selecion" />
        <table>
            <thead>
                <tr>
                    <th colspan="3">Listado de cambios en Grupos</th>
                </tr>
                <tr>
                    <th>sin cambios</th>
                    <th>nuevos marcados a insertar</th>
                    <th>desmarcados a eliminar</th>
                </tr>
            </thead>
            <tbody>
                <!--                                     cada 8 tds, se se podría saltar de columna para aprobechar la pantalla -->
                <tr>
                    <td>
                        <c:catch var="catchtheexception2">
                            <c:choose>
                                <c:when test="${requestScope.listaSinCambios == null}">
                                    <input type="hidden" name="listaSinCambios" value="0">
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${requestScope.listaSinCambios }" var="ep3">
                                        <c:out value="${ep3.getIdGrupo() }"></c:out>
                                        <input type="hidden" name="listaSinCambios" value="${ep3.getIdGrupo() }">
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </c:catch>
                        <c:if test="${catchtheexception2 != null }">
                            <p>
                                The type of exception is: ${catchtheException2 }
                                <br />
                                There is an exception: ${catchtheException2.message }
                            </p>
                        </c:if>
                    </td>
                    <td>
                        <c:catch var="catchtheexception3">
                            <c:choose>
                                <c:when test="${requestScope.listaDeNuevosMarcados == null}">
                                    <input type="hidden" name="listaDeNuevosMarcados" value="0">
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${requestScope.listaDeNuevosMarcados }" var="ep4">
                                        <c:out value="${ep4.getIdGrupo() }"></c:out>
                                        <input type="hidden" name="listaDeNuevosMarcados" value="${ep4.getIdGrupo() }">
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </c:catch>
                        <c:if test="${catchtheexception3 != null }">
                            <p>
                                The type of exception is: ${catchtheException3 }
                                <br />
                                There is an exception: ${catchtheException3.message }
                            </p>
                        </c:if>
                    </td>
                    <td>
                        <c:catch var="catchtheexception4">
                            <c:choose>
                                <c:when test="${requestScope.listaDeDesmarcados == null}">
                                    <input type="hidden" name="listaDeDesmarcados" value="0">
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${requestScope.listaDeDesmarcados }" var="ep5">
                                        <c:out value="${ep5.getIdGrupo() }"></c:out>
                                        <input type="hidden" name="listaDeDesmarcados" value="${ep5.getIdGrupo() }">
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            (LOS DESMARCADOS AUN NO SE BORRAN DE LA BD, AUN NO FUNCIONA TODAVÍA)
                        </c:catch>
                        <c:if test="${catchtheexception4 != null }">
                            <p>
                                The type of exception is: ${catchtheException4 }
                                <br />
                                There is an exception: ${catchtheException4.message }
                            </p>
                        </c:if>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>