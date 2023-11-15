package iu.controladores;

import iu.VistaJugarMesa;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.mesa.Mesa;
import logica.usuario.Sesion;
import utilidades.EventoJuego;
import utilidades.Observable;
import utilidades.Observador;

public class JuegoVistaControlador extends VistaBaseControlador<VistaJugarMesa, Mesa> implements Observador {

    private Sesion sesion;

    public JuegoVistaControlador(VistaJugarMesa vista, Mesa modelo) {
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
    @Override
    protected void inicializarVista() {
        var fachada = Sistema.getInstancia();
//        vista.mostrarTiposDeContacto(fachada.getTiposContacto());
//        vista.mostrarTiposDeTelefno(fachada.getTiposTelefono());
//        vista.mostrarResumenDeInformacion(modelo);
//        vista.mostrarContactos(modelo.getContactos());
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventoJuego.INGRESO_JUGADOR.equals(evento)) {
            //Chequea el state da la mesa por si puede entrar o no y lo deja en espera
            //buscarContacto("");
        }
    }
}