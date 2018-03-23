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
import proyecto.idiger.gov.co.ValueObjects.PersonaGeneralVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : PersonaGeneralDAO
 * Fecha de Creación : 19/02/2018, 04:47:57 PM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class PersonaGeneralDAO {

    String usuarioVO = "";

    public PersonaGeneralDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public boolean Insertar(PersonaGeneralVO personaGeneralVO) throws Exception, SQLException {
        boolean exito = false;
        ConexionIdiger Conexion = new ConexionIdiger();
        CallableStatement cs = null;
        try {
            cs=Conexion.getConnection().prepareCall("{CALL REGAFECTADOS.PR_REGAFECTADOS_I_PERSONAGENER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            int i = 1;
            cs.setString(i++, personaGeneralVO.getPege_registradopor());
            cs.setTimestamp(i++, personaGeneralVO.getPege_fechanaciniento());
            cs.setString(i++, personaGeneralVO.getPege_primerapellido());
            cs.setString(i++, personaGeneralVO.getPege_direccion());
            cs.setString(i++, personaGeneralVO.getPege_barrio());
            cs.setString(i++, personaGeneralVO.getPege_segundoapellido());
            cs.setString(i++, personaGeneralVO.getPege_celular());
            cs.setString(i++, personaGeneralVO.getPege_segundonombre());
            cs.setString(i++, personaGeneralVO.getPege_primernombre());
            cs.setTimestamp(i++, personaGeneralVO.getPege_fechacambio());
            cs.setString(i++, personaGeneralVO.getPege_mail());
            cs.setString(i++, personaGeneralVO.getPege_genero());
            cs.setString(i++, personaGeneralVO.getTpdo_id());
            cs.setString(i++, personaGeneralVO.getPege_documento());
            cs.setString(i++, personaGeneralVO.getPege_telefono());
            cs.setString(i++, personaGeneralVO.getEtni_id());
            cs.setString(i++, personaGeneralVO.getRegm_id());
            cs.setString(i++, personaGeneralVO.getPege_afrocolombia());
            cs.registerOutParameter(i, 2);
            cs.executeQuery();
            personaGeneralVO.setPege_id(String.valueOf(cs.getLong(i)));
            if (personaGeneralVO.getPege_id()!= null) {
                exito = true;
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;Insertar;" + personaGeneralVO.getPege_id());
        }  catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;Insertar;" + ex.getMessage());
        } finally {
            try {
                cs.close();
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;Insertar;" + e.getMessage());
            }
            try {
                Conexion.desconectar();
            } catch (SQLException e) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;Insertar;"  + e.getMessage());
            }
        }
        return exito;
    }
    
    public int NumeroSiguintePersona() throws Exception {
        int serie = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT LAST_NUMBER from user_sequences WHERE SEQUENCE_NAME = 'S_PEGE_ID'");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    serie = rs.getInt("LAST_NUMBER");
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;NumeroSiguintePersona;" + serie );
        } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;NumeroSiguintePersona;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;NumeroSiguintePersona;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;NumeroSiguintePersona;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;NumeroSiguintePersona;" + ex.getMessage());
            }
        }

        return serie;
    }
        
    public List<PersonaGeneralVO> ListarPersona(String id) throws Exception, SQLException {
        List<PersonaGeneralVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        PersonaGeneralVO personaGeneralVO = null;
        try {
            sql.append("SELECT PEGE.PEGE_PRIMERNOMBRE ||' '||  PEGE.PEGE_SEGUNDOAPELLIDO as NOMBRES, ");
            sql.append("PEGE.PEGE_PRIMERAPELLIDO ||' '|| PEGE.PEGE_SEGUNDOAPELLIDO as APELLIDOS, ");
            sql.append("PEGE.PEGE_ID,  ");
            sql.append("PEGE.TPDO_ID, ");
            sql.append("PEGE.PEGE_DOCUMENTO, ");
            sql.append("PEGE.PEGE_FECHANACINIENTO, ");
            sql.append("PEGE.PEGE_GENERO, ");
            sql.append("PEGE.PEGE_DIRECCION, ");
            sql.append("PEGE.PEGE_BARRIO, ");
            sql.append("PEGE.PEGE_TELEFONO, ");
            sql.append("PEGE.PEGE_MAIL, ");
            sql.append("PEGE.PEGE_MAIL, ");
            sql.append("PEGE.PEGE_CELULAR, ");
            sql.append("PEGE.ETNI_ID, ");
            sql.append("PEGE.REGM_ID, ");
            sql.append("PEGE.PEGE_AFROCOLOMBIANO, ");
            sql.append("PAPG.PAPG_FAMILIA, ");
            sql.append("TPFA.TPFA_DESCRIPCION, ");
            sql.append("COAT.COAT_DESCRIPCION ");
            sql.append("FROM REGAFECTADOS.PERSONAGENERAL PEGE,  ");
            sql.append("REGAFECTADOS.POBLAFECTADAPERGEN PAPG,  ");
            sql.append("REGAFECTADOS.TIPOPARENTESCOFAMILAR TPFA, ");
            sql.append("REGAFECTADOS.CONDICIONESACTUALES COAT ");
            sql.append("WHERE PAPG.RPAF_ID = ").append(id);
            sql.append("AND PAPG.PEGE_ID = PEGE.PEGE_ID ");
            sql.append("AND PAPG.COAT_ID = COAT.COAT_ID(+) ");
            sql.append("AND PAPG.TPFA_ID = TPFA.TPFA_ID(+) ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(personaGeneralVO)) {
                    personaGeneralVO = new PersonaGeneralVO();
                    personaGeneralVO.setPege_id(rs.getString("PEGE_ID"));
                    personaGeneralVO.setPege_primernombre(rs.getString("NOMBRES"));
                    personaGeneralVO.setPege_primerapellido(rs.getString("APELLIDOS"));
                    personaGeneralVO.setPege_documento(rs.getString("PEGE_DOCUMENTO"));
                    personaGeneralVO.setPege_genero(rs.getString("PEGE_GENERO"));
                }
                SesionLogs.Logs.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;ListarPersona;" + personaGeneralVO.getPege_id() );
            }
        }  catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";PERSONAGENERAL;PersonaGeneralDAO;ListarPersona;" + ex.getMessage());
            }
        }
        return lista;
    }
}
