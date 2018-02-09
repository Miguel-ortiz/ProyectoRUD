/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : CondicionesActualesVO
 Fecha de Creación : 8/02/2018, 01:58:41 PM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class CondicionesActualesVO {

    private String coat_id;
    private String coat_registrodopor;
    private String coat_descripcion;
    private Timestamp coat_fechacambio;

    public String getCoat_id() {
        return coat_id;
    }

    public void setCoat_id(String coat_id) {
        this.coat_id = coat_id;
    }

    public String getCoat_registrodopor() {
        return coat_registrodopor;
    }

    public void setCoat_registrodopor(String coat_registrodopor) {
        this.coat_registrodopor = coat_registrodopor;
    }

    public String getCoat_descripcion() {
        return coat_descripcion;
    }

    public void setCoat_descripcion(String coat_descripcion) {
        this.coat_descripcion = coat_descripcion;
    }

    public Timestamp getCoat_fechacambio() {
        return coat_fechacambio;
    }

    public void setCoat_fechacambio(Timestamp coat_fechacambio) {
        this.coat_fechacambio = coat_fechacambio;
    }
    
    
}
