package inicio;

import java.util.ArrayList;
import java.util.List;
import logica.mesa.Mesa;
import logica.Sistema;
import logica.mesa.ApuestaColor;
import logica.mesa.ApuestaDirecta;
import logica.mesa.ApuestaDocena;
import logica.mesa.Casillero;
import logica.mesa.ModoCompleto;
import logica.mesa.ModoParcial;
import logica.mesa.ModoSimulador;
import logica.mesa.TipoApuesta;
import logica.mesa.TipoEfecto;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import logica.usuario.UsuarioJugador;

public class DatosPrueba {

    public static void cargar() {
        Sistema logica = Sistema.getInstancia();

        logica.agregarUsuario(new UsuarioCrupier("14255657", "123456", "Carlos Estevez", new Mesa()));
        logica.agregarUsuario(new UsuarioCrupier("24566588", "123321", "Fernando Tegrira", new Mesa()));
        logica.agregarUsuario(new UsuarioCrupier("12345678", "123456", "Fernando Tegrira", new Mesa()));

        logica.agregarUsuario(new UsuarioJugador("45784788", "1234", "Juan Pedreira", 1000));

        logica.agregarUsuario(new UsuarioJugador("54254781", "1234", "Player1", 1000));
        logica.agregarUsuario(new UsuarioJugador("54254782", "1234", "Player2", 2000));
        logica.agregarUsuario(new UsuarioJugador("54254783", "1234", "Player3", 20));
        logica.agregarUsuario(new UsuarioJugador("54254784", "1234", "Player4", 4000));
        logica.agregarUsuario(new UsuarioJugador("54254785", "1234", "Player5", 5000));
        logica.agregarUsuario(new UsuarioJugador("54254786", "1234", "Player6", 6000));

        TipoApuesta directa = new ApuestaDirecta("Apuesta Directa");
        TipoApuesta color = new ApuestaColor("Apuesta Color");
        TipoApuesta docena = new ApuestaDocena("Apuesta Docena");
        
        TipoEfecto completo = new ModoCompleto("Modo Completo");
        TipoEfecto parcial = new ModoParcial("Modo Parcial");
        TipoEfecto simulado = new ModoSimulador("Modo Simulador");
        
        
        logica.agregarTipoApuesta(directa);
        logica.agregarTipoApuesta(color);
        logica.agregarTipoApuesta(docena);
        
        logica.agregarTipoEfecto(completo);
        logica.agregarTipoEfecto(parcial);
        logica.agregarTipoEfecto(simulado);
        
        logica.cargarCasilleros();
        

//        logica.agregarCantJugadores(2);
//        logica.agregarMontoBase(100);
//        UsuarioJugador usu = new UsuarioJugador("Player1", "1234", 10, "Bot jaime");
//        UsuarioJugador usu2 = new UsuarioJugador("Octopus", "321", 120, "Octavio Carnales");
//        List<UsuarioJugador> lista = new ArrayList<UsuarioJugador>();
//        lista.add(usu);
//        lista.add(usu2);
//        Juego juego = new Juego(2, 100, false, lista, new ArrayList<Mano>(), "Juego 1");
//        logica.agregarJuego(juego);
//
//        List<Juego> juegosList = new ArrayList<Juego>();
//        juegosList.add(juego);
//        logica.agregarMazo();
    }
}
