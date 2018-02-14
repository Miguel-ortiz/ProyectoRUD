<%-- 
  Documento : per_reg_ini
  Fecha de Creación : 5/02/2018, 04:16:35 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib uri="http://primefaces.prime.com.tr/" prefix="p" %>--%>
<!--<link rel="stylesheet" type="text/css" href="../js/TableFilter/tablefilter.js" />-->
<fmt:setBundle basename="proyecto.idiger.gov.co.utils.labels"/>
<!DOCTYPE html>
<div class="form-group">
    <div class="input-group center-block">  
        <input type="submit" onclick="location.href = '../menu/index.jsp'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
    </div>
</div>
<br/>
<c:choose>
    <c:when test="${not empty miUsuarioVO}">
        <form class="form" method="post" action="" autocomplete="off" id="FormAplication" name="FormAplication">
            <fieldset class="form-fieldset PaginarTabla">                
                <legend class="text-center">Formulario Registro Persona</legend>
                <div class="form-group col-sm-5">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.nombre' /> 
                        </div>
                        <input id="nombre_txt" name="nombre_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-5">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.apellido' /> 
                        </div>
                        <input id="apellido_txt" name="apellido_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-4">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.tipoDocumento' /></div>
                        <select class="form-control" id="tipodocumento_sel" name="tipodocumento_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.documento' /> 
                        </div>
                        <input id="documento_txt" name="documento_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.parentesco' /></div>
                        <select class="form-control" id="parentesco_sel" name="parentesco_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.genero' /></div>
                        <select class="form-control" id="genero_sel" name="genero_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3"> 
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.fechaNaci' /></div>
                        <input id="fechanac_txt" name="fechanac_txt" class="form-control" type="date">
                    </div>
                </div>
                <div class="form-group col-sm-2">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.edad' /></div>
                        <input id="edad_txt" name="edad_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon"><fmt:message key='label.afrocolom' /></div>
                        <select class="form-control" id="afrocolom_sel" name="afrocolom_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.etnia' /></div>
                        <select class="form-control" id="etnia_sel" name="etnia_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-2">
                    <div class="input-group">
                        <div class="input-group-addon">
                            <fmt:message key='label.numFamilia' /> 
                        </div>
                        <input id="numfamil_txt" name="numfamil_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.estadosalud' /></div>
                        <select class="form-control" id="estadosalud_sel" name="estadosalud_sel" >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.regisalud' /></div>
                        <select class="form-control" id="regisalud_sel" name="regisalud_sel" required >
                            <option value="">--</option>
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
                            <th><fmt:message key='label.nombre' /></th>
                            <th><fmt:message key='label.apellido' /></th>
                            <th><fmt:message key='label.tipoDocumento' /></th>
                            <th><fmt:message key='label.documento' /></th>
                            <th><fmt:message key='label.parentesco' /></th>
                            <th><fmt:message key='label.genero' /></th>
                            <th><fmt:message key='label.fechaNaci' /></th>
                            <th><fmt:message key='label.edad' /></th>
                            <th><fmt:message key='label.afrocolom' /></th>
                            <th><fmt:message key='label.etnia' /></th>
                            <th><fmt:message key='label.numFamilia' /></th>
                            <th><fmt:message key='label.estadosalud' /></th>
                            <th><fmt:message key='label.regisalud' /></th>
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
                                        <td style="color: ${color}">${personaVO.acco_supervisor}</td>
                                        <td style="color: ${color}">${personaVO.pege_nombrecomercial}</td>
                                        <td style="color: ${color}">${personaVO.pege_nombrecomercial}</td>
                                        <td style="text-align: center;">Acciones</td> 
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="15">No tiene solicitudes </td>
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
    </c:when>
    <c:otherwise>
        <c:import url="menu/fuera.jsp" />
    </c:otherwise>
</c:choose>
<script language="javascript" >
    $('#bmenu').remove();
</script>
