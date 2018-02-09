/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : FuncionalidadUsuarioVO
 * Fecha de Creación : 22/01/2018, 11:24:21 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : moortiz
 * Funcion del Archivo :
 */
public class FuncionalidadUsuarioVO {
    private int func_id;
    private int pege_id;
    private String fuus_registradopor;
    private Timestamp fuus_fechacambio;
    
    private String func_codigo;
    private String func_titulo;
    private String func_descripcion;
    private String func_ruta;
    private int can_hijos;
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    

    public int getCan_hijos() {
        return can_hijos;
    }

    public void setCan_hijos(int can_hijos) {
        this.can_hijos = can_hijos;
    }

    public String getFunc_codigo() {
        return func_codigo;
    }

    public void setFunc_codigo(String func_codigo) {
        this.func_codigo = func_codigo;
    }

    public String getFunc_descripcion() {
        return func_descripcion;
    }

    public void setFunc_descripcion(String func_descripcion) {
        this.func_descripcion = func_descripcion;
    }

    public String getFunc_ruta() {
        return func_ruta;
    }

    public void setFunc_ruta(String func_ruta) {
        this.func_ruta = func_ruta;
    }

    public String getFunc_titulo() {
        return func_titulo;
    }

    public void setFunc_titulo(String func_titulo) {
        this.func_titulo = func_titulo;
    }

    public int getFunc_id() {
        return func_id;
    }

    public void setFunc_id(int func_id) {
        this.func_id = func_id;
    }

    public Timestamp getFuus_fechacambio() {
        return fuus_fechacambio;
    }

    public void setFuus_fechacambio(Timestamp fuus_fechacambio) {
        this.fuus_fechacambio = fuus_fechacambio;
    }

    public String getFuus_registradopor() {
        return fuus_registradopor;
    }

    public void setFuus_registradopor(String fuus_registradopor) {
        this.fuus_registradopor = fuus_registradopor;
    }

    public int getPege_id() {
        return pege_id;
    }

    public void setPege_id(int pege_id) {
        this.pege_id = pege_id;
    }
    
}