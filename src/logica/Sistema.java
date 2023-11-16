package logica;

import logica.usuario.UsuarioCrupier;
import logica.usuario.Sesion;
import logica.usuario.UsuarioJugador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
//import logica.mesa.Carta;
//import logica.mesa.ControlJuego;
import logica.mesa.Mesa;
import logica.mesa.Ronda;
import logica.mesa.TipoApuesta;
import logica.mesa.TipoEfecto;
import utilidades.CrupierException;
//import logica.mesa.JuegoException;
//import logica.mesa.Mano;
//import logica.mesa.Mazo;
//import logica.usuario.ControlUsuario;
//import logica.usuario.Sesion;
//import logica.usuario.UsuarioAdmin;
//import logica.usuario.UsuarioJugador;
import utilidades.Observable;
import utilidades.RuletaException;

public class Sistema extends Observable {

//    private ControlJuego controlJuego = new ControlJuego();
    private ControlUsuario controlUsuario = new ControlUsuario();
    private ControlMesa controlMesa = new ControlMesa();

    private static Sistema instancia = new Sistema();

    public static Sistema getInstancia() {
            return instancia;
    }

//    public Mazo agregarMazo() {
//        return controlJuego.agregarMazo();
//    }
//    public List<Juego> getJuegos() {
//        return controlJuego.getJuegos();
//    }
//
//     public boolean agregarJuego(List<UsuarioJugador> jugadores, List<Ronda> rondas) {
//        return controlMesa.agregarJuego(jugadores, rondas);
//      }
//     
//

    public List<Mesa> listarMesas() {
        return controlMesa.listarMesas();
    }
//

    public void agregarJugadorJuego(Sesion sesion, Mesa juego) throws RuletaException {
        controlMesa.agregarJugadorJuego(sesion, juego);
    }
//
//    public List<UsuarioJugador> obtenerJugadores() {
//        return controlJuego.obtenerListaJugadores();
//    }

    public Sesion loginUsuarioJugador(String nombre, String password) throws CrupierException {
        return controlUsuario.loginUsuarioJugador(nombre, password);
    }

    public Sesion loginUsuarioCrupier(String nombre, String password) throws CrupierException {
        return controlUsuario.loginUsuarioCrupier(nombre, password);
    }

    public boolean agregarUsuario(UsuarioJugador usuario) {
        return controlUsuario.agregarUsuarioJugador(usuario);
    }

    public boolean agregarUsuario(UsuarioCrupier usuario) {
        return controlUsuario.agregarUsuarioCrupier(usuario);
    }

    public List<Sesion> getLogueados() {
        return controlUsuario.getLogueados();
    }

    public Sesion loginJugador(String nombre, String password) throws CrupierException {
        return controlUsuario.loginUsuarioJugador(nombre, password);
    }

    public Sesion loginAdmin(String nombre, String password) throws CrupierException {
        return controlUsuario.loginUsuarioCrupier(nombre, password);
    }

    public void logout(Sesion sesion) {
        controlUsuario.logout(sesion);
    }

//    public void agregarJuegoUsuario(Juego juego, Sesion sesion) {
//        controlUsuario.agregarJuegoUsuario(juego, sesion);
//    }
//
//    public void agregarCantJugadores(int i) {
//        controlJuego.agregarCantJugadores(i);
//    }
//
//    public void agregarMontoBase(double i) {
//        controlJuego.agregarMontoBase(i);
//
//    }
//
//    public int obtenerCantJugadores() {
//        return controlJuego.getLimiteJugadores();
//    }
//
//    public double obtenerMontoBase() {
//        return controlJuego.getMontoBase();
//    }
    public ArrayList<TipoApuesta> getTipoApuesta() {
        return controlMesa.getTipoApuesta();
    }

    public ArrayList<TipoEfecto> getTiposEfecto() {
        return controlMesa.getTiposEfecto();
    }

    public void agregarTipoApuesta(TipoApuesta ta) {
        controlMesa.agregarTipoApuesta(ta);
    }

    public void agregarTipoEfecto(TipoEfecto te) {
        controlMesa.agregarTipoEfecto(te);
    }

    public void agregarMesa(Mesa mesa) {
        controlMesa.agregarMesa(mesa);
    }

    public void cargarCasilleros() {
        controlMesa.cargarCasilleros();
    }

}
