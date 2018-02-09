/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : AfectadoRegistroAyudaVO
 * Fecha de Creación : 8/02/2018, 02:18:31 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class AfectadoRegistroAyudaVO {

    private String arey_id;
    private Timestamp arey_fechacambio;
    private String pram_id;
    private String arey_registrdopor;
    private String afam_id;
    private String arey_detalle; 

    public String getArey_id() {
        return arey_id;
    }

    public void setArey_id(String arey_id) {
        this.arey_id = arey_id;
    }

    public Timestamp getArey_fechacambio() {
        return arey_fechacambio;
    }

    public void setArey_fechacambio(Timestamp arey_fechacambio) {
        this.arey_fechacambio = arey_fechacambio;
    }

    public String getPram_id() {
        return pram_id;
    }

    public void setPram_id(String pram_id) {
        this.pram_id = pram_id;
    }

    public String getArey_registrdopor() {
        return arey_registrdopor;
    }

    public void setArey_registrdopor(String arey_registrdopor) {
        this.arey_registrdopor = arey_registrdopor;
    }

    public String getAfam_id() {
        return afam_id;
    }

    public void setAfam_id(String afam_id) {
        this.afam_id = afam_id;
    }

    public String getArey_detalle() {
        return arey_detalle;
    }

    public void setArey_detalle(String arey_detalle) {
        this.arey_detalle = arey_detalle;
    }
    
    
}
