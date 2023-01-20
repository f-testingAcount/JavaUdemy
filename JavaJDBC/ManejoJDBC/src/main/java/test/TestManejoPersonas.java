package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

//        Insertando un nuevo objeto de tipo Persona
        Persona personaNueva = new Persona("John", "Smith", "js@mail.com", "78787844");
//        personaDao.insertar(personaNueva);
        System.out.println("Se ha agregado " + personaDao.insertar(personaNueva) + " registro!");
        imprimir(personaDao);

//        List<Persona> personas = personaDao.seleccionar();
//        personas.forEach(persona -> {
//            System.out.println("Persona: " + persona);
//        });
        //Modificar un objeto de persona existente osea un registro de la base de datos
        //'16', 'John', 'McGall', 'jmg@mail.com', '23322332'
        //'2', 'Paul', 'Schuartz', 'ps@mail.com', '32658965'
//
//        Persona personaModificar = new Persona(17, "Ariana", "Michaels Collins", "amc@mail.com", "111111111");
//        System.out.println("Se ha modificado " + personaDao.actualizar(personaModificar) + " registro!");
//        imprimir(personaDao);
//        
//        
//        //Eliminar registro
//        Persona personaEliminar = new Persona(34);
//        System.out.println("Se ha eliminado " + personaDao.eliminar(personaEliminar) + " registro con el id numero " + personaEliminar.getIdPersona() + "!");
//        imprimir(personaDao);

//        List<Persona> personas = personaDao.seleccionar();
//        personas.forEach(persona -> {
//            System.out.println("Persona: " + persona);
//        });
    }

    public static void imprimir(PersonaDAO personaDao) {
        List<Persona> personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println(persona);
        });
    }
}
