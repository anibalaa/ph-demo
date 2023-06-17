<%@ include file="/includes/include.jsp"%>
<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu .dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -1px;
}

.contcolor0 {
	background-color: #5f5448
}

.contcolor1 {
	background-color: white
}

.contcolor2 {
	background-color: #dfd3b6
}
</style>
<body>
    <div class="container">
        <div id="u0" class="contcolor0 panel panel-default">
            <div id="u0_div" class="panel-body"></div>
        </div>
        <div id="u1" class="contcolor1 panel panel-default">
            <!--             <img -->
            <!--                 src="includes/logo.png" -->
            <!--                 class="img-rounded" -->
            <!--                 alt="Proyecto Hombre Asturias"> -->
        </div>
        <div id="u2" class="contcolor2 panel panel-default">
            <div id="u2_div" class="panel-body"></div>
        </div>
        <div class="dropdown">
            <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                INICIO
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li class="dropdown-submenu">
                    <a class="test" tabindex="-1" href="#">
                        PERSONAS / RECORRIDOS
                        <!--                         GESTIÓN DE PACIENTES -->
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a tabindex="-1" href="MostrarPersona.do">Mostrar Personas</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="MostrarUnaPersona.do">Mostrar una Persona</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="MostrarRecorrido.do">Mostrar Recorridos</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="MostrarUnRecorrido.do">Mostrar un Recorrido</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="MostrarUnTratamiento.do?idPersona=1">Mostrar un Tratamiento</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="MostrarMenuAgrupacion.do">Menú Gestión Agrupaciones</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <script>
                    $(document).ready(function() {
                        $('.dropdown-submenu a.test').on("click", function(e) {
                            $(this).parent().parent().find('.dropdown-menu').hide();
                            $(this).next('ul').toggle();
                            e.stopPropagation();
                            e.preventDefault();
                        });
                    });
                </script>
</body>
</html>