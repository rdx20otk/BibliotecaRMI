package Entidad;

public class Administrador {

    private int id;
    private String user;
    private String Password;

    public Administrador(int id, String user, String Password) {
        this.id = id;
        this.user = user;
        this.Password = Password;
    }
//u
    public Administrador(String user, String Password) {
        this.user = user;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
