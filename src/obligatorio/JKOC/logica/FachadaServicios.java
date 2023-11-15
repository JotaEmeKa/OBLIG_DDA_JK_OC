/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.logica;

import java.util.ArrayList;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.common.Observador;
import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;
import obligatorio.JKOC.dominio.Usuario;

/**
 *
 * @author ddauser
 */
public class FachadaServicios extends Observable implements Observador {

    private static FachadaServicios instance;
    private ServicioAgenda servicioAgenda;
    private ServicioUsuario servicioUsuario;

    private FachadaServicios() {
        servicioAgenda = new ServicioAgenda();
        servicioUsuario = new ServicioUsuario();
        servicioUsuario.agregar(this);
    }

    public synchronized static FachadaServicios getInstance() {
        if (instance == null) {
            instance = new FachadaServicios();
        }
        return instance;
    }

    public void agregar(TipoContacto tipoContacto) {
        servicioAgenda.agregar(tipoContacto);
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return servicioAgenda.getTiposContacto();
    }

    public void agregar(Usuario usuario) {
        servicioUsuario.agregar(usuario);
    }

    public void agregar(Administrador administrador) {
        servicioUsuario.agregar(administrador);
    }

    public Usuario loginUsuario(String usuario, String password) {
        return servicioUsuario.loginUsuario(usuario, password);
    }

    public Administrador loginAdministrador(String usuario, String password) {
        return servicioUsuario.loginAdministrador(usuario, password);
    }

    public void iniciar(Sesion sesion) {
        servicioUsuario.iniciar(sesion);
    }

    public void cerrar(Sesion sesion) {
        servicioUsuario.cerrar(sesion);
    }

    public ArrayList<Sesion> getUsuariosConectados() {
        return servicioUsuario.getUsuariosConectados();
    }

    public void agregar(TipoTelefono tipoTelefono) {
        servicioAgenda.agregar(tipoTelefono);
    }

    public ArrayList<TipoTelefono> getTiposTelefono() {
        return servicioAgenda.getTiposTelefono();
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (Eventos.LOGIN_USUARIO_AGENDA.equals(evento) || Eventos.LOGOUT_USUARIO_AGENDA.equals(evento)) {
            avisar(evento);
        }
    }
}
