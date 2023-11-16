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
public class ModoParcial extends TipoEfecto {

    public ModoParcial(String nombre) {
        super(nombre);
    }

    @Override
    public boolean esValido(String numero) {
        return numero.trim().length() == 8 && esNumerico(numero);
    }

    @Override
    public int hacerSorteo(TipoEfecto te, Mesa mesa) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(37);
        List<Integer> ultimosNumeros = new ArrayList<>();
        
        for (int i = mesa.getRondas().size()-1; i > mesa.getRondas().size()-3; i--) {
            ultimosNumeros.add(mesa.getRondas().get(i).getNumeroSorteado());
        }

        for (int elemento : ultimosNumeros) {
            if (elemento == numeroSorteado) {
                numeroSorteado=random.nextInt(37);
            }
        }
        return numeroSorteado;
    }
}
