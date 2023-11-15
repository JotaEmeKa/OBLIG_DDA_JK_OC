package obligatorio.JKOC.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import obligatorio.JKOC.common.Observable;
import obligatorio.JKOC.exceptions.AgendaException;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;

/**
 *
 * @author ddauser
 */
public class Agenda extends Observable {

    private Usuario usuario;
    private final ArrayList<Grupo> grupos = new ArrayList<>();
    /**
     * *
     * Cambie ArrayList por HashSet (y sobreescribi el equals en Contacto) para
     * validar que no se agreguen contactos repetidos.
     */
    private final HashSet<Contacto> contactos;

    public Agenda() {
        contactos = new HashSet();
    }

    public int getCantidadContactos() {
        return contactos.size();
    }

    public boolean agregar(Contacto contacto) throws ContactoInvalidoException, TelefonoInvalidoException {
        boolean agregadoOk = false;
        if (contacto.validar()) {
            agregadoOk = contactos.add(contacto);
            if (!agregadoOk) {
                throw new ContactoInvalidoException("Ya existe el contacto");
            } else {
                avisar(Eventos.AGENDA_NUEVO_CONTACTO_AGREGADO);
            }
        }
        return agregadoOk;
    }

    public void agregar(Grupo grupo) throws AgendaException {
        validarGrupoNoEstaRepetido(grupo);
        grupo.validar();
        grupos.add(grupo);
    }

    public ArrayList<Contacto> getContactos() {
        return new ArrayList<>(contactos);
    }

    public ArrayList<Contacto> buscarContactos(String criterio) {
        ArrayList<Contacto> resultados = new ArrayList();
        if (criterio.trim().isEmpty()) {
            resultados = this.getContactos();
        } else {
            for (Contacto c : contactos) {
                if (c.contiene(criterio)) {
                    resultados.add(c);
                }
            }
        }
        return resultados;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private void validarGrupoNoEstaRepetido(Grupo grupo) throws AgendaException {
        if (this.grupos.contains(grupo)) {
            throw new AgendaException("Ya existe un grupo con ese nombre");
        }
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

}
