<%-- 
  Documento : for_reg_ini
  Fecha de Creación : 29/01/2018, 11:05:00 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>
<%--<%@page import="java.util.Calendar"%>--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--<%@ taglib uri="http://primefaces.prime.com.tr/" prefix="p" %>--%>

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
                <legend class="text-center">Formulario Registro</legend>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.departamento' /></div>
                        <select class="form-control" id="departamento_sel" name="departamento_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.municipio' /></div>
                        <select class="form-control" id="municipio_sel" name="municipio_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3"> 
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.fechaEven' /></div>
                        <input id="fechaeven_txt" name="fechaeven_txt" class="form-control" type="date">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon"><fmt:message key='label.tipoEven' /></div>
                        <select class="form-control" id="tipoeven_sel" name="tipoeven_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.ubicacion' /></div>
                        <select class="form-control" id="ubicacion_sel" name="ubicacion_sel" required >
                            <option value="">--</option>
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
                            <fmt:message key='label.numFamilia' /> 
                        </div>
                        <input id="numfamil_txt" name="numfamil_txt" class="form-control"  type="text" style="width: 30px">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon" ><fmt:message key='label.fechaElabo' /></div>
                        <input id="fechaelabo_txt" name="fechaelabo_txt" class="form-control" type="date">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.ayuDamni' /></div>
                        <select class="form-control" id="ayudamni_sel" name="ayudamni_sel" >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.materialvivien' /></div>
                        <select class="form-control" id="matervivien_sel" name="matervivien_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.subArriendo' /></div>
                        <select class="form-control" id="subarrien_sel" name="subarrien_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-10">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.tipoayuda' /></div>
                        <textarea name="tipoayuda_txt" id="tipoayuda_txt" rows="2" cols="100">
                        </textarea>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.acueducto' /></div>
                        <select class="form-control" id="acueducto_sel" name="acueducto_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon">
                            <fmt:message key='label.nomAcueducto' /> 
                        </div>
                        <input id="numacueduc_txt" name="numacueduc_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon">
                            <fmt:message key='label.entPrestadora' /> 
                        </div>
                        <input id="entpresta_txt" name="entpresta_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.planContin' /></div>
                        <select class="form-control" id="planContin_sel" name="planContin_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div> 
                <div class="form-group col-sm-10">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.cual' /></div>
                        <textarea name="cualcuntin_txt" id="cualcuntin_txt" rows="2" cols="100">
                        </textarea>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon">
                            <fmt:message key='label.preServi' /> 
                        </div>
                        <input id="preservi_txt" name="preservi_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group">
                        <div class="input-group-addon"><fmt:message key='label.alcantarilla' /></div>
                        <select class="form-control" id="alcantarilla_sel" name="alcantarilla_sel" required >
                            <option value="">--</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon">
                            <fmt:message key='label.responsable' /> 
                        </div>
                        <input id="responsable_txt" name="responsable_txt" class="form-control"  type="text">
                    </div>
                </div>
                <div class="form-group col-sm-3">
                    <div class="input-group" >
                        <div class="input-group-addon">
                            <fmt:message key='label.entidad' /> 
                        </div>
                        <input id="entidad_txt" name="entidad_txt" class="form-control"  type="text">
                    </div>
                </div>
                <center>
                    <div class="dialog-divckeditor"> 
                        <h4><fmt:message key='label.observas' />: </h4>                  
                        <div style="width: 100%;">
                            <center>
                                <textarea name="obserformreg_txt" id="obserformreg_txt" rows="4" cols="150">
                                </textarea>
                            </center>
                        </div>
                    </div>
                </center>
                <script>
                    var config = {
                        toolbar: [
                            ['Bold', 'Italic', 'NumberedList', 'BulletedList', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock', 'Format', 'Font', 'FontSize']],
                        height: "80",
                        width: "100%"
                    };
                    config.skin = 'kama';
                    var motivo = CKEDITOR.replace('obserformreg_txt', config);

                    motivo.on('change', function () {
                        motivo.updateElement();
                    });
                    motivo.on('blur', function () {
                        motivo.updateElement();
                    });
                </script>
            </fieldset>
            <br/>
            <center>
                <div class="form-group">
                    <div class="input-group center-block">  
                        <input type="hidden" value="1" id="op" name="op" /> 
                        <input type="submit" value="Guardar Registro" class="btn btn-primary" />
                    </div>
                </div>
            </center>
        </form>
    </c:when>
    <c:otherwise>
        <c:import url="menu/fuera.jsp" />
    </c:otherwise>
</c:choose>
<script language="javascript" >
    $('#bmenu').remove();
</script>