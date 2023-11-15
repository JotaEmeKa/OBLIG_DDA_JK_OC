/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obligatorio.JKOC.ui;

import obligatorio.JKOC.dominio.Usuario;

/**
 *
 * @author fadavanc
 */
public interface LoginVista extends VistaBase {

    void ejecutarCasoDeUsoInicial(Usuario usuario);

    void cerrarVentana();
}
