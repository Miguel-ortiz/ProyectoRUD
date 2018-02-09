<%-- 
  Documento : cabecera
  Fecha de Creación : 31/01/2018, 10:37:57 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>IDIGER - Registro Unico de Desartres</title>

        <meta http-equiv="Content-Type" content="text/html" charset="iso-8859-1" />
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="../css/forms.css" />
        <link rel="stylesheet" type="text/css" href="../css/tablas.css" />
        <link rel="stylesheet" type="text/css" href="../includes/css/style.css" />
        <link rel="stylesheet" type="text/css" href="../css/ui.css" />
        <link rel="stylesheet" type="text/css" href="../css/alertify/alertify.core.css" />
        <link rel="stylesheet" type="text/css" href="../css/alertify/alertify.default.css" />
        
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="../js/timepicki.js"></script>
        <script type="text/javascript" src="../js/controlador.js?<%=Math.random()%>"></script>
        <script type="text/javascript" src="../js/jquery.validate.js"></script>
        <script type="text/javascript" src="../js/alertify.js"></script>
        <script src="../js/jquery.fileupload-uix.js" type="text/javascript"></script>
        <script src="../js/jquery.fileupload-ui.js" type="text/javascript"></script>
        <script src="../js/jquery.fileupload.js" type="text/javascript"></script>
        <script type="text/javascript" src="../js/Filter/tablefilter.js"></script>
        <script src="../ckeditor/ckeditor.js" type="text/javascript"></script>
    </head>
    <!-- START PAGE SOURCE -->
    <body  id="cprincipal" style="min-height: 500px; padding: 5px 5px;">
        <style> 
            footer{ background-color:#009fe1; color:#fff; overflow:hidden; }
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
                    <div class="usuario">
                        <%
                            //MiUsuarioVO miUsuarioVO = (MiUsuarioVO) session.getAttribute("miUsuarioVO");
                            out.print("Miguel Ortiz ");
                            out.print("<br>");
                            out.print("Rol");
                            out.print("<br>");
                            out.print("Tipo Emergencia");
                            SesionLogs.Logs.RegistrarLogs("miguel ortiz" + ";;INGRESA A JSP ;" + request.getRequestURL());
                        %>   
                    </div>





