/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.reporte;

/**
 *
 * @author Administrador
 */
public class Reporte {
    private int docente_id;
    private String docente_nombres;

    public Reporte() {
    }

    public Reporte(int docente_id, String docente_nombres) {
        this.docente_id = docente_id;
        this.docente_nombres = docente_nombres;
    }

    public int getDocente_id() {
        return docente_id;
    }

    public void setDocente_id(int docente_id) {
        this.docente_id = docente_id;
    }

    public String getDocente_nombres() {
        return docente_nombres;
    }

    public void setDocente_nombres(String docente_nombres) {
        this.docente_nombres = docente_nombres;
    }
    
    
}
