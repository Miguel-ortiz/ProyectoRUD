/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : ActaEvacuacionVO
 * Fecha de Creación : 8/02/2018, 02:17:36 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class ActaEvacuacionVO {

    private String acev_id;
    private String acev_fechacambio;
    private String acev_radicado;
    private String acev_observaciones;
    private Timestamp acev_fecha;
    private String acev_registradopor;
    private String rpaf_id;
    private String acev_radicadoalcaldia;
    private String evte_id;
    private String acev_obserevte;

    public String getAcev_id() {
        return acev_id;
    }

    public void setAcev_id(String acev_id) {
        this.acev_id = acev_id;
    }

    public String getAcev_fechacambio() {
        return acev_fechacambio;
    }

    public void setAcev_fechacambio(String acev_fechacambio) {
        this.acev_fechacambio = acev_fechacambio;
    }

    public String getAcev_radicado() {
        return acev_radicado;
    }

    public void setAcev_radicado(String acev_radicado) {
        this.acev_radicado = acev_radicado;
    }

    public String getAcev_observaciones() {
        return acev_observaciones;
    }

    public void setAcev_observaciones(String acev_observaciones) {
        this.acev_observaciones = acev_observaciones;
    }

    public Timestamp getAcev_fecha() {
        return acev_fecha;
    }

    public void setAcev_fecha(Timestamp acev_fecha) {
        this.acev_fecha = acev_fecha;
    }

    public String getAcev_registradopor() {
        return acev_registradopor;
    }

    public void setAcev_registradopor(String acev_registradopor) {
        this.acev_registradopor = acev_registradopor;
    }

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }

    public String getAcev_radicadoalcaldia() {
        return acev_radicadoalcaldia;
    }

    public void setAcev_radicadoalcaldia(String acev_radicadoalcaldia) {
        this.acev_radicadoalcaldia = acev_radicadoalcaldia;
    }

    public String getEvte_id() {
        return evte_id;
    }

    public void setEvte_id(String evte_id) {
        this.evte_id = evte_id;
    }

    public String getAcev_obserevte() {
        return acev_obserevte;
    }

    public void setAcev_obserevte(String acev_obserevte) {
        this.acev_obserevte = acev_obserevte;
    }
    
    
}
