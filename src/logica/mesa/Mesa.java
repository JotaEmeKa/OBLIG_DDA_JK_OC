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

    private ArrayList<UsuarioJugador> jugadores;
    private ArrayList<Ronda> rondas = new ArrayList<Ronda>();
    private ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
    private ArrayList<TipoApuesta> tiposApuesta = new ArrayList<TipoApuesta>();
    public int mesaId = 0;
    UsuarioCrupier crupier;
    double balance = 0;
    boolean esDisponible;//ver con estados

    public Mesa(UsuarioCrupier crupier, Ronda ronda) {
        this.mesaId++;
        this.crupier = crupier;
        this.rondas.add(ronda);
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

    public ArrayList<Ronda> getRondas() {
        return rondas;
    }

    public ArrayList<UsuarioJugador> getJugadores() {
        return jugadores;
    }

    //VER ESTE MÉTODO!
    public int getLimiteJugadores() {
        return jugadores.size();
    }

    public void agregarTiposApuesta(ArrayList<TipoApuesta> ta) {
        for (TipoApuesta tipoApuesta : ta) {//Falta agregar a prepo la apuesta directa, buscándola por nombre capaz
            this.tiposApuesta.add(tipoApuesta);
        }
    }

    public ArrayList<TipoApuesta> getTiposApuesta() {
        return tiposApuesta;
    }

    public int getMesaId() {
        return mesaId;
    }

    public UsuarioCrupier getCrupier() {
        return crupier;
    }

    public boolean isEsDisponible() {
        return esDisponible;
    }

    public double getBalance() {
        return balance;
    }

    public void setCrupier(UsuarioCrupier crupier) {
        this.crupier = crupier;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    Casillero buscar(int nroSorteado) {
        for (Casillero c : casilleros) {
            if (c.getUniversalCellCode() == nroSorteado) {
                return c;
            }
        }
        return null;
    }

}
