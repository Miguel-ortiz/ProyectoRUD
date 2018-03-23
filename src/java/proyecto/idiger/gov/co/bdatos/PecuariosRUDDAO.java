/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.PecuariosRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : PecuariosRUDDAO
 * Fecha de Creación : 13/03/2018, 09:44:10 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PecuariosRUDDAO {

    String usuarioVO = "";

    public PecuariosRUDDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public boolean Insertar(PecuariosRUDVO pecuariosRUDVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs = Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_PECUARIOS_RU(?,?,?,?,?,?)}");
            int i = 1;
            cs.setString(i++, pecuariosRUDVO.getTppc_id());
            cs.setString(i++, pecuariosRUDVO.getPecu_cantidad());
            cs.setString(i++, pecuariosRUDVO.getPecu_observaciones());
            cs.setString(i++, pecuariosRUDVO.getPecu_especiepez());
            cs.setString(i++, pecuariosRUDVO.getRegi_id());
            cs.registerOutParameter(i, 2);
            cs.executeQuery();
            pecuariosRUDVO.setPecu_id(String.valueOf(cs.getLong(i)));
            if (pecuariosRUDVO.getPecu_id()!= null) {
                exito = true;
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";PECUARIOS_RUD;PecuariosRUDDAO;Insertar;" + pecuariosRUDVO.getPecu_id());
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PECUARIOS_RUD;PecuariosRUDDAO;Insertar;" + ex.getMessage());
        } finally {
            try {
                cs.close();
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PECUARIOS_RUD;PecuariosRUDDAO;Insertar;" + e.getMessage());
            }
            try {
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PECUARIOS_RUD;PecuariosRUDDAO;Insertar;" + e.getMessage());
            }
        }
        return exito;
    }    
}
