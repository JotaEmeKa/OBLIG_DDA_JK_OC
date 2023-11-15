package obligatorio.JKOC.controllers;

import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.ui.LoginVista;

public class LoginCrupierVistaControlador extends LoginVistaControlador {

    public LoginCrupierVistaControlador(LoginVista vista) {
        super(vista);
    }

    @Override
    protected Usuario loginInterno(String nombreUsuario, String password) {
        return Sistema.getInstance().loginCrupier(nombreUsuario, password);
    }

}
