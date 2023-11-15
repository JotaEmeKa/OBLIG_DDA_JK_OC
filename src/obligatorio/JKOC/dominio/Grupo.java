/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio.JKOC.dominio;

import java.util.ArrayList;
import java.util.Objects;
import obligatorio.JKOC.exceptions.AgendaException;

/**
 *
 * @author fadavanc
 */
public class Grupo {

    private final String nombre;
    private final ArrayList<Contacto> contactos = new ArrayList<>();

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void agregar(Contacto contacto) throws AgendaException {
        if (existe(contacto)) {
            throw new AgendaException("Ya existe ese contacto en este grupo");
        } else {
            contactos.add(contacto);
        }
    }

    public void validar() throws AgendaException {
        validarNombre();
        validarCantidadDeContactos();
    }

    private boolean existe(Contacto contacto) {

        //return contactos.contains(this);
        boolean existe = false;
        for (Contacto c : contactos) {
            if (c.equals(contacto)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    private void validarNombre() throws AgendaException {
        if (nombre == null || nombre.isBlank()) {
            throw new AgendaException("Debe ingresar un nombre para el grupo");
        }
    }

    private void validarCantidadDeContactos() throws AgendaException {
        if (getCantidadDeContactos() < 2) {
            throw new AgendaException("El grupo debe tener al menos 2 contactos");
        }
    }

    public int getCantidadDeContactos() {
        return contactos.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        return Objects.equals(this.nombre, other.nombre);

    }

}
