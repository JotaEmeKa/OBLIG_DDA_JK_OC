/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obligatorio.JKOC.ui;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.Grupo;

/**
 *
 * @author fadavanc
 */
public interface NuevoGrupoDeContactosVista extends VistaBase{

    void mostrarContactos(ArrayList<Contacto> contactos);

    void mostrarGrupos(ArrayList<Grupo> grupos);
}
