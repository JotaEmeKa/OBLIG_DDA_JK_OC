/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.ui;

import java.awt.Frame;
import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.UsuarioGenerico;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.controllers.LoginAdministradorVistaControlador;
import obligatorio.JKOC.controllers.LoginVistaControlador;

/**
 *
 * @author ddauser
 */
public class DialogoLoginAdministrador extends DialogoLogin {

    public DialogoLoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de Administrador");
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        return new LoginAdministradorVistaControlador(this);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(UsuarioGenerico usuario) {
        new DialogoUsuariosConectados((java.awt.Frame) this.getParent(), false, (Administrador) usuario).setVisible(true);
    }
}
