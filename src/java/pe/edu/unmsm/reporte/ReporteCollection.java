/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.reporte;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ReporteCollection {
    
    private List<Reporte> ReporteList = new ArrayList<>();
    
    public void agregarDocente(Reporte objReporte){
        ReporteList.add(objReporte);
    }
    
    public List<Reporte> getListReporte(){
        return ReporteList;
    }
}
