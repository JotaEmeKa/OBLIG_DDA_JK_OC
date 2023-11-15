/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.JKOC.controllers;

import java.util.ArrayList;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.common.Observador;
import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.logica.Sistema;
import obligatorio.JKOC.ui.UsuariosConectadosVista;

/**
 *
 * @author fadavanc
 */
public class UsuariosConectadosVistaControlador extends VistaBaseControlador<UsuariosConectadosVista, Crupier> implements Observador {

    private ArrayList<Sesion> usuariosConectados;

    public UsuariosConectadosVistaControlador(UsuariosConectadosVista vista, Crupier modelo) {
        super(vista, modelo);

        Sistema.getInstance().agregar(this);

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
        usuariosConectados = Sistema.getInstance().getUsuariosConectados();
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
        Sistema.getInstance().remover(this);
    }

    @Override
    protected void inicializarVista() {
        mostrarDatosDelAdministrador();
        mostrarUsuariosConectados();
    }

}
