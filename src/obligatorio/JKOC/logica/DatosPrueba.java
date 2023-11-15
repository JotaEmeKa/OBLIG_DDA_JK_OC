/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio.JKOC.logica;

import obligatorio.JKOC.dominio.Administrador;
import obligatorio.JKOC.dominio.Agenda;
import obligatorio.JKOC.dominio.Contacto;
import obligatorio.JKOC.dominio.Telefono;
import obligatorio.JKOC.dominio.TelefonoCelular;
import obligatorio.JKOC.dominio.TelefonoFijo;
import obligatorio.JKOC.dominio.TelefonoInternacional;
import obligatorio.JKOC.dominio.TipoContacto;
import obligatorio.JKOC.dominio.TipoTelefono;
import obligatorio.JKOC.dominio.Usuario;
import obligatorio.JKOC.exceptions.ContactoInvalidoException;
import obligatorio.JKOC.exceptions.TelefonoInvalidoException;

/**
 *
 * @author ddauser
 */
public class DatosPrueba {
    
    public static void iniciar() throws ContactoInvalidoException, TelefonoInvalidoException {
        TipoContacto t1 = new TipoContacto("Personal");
        TipoContacto t2 = new TipoContacto("Familiar");
        TipoContacto t3 = new TipoContacto("Laboral");
        FachadaServicios.getInstance().agregar(t1);
        FachadaServicios.getInstance().agregar(t2);
        FachadaServicios.getInstance().agregar(t3);
        
        TipoTelefono fijo = new TelefonoFijo("Fijo");
        TipoTelefono fax = new TelefonoFijo("Fax");
        TipoTelefono celular = new TelefonoCelular("Celular");
        TipoTelefono internacional = new TelefonoInternacional("Internacional");
        FachadaServicios.getInstance().agregar(fijo);
        FachadaServicios.getInstance().agregar(fax);
        FachadaServicios.getInstance().agregar(celular);
        FachadaServicios.getInstance().agregar(internacional);
        
        // Maria
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
        
        Usuario maria = new Usuario();
        maria.setNombre("Maria");
        maria.setUsuario("maria");
        maria.setPassword("123");
        
        maria.setAgenda(agendaMaria);
         
        // Daniel
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
        
        Usuario daniel = new Usuario();
        daniel.setNombre("Daniel");
        daniel.setUsuario("daniel");
        daniel.setPassword("321");
        
        daniel.setAgenda(agendaDaniel);
        
        FachadaServicios.getInstance().agregar(maria);
        FachadaServicios.getInstance().agregar(daniel);
        
        Administrador admin = new Administrador();
        admin.setNombre("Administrador Principal");
        admin.setUsuario("admin");
        admin.setPassword("admin");
        
        FachadaServicios.getInstance().agregar(admin);
    }
}
