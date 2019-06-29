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
public class Administrador extends Usuario{
    private String nombreAdm;

    public Administrador() {
    }

    public Administrador(String codigo, String password, int nivelUsuario) {
        super(codigo, password, nivelUsuario);
    }

    public Administrador(String codigo, String password) {
        super(codigo, password);
    }
    
    public Administrador(String nombreAdmin, String codigo, String password, int nivelUsuario) {
        super(codigo, password, nivelUsuario);
        this.nombreAdm = nombreAdmin;
    }

    public String getNombreAdm() {
        return nombreAdm;
    }

    public void setNombreAdm(String nombreAdm) {
        this.nombreAdm = nombreAdm;
    }
}
