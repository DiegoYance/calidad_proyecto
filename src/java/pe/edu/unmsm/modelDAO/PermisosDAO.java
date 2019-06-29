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

    ConexionBD cn = ConexionBD.getConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

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

    public static void main(String[] args) throws SQLException {
        PermisosDAO solicitudes = new PermisosDAO();
        ResultSet rs = solicitudes.listarSolicitud();
        int i = 1;
        while (rs != null && rs.next()) {
            System.out.println(rs.getString("motivo"));
        }
    }
}
