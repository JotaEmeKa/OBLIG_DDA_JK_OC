/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.dominio;

import obligatorio.JKOC.exceptions.TelefonoInvalidoException;

/**
 *
 * @author ddauser
 */
public class Telefono {

    private String numero;
    private TipoTelefono tipoTelefono;

    public Telefono() {
    }

    public Telefono(String numero, TipoTelefono tipoTelefono) {
        this.numero = numero;
        this.tipoTelefono = tipoTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public void esValido() throws TelefonoInvalidoException {

        if (numero == null || tipoTelefono == null
                || (tipoTelefono != null && !tipoTelefono.esValido(numero))) {
            throw new TelefonoInvalidoException("Numero incorrecto para un teléfono " + tipoTelefono.getNombre());
        }
    }
}
