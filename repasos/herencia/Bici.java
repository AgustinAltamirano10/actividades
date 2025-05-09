public class Bici implements Vehiculo {

    @Override
    public void arrancar() {
        System.out.println("arranco la bici");
    }

    @Override
    public void frenar() {
        System.out.println("freno la bici");
    }
    
}
