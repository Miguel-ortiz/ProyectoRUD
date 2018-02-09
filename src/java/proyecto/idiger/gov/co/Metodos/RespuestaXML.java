/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.Metodos;

import proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO;

/**
 * Documento : RespuestaXML
 * Fecha de Creación : 31/01/2018, 10:51:11 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class RespuestaXML {

    public StringBuffer GenerarXML(ObjetoRespuestaVO ObjetoRespuestaVO) {
        StringBuffer xml = new StringBuffer();
        xml.append("<?xml version='1.0' encoding='UTF-8' ?>");
        xml.append("<proceso>");
        xml.append("<ejecucion>");
        xml.append("    <respuesta>");
        xml.append(ObjetoRespuestaVO.getRespuesta());
        xml.append("    </respuesta>");
        if (ObjetoRespuestaVO.getXml() != null) {
            xml.append(ObjetoRespuestaVO.getXml());
        }
        xml.append("<errores>");
        xml.append("<![CDATA[");
        if (ObjetoRespuestaVO.getErrores() != null && ObjetoRespuestaVO.getErrores().size() > 0) {
            for (int a = 0; a < ObjetoRespuestaVO.getErrores().size(); a++) {
                xml.append(ObjetoRespuestaVO.getErrores().get(a) + "<br/>");
            }
        } else {
            xml.append("");
        }
        //xml.append(ObjetoRespuestaVO.getErrores());
        xml.append("]]>");
        xml.append("</errores>");

        xml.append("<codigo>");
        if (ObjetoRespuestaVO.getHtml() != null) {
            xml.append("<![CDATA[");
            xml.append(ObjetoRespuestaVO.getHtml());
            xml.append("]]>");
        }
        xml.append("</codigo>");
        xml.append("</ejecucion>");
        xml.append("</proceso>");
        System.out.println(xml.toString());
        return xml;
    }

    public String ImprimirErrores(ObjetoRespuestaVO ObjetoRespuestaVO, String modo) {
        if (modo.compareTo("ERRORES") == 0) {
            StringBuffer errores = new StringBuffer();
            if (ObjetoRespuestaVO.getErrores() != null && ObjetoRespuestaVO.getErrores().size() > 0) {
                errores.append("<div class=\"clear\" style=\"width: 100%;\">");
                for (int a = 0; a < ObjetoRespuestaVO.getErrores().size(); a++) {
                    errores.append(ObjetoRespuestaVO.getErrores().get(a) + "<br/>");
                }
                errores.append("</div>");
            } else {
                errores.append("");
            }
            return errores.toString();
        } else {
            return "";
        }
    }
}