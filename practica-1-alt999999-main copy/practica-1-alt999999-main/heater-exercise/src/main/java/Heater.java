

public class Heater {

    private double temperature;
    private double min;
    private double max;
    private double increment;
    
    /*
     * @post constructor 
     */
    public Heater(double min, double max) 
    {
        temperature = 15.0;
        this.min = min;
        this.max = max;
        increment = 5.0;
    }

    /**
     * @post incrementa la temperatura en 5.0 grados
     */
    public void warmer()
    {
        if (max - temperature >= increment) {
            temperature += increment;
        } else {
            System.out.println("No se puede incrementar maximo alcanzado");
        }
        
    }

    /**
     * @post decrementa la temperatura en 5.0 grados
     */
    public void cooler()
    {
        if (temperature - min >= increment) {
            temperature -= increment;
        } else {
            System.out.println("No se puede decrementar minimo alcanzado");
        }
    }

    /**
     * @post muestra la temperatura
     */
    public void showTemperatura()
    {
        System.out.println("Temperatura: " + temperature);
    }

    /*
     * @post dice de cuanto es el incremento
     */
    public void setIncrement(double increment)
    {
        this.increment = increment;
    }
}