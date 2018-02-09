/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoTenenciaViviendaVO
 * Fecha de Creación : 8/02/2018, 10:24:50 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoTenenciaViviendaVO {

    private String ttvi_id;
    private Timestamp ttvi_fechacambio;
    private String ttvi_estado;
    private String ttvi_registradopor;
    private String ttvi_descripcion;

    public String getTtvi_id() {
        return ttvi_id;
    }

    public void setTtvi_id(String ttvi_id) {
        this.ttvi_id = ttvi_id;
    }

    public Timestamp getTtvi_fechacambio() {
        return ttvi_fechacambio;
    }

    public void setTtvi_fechacambio(Timestamp ttvi_fechacambio) {
        this.ttvi_fechacambio = ttvi_fechacambio;
    }

    public String getTtvi_estado() {
        return ttvi_estado;
    }

    public void setTtvi_estado(String ttvi_estado) {
        this.ttvi_estado = ttvi_estado;
    }

    public String getTtvi_registradopor() {
        return ttvi_registradopor;
    }

    public void setTtvi_registradopor(String ttvi_registradopor) {
        this.ttvi_registradopor = ttvi_registradopor;
    }

    public String getTtvi_descripcion() {
        return ttvi_descripcion;
    }

    public void setTtvi_descripcion(String ttvi_descripcion) {
        this.ttvi_descripcion = ttvi_descripcion;
    }
    
    

}
