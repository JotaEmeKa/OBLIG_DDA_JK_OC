
package utilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private final List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador observador){
       if(!observadores.contains(observador)){
           observadores.add(observador);
       }   
    }
   
    public void quitar (Observador observador){
           observadores.remove(observador);
    }
    
    public void avisar(Object evento){
       List<Observador> observadoresTemporal = new ArrayList<>(observadores);
        for (Observador observadorTemporal : observadoresTemporal) {
            observadorTemporal.actualizar(this,evento);
        }
    }
    
    
}
