package logica;

import logica.usuario.Sesion;
import logica.usuario.UsuarioCrupier;
import logica.usuario.UsuarioJugador;
import logica.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import logica.usuario.UsuarioJugador;
import utilidades.CrupierException;
import utilidades.EventoJuego;
import utilidades.Observable;
//import logica.juego.Juego;

public class ControlUsuario extends Observable {

    private List<UsuarioCrupier> usuariosCrupier = new ArrayList<>();
    private List<UsuarioJugador> usuariosJugadores = new ArrayList<>();
    private List<Sesion> logueados = new ArrayList<>();

    public List<Sesion> getLogueados() {
        return logueados;
    }

    public boolean agregarUsuarioJugador(UsuarioJugador usuarioJugador) {
        if (usuariosJugadores.contains(usuarioJugador)) {
            return false;
        }
        usuariosJugadores.add(usuarioJugador);
        return true;
    }

    public boolean agregarUsuarioCrupier(UsuarioCrupier usuarioAdministrador) {
        if (usuariosCrupier.contains(usuarioAdministrador)) {
            return false;
        }
        usuariosCrupier.add(usuarioAdministrador);
        return true;
    }

    public Sesion loginUsuarioJugador(String nombre, String password) throws CrupierException {
        Usuario usuario = login(nombre, password, usuariosJugadores);
        if (usuario == null) {
            throw new CrupierException("Credenciales incorrectas.");
        }
        UsuarioJugador usuarioJugador = (UsuarioJugador) usuario;
        //aca iria un usuarioJugador.asignarSala();
        Sesion usuarioSesion = new Sesion(usuarioJugador);
        //implementar un if que no permita que se el mismo usuario este conectado if(logueados.contains(usuarioSesion)) y chequear tambien donde se ejecuta el mostrar ventana de usuario logueado
        if (!logueados.contains(usuarioSesion)) {
            logueados.add(usuarioSesion);
        } else {
            throw new CrupierException("Acceso denegado. El usuario ya tiene una sesión activa.");
        }
        avisar(EventoJuego.INGRESO_CRUPIER);
        return usuarioSesion;
    }

    private Usuario login(String nombre, String password, List usuarios) {
        Usuario usuario = buscarUsuario(nombre, usuarios);
        if (usuario == null || !usuario.validarPassword(password)) {
            return null;
        }
        return usuario;
    }

    private Usuario buscarUsuario(String nombre, List usuarios) {
        Usuario usuario;
        for (Object object : usuarios) {
            usuario = (Usuario) object;
            if (usuario.getNombreUsuario().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }

    public Sesion loginUsuarioCrupier(String nombre, String password) throws CrupierException {
        Usuario usuario = login(nombre, password, usuariosCrupier);
        UsuarioCrupier usuarioCrupier = (UsuarioCrupier) usuario;
        Sesion usuarioSesion = new Sesion(usuarioCrupier);
        if (usuario == null) {
            throw new CrupierException("Credenciales incorrectas.");
        }
        if (!logueados.contains(usuarioSesion)) {
            logueados.add(usuarioSesion);
        } else {
            throw new CrupierException("Acceso denegado. El usuario ya tiene una sesión activa.");
        }
        avisar(EventoJuego.INGRESO_CRUPIER);
        return usuarioSesion;
    }

    public void logout(Sesion sesion) {
        if (logueados.contains(sesion)) {
            logueados.remove(sesion);
        }
        // Sistema.getInstancia().avisar(EventoSistema.LISTA_LOGUEADOS); //Hay que sacarlo de la partida, que hay que usar el actualizar, el Evento
    }

//    public void agregarJuegoUsuario(Juego juego, Sesion sesion) {
//        UsuarioJugador jugador = (UsuarioJugador) sesion.getUsuario();
//        jugador.agregarJuegoUsuario(juego);
//    }
}
