
package iu.controladores;

import iu.LoginVista;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.Usuario;
import utilidades.CrupierException;


public class LoginAdministradorVistaControlador extends LoginVistaControlador {

    public LoginAdministradorVistaControlador(LoginVista vista) {
        super(vista);
    }

    @Override
    protected Sesion loginInterno(String nombreUsuario, String password) {
        try {
            return Sistema.getInstancia().loginAdmin(nombreUsuario, password);
        } catch (CrupierException ex) {
            Logger.getLogger(LoginAdministradorVistaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   

}
