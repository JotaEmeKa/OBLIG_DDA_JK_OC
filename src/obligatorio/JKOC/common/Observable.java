package obligatorio.JKOC.common;

import java.util.ArrayList;

public abstract class Observable {
    
    private final ArrayList<Observador> observadores = new ArrayList<>();
    
    public void agregar(Observador observador) {
        this.observadores.add(observador);
    }
    
    public boolean remover(Observador observador) {
        return observadores.remove(observador);
    }
    
    protected void avisar(Object evento) {
        
        for(int i=0;i<observadores.size();i++){
            observadores.get(i).actualizar(this, evento);
        }
    }
   
}
