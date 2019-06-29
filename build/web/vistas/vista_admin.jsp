<%-- 
    Document   : vista_admin
    Created on : 20/05/2019, 11:19:18 AM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vista de administrador</h1>
        <%
            
    HttpSession sesion = request.getSession();
    int idAdministrador;

    if(sesion.getAttribute("idAdministrador")!=null){
        idAdministrador = Integer.parseInt(sesion.getAttribute("idAdministrador").toString());
        out.println("id de Administrador: " +idAdministrador);
        //out.println("<a href='vista_admin.jsp?accion=cerrar'><h5>Cerrar Session " + usuario + "</h5></a>");
        out.println("<br><br><a href='Controlador?accion=cerrar'><h5>Cerrar Session </h5></a>");
        //out.println("<a href='auth/login.jsp?accion=cerrar'><h5>Cerrar Session " + usuario + "</h5></a>");
    }else{
        //out.println("<script>location.replace(login.jsp');</script>");
        //out.println("no hay session");
        response.sendRedirect("auth/login.jsp");
    }
    
    /*
    String accion = request.getParameter("accion");
    out.println("-->" + accion);
    
    if(accion != null){
            sesion.invalidate();
            out.println("-->" + request.getParameter("accion"));
            //response.sendRedirect("auth/login.jsp");  
            
    }
*/

%>
    </body>
</html>
