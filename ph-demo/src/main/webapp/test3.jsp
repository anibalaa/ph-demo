<%@ include file="/includes/include.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsBikeBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/JsModeloBean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript">
    function cambiar(sel4) {
        var sel4 = document.getElementById(sel4);
        console.log(sel4.value);
    }
</script>
<script type="text/javascript">
    window.onload = function() {
        setupSelect();
    }

    function setupSelect() {
        JsBikeBean.getDesignerInfo(populate);
    }

    function populate(list) {
        dwr.util.removeAllOptions("bikes");
        dwr.util.addOptions("bikes", list);
    }

    function setupSelect2(value) {

        console.log("value: " + value);
        JsModeloBean.getModeloInfo(value, populate2);
    }
    function populate2(list) {
        dwr.util.removeAllOptions("modelos");
        dwr.util.addOptions("modelos", list);
    }
</script>
<body>
    <form action="void(0)" accept-charset="utf-8" method="post">
        <h2>Estas en TEST3</h2>
        <p>
            Bikes:
            <select id="bikes" onchange="setupSelect2(this.value)">
            </select>
            Modelos:
            <select id="modelos" onchange="cambiar(this.id)">
            </select>
        </p>
    </form>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>