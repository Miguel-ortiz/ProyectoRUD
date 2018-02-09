/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoDocumentoIdentidadVO
 Fecha de Creación : 8/02/2018, 01:54:57 PM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoDocumentoIdentidadVO {

    private String tpdo_id;
    private Timestamp tpdo_fechacambio;
    private String tpdo_descripcion;
    private String tpdo_registrodopor;
    private String tpdo_abreviacion;
    private String tpdo_estado;    

    public String getTpdo_id() {
        return tpdo_id;
    }

    public void setTpdo_id(String tpdo_id) {
        this.tpdo_id = tpdo_id;
    }

    public Timestamp getTpdo_fechacambio() {
        return tpdo_fechacambio;
    }

    public void setTpdo_fechacambio(Timestamp tpdo_fechacambio) {
        this.tpdo_fechacambio = tpdo_fechacambio;
    }

    public String getTpdo_descripcion() {
        return tpdo_descripcion;
    }

    public void setTpdo_descripcion(String tpdo_descripcion) {
        this.tpdo_descripcion = tpdo_descripcion;
    }

    public String getTpdo_registrodopor() {
        return tpdo_registrodopor;
    }

    public void setTpdo_registrodopor(String tpdo_registrodopor) {
        this.tpdo_registrodopor = tpdo_registrodopor;
    }

    public String getTpdo_abreviacion() {
        return tpdo_abreviacion;
    }

    public void setTpdo_abreviacion(String tpdo_abreviacion) {
        this.tpdo_abreviacion = tpdo_abreviacion;
    }

    public String getTpdo_estado() {
        return tpdo_estado;
    }

    public void setTpdo_estado(String tpdo_estado) {
        this.tpdo_estado = tpdo_estado;
    }
    
    
}

