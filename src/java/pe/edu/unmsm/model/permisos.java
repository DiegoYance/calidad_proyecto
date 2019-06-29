/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.model;

/**
 *
 * @author Administrador
 */
public class permisos {
    private int idPermisos;
    private String motivo;
    private String aprobado;
    private int idDocente;
    private int idAdministrador;

    public int getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
    
    
    
}
