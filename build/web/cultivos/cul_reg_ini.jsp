<%-- 
  Documento : cul_reg_ini
  Fecha de Creación : 6/02/2018, 04:31:23 PM
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
        <div class="boxes">
            <div class="form-group">
                <div class="input-group center-block">  
                    <input type="submit" onclick="location.href = '../menu/index.jsp'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
                </div>
            </div>
            <br/>
            <form class="form" method="post" action="cul_reg_ctr.jsp" autocomplete="off" id="FormAplication" name="FormAplication">
                <fieldset class="form-fieldset PaginarTabla">                
                    <legend class="text-center">Formulario Registro Cultivos Perdidos</legend>
                    <div class="form-group col-xs-10 ">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.nomcultivo' /></div>
                            <input id="nomcultivo_txt" name="nomcultivo_txt" class="form-control"  type="text">
                        </div> 
                    </div>
                    <div class="form-group col-xs-2 col-md-2">
                        <div class="input-group" >
                            <div class="input-group-addon"><fmt:message key='label.area' /></div>
                            <input id="area_txt" name="area_txt" type="text" class="form-control" >
                        </div>
                    </div>
                    <div class="form-group col-xs-4 col-md-4">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.unidad' /></div>
                            <select class="form-control" id="unidad_sel" name="unidad_sel" required >
                                <option value="">--</option>
                                <c:forEach var="UnidadVOs" items="${UnidadVO}"  varStatus="i">
                                    <option value="${UnidadVOs.argumento}">${UnidadVOs.resultado}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-2 col-md-2">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.credito' /></div>
                            <select class="form-control" id="credito_sel" name="credito_sel" >
                                <option value="0">No</option>
                                <option value="1">Si</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group .col-xs-offset-3">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.valorcre' /> 
                            </div>
                            <input id="valorcre_txt" name="valorcre_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-10">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <fmt:message key='label.enticredi' /> 
                            </div>
                            <input id="enticredi_txt" name="enticredi_txt" class="form-control"  type="text">
                        </div>
                    </div>
                    <div class="form-group col-xs-10">
                        <div class="input-group">
                            <div class="input-group-addon"><fmt:message key='label.observas' /></div>
                            <textarea  class="form-control" name="obserculti_txt" id="obserculti_txt" rows="2" cols="100">
                            </textarea>
                        </div>
                    </div>
                </fieldset>
                <br/>
                <center>
                    <div class="input-group center-block">
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
                                    <th><fmt:message key='label.tipoEven' /></th>
                                    <th><fmt:message key='label.nomcultivo' /></th>
                                    <th><fmt:message key='label.area' /></th>
                                    <th><fmt:message key='label.unidad' /></th>
                                    <th><fmt:message key='label.credito' /></th>
                                    <th><fmt:message key='label.valorcre' /></th>
                                    <th><fmt:message key='label.enticredi' /></th>
                                    <th><fmt:message key='label.observas' /></th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody style="text-align: center">
                                <c:set var="color" value="black" />
                                <c:forEach var="cultivosAfectadosRUDVO" items="${cultivosAfectadosRUDVO}"  varStatus="i">
                                    <tr>
                                        <!--<td style="text-align: center;"></td>--> 
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_id}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.regi_id}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_nombre}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_area}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_unidad}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_credito}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_valorcredito}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_entiidadcredito}</td>
                                        <td style="color: ${color}">${cultivosAfectadosRUDVO.cuaf_observaciones}</td>
                                        <td style="text-align: center;">Acciones</td> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <script>
                            var table = {
                                paging: true,
                                paging_length: 10,
                                alternate_rows: true,
                                col_0: "none",
                                col_1: "select",
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
                </fieldset>
        </div>
        <c:import url='/includes/footer.jsp' />
    </c:when>
    <c:otherwise>
        <c:import url="/menu/fuera.jsp" />
    </c:otherwise>
</c:choose>