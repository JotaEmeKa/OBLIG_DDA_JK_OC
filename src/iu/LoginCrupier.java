
package iu;

import java.awt.Frame;
import logica.Sistema;
import logica.usuario.Sesion;
import logica.usuario.UsuarioCrupier;


public class LoginCrupier extends Login{

    public LoginCrupier(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public Sesion hacerLogin(String nombre, String password) {
          return Sistema.getInstancia().loginUsuarioAdmin(nombre, password);
    }

//    @Override
//    public void mostrarProximaInterfaz(Sesion sesion) {
//       MonitorearJuegos verUsuariosConectados = new MonitorearJuegos(null, false,(UsuarioAdmin)sesion.getUsuario());
//       verUsuariosConectados.setVisible(true);
//       verUsuariosConectados.setLocationRelativeTo(this);
//    }
//    

    @Override
    public void mostrarProximaInterfaz(Sesion sesion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
