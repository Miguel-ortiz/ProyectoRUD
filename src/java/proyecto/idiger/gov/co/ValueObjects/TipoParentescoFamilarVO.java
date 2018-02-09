/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoParentescoFamilarVO
 * Fecha de Creación : 8/02/2018, 10:18:44 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoParentescoFamilarVO {

    private String tpfa_id;
    private String tpfa_registradopor;
    private Timestamp tpfa_fechacambio;
    private String tpfa_descripcion; 

    public String getTpfa_id() {
        return tpfa_id;
    }

    public void setTpfa_id(String tpfa_id) {
        this.tpfa_id = tpfa_id;
    }

    public String getTpfa_registradopor() {
        return tpfa_registradopor;
    }

    public void setTpfa_registradopor(String tpfa_registradopor) {
        this.tpfa_registradopor = tpfa_registradopor;
    }

    public Timestamp getTpfa_fechacambio() {
        return tpfa_fechacambio;
    }

    public void setTpfa_fechacambio(Timestamp tpfa_fechacambio) {
        this.tpfa_fechacambio = tpfa_fechacambio;
    }

    public String getTpfa_descripcion() {
        return tpfa_descripcion;
    }

    public void setTpfa_descripcion(String tpfa_descripcion) {
        this.tpfa_descripcion = tpfa_descripcion;
    }

    
}
