/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : AplicacionVO
 * Fecha de Creación : 8/02/2018, 01:57:52 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class AplicacionVO {

    private String apli_id;
    private String apli_registrdopor;
    private Timestamp apli_fechacambio;
    private String apli_descripcion;

    public String getApli_id() {
        return apli_id;
    }

    public void setApli_id(String apli_id) {
        this.apli_id = apli_id;
    }

    public String getApli_registrdopor() {
        return apli_registrdopor;
    }

    public void setApli_registrdopor(String apli_registrdopor) {
        this.apli_registrdopor = apli_registrdopor;
    }

    public Timestamp getApli_fechacambio() {
        return apli_fechacambio;
    }

    public void setApli_fechacambio(Timestamp apli_fechacambio) {
        this.apli_fechacambio = apli_fechacambio;
    }

    public String getApli_descripcion() {
        return apli_descripcion;
    }

    public void setApli_descripcion(String apli_descripcion) {
        this.apli_descripcion = apli_descripcion;
    }
    
    
}
