
package logica.usuario;

import java.util.ArrayList;
import java.util.List;
//import logica.juego.Carta;


public class Usuario {
    private String cedula;
    private String password;
    private String nombreCompleto;
    
    

    public Usuario(String nombreUsuario, String password, String nombreCompleto) {
        this.cedula = nombreUsuario;
        this.password = password;
        this.nombreCompleto= nombreCompleto;
        
    }
    
    

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    public String getNombreUsuario() {
        return cedula;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.cedula = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    
    
}
