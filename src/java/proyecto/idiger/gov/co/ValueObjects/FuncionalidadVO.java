/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : FuncionalidadVO
 * Fecha de Creación : 8/02/2018, 10:28:17 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class FuncionalidadVO {

    
    private String func_id;
    private String func_url;
    private String func_descripcion;
    private Timestamp func_fechacambio;
    private String func_registradopor;
    private String apli_id;

    public String getFunc_id() {
        return func_id;
    }

    public void setFunc_id(String func_id) {
        this.func_id = func_id;
    }

    public String getFunc_url() {
        return func_url;
    }

    public void setFunc_url(String func_url) {
        this.func_url = func_url;
    }

    public String getFunc_descripcion() {
        return func_descripcion;
    }

    public void setFunc_descripcion(String func_descripcion) {
        this.func_descripcion = func_descripcion;
    }

    public Timestamp getFunc_fechacambio() {
        return func_fechacambio;
    }

    public void setFunc_fechacambio(Timestamp func_fechacambio) {
        this.func_fechacambio = func_fechacambio;
    }

    public String getFunc_registradopor() {
        return func_registradopor;
    }

    public void setFunc_registradopor(String func_registradopor) {
        this.func_registradopor = func_registradopor;
    }

    public String getApli_id() {
        return apli_id;
    }

    public void setApli_id(String apli_id) {
        this.apli_id = apli_id;
    }
    
    
    
}
