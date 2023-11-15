package obligatorio.JKOC.dominio;

import java.util.ArrayList;
import java.util.List;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.exceptions.RuletaException;
import obligatorio.JKOC.logica.Evento;

public class Mesa extends Observable {

    private List<Jugador> jugadores;
    private List<Ronda> rondas = new ArrayList<Ronda>();
    public int mesaId = 0;
    Crupier crupier;

    boolean esDisponible;//ver con estados
    
    public Mesa(Crupier crupier) {
        this.mesaId ++;
        this.crupier = crupier;
    }

    public Mesa() {
    }

    public void agregarPlayer(Sesion sesion) throws RuletaException {
        Jugador usuNuevo = (Jugador) sesion.getUsuario();
        if (jugadores.contains(usuNuevo)) {
            throw new RuletaException("Ya hay un jugador con el mismo nombre en la partida por el sistema");
        }
        jugadores.add(usuNuevo);
        avisar(Evento.INGRESO_JUGADOR);
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    //VER ESTE MÉTODO!
    public int getLimiteJugadores() {
        return jugadores.size();
    }

}
