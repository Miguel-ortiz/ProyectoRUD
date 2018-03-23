<%-- 
  Documento : eve_eve_ini
  Fecha de Creación : 26/02/2018, 11:04:46 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib uri="http://primefaces.prime.com.tr/" prefix="p" %>--%>

<fmt:setBundle basename="proyecto.idiger.gov.co.utils.labels"/>
<c:import url='/includes/cabecerainit.jsp' />
<div class="boxes">
    <div id="contenidoInterno" style="width: 100%">
        <form class="form" method="post" autocomplete="off" id="FormAplication" name="FormAplication">
            <fieldset class="form-fieldset"> 
                <div class="form-group col-sm-10">
                    <div class="input-group has-error">
                        <div class="input-group-addon"><fmt:message key='label.tipoEven' /></div>
                        <input id="tipoevento_txt" name="tipoevento_txt" class="form-control" 
                               type="text" value="" 
                               placeholder="Digite número de evento sire o nuse" >
                    </div>
                </div>
                <table style="margin: auto; text-align: center; " class="table table-bordered table-hover" cellspacing="1" cellpadding="0" border="1" id="tab2">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th><fmt:message key='label.nombre' /></th>
                            <th><fmt:message key='label.apellido' /></th>
                            <th><fmt:message key='label.parentesco' /></th>
                            <th><fmt:message key='label.genero' /></th>
                            <th><fmt:message key='label.fechaNaci' /></th>
                            <th><fmt:message key='label.edad' /></th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center">
                        <c:set var="color" value="black" />
                        <c:choose>
                            <c:when test="${not empty datos}">
                                <c:forEach var="tipoEventoVOs" items="${tipoEventoVO}"  varStatus="i">
                                    <tr>
                                        <td style="text-align: center;">
                                            <img src="../images/abrir.png" alt="abrir" 
                                                 onclick="enviarCTR('contenidoInterno', 'eve_eve_ctr.jsp?op=2&tpev_id=${tipoEventoVOs.tpev_id}')" />
                                        </td> 
                                        <td style="color: ${color}">${tipoEventoVOs.tpev_id}</td>
                                        <td style="color: ${color}">${tipoEventoVOs.tpev_descripcion}</td>
                                        <td style="color: ${color}">${tipoEventoVOs.tpev_fechaevento}</td>
                                        <td style="text-align: center;"></td> 
                                        <td style="text-align: center;"></td> 
                                        <td style="text-align: center;"></td> 
                                        <td style="text-align: center;">Acciones</td> 
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="8">No tiene evento </td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
                <script>
                    $(function () {
                        // elementos de la lista
                        var menues = $(".input-group");
                        menues.keyup(function () {
                            if (document.getElementById("tipoevento_txt").value != "") {
                                menues.removeClass("has-error");
                                $(this).addClass("has-success");
                               
                            } else {
                                $(this).addClass("has-error");
                            }
                            mostrar();
                        });
                    });
                    function mostrar() {
                        if (document.getElementById("tipoevento_txt").value != "") {
                            document.getElementById("boton1").disabled = "";
                        } else {
                            document.getElementById("boton1").disabled = "disabled";
                        }
                    }

                    var table = {
                        paging: true,
                        paging_length: 10,
                        alternate_rows: true,
                        col_0: "none",
                        col_1: "select",
                        col_2: "select",
                        col_3: "select",
                        col_4: "none",
                        col_5: "select",
                        col_6: "select",
                        col_7: "select",
                        rows_counter: true,
                        rows_counter_text: "Registros:",
                        results_per_page: ['# Registros', [10, 20]],
                        btn_reset: true,
                        enter_key: false,
                        sort_select: true,
                        on_keyup: true,
                        loader: true
                    };
                    tf = setFilterGrid("tab2", table);
                </script>
            </fieldset>
            <center>
                <div class="form-group">
                    <div class="input-group center-block">  
                        <input type="hidden" value="1" id="op" name="op" /> 
                        <input type="hidden" name="request" id="request" value="eve_eve_crt.jsp" />
                        <input name="boton1" id="boton1" type="submit" value="Guardar Persona" disabled = "disabled" class="btn btn-primary activo" />
                    </div>
                </div>
            </center>
        </form>
    </div>
</div>
</div>
<footer id="footer" role="contentinfo"> 
    <div class="container text-left" style="background-color:#073e65; line-height:0.6; padding:15px; padding-right:20px; width:96.5%; margin:0; ">
        <div class="row text-left" style="margin:0; padding:0">
            <div class="right_content" style="line-height:0.8; margin:0; padding:0">
                <h4>Alcaldía Mayor de Bogotá</h4> <p>Cra 8 No. 10-65 - Bogotá</p>
                <p>Teléfono: (57 1) 3813000</p> <p>Horario de Atención al público</p>
                <p>Lunes a Viernes de 7:00am a 4:30pm</p> 
            </div>
            <div class="right_content" style="line-height:0.8; margin:0; padding:">
                <img src="http://www.idiger.gov.co/documents/20182/0/logo-alcaldiaok.png/77e00292-d5d0-498c-ae08-552e9eb18177?t=1475856214141">
            </div>
            <div class="pull-right text-right" style="line-height:0.8; margin:0; padding:1px"> 
                <h4>Instituto Distrital de Gestión de Riesgos y Cambio Climático</h4>
                <p>Nit:800154275-1</p> 
                <p>Diagonal 47 # 77A-09 Int.11 - Bogotá</p>
                <p>Conmutador: (57 1) 4292800</p>
                <p><a href="mailto:idiger@idiger.gov.co" style="color:#fff">idiger@idiger.gov.co</a></p> 
                <p>Horario de Atención al público:</p>
                <p>Lunes a Viernes de 7:30am a 4:30pm</p>
            </div>
        </div> 
    </div> 
    <div class="container text-center" style="padding:5px; width:96.5%; margin:0;">
        <div class="row " style="margin:0; padding:0">
            <div class="copyright span10" style="margin:0; padding:0"> 
                <p>Copyright 2016. Todos los derechos reservados por IDIGER</p>
            </div> 
        </div>
    </div> 
</footer>
<!--END PAGE SOURCE-->
</div></div>
</body>
</html>
