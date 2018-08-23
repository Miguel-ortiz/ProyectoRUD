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
 * Documento : PecuariosRUDDAO Fecha de Creación : 13/03/2018, 09:44:10 AM
 * Author : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER
 * Derechos Reservados de Uso Proyecto a Desarrollar : Expression
 * project.organization is undefined on line 15, column 31 in
 * Templates/Classes/Class.java. Funcion del Archivo :
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
            if (pecuariosRUDVO.getPecu_id() != null) {
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

    public List<PecuariosRUDVO> ListarPecuario(String id) throws Exception, SQLException {
        List<PecuariosRUDVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        PecuariosRUDVO pecuariosRUDVO = null;
        try {
            sql.append("SELECT PECU.*, ");
            sql.append("TPEC.TPPC_DESCRIPCION ");
            sql.append("FROM REGAFECTADOS.PECUARIOS_RUD PECU, ");
            sql.append("REGAFECTADOS.TIPOPECUARIO_RUD TPEC ");
            sql.append("WHERE PECU.REGI_ID = ").append(id);
            sql.append("AND TPEC.TPPC_ID = PECU.TPPC_ID ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(pecuariosRUDVO)) {
                    pecuariosRUDVO = new PecuariosRUDVO();
                    pecuariosRUDVO.setPecu_id(rs.getString("PECU_ID"));
                    pecuariosRUDVO.setRegi_id(rs.getString("REGI_ID"));
                    pecuariosRUDVO.setPecu_cantidad(rs.getString("PECU_CANTIDAD"));
                    pecuariosRUDVO.setPecu_especiepez(rs.getString("PECU_ESPECIEPEZ"));
                    pecuariosRUDVO.setPecu_observaciones(rs.getString("PECU_OBSERVACIONES"));
                    pecuariosRUDVO.setTppc_descripcion(rs.getString("TPPC_DESCRIPCION"));
                }
                SesionLogs.Logs.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;PecuariosRUDVO;Listarbienesafec;" + pecuariosRUDVO.getPecu_id());
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;PecuariosRUDVO;Listarbienesafec;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BIENESAFECTADOS_RUD;PecuariosRUDVO;Listarbienesafec;" + ex.getMessage());
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
