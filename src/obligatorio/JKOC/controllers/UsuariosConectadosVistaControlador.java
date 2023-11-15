/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.JKOC.controllers;

import java.util.ArrayList;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.common.Observador;
import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.logica.FachadaServicios;
import obligatorio.JKOC.ui.UsuariosConectadosVista;

/**
 *
 * @author fadavanc
 */
public class UsuariosConectadosVistaControlador extends VistaBaseControlador<UsuariosConectadosVista, Administrador> implements Observador {

    private ArrayList<Sesion> usuariosConectados;

    public UsuariosConectadosVistaControlador(UsuariosConectadosVista vista, Administrador modelo) {
        super(vista, modelo);

        FachadaServicios.getInstance().agregar(this);

    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.AGENDA_NUEVO_CONTACTO_AGREGADO.equals(evento)
                || Eventos.LOGIN_USUARIO_AGENDA.equals(evento)
                || Eventos.LOGOUT_USUARIO_AGENDA.equals(evento)) {
            mostrarUsuariosConectados();
        }
    }

    private void mostrarDatosDelAdministrador() {
        vista.mostrarDatosDelAdministrador(modelo);
    }

    private void mostrarUsuariosConectados() {
        desSuscribirDeAgendaDeUsuariosConectados();
        usuariosConectados = FachadaServicios.getInstance().getUsuariosConectados();
        suscribirAAgendaDeUsuariosConectados();
        vista.mostrarUsuariosConectados(usuariosConectados);
    }

    private void desSuscribirDeAgendaDeUsuariosConectados() {
        if (usuariosConectados != null && !usuariosConectados.isEmpty()) {
            usuariosConectados.forEach(s -> s.getUsuario().getAgenda().remover(this));
        }
    }

    private void suscribirAAgendaDeUsuariosConectados() {
        usuariosConectados.forEach(s -> s.getUsuario().getAgenda().agregar(this));
    }

    public void cerrandoVentana() {
        desSuscribirDeAgendaDeUsuariosConectados();
        FachadaServicios.getInstance().remover(this);
    }

    @Override
    protected void inicializarVista() {
        mostrarDatosDelAdministrador();
        mostrarUsuariosConectados();
    }

}
