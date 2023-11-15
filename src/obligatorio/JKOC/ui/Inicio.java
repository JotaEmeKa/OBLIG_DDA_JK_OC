/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.ui;

import obligatorio.JKOC.dominio.Telefono;
import obligatorio.JKOC.dominio.TelefonoCelular;
import obligatorio.JKOC.dominio.TelefonoFijo;
import obligatorio.JKOC.dominio.TelefonoInternacional;
import obligatorio.JKOC.exceptions.AgendaException;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;
import obligatorio.JKOC.logica.DatosPrueba;

/**
 *
 * @author ddauser
 */
public class Inicio {

    public static void main(String args[]) throws ContactoInvalidoException, TelefonoInvalidoException {

        //testearTiposTelefono();
        DatosPrueba.iniciar();
        new VentanaInicio().setVisible(true);
    }

    private static void testearTiposTelefono() throws TelefonoInvalidoException {

        Telefono t1;

        t1 = new Telefono("12345678", new TelefonoFijo("Fijo"));
        validar(t1, true);
        t1 = new Telefono("123456789", new TelefonoFijo("Fijo"));
        validar(t1, false);
        t1 = new Telefono("1234567", new TelefonoFijo("Fijo"));
        validar(t1, false);
        t1 = new Telefono("123x5678", new TelefonoFijo("Fijo"));
        validar(t1, false);
        t1 = new Telefono("1234 678", new TelefonoFijo("Fijo"));
        validar(t1, false);

        t1 = new Telefono("093456789", new TelefonoCelular("Celular"));
        validar(t1, true);
        t1 = new Telefono("083456789", new TelefonoCelular("Celular"));
        validar(t1, false);
        t1 = new Telefono("0934567890", new TelefonoCelular("Celular"));
        validar(t1, false);
        t1 = new Telefono("09345678", new TelefonoCelular("Celular"));
        validar(t1, false);
        t1 = new Telefono("0934x6789", new TelefonoCelular("Celular"));
        validar(t1, false);

        t1 = new Telefono("001234567890", new TelefonoInternacional("Internacional"));
        validar(t1, true);
        t1 = new Telefono("+1234567890", new TelefonoInternacional("Internacional"));
        validar(t1, true);
        t1 = new Telefono("00123456789", new TelefonoInternacional("Internacional"));
        validar(t1, false);
        t1 = new Telefono("001234x567890", new TelefonoInternacional("Internacional"));
        validar(t1, false);
        t1 = new Telefono("00123456789012345678901", new TelefonoInternacional("Internacional"));
        validar(t1, false);

    }

    private static void validar(Telefono t1, boolean valido) throws TelefonoInvalidoException {
        t1.esValido();
        System.out.println(t1.getNumero() + " " + valido + " true");
    }
}
