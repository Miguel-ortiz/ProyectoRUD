<%-- 
  Documento : fueraC
  Fecha de Creación : 1/02/2018, 09:54:46 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*, java.lang.*" %>
<!DOCTYPE html>


<title>IDIGER - Registro Unico de Desartres</title>
<script language="JavaScript">
    //  ------------------------------------------------------------------------------------
    //      Deshabilita la tecla F2 - F12 ( Solo para Internet Explorer ).
    //      Deshabilita la tecla ALT CTRL ALT-LEFT SHIFT ( Internet Explorer - Netscape ).
    //      Para paginas que no usen Objetos de formulario
    //  ------------------------------------------------------------------------------------

    function clickIE(){
        if (document.all){
            return false;
        }
    }

    function clickNS(e){
        if (document.layers || (document.getElementById && !document.all)){
            if (e.which == 2 || e.which == 3){
                return false;
            }
        }
    }

    if (document.layers){
        document.captureEvents(Event.MOUSEDOWN);
        document.onmousedown = clickNS;
    } else {
        document.onmouseup = clickNS;
        document.oncontextmenu = clickIE;
    }

    var NS = (navigator.appName == "Netscape" && parseInt(navigator.appVersion, 10) >= 5)? true : false;
    var IE = (navigator.appVersion.search(/MSIE/) != -1)? true : false;

    function whichKey(km){
        if (NS){
            try {
                if ( (km.which==16) || (km.which==17) || (km.which==18) || (km.which==8) || (km.which>=111 && km.which<=123)){	
                    //alerta(message);
                    return (false);  
                }
            } catch (e) {
                alert ("Ocurrio un error: " + e.message + "Intenta acceder a una función de tecla que no esta permitida en esta página.");
            }
        }
        else{
            try {		
                if ( (event.altLeft) || (event.altKey) || (event.ctrlKey) || (event.shiftKey) || (event.keyCode == 8) || (event.keyCode >= 111 && event.keyCode <= 123)){  	
                    event.keyCode = 0;	
                    return (false);  
                }
            } catch (e){
                alert ("Ocurrio un error: " + e.message + "Intenta acceder a una función de tecla que no esta permitida en esta página.");
            }
        }
    }

    document.onkeydown = whichKey;
</script> 
<body onLoad="javascript: restaurar();">
    <form name="form1" action="" method="post" >
        <div style="height: 105px; width: 260px;">
            <center>
                <strong style="color: #000; font-family: Arial, Helvetica, sans-serif; font-size: 12px;">
                    Su sesión en el IDIGER - Registro Unico de Desartres a finalizado, espere un momento...
                </strong>
                <br />
                <br />
                <input name="aceptar" style="border: #CCC solid 1px; "  onClick="javascript: window.close();" type="button" class="text_file" value="    Cerrar    "/>
            </center>
        </div>
    </form>
</body>

<script language="javascript">
    setTimeout("descargar()", 1000);
	
    function descargar () {
        window.close();
    }
</script>
<!--%}%-->