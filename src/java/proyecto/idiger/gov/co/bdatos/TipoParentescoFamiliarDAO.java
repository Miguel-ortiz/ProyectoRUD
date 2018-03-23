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
import proyecto.idiger.gov.co.ValueObjects.TipoParentescoFamilarVO;
import proyecto.idiger.gov.co.logs.SesionLogs;

/**
 * Documento : TipoParentescoFamiliarDAO
 * Fecha de Creación : 21/02/2018, 09:49:28 AM
 * Author : Ingeniero Miguel O. Ortiz
 * Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
 * Proyecto a Desarrollar : Expression project.organization is undefined on line 15, column 31 in Templates/Classes/Class.java.
 * Funcion del Archivo :
 */
public class TipoParentescoFamiliarDAO {

     String usuarioVO = "";

    public TipoParentescoFamiliarDAO(String usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
     public List<TipoParentescoFamilarVO> ListarParentesco() throws Exception, SQLException {
        List<TipoParentescoFamilarVO> lista = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionIdiger Conexion = new ConexionIdiger();
        StringBuilder sql = new StringBuilder();
        TipoParentescoFamilarVO tipoParentescoFamilarVO =  null;
        try {
            sql.append("SELECT * FROM REGAFECTADOS.TIPOPARENTESCOFAMILAR ");
            ps = Conexion.getConnection().prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList();
                for (; rs.next(); lista.add(tipoParentescoFamilarVO)) {
                    tipoParentescoFamilarVO = new TipoParentescoFamilarVO();
                    tipoParentescoFamilarVO.setTpfa_id(rs.getString("TPFA_ID"));
                    tipoParentescoFamilarVO.setTpfa_descripcion(rs.getString("TPFA_DESCRIPCION"));
                }
            }
            SesionLogs.Logs.RegistrarLogs(usuarioVO + ";TIPOPARENTESCOFAMILAR;TipoParentescoFamiliarDAO;ListarParentesco;");
        }  catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOPARENTESCOFAMILAR;TipoParentescoFamiliarDAO;ListarParentesco;" + ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOPARENTESCOFAMILAR;TipoParentescoFamiliarDAO;ListarParentesco;" + ex.getMessage());
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOPARENTESCOFAMILAR;TipoParentescoFamiliarDAO;ListarParentesco;" + ex.getMessage());
            }
            try {
                if (Conexion != null) {
                    Conexion.desconectar();
                }
            } catch (SQLException ex) {
                SesionLogs.Errores.RegistrarLogs(usuarioVO + ";TIPOPARENTESCOFAMILAR;TipoParentescoFamiliarDAO;ListarParentesco;" + ex.getMessage());
            }
        }
        return lista;
    }
}