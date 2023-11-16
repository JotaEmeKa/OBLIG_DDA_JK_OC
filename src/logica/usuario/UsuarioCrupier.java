

package logica.usuario;

import logica.mesa.Mesa;


public class UsuarioCrupier extends Usuario{
    
    Mesa mesa;
    
    public UsuarioCrupier(String cedula, String password,String nombreCompleto, Mesa mesa) {
        super(cedula, password,nombreCompleto);
        this.mesa = mesa;
    }

    public Mesa getMesa() {
        return mesa;
    }
    
    
    
    
}
