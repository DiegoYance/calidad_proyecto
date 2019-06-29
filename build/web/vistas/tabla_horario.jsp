<%-- 
    Document   : tabla_horario
    Created on : 18/05/2019, 12:28:12 PM
    Author     : Administrador
--%>

<%@page import="pe.edu.unmsm.controller.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%@ include file="../LogicaPresentacion/TablaHorarioLogica.jsp" %>

<!DOCTYPE html>
<html>
    <head>

        <title>Disponibilidad</title>
        <%@ include file="../tpl/libraries_import.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilos_tabla_horario.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Bree+Serif|Lato:400,700&display=swap" rel="stylesheet"> 

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="./js/jquery.js"></script>
    </head>
    <body>

        <div class="container">

            <div class="row horario-row-1">
                <div class="col-12 horario-row1-col1">
                    Disponibilidad Docente
                </div>

                <div class="col-12 col-sm-8 horario-row1-col2">
                    Departamento Académico de la Facultad de Ingeniería de Sistemas e Informática
                </div>
                <div class="col-12 col-sm-4 horario-row1-col2 horario-cerrarSesion">
                    <%if (Controlador.getTipo().equals("administrador")) {%>
                    <a href='javascript:history.back(-1);'><h5>Regresar </h5></a>
                    <%} else {%>
                    <a href='Controlador?accion=cerrar'><h5>Cerrar Session </h5></a>
                    <%}%>
                </div>
            </div>

            <div class="row horario-row-2">
                <table class="tabla-datos-docente table">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Apellido Paterno</th>
                            <th scope="col">Apellido Materno</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Categoría</th>
                            <th scope="col">Horas</th>
                        </tr>	
                    </thead>
                    <tbody>
                        <tr>
                            <td><%= docente.getCodigo()%></td>
                            <td><%= docente.getApePaterno()%></td>
                            <td><%= docente.getApeMaterno()%></td>
                            <td><%= docente.getNombres()%></td>
                            <td><%= docente.getNombreCategoria()%></td>
                            <td><%= docente.getHorasMin()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <form action="Controlador" method="GET">
                <div class="row align-items-center horario-row-3">
                    <div class="col col-sm-8">
                        DISPONIBILIDAD SEMANAL
                    </div>

                    <div class="col col-sm-4 horario-row3-icons <%=imprimirEditar%>" style="text-align:right">

                        <button><em class="fas fa-print">
                            </em> Imprimir
                        </button>&nbsp;&emsp;

                        <button type="button" data-toggle="modal" data-target="#modal_enviar_solicitud" data-whatever="@mdo">
                            <em class="fas fa-edit"></em> Editar
                        </button>
                        <input type="hidden" name="idDocenteSolicitud" value="<%=idDocente%>">
                        <%@ include file="modales/enviarSolicitud.jsp" %>

                    </div>

                </div>
            </form>


            <div class="row horario-row-4">
                <table id="idTabla" class="tabla-horario table"> <!-- color de filas impares: table-striped -->
                    <thead>
                        <tr>
                            <th scope="col">Hora</th>
                            <th scope="col">Lunes</th>
                            <th scope="col">Martes</th>
                            <th scope="col">Miércoles</th>
                            <th scope="col">Jueves</th>
                            <th scope="col">Viernes</th>
                            <th scope="col">Sábado</th>
                            <th scope="col">Domingo</th>
                        </tr>
                    </thead>

                    <tbody class="table-bordered">
                        <%= disponiblidadDAO.mostrarTablaDisponibilidad(
                                8, 21, 1, 7, celdasBD, docente.getRestriccion())%>
                    </tbody>
                </table>
            </div>

            <div class="row horario-row-5">
                <div class="col">
                    CURSOS DE SU PREFERENCIA
                </div>
            </div>

            <div class="row horario-row-6">
                <div class="col">
                    Escuela
                </div>
                <div class="col">
                    Curso
                </div>
            </div>

            <form name="form_celdas" action="Controlador"> 

                <div class="row horario-row-7">	
                    <%= cursoDAO.pintarTodosLosSelect(docente.getRestriccion(),
                         idDocente)%>	
                </div>

                <div class="row justify-content-end horario-row-8">


                    <input type="hidden" name="celdasEnviadas">

                    <!-- Button trigger modal -->
                    <button id="btnEnviar" type="button" <%=botonDesabilitado%> >
                        Enviar
                    </button>

                    <%@ include file="modales/confirmacion.jsp" %>
                    <%@ include file="modales/validarHoras.jsp" %>
                    <%@ include file="modales/validarCursos.jsp" %>
                    <%@ include file="modales/validarCursosRepetidos.jsp" %>
                    <%@ include file="modales/validarMinMaxCeldas.jsp" %>

                </div>  

            </form>

        </div>
             
                    <%  out.println("res->" + restriccion);
                    System.out.println("men-->" + mensajeRestriccion);
            if(restriccion == 2 || restriccion == 3
                || restriccion == 4) { %>
            <div class="modal" tabindex="-1" role="dialog" id="mostrarmodal">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">SOLICITUD DE PERMISO DE MODIFICACIÓN</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body text-uppercase" style="text-align:center;">
                            <p><%=mensajeRestriccion%></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
                        </div>
                    </div>
                </div>
            </div>        
        <% } %>

        <script src="js/tabla_horario.js?"></script>

        <script>
            /**********MOSTRAR MODAL DE ACUERDO A LAS RESCTRICCIONES*****/
            $(document).ready(function ()
            {
                $("#mostrarmodal").modal("show");
            });
            
            /************* VALIDAR CAMPOS VACÍOS ***************************/

            $('#btnEnviar').click(function () {

                //alert("Número de Celdas: " + ObtenerCantidadCeldasSeleccionadas());

                var celdasSelectValidados = true;

                var minCeldas = <%=horasMin%>;
                var maxCeldas = <%=horasMax%>;

                // VALIDAR CELDAS VACÍAS
                if (ObtenerCeldasSeleccionadas() === "") {
                    celdasSelectValidados = false;
                    //alert('Llene la cantidad mínima de horas requeridas por favor.');
                    $('#modal_validarHoras').modal();

                }
                // VALIDAR MÍNIMO Y MÁXIMO NÚMERO DE CELDAS
                else if (ObtenerCantidadCeldasSeleccionadas() < minCeldas || ObtenerCantidadCeldasSeleccionadas() > maxCeldas) {
                    celdasSelectValidados = false;
                    $('#modal_validarMinMaxCeldas').modal();
                }


                // VALIDAR SELECT VACÍOS
                else if ($('#idSelectEscuela1').val() === '0'
                        || $('#idSelectCurso1').val() === '0'
                        || $('#idSelectEscuela2').val() === '0'
                        || $('#idSelectCurso2').val() === '0'
                        || $('#idSelectEscuela3').val() === '0'
                        || $('#idSelectCurso3').val() === '0'
                        || $('#idSelectEscuela4').val() === '0'
                        | $('#idSelectCurso4').val() === '0') {

                    celdasSelectValidados = false;
                    //alert('Seleccione todas las escuelas y cursos por favor.');
                    $('#modal_validarCursos').modal();
                }

                /*
                 else if(validarCursosRepetidos){
                 celdasSelectValidados = false;
                 $('#modal_validarCursosRepetidos').modal();
                 }
                 */

                if (celdasSelectValidados) {
                    $("#modal_btnEnviar").modal();

                    $('#btnSI').click(function () {

                        var celdasPintadas = ObtenerCeldasSeleccionadas();

                        document.form_celdas.celdasEnviadas.value = celdasPintadas;
                        document.form_celdas.submit();

                    });
                }


            });

            /************* FIN DE VALIDAR CAMPOS VACÍOS ***************************/

        </script>

    </body>
</html>
