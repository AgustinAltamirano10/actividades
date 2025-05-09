package pilainvertir;
public class Main {

    public static void main(String[] args) {
        Clase<Integer> a = new Clase<>(3);
        a.push(1);
        a.push(2);
        a.push(3);
        System.out.println("tamaño: " + a.size());
        System.out.println("arreglo: " + a.toString());

        a.pop();
        System.out.println("\n arreglo: " + a.toString());

        System.out.println("\n tope:" + a.top());

        Clase<Integer> array = new Clase<>();
        try {
            array.pop();
        } catch (Exception e) {
            System.out.println(e);
        }

        for (Integer aux : a) {
            System.out.println(aux);
        }

        Clase<Integer> a3 = new Clase<>(3);
        a3.push(1);
        a3.push(2);
        a3.push(3);
        System.out.println("original: " + a3.toString());
        a3.invertirPila();
        System.out.println("invertida: " + a3.toString());
    }
}