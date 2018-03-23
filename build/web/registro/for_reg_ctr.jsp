<%-- 
  Documento : for_reg_ctr
  Fecha de Creación : 31/01/2018, 10:42:37 AM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.bdatos.RegistroRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ManejadorFechas"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ProcesaCadenas"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoEventoVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.logs.SesionLogs"%>
<%!
    String path = "/menu/fuera.jsp";
    RespuestaXML RespuestaXML = new RespuestaXML();
    ObjetoRespuestaVO ObjetoRespuestaVO = new ObjetoRespuestaVO();
    boolean procesa = false;
    HttpSession _session = null;
    HttpServletRequest _request = null;
    ServletContext _application = null;
    UsuarioVO MiUsuarioVO = null;
    TipoEventoVO tipoEventoVO = null;
    String _url = null;
    ManejadorFechas f = new ManejadorFechas();
    ProcesaCadenas o = new ProcesaCadenas();
%>
<%
    MiUsuarioVO = (UsuarioVO) session.getAttribute("miUsuarioVO");
    tipoEventoVO  = (TipoEventoVO) session.getAttribute("tipoEventoVO");
    _session = (HttpSession) session;
    _request = (HttpServletRequest) request;
    _application = (ServletContext) application;
    if (MiUsuarioVO != null) {
        int opcion = request.getParameter("op") != null ? Integer.parseInt(request.getParameter("op")) : 0;
        SesionLogs.Logs.RegistrarLogs("ctr " + opcion + " " + _request.getParameter("op"));
        switch (opcion) {
            case 0:
                path = "/registro/for_reg_ini.jsp";
                procesa = false;
                break;
            case 1:
                guardaRegistro();
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
    void guardaRegistro() throws UnsupportedEncodingException, Exception {

            SesionLogs.Logs.RegistrarLogs(MiUsuarioVO.getUsua_id() + ";guardarRegistro;;"+_request.getParameter("fechaelabo_txt"));
            RegistroRUDVO registroRUDVO = new RegistroRUDVO();
            RegistroRUDDAO registroRUDDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());

            registroRUDVO.setRegi_acueducto(o.notNull(_request.getParameter("acueducto_sel"), ""));
            registroRUDVO.setRegi_alcantadillafectada(o.notNull(_request.getParameter("alcantarilla_sel"), ""));
            registroRUDVO.setRegi_ayudaentregada(o.notNull(_request.getParameter("ayudamni_sel"), ""));
            registroRUDVO.setRegi_corregimiento(o.notNull(_request.getParameter("corregi_txt"), ""));
            registroRUDVO.setRegi_cualplancontin(o.notNull(_request.getParameter("cualcuntin_txt"), ""));
            registroRUDVO.setRegi_entidad(o.notNull(_request.getParameter("entidad_txt"), ""));
            registroRUDVO.setRegi_entipresdadora(o.notNull(_request.getParameter("entpresta_txt"), ""));
            registroRUDVO.setRegi_fechaelaboracion(f.retornaTimeStamp(o.notNull(_request.getParameter("fechaelabo_txt"), "")));
            registroRUDVO.setRegi_idmunicipio(o.notNull(_request.getParameter("municipio_sel"), ""));
            registroRUDVO.setRegi_materialvivienda(o.notNull(_request.getParameter("matervivien_sel"), ""));
            registroRUDVO.setRegi_nomacueducto(o.notNull(_request.getParameter("nomacueduc_txt"), ""));
            registroRUDVO.setRegi_numfamilia(o.notNull(_request.getParameter("numfamil_txt"), ""));
            registroRUDVO.setRegi_observacion(o.notNull(_request.getParameter("obserformreg_txt"), ""));
            registroRUDVO.setRegi_plancontingencia(o.notNull(_request.getParameter("planContin_sel"), ""));
            registroRUDVO.setRegi_prestaservicio(o.notNull(_request.getParameter("preservi_txt"), ""));
            registroRUDVO.setRegi_responsable(MiUsuarioVO.getUsua_id());
            registroRUDVO.setRegi_subarriendo(o.notNull(_request.getParameter("subarrien_sel"), ""));
            registroRUDVO.setRegi_tipoayuda(o.notNull(_request.getParameter("tipoayuda_txt"), ""));
            registroRUDVO.setRegi_ubicacion(o.notNull(_request.getParameter("ubicacion_sel"), ""));
            registroRUDVO.setRegi_vereda(o.notNull(_request.getParameter("vereda_txt"), ""));
            registroRUDVO.setTpev_id(o.notNull(_request.getParameter("tipoeven_sel"), ""));

            registroRUDDAO.Insertar(registroRUDVO);
}
    %>