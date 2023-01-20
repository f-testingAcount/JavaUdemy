package datos;

import domain.Usuario1DTO;
import java.sql.SQLException;
import java.util.List;

public interface IUsuario1Dao {
    
    public List<Usuario1DTO> select() throws SQLException;
    
    public int insert(Usuario1DTO usuario) throws SQLException;
    
    public int update(Usuario1DTO usuario) throws SQLException;
    
    public int delete(Usuario1DTO usuario) throws SQLException;
}
