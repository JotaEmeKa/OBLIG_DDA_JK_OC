package obligatorio.JKOC.logica;

import java.util.ArrayList;
import obligatorio.JKOC.dominio.Jugador;
import obligatorio.JKOC.dominio.Mesa;
import obligatorio.JKOC.dominio.TipoApuesta;
import obligatorio.JKOC.dominio.TipoEfecto;

public class ControlMesa {

    private ArrayList<Mesa> mesas;
    private ArrayList<TipoApuesta> tipoApuestas;
    private ArrayList<TipoEfecto> tipoEfectos;
    
    private int limiteJugadores;
    private double montoBase;


    public ControlMesa() {
        mesas = new ArrayList<>();
        tipoApuestas = new ArrayList<>();
        tipoEfectos = new ArrayList<>();
    }
    

    
    public void agregar(Mesa mesa) {
        mesas.add(mesa);
    }

    public void agregar(TipoApuesta tipoApuesta) {
        tipoApuestas.add(tipoApuesta);
    }
    
    public void agregar(TipoEfecto tipoEfecto) {
        tipoEfectos.add(tipoEfecto);
    }

    /**
     * @return the mesas
     */
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    /**
     * @param mesas the mesas to set
     */
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    /**
     * @return the tipoApuestas
     */
    public ArrayList<TipoApuesta> getTipoApuestas() {
        return tipoApuestas;
    }

    /**
     * @param tipoApuestas the tipoApuestas to set
     */
    public void setTipoApuestas(ArrayList<TipoApuesta> tipoApuestas) {
        this.tipoApuestas = tipoApuestas;
    }

    /**
     * @return the tipoEfectos
     */
    public ArrayList<TipoEfecto> getTipoEfectos() {
        return tipoEfectos;
    }

    /**
     * @param tipoEfectos the tipoEfectos to set
     */
    public void setTipoEfectos(ArrayList<TipoEfecto> tipoEfectos) {
        this.tipoEfectos = tipoEfectos;
    }

    /**
     * @return the limiteJugadores
     */
    public int getLimiteJugadores() {
        return limiteJugadores;
    }

    /**
     * @param limiteJugadores the limiteJugadores to set
     */
    public void setLimiteJugadores(int limiteJugadores) {
        this.limiteJugadores = limiteJugadores;
    }

    /**
     * @return the montoBase
     */
    public double getMontoBase() {
        return montoBase;
    }

    /**
     * @param montoBase the montoBase to set
     */
    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    
}
