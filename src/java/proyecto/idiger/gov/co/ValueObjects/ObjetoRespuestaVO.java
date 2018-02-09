/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.util.ArrayList;

/**
 * Documento : ObjetoRespuestaVO
 * Fecha de Creación : 22/01/2018, 12:07:38 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : moortiz
 * Funcion del Archivo :
 */
public class ObjetoRespuestaVO {

    private ArrayList errores;
    private String respuesta;
    private String html;
    private StringBuffer xml;
    private String rutaLogs;

    public StringBuffer getXml() {
        return xml;
    }

    public void setXml(StringBuffer xml) {
        this.xml = xml;
    }

    public String getRutaLogs() {
        return rutaLogs;
    }

    public void setRutaLogs(String rutaLogs) {
        this.rutaLogs = rutaLogs;
    }

    public ArrayList getErrores() {
        return errores;
    }

    public void setErrores(ArrayList errores) {
        this.errores = errores;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
