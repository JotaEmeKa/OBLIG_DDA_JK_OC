/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import iu.VistaBase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @param <Vista>
 * @param <Modelo>
 */
public abstract class VistaBaseControlador<Vista extends VistaBase, Modelo> {

    protected Vista vista;
    protected Modelo modelo;

    public VistaBaseControlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        inicializarVista();
    }

    protected void gestionarExcepcion(Exception ex, Level logLevel) {
        Logger.getLogger(this.getClass().getName()).log(logLevel, null, ex);
        vista.mostrarMensajeDeError(ex.getMessage());
    }

    protected abstract void inicializarVista();
}
