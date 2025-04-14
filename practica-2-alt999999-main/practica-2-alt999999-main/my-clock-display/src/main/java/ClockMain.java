public class ClockMain {

    public static void main(String[] args) {
        ClockDisplay12 reloj12A = new ClockDisplay12(00, 12);
        ClockDisplay12 reloj12B = new ClockDisplay12(12, 00);
        ClockDisplay12 reloj12C = new ClockDisplay12(05, 45);
        ClockDisplay12 reloj12D = new ClockDisplay12(24, 00);
        ClockDisplay12 reloj12E = new ClockDisplay12(18, 56);

        System.out.println("Hora: " + reloj12A.getTime());
        System.out.println("Hora: " + reloj12B.getTime());
        System.out.println("Hora: " + reloj12C.getTime());
        System.out.println("Hora: " + reloj12D.getTime());
        System.out.println("Hora: " + reloj12E.getTime());        
    }
}
