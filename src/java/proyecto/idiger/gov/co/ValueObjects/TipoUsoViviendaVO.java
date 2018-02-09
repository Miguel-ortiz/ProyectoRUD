/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoUsoViviendaVO
 * Fecha de Creación : 8/02/2018, 10:25:54 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoUsoViviendaVO {

    private String tuvi_id;
    private String tuvi_registradopor;
    private String tuvi_descripcion;
    private Timestamp tuvi_fechacambio;
    private String tuvi_estado; 

    public String getTuvi_id() {
        return tuvi_id;
    }

    public void setTuvi_id(String tuvi_id) {
        this.tuvi_id = tuvi_id;
    }

    public String getTuvi_registradopor() {
        return tuvi_registradopor;
    }

    public void setTuvi_registradopor(String tuvi_registradopor) {
        this.tuvi_registradopor = tuvi_registradopor;
    }

    public String getTuvi_descripcion() {
        return tuvi_descripcion;
    }

    public void setTuvi_descripcion(String tuvi_descripcion) {
        this.tuvi_descripcion = tuvi_descripcion;
    }

    public Timestamp getTuvi_fechacambio() {
        return tuvi_fechacambio;
    }

    public void setTuvi_fechacambio(Timestamp tuvi_fechacambio) {
        this.tuvi_fechacambio = tuvi_fechacambio;
    }

    public String getTuvi_estado() {
        return tuvi_estado;
    }

    public void setTuvi_estado(String tuvi_estado) {
        this.tuvi_estado = tuvi_estado;
    }
    
    
}
