//
//CONTROLADOR JAVASCRIPT DE APLICACIONES PROPIAS
//

var maximo = 10;
var tabs;
var validator;
var nitems = 0;
var ndocumentos = 0;

$(document).ready(function () {
    validadorFormDialog();
    validadorBusqueda();
    //validador();
    fechas();
});

$(document).ajaxStart(function () {
    var modal = parent.document.getElementById('ModalLoader');
    if (modal === null) {
        modal = document.getElementById('ModalLoader');
    }
    modal.style.display = "block";
});

$(document).ajaxStop(function () {
    var modal = parent.document.getElementById('ModalLoader');
    if (modal === null) {
        modal = document.getElementById('ModalLoader');
    }

    modal.style.display = "none";

});

function _isNumeric(valor) {
    var _is = false;
    try {
        eval(valor);
        _is = true;
    } catch (ex) {
        _is = false;
    }
    return _is;
}

function addPanel(titulo, url) {
    var tab = $('#tt').tabs('exists', titulo);
    if (tab) {
        $('#tt').tabs('select', titulo);
    } else {
        $('#tt').tabs('add', {
            title: titulo,
            content: '' +
                    '<iframe src="' + url + '" id="' + titulo + '" ></iframe>',
            closable: true
        });
    }
}

function Cerrar() {
    $("#FormDialog").dialog("close");
    $("#FormDialog").dialog("destroy");
    $("#FormDialog").remove();
    $("#mensaje").dialog("close");
    $("#mensaje").dialog("destroy");
    $("#mensaje").remove();
}

function CerrarFormDialog(idDialog) {

    if (idDialog === undefined) {
        idDialog = "FormDialog";
    }

    $("#" + idDialog).dialog("close");
    $("#" + idDialog).remove();
}

function direccionarlink(url) {
    if (url != "") {
        location.href = url;
    }
}

function enviarCTR(id, url) {
    if (url != "") {
        $.ajax({
            url: url,
            type: "POST",
            data: "",
            success: function (datos) {
                $("#" + id).html("");
                $("#" + id).append(datos);
                $("#mensaje").dialog("destroy");
                $("#mensaje").remove();
            },
            error: function () {
                alert("Error en el procesamiento");
            }
        });
    }
}

function enviarCTRLoad(id, url) {

    //alerta("Mensaje del Sistema", "espera", "dialog");
    if (url != "") {
        $("#" + id).load(url, function (response, status, xhr) {
            if (status == "success") {
               // $("#mensaje").dialog("destroy");
              //  $("#mensaje").remove();
           //   alert("cargo");
       }

            if (status == "error")
                alert("Error en el procesamiento: " + xhr.status + ": " + xhr.statusText);
        });
    }

}

function LoadSuper(id, url) {

    //alerta("Mensaje del Sistema", "espera", "dialog");
    if (url != "") {
        $("#" + id).load(url, function (response, status, xhr) {
            if (status == "success") {
               // $("#mensaje").dialog("destroy");
              //  $("#mensaje").remove();
           //   alert("cargo");
       }

            if (status == "error")
                alert("Error en el procesamiento: " + xhr.status + ": " + xhr.statusText);
        });
    }

}
function fechas() {
    $(".fecha").datepicker({
        buttonImage: false,
        dateFormat: "dd-mm-yy",
        changeYear: true,
        numberOfMonths: 1
    });
    $(".fechahoy").datepicker({
        buttonImage: false,
        dateFormat: "dd-mm-yy",
        minDate: 0,
        changeYear: true,
        numberOfMonths: 1
    });
    $(".fechaanteriorhoy").datepicker({
        buttonImage: false,
        dateFormat: "dd-mm-yy",
        maxDate: '0',
        changeYear: true,
        numberOfMonths: 1
    });
    $(".fechamax18a").datepicker({
        buttonImage: false,
        dateFormat: "dd-mm-yy",
        maxDate: '-6575',
        changeYear: true,
        numberOfMonths: 1
    });
    $(".fechajanium").datepicker({
        buttonImage: false,
        dateFormat: "yymmdd",
        changeYear: true,
        numberOfMonths: 1
    });
}

function DateTime() {
    $(".time_text").timepicki({
        show_meridian: false,
        min_hour_value: 0,
        max_hour_value: 23,
        /*step_size_minutes: 15,*/
        overflow_minutes: true,
        increase_direction: 'up',
        disable_keyboard_mobile: true});
}

function FormDialog(url, widht, height, titulo) {
    $("body").append('<div id="FormDialog"></div>');
    $('#FormDialog').dialog({
        modal: true,
        open: function ()
        {
            $(this).load(url);
        },
        close: function (event, ui) {
            $('#FormDialog').remove();
        },
        height: height,
        width: widht,
        title: titulo,
        position: 'center top',
        bgiframe: true,
        hide: "scale",
        show: "scale"
    });
}

function peticionAjax(ctr, datos) {
    $.ajax({
        url: ctr,
        type: "POST",
        data: datos,
        dataType: "xml",
        success: function (r) {
            procesarRequestAlertify(r);
        },
        error: function () {
            alert("Error en el procesamiento");
        }
    });
}

function peticionAjaxConfirmacion(ctr, datos, mensaje) {
    parent.alertify.confirm(mensaje, function (e) {
        alert("Error en el procesamiento");
        if (e) {
            $.ajax({
                url: ctr,
                type: "POST",
                data: datos,
                dataType: "xml",
                success: function (r) {
                    procesarRequestAlertify(r);
                },
                error: function () {
                    alert("Error en el procesamiento");
                }
            });
        }
    });

}

function procesar(accion, datos) {
    accion = accion.toString();
    var validarsession = new String(datos);
    try {
        var n = validarsession.match(/exit/gi);
        if (n.length > 0) {
            $("#mensaje").dialog("destroy");
            $("#mensaje").remove();
            alerta("SU SESION A TERMINADO", "LO SENTIMOS SU SESION NO HA PODIDO VERIFICARSE <br/> <br/> <center><input type='button' value = 'Cerrar' onclick='location.href=\"fuera.jsp\"' class='ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all'></center>", "dialog");
            return false;
        }
    } catch (ex) {
    }
    return false;
}

function procesarRequest(response) {
    var respuesta = "";
    var errores = "";
    var html = "";
    var noprocesado = "";
    var mensaje = "";
    var operacion = "";
    $(response).find("ejecucion").each(function () {
        respuesta += $(this).find("respuesta").text();
        //alert(respuesta);
        errores += $(this).find("errores").text();
        //alert(errores);
        mensaje += $(this).find("mensaje").text();
        //alert(mensaje);
        operacion += $(this).find("operacion").text();
        //alert(operacion);
        html += $(this).find("codigo").text();
    });
    /*alert("respuesta : " + respuesta);
     alert("errores : " + errores);
     alert("mensaje : " + mensaje);
     alert("operacion : " + operacion);*/
    // alert("html : " + html);
    $("#mensaje").dialog("destroy");
    $("#mensaje").remove();
    if (_isNumeric(respuesta)) {
        if (respuesta == 1) {
            var pagina = $('#pagina_ocu').val();        ///crear en el formualrio campo oculto con el valor de la pagina a direccionar
            location.href = pagina;
        }
        if (respuesta == 0) {
            if (errores != "") {
                noprocesado += html;
                noprocesado += "El proceso no se ha ejecutado <br/>";
                noprocesado += "<a href='javascript:void(null)' onclick='$(\"#errores\").show();'> Mostrar Errores </a><div id='errores' style='display:none;'>" + errores + "</div>";
                ModalRequest("Mensaje del Sistema", noprocesado, "dialog");
            }
        }

    } else {
        if (errores != "") {
            noprocesado += html;
            noprocesado += "El proceso no se ha ejecutado <br/>";
            noprocesado += "<a href='javascript:void(null)' onclick='$(\"#errores\").show();'> Mostrar Errores </a><div id='errores' style='display:none;'>" + errores + "</div>";
            ModalRequest("Mensaje del Sistema", noprocesado, "dialog");
        }
    }
}

function procesarRequestAlertify(response) {
    var respuesta = "";
    var errores = "";
    var html = "";
    var noprocesado = "";
    var mensaje = "";
    var operacion = "";
    $(response).find("ejecucion").each(function () {
        respuesta += $(this).find("respuesta").text();
        errores += $(this).find("errores").text();
        mensaje += $(this).find("mensaje").text();
        operacion += $(this).find("operacion").text();
        html += $(this).find("codigo").text();
    });
    if (_isNumeric(respuesta)) {
        if (respuesta.trim() === '0') {
            if ($.trim(html) != "" || $.trim(errores) != "") {
                alertify.error(html, 9000);
            }
        }
        if (respuesta.trim() === '1') {
            $('#' + ndocumentos).html('');
            $('#' + ndocumentos).append(html);
            eval(alertify.success('Operaci&oacute;n Exitosa...'));
        }
        if (respuesta.trim() === '2') {
            eval(html);
        }
    } else {
        if (errores != "") {
            noprocesado += "El proceso no se ha ejecutado <br/>";
            noprocesado += "<a href='javascript:void(null)' onclick='$(\"#errores\").show();'> Mostrar Errores </a><div id='errores' style='display:none;'>" + errores + "</div>";
            alertify.error(noprocesado);
        }
    }
}

function redireccionar(url, s, msj, tipo) {
    if (tipo === '1') {
        alertify.success(msj);
    } else if (tipo === '0') {
        alertify.error(msj);
    }
    setTimeout(function () {
        document.location.href = url;
    }
    , s * 1000);
}

function RegargarTag(id, url, tipo) {
    if (url != "") {
        $.ajax({
            url: url,
            type: "POST",
            data: "",
            success: function (datos) {
                //alert(url);
                if (tipo == 'select') {
                    $("#" + id).html("");
                    $("#" + id).append(datos);
                }
                if (tipo == 'table') {
                    $("#" + id).html("");
                    $("#" + id).append(datos);
                }
                if (tipo == 'div') {
                    $("#" + id).html(datos);
                }
            },
            error: function () {
                alert("Error en el procesamiento");
            }
        });
    }
}

function removePanel() {
    var tab = $('#tt').tabs('getSelected');
    if (tab) {
        var index = $('#tt').tabs('getTabIndex', tab);
        $('#tt').tabs('close', index);
    }
}

function setTextareaHeight(textareas) {
    textareas.each(function () {
        var textarea = $(this);
        if (!textarea.hasClass('autoHeightDone')) {
            textarea.addClass('autoHeightDone');

            var extraHeight = parseInt(textarea.css('padding-top')) + parseInt(textarea.css('padding-bottom')), // to set total height - padding size
                    h = textarea[0].scrollHeight - extraHeight;
            textarea.height('auto').height(h);
            textarea.bind('keyup', function () {
                textarea.removeAttr('style'); // no funciona el height auto

                h = textarea.get(0).scrollHeight - extraHeight;

                textarea.height(h + 'px'); // set new height
            });
        }
    });
}

function strTrim(x) {
    return x.replace(/^\s+|\s+$/gm, '');
}

function validador() {
    //alert("validador");   
    validator = $("#FormAplication").validate({
        rules: {
        },
        messages: {
        },
        submitHandler: function () {

            var cadenaFormulario = $('#FormAplication').serialize();
            var request = $('#FormAplication #request').val();
            var funcion = $('#FormAplication #accion').val();
            var texto = "";
//            alert(request);
//            alert(cadenaFormulario);
//            alerta("Mensaje del Sistema", "espera", "dialog");
            $.ajax({
                url: request,
                type: "POST",
                data: cadenaFormulario,
                contentType: "application/x-www-form-urlencoded;charset=ISO-8859-15",
                dataType: ($.browser.msie) ? "text" : "xml",
                success: function (datos) {

                    var xml;
                    if (typeof datos == 'string') {
                        xml = new ActiveXObject('Microsoft.XMLDOM');
                        xml.async = false;
                        xml.loadXML(datos);
                    } else {
                        xml = datos;
                    }
//                    alert(datos);
                    procesarRequestAlertify(xml);
                },
                error: function () {
                    alert("Error en el procesamiento formaplicacion");
                }
            });
        },
        success: function (label) {

        }
    });
}

function validadorBusqueda() {
    validator = $("#Form-Buscar").validate({
        rules: {
        },
        messages: {
        },
        submitHandler: function () {
            var cadenaFormulario = $('#Form-Buscar').serialize();
            var request = $('#Form-Buscar #request').val();
            var funcion = $('#Form-Buscar #accion').val();
            var texto = "";
            if ($('#validar').val() != '') {
                var campos = document.getElementById("validar").value;
                if (campos != "") {
                    var vector = campos.split(",");
                    var lleno = 0;
                    for (a = 0; a < vector.length; a++) {
                        if (document.getElementById(vector[a]).value != "")
                            lleno++;
                    }
                } else
                    lleno = 1;
                if (lleno == 0) {
                    alert("Digite algun parametro de busqueda");
                    return 0;
                }
            }
            alerta("Mensaje del Sistema", "espera", "dialog");
            $.ajax({
                url: request,
                type: "POST",
                data: cadenaFormulario,
                contentType: "application/x-www-form-urlencoded;charset=ISO-8859-15",
                success: function (datos) {
                    procesar(funcion, datos);
                },
                error: function () {
                    alert("Error en el procesamiento");
                }
            });
        },
        success: function (label) {

        }
    });
}

function validadorFormDialog() {
    validator = $("#DialogAplication").validate({
        rules: {
        },
        messages: {
        },
        submitHandler: function () {
            var cadenaFormulario = $('#DialogAplication').serialize();
            var request = $('#DialogAplication #request').val();
            var funcion = $('#DialogAplication #accion').val();
            var texto = "";
            Cerrar();
            $.ajax({
                url: request,
                type: "POST",
                data: cadenaFormulario,
                dataType: "xml",
                success: function (datos) {
                    var xml;
                    xml = datos;
//                    alert(xml);
                    procesarRequestAlertify(xml);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("error" + textStatus + "    " + errorThrown + "  " + jqXHR);
                }
            });
        },
        success: function (label) {

        }
    });
    validator = $("#Form-Dialog").validate({
        rules: {
        },
        messages: {
        },
        submitHandler: function () {
            try {
                if (ValidarCKEditor()) {
                    return false;
                }
            } catch (ex) {
                alert(ex);
            }
            var cadenaFormulario = $('#Form-Dialog').serialize();
            var request = $('#Form-Dialog').attr("action");
            var funcion = $('#Form-Dialog #accion').val();
//            alert(cadenaFormulario);
//            alert(request);
//            alerta("Mensaje del Sistema", "espera", "dialog");
            $.ajax({
                url: request,
                type: "POST",
                data: cadenaFormulario,
                dataType: "xml",
                success: function (datos) {
//                    alert(datos);
                    var xml;
                    xml = datos;
                    procesarRequestAlertify(xml);


                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("error" + textStatus + "    " + errorThrown + "  " + jqXHR);
                }
            });

        },
        success: function (label) {

        }
    });
}

function validadorIndividual(formId) {
    validator = $(formId).validate({
        rules: {
        },
        messages: {
        },
        submitHandler: function () {
            var cadenaFormulario = $(formId).serialize();
            var request = $(formId).attr("action");

            $.ajax({
                url: request,
                type: "POST",
                data: cadenaFormulario,
                dataType: "xml",
                success: function (datos) {
                    procesarRequestAlertify(datos);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("error" + textStatus + "    " + errorThrown + "  " + jqXHR);
                }
            });
        }
    });
}

function ValidarCKEditor(FormId) {
    var respuesta = false;
    try {
        for (var i in CKEDITOR.instances) {
            CKEDITOR.instances[i].updateElement();
            if (CKEDITOR.instances[i].getData() == "") {
                var requerido = 0;
                try {
                    if (FormId != '' && FormId != undefined) {
                        var clases = $('#' + FormId + ' #' + CKEDITOR.instances[i].name).attr('class').split(/\s+/);
                    } else {
                        var clases = $('#' + CKEDITOR.instances[i].name).attr('class').split(/\s+/);
                    }
                    for (a = 0; a < clases.length; a++) {
                        if (clases[a] == 'required') {
                            requerido = 1;
                            break;
                        }
                    }
                } catch (ex) {
                    console.log("No soportado CKEDITOR ERROR  : " + ex);
                }
                if (requerido != 0) {
                    alert('No se ha generado Contenido para el campo de texto.')
                    CKEDITOR.instances[i].focus();
                    respuesta = true;
                    break;
                }
            }
        }
    } catch (ex) {
    }
    return respuesta;
}

function ventanaCerrar() {
    if (confirm("Esta seguro de salir de la Aplicacion")) {
        var opciones = "width=260, height=105, screenX=0, screenY=0, top=0, left=0, scrollbars=no, status=no, resizable=no";
        mi_close = window.open("fueraX.jsp", "FUERA", opciones);
        parent.window.close();
    }
}

function ventanaNueva(url) {
    var aw = screen.availWidth;
    var ah = screen.availHeight;
    var opciones = "width=" + aw + ", height=" + ah + ", screenX=0, screenY=0, top=0, left=0, scrollbars=no, status=no, resizable=no";
    mi_ventana = window.open(url, "", opciones);
}


/*************************************************************/
/****************  IDIOMA CALENDARIO *************************/
/*************************************************************/
jQuery(function ($) {
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '&#x3c;Ant',
        nextText: 'Sig&#x3e;',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
            'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
            'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Juv', 'Vie', 'S&aacute;b'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'S&aacute;'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
    };
    $.datepicker.setDefaults($.datepicker.regional['es']);
});
/*************************************************************/
/****************  IDIOMA CALENDARIO *************************/
/*************************************************************/