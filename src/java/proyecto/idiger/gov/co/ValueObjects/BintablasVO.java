/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.ValueObjects;

import java.sql.Timestamp;

/**
 * Documento : BintablasVO
 * Fecha de Creación : 15/03/2018, 10:56:40 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class BintablasVO {

   private String nombre;
   private String argumento;
   private String resultado;
   private Timestamp vig_inicial;
   private Timestamp vig_final;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Timestamp getVig_inicial() {
        return vig_inicial;
    }

    public void setVig_inicial(Timestamp vig_inicial) {
        this.vig_inicial = vig_inicial;
    }

    public Timestamp getVig_final() {
        return vig_final;
    }

    public void setVig_final(Timestamp vig_final) {
        this.vig_final = vig_final;
    }
   
   
}
