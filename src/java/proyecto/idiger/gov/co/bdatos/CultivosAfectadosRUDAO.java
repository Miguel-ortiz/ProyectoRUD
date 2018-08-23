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
import proyecto.idiger.gov.co.ValueObjects.CultivosAfectadosRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : CultivosAfectadosRUDAO Fecha de Creación : 15/03/2018, 02:43:34
 * PM Author : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER
 * Derechos Reservados de Uso Proyecto a Desarrollar : Expression
 * project.organization is undefined on line 15, column 31 in
 * Templates/Classes/Class.java. Funcion del Archivo :
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
            if (cultivosAfectadosRUDVO.getCuaf_id() != null) {
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

    public List<CultivosAfectadosRUDVO> ListarCultivo(String id) throws Exception, SQLException {
        List<CultivosAfectadosRUDVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        CultivosAfectadosRUDVO cultivosAfectadosRUDVO = null;
        try {
            sql.append("SELECT CUAF.CUAF_ID, ");
            sql.append("CUAF.REGI_ID, ");
            sql.append("CUAF.CUAF_AREA, ");
            sql.append("CUAF.CUAF_CREDITO, ");
            sql.append("CUAF.CUAF_VALORCREDITO, ");
            sql.append("CUAF.CUAF_ENTIIDADCREDITO, ");
            sql.append("CUAF.CUAF_OBSERVACIONES, ");
            sql.append("CUAF.CUAF_NOMBRE ");
//            sql.append("UNID.RESULTADO ");
            sql.append("FROM REGAFECTADOS.CULTIVOSAFECTADOS_RUD CUAF ");
//            sql.append("SIRE_COMUN.BINTABLAS UNID ");
//            sql.append("WHERE UNID.NOMBRE = 'UNIDAD' ");
//            sql.append("AND UNID.ARGUMENTO = CUAF.CUAF_UNIDAD ");
            sql.append("WHERE CUAF.REGI_ID = ").append(id);
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(cultivosAfectadosRUDVO)) {
                    cultivosAfectadosRUDVO = new CultivosAfectadosRUDVO();
                    cultivosAfectadosRUDVO.setCuaf_id(rs.getString("CUAF_ID"));
                    cultivosAfectadosRUDVO.setRegi_id(rs.getString("REGI_ID"));
                    cultivosAfectadosRUDVO.setCuaf_area(rs.getString("CUAF_AREA"));
//                    cultivosAfectadosRUDVO.setCuaf_unidad(rs.getString("CUAF_UNIDAD"));
                    cultivosAfectadosRUDVO.setCuaf_credito(rs.getString("CUAF_CREDITO"));
                    cultivosAfectadosRUDVO.setCuaf_valorcredito(rs.getString("CUAF_VALORCREDITO"));
                    cultivosAfectadosRUDVO.setCuaf_entiidadcredito(rs.getString("CUAF_ENTIIDADCREDITO"));
                    cultivosAfectadosRUDVO.setCuaf_observaciones(rs.getString("CUAF_OBSERVACIONES"));
                    cultivosAfectadosRUDVO.setCuaf_nombre(rs.getString("CUAF_NOMBRE"));
                }
                SesionLogs.Logs.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + cultivosAfectadosRUDVO.getCuaf_id());
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;BienesAfectadosRUDAO;Listarbienesafec;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";CULTIVOSAFECTADOS_RUD;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
        }
        return lista;
    }
}
