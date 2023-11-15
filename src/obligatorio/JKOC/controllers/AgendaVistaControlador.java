/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.ui.AgendaVista;

/**
 *
 * @author fadavanc
 */
public class AgendaVistaControlador extends VistaBaseControlador<AgendaVista, Agenda> implements Observador {

    private Sesion sesion;

    public AgendaVistaControlador(AgendaVista vista, Agenda modelo) {
        super(vista,modelo);
        modelo.agregar(this);

        iniciarSesion(modelo.getUsuario());
    }

    private void iniciarSesion(Usuario usuario) {
        sesion = new Sesion(usuario, new Date());
        FachadaServicios.getInstance().iniciar(sesion);
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
        FachadaServicios.getInstance().cerrar(sesion);
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
        var fachada = FachadaServicios.getInstance();
        vista.mostrarTiposDeContacto(fachada.getTiposContacto());
        vista.mostrarTiposDeTelefno(fachada.getTiposTelefono());
        vista.mostrarResumenDeInformacion(modelo);
        vista.mostrarContactos(modelo.getContactos());
    }

}
