/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import iu.LoginVista;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import utilidades.CrupierException;

/**
 *
 * @author fadavanc
 */
public class LoginUsuarioVistaControlador extends LoginVistaControlador {

    public LoginUsuarioVistaControlador(LoginVista vista) {
        super(vista);
    }

    @Override
    protected Sesion loginInterno(String nombreUsuario, String password) {
        try {
            return Sistema.getInstancia().loginUsuarioJugador(nombreUsuario, password);
        } catch (CrupierException ex) {
            Logger.getLogger(LoginUsuarioVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;//pasar la exception a la vista
    }

}
