package iu;

import java.util.ArrayList;
import logica.mesa.Mesa;
import logica.mesa.TipoApuesta;
import logica.usuario.Sesion;
import logica.usuario.Usuario;

public interface VistaLobby extends VistaBase{

//    public void mostrarTitulo(String titulo);
//
//    public void mostrarError(String mensaje);
//
    public void mostrarProximaInterfaz(Mesa mesa);
//
//    public void limpiarDatos();
//
//    public void cerrar();

    public void ejecutarCasoDeUsoInicial(Sesion sesion);

    public void cerrarVentana();

    public void mostrarTiposApuesta(ArrayList<TipoApuesta> tipoApuestas);
}
