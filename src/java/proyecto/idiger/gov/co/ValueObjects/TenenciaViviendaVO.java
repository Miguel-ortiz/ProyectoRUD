/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TenenciaViviendaVO
 * Fecha de Creación : 8/02/2018, 01:53:55 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TenenciaViviendaVO {

    private String tevi_id;
    private String tevi_registradopor;
    private String pege_propietario;
    private String ttvi_id;
    private Timestamp tevi_rechacambio;

    public String getTevi_id() {
        return tevi_id;
    }

    public void setTevi_id(String tevi_id) {
        this.tevi_id = tevi_id;
    }

    public String getTevi_registradopor() {
        return tevi_registradopor;
    }

    public void setTevi_registradopor(String tevi_registradopor) {
        this.tevi_registradopor = tevi_registradopor;
    }

    public String getPege_propietario() {
        return pege_propietario;
    }

    public void setPege_propietario(String pege_propietario) {
        this.pege_propietario = pege_propietario;
    }

    public String getTtvi_id() {
        return ttvi_id;
    }

    public void setTtvi_id(String ttvi_id) {
        this.ttvi_id = ttvi_id;
    }

    public Timestamp getTevi_rechacambio() {
        return tevi_rechacambio;
    }

    public void setTevi_rechacambio(Timestamp tevi_rechacambio) {
        this.tevi_rechacambio = tevi_rechacambio;
    }
    
    
}
