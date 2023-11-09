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
//import logica.juego.Juego;

public class ControlUsuario {

    private List<UsuarioCrupier> usuariosAdministradores = new ArrayList<>();
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

    public boolean agregarUsuarioAdmin(UsuarioCrupier usuarioAdministrador) {
        if (usuariosAdministradores.contains(usuarioAdministrador)) {
            return false;
        }
        usuariosAdministradores.add(usuarioAdministrador);
        return true;
    }

    public Sesion loginUsuarioJugador(String nombre, String password) {
        Usuario usuario = login(nombre, password, usuariosJugadores);
        if (usuario == null) {
            return null;
        }
        UsuarioJugador usuarioJugador = (UsuarioJugador) usuario;
        //aca iria un usuarioJugador.asignarSala();
        Sesion usuarioSesion = new Sesion(usuarioJugador);
        //implementar un if que no permita que se el mismo usuario este conectado if(logueados.contains(usuarioSesion)) y chequear tambien donde se ejecuta el mostrar ventana de usuario logueado
        if (!logueados.contains(usuarioSesion)) {
            logueados.add(usuarioSesion);
        }

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

    public Sesion loginUsuarioAdmin(String nombre, String password) {
        Usuario usuario = login(nombre, password, usuariosAdministradores);
        if (usuario == null) {
            return null;
        }
        UsuarioCrupier usuarioAdministrador = (UsuarioCrupier) usuario;
        Sesion usuarioSesion = new Sesion(usuarioAdministrador);
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
