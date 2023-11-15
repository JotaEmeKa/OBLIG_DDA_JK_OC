package obligatorio.JKOC.ui;

import java.awt.Frame;
import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.controllers.LoginCrupierVistaControlador;
import obligatorio.JKOC.controllers.LoginVistaControlador;

public class DialogoLoginCrupier extends DialogoLogin {

    public DialogoLoginCrupier(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de Crupier");
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        return new LoginCrupierVistaControlador(this);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new DialogoUsuariosConectados((java.awt.Frame) this.getParent(), false, (Crupier) usuario).setVisible(true);
    }
}
