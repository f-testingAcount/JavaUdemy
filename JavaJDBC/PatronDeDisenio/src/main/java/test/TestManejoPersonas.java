package test;

import datos.Conexion;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDaoJDBC personaDao = new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO> personas = personaDao.select();
            
            for (PersonaDTO persona : personas) {
                System.out.println("Persona DTO: " + persona);
            }
            
            
//            PersonaDTO modificarDatos = new PersonaDTO();
//            modificarDatos.setIdPersona(37);
//            //'37', 'John', 'Smith', 'js@mail.com', '78787844'
//            modificarDatos.setNombre("Irina");
//            modificarDatos.setApellido("James");
//            modificarDatos.setEmail("ij@mail.com");
//            modificarDatos.setTelefono("32659874");
//            personaDao.update(modificarDatos);
//
//            PersonaDTO nuevaPersona = new PersonaDTO();
//            nuevaPersona.setNombre("Milly");
////            nuevaPersona.setApellido("VanIlly1111111111111111111111111111111111111111111111111111111111111111111111111");
//            nuevaPersona.setApellido("VanIlly");
//            nuevaPersona.setEmail("mv@mail.com");
//            nuevaPersona.setTelefono("45665445");
//            personaDao.insert(nuevaPersona);

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
