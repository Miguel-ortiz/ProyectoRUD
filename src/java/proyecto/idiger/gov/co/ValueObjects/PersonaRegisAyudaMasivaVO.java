/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : PersonaRegisAyudaMasivaVO
 Fecha de Creación : 8/02/2018, 10:31:25 AM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PersonaRegisAyudaMasivaVO {

    private String pram_id;
    private String eama_id;
    private String tevi_id;
    private String pram_cantidaentregar;
    private String pege_entregayuda;
    private String pram_registradopor;
    private Timestamp pram_fechacambio;

    public String getPram_id() {
        return pram_id;
    }

    public void setPram_id(String pram_id) {
        this.pram_id = pram_id;
    }

    public String getEama_id() {
        return eama_id;
    }

    public void setEama_id(String eama_id) {
        this.eama_id = eama_id;
    }

    public String getTevi_id() {
        return tevi_id;
    }

    public void setTevi_id(String tevi_id) {
        this.tevi_id = tevi_id;
    }

    public String getPram_cantidaentregar() {
        return pram_cantidaentregar;
    }

    public void setPram_cantidaentregar(String pram_cantidaentregar) {
        this.pram_cantidaentregar = pram_cantidaentregar;
    }

    public String getPege_entregayuda() {
        return pege_entregayuda;
    }

    public void setPege_entregayuda(String pege_entregayuda) {
        this.pege_entregayuda = pege_entregayuda;
    }

    public String getPram_registradopor() {
        return pram_registradopor;
    }

    public void setPram_registradopor(String pram_registradopor) {
        this.pram_registradopor = pram_registradopor;
    }

    public Timestamp getPram_fechacambio() {
        return pram_fechacambio;
    }

    public void setPram_fechacambio(Timestamp pram_fechacambio) {
        this.pram_fechacambio = pram_fechacambio;
    }
    
    
}
