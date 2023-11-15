/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obligatorio.JKOC.ui;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.Sesion;

/**
 *
 * @author fadavanc
 */
public interface UsuariosConectadosVista extends VistaBase {

    void mostrarDatosDelAdministrador(Administrador administrador);

    void mostrarUsuariosConectados(ArrayList<Sesion> usuariosConectados);
}
