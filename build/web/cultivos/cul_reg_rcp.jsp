<%-- 
  Documento : cul_reg_rcp
  Fecha de Creación : 6/02/2018, 04:31:00 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:choose>
    <c:when test="${not empty miUsuarioVO}">
        <c:import url='/includes/cabecera.jsp' />
        <div class="boxes">
            <div>
                <!--<legend>NUEVO FORMULARIO</legend>-->
                <!--<br/>-->
                <!-- <div id="bmenu" style="width: 100%; "></div>
                     <br/>-->
                <form class="form" method="post" enctype="multipart/form-data" autocomplete="off" id="FormAplication" name="FormAplication">
                    <div id="contenidoInterno" style="width: 100%">
                        <c:import url="/cultivos/cul_reg_ini.jsp"/>
                    </div> 
                </form>
                <div id="dialog" ></div>
            </div>
            <div class="cl">&nbsp;</div>
        </div>
        <c:import url='/includes/footer.jsp' />
    </c:when>
    <c:otherwise>
        <c:import url='menu/fuera.jsp' />
    </c:otherwise>
</c:choose>
<script language="javascript" >
    $('#btSubmit').remove();
</script>