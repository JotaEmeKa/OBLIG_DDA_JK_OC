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
public abstract class TipoApuesta {
    
    private String nombre;

    public TipoApuesta(String nombre) {
        this.nombre = nombre;
    }
    

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }
    
    protected boolean esNumerico(String numero) {
        try {
            Long.parseLong(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    } 
   
    public abstract boolean esValido(String numero);
}
