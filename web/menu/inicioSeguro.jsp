<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="java.util.*, java.lang.*" %>
<%
    response.addHeader("Pragma", "No-cache");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Expires", "1");
  
    String pagina = (String) request.getParameter("pagina");
%>

<html>
    <head>
        <title>IDIGER - Registro Unico de Damnificados </title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>
    <frameset rows="0,*" framespacing="0" frameborder="NO" border="0" onUnload="MM_openBrWindow('/menu/fueraC.jsp', 'Fuera', 'width=260, height=105, screenX=0, screenY=0, top=0, left=0, scrollbars=no, status=no, resizable=no')" >
        <frame name="topFrame" scrolling="NO" noresize />
            <frame name="mainFrame" src="<%=pagina%>" />
    </frameset>
    <noframes> 
        <body bgcolor="#FFFFFF" text="#000000" > 
        </body>
    </noframes> 
</html>