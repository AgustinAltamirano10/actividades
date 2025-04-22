

public class TicketMachineMain {

    public static void main(String[] args) {

        TicketMachine machine1 = new TicketMachine(10);
        TicketMachine machine2 = new TicketMachine(16);

        TicketMachine machine3 = new TicketMachine();

        machine1.showPrice();
        machine2.showPrice();
        machine3.showPrice();

        // Ejercicio 3.4
        TicketMachine machine4 = new TicketMachine();
        machine4.insertMoney(2200);
        machine4.printTicket();
        machine4.printTicket();
        machine4.showTotal(); // El total es 2000
        System.out.println("vacio la maquina");
        machine4.empty();
        machine4.showTotal(); // El total es cero

    }

}
