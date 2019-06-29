<%@page import="pe.edu.unmsm.modelDAO.CursoDAO"%>
<%
    int idEscuela = Integer.parseInt(request.getParameter("idEscuela"));
    
    CursoDAO curso = new CursoDAO();
    
    out.println(curso.pintarSelectCurso(idEscuela, "idSelectCurso4"));
        
    

%>
