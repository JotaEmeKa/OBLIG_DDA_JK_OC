/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.dominio;

import java.util.regex.Pattern;

/**
 *
 * @author ddauser
 */
public class TelefonoInternacional extends TipoTelefono {

    public TelefonoInternacional(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esValido(String numero) {
        numero = numero.replaceAll("\\s", "");
        return numero.matches("^(00|\\+)(\\d{10,20})$");
    }
}
