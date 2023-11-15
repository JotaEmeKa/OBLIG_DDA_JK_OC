/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obligatorio.JKOC.ui;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.Agenda;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;

/**
 *
 * @author fadavanc
 */
public interface AgendaVista extends VistaBase {

    void mostrarTiposDeContacto(ArrayList<TipoContacto> tipos);

    void mostrarTiposDeTelefno(ArrayList<TipoTelefono> tipos);

    void mostrarContactos(ArrayList<Contacto> contactos);

    void mostrarDetalleContacto(Contacto contacto);
    
    void mostrarResumenDeInformacion(Agenda agenda);        

    public void mostrarDialogoNuevoGrupoDeContactos(Agenda agenda);
}
