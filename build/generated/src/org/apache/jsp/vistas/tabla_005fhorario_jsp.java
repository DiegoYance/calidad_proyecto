package org.apache.jsp.vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import pe.edu.unmsm.controller.Controlador;
import pe.edu.unmsm.modelDAO.CursoDAO;
import pe.edu.unmsm.modelDAO.DisponibilidadDAO;
import pe.edu.unmsm.model.Docente;
import pe.edu.unmsm.modelDAO.DocenteDAO;
import pe.edu.unmsm.modelDAO.PermisosDAO;

public final class tabla_005fhorario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(8);
    _jspx_dependants.add("/vistas/../Logica/TablaHorarioLogica.jsp");
    _jspx_dependants.add("/vistas/../tpl/libraries_import.jsp");
    _jspx_dependants.add("/vistas/modales/enviarSolicitud.jsp");
    _jspx_dependants.add("/vistas/modales/confirmacion.jsp");
    _jspx_dependants.add("/vistas/modales/validarHoras.jsp");
    _jspx_dependants.add("/vistas/modales/validarCursos.jsp");
    _jspx_dependants.add("/vistas/modales/validarCursosRepetidos.jsp");
    _jspx_dependants.add("/vistas/modales/validarMinMaxCeldas.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

        
       
        HttpSession sesion = request.getSession();
       
            int idDocente = 0;
            int restriccion = -1;
            String imprimirEditar = "";
            String botonDesabilitado = "";
            int horasMin = 10, horasMax = 40;
            
            String celdasRecibidas = request.getParameter("celdasEnviadas");
            String motivo = request.getParameter("motivo");

            int selectEscuela1=0, selectEscuela2=0, selectEscuela3=0, selectEscuela4=0;
            int selectCurso1=0, selectCurso2=0, selectCurso3=0, selectCurso4=0;

            DocenteDAO docDAO = new DocenteDAO();
            Docente docente = new Docente();
            DisponibilidadDAO disponiblidadDAO = new DisponibilidadDAO();
            CursoDAO cursoDAO = new CursoDAO();

            if(sesion.getAttribute("idDocente")!=null){
                
                idDocente = Integer.parseInt(sesion.getAttribute("idDocente").toString());
                
                docente = docDAO.buscar(idDocente);
  
                horasMin = docente.getHorasMin();
                horasMax = docente.getHorasMax();
                
                restriccion = docente.getRestriccion();
                
                out.println("-->" + cursoDAO.filtrarCursoPorEscuela(2, 9));
     
                if(restriccion == 0){        
                    
                    
                    imprimirEditar = "d-none";
                    botonDesabilitado = "class='horario-row8-btnEnviar'";
                            
                    if(celdasRecibidas != null && !"".equals(celdasRecibidas)
                            && request.getParameter("idSelectCurso1") != null 
                            && request.getParameter("idSelectCurso2") != null
                            && request.getParameter("idSelectCurso3") != null 
                            && request.getParameter("idSelectCurso4") != null 
                            && request.getParameter("idSelectEscuela1") != null 
                            && request.getParameter("idSelectEscuela2") != null 
                            && request.getParameter("idSelectEscuela3") != null 
                            && request.getParameter("idSelectEscuela4") != null
                            
                            ){
                        
                        // CELDAS ENVIADAS
                        // Le quitamos la última coma
                        celdasRecibidas = celdasRecibidas.substring(0, celdasRecibidas.length()-1);
                    
                        disponiblidadDAO.agregar(idDocente, celdasRecibidas, restriccion);
                        
                        // CURSOS DEL CICLO ANTERIOR/ACTUAL ENVIADOS
                        
                        selectEscuela1 = Integer.parseInt(request.getParameter("idSelectEscuela1"));
                        selectEscuela2 = Integer.parseInt(request.getParameter("idSelectEscuela2"));
                        selectEscuela3 = Integer.parseInt(request.getParameter("idSelectEscuela3"));
                        selectEscuela4 = Integer.parseInt(request.getParameter("idSelectEscuela4"));
                        
                        selectCurso1 = Integer.parseInt(request.getParameter("idSelectCurso1"));
                        selectCurso2 = Integer.parseInt(request.getParameter("idSelectCurso2"));
                        selectCurso3 = Integer.parseInt(request.getParameter("idSelectCurso3"));
                        selectCurso4 = Integer.parseInt(request.getParameter("idSelectCurso4"));
                        
                        
                        out.println("<br>escuelas:<br>");
                        out.println(request.getParameter("idSelectEscuela1") + "," + request.getParameter("idSelectEscuela2") 
                                + "," + request.getParameter("idSelectEscuela3") + "," + request.getParameter("idSelectEscuela4"));
                        
                        out.println("<br>cursos<br>");
                        out.println(request.getParameter("idSelectCurso1") + "," + request.getParameter("idSelectCurso2") 
                                + "," + request.getParameter("idSelectCurso3") + "," + request.getParameter("idSelectCurso4"));
                        
                        int[] escuelas = {selectEscuela1, selectEscuela2, selectEscuela3, selectEscuela4};
                        int[] cursos = {selectCurso1, selectCurso2, selectCurso3, selectCurso4};
                        
                        for(int i=0; i<escuelas.length; i++){
                            out.println("<br>escuelas [" + i + "]: " + escuelas[i]);
                            out.println("<br>cursos [" + i + "]: " + cursos[i]);
                            out.println("-->"+ cursoDAO.filtrarCursoPorEscuela(escuelas[i], cursos[i]));
                        }
                        
                        
                        int result = cursoDAO.agregar(idDocente, restriccion, escuelas, cursos);
                        
                        out.println("<br>agregar->" + result);
                        
                        docDAO.updateRestriccion(idDocente, 1);
                        
                        botonDesabilitado = "disabled class='horario-row8-btnEnviarBloqueado'";
                        imprimirEditar = "";
                    }
        
                }else if(restriccion < 2){
                    /**************************************/
                    // Enviar Solicitud:
                    if(motivo != null){
                        PermisosDAO permisosDAO = new PermisosDAO();
                        permisosDAO.enviarSolicitud(idDocente, motivo);
                        docDAO.updateRestriccion(idDocente, 2);
                    }
            
                    /**************************************/
                }else{
                    imprimirEditar = "";
                    botonDesabilitado = "disabled class='horario-row8-btnEnviarBloqueado'";

                }

              
            }else{
                response.sendRedirect("auth/login.jsp");
            } 


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <title>Disponibilidad</title>\r\n");
      out.write("        ");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("<link href=\"css/bootstrap4/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<link href=\"css/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("<script src=\"js/bootstrap4/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/jquery.js\" type=\"text/javascript\"></script>\n");
      out.write("\r\n");
      out.write("        <link href=\"css/estilos_tabla_horario.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Bree+Serif|Lato:400,700&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!--\r\n");
      out.write("        <script src=\"js/bootstrap4/bootstrap.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        -->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        ");
            out.println("<br>id-->" + idDocente);
            out.println("<br>Restricción-->" + restriccion);
            String celdasBD = disponiblidadDAO.concatenarCeldasDeBD(idDocente);
            out.println("<br>celadBD-->" + celdasBD);

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row horario-row-1\">\r\n");
      out.write("                <div class=\"col-12 horario-row1-col1\">\r\n");
      out.write("                    Disponibilidad Docente\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"col-12 col-sm-8 horario-row1-col2\">\r\n");
      out.write("                    Departamento Académico de la Facultad de Ingeniería de Sistemas e Informática\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-12 col-sm-4 horario-row1-col2 horario-cerrarSesion\">\r\n");
      out.write("                    ");
if (Controlador.getTipo().equals("administrador")) {
      out.write("\r\n");
      out.write("                    <a href='javascript:history.back(-1);'><h5>Regresar </h5></a>\r\n");
      out.write("                    ");
} else {
      out.write("\r\n");
      out.write("                    <a href='Controlador?accion=cerrar'><h5>Cerrar Session </h5></a>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row horario-row-2\">\r\n");
      out.write("                <table class=\"tabla-datos-docente table\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">Código</th>\r\n");
      out.write("                            <th scope=\"col\">Apellido Paterno</th>\r\n");
      out.write("                            <th scope=\"col\">Apellido Materno</th>\r\n");
      out.write("                            <th scope=\"col\">Nombres</th>\r\n");
      out.write("                            <th scope=\"col\">Categoría</th>\r\n");
      out.write("                            <th scope=\"col\">Horas</th>\r\n");
      out.write("                        </tr>\t\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print( docente.getCodigo());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( docente.getApePaterno());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( docente.getApeMaterno());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( docente.getNombres());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( docente.getNombreCategoria());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( docente.getHorasMin());
      out.write("</td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <form action=\"Controlador\" method=\"GET\">\r\n");
      out.write("                <div class=\"row align-items-center horario-row-3\">\r\n");
      out.write("                    <div class=\"col col-sm-8\">\r\n");
      out.write("                        DISPONIBILIDAD SEMANAL\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col col-sm-4 horario-row3-icons ");
      out.print(imprimirEditar);
      out.write("\" style=\"text-align:right\">\r\n");
      out.write("\r\n");
      out.write("                        <button><i class=\"fas fa-print\">\r\n");
      out.write("                            </i> Imprimir\r\n");
      out.write("                        </button>&nbsp;&emsp;\r\n");
      out.write("\r\n");
      out.write("                        <button type=\"button\" data-toggle=\"modal\" data-target=\"#modal_enviar_solicitud\" data-whatever=\"@mdo\">\r\n");
      out.write("                            <i class=\"fas fa-edit\"></i> Editar\r\n");
      out.write("                        </button>\r\n");
      out.write("                        <input type=\"hidden\" name=\"idDocenteSolicitud\" value=\"");
      out.print(idDocente);
      out.write("\">\r\n");
      out.write("                        ");
      out.write("<div class=\"modal fade\" id=\"modal_enviar_solicitud\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("      <div class=\"modal-content\" style=\"color: #212428\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Enviar Solicitud al Administrador para editar Disponibilidad</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("          <form action=\"Controlador\">\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("        \n");
      out.write("          <div class=\"form-group\">\n");
      out.write("            <label for=\"message-text\" class=\"col-form-label\">Motivo de solicitud para la edición:</label>\n");
      out.write("            <textarea name=\"motivo\" class=\"form-control\" id=\"message-text\" style=\"height: 140px;\"></textarea>\n");
      out.write("          </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\"> \n");
      out.write("          \n");
      out.write("        <button type=\"submit\" class=\"btn btn-secondary\" name=\"accion\" value=\"celdas\">Enviar</button>\n");
      out.write("        <button type=\"button\" class=\"btn btn btn-primary\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("      </div>\n");
      out.write("      </form>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row horario-row-4\">\r\n");
      out.write("                <table id=\"idTabla\" class=\"tabla-horario table\"> <!-- color de filas impares: table-striped -->\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">Hora</th>\r\n");
      out.write("                            <th scope=\"col\">Lunes</th>\r\n");
      out.write("                            <th scope=\"col\">Martes</th>\r\n");
      out.write("                            <th scope=\"col\">Miércoles</th>\r\n");
      out.write("                            <th scope=\"col\">Jueves</th>\r\n");
      out.write("                            <th scope=\"col\">Viernes</th>\r\n");
      out.write("                            <th scope=\"col\">Sábado</th>\r\n");
      out.write("                            <th scope=\"col\">Domingo</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("\r\n");
      out.write("                    <tbody class=\"table-bordered\">\r\n");
      out.write("                        ");
      out.print( disponiblidadDAO.mostrarTablaDisponibilidad(
                                8, 21, 1, 7, celdasBD, docente.getRestriccion()));
      out.write("\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row horario-row-5\">\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    CURSOS DE SU PREFERENCIA\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"row horario-row-6\">\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    Escuela\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col\">\r\n");
      out.write("                    Curso\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <form name=\"form_celdas\" action=\"Controlador\"> \r\n");
      out.write("\r\n");
      out.write("                <div class=\"row horario-row-7\">\t\r\n");
      out.write("                    ");
      out.print( cursoDAO.pintarTodosLosSelect(docente.getRestriccion(),
                         idDocente));
      out.write("\t\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row justify-content-end horario-row-8\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <input type=\"hidden\" name=\"celdasEnviadas\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Button trigger modal -->\r\n");
      out.write("                    <button id=\"btnEnviar\" type=\"button\" ");
      out.print(botonDesabilitado);
      out.write(" >\r\n");
      out.write("                        Enviar\r\n");
      out.write("                    </button>\r\n");
      out.write("\r\n");
      out.write("                    ");
      out.write(" <!-- Modal -->\r\n");
      out.write("<div id=\"modal_btnEnviar\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\">Guardar Horario</h5>\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                Está seguro que quiere guardar su disponibilidad?<br>\r\n");
      out.write("                Al aceptar ya no podrá realizar cambios.\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <button id=\"btnSI\" type=\"submit\" class=\"btn btn-secondary\" name=\"accion\" value=\"celdas\">Sí</button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">No</button>\r\n");
      out.write("                            \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("     </div>\r\n");
      out.write("</div>\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("                    ");
      out.write(" <!-- Modal -->\n");
      out.write("<div id=\"modal_validarHoras\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\">Cantidad de Horas Mínimas Inválido</h5>\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                Llene la cantidad mínima de horas requeridas por favor\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("    \n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Aceptar</button>\n");
      out.write("                            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("                    ");
      out.write(" <!-- Modal -->\n");
      out.write("<div id=\"modal_validarCursos\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\">Seleccione todos los cursos</h5>\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                Seleccione todas las escuelas y cursos por favor.\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("    \n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Aceptar</button>\n");
      out.write("                            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("                    ");
      out.write(" <!-- Modal -->\n");
      out.write("<div id=\"modal_validarCursosRepetidos\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\">Cursos Repetidos</h5>\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                No puede seleccionar cursos repetidos de una misma Escuela Académica Profesional.<br>\n");
      out.write("                Por favor elija un curso diferente.\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("    \n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Aceptar</button>\n");
      out.write("                            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("                    ");
      out.write(" <!-- Modal -->\n");
      out.write("<div id=\"modal_validarMinMaxCeldas\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">\n");
      out.write("    <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <div class=\"modal-header\">\n");
      out.write("                <h5 class=\"modal-title\" id=\"exampleModalCenterTitle\">Cantidad de Horas Permitidas</h5>\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-body\">\n");
      out.write("                La cantidad de horas mínimas o máximas de su Disponibilidad no\n");
      out.write("concuerda con su categoría..\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal-footer\">\n");
      out.write("    \n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">Aceptar</button>\n");
      out.write("                            \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");
      out.write("</div>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>  \r\n");
      out.write("\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("         \r\n");
      out.write("        ");

            String message = "";
            switch(restriccion){
                case 2:
                    message = "Su solicitud de permiso esta en proceso.";
                    break;
                case 3:
                    message = "Su solicitud de permiso fue aceptado.";
                    break;
                case 4:
                    message = "Su solicitud de permiso fue negado.";
                break;
            }
        
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("        <!-- Modal - Restricciones -->\r\n");
      out.write("        <div class=\"modal\" tabindex=\"-1\" role=\"dialog\" id=\"mostrarmodal\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <h5 class=\"modal-title\">SOLICITUD DE PERMISO DE MODIFICACIÓN</h5>\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                            <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body text-uppercase\" style=\"text-align:center;\">\r\n");
      out.write("                        <p>");
      out.print(message);
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">OK</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/tabla_horario.js?\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            /**********MOSTRAR MODAL DE ACUERDO A LAS RESCTRICCIONES*****/\r\n");
      out.write("            $(document).ready(function ()\r\n");
      out.write("            {\r\n");
      out.write("                $(\"#mostrarmodal\").modal(\"show\");\r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("            /************* VALIDAR CAMPOS VACÍOS ***************************/\r\n");
      out.write("\r\n");
      out.write("            $('#btnEnviar').click(function () {\r\n");
      out.write("\r\n");
      out.write("                //alert(\"Número de Celdas: \" + ObtenerCantidadCeldasSeleccionadas());\r\n");
      out.write("\r\n");
      out.write("                var celdasSelectValidados = true;\r\n");
      out.write("\r\n");
      out.write("                var minCeldas = ");
      out.print(horasMin);
      out.write(";\r\n");
      out.write("                var maxCeldas = ");
      out.print(horasMax);
      out.write(";\r\n");
      out.write("\r\n");
      out.write("                // VALIDAR CELDAS VACÍAS\r\n");
      out.write("                if (ObtenerCeldasSeleccionadas() === \"\") {\r\n");
      out.write("                    celdasSelectValidados = false;\r\n");
      out.write("                    //alert('Llene la cantidad mínima de horas requeridas por favor.');\r\n");
      out.write("                    $('#modal_validarHoras').modal();\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("                // VALIDAR MÍNIMO Y MÁXIMO NÚMERO DE CELDAS\r\n");
      out.write("                else if (ObtenerCantidadCeldasSeleccionadas() < minCeldas || ObtenerCantidadCeldasSeleccionadas() > maxCeldas) {\r\n");
      out.write("                    celdasSelectValidados = false;\r\n");
      out.write("                    $('#modal_validarMinMaxCeldas').modal();\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                // VALIDAR SELECT VACÍOS\r\n");
      out.write("                else if ($('#idSelectEscuela1').val() === '0'\r\n");
      out.write("                        || $('#idSelectCurso1').val() === '0'\r\n");
      out.write("                        || $('#idSelectEscuela2').val() === '0'\r\n");
      out.write("                        || $('#idSelectCurso2').val() === '0'\r\n");
      out.write("                        || $('#idSelectEscuela3').val() === '0'\r\n");
      out.write("                        || $('#idSelectCurso3').val() === '0'\r\n");
      out.write("                        || $('#idSelectEscuela4').val() === '0'\r\n");
      out.write("                        | $('#idSelectCurso4').val() === '0') {\r\n");
      out.write("\r\n");
      out.write("                    celdasSelectValidados = false;\r\n");
      out.write("                    //alert('Seleccione todas las escuelas y cursos por favor.');\r\n");
      out.write("                    $('#modal_validarCursos').modal();\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                /*\r\n");
      out.write("                 else if(validarCursosRepetidos){\r\n");
      out.write("                 celdasSelectValidados = false;\r\n");
      out.write("                 $('#modal_validarCursosRepetidos').modal();\r\n");
      out.write("                 }\r\n");
      out.write("                 */\r\n");
      out.write("\r\n");
      out.write("                if (celdasSelectValidados) {\r\n");
      out.write("                    $(\"#modal_btnEnviar\").modal();\r\n");
      out.write("\r\n");
      out.write("                    $('#btnSI').click(function () {\r\n");
      out.write("\r\n");
      out.write("                        var celdasPintadas = ObtenerCeldasSeleccionadas();\r\n");
      out.write("\r\n");
      out.write("                        document.form_celdas.celdasEnviadas.value = celdasPintadas;\r\n");
      out.write("                        document.form_celdas.submit();\r\n");
      out.write("\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            /************* FIN DE VALIDAR CAMPOS VACÍOS ***************************/\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
