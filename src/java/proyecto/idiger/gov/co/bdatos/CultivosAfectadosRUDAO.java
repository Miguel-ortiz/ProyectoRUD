/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.CultivosAfectadosRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : CultivosAfectadosRUDAO
 * Fecha de Creación : 15/03/2018, 02:43:34 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class CultivosAfectadosRUDAO {

     String usuarioVO = "";

    public CultivosAfectadosRUDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public boolean Insertar(CultivosAfectadosRUDVO cultivosAfectadosRUDVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs = Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_CULTIVOSAFEC(?,?,?,?,?,?,?,?,?)}");
            int i = 1;
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_observaciones());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_valorcredito());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_entiidadcredito());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_credito());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_unidad());
            cs.setString(i++, cultivosAfectadosRUDVO.getRegi_id());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_area());
            cs.setString(i++, cultivosAfectadosRUDVO.getCuaf_nombre());
            cs.registerOutParameter(i, 2);
            cs.executeQuery();
            cultivosAfectadosRUDVO.setCuaf_id(String.valueOf(cs.getLong(i)));
            if (cultivosAfectadosRUDVO.getCuaf_id()!= null) {
                exito = true;
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;CultivosAfectadosRUDAO;Insertar;" + cultivosAfectadosRUDVO.getCuaf_id());
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;CultivosAfectadosRUDAO;Insertar;" + ex.getMessage());
        } finally {
            try {
                cs.close();
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;CultivosAfectadosRUDAO;Insertar;" + e.getMessage());
            }
            try {
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;CultivosAfectadosRUDAO;Insertar;" + e.getMessage());
            }
        }
        return exito;
    }
}
