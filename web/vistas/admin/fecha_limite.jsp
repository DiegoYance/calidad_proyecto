<%-- 
    Document   : main
    Created on : 24/05/2019, 01:28:49 PM
    Author     : Diego Yance
--%>

<%@page import="pe.edu.unmsm.modelDAO.PeriodoAcademicoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Fecha Limite</title>

        <!-- Custom fonts for this template-->
        <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="./css/sb-admin.css" rel="stylesheet">
        
        <link href="./css/core.min.css" rel="stylesheet">
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <script src="./js/jquery-3.2.1.min.js"></script>
        <script src="./js/core.min.js"></script>
        <script src="./js/datapicker.min.js"></script>

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
                <li class="nav-item">
                    <a class="nav-link" href="Controlador?accion=gestion">
                        <em class="fas fa-copy"></em>
                        <span>Gestionar permisos</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Controlador?accion=fecha_limite">
                        <em class="fas fa-clock"></em>
                        <span>Fijar fecha límite</span></a>
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
                        <h1>FIJAR FECHA LIMITE</h1>
                    </div>
                    <form method="POST" action="Controlador">
                        
                        <br><br>
                        
                        <%String fechas[] = new PeriodoAcademicoDAO().fechaLimite();
                            if(fechas != null){
                        %>
                        <div class="d-flex justify-content-around">
                            <input id="datepicker1" name="fechaInicio" value="<%=fechas[0]%>" width="276"/>
                            <input id="datepicker2" name="fechaFin" value="<%=fechas[1]%>" width="276" />
                        </div>
                        <%} else {%>
                        <div class="d-flex justify-content-around">
                            <input id="datepicker1" name="fechaInicio" width="276"/>
                            <input id="datepicker2" name="fechaFin" width="276" />
                        </div>
                        <%}%>
                        
                        <br><br>

                        <div class="d-flex justify-content-around" >
                            <h1>Fijar fecha inicio</h1>
                            <h1>Fijar fecha fin</h1>
                        </div>
                        
                        <br><br>

                        <div class="d-flex justify-content-around" >
                            <input type="submit" value="Fijar fecha limite" name="accion" class="btn btn-lg btn-dark">
                        </div>
                        
                    </form>
                </div>
                        
            </div>
            <!-- /.content-wrapper -->
        </div>
        <!-- /#wrapper -->
        <script>
            $('#datepicker1').datepicker({
                locale: 'es-es',
                uiLibrary: 'bootstrap4',
                format: 'yyyy-mm-dd',
                size: 'large'
            });
            $('#datepicker2').datepicker({
                locale: 'es-es',
                uiLibrary: 'bootstrap4',
                format: 'yyyy-mm-dd',
                size: 'large'
            });
        </script>
    </body>

</html>

