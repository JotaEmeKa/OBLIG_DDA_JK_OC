package obligatorio.JKOC.controllers;

import java.util.List;
import java.util.logging.Level;
import obligatorio.JKOC.dominio.Agenda;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.Grupo;
import obligatorio.JKOC.exceptions.AgendaException;
import obligatorio.JKOC.ui.NuevoGrupoDeContactosVista;

public class NuevoGrupoDeContactosVistaControlador extends VistaBaseControlador<NuevoGrupoDeContactosVista, Agenda> {

    public NuevoGrupoDeContactosVistaControlador(Agenda modelo, NuevoGrupoDeContactosVista vista) {
        super(vista, modelo);
    }

    public void crearGrupo(String nombreDelGrupo, List<Contacto> contactos) {
        Grupo grupo = new Grupo(nombreDelGrupo);
        contactos.forEach(c -> {
            try {
                grupo.agregar(c);
            } catch (AgendaException ex) {
                gestionarExcepcion(ex, Level.SEVERE);
                return;
            }
        });

        try {
            modelo.agregar(grupo);
            inicializarVista();
        } catch (AgendaException ex) {
            gestionarExcepcion(ex, Level.SEVERE);
        }
    }

    @Override
    protected void inicializarVista() {
        vista.mostrarContactos(modelo.getContactos());
        vista.mostrarGrupos(modelo.getGrupos());
    }

}
