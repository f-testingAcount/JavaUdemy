package test;

import static datos.Conexion.getConnection;
import datos.Usuario1DaoJDBC;
import domain.Usuario1DTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        Connection conexion = null;
        
        try {
            conexion = getConnection();
            if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        
        Usuario1DaoJDBC usuario1Dao = new Usuario1DaoJDBC(conexion);
        
        List<Usuario1DTO> usuarios1 = usuario1Dao.select();
        
        for (Usuario1DTO usuario1DTO : usuarios1) {
            System.out.println("Usuario DTO " + usuario1DTO);
        }
        
        conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        
//        Usuario1DaoJDBC usuario = new Usuario1DaoJDBC();
        
        //Insertar un nuevo registro 
//        Usuario1DTO nuevoUsuario = new Usuario1DTO("walton.majors", "987");
//        usuario.insert(nuevoUsuario);
        //System.out.println(nuevoUsuario);

//        //Modificar usuario
//        Usuario1DTO modificarUsuario = new Usuario1DTO(2, "ashleyMarie.thompson", "321");
//        usuario.update(modificarUsuario);

        //Eliminar usuario
//        Usuario1DTO eliminarUsuario = new Usuario1DTO(3);
//        usuario.delete(eliminarUsuario);
        
        
        //Ejecutando el listado de usuarios
//        List<Usuario1DTO> usuarios = usuario.select();
//        for(Usuario1DTO detalle: usuarios){
//            System.out.println("Detalle: " + detalle);
//        }
        
        
       
    }
}
