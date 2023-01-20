package datos;

import static datos.Conexion.*;
import domain.Usuario1DTO;
import java.sql.*;
import java.util.*;

public class Usuario1DaoJDBC implements IUsuario1Dao {
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT idusuario1, username, password FROM testprueba.usuario1";
    private static final String SQL_INSERT = "INSERT INTO testprueba.usuario1(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE testprueba.usuario1 SET username = ?, password = ? WHERE idusuario1 = ?";
    private static final String SQL_DELETE = "DELETE FROM testprueba.usuario1 WHERE idusuario1 = ?";

    public Usuario1DaoJDBC() {
    }

    public Usuario1DaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Usuario1DTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario1DTO usuario = null;
        List<Usuario1DTO> usuarios = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idusuario1 = rs.getInt("idusuario1");
                String username = rs.getString("username");
                String password = rs.getString("password");
                usuario = new Usuario1DTO();
                usuario.setIdusuario1(idusuario1);
                usuario.setUsername(username);
                usuario.setPassword(password);
                usuarios.add(usuario);
            }
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return usuarios;
    }

    public int insert(Usuario1DTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            //System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros agregados: " + rows);
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return rows;
    }

    public int update(Usuario1DTO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdusuario1());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return rows;
    }

    public int delete(Usuario1DTO usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdusuario1());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            if (this.conexionTransaccional == null) {
                close(conn);
            }
        }
        return rows;
    }
}
