/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.mesa;

import java.util.ArrayList;

/**
 *
 * @author Octavio
 */
public class Ronda {

    private int id = 1;
    private ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
    private TipoEfecto tipoEfecto;
    private double liquidacion;
    private Casillero casillero;
    private int numeroSorteado;

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

//    public Ronda(TipoEfecto tipoEfecto) {
//        this.tipoEfecto = tipoEfecto;
//    }
    public Ronda() {
        this.id++;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public TipoEfecto getTipoEfecto() {
        return tipoEfecto;
    }

    public double getLiquidacion() {
        return liquidacion;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void setTipoEfecto(TipoEfecto tipoEfecto) {
        this.tipoEfecto = tipoEfecto;
    }

    public void setLiquidacion(double liquidacion) {
        this.liquidacion = liquidacion;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public void setApuesta() {

    }

    public Casillero hacerSorteo(TipoEfecto te, Mesa mesa) {
        this.tipoEfecto = te;
        int nroSorteado = this.tipoEfecto.hacerSorteo(te, mesa);
        casillero = mesa.buscar(nroSorteado);
        return casillero;
    }

}
