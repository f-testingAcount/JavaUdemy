package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDao = new PersonaDAO(conexion);

            Persona modificarDatos = new Persona();
            modificarDatos.setIdPersona(37);
            //'37', 'John', 'Smith', 'js@mail.com', '78787844'
            modificarDatos.setNombre("Irina");
            modificarDatos.setApellido("James");
            modificarDatos.setEmail("ij@mail.com");
            modificarDatos.setTelefono("32659874");
            personaDao.actualizar(modificarDatos);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Milly");
//            nuevaPersona.setApellido("VanIlly1111111111111111111111111111111111111111111111111111111111111111111111111");
            nuevaPersona.setApellido("VanIlly");
            nuevaPersona.setEmail("mv@mail.com");
            nuevaPersona.setTelefono("45665445");
            personaDao.insertar(nuevaPersona);

            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
