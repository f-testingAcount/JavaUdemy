package datos;

import static datos.Conexion.*;
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;

public class PersonaDaoJDBC implements IPersonaDao{

    private Connection conexionTransaccional; //Creamos este atributo para que generar una conexion externa global que se proporciona en el constructor 
                                              //lo cual evita que la conexion tenga que instanciarce en cada metodo y, al no crearce internamente en el 
                                              //metodo tampoco es necesario que cada mentodo la cierre. Solo se instacia si cuando se valida la existencia
                                              //de la conexion externa no existe. La conexion global permanece abierta lo cual nos permite ademas ejecutar
                                              //los commits y los rollback en caso de ser necesario.
                                              //En los metodos tambien eliminamos el bloque catch para que la excepcion se propague

    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM testprueba.persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE testprueba.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM testprueba.persona WHERE idpersona = ?";

    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PersonaDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection(); //Si la conexion transaccional existe se utiliza si no se genera una. Esta ultima se cerraria en este metodo la otra no
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
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
        return personas;
    }

    public int insert(PersonaDTO persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection(); //Si la conexion transaccional existe se utiliza si no se genera una. Esta ultima se cerraria en este metodo la otra no
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
        }
        return registros;
    }

    public int update(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection(); //Si la conexion transaccional existe se utiliza si no se genera una. Esta ultima se cerraria en este metodo la otra no
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
        }
        return registros;
    }

    public int delete(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection(); //Si la conexion transaccional existe se utiliza si no se genera una. Esta ultima se cerraria en este metodo la otra no
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
        }
        return registros;
    }
}
