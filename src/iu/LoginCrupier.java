package iu;

import iu.controladores.LoginAdministradorVistaControlador;
import iu.controladores.LoginVistaControlador;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import utilidades.CrupierException;

public class LoginCrupier extends LoginVista {

    public LoginCrupier(Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal, isCrupier);
    }

//    public void mostrarProximaInterfaz(Sesion sesion) {
////       MonitorearJuegos verUsuariosConectados = new MonitorearJuegos(null, false,(UsuarioAdmin)sesion.getUsuario());
////       verUsuariosConectados.setVisible(true);
////       verUsuariosConectados.setLocationRelativeTo(this);
//        System.out.println("Entraste");
//        LobbyVista lobby = new LobbyVistaCrupier(null, false, sesion);
//        lobby.setVisible(true);
//    }
    public void ejecutarCasoDeUsoInicial(Sesion sesion) {
        new LobbyVista((java.awt.Frame) this.getParent(), false, sesion).setVisible(true);
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        return new LoginAdministradorVistaControlador(this);
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
