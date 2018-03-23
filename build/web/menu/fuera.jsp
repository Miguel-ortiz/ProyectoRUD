<%-- 
  Documento : reg_per_per
  Fecha de Creación : 31/01/2018, 10:37:57 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="../css/ui.css" />

        <title>IDIGER - Registro Unico de Desartres</title>

        <meta http-equiv="Content-Type" content="text/html" charset="iso-8859-1" />
        <link rel="stylesheet" type="text/css" href="../css/forms.css" />
        <link rel="stylesheet" type="text/css" href="../css/tablas.css" />
        <link rel="stylesheet" type="text/css" href="../includes/css/style.css" />
        <!--<link rel="stylesheet" type="text/css" href="../css/bootstrap/easyui.css" />-->
        <link rel="stylesheet" type="text/css" href="../css/ui.css" />
        <link rel="stylesheet" type="text/css" href="../css/alertify/alertify.core.css" />
        <link rel="stylesheet" type="text/css" href="../css/alertify/alertify.default.css" />
        <!--<link rel="stylesheet" type="text/css" href="../css/timepicki.css" />-->
        <link rel="stylesheet" type="text/css" href="../css/modalLoader.css" />
        <script type="text/javascript" src="../js/jquery.js"></script>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="../js/jquery-ui.min.js"></script>
        <!--<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>-->
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
    <style type="text/css" media="screen">
        body {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            color: #666;
        }
        h1 {
            margin-top: 0;
        }
        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        li {
            margin-bottom: 5px;
            clear: both;
        }
        label {
            font-size: 12px;
            font-weight: bold;
            text-transform: uppercase;
            display: block;
            color: #000;
            margin-bottom: 3px;
            clear: both;
        }
        footer{ background-color:#009fe1; color:#fff; overflow:hidden; }
        @media (min-width: 980px) { footer{ width:1000px; margin:0 auto; } } 
        @media (max-width: 979px) { footer{ width:98%; margin:0 auto; } } 
    </style> 
</head>
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
            <!--<div id="main" >-->
    
    
    <div class="ui-widget">
        <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
            <p style="font-size: 14px; font-family: sans-serif; text-align: center;"><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
                La sesion no a podido ser verificada esto es debido a que el tiempo establecido de inactividad de su sesion se ha vencido o esta intentando ingresar de manera no autorizada a este sistema.
                <br/><br/>
                Recomendamos realizar nuevamente el ingreso.
                <!-- END PAGE SOURCE -->
            </p>
        </div>
    </div>
    
    
 <!--</div>-->
        <footer id="footer" role="contentinfo"> 
            <div class="container text-left" style="background-color:#073e65; line-height:0.6; padding:15px; padding-right:20px; width:96.5%; margin:0; ">
                <div class="row text-left" style="margin:0; padding:0">
                    <div class="right_content" style="line-height:0.8; margin:0; padding:0">
                        <h4>Alcaldía Mayor de Bogotá</h4> <p>Cra 8 No. 10-65 - Bogotá</p>
                        <p>Teléfono: (57 1) 3813000</p> <p>Horario de Atención al público</p>
                        <p>Lunes a Viernes de 7:00am a 4:30pm</p> 
                    </div>
                    <div class="right_content" style="line-height:0.8; margin:0; padding:">
                        <img src="http://www.idiger.gov.co/documents/20182/0/logo-alcaldiaok.png/77e00292-d5d0-498c-ae08-552e9eb18177?t=1475856214141">
                    </div>
                    <div class="pull-right text-right" style="line-height:0.8; margin:0; padding:1px"> 
                        <h4>Instituto Distrital de Gestión de Riesgos y Cambio Climático</h4>
                        <p>Nit:800154275-1</p> 
                        <p>Diagonal 47 # 77A-09 Int.11 - Bogotá</p>
                        <p>Conmutador: (57 1) 4292800</p>
                        <p><a href="mailto:idiger@idiger.gov.co" style="color:#fff">idiger@idiger.gov.co</a></p> 
                        <p>Horario de Atención al público:</p>
                        <p>Lunes a Viernes de 7:30am a 4:30pm</p>
                    </div>
                </div> 
            </div> 
            <div class="container text-center" style="padding:5px; width:96.5%; margin:0;">
                <div class="row " style="margin:0; padding:0">
                    <div class="copyright span10" style="margin:0; padding:0"> 
                        <p>Copyright 2016. Todos los derechos reservados por IDIGER</p>
                    </div> 
                </div>
            </div> 
        </footer>
        <!--END PAGE SOURCE-->
    </div></div>
</body>
</html>
