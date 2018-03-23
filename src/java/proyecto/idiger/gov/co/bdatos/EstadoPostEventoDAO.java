/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.EstadoPostEventoVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : EstadoPostEventoDAO
 Fecha de Creación : 21/02/2018, 10:55:16 AM
 Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class EstadoPostEventoDAO {

       String usuarioVO = "";

    public EstadoPostEventoDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
     public List<EstadoPostEventoVO> ListarCondiciones() throws Exception, SQLException {
        List<EstadoPostEventoVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        EstadoPostEventoVO estadoPostEventoVO =  null;
        try {
            sql.append("SELECT * FROM REGAFECTADOS.ESTADOPOSTEVENTO WHERE EPVE_ESTADO = 1");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(estadoPostEventoVO)) {
                    estadoPostEventoVO = new EstadoPostEventoVO();
                    estadoPostEventoVO.setEpev_id(rs.getString("EPEV_ID"));
                    estadoPostEventoVO.setEpev_descricion(rs.getString("EPEV_DESCRICION"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";CONDICIONESACTUALES;CondicionesActualesDAO;ListarCondiciones;");
        }  catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CONDICIONESACTUALES;CondicionesActualesDAO;ListarCondiciones;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CONDICIONESACTUALES;CondicionesActualesDAO;ListarCondiciones;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CONDICIONESACTUALES;CondicionesActualesDAO;ListarCondiciones;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CONDICIONESACTUALES;CondicionesActualesDAO;ListarCondiciones;" + ex.getMessage());
            }
        }
        return lista;
    }
}
