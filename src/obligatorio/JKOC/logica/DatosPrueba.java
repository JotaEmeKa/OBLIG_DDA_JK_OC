package obligatorio.JKOC.logica;

import obligatorio.JKOC.dominio.Crupier;
import obligatorio.JKOC.dominio.Agenda;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.Telefono;
import obligatorio.JKOC.dominio.TelefonoCelular;
import obligatorio.JKOC.dominio.TelefonoFijo;
import obligatorio.JKOC.dominio.TelefonoInternacional;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;
import obligatorio.JKOC.dominio.Jugador;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;

public class DatosPrueba {
    
    public static void iniciar() throws ContactoInvalidoException, TelefonoInvalidoException {
        TipoContacto t1 = new TipoContacto("Personal");
        TipoContacto t2 = new TipoContacto("Familiar");
        TipoContacto t3 = new TipoContacto("Laboral");
        //Sistema.getInstance().agregar(t1);
        //Sistema.getInstance().agregar(t2);
        //Sistema.getInstance().agregar(t3);
        
        TipoTelefono fijo = new TelefonoFijo("Fijo");
        TipoTelefono fax = new TelefonoFijo("Fax");
        TipoTelefono celular = new TelefonoCelular("Celular");
        TipoTelefono internacional = new TelefonoInternacional("Internacional");
        //Sistema.getInstance().agregar(fijo);
        //Sistema.getInstance().agregar(fax);
        //Sistema.getInstance().agregar(celular);
        //Sistema.getInstance().agregar(internacional);
        
        // Ermenegildo
        Contacto c1 = new Contacto();
        c1.setNombre("Andres");
        c1.setTelefono(new Telefono("12345678", fijo));
        c1.setTipoContacto(t1);
        
        Contacto c2 = new Contacto();
        c2.setNombre("Pedro");
        c2.setTelefono(new Telefono("+4322423345345", internacional));
        c2.setTipoContacto(t3);
        
        Agenda agendaMaria = new Agenda();
        agendaMaria.agregar(c1);
        agendaMaria.agregar(c2);
        
        Jugador ermenegildo = new Jugador();
        ermenegildo.setNombre("Jugador Ermenegildo");
        ermenegildo.setIdUsuario("ermenegildo");
        ermenegildo.setPassword("123");
        
        ermenegildo.setAgenda(agendaMaria);
         
        // Atalibar
        Contacto c3 = new Contacto();
        c3.setNombre("Vanesa");
        c3.setTelefono(new Telefono("093456789", celular));
        c3.setTipoContacto(t3);
        
        Contacto c4 = new Contacto();
        c4.setNombre("Norma");
        c4.setTelefono(new Telefono("43284433", fijo));
        c4.setTipoContacto(t2);
        
        Agenda agendaDaniel = new Agenda();
        agendaDaniel.agregar(c3);
        agendaDaniel.agregar(c4);
        
        Jugador atalibar = new Jugador();
        atalibar.setNombre("Jugador Atalibar");
        atalibar.setIdUsuario("atalibar");
        atalibar.setPassword("123");
        
        atalibar.setAgenda(agendaDaniel);
        
        Sistema.getInstance().agregar(ermenegildo);
        Sistema.getInstance().agregar(atalibar);
        
        Crupier carlos = new Crupier();
        carlos.setNombre("Crupier Carlos");
        carlos.setIdUsuario("carlos");
        carlos.setPassword("123");
        
        Sistema.getInstance().agregar(carlos);
    }
}
