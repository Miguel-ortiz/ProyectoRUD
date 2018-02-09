/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoBienVO 
 * Fecha de Creación : 8/02/2018, 10:09:58 AM 
 * Author :Ingeniero Miguel O. Ortiz 
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization isundefined on line 15, column 31 in Templates/Classes/Class.java. 
 * Funcion del Archivo :
 */
public class TipoBienVO {

    private String tpbi_id;
    private String tpbi_estado;
    private Timestamp tpbi_fechacambio;
    private String tpbi_registradopor;
    private String tpbi_descripcion;

    public String getTpbi_id() {
        return tpbi_id;
    }

    public void setTpbi_id(String tpbi_id) {
        this.tpbi_id = tpbi_id;
    }

    public String getTpbi_estado() {
        return tpbi_estado;
    }

    public void setTpbi_estado(String tpbi_estado) {
        this.tpbi_estado = tpbi_estado;
    }

    public Timestamp getTpbi_fechacambio() {
        return tpbi_fechacambio;
    }

    public void setTpbi_fechacambio(Timestamp tpbi_fechacambio) {
        this.tpbi_fechacambio = tpbi_fechacambio;
    }

    public String getTpbi_registradopor() {
        return tpbi_registradopor;
    }

    public void setTpbi_registradopor(String tpbi_registradopor) {
        this.tpbi_registradopor = tpbi_registradopor;
    }

    public String getTpbi_descripcion() {
        return tpbi_descripcion;
    }

    public void setTpbi_descripcion(String tpbi_descripcion) {
        this.tpbi_descripcion = tpbi_descripcion;
    }

    
}
