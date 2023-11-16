package iu.controladores;

import iu.VistaJugarMesa;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.mesa.Casillero;
import logica.mesa.Mesa;
import logica.mesa.Ronda;
import logica.mesa.TipoEfecto;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import utilidades.EventoJuego;
import utilidades.Observable;
import utilidades.Observador;

public class MesaCrupierVistaControlador extends VistaBaseControlador<VistaJugarMesa, Mesa> implements Observador {

    private Sesion sesion;
    private ArrayList<Usuario> jugadores;
    private Mesa mesa;
    private ArrayList<Ronda> rondas;

    public MesaCrupierVistaControlador(VistaJugarMesa vista, Mesa modelo) {
        super(vista, modelo);
        modelo.agregar(this);
        //iniciarSesion(modelo.getUsuario());
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
    public void lanzarBola(TipoEfecto te, Mesa mesa) {
        this.mesa = mesa;
        this.rondas = mesa.getRondas();
        if (!rondas.isEmpty()) {
            Ronda ultimaRonda = rondas.get(rondas.size()-1);
            Casillero casillero = ultimaRonda.hacerSorteo(te, mesa);
            vista.mostrarNumeroSorteado(casillero);
        }
    }

    @Override
    protected void inicializarVista() {

        ArrayList<TipoEfecto> tipos = Sistema.getInstancia().getTiposEfecto();
        vista.mostrarDatosIniciales(tipos);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventoJuego.INGRESO_JUGADOR.equals(evento)) {
            //Chequea el state da la mesa por si puede entrar o no y lo deja en espera
            //buscarContacto("");
        }
    }

}
