/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.dominio;

/**
 *
 * @author ddauser
 */
public class Usuario extends UsuarioGenerico {
    
    private Agenda agenda;
    
    public Agenda getAgenda() {
        return agenda;
    }
    
    public void setAgenda(Agenda agenda) {
        if (agenda != null) {
            this.agenda = agenda;
            agenda.setUsuario(this);
        }
        
    }
    
    public int getCantidadContactos() {
        return agenda.getCantidadContactos();
    }
}
