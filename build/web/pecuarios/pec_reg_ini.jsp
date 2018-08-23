<%-- 
  Documento : pec_reg_ini
  Fecha de Creación : 7/02/2018, 01:54:57 PM
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
<!DOCTYPE html>
<c:choose>
    <c:when test="${not empty miUsuarioVO}">
        <c:import url='/includes/cabecera.jsp' />
        <c:set var="personaVO" value="${personaVO}" />
        <div class="boxes">
            <div class="form-group">
                <div class="input-group center-block">  
                    <input type="submit" onclick="location.href = '../menu/index.jsp'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
                </div>
            </div>
            <br/>
            <form class="form" method="post" action="pec_reg_ctr.jsp" autocomplete="off" id="FormAplication" name="FormAplication">
                <fieldset class="form-fieldset PaginarTabla">                
                    <legend class="text-center">Formulario Registro Pecuario</legend>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.pecuario' /></div>
                            <select class="form-control" id="pecuario_sel" name="pecuario_sel" required >
                                <option value="">--</option>
                                <c:forEach var="pecuariosRUDVOs" items="${pecuariosRUDVO}"  varStatus="i">
                                    <option value="${pecuariosRUDVOs.argumento}">${pecuariosRUDVOs.resultado}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.cantidad' /> 
                            </div>
                            <input id="cantidad_txt" name="cantidad_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-3 col-md-3">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.especipez' /> 
                            </div>
                            <input id="especipez_txt" name="especipez_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-10">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.observas' /></div>
                            <textarea  class="form-control" name="obserpecua_txt" id="obserpecua_txt" rows="2" cols="100">
                            </textarea>
                        </div>
                    </div>
                </fieldset>
                <br/> 
                <center>
                    <div class="form-group">
                        <div class="input-group center-block">  
                            <input type="hidden" value="1" id="op" name="op" /> 
                            <input type="submit" value="Guardar Persona" class="btn btn-primary" />
                        </div>
                    </div>
                </center>
                <c:if test="${datos eq 'si'}">
                    <fieldset class="form-fieldset">
                        <table style="margin: auto; text-align: center; " class="table table-bordered table-hover" cellspacing="1" cellpadding="0" border="1" id="tab2">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th><fmt:message key='label.pecuario' /></th>
                                    <th><fmt:message key='label.cantidad' /></th>
                                    <th><fmt:message key='label.especipez' /></th>
                                    <th><fmt:message key='label.observas' /></th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:set var="color" value="black" />
                                <c:choose>
                                    <c:when test="${not empty datos}"> 
                                        <c:forEach var="pecuariosRUDVOs" items="${pecuariosRUDVOs}"  varStatus="i">
                                            <tr>
<!--                                                <td style="text-align: center;"></td> -->
                                                <td style="color: ${color}">${pecuariosRUDVOs.pecu_id}</td>
                                                <td style="color: ${color}">${pecuariosRUDVOs.tppc_descripcion}</td>
                                                <td style="color: ${color}">${pecuariosRUDVOs.pecu_cantidad}</td>
                                                <td style="color: ${color}">${pecuariosRUDVOs.pecu_especiepez}</td>
                                                <td style="color: ${color}">${pecuariosRUDVOs.pecu_observaciones}</td>
                                                <td style="text-align: center;">Acciones</td> 
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="6">No tiene solicitudes </td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                        <script>
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
                </c:if>
            </form>
        </div>
        <c:import url='/includes/footer.jsp' />
    </c:when>
    <c:otherwise>
        <c:import url="/menu/fuera.jsp" />
    </c:otherwise>
</c:choose>
