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
import proyecto.idiger.gov.co.ValueObjects.TipoDocumentoIdentidadVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : TipoDocumentoIdentidadDAO
 * Fecha de Creación : 21/02/2018, 08:48:19 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoDocumentoIdentidadDAO {

     String usuarioVO = "";

    public TipoDocumentoIdentidadDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
     public List<TipoDocumentoIdentidadVO> ListarDocumento() throws Exception, SQLException {
        List<TipoDocumentoIdentidadVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        TipoDocumentoIdentidadVO documentoIdentidadVO = null;
        try {
            sql.append("SELECT * FROM REGAFECTADOS.TIPODOCUMENTOIDENTIDAD WHERE TPDO_ESTADO = 1 ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(documentoIdentidadVO)) {
                    documentoIdentidadVO = new TipoDocumentoIdentidadVO();
                    documentoIdentidadVO.setTpdo_id(rs.getString("TPDO_ID"));
                    documentoIdentidadVO.setTpdo_descripcion(rs.getString("TPDO_DESCRIPCION"));
                    documentoIdentidadVO.setTpdo_abreviacion(rs.getString("TPDO_ABREVIACION"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";TIPODOCUMENTOIDENTIDAD;TipoDocumentoIdentidadDAO;ListarDocumento;");
        }  catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPODOCUMENTOIDENTIDAD;TipoDocumentoIdentidadDAO;ListarDocumento;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPODOCUMENTOIDENTIDAD;TipoDocumentoIdentidadDAO;ListarDocumento;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPODOCUMENTOIDENTIDAD;TipoDocumentoIdentidadDAO;ListarDocumento;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPODOCUMENTOIDENTIDAD;TipoDocumentoIdentidadDAO;ListarDocumento;" + ex.getMessage());
            }
        }
        return lista;
    }
}
