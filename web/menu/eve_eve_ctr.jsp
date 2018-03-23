<%-- 
  Documento : eve_eve_ctr
  Fecha de Creación : 26/02/2018, 02:50:09 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page import="proyecto.idiger.gov.co.bdatos.TipoEventoDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoEventoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%!
    String path = "/menu/fuera.jsp";
    RespuestaXML RespuestaXML = new RespuestaXML();
    ObjetoRespuestaVO ObjetoRespuestaVO = new ObjetoRespuestaVO();
    boolean procesa = false, x = true;
    HttpSession _session = null;
    HttpServletRequest _request = null;
    HttpServletResponse _response = null;
    ServletContext _application = null;
    String _url = null;
%>

<%
    _session = (HttpSession) session;
    _request = (HttpServletRequest) request;
    _application = (ServletContext) application;
    _response = (HttpServletResponse) response;

    int opcion = request.getParameter("op") != null ? Integer.parseInt(request.getParameter("op")) : 0;
//    SesionLogs.Logs.RegistrarLogs("ctr " + opcion + " " + _request.getParameter("op"));
    switch (opcion) {
        case 0:
//            _session.removeAttribute("");
            _session.removeAttribute("tipoEventoVO");
            path = "/menu/eve_eve_ini.jsp";
            procesa = false;
            break;
        case 1:
            _session.removeAttribute("tipoEventoVO");
            listaEvento();
            path = "/menu/eve_eve_ini.jsp";
            procesa = false;
            break;
        case 2:
            seleccionarDatos();
            path = "/menu/eve_eve_bus.jsp";
            procesa = false;
            break;
        case 3:
            Ingreso();
//            path = "index.jsp";
            response.sendRedirect(this._url);
            x = false;
            break;
        case 4:
            response.sendRedirect("/ProyectoRUD/menu/eve_eve_ctr.jsp");
            procesa = false;
            break;
    }

    if (x) {
        if (procesa) {
            out.clear();
            out.print(RespuestaXML.GenerarXML(ObjetoRespuestaVO).toString().trim());
        } else {
            RequestDispatcher dispatcher = application.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        }
    }

%>
<%!
    void seleccionarDatos() throws UnsupportedEncodingException, Exception {
        _session.removeAttribute("tipoEvento");
        _session.removeAttribute("tpev_id");
        TipoEventoVO tipoEventoVO = new TipoEventoDAO("0").bitacora(_request.getParameter("tpev_id"));
        _session.setAttribute("tipoEvento", tipoEventoVO);
        _session.setAttribute("tpev_id", _request.getParameter("tpev_id"));

    }

    void Ingreso() throws UnsupportedEncodingException, Exception {
        _session.removeAttribute("tipoEvento");
        _session.removeAttribute("user");
        _session.removeAttribute("pass");
        this._url = "index.jsp";

    }

    void listaEvento() throws UnsupportedEncodingException, Exception {
        try {
            _session.removeAttribute("tipoEventoVO");
            _session.removeAttribute("datos");
            _session.removeAttribute("modulo");
            List<TipoEventoVO> tipoEventoVO = new TipoEventoDAO("0").buscarEventos(_request.getParameter("tipoevento_txt"));

            if (tipoEventoVO != null) {
                _session.setAttribute("tipoEventoVO", tipoEventoVO);
                _session.setAttribute("datos", "si");
            }
        } catch (Exception ex) {
            SesionLogs.Errores.RegistrarLogs("-------" + ex.getMessage());
        }
    }
%>