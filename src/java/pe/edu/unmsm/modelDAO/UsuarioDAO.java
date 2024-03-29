/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO {
    
    ConexionBD cn = ConexionBD.getConexion();   //Se conecta con la bd
    Connection con = cn.getConnection(); //Obtiene la conexion
    PreparedStatement ps;   //Prepara la consulta
    ResultSet rs;   //Ejecuta la consulta
    
    //Realizara las consultas
     String sql1 = "select idAdministrador from Administrador where usuario=? and password=?";
     String sql2 = "select idDocente from Docente where codigo=? and password=?";
    
     //Obtiene el tipo de usuario
    public int obtenerTipoUsuario(String user, String pass){
        int tipoUsuario = 0;
        
        // Buscamos en la tabla Administrador
        if(obtenerIdAdminnistradorPorCuenta(user, pass) != 0){ 
            tipoUsuario = 1;      
        }else{
            // Buscamos en la tabla Docente
            if(obtenerIdDocentePorCuenta(user,pass) != 0){
                tipoUsuario = 2;      
            }else{
                tipoUsuario = 0;
            }
        }   

        return tipoUsuario;
    }

    //Obtiene el id del administrador
    public int obtenerIdAdminnistradorPorCuenta(String user, String pass){
       
        int idAdministrador = 0;
        
        try{
            ps=con.prepareStatement(sql1);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            rs.next();
            idAdministrador = rs.getInt("idAdministrador");
        }catch (SQLException e){
            
        }
        
        return idAdministrador;
        
    }
    
    //Obtiene el id del docente
    public int obtenerIdDocentePorCuenta(String user, String pass){
        
        int idDocente = 0;
        
        try{
            ps=con.prepareStatement(sql2);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            rs.next();
            idDocente = rs.getInt("idDocente");
        }catch (SQLException e){
            
        }
        
        return idDocente;
        
    }
    
    /*
    public int obtenerTipoUsuario(String user, String pass){
        int tipoUsuario = 0;
        
        // Buscamos en la tabla Administrador
        try{
            ps=con.prepareStatement(sql1);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if(rs.next()){ 
                tipoUsuario = 1;      
            }else{
            // Buscamos en la tabla Docente
                ps=con.prepareStatement(sql2);
                ps.setString(1, user);
                ps.setString(2, pass);
                rs=ps.executeQuery();
                
                if(rs.next()){
                    tipoUsuario = 2;      
                }else{
                    tipoUsuario = 0;
                }
            }    
        }catch(SQLException e){
            
        }
       

        return tipoUsuario;
    }
    */
}
