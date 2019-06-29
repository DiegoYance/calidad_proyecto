
package pe.edu.unmsm.controller;

import pe.edu.unmsm.model.Docente;
import pe.edu.unmsm.modelDAO.DisponibilidadDAO;
import pe.edu.unmsm.modelDAO.DocenteDAO;
import pe.edu.unmsm.modelDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import static pe.edu.unmsm.config.ConfigController.getADMIN_FECHA_LIMITE;
import static pe.edu.unmsm.config.ConfigController.getADMIN_GESTION;
import static pe.edu.unmsm.config.ConfigController.getADMIN_VISUALIZAR_PROFESOR;
import static pe.edu.unmsm.config.ConfigController.getDISP_MOSTRAR_TABLA;
import static pe.edu.unmsm.config.ConfigController.getLOGIN;
import pe.edu.unmsm.modelDAO.PeriodoAcademicoDAO;


public class Controlador extends HttpServlet {
    
    private static String tipo = "#";
    
    Docente docente = new Docente();
    UsuarioDAO userDAO=new UsuarioDAO();
    DocenteDAO docDAO = new DocenteDAO();
    DisponibilidadDAO disponiblidadDAO = new DisponibilidadDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        
        HttpSession sesion = request.getSession();
        
        String accion=request.getParameter("accion");
        
        switch(accion){
            case "login":
               acceso = getLOGIN();
               break;
            case "gestion":
               acceso = getADMIN_GESTION();
               break;
            case "fecha_limite":
                acceso = getADMIN_FECHA_LIMITE();
                break;
            case "visualizar_profesor":
                acceso = getADMIN_VISUALIZAR_PROFESOR();
                break;
            case "mostrarTabla":
                acceso = getDISP_MOSTRAR_TABLA();
                break;
            case "celdas":
                acceso=getDISP_MOSTRAR_TABLA();
                break;
            case "cerrar":
                sesion.invalidate();
                acceso = getLOGIN();
                break;
            default:
                sesion.invalidate();
                acceso = getLOGIN();
                break;
                
        }
       
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso="";
        
        HttpSession session = request.getSession();
        
        String accion =request.getParameter("accion");
        
        if(accion.equals("Ingresar")){
            String user=request.getParameter("usuario");
            String pass=DigestUtils.sha1Hex(request.getParameter("password"));
            int tipoUsuario = userDAO.obtenerTipoUsuario(user, pass);
            
            switch (tipoUsuario) {
                case 1:
                    int idAdministrador = userDAO.obtenerIdAdminnistradorPorCuenta(user, pass);
                    session.setAttribute("idAdministrador", idAdministrador);
                    tipo = "administrador";
                    acceso = getADMIN_VISUALIZAR_PROFESOR();
                    break;
                case 2:
                    int idDocente = userDAO.obtenerIdDocentePorCuenta(user, pass);
                    session.setAttribute("idDocente", idDocente);
                    tipo = "docente";
                    acceso = getDISP_MOSTRAR_TABLA();
                    break;
                default:      
                    acceso = getLOGIN();
                    break;
            }
        } else if(accion.equals("Ver")){
            String idDocente=request.getParameter("id");
            session.setAttribute("idDocente", idDocente);
            acceso = getDISP_MOSTRAR_TABLA();
        } else if(accion.equalsIgnoreCase("aceptar_edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            docDAO.updateRestriccion(id, 3);
            acceso = getADMIN_GESTION();
        }else if(accion.equalsIgnoreCase("negar_edit")){
            int id = Integer.parseInt(request.getParameter("id"));
            docDAO.updateRestriccion(id, 4);
            acceso = getADMIN_GESTION();
        } else if(accion.equalsIgnoreCase("Fijar fecha limite")){
            String fecha_inicio = request.getParameter("fechaInicio");
            String fecha_fin = request.getParameter("fechaFin");
            PeriodoAcademicoDAO facultad = new PeriodoAcademicoDAO();
            facultad.ingresarFechaLimite(fecha_inicio, fecha_fin); 
            acceso = getADMIN_FECHA_LIMITE();
        } else if(accion.equalsIgnoreCase("Enviar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String motivo=request.getParameter("motivo");
            acceso=getDISP_MOSTRAR_TABLA();
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public static String getTipo(){
        return tipo;
    }
    
    public static void main(String[] args) {
        String textoSinEncriptar="avendano"; 
String textoEncriptadoConSHA=DigestUtils.sha1Hex(textoSinEncriptar); 
System.out.println("Texto Encriptado con SHA : "+textoEncriptadoConSHA);
    }
}
