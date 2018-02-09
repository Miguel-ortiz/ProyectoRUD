<%-- 
  Documento : per_reg_ctr
  Fecha de Creación : 5/02/2018, 04:16:16 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%!
    String path = "/fuera.jsp";
    RespuestaXML RespuestaXML = new RespuestaXML();
    ObjetoRespuestaVO ObjetoRespuestaVO = new ObjetoRespuestaVO();
    boolean procesa = false;
    HttpSession _session = null;
    HttpServletRequest _request = null;
    ServletContext _application = null;
    String MiUsuarioVO = "Miguel Ortiz";
    String _url = null;
%>
<%
    _session = (HttpSession) session;
    _request = (HttpServletRequest) request;
    _application = (ServletContext) application;
    if (MiUsuarioVO != null) {
        int opcion = request.getParameter("op") != null ? Integer.parseInt(request.getParameter("op")) : 0;
        SesionLogs.Logs.RegistrarLogs("ctr " + opcion + " " + _request.getParameter("op"));
        switch (opcion) {
            case 0:
                path = "/personas/per_reg_reg.jsp";
                procesa = false;
                break;
            case 1:
                procesa = false;
                path = "/personas/per_reg_reg.jsp";
                break;
        }
    }
    if (procesa) {
        out.clear();
        out.print(RespuestaXML.GenerarXML(ObjetoRespuestaVO).toString().trim());
    } else {
        SesionLogs.Logs.RegistrarLogs(MiUsuarioVO != null ? MiUsuarioVO : "" + "; ; INGRESA A JSP ;" + path);
        RequestDispatcher dispatcher = application.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
%>        
