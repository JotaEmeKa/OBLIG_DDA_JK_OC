/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.dominio;

/**
 *
 * @author ddauser
 */
public class TelefonoCelular extends TipoTelefono {

    public TelefonoCelular(String nombre) {
        super(nombre);
    }
    
    @Override
    public boolean esValido(String numero) {
        return numero.startsWith("09")&& numero.length() == 9 && esNumerico(numero);
    }
}
