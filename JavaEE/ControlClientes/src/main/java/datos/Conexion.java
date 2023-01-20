package datos;

import java.sql.*;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublickeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "adminmin23";

    private static BasicDataSource dataSource;

    //Agregamos el metodo que recupera la conexion a una base de datos.
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource(); //Esta clase se encuentra en el paquete org.apache.commons.dbcp2 que es la libreria que agregamos al archivo pom.xml
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50); //Definimos el tamaño inicial del pull de conexiones. Ante cualquier inconveniente de conexion hacia la base de datos
            //seria recomendable usar el pull de conexiones del servidor de aplicaciones (en este caso glassfish). 
        }
        return dataSource;
    }

    //Definimos un metodo para obtener una conexion
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getDataSource().getConnection();
    }

//    public static Connection obtenerConexion(String driver, String url, String usr, String pass)
//            throws ClassNotFoundException, SQLException { //Metodo de conexion que me envio Emiliano.
//        Class.forName(driver);
//        return DriverManager.getConnection(url, usr, pass);
//    }

    //Agregamos los metodos de cierre
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) { 
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
