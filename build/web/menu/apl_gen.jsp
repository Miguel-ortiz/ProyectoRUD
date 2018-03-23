<%-- 
  Documento : apl_gen
  Fecha de Creación : 22/01/2018, 11:08:46 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.bdatos.TipoEventoDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoEventoVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.UsuarioDAO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
//    String separador = System.getProperty("file.separator");
//    String ruta = application.getRealPath("") + separador + "Logs" + separador;
//    SesionLogs.Logs.setRuta(ruta + "Logs_");
//    SesionLogs.Errores.setRuta(ruta + "Errores_");
//
//    String idUsuario = "1";
//    String idTipoEven = String.valueOf(session.getAttribute("tpev_id"));
//
//    if (idUsuario != null) {
//        UsuarioDAO UsuarioDAO = new UsuarioDAO();
//        UsuarioVO usuarioVO = (UsuarioVO) UsuarioDAO.consultar(idUsuario);
//        TipoEventoVO tipoEventoVO = new TipoEventoDAO(usuarioVO.getUsua_id()).bitacora(idTipoEven);
//        System.out.println("Aqui llego 1");
//        if (usuarioVO != null) {
//            System.out.println("Aqui llego 2");
//            session.setAttribute("miUsuarioVO", usuarioVO);
//            session.setAttribute("tipoEventoVO", tipoEventoVO);
//            /**
//             * *********************LOGS***********************
//             */
//            String ip = request.getHeader("X-Forwarded-For");
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("HTTP_CLIENT_IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getRemoteAddr();
//            }
//            SesionLogs.Logs.RegistrarLogs(usuarioVO.getUsua_id() + ";;INGRESA DESDE IP ;" + ip);
            /**
             * ************************************************
             */
%>
<html>
    <head>
        <title>IDIGER - Registro Unico de Desartres </title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>
    <body>
        <form name="form1" id="form1" method="post">
            <input type="hidden" name="pagina" id="pagina" value="/ProyectoRUD/menu/eve_eve_ctr.jsp" />
        </form>
    </body>
    <script language="JavaScript" type="text/JavaScript">
        function enviar(frm , dir){
        frm.action = dir;
        frm.submit();
        }

        var isOpera = ( /opera/i.test ( navigator.userAgent ) ) ;
        var isIE 	= ( /msie/i.test ( navigator.userAgent ) && !isOpera ) ;
        var isGecko	= ( /gecko/i.test ( navigator.userAgent ) ) ;

        if ( !isGecko && !isIE ) {
        enviar(document.forms['form1'] , '/ProyectoRUD/menu/navegador.jsp');
        }else{
        enviar(document.forms['form1'] , '/ProyectoRUD/menu/inicioSeguro.jsp');
        }
    </script>
</html>
<%       
//    } else {
//            response.sendRedirect("../menu/fuera.jsp");
//        }
//    } else {
//        response.sendRedirect("../menu/fuera.jsp");
//    }
%>