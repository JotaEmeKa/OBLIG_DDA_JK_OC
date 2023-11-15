package obligatorio.JKOC.controllers;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.common.Observador;
import obligatorio.JKOC.dominio.Agenda;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.dominio.Jugador;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.ui.AgendaVista;

public class AgendaVistaControlador extends VistaBaseControlador<AgendaVista, Agenda> implements Observador {

    private Sesion sesion;

    public AgendaVistaControlador(AgendaVista vista, Agenda modelo) {
        super(vista,modelo);
        modelo.agregar(this);

        iniciarSesion(modelo.getUsuario());
    }

    private void iniciarSesion(Jugador usuario) {
        sesion = new Sesion(usuario, new Date());
        Sistema.getInstance().iniciar(sesion);
    }

    public void crearContacto(Contacto contacto) {
        try {
            modelo.agregar(contacto);
            // Aqui he decidido refrescar la lista de contactos con el filtro que este en este momento.
            // Solo si el nuevo contacto cumple el criterio de busqueda aparecera en el listado.
        } catch (ContactoInvalidoException | TelefonoInvalidoException ex) {
            Logger.getLogger(AgendaVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
            vista.mostrarMensajeDeError(ex.getMessage());
        }
    }

    public void contactoSeleccionado(Contacto contacto) {
        this.vista.mostrarDetalleContacto(contacto);
    }

    public void buscarContacto(String criterio) {
        var contactos = modelo.buscarContactos(criterio);
        vista.mostrarContactos(contactos);
    }

    public void logout() {
        Sistema.getInstance().cerrar(sesion);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.AGENDA_NUEVO_CONTACTO_AGREGADO.equals(evento)) {
            buscarContacto("");
        }
    }

    public void mostrarVistaNuevoGrupo() {
        vista.mostrarDialogoNuevoGrupoDeContactos(modelo);
    }

    @Override
    protected void inicializarVista() {
        var fachada = Sistema.getInstance();
        //vista.mostrarTiposDeContacto(fachada.getTiposContacto());
        //vista.mostrarTiposDeTelefno(fachada.getTiposTelefono());
        vista.mostrarResumenDeInformacion(modelo);
        vista.mostrarContactos(modelo.getContactos());
    }

}
