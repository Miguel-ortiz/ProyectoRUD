/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : DanoVehiculoVO
 Fecha de Creación : 8/02/2018, 02:05:29 PM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class DanoVehiculoVO {

    private String davh_id;
    private String dahv_registradopor;
    private Timestamp davh_fechacambio;
    private String rpaf_id;

    public String getDavh_id() {
        return davh_id;
    }

    public void setDavh_id(String davh_id) {
        this.davh_id = davh_id;
    }

    public String getDahv_registradopor() {
        return dahv_registradopor;
    }

    public void setDahv_registradopor(String dahv_registradopor) {
        this.dahv_registradopor = dahv_registradopor;
    }

    public Timestamp getDavh_fechacambio() {
        return davh_fechacambio;
    }

    public void setDavh_fechacambio(Timestamp davh_fechacambio) {
        this.davh_fechacambio = davh_fechacambio;
    }

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }
    
    
}
