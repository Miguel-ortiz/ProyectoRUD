/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : EvaluacionTenicaVO
 * Fecha de Creación : 8/02/2018, 02:16:42 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class EvaluacionTenicaVO {

    private String evte_id;
    private String evte_descripcion;
    private String evte_registradopor;
    private Timestamp evte_fechacambio; 

    public String getEvte_id() {
        return evte_id;
    }

    public void setEvte_id(String evte_id) {
        this.evte_id = evte_id;
    }

    public String getEvte_descripcion() {
        return evte_descripcion;
    }

    public void setEvte_descripcion(String evte_descripcion) {
        this.evte_descripcion = evte_descripcion;
    }

    public String getEvte_registradopor() {
        return evte_registradopor;
    }

    public void setEvte_registradopor(String evte_registradopor) {
        this.evte_registradopor = evte_registradopor;
    }

    public Timestamp getEvte_fechacambio() {
        return evte_fechacambio;
    }

    public void setEvte_fechacambio(Timestamp evte_fechacambio) {
        this.evte_fechacambio = evte_fechacambio;
    }
    
    
}
