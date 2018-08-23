/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import proyecto.idiger.gov.co.logs.SesionLogs;
import proyecto.idiger.gov.co.Metodos.EnviarMail;

/**
 * Documento : ConexionIdiger Fecha de Creación : 9/02/2018, 02:33:56 PM Author
 * : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER Derechos
 * Reservados de Uso Proyecto a Desarrollar : Expression project.organization is
 * undefined on line 15, column 31 in Templates/Classes/Class.java. Funcion del
 * Archivo :
 */
public class ConexionIdiger {

    /**
     * Parametros de conexion
     */
    static String bd = "jdbc/Regafectados";
    Connection connection = null;

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() throws SQLException, Exception {
        connection = null;
        SesionLogs.Logs.RegistrarLogs(";;ConexionIdiger;Desconexión a base de datos " + bd + " OK ;Desconexión");
    }

    public ConexionIdiger() throws SQLException, Exception{
        try {
            InitialContext context = new InitialContext();
            DataSource datasource = (DataSource) context.lookup("jdbc/Regafectados");
            connection = datasource.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(ConexionIdiger.class.getName()).log(Level.SEVERE, null, ex);
            EnviarMail.EnviarMail(ex);
        }
//        return connection;
    }
}
