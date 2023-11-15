/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.JKOC.controllers;

import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.UsuarioGenerico;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.ui.LoginVista;

/**
 *
 * @author fadavanc
 */
public abstract class LoginVistaControlador extends VistaBaseControlador<LoginVista, FachadaServicios> {

    public LoginVistaControlador(LoginVista vista) {
        super(vista, FachadaServicios.getInstance());
    }

    public void login(String nombreUsuario, String password) {
        UsuarioGenerico usuario = loginInterno(nombreUsuario, password);
        if (usuario == null) {
            vista.mostrarMensajeDeError("Nombre y/o la contraseña no son correctos");
        } else {
            vista.ejecutarCasoDeUsoInicial(usuario);
            vista.cerrarVentana();
        }
    }

    protected abstract UsuarioGenerico loginInterno(String nombreUsuario, String password);
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
