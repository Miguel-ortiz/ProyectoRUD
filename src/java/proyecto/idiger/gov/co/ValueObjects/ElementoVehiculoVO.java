/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : ElementoVehiculoVO
 * Fecha de Creación : 8/02/2018, 02:12:02 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class ElementoVehiculoVO {

    private String elve_id;
    private String elve_registradopor;
    private String elve_estado;
    private String elve_descripcion;
    private Timestamp elve_fechacambio;

    public String getElve_id() {
        return elve_id;
    }

    public void setElve_id(String elve_id) {
        this.elve_id = elve_id;
    }

    public String getElve_registradopor() {
        return elve_registradopor;
    }

    public void setElve_registradopor(String elve_registradopor) {
        this.elve_registradopor = elve_registradopor;
    }

    public String getElve_estado() {
        return elve_estado;
    }

    public void setElve_estado(String elve_estado) {
        this.elve_estado = elve_estado;
    }

    public String getElve_descripcion() {
        return elve_descripcion;
    }

    public void setElve_descripcion(String elve_descripcion) {
        this.elve_descripcion = elve_descripcion;
    }

    public Timestamp getElve_fechacambio() {
        return elve_fechacambio;
    }

    public void setElve_fechacambio(Timestamp elve_fechacambio) {
        this.elve_fechacambio = elve_fechacambio;
    }
    
    
    
}
