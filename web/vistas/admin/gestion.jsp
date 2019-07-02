<%-- 
    Document   : main
    Created on : 24/05/2019, 01:28:49 PM
    Author     : Diego Yance
--%>

<%@page import="pe.edu.unmsm.modelDAO.PermisosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Gestion de permisos</title>

        <!-- Custom fonts for this template-->
        <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet" type="text/css">


        <!-- Custom styles for this template-->
        <link href="./css/sb-admin.css" rel="stylesheet">
        <script src="./js/jquery-3.2.1.min.js"></script>
	
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        
    </head>

    <body id="page-top">

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <br>
                    <img class="mx-auto d-block" src="./images/admin.jpg" alt="" 
                        style="display: block;
                        width: 150px;
                        height: 150px;">
                    <h5 style="color:white;text-align: center;font-size: 1.28571429em;
                        font-weight: 700;
                        line-height: 1.2857em;
                        margin: 0;">Administrador</h5>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link" href="Controlador?accion=visualizar_profesor" id="pagesDropdown">
                        <em class="fas fa-users"></em>
                        <span>Profesor</span>
                    </a>
                </li>
                <li class="nav-item active">
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
                             <h1>GESTIONAR PERMISOS</h1>
                        </div> 
                        <div class="col-5">
                            <div class="input-group">
                                <input id="buscador" type="text" class="form-control" placeholder="Buscar por nombre o codigo..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered" id="tabla" width="100%" style="text-align: center">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                            PermisosDAO solicitudes = new PermisosDAO();
                            ResultSet rs = solicitudes.listarSolicitud();
                            while(rs != null && rs.next()){
                                if(rs.getInt("restriccion")==2){
                            %>
                            <tr>
                                <td><%=rs.getString("codigo")%></td>
                                <td><%=rs.getString("nombres")%></td>
                                <td><%= rs.getString("apellido_paterno") + " " + 
                                            rs.getString("apellido_materno")%></td>
                                <td>
                                    <div class="row">
                                        <div class="col-6">
                                            <form method="POST" action="Controlador">
                                                <input type="hidden" value="<%=rs.getString("idDocente")%>" name="id">
                                                <input class="btn btn-dark" type="submit" name="accion" value="Ver">
                                            </form>
                                        </div>
                                        <div class="col-6">
                                           
                                            <button class="btn btn-dark" type="button" data-toggle="modal" data-target="#modal_solicitud">
                                                Solicitud
                                            </button>
                                            <div class="modal fade" id="modal_solicitud" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                                <div class="modal-dialog modal-dialog-centered" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalCenterTitle">Solicitud de modificacion de disponibilidad</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <%=rs.getString("motivo")%>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <form method="POST" action="Controlador">
                                                            <input type="hidden" value="<%=rs.getString("idDocente")%>" name="id">
                                                            <button type="submit" class="btn btn-primary" name="accion" value="aceptar_edit">Aceptar</button>
                                                            <button type="submit" class="btn btn-primary" name="accion" value="negar_edit">Negar</button>
                                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>      
                                                            </form>
                                                        </div>
                                                    </div>
                                                 </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <%}}%>
                        </tbody>
                    </table>
                </div>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->
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

