/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : RegPoblAfectaDanoMatVO
 Fecha de Creación : 8/02/2018, 01:52:58 PM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class RegPoblAfectaDanoMatVO {
    
    private String dama_id;
    private String rpaf_id;
    private String rpdm_fechacambio;
    private Timestamp rpdm_registradopor;
    private String rpdm_detalle;

    public String getDama_id() {
        return dama_id;
    }

    public void setDama_id(String dama_id) {
        this.dama_id = dama_id;
    }

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }

    public String getRpdm_fechacambio() {
        return rpdm_fechacambio;
    }

    public void setRpdm_fechacambio(String rpdm_fechacambio) {
        this.rpdm_fechacambio = rpdm_fechacambio;
    }

    public Timestamp getRpdm_registradopor() {
        return rpdm_registradopor;
    }

    public void setRpdm_registradopor(Timestamp rpdm_registradopor) {
        this.rpdm_registradopor = rpdm_registradopor;
    }

    public String getRpdm_detalle() {
        return rpdm_detalle;
    }

    public void setRpdm_detalle(String rpdm_detalle) {
        this.rpdm_detalle = rpdm_detalle;
    }
    
    
}
