package logica.usuario;

import java.util.ArrayList;
import java.util.List;
import logica.mesa.Mesa;
//import logica.juego.Carta;
//import logica.juego.Figura;
//import logica.juego.Juego;

public class UsuarioJugador extends Usuario {

    private double saldo;
    
//    private double apuesta;
//    private String nombreUsuario;
    private List<Mesa> juegos = new ArrayList<Mesa>();
    private boolean aposto = false;
//    private Figura figura = new Figura();
//    private boolean esGanador = false;
//
//    private List<Carta> mazoCartas = new ArrayList<Carta>();

    public UsuarioJugador(String cedula, String password, String nombreCompleto, double saldo) {
        super(cedula, password, nombreCompleto);
        this.saldo = saldo;
//        this.nombreUsuario = nombreCompleto;
//        this.aposto = false;
    }

//    public UsuarioJugador(String nombreUsuario, String password, double saldo, String nombreCompleto, List<Juego> juegos, double apuesta) {
//        super(nombreUsuario, password, nombreCompleto);
//        this.saldo = saldo;
//        this.nombreUsuario = nombreUsuario;
//        this.juegos = juegos;
//        this.aposto = false;
//    }

//    public boolean isAposto() {
//        return aposto;
//    }
//
//    public void setEsGanador(boolean esGanador) {
//        this.esGanador = esGanador;
//    }
//
//    public boolean isEsGanador() {
//        return esGanador;
//    }
//
//    public void setAposto(boolean aposto) {
//        this.aposto = aposto;
//    }
//
//    public void setFigura(Figura figura) {
//        this.figura = figura;
//    }
//
//    public Figura getFigura() {
//        return figura;
//    }

    public double getSaldo() {
        return saldo;
    }

//    public List<Carta> getMazoCartas() {
//        return mazoCartas;
//    }
//
//    public void setApuesta(double apuesta) {
//        this.apuesta = apuesta;
//    }
//
//    public double getApuesta() {
//        return apuesta;
//    }
//
    public List<Mesa> getMesas() {
        return juegos;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

//    public void setMazoCartas(List<Carta> mazoCartas) {
//        this.mazoCartas = mazoCartas;
//    }
//
//    public void agregarJuegoUsuario(Juego juego) { //esto esta raro pero por ahora dejalo
//        this.juegos.add(juego);
//    }

}
