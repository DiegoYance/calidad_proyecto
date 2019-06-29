/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import pe.edu.unmsm.model.Disponibilidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class DisponibilidadDAO {
    
    ConexionBD cn = ConexionBD.getConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Disponibilidad disponibilidad = new Disponibilidad();
    
    // retorna la disponibilidad o restricción
    public int agregar(int idDocente, String celdasRecibidas, int restriccion) {
        
        if(restriccion != 0){
           return restriccion;
        } 
       
        String sql="insert into disponibilidad(Docente_idDocente,lunes, martes, miercoles, jueves " 
               + ", viernes, sabado, domingo) values(?,?,?,?,?,?,?,?)";
       
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            
            String[] celdasArray = celdasRecibidas.split(",");
            String[] celda;
            
            String lunes="", martes="", miercoles="", jueves=""
                    , viernes="", sabado="", domingo="";
            
            int i = 0;
            while(i < celdasArray.length){
                celda = celdasArray[i].split("_");
                i++;
                switch(celda[1]){
                    case "1":
                        lunes += celda[0] + ",";
                        break;
                    case "2":
                        martes += celda[0] + ",";
                        break;
                    case "3":
                        miercoles += celda[0] + ",";
                        break;
                    case "4":
                        jueves += celda[0] + ",";
                        break;
                    case "5":
                        viernes += celda[0] + ",";
                        break;
                    case "6":
                        sabado += celda[0] + ",";
                        break;
                    case "7":
                        domingo += celda[0] + ",";
                        break; 
                }
                
            }
            
            lunes = quitarUltimoCaracter(lunes);
            martes = quitarUltimoCaracter(martes);
            miercoles = quitarUltimoCaracter(miercoles);
            jueves = quitarUltimoCaracter(jueves);
            viernes = quitarUltimoCaracter(viernes);
            sabado = quitarUltimoCaracter(sabado);
            domingo = quitarUltimoCaracter(domingo);
            
            
            ps.setInt(1, idDocente);
            ps.setString(2, lunes);
            ps.setString(3, martes);
            ps.setString(4, miercoles);
            ps.setString(5, jueves);
            ps.setString(6, viernes);
            ps.setString(7, sabado);
            ps.setString(8, domingo);

            ps.executeUpdate();
            
            return 1;
        } catch (SQLException e) {
        }
       return 0;
    }
    
    
    public Disponibilidad buscar(int id) {
        String sql="select * from disponibilidad where Docente_idDocente=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()){  
                disponibilidad.setLunes(rs.getString("lunes"));
                disponibilidad.setMartes(rs.getString("martes"));
                disponibilidad.setMiercoles(rs.getString("miercoles"));
                disponibilidad.setJueves(rs.getString("jueves"));
                disponibilidad.setViernes(rs.getString("viernes"));
                disponibilidad.setSabado(rs.getString("sabado"));
                disponibilidad.setDomingo(rs.getString("domingo"));
                
            }
        } catch (SQLException e) {
        }
        return disponibilidad;
    }
    
    public String quitarUltimoCaracter(String cadena){
        if(cadena != null && !"".equals(cadena)){
            cadena = cadena.substring(0, cadena.length()-1);
            return cadena;
        }else{
            return "No hay horas";
        }
    }
    
    public String mostrarTablaDisponibilidad(int filaIncio, int filaFin, int columnaInicio, int columnaFin, String celdas, int restriccion){
        
        //celdas = celdas.substring(0, celdas.length()-1);
        String tablaDisponibilidad = "";
        String[] ArrayCeldas;
        
        if("".equals(celdas)){
            for(int i=filaIncio; i<=filaFin; i++){
            
                tablaDisponibilidad += "" 
                    + "<tr>"

                        + "<th scope='row'>" + validarHora(i) + validarPeriodo(i) + " a "
                            + validarHora(i+1) + validarPeriodo(i+1)
                        + "</th>"

                        +  columnasTabla(columnaInicio, columnaFin, i)

                    + "</tr>"
                ;

            }
            
        }else{
            ArrayCeldas = celdas.split(",");
            
            for(int i=filaIncio; i<=filaFin; i++){
            
                tablaDisponibilidad += "" 
                    + "<tr>"

                        + "<th scope='row'>" + validarHora(i) + validarPeriodo(i) + " a "
                            + validarHora(i+1) + validarPeriodo(i+1)
                        + "</th>"

                        +  columnasTabla(columnaInicio, columnaFin, i, ArrayCeldas, restriccion)

                    + "</tr>"
                ;

            }
        }
                            
        return tablaDisponibilidad;
                      
    }
    
    public int validarHora(int i){
        if(i>=13){
            i = i-12;
        }
        return i;
    }
    
    public String validarPeriodo(int i){
        if(i>=12){
            return "PM";
        }
        return "AM";
    }
    
    public String columnasTabla(int columnaInicio, int columnaFin, int i){
        
        String columnas = "";
        for(int j=columnaInicio; j<=columnaFin; j++){
            columnas += "<td id='" + i + "_" + j + "' onclick='seleccionarCelda(" + i + "," + j + ")'></td>";
        }
        
        return columnas;
    }
    
    public String columnasTabla(int columnaInicio, int columnaFin, int i, String[] ArrayCeldas, int restriccion){
        
        String columnas = "";
        String clasePintar = "";
        for(int j=columnaInicio; j<=columnaFin; j++){
            
            if(buscarIdCelda(i + "_" + j, ArrayCeldas)){
                if(restriccion !=0 || restriccion !=3){
                    clasePintar = "class='celda_activa_bloqueada'";
                }else{
                    clasePintar = "class='celda_activa'";
                }
            }else{
               if(restriccion !=0 || restriccion !=3){
                   clasePintar = "class='celda_inactiva_bloqueada'";
               } 
            }
            
            columnas += "<td id='" + i + "_" + j + "' " + clasePintar + " onclick='seleccionarCelda(" + i + "," + j + ")'></td>";
            clasePintar = "";
        }
        
        return columnas;
    }
    
    public boolean buscarIdCelda(String idCelda, String[] cadena){
        for (String cadena1 : cadena) {
            if (idCelda.equals(cadena1)) {
                return true;
            }
        }
        return false;
    }
    
    public String concatenarCeldasDeBD(int id){
        String celdasBD = "";
        
        
        String sql="select * from disponibilidad where Docente_idDocente=?";
        try {
            String[] ArrayCeldas = new String[7];
 
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            rs.next();  
            
            ArrayCeldas[0] = rs.getString("lunes");
            ArrayCeldas[1] = rs.getString("martes");
            ArrayCeldas[2] = rs.getString("miercoles");
            ArrayCeldas[3] = rs.getString("jueves");
            ArrayCeldas[4] = rs.getString("viernes");
            ArrayCeldas[5] = rs.getString("sabado");
            ArrayCeldas[6] = rs.getString("domingo");
            
            //celdasBD =   ArrayCeldas[0];
            for (int i=0; i<ArrayCeldas.length; i++) {
                if (!"No hay horas".equals(ArrayCeldas[i])) {
                    String[] ArrayColumnas = ArrayCeldas[i].split(",");
                    
                    for(int j=0; j<ArrayColumnas.length; j++){
                        celdasBD += ArrayColumnas[j] + "_" + (i+1)  + ",";
                    }
                    
                }
            }
            
            celdasBD = quitarUltimoCaracter(celdasBD);
            
            return celdasBD;
           
        } catch (SQLException e) {
            celdasBD = "";
            return celdasBD;
        }
        
    }
    
}
