import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    private HashMap<String, String> mapa;

    /**
     * Constuctor de phone book
     */
    public PhoneBook() {
        mapa = new HashMap<>();
    }
    
    /**
     * @post agrega un contacto
     */
    public void addEntry(String name, String numPhone)
    {
        mapa.put(name, numPhone);
    }

    /*
     * @post modifica el numero de telefono
     */
    public void changePhone(String name, String numPhone)
    {
        if (mapa.containsKey(name)) {
            mapa.put(name, numPhone);
        } else {
            System.out.println("El contacto no existe");
        }
    }
    
    /**
     * @post borra un contacto de la agenda
     */
    public void delContact(String name)
    {
        if (mapa.containsKey(name)) {
            mapa.remove(name);
        } else {
            System.out.println("El contacto no existe");
        }
    }

    /*
     * @post Retorna un set con todos los contactos de la agenda
     */
    public Set getAllContacts()
    {
        Set<String> agendaContactos = new HashSet<>();
        for (String clave : mapa.keySet()) {
            String valor = mapa.get(clave);
            agendaContactos.add("Nombre: " + clave + "Numero Telefonico: " + valor);
        }
        return agendaContactos;
    }
    
    /**
     * @post retorna el numero de telefono asociado a un nombre
     */
    public String lookupNumber(String name)
    {
        if (mapa.containsKey(name)) {
            String numeroBuscado = mapa.get(name);
            return numeroBuscado;
        }
        return null;
    }

}