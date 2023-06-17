<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsNombrePersonaBean.js"></script>
<script type="text/javascript">
    function setupSelect() {
        JsNombrePersonaBean.getPersonaInfo(populate);
    }
    function populate(list) {
        dwr.util.removeAllOptions("sel-nom");
        dwr.util.addOptions("sel-nom", [ "" ]);
        dwr.util.addOptions("sel-nom", list);
    }
    function imprimir(sel1) {
        var sel1 = document.getElementById(sel1);
        console.log(sel1.value);
    }

    $(document).ready(function() {
        setupSelect();
    });
</script>
<body>
    <form action="void(0)" accept-charset="utf-8" method="post">
        <h2>Estas en TEST4</h2>
        <p>
            Nombre:
            <select id="sel-nom" onchange="javascript:imprimir(this.id)">
            </select>
        </p>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>