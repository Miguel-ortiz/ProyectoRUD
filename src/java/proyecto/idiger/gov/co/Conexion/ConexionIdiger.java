/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : ConexionIdiger Fecha de Creación : 9/02/2018, 02:33:56 PM Author
 * : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER Derechos
 * Reservados de Uso Proyecto a Desarrollar : Expression project.organization is
 * undefined on line 15, column 31 in Templates/Classes/Class.java. Funcion del
 * Archivo :
 */
public class ConexionIdiger {
 /**Parametros de conexion*/
   static String bd = "jdbc/Regafectados";
   static String login = "REGAFECTADOS";
   static String password = "regafectados2017";
   static String url = "jdbc:oracle:thin:@//fopaescan.fopaedom.local:1521/siredb";
   Connection connection = null;
 
   public ConexionIdiger() {
      try{
         //obtenemos el driver 
         Class.forName("oracle.jdbc.OracleDriver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
         if (connection!=null){
            SesionLogs.Logs.RegistrarLogs("Conexión a base de datos "+bd+" OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
   public void desconectar(){
      connection = null;
   }
}