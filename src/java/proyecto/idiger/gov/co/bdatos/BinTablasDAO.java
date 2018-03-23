/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.idiger.gov.co.bdatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto.idiger.gov.co.Conexion.ConexionIdiger;
import proyecto.idiger.gov.co.ValueObjects.BintablasVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : BinTablasDAO
 * Fecha de Creación : 13/03/2018, 09:42:22 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class BinTablasDAO {

    String usuarioVO = "";

    public BinTablasDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public List<BintablasVO> ListParentesco() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO familarVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'PARENTESCO' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(familarVO)) {
                    familarVO = new BintablasVO();
                    familarVO.setArgumento(rs.getString("ARGUMENTO"));
                    familarVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListParentesco;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListParentesco;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListParentesco;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListParentesco;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListParentesco;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListTipoDocumento() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO tdivo = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'T_DOCUMENTO' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(tdivo)) {
                    tdivo = new BintablasVO();
                    tdivo.setArgumento(rs.getString("ARGUMENTO"));
                    tdivo.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoDocumento;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoDocumento;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoDocumento;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoDocumento;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoDocumento;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListTipoBien() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO bienVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'TIPOBIEN' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(bienVO)) {
                    bienVO = new BintablasVO();
                    bienVO.setArgumento(rs.getString("ARGUMENTO"));
                    bienVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoBien;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoBien;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoBien;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoBien;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoBien;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListTenencia() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO teneciaVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'TENENCIA' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(teneciaVO)) {
                    teneciaVO = new BintablasVO();
                    teneciaVO.setArgumento(rs.getString("ARGUMENTO"));
                    teneciaVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTenencia;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTenencia;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTenencia;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTenencia;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTenencia;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListAfectacion() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO afectacionVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'AFECTACION' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(afectacionVO)) {
                    afectacionVO = new BintablasVO();
                    afectacionVO.setArgumento(rs.getString("ARGUMENTO"));
                    afectacionVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListAfectacion;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListAfectacion;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListAfectacion;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListAfectacion;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListAfectacion;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListUnidad() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO cultivosVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'UNIDAD' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(cultivosVO)) {
                    cultivosVO = new BintablasVO();
                    cultivosVO.setArgumento(rs.getString("ARGUMENTO"));
                    cultivosVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListCultivos;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListCultivos;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListCultivos;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListCultivos;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListCultivos;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListTipoPecuario() throws Exception,SQLException{
    List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO pecuariosRUDVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'PECUARIOS' AND VIG_FINAL is null ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(pecuariosRUDVO)) {
                    pecuariosRUDVO = new BintablasVO();
                    pecuariosRUDVO.setArgumento(rs.getString("ARGUMENTO"));
                    pecuariosRUDVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoPecuario;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoPecuario;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoPecuario;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoPecuario;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListTipoPecuario;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListDepartamento() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO deptoVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'DEPTO' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(deptoVO)) {
                    deptoVO = new BintablasVO();
                    deptoVO.setArgumento(rs.getString("ARGUMENTO"));
                    deptoVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListDepartamento;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListDepartamento;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListDepartamento;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListDepartamento;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListDepartamento;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> ListMunicipos(String id) throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO municipoVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'MUNICIPIOS' ");     
            sql.append("AND ARGUMENTO LIKE '").append(id).append("%' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(municipoVO)) {
                    municipoVO = new BintablasVO();
                    municipoVO.setArgumento(rs.getString("ARGUMENTO"));
                    municipoVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListMunicipos;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListMunicipos;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListMunicipos;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListMunicipos;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;ListMunicipos;" + ex.getMessage());
            }
        }
        return lista;
    }
    
    public List<BintablasVO> Listlocalidad() throws Exception, SQLException {
        List<BintablasVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        BintablasVO localidadVO = null;
        try {
            sql.append("SELECT * FROM SIRE_COMUN.BINTABLAS WHERE NOMBRE = 'LOCALIDAD' AND VIG_FINAL is null");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(localidadVO)) {
                    localidadVO = new BintablasVO();
                    localidadVO.setArgumento(rs.getString("ARGUMENTO"));
                    localidadVO.setResultado(rs.getString("RESULTADO"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;Listlocalidad;");
        } catch (SQLException ex) {
            SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;Listlocalidad;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;Listlocalidad;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;Listlocalidad;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";SIRE_COMUN.BINTABLAS;BinTablasDAO;Listlocalidad;" + ex.getMessage());
            }
        }
        return lista;
    }
}
