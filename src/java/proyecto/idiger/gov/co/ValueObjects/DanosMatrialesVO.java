/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : DanosMatrialesVO
 Fecha de Creación : 8/02/2018, 02:02:42 PM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class DanosMatrialesVO {

    private String dama_id;
    private String dama_descripcion;
    private Timestamp dama_registradopor;
    private String dama_fechacambio;

    public String getDama_id() {
        return dama_id;
    }

    public void setDama_id(String dama_id) {
        this.dama_id = dama_id;
    }

    public String getDama_descripcion() {
        return dama_descripcion;
    }

    public void setDama_descripcion(String dama_descripcion) {
        this.dama_descripcion = dama_descripcion;
    }

    public Timestamp getDama_registradopor() {
        return dama_registradopor;
    }

    public void setDama_registradopor(Timestamp dama_registradopor) {
        this.dama_registradopor = dama_registradopor;
    }

    public String getDama_fechacambio() {
        return dama_fechacambio;
    }

    public void setDama_fechacambio(String dama_fechacambio) {
        this.dama_fechacambio = dama_fechacambio;
    }
    
    
}
