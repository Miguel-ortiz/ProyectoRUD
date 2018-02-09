/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import proyecto.idiger.gov.co.Metodos.ManejadorFechas;

/**
 * Documento : Logs
 * Fecha de Creación : 22/01/2018, 10:32:17 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : moortiz
 * Funcion del Archivo :
 */
public class Logs {

    FileWriter archivo;
    String ruta = null;

    public Logs(String ruta) {
         ManejadorFechas f = new ManejadorFechas();
        this.ruta = ruta + f.getCadenaArchivo().substring(0, 7) + ".csv";
    }
    
    
    public void setRuta(String ruta) {
        ManejadorFechas f = new ManejadorFechas();
        this.ruta = ruta + f.getCadenaArchivo().substring(0, 8) + ".csv";
    }
    
    

    public boolean RegistrarLogs( String mensaje) throws IOException {
        boolean exito = false;
        boolean primera = false;
        //   if (ObjetoRespuestaVO != null) {
            //   if (ObjetoRespuestaVO.getRutaLogs() != null) {
                if (ruta != null) {
                //ManejadorFechas f = new ManejadorFechas();
                //  ruta = ObjetoRespuestaVO.getRutaLogs() + f.getCadenaArchivo() + ".txt";
                //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
                if (new File(ruta).exists() == false) {
                    archivo = new FileWriter(new File(ruta), false);
                    primera = true;
                }
                archivo = new FileWriter(new File(ruta), true);
                Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar    
                //Empieza a escribir en el archivo
                if(primera){
                    if(ruta.equals("Logs")){
                  archivo.write("Fecha;Hora;Usuario;Tabla;Accion;id_registro \r\n");
                    }
                    else{
                        archivo.write("Fecha;Hora;Usuario;Tabla;Funcion;Accion;id_registro \r\n");
                    }
                  primera=false;
                }
                archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                        + "/" + String.valueOf(fechaActual.get(Calendar.MONTH) + 1)
                        + "/" + String.valueOf(fechaActual.get(Calendar.YEAR))
                        + ";" + String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                        + ":" + String.valueOf(fechaActual.get(Calendar.MINUTE))
                        + ":" + String.valueOf(fechaActual.get(Calendar.SECOND))) + ";" + mensaje.replaceAll("\n", " ") + "\r\n");
                archivo.close(); //Se cierra el archivo
            }
   //     }
        return exito;
    }
}
