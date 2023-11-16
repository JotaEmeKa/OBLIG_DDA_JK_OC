package iu;

import iu.controladores.LoginVistaControlador;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.mesa.Mesa;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import utilidades.CrupierException;

public class LoginJugador extends LoginVista {

    public LoginJugador(Frame parent, boolean modal, boolean isCrupier) {
        super(parent, modal, isCrupier);
    }

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
        MesaCrupierVista vmesa = new MesaCrupierVista(sesion, new Mesa());
        vmesa.setVisible(true);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Sesion usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cerrarVentana() {
        dispose();
    }

    @Override
    public void mostrarMensajeDeError(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
