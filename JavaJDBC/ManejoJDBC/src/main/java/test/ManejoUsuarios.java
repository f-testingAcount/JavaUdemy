package test;

import datos.Usuario1DAO;
import domain.Usuario1;
import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        Usuario1DAO usuario = new Usuario1DAO();
        
        //Insertar un nuevo registro 
        Usuario1 nuevoUsuario = new Usuario1("walton.majors", "987");
        usuario.insert(nuevoUsuario);
        //System.out.println(nuevoUsuario);

//        //Modificar usuario
//        Usuario1 modificarUsuario = new Usuario1(2, "ashleyMarie.thompson", "321");
//        usuario.update(modificarUsuario);

        //Eliminar usuario
//        Usuario1 eliminarUsuario = new Usuario1(3);
//        usuario.delete(eliminarUsuario);

//        Forma simplificada
//        usuario.delete(new Usuario1(idusuario1));
        
        
        //Ejecutando el listado de usuarios
        List<Usuario1> usuarios = usuario.select();
        for(Usuario1 detalle: usuarios){
            System.out.println("Detalle: " + detalle);
        }
    }
}
