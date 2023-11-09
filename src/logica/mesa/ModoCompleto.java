/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.mesa;

/**
 *
 * @author ddauser
 */
public class ModoCompleto extends TipoEfecto {

    public ModoCompleto(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esValido(String numero) {
        return numero.trim().length() == 8 && esNumerico(numero); 
    }
}
