/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : RegistroPoblacionAfectadaVO
 * Fecha de Creación : 8/02/2018, 10:33:54 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class RegistroPoblacionAfectadaVO {

    private String rpaf_id;
    private String rpaf_observaciones;
    private Timestamp rpaf_fechacambio;
    private String pege_usuario;
    private String tevi_id;
    private String sire_id;
    private String tpev_id;
    private Timestamp rpaf_fecha;
    private String nuse_id;
    private String usvi_id;
    private String rpaf_registradopor;
    private String pege_surevisor;

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }

    public String getRpaf_observaciones() {
        return rpaf_observaciones;
    }

    public void setRpaf_observaciones(String rpaf_observaciones) {
        this.rpaf_observaciones = rpaf_observaciones;
    }

    public Timestamp getRpaf_fechacambio() {
        return rpaf_fechacambio;
    }

    public void setRpaf_fechacambio(Timestamp rpaf_fechacambio) {
        this.rpaf_fechacambio = rpaf_fechacambio;
    }

    public String getPege_usuario() {
        return pege_usuario;
    }

    public void setPege_usuario(String pege_usuario) {
        this.pege_usuario = pege_usuario;
    }

    public String getTevi_id() {
        return tevi_id;
    }

    public void setTevi_id(String tevi_id) {
        this.tevi_id = tevi_id;
    }

    public String getSire_id() {
        return sire_id;
    }

    public void setSire_id(String sire_id) {
        this.sire_id = sire_id;
    }

    public String getTpev_id() {
        return tpev_id;
    }

    public void setTpev_id(String tpev_id) {
        this.tpev_id = tpev_id;
    }

    public Timestamp getRpaf_fecha() {
        return rpaf_fecha;
    }

    public void setRpaf_fecha(Timestamp rpaf_fecha) {
        this.rpaf_fecha = rpaf_fecha;
    }

    public String getNuse_id() {
        return nuse_id;
    }

    public void setNuse_id(String nuse_id) {
        this.nuse_id = nuse_id;
    }

    public String getUsvi_id() {
        return usvi_id;
    }

    public void setUsvi_id(String usvi_id) {
        this.usvi_id = usvi_id;
    }

    public String getRpaf_registradopor() {
        return rpaf_registradopor;
    }

    public void setRpaf_registradopor(String rpaf_registradopor) {
        this.rpaf_registradopor = rpaf_registradopor;
    }

    public String getPege_surevisor() {
        return pege_surevisor;
    }

    public void setPege_surevisor(String pege_surevisor) {
        this.pege_surevisor = pege_surevisor;
    }
    
    
}
