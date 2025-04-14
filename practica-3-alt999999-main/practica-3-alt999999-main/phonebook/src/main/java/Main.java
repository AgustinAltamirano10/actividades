public class Main {
    public static void main(String[] args) {
        PhoneBook agenda = new PhoneBook();

        agenda.addEntry("juan", "1234");
        agenda.addEntry("jorge", "5678");

        // 1.1 
        System.out.println("Cantidad de contactos: " + agenda.getAllContacts().size());
        System.out.println("###########################################");
        
        // 1.2 
        agenda.addEntry("juan", "1111"); // Se sobrescribe el valor
        System.out.println("Número nuevo: " + agenda.lookupNumber("juan"));
        System.out.println("###########################################");

        // 1.3
        agenda.addEntry("pablo", "5678");
        System.out.println("pablo y raul tienen el mismo numero:");
        System.out.println("raul: " + agenda.lookupNumber("raul"));
        System.out.println("pablo: " + agenda.lookupNumber("pablo"));
        System.out.println("###########################################");

        // 1.4
        System.out.println("¿Está raul? " + (agenda.lookupNumber("raul") != null));
        System.out.println("¿Está luis? " + (agenda.lookupNumber("luis") != null));
        System.out.println("###########################################");

        // 1.5 
        String numeroLuis = agenda.lookupNumber("luis");
        System.out.println("Número de luis: " + (numeroLuis == null ? "No encontrado" : numeroLuis));
        System.out.println("###########################################");

        // 1.6 
        System.out.println("Contactos de la agenda:");
        for (Object contacto : agenda.getAllContacts()) {
            System.out.println(contacto);
        }
    }
}
