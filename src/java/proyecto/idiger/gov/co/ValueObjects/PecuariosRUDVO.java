/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

/**
 * Documento : PecuariosRUDVO
 * Fecha de Creación : 15/02/2018, 04:14:58 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PecuariosRUDVO {

    private String pecu_id;
    private String tppc_id;
    private String pecu_cantidad;
    private String pecu_observaciones;
    private String pecu_especiepez;
    private String regi_id;
    
    private String tppc_descripcion; 

    public String getPecu_id() {
        return pecu_id;
    }

    public void setPecu_id(String pecu_id) {
        this.pecu_id = pecu_id;
    }

    public String getTppc_id() {
        return tppc_id;
    }

    public void setTppc_id(String tppc_id) {
        this.tppc_id = tppc_id;
    }

    public String getPecu_cantidad() {
        return pecu_cantidad;
    }

    public void setPecu_cantidad(String pecu_cantidad) {
        this.pecu_cantidad = pecu_cantidad;
    }

    public String getPecu_observaciones() {
        return pecu_observaciones;
    }

    public void setPecu_observaciones(String pecu_observaciones) {
        this.pecu_observaciones = pecu_observaciones;
    }

    public String getPecu_especiepez() {
        return pecu_especiepez;
    }

    public void setPecu_especiepez(String pecu_especiepez) {
        this.pecu_especiepez = pecu_especiepez;
    }

    public String getRegi_id() {
        return regi_id;
    }

    public void setRegi_id(String regi_id) {
        this.regi_id = regi_id;
    }

    public String getTppc_descripcion() {
        return tppc_descripcion;
    }

    public void setTppc_descripcion(String tppc_descripcion) {
        this.tppc_descripcion = tppc_descripcion;
    }
       
}
