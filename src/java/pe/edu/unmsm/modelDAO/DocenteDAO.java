package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import pe.edu.unmsm.model.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DocenteDAO extends UsuarioDAO {

    ConexionBD cn = ConexionBD.getConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Docente docente;

    public Docente buscar(int idDocente) {
        String sql = "SELECT * FROM docente INNER JOIN categoria "
                + " ON Categoria_idCategoria = idCategoria WHERE idDocente=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDocente);
            rs = ps.executeQuery();
            
            rs.next();
            
            docente = new Docente(rs.getString("codigo")
                                , rs.getString("password")
                                , idDocente
                                , rs.getString("apellido_paterno")
                                , rs.getString("apellido_materno")
                                , rs.getString("nombres")
                                , rs.getInt("restriccion")
                                , rs.getInt("idCategoria")
                                , rs.getString("nombre")
                                , rs.getInt("horas_min")
                                , rs.getInt("horas_max")
                                );
            
            
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos Docente");
        }
        return docente;
    }

    public boolean updateRestriccion(int id, int restriccion) {
        String sql = "UPDATE docente SET restriccion = ? WHERE idDocente = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, restriccion);
            ps.setInt(2, id);
            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    public boolean buscarCeldaElegida(String cadena, String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(cadena)) {
                return true;
            }

        }
        return false;
    }
    
    // ADMIN
    
    //Manda un Iterator para que se pueda lista los docentes
    public Iterator<Docente> listarDocente() {
        
        //Se declara una Lista
        List<Docente> docentes = new ArrayList<>();
        
        //Se realiza la consulta para el listado de docente
        String sql = "SELECT idDocente, codigo, nombres, apellido_paterno, apellido_materno "
                    + "FROM Docente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                //Se ingresa los datos de los docentes
                Docente doc = new Docente(rs.getInt("idDocente"),
                                          rs.getString("codigo"),
                                          rs.getString("nombres"), 
                                          rs.getString("apellido_paterno"),
                                          rs.getString("apellido_materno")
                                          );
                docentes.add(doc);//Se agrega los docentes en la Lista
            }
            return docentes.iterator();//Retorna un Iterator
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos Docente");
        }
        return null;//Si en caso no se encuentra ningun docente
    }
    
    public ResultSet listarSolicitud() {
        String sql = "SELECT * FROM docente INNER JOIN categoria "
                + " ON docente.Categoria_idCategoria = categoria.idCategoria"
                + " INNER JOIN disponibilidad ON disponibilidad.Docente_idDocente = docente.idDocente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos Docente");
        }
        return null;
    }
    
}
