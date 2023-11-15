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
public class ApuestaDocena extends TipoApuesta {

    public ApuestaDocena(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esValido(String numero) {
        return numero.trim().length() == 8 && esNumerico(numero); 
    }
}
