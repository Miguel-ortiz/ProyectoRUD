<%-- 
  Documento : cabecera
  Fecha de Creación : 31/01/2018, 10:37:57 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>IDIGER - Registro Unico de Desartres</title>
        <meta http-equiv="Content-Type" content="text/html" charset="iso-8859-1" />
        <link href="../css/forms.css" rel="stylesheet" type="text/css"/>
        <link href="../includes/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap/easyui.css" rel="stylesheet" type="text/css"/>
        <link href="../css/alertify/alertify.core.css" rel="stylesheet" type="text/css"/>
        <link href="../css/alertify/alertify.default.css" rel="stylesheet" type="text/css"/>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="../css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css"/>
        <!--<link href="../css/modalLoader.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="../css/style_light.css" rel="stylesheet" type="text/css"/>-->
<!--        <link href="../css/tablas.css" rel="stylesheet" type="text/css"/>
        <link href="../css/tablasextra.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="../css/timepicki.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="../css/ui.css" rel="stylesheet" type="text/css"/>-->
        
        <!--<script src="../js/Filter/tablefilter.js" type="text/javascript"></script>-->
        <script src="../js/external/jquery/jquery.js?<%=Math.random()%>" type="text/javascript"></script>
        <!--<script src="../js/additional-methods.js" type="text/javascript"></script>-->
        <script src="../js/alertify.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
        <script src="../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../js/controlador.js?<%=Math.random()%>" type="text/javascript"></script>
        <!--<script src="../js/dialog-patch.js" type="text/javascript"></script>-->
        <script src="../js/iframes-controllers.js" type="text/javascript"></script>
        <script src="../js/jquery-ui.min.js" type="text/javascript"></script>
        <script src="../js/jquery.autocomplete.js" type="text/javascript"></script>
        <!--<script src="../js/jquery.blockUI.js" type="text/javascript"></script>-->
        <!--<script src="../js/jquery.easyui.min.js" type="text/javascript"></script>-->
        <script src="../js/jquery.fileupload-ui.js" type="text/javascript"></script>
        <script src="../js/jquery.fileupload-uix.js" type="text/javascript"></script>
        <script src="../js/jquery.fileupload.js" type="text/javascript"></script>
        <script src="../js/jquery.js?<%=Math.random()%>" type="text/javascript"></script>
<!--        <script src="../js/jquery.tablesorter.js" type="text/javascript"></script>
        <script src="../js/jquery.tablesorter.pager.js" type="text/javascript"></script>
        <script src="../js/jquery.tabs.js" type="text/javascript"></script>-->
<!--        <script src="../js/jquery.uniform.js" type="text/javascript"></script>
        <script src="../js/jquery.validate.js" type="text/javascript"></script>
        <script src="../js/timepicki.js" type="text/javascript"></script>-->
        <script src="../ckeditor/ckeditor.js" type="text/javascript"></script>
    </head>
    <!-- START PAGE SOURCE -->
    <body  id="cprincipal" style="min-height: 500px; padding: 5px 5px;">
        <style> 
            footer{ background-color:#fff; color:#fff; overflow:hidden; }
            @media (min-width: 980px) { footer{ width:1000px; margin:0 auto; } } 
            @media (max-width: 979px) { footer{ width:98%; margin:0 auto; } } 
        </style> 
        <script type="text/javascript">
            $('#cprincipal').css('height', ($(window).height() - 15) + 'px');
            $('#shell').css('width', ($(window).width() - 20) + 'px');
        </script>
        <div class="body-bg">
            <div class="shell" id="shell" >  
                <div class="logo"></div>
                <br/>
                <div id="main" >
                    <br/>
                    <div class="usuario text-center">
                        <%  out.print("bienvenido ");
                            UsuarioVO MiUsuarioVO = (UsuarioVO) session.getAttribute("miUsuarioVO");
                            out.print(MiUsuarioVO.getNum_completo()+", ");
                            out.print(MiUsuarioVO.getUsua_entidad());
                            SesionLogs.Logs.RegistrarLogs(MiUsuarioVO.getUsua_id() + ";;INGRESA A JSP ;" + request.getRequestURL());
                        %>   
                    </div>





