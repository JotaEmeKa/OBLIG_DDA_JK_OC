
package controlador;

import logica.usuario.Sesion;

public interface VistaLogin {
     public void mostrarTitulo(String titulo);
     public void mostrarError(String mensaje);
     public void mostrarProximaInterfaz(Sesion sesion);
     public void limpiarDatos();
     public void cerrar();
}
