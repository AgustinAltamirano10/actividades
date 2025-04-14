import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;


public class Testphonebook {
    
    @Test
    public void testaddEntry()
    {
        PhoneBook agenda = new PhoneBook();
        agenda.addEntry("juan", "1234");
        agenda.addEntry("jorge", "4567");
        agenda.addEntry("pablo", "8901");

        Set agendaContactos = agenda.getAllContacts();

        assertTrue(agendaContactos.contains("Nombre: juanNumero Telefonico: 1234"));
        assertTrue(agendaContactos.contains("Nombre: jorgeNumero Telefonico: 4567"));
        assertTrue(agendaContactos.contains("Nombre: pabloNumero Telefonico: 8901"));
    }

    @Test
    public void testDelContact()
    {
        PhoneBook agenda = new PhoneBook();
        agenda.addEntry("juan", "1234");
        agenda.addEntry("jorge", "4567");
        agenda.addEntry("pablo", "8901");
        agenda.delContact("jorge");
        Set agendaContactos = agenda.getAllContacts();

        assertTrue(agendaContactos.contains("Nombre: juanNumero Telefonico: 1234"));
        assertTrue(agendaContactos.contains("Nombre: pabloNumero Telefonico: 8901"));
    }

    @Test
    public void testLookNumbre()
    {
        PhoneBook agenda = new PhoneBook();
        agenda.addEntry("juan", "1234");
        agenda.addEntry("jorge", "4567");
        agenda.addEntry("pablo", "8901");
        assertEquals("8901", agenda.lookupNumber("pablo"));
    }
}
