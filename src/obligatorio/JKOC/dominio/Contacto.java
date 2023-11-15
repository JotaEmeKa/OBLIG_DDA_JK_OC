/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.dominio;

import java.util.Objects;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;

/**
 *
 * @author ddauser
 */
public class Contacto {

    private String nombre;
    private Telefono telefono;
    private TipoContacto tipoContacto;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public TipoContacto getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(TipoContacto tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public boolean validar() throws ContactoInvalidoException, TelefonoInvalidoException {
        if (!esNombreValido()) {
            throw new ContactoInvalidoException("Falta el nombre del contacto");
        }

        esTelefonoValido();
        
        return esNombreValido() && esTipoContactoValido();
    }

    private boolean esNombreValido() {
        return this.getNombre() != null && !this.getNombre().trim().isEmpty();
    }

    private void esTelefonoValido() throws TelefonoInvalidoException {
        getTelefono().esValido();
    }

    private boolean esTipoContactoValido() {
        return this.getTipoContacto() != null;
    }

    public boolean contiene(String criterio) {
        // TODO: getTelefon().getNumero().contains... seria mejor delegarlo a Telefono (ahi puede considerar ignorar espacios en blanco, prefijo, etc.)
        if (this.getNombre().toUpperCase().contains(criterio.toUpperCase())
                || this.getTelefono().getNumero().contains(criterio)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        // Si se compara con si mismo, devuelve true  
        if (o == this) {
            return true;
        }

        // Verifica que el objeto sea Contacto
        if (!(o instanceof Contacto)) {
            return false;
        }

        // Castea el parametro y compara por nombre.
        Contacto c = (Contacto) o;
        return this.getNombre() != null && this.getNombre().equals(c.getNombre());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
