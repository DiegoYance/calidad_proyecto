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
public class Categoria {
    private int idCategoria;
    private String nombre;
    private int horasMin;
    private int horasMax;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombre, int horasMin, int horasMax) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.horasMin = horasMin;
        this.horasMax = horasMax;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasMin() {
        return horasMin;
    }

    public void setHorasMin(int horasMin) {
        this.horasMin = horasMin;
    }

    public int getHorasMax() {
        return horasMax;
    }

    public void setHorasMax(int horasMax) {
        this.horasMax = horasMax;
    }
    
    
}
