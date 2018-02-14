<%-- 
  Documento : bie_reg_ctr
  Fecha de Creación : 6/02/2018, 03:37:11 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%!
    String path = "menu/fuera.jsp";
    RespuestaXML RespuestaXML = new RespuestaXML();
    ObjetoRespuestaVO ObjetoRespuestaVO = new ObjetoRespuestaVO();
    boolean procesa = false;
    HttpSession _session = null;
    HttpServletRequest _request = null;
    ServletContext _application = null;
    UsuarioVO MiUsuarioVO = null;
    String _url = null;
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
                path = "/bienes/bie_reg_bia.jsp";
                procesa = false;
                break;
            case 1:
                procesa = false;
                path = "/bienes/bie_reg_bia.jsp";
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
