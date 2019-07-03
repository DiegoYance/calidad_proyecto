<%@page import="pe.edu.unmsm.modelDAO.CursoDAO"%>
<%@page import="pe.edu.unmsm.modelDAO.DisponibilidadDAO"%>
<%@page import="pe.edu.unmsm.model.Docente"%>
<%@page import="pe.edu.unmsm.modelDAO.DocenteDAO"%>
<%@page import="pe.edu.unmsm.modelDAO.PermisosDAO"%>
<%
        
       
        HttpSession sesion = request.getSession();
       
            int idDocente = 0;
            int restriccion = -1;
            String imprimirEditar = "";
            String botonDesabilitado = "";
            int horasMin = 10, horasMax = 40;
            String celdasBD = "";
            String mensajeRestriccion = "";
            
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
                celdasBD = disponiblidadDAO.concatenarCeldasDeBD(idDocente);
                
                docente = docDAO.buscar(idDocente);
  
                horasMin = docente.getHorasMin();
                horasMax = docente.getHorasMax();
                
                String horasMaxString = "" + horasMax;
                
                restriccion = docente.getRestriccion();
     
                if(restriccion == 0 || restriccion == 3){             
                    
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
                        
                        if(restriccion == 0){
                            disponiblidadDAO.agregar(idDocente, celdasRecibidas, restriccion);
                        } else {
                            disponiblidadDAO.update(idDocente, restriccion);
                            disponiblidadDAO.agregar(idDocente, celdasRecibidas, 0);
                        }
                        
                        
                        // Para que actualice de inmediato la variable cedasBD
                        celdasBD = celdasRecibidas;
                        
                        // CURSOS DEL CICLO ANTERIOR/ACTUAL ENVIADOS
                        
                        selectEscuela1 = Integer.parseInt(request.getParameter("idSelectEscuela1"));
                        selectEscuela2 = Integer.parseInt(request.getParameter("idSelectEscuela2"));
                        selectEscuela3 = Integer.parseInt(request.getParameter("idSelectEscuela3"));
                        selectEscuela4 = Integer.parseInt(request.getParameter("idSelectEscuela4"));
                        
                        selectCurso1 = Integer.parseInt(request.getParameter("idSelectCurso1"));
                        selectCurso2 = Integer.parseInt(request.getParameter("idSelectCurso2"));
                        selectCurso3 = Integer.parseInt(request.getParameter("idSelectCurso3"));
                        selectCurso4 = Integer.parseInt(request.getParameter("idSelectCurso4"));
                        
                        int[] escuelas = {selectEscuela1, selectEscuela2, selectEscuela3, selectEscuela4};
                        int[] cursos = {selectCurso1, selectCurso2, selectCurso3, selectCurso4};
                   
                        if(restriccion == 0){
                            cursoDAO.agregar(idDocente, restriccion, escuelas, cursos);
                            //if(result == 0){
                               docDAO.updateRestriccion(idDocente, 1);
                               docente.setRestriccion(1);
                            //}
                        }else if(restriccion == 3){
                           cursoDAO.update(idDocente, restriccion, escuelas, cursos);
                           cursoDAO.agregar(idDocente, 0, escuelas, cursos);
                            docDAO.updateRestriccion(idDocente, 5);
                            docente.setRestriccion(5);
                        }
                        
                        botonDesabilitado = "disabled class='horario-row8-btnEnviarBloqueado'";
                        imprimirEditar = "";

                    }
                    
                    if(restriccion == 3){
                        mensajeRestriccion = "Su solicitud de permiso fue aceptado.";
                    }
        
                }else if(restriccion == 1 || restriccion == 2 || restriccion == 4 || restriccion == 5){
                    imprimirEditar = "";
                    botonDesabilitado = "disabled class='horario-row8-btnEnviarBloqueado'";
                    
                    if(restriccion == 1){
                        // Enviar Solicitud:
                        if(motivo != null){
                            PermisosDAO permisosDAO = new PermisosDAO();
                            permisosDAO.enviarSolicitud(idDocente, motivo);
                            docDAO.updateRestriccion(idDocente, 2);
                        }
                    }else if(restriccion == 2){
                        mensajeRestriccion = "Su solicitud de permiso esta en proceso";
                        // Aún falta implementar
                    }else if(restriccion == 4){
                        mensajeRestriccion = "Su solicitud de permiso fue negado.";
                        // Aún falta implementar
                    }     
                }
                
                
              
            }else{
                sesion.invalidate();
                response.sendRedirect("../vistas/auth/login.jsp");
            } 

%>