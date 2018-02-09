/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : PermisosVO
 * Fecha de Creación : 8/02/2018, 10:28:56 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PermisosVO {

    private String func_id;
    private String usua_id;
    private String perm_registradopor;
    private Timestamp perm_fechacambio;

    public String getFunc_id() {
        return func_id;
    }

    public void setFunc_id(String func_id) {
        this.func_id = func_id;
    }

    public String getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(String usua_id) {
        this.usua_id = usua_id;
    }

    public String getPerm_registradopor() {
        return perm_registradopor;
    }

    public void setPerm_registradopor(String perm_registradopor) {
        this.perm_registradopor = perm_registradopor;
    }

    public Timestamp getPerm_fechacambio() {
        return perm_fechacambio;
    }

    public void setPerm_fechacambio(Timestamp perm_fechacambio) {
        this.perm_fechacambio = perm_fechacambio;
    }
    
    
}
