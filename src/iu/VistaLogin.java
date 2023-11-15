
package iu;

import iu.VistaBase;
import logica.usuario.Sesion;
import logica.usuario.Usuario;

public interface VistaLogin extends VistaBase{
//     public void mostrarTitulo(String titulo);
//     public void mostrarError(String mensaje);
//     public void mostrarProximaInterfaz(Sesion sesion);
//     public void limpiarDatos();
//     public void cerrar();

    public void ejecutarCasoDeUsoInicial(Sesion usuario);

    public void cerrarVentana();
}
