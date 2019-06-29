/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import pe.edu.unmsm.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class CategoriaDAO {
    
    ConexionBD cn = ConexionBD.getConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Categoria docente = new Categoria();

    /*
    public Categoria buscar(int idDocente) {
        String sql = "select * from docente inner join categoria "
                + " on Categoria_idCategoria = idCategoria where idDocente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                docente.setId(rs.getInt("idDocente"));
                docente.setApePaterno(rs.getString("apellido_paterno"));
                docente.setApeMaterno(rs.getString("apellido_materno"));
                docente.setNombres(rs.getString("nombres"));
                docente.setRestriccion(rs.getInt("restriccion"));
                docente.setCategoria(rs.getString("nombre"));
                docente.setCodigo(rs.getString("codigo"));
                docente.setPassword(rs.getString("password"));
                docente.setHorasMin(rs.getInt("horas_min"));
                docente.setHorasMax(rs.getInt("horas_max"));

            }
        } catch (SQLException e) {
        }
        return docente;
    }
    */
}
