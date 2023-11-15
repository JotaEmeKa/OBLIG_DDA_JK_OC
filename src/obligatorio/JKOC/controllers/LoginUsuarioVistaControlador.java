/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.JKOC.controllers;

import obligatorio.JKOC.dominio.UsuarioGenerico;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.ui.LoginVista;

/**
 *
 * @author fadavanc
 */
public class LoginUsuarioVistaControlador extends LoginVistaControlador {

    public LoginUsuarioVistaControlador(LoginVista vista) {
        super(vista);
    }

    @Override
    protected UsuarioGenerico loginInterno(String nombreUsuario, String password) {
        return FachadaServicios.getInstance().loginUsuario(nombreUsuario, password);
    }

}
