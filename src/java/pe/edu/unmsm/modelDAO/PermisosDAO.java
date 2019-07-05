package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER1
 */
public class PermisosDAO {

    ConexionBD cn = ConexionBD.getConexion();   //Se conecta con la bd
    Connection con; //Obtiene la conexion
    PreparedStatement ps;   //Prepara la consulta
    ResultSet rs;   //Ejecuta la consulta
    
    //Envia la solicitud de permiso al administrador
    public boolean enviarSolicitud(int idDocente, String motivo) {
        String sql = "insert into permisos(docente_idDocente,motivo, aprobado) "
                + " values(?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, idDocente);
            ps.setString(2, motivo);
            ps.setString(3, "NO");

            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    //Lista los permisos de los profesores
    public ResultSet listarSolicitud() {
        String sql = "SELECT permisos.motivo, docente.nombres, docente.idDocente, docente.apellido_paterno, "
                + "docente.apellido_materno, docente.restriccion, docente.codigo "
                + "FROM permisos "
                + "INNER JOIN docente ON permisos.docente_idDocente = docente.idDocente";
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
