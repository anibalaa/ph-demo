<%@ include file="/includes/include.jsp"%>
<script type="text/javascript">
    function show2(sel) {
        var sel = document.getElementById(sel);
        console.log(sel.value);

    }

    function show(str) {
        if (str == "") {
            document.getElementById("demo").innerHTML = "";
            return;
        } else {
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            } else {
                // code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("demo").innerHTML = this.responseText;
                }
            };
            xmlhttp.open("GET", "Server.do?q=" + str, true);
            xmlhttp.send();
        }
    }

    function xmlhttpPost(strURL) {
        var xmlHttpReq = false;
        var self = this;
        // Mozilla/Safari
        if (window.XMLHttpRequest) {
            self.xmlHttpReq = new XMLHttpRequest();
        }
        // IE
        else if (window.ActiveXObject) {
            self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
        }
        self.xmlHttpReq.open('POST', strURL, true);
        self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        self.xmlHttpReq.onreadystatechange = function() {
            if (self.xmlHttpReq.readyState == 4) {
                updatepage(self.xmlHttpReq.responseText);
            }
        }
        self.xmlHttpReq.send(getquerystring());
    }

    function getquerystring() {
        var word = document.getElementById("slct1").value;
        console.log("word: " + word);
        qstr = 'w=' + escape(word); // NOTE: no '?' before querystring
        return qstr;
    }

    function updatepage(str) {
        document.getElementById("demo").innerHTML = str;
    }
</script>
<body>
    <form name="f1" action="void(0)" accept-charset="utf-8">
        <h3>Cambie de opción:</h3>
        <select name="slct1" id="slct1" onchange="JavaScript:xmlhttpPost('hello.jsp')">
            <option value=""></option>
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="30">30</option>
        </select>
    </form>
    <p id="demo"></p>
    <%@ include file="/includes/pie.jsp"%>
</body>
</html>