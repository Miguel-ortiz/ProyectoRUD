/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.BienesAfectadosRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : BienesAfectadosRUDAO
 * Fecha de Creación : 15/03/2018, 02:43:54 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class BienesAfectadosRUDAO {

     String usuarioVO = "";

    public BienesAfectadosRUDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public boolean Insertar(BienesAfectadosRUDVO bienesAfectadosRUDVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs = Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_BIENESAFECTA(?,?,?,?,?,?,?,?,?,?,?)}");
            int i = 1;
            cs.setString(i++, bienesAfectadosRUDVO.getTtvi_id());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_direccion());
            cs.setString(i++, bienesAfectadosRUDVO.getTpaf_id());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_barrio());
            cs.setString(i++, bienesAfectadosRUDVO.getRegi_id());
            cs.setString(i++, bienesAfectadosRUDVO.getTuvi_id());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_sector());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_corregimiento());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_vereda());
            cs.setString(i++, bienesAfectadosRUDVO.getBiaf_municipio());
            cs.registerOutParameter(i, 2);
            cs.executeQuery();
            bienesAfectadosRUDVO.setBiaf_id(String.valueOf(cs.getLong(i)));
            if (bienesAfectadosRUDVO.getBiaf_id()!= null) {
                exito = true;
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";PECUARIOS_RUD;PecuariosRUDDAO;Insertar;" + bienesAfectadosRUDVO.getBiaf_id());
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
