/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.logica;

import java.util.ArrayList;
import java.util.Date;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.Eventos;
import obligatorio.JKOC.dominio.Sesion;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.dominio.UsuarioGenerico;

/**
 *
 * @author ddauser
 */
class ServicioUsuario extends Observable {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Administrador> administradores;
    private ArrayList<Sesion> usuariosConectados;

    public ServicioUsuario() {
        usuarios = new ArrayList();
        administradores = new ArrayList();
        usuariosConectados = new ArrayList();
    }

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregar(Administrador administrador) {
        administradores.add(administrador);
    }

    public void iniciar(Sesion sesion) {
        usuariosConectados.add(sesion);
        avisar(Eventos.LOGIN_USUARIO_AGENDA);
    }

    public void cerrar(Sesion sesion) {
        usuariosConectados.remove(sesion);
        avisar(Eventos.LOGOUT_USUARIO_AGENDA);
    }

    public ArrayList<Sesion> getUsuariosConectados() {
        return usuariosConectados;
    }

    public Usuario loginUsuario(String usuario, String password) {
        return (Usuario) loginGenerico(usuario, password, (ArrayList) usuarios);
    }

    public Administrador loginAdministrador(String usuario, String password) {
        return (Administrador) loginGenerico(usuario, password, (ArrayList) administradores);
    }

    private UsuarioGenerico loginGenerico(String usuario, String password, ArrayList<UsuarioGenerico> listaUsuarios) {
        for (UsuarioGenerico u : listaUsuarios) {
            if (u.getUsuario().equals(usuario) && u.esPassordValida(password)) {
                return u;
            }
        }
        return null;
    }
}
