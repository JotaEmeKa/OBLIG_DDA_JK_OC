package logica.mesa;

import utilidades.EventoJuego;
import java.util.ArrayList;
import java.util.List;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.UsuarioCrupier;
import logica.usuario.UsuarioJugador;
import utilidades.Observable;
import utilidades.RuletaException;

/**
 *
 * @author Octavio
 */
public class Mesa extends Observable {

    private List<UsuarioJugador> jugadores;
    private List<Ronda> rondas = new ArrayList<Ronda>();
    public int mesaId = 0;
    UsuarioCrupier crupier;

    boolean esDisponible;//ver con estados
    
    public Mesa(UsuarioCrupier crupier) {
        this.mesaId ++;
        this.crupier = crupier;
    }

    public Mesa() {
    }

    public void agregarPlayer(Sesion sesion) throws RuletaException {
        UsuarioJugador usuNuevo = (UsuarioJugador) sesion.getUsuario();
        if (jugadores.contains(usuNuevo)) {
            throw new RuletaException("Ya hay un jugador con el mismo nombre en la partida por el sistema");
        }
        jugadores.add(usuNuevo);
        avisar(EventoJuego.INGRESO_JUGADOR);
        Sistema.getInstancia().avisar(EventoJuego.INGRESO_JUGADOR);
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public List<UsuarioJugador> getJugadores() {
        return jugadores;
    }

    //VER ESTE MÉTODO!
    public int getLimiteJugadores() {
        return jugadores.size();
    }

    





}
