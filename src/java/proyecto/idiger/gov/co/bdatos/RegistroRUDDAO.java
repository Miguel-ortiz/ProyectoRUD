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
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : RegistroRUDDAO
 * Fecha de Creación : 16/02/2018, 10:16:03 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class RegistroRUDDAO {

    String usuarioVO = "";

    public RegistroRUDDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
  
    public boolean Insertar(RegistroRUDVO registroRUDVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs=Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_REGISTRO_RUD(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            int i = 1;
            cs.setString(i++, registroRUDVO.getRegi_subarriendo());
            cs.setString(i++, registroRUDVO.getRegi_observacion());
            cs.setString(i++, registroRUDVO.getRegi_cualplancontin());
            cs.setString(i++, registroRUDVO.getRegi_vereda());
            cs.setString(i++, registroRUDVO.getTpev_id());
            cs.setString(i++, registroRUDVO.getRegi_prestaservicio());
            cs.setString(i++, registroRUDVO.getRegi_entipresdadora());
            cs.setString(i++, registroRUDVO.getRegi_responsable());
            cs.setString(i++, registroRUDVO.getRegi_tipoayuda());
            cs.setString(i++, registroRUDVO.getRegi_idmunicipio());
            cs.setString(i++, registroRUDVO.getRegi_nomacueducto());
            cs.setString(i++, registroRUDVO.getRegi_entidad());
            cs.setString(i++, registroRUDVO.getRegi_alcantadillafectada());
            cs.setString(i++, registroRUDVO.getRegi_ubicacion());
            cs.setString(i++, registroRUDVO.getRegi_plancontingencia());
            cs.setString(i++, registroRUDVO.getRegi_ayudaentregada());
            cs.setString(i++, registroRUDVO.getRegi_corregimiento());
            cs.setString(i++, registroRUDVO.getRegi_numfamilia());
            cs.setString(i++, registroRUDVO.getRegi_materialvivienda());
            cs.setString(i++, registroRUDVO.getRegi_acueducto());
            cs.setTimestamp(i++, registroRUDVO.getRegi_fechaelaboracion());
            cs.registerOutParameter(i, 2);
            cs.executeQuery();
            registroRUDVO.setRegi_id(String.valueOf(cs.getLong(i)));
            if (registroRUDVO.getRegi_id()!= null) {
                exito = true;
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;Insertar;" + registroRUDVO.getRegi_id());
        }  catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;Insertar;" + ex.getMessage());
        } finally {
            try {
                cs.close();
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;Insertar;" + e.getMessage());
            }
            try {
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;Insertar;"  + e.getMessage());
            }
        }
        return exito;
    }
    
    public RegistroRUDVO NumRegistro() throws Exception, SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        RegistroRUDVO registroRUDVO = null;
        try {
        sql.append("SELECT * FROM ");
        sql.append("(SELECT REGI.REGI_ID FROM REGAFECTADOS.REGISTRO_RUD REGI ");
        sql.append("WHERE REGI.REGI_RESPONSABLE = '").append(usuarioVO).append("'");
        sql.append("ORDER BY REGI.REGI_ID DESC ) ");
        sql.append("WHERE ROWNUM = 1 ");
        ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                for (; rs.next();) {
                    registroRUDVO = new RegistroRUDVO();
                    registroRUDVO.setRegi_id(rs.getString("REGI_ID"));
                }
            }
              SesionLogs.Logs.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;NumRegistro;" + registroRUDVO.getRegi_id() );
        } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;NumRegistro;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;NumRegistro;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;NumRegistro;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";REGISTRO_RUD;RegistroRUDDAO;NumRegistro;" + ex.getMessage());
            }
        }
        return registroRUDVO;
    }
}
