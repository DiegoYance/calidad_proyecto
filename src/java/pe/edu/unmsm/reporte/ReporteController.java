/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.reporte;


import java.util.List;

/**
 *
 * @author Administrador
 */
public class ReporteController {
    private static ReporteCollection reporteCollection;
    
    public static List<Reporte> cargarProductCollection(){
        llenarCollection();
        return reporteCollection.getListReporte();
    }
    
    private static void llenarCollection(){
        reporteCollection = new ReporteCollection();
        
        reporteCollection.agregarDocente(new Reporte(1, "jhordan"));
        
    }
}
