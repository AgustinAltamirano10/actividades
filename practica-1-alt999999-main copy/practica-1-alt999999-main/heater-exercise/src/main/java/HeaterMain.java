/**
 * 
 * clase main de Heater
*/

public class HeaterMain {

    public static void main(String[] args) {
        Heater var = new Heater(7 , 22);
        var.setIncrement(5);
        var.warmer(); // Temperatura queda en 20
        var.showTemperatura();
        var.warmer(); // No se puede
        
        var.cooler();
        var.showTemperatura();
        var.cooler();
        var.showTemperatura();
        var.cooler();

    }
}