
package pe.edu.unmsm.modelDAO;

import pe.edu.unmsm.conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeriodoAcademicoDAO {
    private static ConexionBD cn = ConexionBD.getConexion();
    
    
    public void ingresarFechaLimite(String fecha_inicio, String fecha_fin ) {
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "UPDATE periodoacademico SET fechaInicio = ?, fechaFin = ?"
                + "WHERE idPeriodoAcademico=1";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha_inicio);
            ps.setString(2, fecha_fin);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al intentar actualizar las fechas.");
        }
    } 

    public String[] fechaLimite(){
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT fechaInicio, fechaFin "
                    + "FROM periodoacademico";
        String fechas[] = new String[2];
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               fechas[0] = rs.getString("fechaInicio");
               fechas[1] = rs.getString("fechaFin");
                
            }
            return fechas;//Retorna las fechas
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos Docente");
        }
        return null;
    }
}
