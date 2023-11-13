package iu;

import componente.PanelRuleta;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
//import logica.juego.Juego;
import logica.usuario.Sesion;
import logica.usuario.UsuarioCrupier;

public class LoginJugador extends Login {

    public LoginJugador(Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal, isCrupier);
    }

    @Override
    public Sesion hacerLogin(String nombre, String password) {
        return Sistema.getInstancia().loginUsuarioJugador(nombre, password);
    }

    public void mostrarProximaInterfaz(Sesion sesion) {
        System.out.println("Entraste");
        PanelRuleta jugar = new PanelRuleta(sesion);
        //jugar.setVisible(true);
    }

}
