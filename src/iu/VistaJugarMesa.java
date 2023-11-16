package iu;

import java.util.ArrayList;
import java.util.List;
import logica.mesa.Casillero;
import logica.mesa.Mesa;
import logica.mesa.TipoEfecto;
import logica.usuario.Sesion;
import logica.usuario.UsuarioJugador;

public interface VistaJugarMesa extends VistaBase{

    public void mostrarError(String mensaje);

    public void mostrarTitulo(String titulo);

    public void jugar(Sesion usuario, List<UsuarioJugador> jugadores);

    public void mostrarNombre(String nombre);

    public void mostrarMensaje(String mensaje);

    public void lanzarBola();

    public void cerrar();

    public void mostrarMontos(List<UsuarioJugador> jugadores);

//    public void mostrarLogin();
//
//    public void mostrarMensajeConfirmacion(String mensaje, double apuesta);
//
//    public void mostrarJugadoresList(List<UsuarioJugador> jugadores);

    public void mostrarNumeroSorteado(Casillero casillero);

    public void mostrarDatosIniciales(ArrayList<TipoEfecto> tipos);

}
