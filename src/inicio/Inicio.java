
package inicio;

import iu.Principal;


public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        DatosPrueba.cargar();
        principal.setVisible(true);
    }
    
}
