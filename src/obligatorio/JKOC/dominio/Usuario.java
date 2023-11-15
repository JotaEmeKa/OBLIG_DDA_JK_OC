package obligatorio.JKOC.dominio;

public abstract class Usuario {

    private String idUsuario;

    private String nombre;

    private String password;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean esPassordValida(String password) {
        return this.password.equals(password);
    }

}
