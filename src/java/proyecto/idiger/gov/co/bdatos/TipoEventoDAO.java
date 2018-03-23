/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.idiger.gov.co.bdatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.TipoEventoVO;
import proyecto.idiger.gov.co.logs.SesionLogs;
import proyecto.idiger.gov.co.Metodos.ManejadorFechas;

/**
 * Documento : TipoEventoDAO Fecha de Creación : 16/02/2018, 11:32:53 AM Author
 * : Ingeniero Miguel O. Ortiz Propiedad Intelectual : Area TIC IDIGER Derechos
 * Reservados de Uso Proyecto a Desarrollar : Expression project.organization is
 * undefined on line 15, column 31 in Templates/Classes/Class.java. Funcion del
 * Archivo :
 */
public class TipoEventoDAO {

    String usuarioVO = "";

    public TipoEventoDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public TipoEventoVO tipoEvento(String id) throws Exception, SQLException {
        TipoEventoVO tipoEventoVO = new TipoEventoVO();
        ManejadorFechas mf = new ManejadorFechas();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT TPEV.* FROM REGAFECTADOS.TIPOEVENTO TPEV WHERE TPEV.TPEV_ID =").append(Integer.parseInt(id));
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                for (; rs.next();) {
                    tipoEventoVO = new TipoEventoVO();
                    tipoEventoVO.setTpev_id(rs.getString("TPEV_ID"));
                    tipoEventoVO.setTpev_descripcion(rs.getString("TPEV_DESCRIPCION"));
                    tipoEventoVO.setTpev_fechaevento(rs.getTimestamp("TPEV_FECHAEVENTO"));
                    SesionLogs.Logs.RegistrarLogs(usuarioVO + ";TipoEvento;TipoEventoDAO;Consultar Tipo Evento;" + tipoEventoVO.getTpev_id());
                }
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
        }
        return tipoEventoVO;
    }

    public List<TipoEventoVO> listarEventos() throws Exception, SQLException {
        List<TipoEventoVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        TipoEventoVO eventoVO = null;
        try {
            sql.append("SELECT BITA.BIT_IDENTIFICADOR,BITA.BIT_NUSE_ID,BITA.BIT_FECHA_REPORTE,TIEV.TEV_TIPO  ");
            sql.append("FROM SIRE.BITACORAS BITA, SIRE.TIPOS_EVENTO TIEV ");
            sql.append("WHERE TIEV.TEV_ID = BITA.BIT_TEV_ID ");
//            sql.append("-- AND TO_CHAR(BITA.BIT_FECHA_INICIO,'YYYY') = TO_CHAR(SYSDATE,'YYYY') ");
            sql.append("AND BITA.ESTADO = 'A' ");
//            sql.append("-- AND BITA.BIT_FECHA_FINAL = NULL  ");
            sql.append("AND BITA.BIT_FALSA_ALARMA = 'NO' ");
            sql.append("AND BITA.BIT_DUPLICADO = 'NO' ");
            sql.append("AND BITA.RPT_ESTADO_EVENTOS = '1' ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(eventoVO)) {
                    eventoVO = new TipoEventoVO();
                    eventoVO.setTpev_id(rs.getString("BIT_IDENTIFICADOR"));
                    eventoVO.setTpev_descripcion(rs.getString("TEV_TIPO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;listarEventos;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;listarEventos;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;listarEventos;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;listarEventos;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;listarEventos;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public TipoEventoVO bitacora(String id) throws Exception, SQLException {
        TipoEventoVO tipoEventoVO = new TipoEventoVO();
        ManejadorFechas mf = new ManejadorFechas();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        try {
            sql.append("SELECT BITA.* FROM SIRE.BITACORAS BITA WHERE BITA.BIT_IDENTIFICADOR =").append(Integer.parseInt(id));
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                for (; rs.next();) {
                    tipoEventoVO = new TipoEventoVO();
                    tipoEventoVO.setTpev_id(rs.getString("BIT_IDENTIFICADOR"));
                    tipoEventoVO.setTpev_descripcion(rs.getString("BIT_NOMB_EMER"));
                    tipoEventoVO.setTpev_fechaevento(rs.getTimestamp("BIT_FECHA_REPORTE"));
                    SesionLogs.Logs.RegistrarLogs(usuarioVO + ";TipoEvento;TipoEventoDAO;Consultar Tipo Evento;" + tipoEventoVO.getTpev_id());
                }
            }
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOEVENTO;TipoEventoDAO;Consultar Tipo Evento;" + ex.getMessage());
            }
        }
        return tipoEventoVO;
    }
    
    public List<TipoEventoVO> buscarEventos(String id) throws Exception, SQLException {
        List<TipoEventoVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        TipoEventoVO eventoVO = null;
        try {
            sql.append("SELECT BITA.* FROM SIRE.BITACORAS BITA WHERE BITA.BIT_IDENTIFICADOR LIKE '%").append(Integer.parseInt(id)).append("%'");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(eventoVO)) {
                    eventoVO = new TipoEventoVO();
                    eventoVO.setTpev_id(rs.getString("BIT_IDENTIFICADOR"));
                    eventoVO.setTpev_descripcion(rs.getString("BIT_NOMB_EMER"));
                    eventoVO.setTpev_fechaevento(rs.getTimestamp("BIT_FECHA_REPORTE"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;buscarEventos;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;buscarEventos;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;buscarEventos;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;buscarEventos;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";BITACORAS;TipoEventoDAO;ListarParentesco;" + ex.getMessage());
            }
        }
        return lista;
    }
    
}
