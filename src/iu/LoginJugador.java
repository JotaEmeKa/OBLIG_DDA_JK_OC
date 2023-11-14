package iu;

import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import utilidades.CrupierException;

public class LoginJugador extends LoginVista {

    public LoginJugador(Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal, isCrupier);
    }

    @Override
    public Sesion hacerLogin(String nombre, String password) {
        try {
            return Sistema.getInstancia().loginUsuarioJugador(nombre, password);
        } catch (CrupierException ex) {
            Logger.getLogger(LoginJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void mostrarProximaInterfaz(Sesion sesion) {
        System.out.println("Entraste");
        PanelRuleta jugar = new PanelRuleta(sesion);
        //jugar.setVisible(true);
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
