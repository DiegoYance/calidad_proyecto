
package pe.edu.unmsm.conexionBD;

import java.sql.*;
import static pe.edu.unmsm.config.ConfigBD.getNAME_BD;
import static pe.edu.unmsm.config.ConfigBD.getPASSWORD_BD;
import static pe.edu.unmsm.config.ConfigBD.getUSER_BD;

public class ConexionBD {
    private Connection con;
    private static ConexionBD conexion;
    
    
    private ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    getNAME_BD(), getUSER_BD(), getPASSWORD_BD());             
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    
    public static ConexionBD getConexion(){
        if(conexion == null){
            conexion = new ConexionBD();
        }
        return conexion;
    }
    
    public Connection getConnection(){
        return con;
    }
}
