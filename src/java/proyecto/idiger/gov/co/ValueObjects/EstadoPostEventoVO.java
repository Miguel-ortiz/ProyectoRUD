/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : EstadoPostEventoVO 
 * Fecha de Creación : 8/02/2018, 10:17:33 AM
 * Author : Ingeniero Miguel O. Ortiz 
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java. 
 * Funcion del Archivo :
 */
public class EstadoPostEventoVO {

    private String epev_id;
    private String epev_registrodopor;
    private String epev_descricion;
    private Timestamp epve_fechacambio;
    private String epve_estado;

    public String getEpev_id() {
        return epev_id;
    }

    public void setEpev_id(String epev_id) {
        this.epev_id = epev_id;
    }

    public String getEpev_registrodopor() {
        return epev_registrodopor;
    }

    public void setEpev_registrodopor(String epev_registrodopor) {
        this.epev_registrodopor = epev_registrodopor;
    }

    public String getEpev_descricion() {
        return epev_descricion;
    }

    public void setEpev_descricion(String epev_descricion) {
        this.epev_descricion = epev_descricion;
    }

    public Timestamp getEpve_fechacambio() {
        return epve_fechacambio;
    }

    public void setEpve_fechacambio(Timestamp epve_fechacambio) {
        this.epve_fechacambio = epve_fechacambio;
    }

    public String getEpve_estado() {
        return epve_estado;
    }

    public void setEpve_estado(String epve_estado) {
        this.epve_estado = epve_estado;
    }
    
    
}
