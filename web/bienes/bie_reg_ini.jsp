<%-- 
  Documento : bie_reg_ini
  Fecha de Creación : 6/02/2018, 03:37:29 PM
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
        <form class="form" method="post" action="bie_reg_ctr.jsp" autocomplete="off" id="FormAplication" name="FormAplication">
            <fieldset class="form-fieldset PaginarTabla">                
                <legend class="text-center">Formulario Registro Bienes Inmuebles Afectados</legend>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.municipio' /></div>
                        <select class="form-control" id="municipio_sel" name="municipio_sel" >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon"><fmt:message key='label.tipoEven' /></div>
                        <select class="form-control" id="tipoeven_sel" name="tipoeven_sel"  >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.tipobien' /></div>
                        <select class="form-control" id="tipobien_sel" name="tipobien_sel" required >
                            <option value="">--</option>
                            <c:forEach var="tipoBienVOs" items="${tipoBienVO}"  varStatus="i">
                                <option value="${tipoBienVOs.argumento}">${tipoBienVOs.resultado}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.tenencia' /></div>
                        <select class="form-control" id="tenencia_sel" name="tenencia_sel" required >
                            <option value="">--</option>
                            <c:forEach var="tenenciaVOs" items="${tenenciaVO}"  varStatus="i">
                                <option value="${tenenciaVOs.argumento}">${tenenciaVOs.resultado}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.corregimiento' /> 
                        </div>
                        <input id="corregi_txt" name="corregi_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.vereda' /> 
                        </div>
                        <input id="vereda_txt" name="vereda_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.sector' /> 
                        </div>
                        <input id="sector_txt" name="sector_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.barrio' /> 
                        </div>
                        <input id="barrio_txt" name="barrio_txt" class="form-control"  type="text">
                    </div>
                </div>  
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.direccion' /> 
                        </div>
                        <input id="direccion_txt" name="direccion_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon"><fmt:message key='label.afectacion' /></div>
                        <select class="form-control" id="afectacion_sel" name="afectacion_sel" required >
                            <option value="">--</option>
                            <c:forEach var="afectacionVOs" items="${afectacionVO}"  varStatus="i">
                                <option value="${afectacionVOs.argumento}">${afectacionVOs.resultado}</option>
                            </c:forEach>
                        </select>
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
            <fieldset class="form-fieldset">
                <table style="margin: auto; text-align: center; " class="table table-bordered table-hover" cellspacing="1" cellpadding="0" border="1" id="tab2">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th><fmt:message key='label.municipio' /></th>
                            <th><fmt:message key='label.tipoEven' /></th>
                            <th><fmt:message key='label.tipobien' /></th>
                            <th><fmt:message key='label.tenencia' /></th>
                            <th><fmt:message key='label.corregimiento' /></th>
                            <th><fmt:message key='label.vereda' /></th>
                            <th><fmt:message key='label.sector' /></th>
                            <th><fmt:message key='label.barrio' /></th>
                            <th><fmt:message key='label.direccion' /></th>
                            <th><fmt:message key='label.afectacion' /></th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center">
                        <c:set var="color" value="black" />
                        <c:choose>
                            <c:when test="${not empty datos}"> 
                                <c:forEach var="personaVO" items="${PersonaVOs}"  varStatus="i">
                                    <tr>
                                        <td style="text-align: center;"></td> 
                                        <td style="color: ${color}">${personaVO.paac_descripcion}</td>
                                        <td style="color: ${color}">${personaVO.conv_nombre}</td>
                                        <td style="color: ${color}">${personaVO.conv_estado}</td>
                                        <td style="color: ${color}">${personaVO.pege_nombrecomercial}</td>
                                        <td style="color: ${color}">${personaVO.cige_nombre}</td>
                                        <td style="color: ${color}">${personaVO.nombre_docente}</td>
                                        <td style="color: ${color}">${personaVO.acco_supervisor}</td>
                                        <td style="color: ${color}">${personaVO.pege_nombrecomercial}</td>
                                        <td style="color: ${color}">${personaVO.cige_nombre}</td>
                                        <td style="color: ${color}">${personaVO.nombre_docente}</td>
                                        <td style="text-align: center;">Acciones</td> 
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="12">No tiene solicitudes </td>
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
        </form>
   </div>
        <c:import url='/includes/footer.jsp' />
    </c:when>
    <c:otherwise>
        <c:import url="/menu/fuera.jsp" />
    </c:otherwise>
</c:choose>

