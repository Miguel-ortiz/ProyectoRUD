<%-- 
  Documento : eve_eve_bus
  Fecha de Creación : 28/02/2018, 11:36:43 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>


<fmt:setBundle basename="proyecto.idiger.gov.co.utils.labels"/>

<div class="form-group">
    <div class="input-group center-block">  
        <input type="submit" onclick="location.href = '../ProyectoRUD/'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
    </div>
</div>
<form class="form" method="post" action="" autocomplete="off" id="FormAplication" name="FormAplication">
    <div class="form-group col-sm-5">
        <div class="input-group">
            <div class="input-group-addon">
                <fmt:message key='label.usuario' /> 
            </div>
            <input id="usuario_txt" name="usuario_txt" class="form-control"  type="text">
        </div>
    </div>
    <div class="form-group col-sm-5">
        <div class="input-group">
            <div class="input-group-addon">
                <fmt:message key='label.clave' /> 
            </div>
            <input id="pass_txt" name="pass_txt" class="form-control"  type="text">
        </div>
    </div>
    <center>
        <div class="form-group">
            <div class="input-group center-block">  
                <input type="hidden" value="3" id="op" name="op" /> 
                <input type="submit" value="Guardar Persona" class="btn btn-primary" onclick="location.href = '../ProyectoRUD/evento/eve_eve_ctr.jsp';" />
            </div>
        </div>
    </center>
</form>


