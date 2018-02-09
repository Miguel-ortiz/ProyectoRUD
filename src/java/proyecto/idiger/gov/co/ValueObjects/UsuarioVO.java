/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : UsuarioVO
 * Fecha de Creación : 8/02/2018, 10:27:32 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class UsuarioVO {

    private String usua_id;
    private String usua_entidad;
    private String usua_cargo;
    private Timestamp usua_fechacambio;
    private String pege_id;
    private String usua_registradopor;
    private String usua_usuario;
    private String usua_contrasena;
    private String usua_dependencia;

    public String getUsua_id() {
        return usua_id;
    }

    public void setUsua_id(String usua_id) {
        this.usua_id = usua_id;
    }

    public String getUsua_entidad() {
        return usua_entidad;
    }

    public void setUsua_entidad(String usua_entidad) {
        this.usua_entidad = usua_entidad;
    }

    public String getUsua_cargo() {
        return usua_cargo;
    }

    public void setUsua_cargo(String usua_cargo) {
        this.usua_cargo = usua_cargo;
    }

    public Timestamp getUsua_fechacambio() {
        return usua_fechacambio;
    }

    public void setUsua_fechacambio(Timestamp usua_fechacambio) {
        this.usua_fechacambio = usua_fechacambio;
    }

    public String getPege_id() {
        return pege_id;
    }

    public void setPege_id(String pege_id) {
        this.pege_id = pege_id;
    }

    public String getUsua_registradopor() {
        return usua_registradopor;
    }

    public void setUsua_registradopor(String usua_registradopor) {
        this.usua_registradopor = usua_registradopor;
    }

    public String getUsua_usuario() {
        return usua_usuario;
    }

    public void setUsua_usuario(String usua_usuario) {
        this.usua_usuario = usua_usuario;
    }

    public String getUsua_contrasena() {
        return usua_contrasena;
    }

    public void setUsua_contrasena(String usua_contrasena) {
        this.usua_contrasena = usua_contrasena;
    }

    public String getUsua_dependencia() {
        return usua_dependencia;
    }

    public void setUsua_dependencia(String usua_dependencia) {
        this.usua_dependencia = usua_dependencia;
    }
    
    
}
