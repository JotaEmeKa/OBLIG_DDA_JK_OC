package iu.controladores;

import iu.VistaLobby;
import java.util.ArrayList;
import logica.Sistema;
import logica.mesa.Mesa;
import logica.mesa.Ronda;
import logica.mesa.TipoApuesta;
import logica.usuario.Sesion;
import logica.usuario.UsuarioCrupier;
import utilidades.EventoJuego;
import utilidades.Observable;
import utilidades.Observador;

public class LobbyVistaControlador extends VistaBaseControlador<VistaLobby, Mesa> implements Observador {

    private Sesion sesion;
    private ArrayList<TipoApuesta> tipoApuestas;

    public LobbyVistaControlador(VistaLobby vista, Sesion sesion) {
        super(vista, new Mesa());
        modelo.agregar(this);
        this.sesion = sesion;
        //mostrarTiposDeApuesta();

        //iniciarSesion(modelo.getUsuario());
    }

    public void mostrarTiposDeApuesta() {
        tipoApuestas = Sistema.getInstancia().getTipoApuesta();
        vista.mostrarTiposApuesta(tipoApuestas);

    }

//    private void iniciarSesion(Usuario usuario) {
//        sesion = new Sesion(usuario, new Date());
//        Sistema.getInstancia().iniciar(sesion);
//    }
//
//    public void crearContacto(Contacto contacto) {
//        try {
//            modelo.agregar(contacto);
//            // Aqui he decidido refrescar la lista de contactos con el filtro que este en este momento.
//            // Solo si el nuevo contacto cumple el criterio de busqueda aparecera en el listado.
//        } catch (ContactoInvalidoException | TelefonoInvalidoException ex) {
//            Logger.getLogger(JuegoVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
//            vista.mostrarMensajeDeError(ex.getMessage());
//        }
//    }
//
//    public void contactoSeleccionado(Contacto contacto) {
//        this.vista.mostrarDetalleContacto(contacto);
//    }
//
//    public void buscarContacto(String criterio) {
//        var contactos = modelo.buscarContactos(criterio);
//        vista.mostrarContactos(contactos);
//    }
//
//    public void logout() {
//        FachadaServicios.getInstance().cerrar(sesion);
//    }
//
//
//    public void mostrarVistaNuevoGrupo() {
//        vista.mostrarDialogoNuevoGrupoDeContactos(modelo);
//    }
    @Override
    protected void inicializarVista() {
        Sistema logica = Sistema.getInstancia();
        vista.mostrarTiposApuesta(logica.getTipoApuesta());
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventoJuego.INGRESO_JUGADOR.equals(evento)) {
            //Chequea el state da la mesa por si puede entrar o no y lo deja en espera
            //buscarContacto("");
        }
    }

    public void crearMesa(ArrayList<TipoApuesta> ta) {
        Mesa mesa = new Mesa((UsuarioCrupier) sesion.getUsuario(), new Ronda());
        mesa.agregarTiposApuesta(ta);
        Sistema.getInstancia().agregarMesa(mesa);
        vista.mostrarProximaInterfaz(mesa);
        vista.cerrarVentana();
    }

}
