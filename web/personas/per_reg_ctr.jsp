<%-- 
  Documento : per_reg_ctr
  Fecha de Creación : 5/02/2018, 04:16:16 PM
  Author : Ingeniero Miguel O. Ortiz
  Propiedad Intelectual : Area TIC IDIGER Derechos Reservados de Uso 
  Proyecto a Desarrollar : moortiz
  Funcion del Archivo :
--%>

<%@page import="proyecto.idiger.gov.co.bdatos.EstadoPostEventoDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.EstadoPostEventoVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.TipoParentescoFamiliarDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoParentescoFamilarVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.TipoDocumentoIdentidadVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.TipoDocumentoIdentidadDAO"%>
<%@page import="java.util.List"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.RegistroRUDVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.PoblaAfectadaPerGenDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.PoblAfectadaPerGenVO"%>
<%@page import="proyecto.idiger.gov.co.bdatos.RegistroRUDDAO"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ManejadorFechas"%>
<%@page import="proyecto.idiger.gov.co.Metodos.ProcesaCadenas"%>
<%@page import="proyecto.idiger.gov.co.bdatos.PersonaGeneralDAO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.PersonaGeneralVO"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="proyecto.idiger.gov.co.Metodos.RespuestaXML"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.ObjetoRespuestaVO"%>
<%@page import="proyecto.idiger.gov.co.ValueObjects.UsuarioVO"%>
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
                listarDocumetento();
                listarParenresco();
                listarEstadoPostEven();
                consultar();
                path = "/personas/per_reg_ini.jsp";
                procesa = false;
                break;
            case 1:
                guardarpersona();
                path = "/menu/index.jsp";
                procesa = false;
                break;
        }
    }
    if (procesa) {
        out.clear();
        out.print(RespuestaXML.GenerarXML(ObjetoRespuestaVO).toString().trim());
    } else {
        SesionLogs.Logs.RegistrarLogs(MiUsuarioVO != null ? MiUsuarioVO.getUsua_id(): "" + "; ; INGRESA A JSP ;" + path);
        RequestDispatcher dispatcher = application.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
%> 

<%!
    void guardarpersona() throws UnsupportedEncodingException, Exception {

            SesionLogs.Logs.RegistrarLogs(MiUsuarioVO.getUsua_id() + ";;guardarpersona;;");
            PersonaGeneralVO personaGeneralVO = new PersonaGeneralVO();
            PersonaGeneralDAO personaGeneralDAO = new PersonaGeneralDAO(MiUsuarioVO.getUsua_id());
            RegistroRUDDAO rUDDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
            PoblAfectadaPerGenVO afectadaPerGenVO = new PoblAfectadaPerGenVO();
            PoblaAfectadaPerGenDAO afectadaPerGenDAO = new PoblaAfectadaPerGenDAO(MiUsuarioVO.getUsua_id());

            personaGeneralVO.setEtni_id(o.notNull(_request.getParameter("etnia_sel"), ""));
            personaGeneralVO.setPege_afrocolombia(o.notNull(_request.getParameter("afrocolom_sel"), ""));
            personaGeneralVO.setPege_barrio(o.notNull(_request.getParameter(""), ""));
            personaGeneralVO.setPege_celular(o.notNull(_request.getParameter(""), ""));
            personaGeneralVO.setPege_direccion(o.notNull(_request.getParameter(""), ""));
            personaGeneralVO.setPege_documento(o.notNull(_request.getParameter("documento_txt"), ""));
            personaGeneralVO.setPege_fechacambio(f.getFechaHoraTimeStamp());
            personaGeneralVO.setPege_fechanaciniento(f.retornaTimeStamp(o.notNull(_request.getParameter("fechanac_txt"), "")));
            personaGeneralVO.setPege_genero(o.notNull(_request.getParameter("genero_sel"), ""));
            personaGeneralVO.setPege_mail(o.notNull(_request.getParameter(""), ""));
            personaGeneralVO.setPege_primerapellido(o.notNull(_request.getParameter("primerape_txt"), ""));
            personaGeneralVO.setPege_primernombre(o.notNull(_request.getParameter("primernom_txt"), ""));
            personaGeneralVO.setPege_registradopor(MiUsuarioVO.getUsua_id());
            personaGeneralVO.setPege_segundoapellido(o.notNull(_request.getParameter("segundoape_txt"), ""));
            personaGeneralVO.setPege_segundonombre(o.notNull(_request.getParameter("segundonom_txt"), ""));
            personaGeneralVO.setPege_telefono(o.notNull(_request.getParameter(""), ""));
            personaGeneralVO.setRegm_id(o.notNull(_request.getParameter("regisalud_sel"), ""));
            personaGeneralVO.setTpdo_id(o.notNull(_request.getParameter("tipodocumento_sel"), ""));

            personaGeneralDAO.Insertar(personaGeneralVO);
            RegistroRUDVO rUDVO = (RegistroRUDVO) rUDDAO.NumRegistro();

            afectadaPerGenVO.setCoat_id(o.notNull(_request.getParameter(""), ""));
            afectadaPerGenVO.setEpev_id(o.notNull(_request.getParameter("estadosalud_sel"), ""));
            afectadaPerGenVO.setPapg_familia(o.notNull(_request.getParameter("numfamil_txt"), ""));
            afectadaPerGenVO.setPapg_fechacambio(f.getFechaHoraTimeStamp());
            afectadaPerGenVO.setPapg_registradopor(MiUsuarioVO.getUsua_id());
            afectadaPerGenVO.setPege_id(String.valueOf(personaGeneralDAO.NumeroSiguintePersona()-1));
            afectadaPerGenVO.setRpaf_id(rUDVO.getRegi_id());
            afectadaPerGenVO.setTpfa_id(o.notNull(_request.getParameter("parentesco_sel"), ""));

            afectadaPerGenDAO.Insertar(afectadaPerGenVO);
        }

    void consultar() throws UnsupportedEncodingException, Exception {

        RegistroRUDDAO dDAO = new RegistroRUDDAO(MiUsuarioVO.getUsua_id());
        List<PersonaGeneralVO> personaVOs = new PersonaGeneralDAO(MiUsuarioVO.getUsua_id()).ListarPersona(dDAO.NumRegistro().getRegi_id());
        _session.removeAttribute("personaVO");
        _session.removeAttribute("dato");
        if (personaVOs != null) {
            _session.setAttribute("personaVO", personaVOs);
            _session.setAttribute("dato", "si");
        }
    }

    void listarDocumetento() throws UnsupportedEncodingException, Exception {

        List<TipoDocumentoIdentidadVO> documentoIdentidadVOs = new TipoDocumentoIdentidadDAO(MiUsuarioVO.getUsua_id()).ListarDocumento();
        _session.removeAttribute("documentoIdentidadVO");
        _session.removeAttribute("dato");
        if (documentoIdentidadVOs != null) {
            _session.setAttribute("documentoIdentidadVO", documentoIdentidadVOs);
            _session.setAttribute("dato", "si");
        }
    }
    
 void listarParenresco() throws UnsupportedEncodingException, Exception {

         List<TipoParentescoFamilarVO> parentescoFamilarVOs = new TipoParentescoFamiliarDAO(MiUsuarioVO.getUsua_id()).ListarParentesco();
         _session.removeAttribute("parentescoFamilarVO");
         _session.removeAttribute("dato");
         if (parentescoFamilarVOs != null) {
             _session.setAttribute("parentescoFamilarVO", parentescoFamilarVOs);
             _session.setAttribute("dato", "si");
         }
     }
 
void listarEstadoPostEven() throws UnsupportedEncodingException, Exception {

         List<EstadoPostEventoVO> estadoPostEventoVOs = new EstadoPostEventoDAO(MiUsuarioVO.getUsua_id()).ListarCondiciones();
         _session.removeAttribute("estadoPostEventoVO");
         _session.removeAttribute("dato");
         if (estadoPostEventoVOs != null) {
             _session.setAttribute("estadoPostEventoVO", estadoPostEventoVOs);
             _session.setAttribute("dato", "si");
         }
     }
%>