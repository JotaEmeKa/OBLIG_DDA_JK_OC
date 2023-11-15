package obligatorio.JKOC.ui;

import java.awt.Frame;
import obligatorio.JKOC.dominio.Jugador;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.controllers.LoginJugadorVistaControlador;
import obligatorio.JKOC.controllers.LoginVistaControlador;

public class DialogoLoginJugador extends DialogoLogin {

    public DialogoLoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales de Jugador");
    }

    @Override
    protected LoginVistaControlador crearControlador() {
        return new LoginJugadorVistaControlador(this);
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Usuario usuario) {
        new DialogoAgenda((java.awt.Frame) this.getParent(), false, (Jugador) usuario).setVisible(true);
    }
}
