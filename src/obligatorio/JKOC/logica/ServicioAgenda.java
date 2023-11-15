/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.logica;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;

/**
 *
 * @author ddauser
 */
public class ServicioAgenda {

    private ArrayList<TipoContacto> tiposContacto;
    private ArrayList<TipoTelefono> tiposTelefono;

    public ServicioAgenda() {
        tiposContacto = new ArrayList();
        tiposTelefono = new ArrayList();
    }
    
    public void agregar(TipoContacto tipoContacto) {
        tiposContacto.add(tipoContacto);
    }

    public void agregar(TipoTelefono tipoTelefono) {
        tiposTelefono.add(tipoTelefono);
    }

    public ArrayList<TipoContacto> getTiposContacto() {
        return tiposContacto;
    }
    
    public ArrayList<TipoTelefono> getTiposTelefono() {
        return tiposTelefono;
    }
}
