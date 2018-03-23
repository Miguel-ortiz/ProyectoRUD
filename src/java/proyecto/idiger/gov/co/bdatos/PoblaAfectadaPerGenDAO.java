/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.PoblAfectadaPerGenVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : PoblaAfectadaPerGenDAO
 * Fecha de Creación : 20/02/2018, 03:35:54 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PoblaAfectadaPerGenDAO {

    String usuarioVO = "";

    public PoblaAfectadaPerGenDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public boolean Insertar(PoblAfectadaPerGenVO PoblAfectadaPerGenVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs=Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_POBLAFECTADA(?,?,?,?,?,?,?,?)}");
            int i = 1;
            cs.setTimestamp(i++, PoblAfectadaPerGenVO.getPapg_fechacambio());
            cs.setString(i++, PoblAfectadaPerGenVO.getPapg_registradopor());
            cs.setString(i++, PoblAfectadaPerGenVO.getEpev_id());
            cs.setString(i++, PoblAfectadaPerGenVO.getTpfa_id());
            cs.setString(i++, PoblAfectadaPerGenVO.getCoat_id());
            cs.setString(i++, PoblAfectadaPerGenVO.getPege_id());
            cs.setString(i++, PoblAfectadaPerGenVO.getPapg_familia());
            cs.setString(i++, PoblAfectadaPerGenVO.getRpaf_id());
            cs.executeQuery();
            exito = true;
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";POBLAFECTADAPERGEN;PoblaAfectadaPerGenDAO;Insertar;" + PoblAfectadaPerGenVO.getRpaf_id());
        }  catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";POBLAFECTADAPERGEN;PoblaAfectadaPerGenDAO;Insertar;" + ex.getMessage());
        } finally {
            try {
                cs.close();
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";POBLAFECTADAPERGEN;PoblaAfectadaPerGenDAO;Insertar;" + e.getMessage());
            }
            try {
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";POBLAFECTADAPERGEN;PoblaAfectadaPerGenDAO;Insertar;"  + e.getMessage());
            }
        }
        return exito;
    }
}
