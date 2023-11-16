package logica.mesa;

import java.util.ArrayList;
import logica.usuario.UsuarioJugador;
import utilidades.JugadorException;

public class Apuesta {

    private Casillero casillero;
    private UsuarioJugador jugador;
    private double monto;

    public double getMonto() {
        return monto;
    }
    

    public Apuesta(Casillero casillero, UsuarioJugador jugador, double monto) {
        this.casillero = casillero;
        this.jugador = jugador;
        this.monto=monto;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public UsuarioJugador getJugador() {
        return jugador;
    }

    public void setCasillero(ArrayList<Casillero> casilleros) {
        this.casillero = casillero;
    }

    public void setJugador(UsuarioJugador jugador) {
        this.jugador = jugador;
    }
    
    

}
