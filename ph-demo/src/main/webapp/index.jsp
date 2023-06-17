<%@ include file="/includes/include.jsp"%>
<!-- saco el código CSS a un archivo -->
<link rel="stylesheet" type="text/css" href="includes/index.css" />
<script type="text/javascript">
    $(document).ready(function() {
        $('.dropdown-submenu a.test').on("click", function(e) {
            $(this).parent().parent().find('.dropdown-menu').hide();
            $(this).next('ul').toggle();
            e.stopPropagation();
            e.preventDefault();
        });
    });
</script>
<!-- 
<script type="text/javascript">
    var str_t = "includes/pics/9855ea57.png";
    var str_p = "includes/pics/6c871b4e.png";
    var str_f = "includes/pics/65c5f0b8.png";
    var str_g = "includes/pics/f0565fff.png";
    var str_m = "includes/pics/22ba37cb.png";
    var str_ip = "includes/pics/09ac4b8d.png";
    var str_mp = "includes/pics/6935411a.png";
    var str_mup = "includes/pics/d283e19a.png";
    var str_crp = "includes/pics/ba49bc33.png";
    var str_crm = "includes/pics/886e17e5.png";
    var str_ipr = "includes/pics/79c5a375.png";
    var str_r3 = "includes/pics/743ec3b1.png";

    var str_rtp = "includes/pics/b5167709.png";
    var str_rpf = "includes/pics/2b7eb3de.png";
    var str_rfg = "includes/pics/c6663690.png";

    $(document).ready(function() {
        $('#a_t').on("mouseover", function(e) {
            $('#img_body').prop("src", str_t);
        });
    });
    $(document).ready(function() {
        $('#a_t').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_p').on("mouseover", function(e) {
            $('#img_body').prop("src", str_p);
        });
    });
    $(document).ready(function() {
        $('#a_p').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_f').on("mouseover", function(e) {
            $('#img_body').prop("src", str_f);
        });
    });
    $(document).ready(function() {
        $('#a_f').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_g').on("mouseover", function(e) {
            $('#img_body').prop("src", str_g);
        });
    });
    $(document).ready(function() {
        $('#a_g').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_m').on("mouseover", function(e) {
            $('#img_body').prop("src", str_m);
        });
    });
    $(document).ready(function() {
        $('#a_m').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_ip').on("mouseover", function(e) {
            $('#img_body').prop("src", str_ip);
        });
    });
    $(document).ready(function() {
        $('#a_ip').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_mp').on("mouseover", function(e) {
            $('#img_body').prop("src", str_mp);
        });
    });
    $(document).ready(function() {
        $('#a_mp').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_mup').on("mouseover", function(e) {
            $('#img_body').prop("src", str_mup);
        });
    });
    $(document).ready(function() {
        $('#a_mup').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_crp').on("mouseover", function(e) {
            $('#img_body').prop("src", str_crp);
        });
    });
    $(document).ready(function() {
        $('#a_crp').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_crm').on("mouseover", function(e) {
            $('#img_body').prop("src", str_crm);
        });
    });
    $(document).ready(function() {
        $('#a_crm').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_ipr').on("mouseover", function(e) {
            $('#img_body').prop("src", str_ipr);
        });
    });
    $(document).ready(function() {
        $('#a_ipr').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
    $(document).ready(function() {
        $('#a_r3').on("mouseover", function(e) {
            $('#img_body').prop("src", str_r3);
        });
    });
    $(document).ready(function() {
        $('#a_r3').on("mouseout", function(e) {
            $('#img_body').prop("src", "");
        });
    });
</script>
 -->
<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale }" scope="session" />
<fmt:setLocale value="${theLocale}" />
<fmt:setBundle basename="com.ph3.i18n.lang.mylabels" />
<body>
    <div class="container-fluid">
        <div id="u0" class="card-header bg-light card">
            <div id="u0_div" class="card-block"></div>
        </div>
        <div id="u1" class="card-body bg-secondary card">
            <p style="text-align: center">PH-DEMO WebApp y BD Versión: 21/01/2018 (En Construcción)</p>
        </div>
        <div id="u2" class="card-footer bg-light card">
            <div id="u2_div" class="card-block">
                <div>
                    <a href="index.jsp?theLocale=es_ES">
                        Spanish (ES)
                        <img src="includes/es_ES.png" height="15px" width="45px">
                    </a>
                    <a href="index.jsp?theLocale=gl_GL">
                        Galician (GL)
                        <img src="includes/gl_GL.png" height="15px" width="45px">
                    </a>
                    <a href="index.jsp?theLocale=ca_CA">
                        Catalan (CA)
                        <img src="includes/ca_CA.png" height="15px" width="45px">
                    </a>
                    <a href="index.jsp?theLocale=va_VA">
                        Basque (VA)
                        <img src="includes/eu_EU.png" height="15px" width="45px">
                    </a>
                    <a href="index.jsp?theLocale=en_EN">
                        English (US)
                        <img src="includes/en_US.png" height="15px" width="45px">
                    </a>
                </div>
            </div>
        </div>
        <div id="u3" class="dropdown">
            <button class="btn-sm btn-secondary dropdown-toggle" type="button" data-toggle="dropdown">
                <fmt:message key="label.start_button" />
            </button>
            <ul class="dropdown-menu">
                <li class="dropdown-submenu">
                    <a class="test dropdown-item" tabindex="-1" href="#">
                        <fmt:message key="label.device_management_button" />
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a id="a_t" class="dropdown-item" tabindex="-1" href="MostrarTratamiento.do">
                                <fmt:message key="label.treatment_management_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_p" class="dropdown-item" tabindex="-1" href="MostrarPrograma.do">
                                <fmt:message key="label.program_management_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_f" class="dropdown-item" tabindex="-1" href="MostrarFase.do">
                                <fmt:message key="label.phase_management_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_g" class="dropdown-item" tabindex="-1" href="MostrarGrupo.do">
                                <fmt:message key="label.group_management_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_m" class="dropdown-item" tabindex="-1" href="MostrarMotivo.do">
                                <fmt:message key="label.management_of_reasons_button" />
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown-submenu">
                    <a class="test dropdown-item" tabindex="-1" href="#">
                        <fmt:message key="label.people_routes_button" />
                    </a>
                    <ul class="dropdown-menu ">
                        <li>
                            <a id="a_ip" class="dropdown-item" tabindex="-1" href="InsertarPersona2.do">
                                <fmt:message key="label.insert_person_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_mp" class="dropdown-item" tabindex="-1" href="MostrarPersona.do">
                                <fmt:message key="label.show_people_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_mup" class="dropdown-item" tabindex="-1" href="MostrarUnaPersona.do">
                                <fmt:message key="label.show_a_person_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_crp" class="dropdown-item" tabindex="-1" href="ConsultarRecorrido.do">
                                <fmt:message key="label.consult_routes_per_person_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_crm" class="dropdown-item" tabindex="-1" href="ConsultarRecorrido2.do">
                                <fmt:message key="label.see_routes_for_reason_button" />
                            </a>
                        </li>
                        <li>
                            <a id="a_ipr" class="dropdown-item" tabindex="-1" href="InsertarPersonaRecorrido.do">
                                <fmt:message key="label.enter_person_on_route_button" />
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="CambiarRecorridoPersona.do">
                                <fmt:message key="label.change_the_route_of_a_person_button" />
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="MostrarRecorrido.do">
                                <fmt:message key="label.show_routes_button" />
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="MostrarUnRecorrido.do">
                                <fmt:message key="label.show_a_route_button" />
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown-submenu">
                    <a class="test dropdown-item" tabindex="-1" href="#">
                        <fmt:message key="label.other_websites_not_classified_yet" />
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a id="a_r3" class="dropdown-item" tabindex="-1" href="MostrarMenuAgrupacion.do">
                                <fmt:message key="label.group_management_menu_button" />
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="MostrarTratamientoPrograma.do">Mostrar TratamientoPrograma</a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="RelacionarTratamientoPrograma.do">Relacionar Programas con un Tratamiento</a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="MostrarProgramaFase.do">Mostrar ProgramaFase </a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="RelacionarProgramaFase.do">Relacionar Fases con un Programa</a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="MostrarFaseGrupo.do">Mostrar FaseGrupo</a>
                        </li>
                        <li>
                            <a class="dropdown-item" tabindex="-1" href="RelacionarFaseGrupo.do">Relacionar Grupos con una Fase </a>
                        </li>
                        <!--                         <li> -->
                        <!--                             <a class="dropdown-item" tabindex="-1" href="test.jsp">Prueba de select con AJAX</a> -->
                        <!--                         </li> -->
                        <!--                         <li> -->
                        <!--                             <a class="dropdown-item" tabindex="-1" href="test2.jsp">Prueba de select con AJAX2 :)</a> -->
                        <!--                         </li> -->
                        <!--                         <li> -->
                        <!--                             <a class="dropdown-item" tabindex="-1" href="test4.jsp">Prueba de select con AJAX4</a> -->
                        <!--                         </li> -->
                    </ul>
                </li>
            </ul>
        </div>
        <div id="u4" class="card-header bg-light card">
            <div id="u0_div" class="card-block">
                <a href="includes/manual_ph-demo.pdf">Manual PH-DEMO</a>
                <!-- 
                	<a href="https://youtu.be/-4qMzOUivLo">ScreenCast1 Youtube 54'</a>
                	<a href="https://youtu.be/eafuALbcVz4">ScreenCast2 Youtube 6'</a>
  				-->           
            </div>
        </div>
        <div id="u5" class="card-fotter bg-light card" style="display: flex; justify-content: flex-end; align-items: flex-end; height: 350px; border: solid 1px DeepSkyBlue;">
            <div>
                <img id="img_body" src="includes/logo.png" height="34px">
            </div>
            <div id="u5_div" class="card-block">
                Aníbal Álvarez Álvarez
                <br />
                Webmaster
            </div>
        </div>
    </div>
    <!--     código Insight Tag de Linkedin -->
    <script type="text/javascript">
                    _linkedin_data_partner_id = "190458";
                </script>
    <script type="text/javascript">
                    (function() {
                        var s = document.getElementsByTagName("script")[0];
                        var b = document.createElement("script");
                        b.type = "text/javascript";
                        b.async = true;
                        b.src = "https://snap.licdn.com/li.lms-analytics/insight.min.js";
                        s.parentNode.insertBefore(b, s);
                    })();
                </script>
    <noscript>
        <img height="1" width="1" style="display: none;" alt="" src="https://dc.ads.linkedin.com/collect/?pid=190458&fmt=gif" />
    </noscript>
    <!--     fin del código Linkedin -->
</body>
</html>