/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.UsuarioVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : UsuarioDAO
 * Fecha de Creación : 9/02/2018, 02:32:47 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class UsuarioDAO {
    
   public Object consultar(String ID) throws SQLException, Exception {
        UsuarioVO datos = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT USUA.*, PENG.PEGE_PRIMERAPELLIDO ||' '|| PENG.PEGE_SEGUNDOAPELLIDO ||' '||  PENG.PEGE_PRIMERNOMBRE ||' '||  PENG.PEGE_SEGUNDOAPELLIDO as NOMBRECOMPLETO ");
            sql.append("FROM USUARIO USUA, PERSONAGENERAL PENG  ");
            sql.append("WHERE USUA.USUA_ID =").append(Integer.parseInt(ID));
            sql.append("AND USUA.PEGE_ID = PENG.PEGE_ID ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                datos = new UsuarioVO();
                datos.setPege_id(rs.getString("PEGE_ID"));
                datos.setUsua_id(rs.getString("USUA_ID"));
                datos.setNum_completo(rs.getString("NOMBRECOMPLETO"));
                datos.setUsua_entidad(rs.getString("USUA_ENTIDAD"));
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(datos.getUsua_id()+";UsuarioDAO; Consultar;"+ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    Conexion.desconectar();
                    ps.close();
                }
                if (rs != null) {
                    Conexion.desconectar();
                    rs.close();
                }
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (Exception ex) {
                SesionLogs.Errores.RegistrarLogs("::::::::: Error Cierre de Conexion :::::::::");
                SesionLogs.Errores.RegistrarLogs(ex.getMessage());
                SesionLogs.Errores.RegistrarLogs("::::::::: Fin de error :::::::::");
            }
        }
        return datos;
    }
}
