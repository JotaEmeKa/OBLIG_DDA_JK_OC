package obligatorio.JKOC.logica;

import java.util.ArrayList;
import java.util.Date;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.dominio.Jugador;
import obligatorio.JKOC.dominio.Usuario;

class ControlUsuario extends Observable {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Crupier> crupieres;
    private ArrayList<Sesion> usuariosConectados;

    public ControlUsuario() {
        jugadores = new ArrayList<>();
        crupieres = new ArrayList<>();
        usuariosConectados = new ArrayList<>();
    }

    public void agregar(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void agregar(Crupier crupier) {
        crupieres.add(crupier);
    }

    public void iniciar(Sesion sesion) {
        usuariosConectados.add(sesion);
        avisar(Eventos.LOGIN_USUARIO_AGENDA);
    }

    public void cerrar(Sesion sesion) {
        usuariosConectados.remove(sesion);
        avisar(Eventos.LOGOUT_USUARIO_AGENDA);
    }

    public ArrayList<Sesion> getUsuariosConectados() {
        return usuariosConectados;
    }

    public Jugador loginJugador(String usuario, String password) {
        return (Jugador) loginGenerico(usuario, password, (ArrayList) jugadores);
    }

    public Crupier loginCrupier(String usuario, String password) {
        return (Crupier) loginGenerico(usuario, password, (ArrayList) crupieres);
    }

    private Usuario loginGenerico(String usuario, String password, ArrayList<Usuario> listaUsuarios) {
        for (Usuario u : listaUsuarios) {
            if (u.getIdUsuario().equals(usuario) && u.esPassordValida(password)) {
                return u;
            }
        }
        return null;
    }
}
