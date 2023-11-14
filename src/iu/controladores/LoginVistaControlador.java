package iu.controladores;

import controlador.VistaBaseControlador;
import iu.VistaLogin;
import iu.LoginVista;
import javax.security.auth.login.LoginException;
import logica.Sistema;
import logica.usuario.Usuario;

public abstract class LoginVistaControlador extends VistaBaseControlador<VistaLogin, Sistema> {

    public LoginVistaControlador(LoginVista vista) {
        super(vista, Sistema.getInstancia());
    }

    public void login(String nombreUsuario, String password) {
//        Usuario usuario = null;
//        try {
//            usuario = loginInterno(nombreUsuario, password);
//            vista.ejecutarCasoDeUsoInicial(usuario);
//            vista.cerrarVentana();
//
//        } catch (LoginException e) {
//            vista.mostrarMensajeDeError(e.getMessage());
//            throw System.out.print("Error");
//        }
        Usuario usuario = loginInterno(nombreUsuario, password);
        if (usuario == null) {
            vista.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
        } else {
            vista.ejecutarCasoDeUsoInicial(usuario);
            vista.cerrarVentana();
        }
    }

    protected abstract Usuario loginInterno(String nombreUsuario, String password);
//Solucion alternativa para tener un único controldor concreto. Obliga al dialogo concreto diferenciar entre loginUsuario/admin
//    public void loginUsuario(String nombreUsuario, String password) {
//        loginGenerico(FachadaServicios.getInstance().loginUsuario(nombreUsuario, password));
//    }
//
//    public void loginAdministrador(String nombreUsuario, String password) {
//        loginGenerico(FachadaServicios.getInstance().loginAdministrador(nombreUsuario, password));
//    }
//
//    private void loginGenerico(UsuarioGenerico usuario) {
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
