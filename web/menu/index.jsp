<%-- 
  Documento : index
  Fecha de Creación : 1/02/2018, 09:17:43 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String a = "";
    // MiUsuarioVO MiUsuarioVO = (MiUsuarioVO) session.getAttribute("miUsuarioVO");
    if (a != null) {
%>
<jsp:include page="/includes/cabecera.jsp"/>
<!--Nueva interfaz -->
<div class="boxes">
    <div class="left_contenttwo">
        <legend>Opciones</legend>
        <!--%
            try {
                FuncionalidadUsuarioDAO FuncionalidadUsuarioDAO = new FuncionalidadUsuarioDAO();
                FuncionalidadUsuarioDAO.FuncionalidadesPermitidas(
                        Integer.parseInt(session.getAttribute("apli_id").toString()),
                        0,
                        Integer.parseInt(MiUsuarioVO.getIdPersona()),
                        "",
                        out);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        %-->
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Registro" onclick="location.href = '../registro/for_reg_per.jsp';
                    return false;"  alt="Registro " title="Registro " class="btn btn-info"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Persona Hogar" onclick="location.href = '../personas/per_reg_reg.jsp';
                    return false;"  alt="Persona Hogar" title="Persona Hogar " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Bienes Inmuebles" onclick="location.href = '../bienes/bie_reg_bia.jsp';
                    return false;"  alt="Bienes Inmuebles Afectados" title="Bienes Inmuebles Afectados " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Cultivos Perdidos" onclick="location.href = '../cultivos/cul_reg_rcp.jsp';
                    return false;"  alt="Cultivos Perdidos" title="Cultivos Perdidos " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Pecuarios Perdidos" onclick="location.href = '../pecuarios/pec_reg_rpp.jsp';
                    return false;"  alt="Pecuarios Perdidos" title="Pecuarios Perdidos " class="btn btn-info" />
            </div>
        </div>
        <div class="cl">&nbsp;</div>
        <div class="izquierdo">
            <input type="image" onclick="ventanaCerrar();
                    return false;" src="../images/salir.png" alt="SALIR DE LA APLICACION" title="SALIR DE LA APLICACION">
        </div>
    </div>

    <div class="cl">&nbsp;</div>
</div>


<jsp:include page="/includes/footer.jsp"/>
<% } else {
        response.sendRedirect("fuera.jsp");
    }%>