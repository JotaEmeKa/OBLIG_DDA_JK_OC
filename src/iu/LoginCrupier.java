
package iu;

import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import utilidades.CrupierException;


public class LoginCrupier extends LoginVista{

    public LoginCrupier(Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal, isCrupier);
    }

    @Override
    public Sesion hacerLogin(String nombre, String password) {
        try {
            return Sistema.getInstancia().loginUsuarioCrupier(nombre, password);
        } catch (CrupierException ex) {
           //Logger.getLogger(LoginCrupier.class.getName()).log(Level.SEVERE, null, ex);
            //Mandar al Controller de la vista
            mostrarMensajeDeError(ex.getMessage());
        }
        return null; 
    }

//    @Override
//    public void mostrarProximaInterfaz(Sesion sesion) {
//       MonitorearJuegos verUsuariosConectados = new MonitorearJuegos(null, false,(UsuarioAdmin)sesion.getUsuario());
//       verUsuariosConectados.setVisible(true);
//       verUsuariosConectados.setLocationRelativeTo(this);
//    }
//    

    @Override
    public void mostrarProximaInterfaz(Sesion sesion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarMensajeDeError(String mensaje) {
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
