<%-- 
  Documento : cul_reg_ctr
  Fecha de Creación : 6/02/2018, 04:31:11 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.bdatos.BinTablasDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.BintablasVO"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ProcesaCadenas"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ManejadorFechas"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.RegistroRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.CultivosAfectadosRUDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.CultivosAfectadosRUDVO"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%!
    String path = "/menu/fuera.jsp";
    RespuestaXML RespuestaXML = new RespuestaXML();
    ObjetoRespuestaVO ObjetoRespuestaVO = new ObjetoRespuestaVO();
    boolean procesa = false;
    HttpSession _session = null;
    HttpServletRequest _request = null;
    ServletContext _application = null;
    UsuarioVO MiUsuarioVO = null;
    String _url = null;
    ManejadorFechas f = new ManejadorFechas();
    ProcesaCadenas o = new ProcesaCadenas();
%>
<%
    MiUsuarioVO = (UsuarioVO) session.getAttribute("miUsuarioVO");
    _session = (HttpSession) session;
    _request = (HttpServletRequest) request;
    _application = (ServletContext) application;
    if (MiUsuarioVO != null) {
        int opcion = request.getParameter("op") != null ? Integer.parseInt(request.getParameter("op")) : 0;
        SesionLogs.Logs.RegistrarLogs("ctr " + opcion + " " + _request.getParameter("op"));
        switch (opcion) {
            case 0:
                listarunidad();
                path = "/cultivos/cul_reg_ini.jsp";
                procesa = false;
                break;
            case 1:
                insertar();
                path = "/menu/index.jsp";
                procesa = false;
                break;
        }
    }
    if (procesa) {
        out.clear();
        out.print(RespuestaXML.GenerarXML(ObjetoRespuestaVO).toString().trim());
    } else {
        SesionLogs.Logs.RegistrarLogs(MiUsuarioVO != null ? MiUsuarioVO.getUsua_id() : "" + "; ; INGRESA A JSP ;" + path);
        RequestDispatcher dispatcher = application.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
%> 

<%!
    void insertar() throws UnsupportedEncodingException, Exception {
            SesionLogs.Logs.RegistrarLogs("error");
            CultivosAfectadosRUDVO afectadosRUDVO = new CultivosAfectadosRUDVO();
            CultivosAfectadosRUDAO afectadosRUDAO = new CultivosAfectadosRUDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDDAO rUDDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDVO rUDVO = (RegistroRUDVO) rUDDAO.NumRegistro();
            
            afectadosRUDVO.setCuaf_area(o.notNull(_request.getParameter("area_txt"), ""));
            afectadosRUDVO.setCuaf_nombre(o.notNull(_request.getParameter("nomcultivo_txt"), ""));
            afectadosRUDVO.setCuaf_credito(o.notNull(_request.getParameter("credito_sel"), ""));
            afectadosRUDVO.setCuaf_entiidadcredito(o.notNull(_request.getParameter("enticredi_txt"), ""));
            afectadosRUDVO.setCuaf_observaciones(o.notNull(_request.getParameter("obserculti_txt"), ""));
            afectadosRUDVO.setCuaf_unidad(o.notNull(_request.getParameter("unidad_sel"), ""));
            afectadosRUDVO.setCuaf_valorcredito(o.notNull(_request.getParameter("valorcre_txt"), ""));
            afectadosRUDVO.setRegi_id(rUDVO.getRegi_id());

            afectadosRUDAO.Insertar(afectadosRUDVO);
        }
    
    void listarunidad() throws UnsupportedEncodingException, Exception {

            List<BintablasVO> binTablasVOs = new BinTablasDAO(MiUsuarioVO.getUsua_id()).ListUnidad();
            _session.removeAttribute("UnidadVO");
            _session.removeAttribute("dato");
            if (binTablasVOs != null) {
                _session.setAttribute("UnidadVO", binTablasVOs);
                _session.setAttribute("dato", "si");
            }
        }
    %>