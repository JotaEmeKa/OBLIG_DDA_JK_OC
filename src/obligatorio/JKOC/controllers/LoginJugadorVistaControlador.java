package obligatorio.JKOC.controllers;

import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.ui.LoginVista;

public class LoginJugadorVistaControlador extends LoginVistaControlador {

    public LoginJugadorVistaControlador(LoginVista vista) {
        super(vista);
    }

    @Override
    protected Usuario loginInterno(String nombreUsuario, String password) {
        return Sistema.getInstance().loginJugador(nombreUsuario, password);
    }

}
