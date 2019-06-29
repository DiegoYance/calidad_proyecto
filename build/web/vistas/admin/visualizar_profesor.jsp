<%-- 
    Document   : main
    Created on : 24/05/2019, 01:28:49 PM
    Author     : Diego Yance
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="pe.edu.unmsm.modelDAO.DocenteDAO"%>
<%@page import="pe.edu.unmsm.model.Docente"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Profesores</title>
  
        <!-- Custom fonts for this template-->
        <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="./css/sb-admin.css" rel="stylesheet">
        <link href="./css/admin_main.css" rel="stylesheet">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    </head>

    <body id="page-top">

        <div id="wrapper">
            
            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <br>
                    <img class="mx-auto d-block" src="./images/admin.jpg" alt="">
                    <h5 style="color:white;text-align: center">Administrador</h5>
                </li>
                <li class="nav-item dropdown active">
                    <a class="nav-link" href="Controlador?accion=main" id="pagesDropdown">
                        <em class="fas fa-users"></em>
                        <span>Profesor</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=gestion">
                        <em class="fas fa-copy"></em>
                        <span>Gestionar permisos</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=fecha_limite">
                        <em class="fas fa-clock"></em>
                        <span>Fijar fecha limite</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href='Controlador?accion=cerrar'>
                        <em class="fas fa-window-close"></em>
                        <span>Cerrar Sesión</span></a>
                </li>
            </ul>

            <div id="content-wrapper">
                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <div class="breadcrumb">
                        <div class="col-7">
                             <h1>PROFESORES</h1>
                        </div> 
                        <div class="col-5">
                            <div class="input-group">
                                <input id="buscador" type="text" class="form-control" placeholder="Buscar por nombre o codigo..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <em class="fas fa-search"></em>
                                    </button>
                                </div>
                            </div>
                        </div>
                        
                    </div>

                    <table class="table table-bordered" id="tabla" width="100%" style="text-align: center">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Código</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Disponibilidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            DocenteDAO docentes = new DocenteDAO();
                            Iterator<Docente> docenteIterator = docentes.listarDocente();
                            
                            if(docenteIterator!=null){
                                int i = 1;
                                while(docenteIterator.hasNext()){
                                    Docente doc = docenteIterator.next();
                            %>
                            <tr>
                                <td><%=i%></td>
                                <td><%=doc.getCodigo()%></td>
                                <td><%=doc.getNombres()%></td>
                                <td><%= doc.getApePaterno() + " " + 
                                            doc.getApeMaterno()%></td>
                                <td>
                                    <form method="POST" action="Controlador">
                                    <input type="hidden" value="<%=doc.getIdDocente()%>" name="id">
                                    <input class="btn btn-dark" type="submit" name="accion" value="Ver">
                                    </form>
                                </td>
                            </tr>
                            <%i++;}}%>
                        </tbody>
                    </table>
   
                </div>

            </div>

        </div>
        <script>
            $(document).ready(function(){
                $("#buscador").keyup(function(){
                _this = this;
                // Show only matching TR, hide rest of them
                $.each($("#tabla tbody tr"), function() {
                    if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                        $(this).hide();
                    else
                        $(this).show();
                    });
                });
            });
        </script>                  
    </body>

</html>

