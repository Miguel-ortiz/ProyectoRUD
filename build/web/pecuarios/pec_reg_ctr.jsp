<%-- 
  Documento : pec_reg_ctr
  Fecha de Creación : 7/02/2018, 01:54:41 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.ValueObjects.BintablasVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.BinTablasDAO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.RegistroRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ManejadorFechas"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ProcesaCadenas"%>
<%@page import="proyecto.idiger.gov.co.bdatos.PecuariosRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.PecuariosRUDVO"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.sql.SQLException"%>
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
                listarpecuario();
                path = "/pecuarios/pec_reg_ini.jsp";
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
            PecuariosRUDVO pecuariosRUDVO = new PecuariosRUDVO();
            PecuariosRUDDAO pecuariosRUDDAO = new PecuariosRUDDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDDAO rUDDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDVO rUDVO = (RegistroRUDVO) rUDDAO.NumRegistro();
            
            pecuariosRUDVO.setPecu_cantidad(o.notNull(_request.getParameter("cantidad_txt"), ""));
            pecuariosRUDVO.setPecu_especiepez(o.notNull(_request.getParameter("especipez_txt"), ""));
            pecuariosRUDVO.setPecu_observaciones(o.notNull(_request.getParameter("obserpecua_txt"), ""));
            pecuariosRUDVO.setRegi_id(rUDVO.getRegi_id());
            pecuariosRUDVO.setTppc_id(o.notNull(_request.getParameter("pecuario_sel"), ""));

            pecuariosRUDDAO.Insertar(pecuariosRUDVO);
        }
    
    void listarpecuario() throws UnsupportedEncodingException, Exception {

            List<BintablasVO> binTablasVOs = new BinTablasDAO(MiUsuarioVO.getUsua_id()).ListTipoPecuario();
            _session.removeAttribute("pecuariosRUDVO");
            _session.removeAttribute("dato");
            if (binTablasVOs != null) {
                _session.setAttribute("pecuariosRUDVO", binTablasVOs);
                _session.setAttribute("dato", "si");
            }
        }
%>