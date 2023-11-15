package obligatorio.JKOC.logica;

import java.util.ArrayList;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.common.Observador;
import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;
import obligatorio.JKOC.dominio.Jugador;

public class Sistema extends Observable implements Observador {

    private static Sistema instance;
    private ControlMesa controlMesa;
    private ControlUsuario controlUsuario;

    private Sistema() {
        controlMesa = new ControlMesa();
        controlUsuario = new ControlUsuario();
        controlUsuario.agregar(this);
    }

    public synchronized static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public Jugador loginJugador(String usuario, String password) {
        return controlUsuario.loginJugador(usuario, password);
    }

    public Crupier loginCrupier(String usuario, String password) {
        return controlUsuario.loginCrupier(usuario, password);
    }

    public void iniciar(Sesion sesion) {
        controlUsuario.iniciar(sesion);
    }

    public void cerrar(Sesion sesion) {
        controlUsuario.cerrar(sesion);
    }
    
    public void agregar(Jugador jugador) {
        controlUsuario.agregar(jugador);
    }

    public void agregar(Crupier crupier) {
        controlUsuario.agregar(crupier);
    }
    
    public ArrayList<Sesion> getUsuariosConectados() {
        return controlUsuario.getUsuariosConectados();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.LOGIN_USUARIO_AGENDA.equals(evento) || Eventos.LOGOUT_USUARIO_AGENDA.equals(evento)) {
            avisar(evento);
        }
    }
}
