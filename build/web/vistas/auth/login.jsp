<%-- 
    Document   : login
    Created on : 19/05/2019, 09:47:54 PM
    Author     : Administrador
--%>


<%
    /*
    if(request.getParameter("accion") != null){
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("cerrar")){
            HttpSession sesion = request.getSession();
            sesion.invalidate();          
        }        
    }
*/
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>INICIAR SESIÓN</title>
        
        <%@ include file="../../tpl/libraries_import.jsp" %>  
        
        <!-- Fonts -->
        <link href="./css/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        
        <!-- Styles -->
        <link href="css/bootstrap4/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap4/bootstrap.js"></script>
        
        <style>

            html,body{
                background-image: url('images/index.png');
                background-size: cover;
                background-repeat: round;
                height: 100%;
            }

            .header{
                color: white;
                font-size: 50px;
            }
            
            .footer{
                color: white;
                text-align: center;
                font-size: 18px;
            }
            
            hr {
                height: 1px;
                background-color: white;
                margin-bottom:  0px;
                margin-top:  50px;
            }
            
            .card{
                height: 340px;
                margin-top: auto;
                margin-bottom: auto;
                width: 450px;
                background-color: rgba(0,0,0,0.5) !important;
            }

            .social_icon span:hover{
                color: white;
                cursor: pointer;
            }

            .card-header h3{
                color: white;

            }

            .card-footer{
                color: white;
                text-align: center;
                font-size: 12px;
            }

            .input-group-prepend span{
                width: 50px;
                background-color: #FFC312;
                color: black;
                border:0 !important;
            }

            input:focus{
                outline: 0 0 0 0  !important;
                box-shadow: 0 0 0 0 !important;

            }

            .remember{
                color: white;
            }

            .remember input
            {
                width: 20px;
                height: 20px;
                margin-left: 15px;
                margin-right: 5px;
            }

            .login_btn{
                color: black;
                background-color: #FFC312;
                width: 100px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="d-flex flex-column h-100">
                <div class="p-4 header">APPDISP</div>
                <div class="p-4">
                    <div class="d-flex justify-content-center h-100">
                        <div class="card">
                            <div class="card-header">
                                <h3>INICIAR SESIÓN</h3>

                            </div>
                            <div class="card-body">
                                <form method="POST" action="Controlador">

                                    <div class="input-group form-group">

                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><em class="fas fa-user"></em></span>
                                        </div>
                                        <input required type="text" class="form-control" placeholder="código" name="usuario">

                                    </div>
                                    <div class="input-group form-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><em class="fas fa-key"></em></span>
                                        </div>
                                        <input required type="password" class="form-control" placeholder="clave" name="password">
                                    </div>
                                    <div class="row align-items-center remember">
                                        <input type="checkbox">Recordar mis datos
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" name="accion" value="Ingresar" class="btn float-right login_btn">
                                    </div>
                                </form>
                            </div>
                            <div class="card-footer">
                                <p>Cualquier consulta por favor comunicarse con el Departamento Académico
                                    al 619-7000 anexo 3605 en horario de oficina</p>
                            </div>    
                        </div>
                    </div>
                </div>
                <div class="p-4 footer">
                    <hr>  
                    <p>Departamento Académico de la Facultad de Ingeniería de Sistemas e Informática</p>
                </div>
                
            </div>
        </div>
    </body>
</html>
