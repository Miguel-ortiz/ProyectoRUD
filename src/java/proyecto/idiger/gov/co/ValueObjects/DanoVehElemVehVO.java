/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : DanoVehElemVehVO
 * Fecha de Creación : 8/02/2018, 02:03:51 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class DanoVehElemVehVO {

    private String elve_id;
    private String davh_id;
    private Timestamp dvev_fechacamio;
    private String dvev_descripcion;
    private String dvev_registradopor;

    public String getElve_id() {
        return elve_id;
    }

    public void setElve_id(String elve_id) {
        this.elve_id = elve_id;
    }

    public String getDavh_id() {
        return davh_id;
    }

    public void setDavh_id(String davh_id) {
        this.davh_id = davh_id;
    }

    public Timestamp getDvev_fechacamio() {
        return dvev_fechacamio;
    }

    public void setDvev_fechacamio(Timestamp dvev_fechacamio) {
        this.dvev_fechacamio = dvev_fechacamio;
    }

    public String getDvev_descripcion() {
        return dvev_descripcion;
    }

    public void setDvev_descripcion(String dvev_descripcion) {
        this.dvev_descripcion = dvev_descripcion;
    }

    public String getDvev_registradopor() {
        return dvev_registradopor;
    }

    public void setDvev_registradopor(String dvev_registradopor) {
        this.dvev_registradopor = dvev_registradopor;
    }
    
    
}
