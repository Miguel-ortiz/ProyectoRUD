<%-- 
  Documento : bie_reg_ctr
  Fecha de Creación : 6/02/2018, 03:37:11 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.RegistroRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.BienesAfectadosRUDVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.BienesAfectadosRUDAO"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ProcesaCadenas"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ManejadorFechas"%>
<%@page import="proyecto.idiger.gov.co.bdatos.BinTablasDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.BintablasVO"%>
<%@page import="java.util.List"%>
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
                listarAfectacion();
                listarTenencia();
                listarTipoBien();
                consultar();
                path = "/bienes/bie_reg_ini.jsp";
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
            BienesAfectadosRUDVO bienesAfectadosRUDVO = new BienesAfectadosRUDVO();
            BienesAfectadosRUDAO bienesAfectadosRUDAO = new BienesAfectadosRUDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDDAO rUDDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDVO rUDVO = (RegistroRUDVO) rUDDAO.NumRegistro();
            
            bienesAfectadosRUDVO.setBiaf_barrio(o.notNull(_request.getParameter("barrio_txt"), ""));
            bienesAfectadosRUDVO.setBiaf_corregimiento(o.notNull(_request.getParameter("corregi_txt"), ""));
            bienesAfectadosRUDVO.setBiaf_direccion(o.notNull(_request.getParameter("direccion_txt"), ""));
            bienesAfectadosRUDVO.setBiaf_municipio(o.notNull(_request.getParameter("municipio_sel"), ""));
            bienesAfectadosRUDVO.setBiaf_sector(o.notNull(_request.getParameter("sector_txt"), ""));
            bienesAfectadosRUDVO.setBiaf_vereda(o.notNull(_request.getParameter("vereda_txt"), ""));
            bienesAfectadosRUDVO.setTpaf_id(o.notNull(_request.getParameter("afectacion_sel"), ""));
            bienesAfectadosRUDVO.setTtvi_id(o.notNull(_request.getParameter("tenencia_sel"), ""));
            bienesAfectadosRUDVO.setRegi_id(rUDVO.getRegi_id());
            bienesAfectadosRUDVO.setTuvi_id(o.notNull(_request.getParameter("tipobien_sel"), ""));

            bienesAfectadosRUDAO.Insertar(bienesAfectadosRUDVO);
        }
    
    void listarAfectacion() throws UnsupportedEncodingException, Exception {

            List<BintablasVO> afectacionVOs = new BinTablasDAO(MiUsuarioVO.getUsua_id()).ListAfectacion();
            _session.removeAttribute("afectacionVO");
            _session.removeAttribute("dato");
            if (afectacionVOs != null) {
                _session.setAttribute("afectacionVO", afectacionVOs);
                _session.setAttribute("dato", "si");
            }
        }
    
    void listarTenencia() throws UnsupportedEncodingException, Exception {

            List<BintablasVO> tenenciaVOs = new BinTablasDAO(MiUsuarioVO.getUsua_id()).ListTenencia();
            _session.removeAttribute("tenenciaVO");
            _session.removeAttribute("dato");
            if (tenenciaVOs != null) {
                _session.setAttribute("tenenciaVO", tenenciaVOs);
                _session.setAttribute("dato", "si");
            }
        }
    void listarTipoBien() throws UnsupportedEncodingException, Exception {

            List<BintablasVO> tipoBienVOs = new BinTablasDAO(MiUsuarioVO.getUsua_id()).ListTipoBien();
            _session.removeAttribute("tipoBienVO");
            _session.removeAttribute("dato");
            if (tipoBienVOs != null) {
                _session.setAttribute("tipoBienVO", tipoBienVOs);
                _session.setAttribute("dato", "si");
            }
        }
    void consultar() throws UnsupportedEncodingException, Exception {

        RegistroRUDDAO dDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
        List<BienesAfectadosRUDVO> bienesAfectadosRUDVOs = new BienesAfectadosRUDAO(MiUsuarioVO.getUsua_id()).Listarbienesafec(dDAO .NumRegistro().getRegi_id());
        _session.removeAttribute("bienesAfectadosRUDVO");
        _session.removeAttribute("datos");
        if (bienesAfectadosRUDVOs != null) {
            _session.setAttribute("bienesAfectadosRUDVO", bienesAfectadosRUDVOs);
            _session.setAttribute("datos", "si");
        }
    }
%>