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
public class Usuario {
    private String codigo;
    private String password;
    private int nivelUsuario;

    public Usuario() {
        
    }

    public Usuario(String codigo, String password, int nivelUsuario) {
        this.codigo = codigo;
        this.password = password;
        this.nivelUsuario = nivelUsuario;
    }

    public Usuario(String codigo, String password) {
        this.codigo = codigo;
        this.password = password;
    }
    
    public Usuario(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(int nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }
    
    
}
