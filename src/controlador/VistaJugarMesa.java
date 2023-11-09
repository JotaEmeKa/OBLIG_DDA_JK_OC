package controlador;

import java.util.List;
import logica.usuario.Sesion;
import logica.usuario.UsuarioJugador;

public interface VistaJugarMesa {

    public void mostrarError(String mensaje);

    public void mostrarTitulo(String titulo);

    public void jugar(Sesion usuario, List<UsuarioJugador> jugadores);

    public void mostrarNombre(String nombre);

    public void mostrarMensaje(String mensaje);

    public void repartirCartas();

    public void cerrar();

    public void mostrarMontos(List<UsuarioJugador> jugadores);

    public void mostrarLogin();

    public void mostrarMensajeConfirmacion(String mensaje, double apuesta);

    public void mostrarJugadoresList(List<UsuarioJugador> jugadores);

    public void mostrarMano(String mensaje);

}
