public class Main {
    public static void main(String[] args) {
        // Crear objetos de las clases
        Bici bici = new Bici();
        Vehiculo auto = new Auto();
        Auto mercedes = new Mercedes();
        Vehiculo bmw = new Bmw();

        // Probar los métodos con diferentes vehículos
        System.out.println("Prueba con la bici:");
        bici.arrancar();
        bici.frenar();
        
        System.out.println("\nPrueba con el auto:");
        auto.arrancar();
        auto.frenar();
        
        System.out.println("\nPrueba con el Mercedes:");
        mercedes.arrancar();
        mercedes.frenar();
        
        System.out.println("\nPrueba con el BMW:");
        bmw.arrancar();
        bmw.frenar();
    }
}
