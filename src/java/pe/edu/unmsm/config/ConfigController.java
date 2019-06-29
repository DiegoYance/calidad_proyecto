/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.config;

/**
 *
 * @author Administrador
 */
public final class ConfigController {
    private static final String LOGIN ="vistas/auth/login.jsp";
    
    // Disponibilidad Docente
    private static final String DISP_MOSTRAR_TABLA="vistas/tabla_horario.jsp";
    
    // Admin:
    private static final String ADMIN_GESTION="vistas/admin/gestion.jsp";
    private static final String ADMIN_FECHA_LIMITE="vistas/admin/fecha_limite.jsp";
    private static final String ADMIN_VISUALIZAR_PROFESOR="vistas/admin/visualizar_profesor.jsp";

    public static String getLOGIN() {
        return LOGIN;
    }

    public static String getDISP_MOSTRAR_TABLA() {
        return DISP_MOSTRAR_TABLA;
    }

    public static String getADMIN_GESTION() {
        return ADMIN_GESTION;
    }

    public static String getADMIN_FECHA_LIMITE() {
        return ADMIN_FECHA_LIMITE;
    }

    public static String getADMIN_VISUALIZAR_PROFESOR() {
        return ADMIN_VISUALIZAR_PROFESOR;
    }

}
