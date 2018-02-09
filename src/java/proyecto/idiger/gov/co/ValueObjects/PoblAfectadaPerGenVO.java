/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : PoblAfectadaPerGenVO
 * Fecha de Creación : 8/02/2018, 10:32:40 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PoblAfectadaPerGenVO {

    private String pege_id;
    private String rpaf_id;
    private Timestamp papg_fechacambio;
    private String papg_registradopor;
    private String epev_id;
    private String tpfa_id;
    private String coat_id; 

    public String getPege_id() {
        return pege_id;
    }

    public void setPege_id(String pege_id) {
        this.pege_id = pege_id;
    }

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }

    public Timestamp getPapg_fechacambio() {
        return papg_fechacambio;
    }

    public void setPapg_fechacambio(Timestamp papg_fechacambio) {
        this.papg_fechacambio = papg_fechacambio;
    }

    public String getPapg_registradopor() {
        return papg_registradopor;
    }

    public void setPapg_registradopor(String papg_registradopor) {
        this.papg_registradopor = papg_registradopor;
    }

    public String getEpev_id() {
        return epev_id;
    }

    public void setEpev_id(String epev_id) {
        this.epev_id = epev_id;
    }

    public String getTpfa_id() {
        return tpfa_id;
    }

    public void setTpfa_id(String tpfa_id) {
        this.tpfa_id = tpfa_id;
    }

    public String getCoat_id() {
        return coat_id;
    }

    public void setCoat_id(String coat_id) {
        this.coat_id = coat_id;
    }
    
    
}
