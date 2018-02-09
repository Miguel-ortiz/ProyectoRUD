/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : UsoViviendaVO
 * Fecha de Creación : 8/02/2018, 10:26:41 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class UsoViviendaVO {

    private String usvi_id;
    private String tuvi_id;
    private String usvi_registradopor;
    private String usvi_descripcion;
    private Timestamp usvi_fechacambio;

    public String getUsvi_id() {
        return usvi_id;
    }

    public void setUsvi_id(String usvi_id) {
        this.usvi_id = usvi_id;
    }

    public String getTuvi_id() {
        return tuvi_id;
    }

    public void setTuvi_id(String tuvi_id) {
        this.tuvi_id = tuvi_id;
    }

    public String getUsvi_registradopor() {
        return usvi_registradopor;
    }

    public void setUsvi_registradopor(String usvi_registradopor) {
        this.usvi_registradopor = usvi_registradopor;
    }

    public String getUsvi_descripcion() {
        return usvi_descripcion;
    }

    public void setUsvi_descripcion(String usvi_descripcion) {
        this.usvi_descripcion = usvi_descripcion;
    }

    public Timestamp getUsvi_fechacambio() {
        return usvi_fechacambio;
    }

    public void setUsvi_fechacambio(Timestamp usvi_fechacambio) {
        this.usvi_fechacambio = usvi_fechacambio;
    }
    
    
    
}
