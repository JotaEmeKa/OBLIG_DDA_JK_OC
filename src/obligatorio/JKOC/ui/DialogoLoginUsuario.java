/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.ui;

import java.awt.Frame;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.dominio.UsuarioGenerico;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.controllers.LoginUsuarioVistaControlador;
import obligatorio.JKOC.controllers.LoginVistaControlador;

/**
 *
 * @author ddauser
 */
public class DialogoLoginUsuario extends DialogoLogin {

    public DialogoLoginUsuario(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de Usuario agenda");
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        return new LoginUsuarioVistaControlador(this);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(UsuarioGenerico usuario) {
        new DialogoAgenda((java.awt.Frame) this.getParent(), false, (Usuario) usuario).setVisible(true);
    }
}
