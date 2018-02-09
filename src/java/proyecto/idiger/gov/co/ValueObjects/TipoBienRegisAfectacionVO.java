/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoBienRegisAfectacionVO 
 * Fecha de Creación : 8/02/2018, 10:12:58 AM 
 * Author : Ingeniero Miguel O. Ortiz 
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 inTemplates/Classes/Class.java. 
 * Funcion del Archivo :
 */
public class TipoBienRegisAfectacionVO {

    private String tpbi_id;
    private String rpaf_id;
    private Timestamp tbra_registradopor;
    private String tbra_fechacambio;

    public String getTpbi_id() {
        return tpbi_id;
    }

    public void setTpbi_id(String tpbi_id) {
        this.tpbi_id = tpbi_id;
    }

    public String getRpaf_id() {
        return rpaf_id;
    }

    public void setRpaf_id(String rpaf_id) {
        this.rpaf_id = rpaf_id;
    }

    public Timestamp getTbra_registradopor() {
        return tbra_registradopor;
    }

    public void setTbra_registradopor(Timestamp tbra_registradopor) {
        this.tbra_registradopor = tbra_registradopor;
    }

    public String getTbra_fechacambio() {
        return tbra_fechacambio;
    }

    public void setTbra_fechacambio(String tbra_fechacambio) {
        this.tbra_fechacambio = tbra_fechacambio;
    }
    
    
}
