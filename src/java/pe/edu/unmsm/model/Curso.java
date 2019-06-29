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
public class Curso {
    private String nombreCurso;
    private String eap;
    private String ciclo;

    public Curso() {
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getEap() {
        return eap;
    }

    public void setEap(String eap) {
        this.eap = eap;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
    
}
