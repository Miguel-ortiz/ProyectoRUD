/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.logs;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Documento : SesionLogs
 * Fecha de Creación : 22/01/2018, 10:36:18 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : moortiz
 * Funcion del Archivo :
 */
public class SesionLogs implements HttpSessionListener {

    public static Logs Logs =new Logs("Logs");
    public static Logs Errores =new Logs("Errores");
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
      
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
       
    }   
}
