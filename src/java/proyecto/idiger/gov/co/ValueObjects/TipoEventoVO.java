/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : TipoEventoVO
 * Fecha de Creación : 8/02/2018, 01:57:10 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoEventoVO {

    private String tpev_id;
    private String tpev_registradopor;
    private String tpev_descripcion;
    private Timestamp tpev_fechaevento;
    private Timestamp tpev_fechacambio;
    private String tpev_estado;

    public Timestamp getTpev_fechaevento() {
        return tpev_fechaevento;
    }

    public void setTpev_fechaevento(Timestamp tpev_fechaevento) {
        this.tpev_fechaevento = tpev_fechaevento;
    }

    public String getTpev_id() {
        return tpev_id;
    }

    public void setTpev_id(String tpev_id) {
        this.tpev_id = tpev_id;
    }

    public String getTpev_registradopor() {
        return tpev_registradopor;
    }

    public void setTpev_registradopor(String tpev_registradopor) {
        this.tpev_registradopor = tpev_registradopor;
    }

    public String getTpev_descripcion() {
        return tpev_descripcion;
    }

    public void setTpev_descripcion(String tpev_descripcion) {
        this.tpev_descripcion = tpev_descripcion;
    }

    public Timestamp getTpev_fechacambio() {
        return tpev_fechacambio;
    }

    public void setTpev_fechacambio(Timestamp tpev_fechacambio) {
        this.tpev_fechacambio = tpev_fechacambio;
    }

    public String getTpev_estado() {
        return tpev_estado;
    }

    public void setTpev_estado(String tpev_estado) {
        this.tpev_estado = tpev_estado;
    }
    
    
}
