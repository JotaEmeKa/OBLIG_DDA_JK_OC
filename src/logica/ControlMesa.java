package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import logica.mesa.Mesa;
import logica.mesa.Ronda;
import logica.usuario.Sesion;
import logica.usuario.UsuarioJugador;
import utilidades.RuletaException;

public class ControlMesa {

    private List<Mesa> mesas = new ArrayList<Mesa>();

    private int limiteJugadores;
    private double montoBase;

    public double getMontoBase() {
        return montoBase;
    }

    public int getLimiteJugadores() {
        return limiteJugadores;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    public void setLimiteJugadores(int limiteJugadores) {
        this.limiteJugadores = limiteJugadores;
    }

    public ControlMesa() {

    }

    public List<Mesa> getJuegos() {
        return mesas;
    }

    public void agregarJugadorJuego(Sesion sesion, Mesa mesa) throws RuletaException {   //osea que aca voy a tener que pasarle el juego o el id de juego
        for (Mesa m : mesas) {
            if (m.equals(mesa)) {
                UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//                if (usu.getSaldo() >= mesa.getMontoBase()) {
                if (usu.getSaldo() > 1) {
                    m.agregarPlayer(sesion);
                } else {
                    //tirar error
                }
            }
        }
    }

//    public Mazo agregarMazo() {
//        // Mano manoNueva = new Mano();
//        ArrayList<Carta> cartas = new ArrayList<Carta>();
//        List<String> palos = new ArrayList<String>();
//
//        palos.add("Corazón");
//        palos.add("Diamante");
//        palos.add("Trébol");
//        palos.add("Picas");
//
//        int contador = 1;
//        int contCarta = 1;
//        int tope = 13;
//        for (String palo : palos) {
//            while (contador <= tope) {
//                ImageIcon Img = new ImageIcon(getClass().getResource("/cartasNum/" + contador + ".gif"));
//                Carta cartaNueva = new Carta(contCarta, palo, Img);
//                cartas.add(cartaNueva);
//                contador++;
//                contCarta++;
//            }
//            tope += 13;
//            contCarta = 1;
//        }
//        //Mazo mazo = new Mazo(cartas);
//        return new Mazo(cartas);
//    }
//
//    public void ingresarJuego() {
//
//    }
//
//    public List<UsuarioJugador> obtenerListaJugadores() { //aca esta el error nuevamente a cambiar
//        return this.juegos.get(0).getJugadores();
//    }

    public List<Mesa> listarMesas() {
//       UsuarioJugador usu = new UsuarioJugador("Player1", "1234", 10, "Bot jaime");
//       UsuarioJugador usu2 = new UsuarioJugador("Octopus", "321",120 ,"Octavio Carnales");
//       List<UsuarioJugador> lista = new ArrayList<UsuarioJugador>();
//       lista.add(usu);
//       lista.add(usu2);
//       Juego juego = new Juego(5,false, lista, new ArrayList<Mano>(), "Juego 1");
//       this.juegos.add(juego);
        return this.mesas;
    }

    public void agregarJuego(Mesa mesa) {
        this.mesas.add(mesa);
    }

    public void agregarCantJugadores(int i) {
        this.setLimiteJugadores(i);
    }

    public void agregarMontoBase(double i) {
        this.setMontoBase(i);
    }

}
