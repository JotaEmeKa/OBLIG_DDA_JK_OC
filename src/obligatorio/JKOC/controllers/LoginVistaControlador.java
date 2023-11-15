package obligatorio.JKOC.controllers;

import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.ui.LoginVista;

public abstract class LoginVistaControlador extends VistaBaseControlador<LoginVista, Sistema> {

    public LoginVistaControlador(LoginVista vista) {
        super(vista, Sistema.getInstance());
    }

    public void login(String nombreUsuario, String password) {
        Usuario usuario = loginInterno(nombreUsuario, password);
        if (usuario == null) {
            vista.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
        } else {
            vista.ejecutarCasoDeUsoInicial(usuario);
            vista.cerrarVentana();
        }
    }

    protected abstract Usuario loginInterno(String nombreUsuario, String password);
//Solucion alternativa para tener un único controldor concreto. Obliga al dialogo concreto diferenciar entre loginJugador/admin
//    public void loginJugador(String nombreUsuario, String password) {
//        loginGenerico(Sistema.getInstance().loginJugador(nombreUsuario, password));
//    }
//
//    public void loginCrupier(String nombreUsuario, String password) {
//        loginGenerico(Sistema.getInstance().loginCrupier(nombreUsuario, password));
//    }
//
//    private void loginGenerico(Usuario usuario) {
//        if (usuario == null) {
//            vista.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
//        } else {
//            vista.ejecutarCasoDeUsoInicial(usuario);
//            vista.cerrarVentana();
//        }
//    }

    @Override
    protected void inicializarVista() {
    }
}
