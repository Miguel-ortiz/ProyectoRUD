/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : AfectadosAyuMasivaVO
 Fecha de Creación : 8/02/2018, 10:08:50 AM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class AfectadosAyuMasivaVO {

    private String afam_id;
    private String afam_estado;
    private Timestamp afam_descripcion;
    private String afam_fechacambio;
    private String afam_registradopor;

    public String getAfam_id() {
        return afam_id;
    }

    public void setAfam_id(String afam_id) {
        this.afam_id = afam_id;
    }

    public String getAfam_estado() {
        return afam_estado;
    }

    public void setAfam_estado(String afam_estado) {
        this.afam_estado = afam_estado;
    }

    public Timestamp getAfam_descripcion() {
        return afam_descripcion;
    }

    public void setAfam_descripcion(Timestamp afam_descripcion) {
        this.afam_descripcion = afam_descripcion;
    }

    public String getAfam_fechacambio() {
        return afam_fechacambio;
    }

    public void setAfam_fechacambio(String afam_fechacambio) {
        this.afam_fechacambio = afam_fechacambio;
    }

    public String getAfam_registradopor() {
        return afam_registradopor;
    }

    public void setAfam_registradopor(String afam_registradopor) {
        this.afam_registradopor = afam_registradopor;
    }
    
    
}
