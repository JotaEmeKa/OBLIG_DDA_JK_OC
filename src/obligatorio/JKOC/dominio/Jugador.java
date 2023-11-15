package obligatorio.JKOC.dominio;

public class Jugador extends Usuario {
    
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
