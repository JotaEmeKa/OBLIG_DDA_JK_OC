package obligatorio.JKOC.dominio;

import java.util.Date;

public class Sesion {
    
    private Jugador usuario;
    
    private Date fechaAcceso;

    public Sesion(Jugador usuario, Date fechaAcceso) {
        this.usuario = usuario;
        this.fechaAcceso = fechaAcceso;
    }

    public Jugador getUsuario() {
        return usuario;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    @Override
    public String toString() {
        //TODO: renderizar esto en la interfaz.
        return usuario.getNombre() + "(Cant.Contactos:" + usuario.getCantidadContactos() + ") - " + fechaAcceso;
    }
}
