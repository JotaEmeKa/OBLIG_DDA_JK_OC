/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.mesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ddauser
 */
public class ModoSimulador extends TipoEfecto {

    public ModoSimulador(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esValido(String numero) {
        return numero.trim().length() == 8 && esNumerico(numero);
    }

    @Override
    public int hacerSorteo(TipoEfecto te, Mesa mesa) {
        Random random = new Random();
        Ronda ultimaRonda = mesa.getRondas().get(mesa.getRondas().size() - 1);
        ArrayList<Apuesta> apuestas = ultimaRonda.getApuestas();

        List<Casillero> numerosAsortear = new ArrayList<>();

        for (Apuesta a : apuestas) {
            numerosAsortear.add(a.getCasillero());
        }

        int indiceAleatorio = random.nextInt(apuestas.size());

        Casillero casillero = apuestas.get(indiceAleatorio).getCasillero();

        return casillero.getUniversalCellCode();
    }

}
