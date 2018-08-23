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
import proyecto.idiger.gov.co.ValueObjects.BienesAfectadosRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : BienesAfectadosRUDAO Fecha de Creación : 15/03/2018, 02:43:54 PM
 * Author : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER
 * Derechos Reservados de Uso Proyecto a Desarrollar : Expression
 * project.organization is undefined on line 15, column 31 in
 * Templates/Classes/Class.java. Funcion del Archivo :
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
            if (bienesAfectadosRUDVO.getBiaf_id() != null) {
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

    public List<BienesAfectadosRUDVO> Listarbienesafec(String id) throws Exception, SQLException {
        List<BienesAfectadosRUDVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BienesAfectadosRUDVO bienesAfectadosRUDVO = null;
        try {
            sql.append("SELECT BIAF.BIAF_ID, ");
            sql.append("BIAF.REGI_ID, ");
            sql.append("BIAF.BIAF_MUNICIPIO, ");
            sql.append("BIAF.BIAF_CORREGIMIENTO, ");
            sql.append("BIAF.BIAF_VEREDA, ");
            sql.append("BIAF.BIAF_SECTOR, ");
            sql.append("BIAF.BIAF_DIRECCION, ");
            sql.append("BIAF_BARRIO, ");
            sql.append("TUVI.TUVI_DESCRIPCION, ");
            sql.append("TTVI.TTVI_DESCRIPCION, ");
            sql.append("TPAF.TPAF_DESCRIPCION ");
            sql.append("FROM REGAFECTADOS.BIENESAFECTADOS_RUD BIAF,  ");
            sql.append("REGAFECTADOS.TIPOUSOVIVIENDA TUVI,  ");
            sql.append("REGAFECTADOS.TIPOTENENCIAVIVIENDA TTVI, ");
            sql.append("REGAFECTADOS.TIPOAFECTACION_RUD TPAF ");
            sql.append("WHERE BIAF.REGI_ID = ").append(id);
            sql.append("AND BIAF.TUVI_ID = TUVI.TUVI_ID ");
            sql.append("AND BIAF.TTVI_ID = TTVI.TTVI_ID  ");
            sql.append("AND BIAF.TPAF_ID = TPAF.TPAF_ID ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(bienesAfectadosRUDVO)) {
                    bienesAfectadosRUDVO = new BienesAfectadosRUDVO();
                    bienesAfectadosRUDVO.setBiaf_id(rs.getString("BIAF_ID"));
                    bienesAfectadosRUDVO.setRegi_id(rs.getString("REGI_ID"));
                    bienesAfectadosRUDVO.setTuvi_id(rs.getString("TUVI_DESCRIPCION"));
                    bienesAfectadosRUDVO.setTtvi_id(rs.getString("TTVI_DESCRIPCION"));
                    bienesAfectadosRUDVO.setTpaf_id(rs.getString("TPAF_DESCRIPCION"));
                    bienesAfectadosRUDVO.setBiaf_municipio(rs.getString("BIAF_MUNICIPIO"));
                    bienesAfectadosRUDVO.setBiaf_corregimiento(rs.getString("BIAF_CORREGIMIENTO"));
                    bienesAfectadosRUDVO.setBiaf_vereda(rs.getString("BIAF_VEREDA"));
                    bienesAfectadosRUDVO.setBiaf_sector(rs.getString("BIAF_SECTOR"));
                    bienesAfectadosRUDVO.setBiaf_barrio(rs.getString("BIAF_BARRIO"));
                    bienesAfectadosRUDVO.setBiaf_direccion(rs.getString("BIAF_DIRECCION"));
                }
                SesionLogs.Logs.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + bienesAfectadosRUDVO.getBiaf_id());
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
        }
        return lista;
    }
}
