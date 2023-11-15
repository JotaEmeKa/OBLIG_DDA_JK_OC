package controlador;

import iu.VistaJugarMesa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.Sistema;
import utilidades.EventoJuego;
import logica.mesa.Mesa;
import logica.mesa.Ronda;
import logica.mesa.TipoEfecto;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import logica.usuario.UsuarioJugador;
import utilidades.Observable;
import utilidades.Observador;
import utilidades.RuletaException;

public class ControladorJuego implements Observador {

    private VistaJugarMesa vista;
    private Sistema modelo = Sistema.getInstancia();
    private List<UsuarioJugador> jugadores = new ArrayList<UsuarioJugador>(); //esto esta mal porque tenemos una lista de juegos de los cuales obtenemos los jugadores.
    private List<Mesa> juegos = new ArrayList<Mesa>();//aca poner modelo.listarJuegos();
    private Mesa mesa;

    private Sesion sesion;
    //private UsuarioJugador usuJugador = (UsuarioJugador) sesion.getUsuario();

    public ControladorJuego(VistaJugarMesa vista, Sesion sesion) {
        this.vista = vista;
        this.sesion = sesion;
        Usuario usuJugador = (UsuarioJugador) sesion.getUsuario();//obtengo el usuario

        //agregarJugador();
        vista.mostrarTitulo(usuJugador.getNombreCompleto()); //muestro el titulo

        modelo.agregar(this);
    }

    public Mesa getJuego() {
        return mesa;
    }

    public Sesion getSesion() {
        return sesion;
    }

//    public int getIdJuego() {
//        return idJuego;
//    }
//    private void buscarPartidas() {
//        vista.mostrarMensaje("Buscando partida... Espere un momento.");
//        List<Juego> juegos = modelo.listarJuegos();
//        for (Juego partida : juegos) {
//            if (!partida.isEmpezo() && limiteJugadores(partida.getJugadores())) {
//                // this.setVisible(false); //quiero sacar la pantalla
//                vista.jugar(sesion, jugadores);
//            }
//        }
//    }
//
//    private boolean limiteJugadores(List<UsuarioJugador> jugadores) { //esto retorna una excepcion
//        if (jugadores.size() > 1 && jugadores.size() < 6) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public void jugar() {
        this.jugadores = obtenerListaJugadores();
        vista.jugar(sesion, jugadores);
    }

    @Override
    public void actualizar(Observable origen, Object event) {
        if (event.equals(EventoJuego.INGRESO_JUGADOR)) {
            //hacer un metodo para obtener la lista de los jugadores de ese MISMO juego jasdja
            String mensaje = obtenerListaDeEspera();
            //vista.jugar(sesion, jugadores);
            vista.mostrarMensaje(mensaje);
            //vista.mostrarBotones(jugadores);
        }
        if (event.equals(EventoJuego.EMPEZO_JUEGO)) {
            vista.repartirCartas();
            vista.mostrarMontos(jugadores);
            vista.mostrarJugadoresList(jugadores);
            chequearCartas();
        }
        if (event.equals(EventoJuego.NUEVA_RONDA)) {
            //vista.repartirCartas();
            vista.mostrarMontos(jugadores);
        }
        if (event.equals(EventoJuego.ABANDONO_JUEGO)) {
            String mensaje = abandonoJuego();
            vista.mostrarMensaje(mensaje);
            vista.mostrarJugadoresList(jugadores);
        }
        if (event.equals(EventoJuego.NUEVA_APUESTA)) {
            UsuarioJugador jugadorSesion = (UsuarioJugador) this.sesion.getUsuario();
            UsuarioJugador jugadorQueAposto = jugadorSesion;

            for (UsuarioJugador jugador : jugadores) {
//                if (jugador.isAposto()) { //ver con states
//                    jugadorQueAposto = jugador;
//                }
            }
            if (jugadorQueAposto != jugadorSesion) {
                //String mensaje = jugadorQueAposto.getNombreCompleto() + " ya ha apostado por " + jugadorQueAposto.getApuesta() + ". Confirme o pase."; // hay que cambiarlo por el true
                //vista.mostrarMensajeConfirmacion(mensaje, jugadorQueAposto.getApuesta());
            }
            vista.mostrarMontos(jugadores);
        }
    }

    public Mesa crearJuego() throws RuletaException {
        this.juegos = modelo.listarMesas();
        //double montoBase = modelo.obtenerMontoBase();
        //int limiteJugadores = modelo.obtenerCantJugadores();
        //Mazo mazo = modelo.agregarMazo();

        //usuJugador
        UsuarioJugador jugador = (UsuarioJugador) this.sesion.getUsuario();
        if (this.juegos.size() == 0) {
            // jugadores.add(jugador);
            Mesa juegoNuevo = new Mesa();
            //Mano mano = new Mano(mazo); //
            Ronda ronda = new Ronda();

            //Ronda.setApuesta(montoBase * limiteJugadores);
            juegoNuevo.getRondas().add(ronda);
            modelo.agregarMesa(juegoNuevo);
//            try {
                if (limiteJugadores(juegoNuevo)) {
//                    modelo.agregarJugadorMesa(sesion, juegoNuevo);
//                    modelo.agregarMesaUsuario(juegoNuevo, sesion);
//                    this.juego = juegoNuevo;
//                    cobrarIngreso(juegoNuevo);
//                }

//            } catch (RuletaException ex) {
//                vista.mostrarError(ex.getMessage());
//            }
            return juegoNuevo;
        } else {
            for (Mesa mesa : juegos) {
//                if (mesa.isEmpezo() && jugadorEnJuego(mesa)) {
//
//                    if (jugadorEnEspera(jugador)) {
//                        vista.mostrarError("El jugador ya esta esperando en una partida");
//                        vista.cerrar();
//                    } else {
//                        //  jugadores.add(jugador);
////                        Juego juegoNuevo = new Juego(limiteJugadores, montoBase, false, jugadores, new ArrayList<Mano>(), "Juego"); //esto tambien esta mal jasfjas//esta bien banana
////                        Mano mano = new Mano(mazo);
////                        mano.setApuesta(montoBase * limiteJugadores);
////
////                        juegoNuevo.getManos().add(mano);
////                        modelo.agregarJuego(juegoNuevo);
////                        //this.juegos.add(juegoNuevo);
////                        try {
////                            modelo.agregarJugadorJuego(sesion, juegoNuevo);
////                            modelo.agregarJuegoUsuario(juegoNuevo, sesion);
////                            this.juego = juegoNuevo;
////                            cobrarIngreso(juegoNuevo);
////                            // this.jugadores = juegoNuevo.getJugadores();
////                        } catch (JuegoException ex) {
////                            vista.mostrarError(ex.getMessage());
////                        }
//                        return juegoNuevo;
//                    }
//
//                } else {
////                    try {
////                        if (limiteJugadores(mesa)) {
////                            modelo.agregarJugadorJuego(sesion, mesa);
////                            modelo.agregarJuegoUsuario(mesa, sesion);
////                            this.juego = mesa;
////                            cobrarIngreso(mesa);
////                        } //else {
////                        // juego.setEmpezo(true);
////                        //}
////                        //this.jugadores.add(jugador);
////                        // modelo.agregarJugadorJuego(sesion, juego);
////                        // modelo.agregarJuegoUsuario(juego, sesion);
////                    } catch (JuegoException ex) {
////                        vista.mostrarError(ex.getMessage());
////                    }
//                    return mesa;
//                }
            }
        }
        //this.jugadores = modelo.obtenerJugadores();
    }
        return null;
}
    public boolean jugadorEnJuego(Mesa juegoYaCreado) {
        //usuJugador
        UsuarioJugador jugador = (UsuarioJugador) this.sesion.getUsuario();
        List<Mesa> juegosUsuario = jugador.getMesas();
        for (Mesa juego : juegosUsuario) {
            if (juegoYaCreado.equals(juego)) {
                return true;
            }
        }
        return false;
    }

    private List<UsuarioJugador> obtenerListaJugadores() {
        this.juegos = modelo.listarMesas();
        for (Mesa partida : juegos) {
//            if (!partida.isEmpezo()) {
//                if (limiteJugadores(partida)) {
//                    return partida.getJugadores();
//                } else {
//                    return partida.getJugadores();
//                }
//
//            }
        }
        return this.jugadores;
    }

    public boolean limiteJugadores(Mesa mesa) { //esto retorna una excepcion
//        if (mesa.getJugadores().size() < mesa.getLimiteJugadores()) {
//            return true;
//        } else {
//            jumesaego.setEmpezo(true);
//            modelo.avisar(EventoJuego.EMPEZO_JUEGO);
//            return false;
//        
return true;
    }

    private String obtenerListaDeEspera() {
        String mensaje = "";
        //usuJugador
        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
        for (Mesa mesa : this.juegos) {
//            if (mesa.getJugadores().size() == mesa.getLimiteJugadores()) {
//                return mensaje;
//            }
//            else if (juego.getJugadores().size() == 1 && juego.isEmpezo()) {
//                Mano mano = juego.getManos().get(juego.getManos().size() - 1);
//                vista.mostrarMensaje("Haz ganado!!!");
//                usu.setSaldo(mano.getApuesta());
//            }
            if (mesa.getJugadores().contains(usu)) {
                this.jugadores = mesa.getJugadores();
                int restantes = mesa.getLimiteJugadores() - jugadores.size();
                mensaje = "Esperando " + restantes + " jugadores mas...";
                return mensaje;
            }

        }
        return mensaje;
    }

    private boolean jugadorEnEspera(UsuarioJugador jugador) {
        for (Mesa mesa : jugador.getMesas()) {
//            if (!mesa.isEmpezo()) { //Ver con states
//                return true;
//            }
        }
        return false;
    }

    public void jugarMano() {

    }

    public void cobrarIngreso(Mesa juego) {
        //double montoBase = juego.getMontoBase();
       // int size = juego.getManos().size();
        //Mano mano = juego.getManos().get(size - 1);
        //mano.descontarSaldoBase(sesion, montoBase);
    }

    public void aumentarApuesta(boolean esDoble) {
//        Mano mano = juego.getManos().get(juego.getManos().size() - 1);
//        if (mano.isSePuedeApostar()) {
//            double menorSaldo = saldoMinimoDeJugadores();
//            UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//            double apuestaUsu = usu.getApuesta();
//
//            if (apuestaUsu >= menorSaldo) {
//                usu.setApuesta(menorSaldo);
//                vista.mostrarMensaje("El máximo por saldo de jugadores es $ " + menorSaldo);
//            } else {
//                //usuJugador
//                apuestaUsu += 50;
//                if (usu.getSaldo() < apuestaUsu) {
//                    vista.mostrarMensaje("Su saldo es menor a su apuesta.");
//                } else if (!esDoble) {
//                    vista.mostrarMensaje("Apostar $ " + apuestaUsu + " ? Presione Confirmar.");
//                    usu.setApuesta(apuestaUsu);
//                } else {
//                    vista.mostrarMensaje("Apostar $  " + apuestaUsu + " ? Presione Confirmar.");
//                    usu.setApuesta(apuestaUsu);
//                }
//            }
//        } else {
//            rechazarSegundaApuesta();
//        }
    }

    public void reducirApuesta(boolean esDoble) {
//        Mano mano = juego.getManos().get(juego.getManos().size() - 1);
//
//        if (mano.isSePuedeApostar()) {
//            //usuJugador
//            UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//            double contador = usu.getApuesta();
//            contador -= 50;
//            if (contador <= 0) {
//                vista.mostrarMensaje("Si no desea apostar, presione pasar.");
//                contador = 0;
//                usu.setApuesta(contador);
//            } else if (!esDoble) {
//                vista.mostrarMensaje(" Apostar $ " + contador + " ? Presione Confirmar.");
//                usu.setApuesta(contador);
//            } else {
//                vista.mostrarMensaje("Apostar $  " + contador + " ? Presione Confirmar.");
//                usu.setApuesta(contador);
//            }
//        } else {
//            rechazarSegundaApuesta();
//        }
    }

    public void allIn() {
//        Mano mano = juego.getManos().get(juego.getManos().size() - 1);
//
//        if (mano.isSePuedeApostar()) {
//            UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//            double saldo = usu.getSaldo();
//            double menorSaldo = saldoMinimoDeJugadores();
//
//            if (saldo > menorSaldo) {
//                usu.setApuesta(menorSaldo);
//                vista.mostrarMensaje("El máximo por saldo de jugadores es $ " + menorSaldo);
//            } else {
//                vista.mostrarMensaje("All In por $  " + saldo + " ? Presione Confirmar.");
//                usu.setApuesta(saldo);
//            }
//        } else {
//            rechazarSegundaApuesta();
//        }
    }

    public void confirmarApuesta() {

//        int size = this.juego.getManos().size();
//        Mano mano = juego.getManos().get(size - 1);
//        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//        double apuestaUsu = usu.getApuesta();
//        if (mano.isSePuedeApostar()) {
//            if (apuestaUsu == 0) {
//                vista.mostrarMensaje("Debe apostar para confirmar o bien pasar.");
//            } else {
//                mano.descontarSaldoApuesta(sesion, apuestaUsu);
//                mano.setSePuedeApostar(false);
//                double apuestas = mano.getApuesta();
//                usu.setAposto(true);
//                mano.setApuesta(apuestaUsu + apuestas);
//                modelo.avisar(EventoJuego.NUEVA_APUESTA);
//
//            }
//        }
    }

    public void logout() {
        abandonarPartida(sesion);
        modelo.logout(sesion);
        modelo.quitar(this);
        //vista.mostrarLogin();
        modelo.avisar(EventoJuego.ABANDONO_JUEGO); //Hay que sacarlo de la partida, que hay que usar el actualizar, el Evento    }

    }

    private void abandonarPartida(Sesion sesion) {
        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
        for (Mesa juego : this.juegos) {
            if (juego.getJugadores().contains(usu)) {
                juego.getJugadores().remove(usu);
            }
//            if (juego.getJugadores().size() == 1 && !juego.isEmpezo()) {
//                //decirle que ganó y acreditarle la plata
//                //Mano mano = juego.getManos().get(juego.getManos().size() - 1);
//                //vista.mostrarMensaje("Haz ganado!!!");esto mostrarlo en otro lado para que lo vea el que queda en juego
//                usu.setSaldo(mano.getApuesta());
//            }
        }
    }

    private String abandonoJuego() {

        String mensaje = "Un jugador ha abandonado la partida."; //quiero que me muestre el msj con el nombre del que abandono la partida//mostra que alguien abandono y fue
        return mensaje;
    }

    public void acreditarMonto() {
//        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//        usu.setSaldo(juego.getManos().get(juego.getManos().size() - 1).getApuesta() + usu.getSaldo());
//        juego.getManos().get(juego.getManos().size() - 1).setApuesta(0);
//        vista.mostrarMontos(jugadores);
    }

    public void descontarApuesta(double apuesta) {
//        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
//        usu.setSaldo(usu.getSaldo() - apuesta);
//        vista.mostrarMontos(jugadores);
//        usu.setAposto(true);
    }

    private double saldoMinimoDeJugadores() {
        double saldoMinimo = Double.MAX_VALUE;
        for (UsuarioJugador jugador : jugadores) {
            if (jugador.getSaldo() < saldoMinimo) {
                saldoMinimo = jugador.getSaldo();
            }
        }
        return saldoMinimo;
    }

    private void rechazarSegundaApuesta() {
//        String nombreJugadorAposto = "";
//        double apuesta = 0;
//        for (UsuarioJugador jugador : jugadores) {
//            if (jugador.isAposto()) {
//                nombreJugadorAposto = jugador.getNombreCompleto();
//                apuesta = jugador.getApuesta();
//                vista.mostrarMensaje("Ya apostó.");
//            }
//        }
    }

    public void chequearCartas() {
        //for (UsuarioJugador jugador : jugadores) {
        UsuarioJugador usu = (UsuarioJugador) sesion.getUsuario();
        //   if (usu.equals(jugador)) {
        //Figura figura = usu.getJuegos().get(usu.getJuegos().size() - 1).getManos().get(juego.getManos().size() - 1).getFigura();
//        Figura figura = usu.getFigura();
//        List<Carta> cartas = usu.getMazoCartas();
//        figura.buscarFigura(cartas, usu);
//
//        if (figura.isColor()) {
//            //figura.setColor(true);
//            vista.mostrarMano("Tiene color.");
//        } else if (figura.isPierna()) {
//            vista.mostrarMano("Tiene pierna.");
//        } else if (figura.isPar()) {
//            vista.mostrarMano("Tiene par.");
//        } else {
//            vista.mostrarMano("Tiene como carta alta " + figura.getCartaAlta().getNumero() + " de " + figura.getCartaAlta().getPalo());
//        }
        // }
        //}

    }

    public void figuraGanadora() {
        UsuarioJugador usuJugador = (UsuarioJugador) sesion.getUsuario();

        for (UsuarioJugador jugador : jugadores) {
//            if (!jugador.equals(sesion.getUsuario())) {
//                Figura figura = jugador.getFigura();
//                Figura figuraSesion = usuJugador.getFigura();
//
//                if (figuraSesion.isPar()) {
//                    if (figura.isColor() || figura.isPierna()) {
//                        jugador.setEsGanador(true);
//                    }
//                }
//
//                if (figuraSesion.isPierna()) {
//                    if (figura.isColor()) {
//                        jugador.setEsGanador(true);
//                    } else if (figura.isPar()) {
//                        usuJugador.setEsGanador(true);
//                    }
//                }
//
//                if (figuraSesion.isColor()) {
//                    usuJugador.setEsGanador(true);
//                }
//
//            }
        }
//        if (usuJugador.isEsGanador()) {
//            //vista.mostrarMensaje("El ganador es " + usuJugador.getNombreCompleto());
//            Sistema.getInstancia().avisar(EventoJuego.GANADOR);
//        }
    }
}
