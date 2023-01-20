package domain;

public class Usuario1DTO {
    private int idusuario1;
    private String username;
    private String password;

    public Usuario1DTO() {}

    public Usuario1DTO(int idusuario1) {
        this.idusuario1 = idusuario1;
    }

    public Usuario1DTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario1DTO(int idusuario1, String username, String password) {
        this.idusuario1 = idusuario1;
        this.username = username;
        this.password = password;
    }

    public int getIdusuario1() {
        return idusuario1;
    }

    public void setIdusuario1(int idusuario1) {
        this.idusuario1 = idusuario1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario1 | ID Usuario1: " + idusuario1 + ", User Name: " + username + ", Password: " + password;
    }
    
}
