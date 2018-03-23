<%-- 
  Documento : index
  Fecha de Creación : 1/02/2018, 09:17:43 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.bdatos.TipoEventoDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoEventoVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.UsuarioDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String separador = System.getProperty("file.separator");
    String ruta = application.getRealPath("") + separador + "Logs" + separador;
    SesionLogs.Logs.setRuta(ruta + "Logs_");
    SesionLogs.Errores.setRuta(ruta + "Errores_");

    String idUsuario = "1";
    String idTipoEven = String.valueOf(session.getAttribute("tpev_id"));

    if (idUsuario != null) {
        UsuarioDAO UsuarioDAO = new UsuarioDAO();
        UsuarioVO usuarioVO = (UsuarioVO) UsuarioDAO.consultar(idUsuario);
        TipoEventoVO tipoEventoVO = new TipoEventoDAO(usuarioVO.getUsua_id()).bitacora(idTipoEven);
        System.out.println("Aqui llego 1");
        if (usuarioVO != null) {
            System.out.println("Aqui llego 2");
            session.setAttribute("miUsuarioVO", usuarioVO);
            session.setAttribute("tipoEventoVO", tipoEventoVO);
            /**
             * *********************LOGS***********************
             */
            String ip = request.getHeader("X-Forwarded-For");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO.getUsua_id() + ";;INGRESA DESDE IP ;" + ip);

%>
<jsp:include page="/includes/cabecera.jsp"/>
<!--Nueva interfaz -->
<div class="boxes">
    <div class="left_contenttwo">
        <legend>Mis Opciones</legend>
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
        <!--         <div class="form-group">
                    <div class="input-group center-block derecho">  
                        <input type="submit" value="Evento" onclick="location.href = '../evento/eve_eve_ctr.jsp';
                            return false;"  alt="Evento " title="Evento " class="btn btn-info"/>
                    </div>
                </div>-->
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Registro" onclick="location.href = '../registro/for_reg_ctr.jsp';
                        return false;"  alt="Registro " title="Registro " class="btn btn-info"/>
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Persona Hogar" onclick="location.href = '../personas/per_reg_ctr.jsp';
                        return false;"  alt="Persona Hogar" title="Persona Hogar " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Bienes Inmuebles" onclick="location.href = '../bienes/bie_reg_ctr.jsp';
                        return false;"  alt="Bienes Inmuebles Afectados" title="Bienes Inmuebles Afectados " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Cultivos Perdidos" onclick="location.href = '../cultivos/cul_reg_ctr.jsp';
                        return false;"  alt="Cultivos Perdidos" title="Cultivos Perdidos " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
            <div class="input-group center-block derecho">  
                <input type="submit" value="Pecuarios Perdidos" onclick="location.href = '../pecuarios/pec_reg_ctr.jsp';
                        return false;"  alt="Pecuarios Perdidos" title="Pecuarios Perdidos " class="btn btn-info" />
            </div>
        </div>
        <div class="form-group">
                <div class="input-group center-block">  
                    <input type="submit" onclick="location.href = '../menu/eve_eve_ctr.jsp'; return false;" value="Volver" alt="VOLVER" title="VOLVER" class="btn btn-primary"/>
                </div>
            </div>
        <div class="cl">&nbsp;</div>
        <div class="izquierdo">
            <input type="image" onclick="location.href = 'eve_eve_ctr.jsp'; return false;" 
                   alt="SALIR DE LA APLICACIÓN" title="SALIR DE LA APLICACIÓN">
        </div>
    </div>

    <div class="cl">&nbsp;</div>
</div>


<jsp:include page="/includes/footer.jsp"/>
<%  } else {
            response.sendRedirect("../menu/fuera.jsp");
        }
    } else {
        response.sendRedirect("../menu/fuera.jsp");
    }
%>