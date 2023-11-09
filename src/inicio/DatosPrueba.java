package inicio;

import java.util.ArrayList;
import java.util.List;
import logica.mesa.Mesa;
import logica.Sistema;
import logica.usuario.Usuario;
import logica.usuario.UsuarioCrupier;
import logica.usuario.UsuarioJugador;

public class DatosPrueba {

    public static void cargar() {
        Sistema logica = Sistema.getInstancia();

        logica.agregarUsuario(new UsuarioCrupier("14255657", "123456", "Carlos Estevez", new Mesa()));
        logica.agregarUsuario(new UsuarioCrupier("24566588", "123321", "Fernando Tegrira", new Mesa()));
        
        logica.agregarUsuario(new UsuarioJugador("45784788", "1234", "Juan Pedreira", 1000));
        
        logica.agregarUsuario(new UsuarioJugador("54254781", "1234", "Player1", 1000));
        logica.agregarUsuario(new UsuarioJugador("54254782" ,"1234", "Player2", 2000));
        logica.agregarUsuario(new UsuarioJugador("54254783" ,"1234", "Player3", 20));
        logica.agregarUsuario(new UsuarioJugador("54254784" ,"1234", "Player4", 4000));
        logica.agregarUsuario(new UsuarioJugador("54254785" ,"1234", "Player5", 5000));
        logica.agregarUsuario(new UsuarioJugador("54254786" ,"1234", "Player6", 6000));

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
