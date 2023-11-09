
package logica.usuario;

import java.util.Date;


public class Sesion {
    private Usuario usuario;
    private Date fechaUltimoIngreso = new Date();

    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }
    
    
    
    
}
