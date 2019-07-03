/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import pe.edu.unmsm.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class CursoDAO {
    ConexionBD cn = ConexionBD.getConexion();
    Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    Curso curso = new Curso();

    public CursoDAO() {
    }
    
    
    public int agregar(int idDocente, int restriccion, int[] escuelas, int[] cursos){
        if(restriccion != 0){
           return restriccion;
        }
        
        String sql="insert into cursoescuelaelegidos (" 
                    + "Docente_idDocente"
                    + ", PeriodoAcademico_idPeriodoAcademico"
                    + ", FiltroCursoPorEscuela_idFiltroCursoPorEscuela) " 
                    + " values(?, ?, ?)";
        con=cn.getConnection();
        
        try {
            
            for(int i=0; i<4; i++){

                int idFiltro = filtrarCursoPorEscuela(escuelas[i], cursos[i]);
                /* OBS:
                   Orden de ejecución:
                    El parámetro idFiltro debe estar antes de que se ejecute
                    el prepareStatement(sql.
                */ 
                ps=con.prepareStatement(sql);

                ps.setInt(1, idDocente);
                ps.setInt(2, 1);
                ps.setInt(3, idFiltro);
                ps.executeUpdate();
            }
           
            return 0;
        } catch (SQLException e) {
            return 1;
        }
        
    }
    
    public int update(int idDocente, int restriccion, int[] escuelas, int[] cursos){
        if(restriccion!=3){
           return restriccion;
        }
        
        String sql="DELETE FROM `cursoescuelaelegidos` WHERE Docente_idDocente = ?;";
        con=cn.getConnection();
        
        try {
                ps=con.prepareStatement(sql);
                ps.setInt(1, idDocente);
                ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error");
        }
        return 1;
    }
    
    public static void main(String[] args) {
        CursoDAO a = new CursoDAO();
        int escuelas[] = {1,1,1,1};
        int cursos[] = {1,2,3,4};
        a.update(1, 0, escuelas, cursos);
    }
    
    
    public int filtrarCursoPorEscuela(int idEscuela, int idCurso){
        int idFiltroCursoPorEscuela = 1;
        String sql="SELECT idFiltroCursoPorEscuela FROM filtrocursoporescuela" 
                + " WHERE Escuela_idEscuela = ? AND Curso_idCurso = ?";

        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idEscuela);
            ps.setInt(2, idCurso);
            rs=ps.executeQuery();
            
            rs.next();
            
            idFiltroCursoPorEscuela = rs.getInt("idFiltroCursoPorEscuela");
            return idFiltroCursoPorEscuela;
           
        } catch (SQLException e) {
            return idFiltroCursoPorEscuela;
        }
        
    }
    
    
    public List listarCursosPorEscuela(int idEscuela) {
        ArrayList<Curso>list=new ArrayList<>();
        String sql1="SELECT * FROM escuela_has_curso INNER JOIN curso ON Curso_idCurso = idCurso WHERE Escuela_idEscuela = ?";
        //String sql2 = "select * from escuela where idEscuela = ?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql1);
            ps.setInt(1, idEscuela);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Curso cur=new Curso();
                cur.setNombreCurso(rs.getString("nombreCurso"));
              
                list.add(cur);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    
    public String pintarTodosLosSelect(int restriccion, int idDocente){
        
        String pintarSelects = "";
        
        if(restriccion == 0 || restriccion == 3){
            for(int i=1; i<=4; i++){
                pintarSelects += ""
                    + "<div id='divSelectEscuela" + i + "' class='col-12 col-sm-6'>" 
                        + pintarSelectEscuela("idSelectEscuela" + i, restriccion) 
                    + "</div>"

                    + "<div id='divSelectCurso" + i + "' class='col-12 col-sm-6'>"

                    + "</div>";
            }
            
        }else{
            String sql="SELECT idEscuela, nombreEscuela, idCurso, nombreCurso "
                    + " FROM ((cursoescuelaelegidos LEFT JOIN filtrocursoporescuela "
                    + " ON idFiltroCursoPorEscuela = FiltroCursoPorEscuela_idFiltroCursoPorEscuela)" 
                    + " LEFT JOIN curso ON Curso_idCurso = idCurso) "
                    + " LEFT JOIN escuela ON Escuela_idEscuela = idEscuela"
                    + " WHERE Docente_idDocente = ?";
        
            try {
                con=cn.getConnection();
                ps=con.prepareStatement(sql);
                ps.setInt(1, idDocente);
                rs=ps.executeQuery();
                
                int cont = 0;
                while(rs.next()){
                    cont++;
                    pintarSelects += "" 
                    
                    + "<div id='div1SelectEscuela" + cont + "' class='col-12 col-sm-6'>" 
                        + "<select class='horario-row7-selectBloqueado' id='div1SelectEscuela" + cont +"' name='divSelectEscuela" + cont + "' disabled >" 
                            + "<option value='" + rs.getInt("idEscuela") + "' selected>" + rs.getString("nombreEscuela") + "</option>" 
                        + "</select>"  
                    + "</div>"
                
                    + "<div id='div1SelectCurso" + cont + "' class='col-12 col-sm-6'>"
                        + "<select class='horario-row7-selectBloqueado' id='div1SelectEscuela" + cont + "' name='divSelectCurso" + cont + "' disabled >" 
                            + "<option value='" + rs.getInt("idCurso") + "' selected>" + rs.getString("nombreCurso") + "</option>" 
                        + "</select>"
                    + "</div>";
                    
                    
                }
                
                return pintarSelects;


            } catch (SQLException e) {
                pintarSelects = "No pasa";
            }
        }
        
        return pintarSelects;

    }
        
    public String pintarSelectEscuela(String idSelectEscuela, int restriccion){
        
        String pintarSelect = "";
        
        if(restriccion == 0){
            pintarSelect = ""
                
                    + "<select required id='" + idSelectEscuela + "' name='" + idSelectEscuela + "' >" 
                        + "<option value='0' selected='selected' hidden> Elija una Escuela</option>"
                        + pintarOptionEscuela() 
                    + "</select>" 
               
                ;
        }else if(restriccion == 3){
            pintarSelect = ""
                
                    + "<select required id='" + idSelectEscuela + "' name='" + idSelectEscuela + "' >" 
                        + "<option value='0' selected='selected' hidden> Elija una Escuela</option>"
                        + pintarOptionEscuela() 
                    + "</select>" 
               
                ;
        }
        

        return pintarSelect;
    }

    public String pintarOptionEscuela(){
        
        String pintarOptions = "";
        
        String sql1="SELECT * FROM escuela";
        //String sql2 = "select * from escuela where idEscuela = ?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql1);
            rs=ps.executeQuery();
            
           
            while(rs.next()){
                 pintarOptions += "<option value='" + rs.getString("idEscuela") + "' >"
                            + rs.getString("nombreEscuela") 
                            + "</option>"; 
            }
            return pintarOptions;
            
        } catch (SQLException e) {
        }
        
        return pintarOptions;
    }
    
    
    public String pintarSelectCurso(int idEscuela, String idSelectCurso){
     
        String pintarSelect = ""
                
                    + "<select required id='" + idSelectCurso + "' name='" + idSelectCurso + "' >" 
                        + "<option value='0' selected='selected' hidden> Elija un curso</option>"
                        + pintarOptionCurso(idEscuela) 
                    + "</select>" 
               
                ;

        return pintarSelect;
    }
    
    public String pintarOptionCurso(int idEscuela){
        
        String pintarOptions = "";
        
        String sql="SELECT idCurso, nombreCurso FROM filtrocursoporescuela LEFT JOIN curso "
                + "ON Curso_idCurso = idCurso WHERE Escuela_idEscuela = ?";
 
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, idEscuela);
            rs=ps.executeQuery();
            
           
            while(rs.next()){
                 pintarOptions += "<option value='" + rs.getString("idCurso") + "'>"
                            + rs.getString("nombreCurso") 
                            + "</option>"; 
            }
            return pintarOptions;
            
        } catch (SQLException e) {
        }
        
        return pintarOptions;
    }
    
    
}
